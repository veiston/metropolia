import java.time.LocalDate;

public class Document implements IDocument {
    private String id;
    private LocalDate creationDate;
    private String content;

    Document(String id, LocalDate creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
