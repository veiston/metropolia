import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor implements FileSystemVisitor {
    private Predicate<File> criterion;
    private List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(Predicate<File> criterion) {
        this.criterion = criterion;
    }

    @Override
    public void visit(File file) {
        if (criterion.test(file)) {
            matchingFiles.add(file);
        }
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
