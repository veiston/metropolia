import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static final AccessControlService INSTANCE = new AccessControlService();
    private final Set<String> permissions = new HashSet<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public void grantAccess(String documentId, String username) {
        permissions.add(username + ":" + documentId);
    }

    public void revokeAccess(String documentId, String username) {
        permissions.remove(username + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.contains(username + ":" + documentId);
    }
}
