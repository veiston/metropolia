import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;
    private static final Map<String, Locale> SUPPORTED_LANGUAGES = new LinkedHashMap<>();

    static {
        SUPPORTED_LANGUAGES.put("English", Locale.of("en", "US"));
        SUPPORTED_LANGUAGES.put("Finnish", Locale.of("fi", "FI"));
        SUPPORTED_LANGUAGES.put("Swedish", Locale.of("sv", "SE"));
        SUPPORTED_LANGUAGES.put("Japanese", Locale.of("ja", "JP"));
        SUPPORTED_LANGUAGES.put("Arabic", Locale.of("ar", "SA"));
    }

    public static Map<String, Locale> getSupportedLanguages() {
        return Collections.unmodifiableMap(SUPPORTED_LANGUAGES);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Locale defaultLocale = SUPPORTED_LANGUAGES.get("English");

        Parent root = loadFxml(defaultLocale);
        Scene scene = new Scene(root, 440, 480);

        primaryStage.setScene(scene);
        primaryStage.setTitle(ResourceBundle.getBundle("MessagesBundle", defaultLocale).getString("converter.title"));
        primaryStage.show();
    }

    public static void switchLanguage(Locale locale) {
        try {
            Parent root = loadFxml(locale);
            ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);

            if (locale.getLanguage().equals("ar")) {
                root.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            } else {
                root.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            }

            primaryStage.setTitle(bundle.getString("converter.title"));
            primaryStage.getScene().setRoot(root);
        } catch (IOException e) {
            System.err.println("Could not switch language: " + e.getMessage());
        }
    }

    private static Parent loadFxml(Locale locale) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main.fxml"), bundle);
        Parent root = loader.load();

        MainController controller = loader.getController();
        controller.setResources(bundle, locale);

        if (locale.getLanguage().equals("ar")) {
            root.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        } else {
            root.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        }

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
