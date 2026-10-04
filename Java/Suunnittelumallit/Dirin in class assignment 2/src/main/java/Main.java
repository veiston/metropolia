import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.List;

public class Main extends Application {
    private final TempCalculator calculator = new TempCalculator();
    private final ObservableList<String> historyList = FXCollections.observableArrayList();
    private TemperatureUnitDAO unitDAO;
    private TempRecordDAO recordDAO;

    @Override
    public void start(Stage primaryStage) {
        initDatabase();

        Label titleLabel = new Label("Temperature Converter");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter temperature value");

        ComboBox<TemperatureUnit> sourceCombo = new ComboBox<>();
        ComboBox<TemperatureUnit> targetCombo = new ComboBox<>();
        loadUnits(sourceCombo, targetCombo);

        Button convertButton = new Button("Convert & Save");
        Label resultLabel = new Label("Result: -");
        resultLabel.setStyle("-fx-font-size: 14px;");

        ListView<String> historyView = new ListView<>(historyList);
        historyView.setPrefHeight(160);
        refreshHistory();

        convertButton.setOnAction(event -> {
            handleConversion(inputField, sourceCombo, targetCombo, resultLabel);
        });

        HBox unitsBox = new HBox(10, new Label("From:"), sourceCombo, new Label("To:"), targetCombo);
        unitsBox.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(12,
                titleLabel,
                new Label("Temperature Value:"),
                inputField,
                unitsBox,
                convertButton,
                resultLabel,
                new Label("Database History:"),
                historyView
        );
        root.setPadding(new Insets(16));
        root.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(root, 440, 450);
        primaryStage.setTitle("Temperature Converter JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleConversion(TextField inputField,
                                  ComboBox<TemperatureUnit> sourceCombo,
                                  ComboBox<TemperatureUnit> targetCombo,
                                  Label resultLabel) {
        String text = inputField.getText().trim();
        TemperatureUnit source = sourceCombo.getValue();
        TemperatureUnit target = targetCombo.getValue();

        if (text.isEmpty() || source == null || target == null) {
            resultLabel.setText("Please fill all fields.");
            return;
        }

        try {
            double inputVal = Double.parseDouble(text);
            double outputVal = calculator.convert(inputVal, source.getName(), target.getName());
            double rounded = Math.round(outputVal * 100.0) / 100.0;

            resultLabel.setText("Result: " + rounded + " " + target.getSymbol());

            if (recordDAO != null) {
                TempRecord record = new TempRecord(inputVal, source.getId(), rounded, target.getId());
                recordDAO.save(record);
                refreshHistory();
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid number format. Enter digits.");
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
