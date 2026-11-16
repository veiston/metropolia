import java.sql.Connection;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ComboBox<String> languageCombo;

    @FXML
    private TextField inputField;

    @FXML
    private ComboBox<TemperatureUnit> sourceCombo;

    @FXML
    private ComboBox<TemperatureUnit> targetCombo;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Button convertButton;

    @FXML
    private Label resultLabel;

    @FXML
    private ListView<String> historyView;

    private final TempCalculator calculator = new TempCalculator();
    private final TemperatureConverter tempConverter = new TemperatureConverter();
    private final ObservableList<String> historyList = FXCollections.observableArrayList();

    private TemperatureUnitDAO unitDAO;
    private TempRecordDAO recordDAO;
    private ResourceBundle messages;
    private Locale currentLocale = Locale.of("en", "US");
    private boolean isUpdatingLanguage = false;

    @FXML
    public void initialize() {
        initDatabase();
        historyView.setItems(historyList);
        sourceCombo.setOnAction(e -> updateDescription());
        populateLanguages();
    }

    public void setResources(ResourceBundle bundle, Locale currentLocale) {
        this.messages = bundle;
        this.currentLocale = currentLocale;
        syncLanguageSelection(currentLocale);
        loadUnits(currentLocale.getLanguage());
        refreshHistory();
    }

    @FXML
    private void handleLanguageChange() {
        if (isUpdatingLanguage) {
            return;
        }

        String selectedName = languageCombo.getValue();
        Map<String, Locale> supported = Main.getSupportedLanguages();
        Locale selectedLocale = supported.get(selectedName);

        if (selectedLocale != null) {
            Main.switchLanguage(selectedLocale);
        }
    }

    @FXML
    private void handleConversion() {
        String text = inputField.getText().trim();
        TemperatureUnit source = sourceCombo.getValue();
        TemperatureUnit target = targetCombo.getValue();

        if (text.isEmpty() || source == null || target == null) {
            resultLabel.setText(messages.getString("converter.error.empty"));
            return;
        }

        try {
            double inputVal = Double.parseDouble(text);
            double outputVal = calculator.convert(inputVal, source.getSymbol(), target.getSymbol());
            double rounded = Math.round(outputVal * 100.0) / 100.0;

            String resultText = MessageFormat.format(
                    messages.getString("converter.result"),
                    inputVal, source.getName(), rounded, target.getName());

            double inCelsius = convertToCelsius(inputVal, source);
            if (tempConverter.isExtremeTemperature(inCelsius)) {
                resultText = resultText + "\n" + messages.getString("converter.extreme");
            }

            resultLabel.setText(resultText);
            saveRecord(inputVal, source.getId(), rounded, target.getId());
        } catch (NumberFormatException e) {
            resultLabel.setText(messages.getString("converter.error.invalid"));
        } catch (Exception e) {
            resultLabel.setText("Error saving: " + e.getMessage());
        }
    }

    private double convertToCelsius(double value, TemperatureUnit unit) {
        if (unit.getSymbol().equalsIgnoreCase("F") || unit.getName().equalsIgnoreCase("Fahrenheit")) {
            return tempConverter.fahrenheitToCelsius(value);
        }
        if (unit.getSymbol().equalsIgnoreCase("K") || unit.getName().equalsIgnoreCase("Kelvin")) {
            return tempConverter.kelvinToCelsius(value);
        }
        return value;
    }

    private void saveRecord(double inputVal, int sourceId, double outputVal, int targetId) {
        if (recordDAO != null) {
            try {
                String lang = "en";
                if (currentLocale != null) {
                    lang = currentLocale.getLanguage();
                }
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                TempRecord record = new TempRecord(inputVal, sourceId, outputVal, targetId, lang, timestamp);
                recordDAO.save(record);
                refreshHistory();
            } catch (Exception e) {
                System.err.println("Could not save record: " + e.getMessage());
            }
        }
    }

    private void populateLanguages() {
        isUpdatingLanguage = true;
        languageCombo.getItems().clear();
        languageCombo.getItems().addAll(Main.getSupportedLanguages().keySet());
        isUpdatingLanguage = false;
    }

    private void syncLanguageSelection(Locale locale) {
        isUpdatingLanguage = true;
        for (Map.Entry<String, Locale> entry : Main.getSupportedLanguages().entrySet()) {
            if (entry.getValue().getLanguage().equals(locale.getLanguage())) {
                languageCombo.setValue(entry.getKey());
                break;
            }
        }
        isUpdatingLanguage = false;
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

    private void loadUnits(String lang) {
        if (unitDAO == null) {
            return;
        }
        try {
            List<TemperatureUnit> units = unitDAO.findAll(lang);
            sourceCombo.getItems().setAll(units);
            targetCombo.getItems().setAll(units);

            if (!units.isEmpty()) {
                sourceCombo.setValue(units.get(0));
            }
            if (units.size() > 1) {
                targetCombo.setValue(units.get(1));
            }
            updateDescription();
        } catch (Exception e) {
            System.err.println("Could not load units: " + e.getMessage());
        }
    }

    private void updateDescription() {
        if (descriptionLabel == null) {
            return;
        }
        TemperatureUnit selected = sourceCombo.getValue();
        if (selected != null && selected.getDescription() != null && !selected.getDescription().isEmpty()) {
            descriptionLabel.setText(selected.getDescription());
        } else {
            descriptionLabel.setText("");
        }
    }

    private void refreshHistory() {
        if (recordDAO == null) {
            return;
        }
        try {
            historyList.clear();
            List<TempRecord> records = recordDAO.findRecent(5);
            for (TempRecord record : records) {
                String fromName = getUnitName(record.getSourceUnitId());
                String toName = getUnitName(record.getTargetUnitId());
                String line = record.getInputValue() + " " + fromName + " -> " + record.getOutputValue() + " " + toName
                        + " [" + record.getLanguage() + "] (" + record.getTimestamp() + ")";
                historyList.add(line);
            }
        } catch (Exception e) {
            System.err.println("Could not refresh history: " + e.getMessage());
        }
    }

    private String getUnitName(int unitId) {
        if (sourceCombo != null) {
            for (TemperatureUnit unit : sourceCombo.getItems()) {
                if (unit.getId() == unitId) {
                    return unit.getName();
                }
            }
        }
        return "#" + unitId;
    }
}
