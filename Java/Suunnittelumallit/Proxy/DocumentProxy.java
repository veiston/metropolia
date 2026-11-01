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
            throw new AccessDeniedException("Access denied: User is null.");
        }

        boolean isAllowed = accessControlService.isAllowed(document.getId(), user.getUsername());
        if (!isAllowed) {
            throw new AccessDeniedException("Access denied: User '" + user.getUsername() + "' does not have permission to view document '" + document.getId() + "'.");
        }

        return document.getContent(user);
    }
}
