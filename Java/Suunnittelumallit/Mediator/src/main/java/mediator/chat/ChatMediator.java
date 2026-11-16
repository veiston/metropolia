package mediator.chat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

// Clients only know the mediator, never each other
public class ChatMediator {
    private LinkedHashMap<String, ChatController> clientsByName = new LinkedHashMap<>();

    public void register(ChatController client) {
        clientsByName.put(client.getUsername(), client);
    }

    public List<String> getUsernames() {
        return new ArrayList<>(clientsByName.keySet());
    }

    public boolean sendMessage(String sender, String recipient, String message) {
        ChatController recipientClient = clientsByName.get(recipient);
        if (recipientClient == null) {
            return false;
        }
        recipientClient.receiveMessage(sender, message);
        return true;
    }
}
