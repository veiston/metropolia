import java.sql.Connection;
import java.text.MessageFormat;
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
    private boolean isUpdatingLanguage = false;

    @FXML
    public void initialize() {
        initDatabase();
        historyView.setItems(historyList);
        loadUnits();
        refreshHistory();
        populateLanguages();
    }

    public void setResources(ResourceBundle bundle, Locale currentLocale) {
        this.messages = bundle;
        syncLanguageSelection(currentLocale);
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
            double outputVal = calculator.convert(inputVal, source.getName(), target.getName());
            double rounded = Math.round(outputVal * 100.0) / 100.0;

            String resultText = MessageFormat.format(
                    messages.getString("converter.result"),
                    inputVal, source.getSymbol(), rounded, target.getSymbol());

            double inCelsius = convertToCelsius(inputVal, source.getName());
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

    private double convertToCelsius(double value, String unitName) {
        if (unitName.equalsIgnoreCase("Fahrenheit")) {
            return tempConverter.fahrenheitToCelsius(value);
        }
        if (unitName.equalsIgnoreCase("Kelvin")) {
            return tempConverter.kelvinToCelsius(value);
        }
        return value;
    }

    private void saveRecord(double inputVal, int sourceId, double outputVal, int targetId) {
        if (recordDAO != null) {
            try {
                TempRecord record = new TempRecord(inputVal, sourceId, outputVal, targetId);
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

    private void loadUnits() {
        if (unitDAO == null) {
            return;
        }
        try {
            List<TemperatureUnit> units = unitDAO.findAll();
            sourceCombo.getItems().setAll(units);
            targetCombo.getItems().setAll(units);

            if (!units.isEmpty()) {
                sourceCombo.setValue(units.get(0));
            }
            if (units.size() > 1) {
                targetCombo.setValue(units.get(1));
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
}
