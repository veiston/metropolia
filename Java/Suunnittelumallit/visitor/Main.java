public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory src = new Directory("src");
        Directory docs = new Directory("docs");

        File mainJava = new File("Main.java", 0.1);
        File appJava = new File("App.java", 0.2);
        File readme = new File("README.md", 0.05);
        File manualPdf = new File("manual.pdf", 2.5);

        src.addElement(mainJava);
        src.addElement(appJava);
        docs.addElement(readme);
        docs.addElement(manualPdf);

        root.addElement(src);
        root.addElement(docs);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor javaSearch = new SearchVisitor(".java");
        root.accept(javaSearch);
        for (File file : javaSearch.getMatchingFiles()) {
            System.out.println("Found: " + file.getName());
        }

        SearchVisitor pdfSearch = new SearchVisitor(".pdf");
        root.accept(pdfSearch);
        for (File file : pdfSearch.getMatchingFiles()) {
            System.out.println("Found: " + file.getName());
        }
    }
}
