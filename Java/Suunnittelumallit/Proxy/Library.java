import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, IDocument> documents;

    public Library() {
        this.documents = new HashMap<>();
    }

    public void addDocument(IDocument document) {
        documents.put(document.getId(), document);
    }

    // Factory method for protected document
    public void createProtectedDocument(String id, LocalDate date, String content) {
        Document document = new Document(id, date, content);
        DocumentProxy proxy = new DocumentProxy(document);
        documents.put(id, proxy);
    }

    public void createUnprotectedDocument(String id, LocalDate date, String content) {
        Document document = new Document(id, date, content);
        documents.put(id, document);
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}
