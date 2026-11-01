public interface FileSystemVisitor {
    void visit(File file);

    default void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
