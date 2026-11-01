import java.util.List;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("workspace");

        Directory sourceDir = new Directory("src");
        Directory docsDir = new Directory("docs");
        Directory imagesDir = new Directory("images");

        File appFile = new File("App.java", 0.15);
        File modelFile = new File("Model.java", 0.25);
        File readmeFile = new File("README.md", 0.05);
        File reportFile = new File("annual_report.pdf", 4.50);
        File logoFile = new File("logo.png", 1.20);
        File iconFile = new File("icon.png", 0.80);

        sourceDir.addElement(appFile);
        sourceDir.addElement(modelFile);

        docsDir.addElement(readmeFile);
        docsDir.addElement(reportFile);

        imagesDir.addElement(logoFile);
        imagesDir.addElement(iconFile);

        root.addElement(sourceDir);
        root.addElement(docsDir);
        root.addElement(imagesDir);

        System.out.println("=== Size Calculation ===");
        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total workspace size: " + sizeCalculator.getTotalSize() + " MB");

        SizeCalculatorVisitor imagesSizeCalculator = new SizeCalculatorVisitor();
        imagesDir.accept(imagesSizeCalculator);
        System.out.println("Images folder size: " + imagesSizeCalculator.getTotalSize() + " MB");

        System.out.println("\n=== File Search ===");

        System.out.println("Java source files:");
        SearchVisitor javaSearch = new SearchVisitor(file -> file.getName().endsWith(".java"));
        root.accept(javaSearch);
        printFiles(javaSearch.getMatchingFiles());

        System.out.println("\nPNG images:");
        SearchVisitor pngSearch = new SearchVisitor(file -> file.getName().endsWith(".png"));
        root.accept(pngSearch);
        printFiles(pngSearch.getMatchingFiles());

        System.out.println("\nFiles larger than 1.0 MB:");
        SearchVisitor largeFileSearch = new SearchVisitor(file -> file.getSize() > 1.0);
        root.accept(largeFileSearch);
        printFiles(largeFileSearch.getMatchingFiles());
    }

    private static void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(" - " + file.getName() + " (" + file.getSize() + " MB)");
        }
    }
}
