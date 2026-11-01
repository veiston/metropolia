public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0.0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    public double getTotalSize() {
        return totalSize;
    }
}
