import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessControl = AccessControlService.getInstance();

        User veke = new User("Veke");
        User kevin = new User("Kevin");

        library.createUnprotectedDocument("DOC-1", LocalDate.now(), "Public info");
        library.createProtectedDocument("DOC-2", LocalDate.now(), "Secret data");

        accessControl.grantAccess("DOC-2", veke.getUsername());

        IDocument doc1 = library.getDocument("DOC-1");
        System.out.println(doc1.getId() + ": " + doc1.getContent(veke));
        System.out.println(doc1.getId() + ": " + doc1.getContent(kevin));

        IDocument doc2 = library.getDocument("DOC-2");
        System.out.println(doc2.getId() + " date: " + doc2.getCreationDate());

        try {
            System.out.println(doc2.getId() + ": " + doc2.getContent(veke));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(doc2.getId() + ": " + doc2.getContent(kevin));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        accessControl.grantAccess("DOC-2", kevin.getUsername());
        try {
            System.out.println(doc2.getId() + ": " + doc2.getContent(kevin));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
