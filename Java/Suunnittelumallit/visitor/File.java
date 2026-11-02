public class File implements FileSystemElement {
    private String name;
    private double size; // Size in MB

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
