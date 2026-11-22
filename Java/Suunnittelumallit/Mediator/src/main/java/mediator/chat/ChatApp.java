package mediator.chat;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private static final List<String> USERNAMES = List.of("Veikka", "Kseniia", "Luara");
    private static final int WINDOW_GAP = 380;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatMediator();
        List<ChatWindow> windows = new ArrayList<>();
        for (String username : USERNAMES) {
            windows.add(new ChatWindow(username, mediator));
        }
        for (int i = 0; i < windows.size(); i++) {
            windows.get(i).show(i * WINDOW_GAP);
        }
    }
}
