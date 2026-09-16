public class Main {
    public static void main(String[] args) {
        // Basic printer
        System.out.println("Hello, basic Printer");
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        // Both decorators
        System.out.println("\nEncrypted + XML Printer");
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        // Decryption testiing
        System.out.println("\n Decryption Verification");
        EncryptedPrinter enc = new EncryptedPrinter(new BasicPrinter());
        String encrypted = enc.encrypt("Hello World!");
        System.out.println("Encrypted msg: " + encrypted);
        System.out.println("Decrypted mesg: " + enc.decrypt(encrypted));
    }
}
