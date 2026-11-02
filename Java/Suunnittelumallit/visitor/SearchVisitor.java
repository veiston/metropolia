import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String criterion;
    private List<File> matchingFiles;

    public SearchVisitor(String criterion) {
        this.criterion = criterion;
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        // Accumulate matching files
        if (file.getName().contains(criterion)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
