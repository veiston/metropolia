package mediator.chat;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow {
    private static final int WIDTH = 360;
    private static final int HEIGHT = 300;
    private static final int SPACING = 8;

    private ChatController controller;
    private TextArea messageArea = new TextArea();

    public ChatWindow(String username, ChatMediator mediator) {
        controller = new ChatController(username, mediator, this);
    }

    // Called after every client is registered, so all recipients are known
    public void show(double x) {
        messageArea.setEditable(false);
        ComboBox<String> recipientBox = new ComboBox<>();
        recipientBox.getItems().setAll(controller.getRecipients());
        recipientBox.setPromptText("Recipient");
        TextField messageField = new TextField();
        HBox.setHgrow(messageField, Priority.ALWAYS);
        Button sendButton = new Button("Send");

        sendButton.setOnAction(event -> {
            controller.sendMessage(recipientBox.getValue(), messageField.getText());
            messageField.clear();
        });
        // Enter key sends too
        messageField.setOnAction(event -> sendButton.fire());

        VBox root = new VBox(SPACING, messageArea, new HBox(SPACING, recipientBox, messageField, sendButton));
        root.setPadding(new Insets(SPACING));
        VBox.setVgrow(messageArea, Priority.ALWAYS);

        Stage stage = new Stage();
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.setTitle(controller.getUsername());
        stage.setX(x);
        stage.show();
    }

    public void showMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}
