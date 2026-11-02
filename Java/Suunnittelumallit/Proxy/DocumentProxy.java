import java.time.LocalDate;

public class DocumentProxy implements IDocument {
    private Document document;
    private AccessControlService accessControlService;

    public DocumentProxy(Document document) {
        this.document = document;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) {
        if (user == null) {
            throw new AccessDeniedException("User is null");
        }

        // Check access
        boolean allowed = accessControlService.isAllowed(document.getId(), user.getUsername());
        if (!allowed) {
            throw new AccessDeniedException("Access denied: " + user.getUsername());
        }

        return document.getContent(user);
    }
}
