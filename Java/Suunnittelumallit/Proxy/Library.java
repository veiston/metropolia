import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, IDocument> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(IDocument document) {
        documents.put(document.getId(), document);
    }

    public void addProtectedDocument(String id, LocalDate creationDate, String content) {
        Document realDocument = new Document(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);
    }

    public void addUnprotectedDocument(String id, LocalDate creationDate, String content) {
        Document realDocument = new Document(id, creationDate, content);
        documents.put(id, realDocument);
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}
