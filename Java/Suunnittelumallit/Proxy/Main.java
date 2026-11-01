import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessService = AccessControlService.getInstance();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        // Add unprotected public document
        String publicDocId = "DOC-PUB-001";
        LocalDate publicDate = LocalDate.now();
        String publicContent = "Company Public Announcement: Welcome to our new headquarters!";
        library.addUnprotectedDocument(publicDocId, publicDate, publicContent);

        // Add protected confidential document
        String secretDocId = "DOC-SEC-001";
        LocalDate secretDate = LocalDate.now();
        String secretContent = "Confidential Financial Report 2026: Q3 profit is up 25%.";
        library.addProtectedDocument(secretDocId, secretDate, secretContent);

        // Grant access for DOC-SEC-001 to alice and charlie
        accessService.grantAccess(secretDocId, alice.getUsername());
        accessService.grantAccess(secretDocId, charlie.getUsername());

        System.out.println("=== 1. Public Document Access ===");
        IDocument publicDoc = library.getDocument(publicDocId);
        System.out.println("Document ID: " + publicDoc.getId());
        System.out.println("Creation Date: " + publicDoc.getCreationDate());
        System.out.println("Alice reads: " + publicDoc.getContent(alice));
        System.out.println("Bob reads: " + publicDoc.getContent(bob));

        System.out.println("\n=== 2. Protected Document Public Metadata ===");
        IDocument secretDoc = library.getDocument(secretDocId);
        System.out.println("Document ID: " + secretDoc.getId());
        System.out.println("Creation Date: " + secretDoc.getCreationDate());

        System.out.println("\n=== 3. Protected Document Authorized Access ===");
        try {
            System.out.println("Alice reads: " + secretDoc.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 4. Protected Document Unauthorized Access ===");
        try {
            System.out.println("Bob reads: " + secretDoc.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        }

        System.out.println("\n=== 5. Granting Access to Bob Dynamically ===");
        accessService.grantAccess(secretDocId, bob.getUsername());
        try {
            System.out.println("Bob reads after granted access: " + secretDoc.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 6. Revoking Access from Alice ===");
        accessService.revokeAccess(secretDocId, alice.getUsername());
        try {
            System.out.println("Alice reads after access revoked: " + secretDoc.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        }
    }
}
