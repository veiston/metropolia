import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<String, Set<String>> allowedUsers; // documentId -> usernames

    private AccessControlService() {
        this.allowedUsers = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        if (!allowedUsers.containsKey(documentId)) {
            allowedUsers.put(documentId, new HashSet<>());
        }
        allowedUsers.get(documentId).add(username);
    }

    public void revokeAccess(String documentId, String username) {
        if (allowedUsers.containsKey(documentId)) {
            allowedUsers.get(documentId).remove(username);
        }
    }

    public boolean isAllowed(String documentId, String username) {
        if (allowedUsers.containsKey(documentId)) {
            return allowedUsers.get(documentId).contains(username);
        }
        return false;
    }
}
