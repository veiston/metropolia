import java.sql.Connection;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private final TempCalculator calculator = new TempCalculator();
    private final TemperatureConverter tempConverter = new TemperatureConverter();
    private final ObservableList<String> historyList = FXCollections.observableArrayList();
    private TemperatureUnitDAO unitDAO;
    private TempRecordDAO recordDAO;
    private ResourceBundle messages;

    // Supported languages mapped
    private static final Map<String, Locale> SUPPORTED_LANGUAGES = new LinkedHashMap<>();
    static {
        SUPPORTED_LANGUAGES.put("English", Locale.of("en", "US"));
        SUPPORTED_LANGUAGES.put("Finnish", Locale.of("fi", "FI"));
        SUPPORTED_LANGUAGES.put("Swedish", Locale.of("sv", "SE"));
        SUPPORTED_LANGUAGES.put("Japanese", Locale.of("ja", "JP"));
    }

    @Override
    public void start(Stage primaryStage) {
        initDatabase();

        /* i18n language localization */
        Locale selectedLocale = promptLanguageSelection();
        messages = ResourceBundle.getBundle("MessagesBundle", selectedLocale);

        Label titleLabel = new Label(messages.getString("converter.title"));
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField inputField = new TextField();
        inputField.setPromptText(messages.getString("converter.prompt"));

        ComboBox<TemperatureUnit> sourceCombo = new ComboBox<>();
        ComboBox<TemperatureUnit> targetCombo = new ComboBox<>();
        loadUnits(sourceCombo, targetCombo);

        Button convertButton = new Button(messages.getString("converter.button"));
        Label resultLabel = new Label(messages.getString("converter.result.placeholder"));
        resultLabel.setStyle("-fx-font-size: 14px;");

        ListView<String> historyView = new ListView<>(historyList);
        historyView.setPrefHeight(160);
        refreshHistory();

        convertButton.setOnAction(event -> {
            handleConversion(inputField, sourceCombo, targetCombo, resultLabel);
        });

        HBox unitsBox = new HBox(10,
                new Label(messages.getString("converter.from")), sourceCombo,
                new Label(messages.getString("converter.to")), targetCombo);
        unitsBox.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(12,
                titleLabel,
                new Label(messages.getString("converter.prompt")),
                inputField,
                unitsBox,
                convertButton,
                resultLabel,
                new Label(messages.getString("converter.history")),
                historyView);
        root.setPadding(new Insets(16));
        root.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(root, 440, 450);
        primaryStage.setTitle(messages.getString("converter.title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Locale promptLanguageSelection() {
        List<String> languages = List.copyOf(SUPPORTED_LANGUAGES.keySet());
        String defaultLanguage = languages.get(0);

        ChoiceDialog<String> dialog = new ChoiceDialog<>(defaultLanguage, languages);
        dialog.setTitle("Language / Kieli / Språk / 言語");
        dialog.setHeaderText("Select your language:");
        dialog.setContentText("Language:");

        // Returns the chosen language, or default if cancelled
        String chosen = dialog.showAndWait().orElse(defaultLanguage);
        Locale locale = SUPPORTED_LANGUAGES.get(chosen);

        System.out.println("Language selected: " + chosen);
        return locale;
    }

    private void handleConversion(TextField inputField,
            ComboBox<TemperatureUnit> sourceCombo,
            ComboBox<TemperatureUnit> targetCombo,
            Label resultLabel) {
        String text = inputField.getText().trim();
        TemperatureUnit source = sourceCombo.getValue();
        TemperatureUnit target = targetCombo.getValue();

        if (text.isEmpty() || source == null || target == null) {
            resultLabel.setText(messages.getString("converter.error.empty"));
            return;
        }

        try {
            double inputVal = Double.parseDouble(text);
            double outputVal = calculator.convert(inputVal, source.getName(), target.getName());
            double rounded = Math.round(outputVal * 100.0) / 100.0;

            String resultText = MessageFormat.format(
                    messages.getString("converter.result"),
                    inputVal, source.getSymbol(), rounded, target.getSymbol());

            // Check for extreme temperature in Celsius
            double inCelsius = inputVal;
            if (source.getName().equalsIgnoreCase("Fahrenheit")) {
                inCelsius = tempConverter.fahrenheitToCelsius(inputVal);
            } else if (source.getName().equalsIgnoreCase("Kelvin")) {
                inCelsius = tempConverter.kelvinToCelsius(inputVal);
            }

            if (tempConverter.isExtremeTemperature(inCelsius)) {
                resultText = resultText + "\n" + messages.getString("converter.extreme");
            }

            resultLabel.setText(resultText);

            if (recordDAO != null) {
                TempRecord record = new TempRecord(inputVal, source.getId(), rounded, target.getId());
                recordDAO.save(record);
                refreshHistory();
            }
        } catch (NumberFormatException e) {
            resultLabel.setText(messages.getString("converter.error.invalid"));
        } catch (Exception e) {
            resultLabel.setText("Error saving: " + e.getMessage());
        }
    }

    private void initDatabase() {
        try {
            Connection connection = DBConnection.getConnection();
            unitDAO = new TemperatureUnitDAO(connection);
            recordDAO = new TempRecordDAO(connection);
        } catch (Exception e) {
            System.err.println("Could not initialize database: " + e.getMessage());
        }
    }

    private void loadUnits(ComboBox<TemperatureUnit> source, ComboBox<TemperatureUnit> target) {
        if (unitDAO == null) {
            return;
        }
        try {
            List<TemperatureUnit> units = unitDAO.findAll();
            source.getItems().addAll(units);
            target.getItems().addAll(units);

            if (!units.isEmpty()) {
                source.setValue(units.get(0));
            }
            if (units.size() > 1) {
                target.setValue(units.get(1));
            }
        } catch (Exception e) {
            System.err.println("Could not load units: " + e.getMessage());
        }
    }

    private void refreshHistory() {
        if (recordDAO == null) {
            return;
        }
        try {
            historyList.clear();
            List<TempRecord> records = recordDAO.findAll();
            for (TempRecord record : records) {
                String line = record.getInputValue() + " -> " + record.getOutputValue();
                historyList.add(line);
            }
        } catch (Exception e) {
            System.err.println("Could not refresh history: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
