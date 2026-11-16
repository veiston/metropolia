package mediator.chat;

import java.util.List;

public class ChatController {
    private String username;
    private ChatMediator mediator;
    private ChatWindow window;

    public ChatController(String username, ChatMediator mediator, ChatWindow window) {
        this.username = username;
        this.mediator = mediator;
        this.window = window;
        mediator.register(this);
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRecipients() {
        List<String> recipients = mediator.getUsernames();
        recipients.remove(username);
        return recipients;
    }

    public void sendMessage(String recipient, String message) {
        if (recipient == null) {
            window.showMessage("Choose a recipient first");
            return;
        }
        if (message.isBlank()) {
            return;
        }
        if (mediator.sendMessage(username, recipient, message)) {
            window.showMessage("To " + recipient + ": " + message);
        } else {
            window.showMessage("Could not reach " + recipient);
        }
    }

    public void receiveMessage(String sender, String message) {
        window.showMessage("From " + sender + ": " + message);
    }
}
