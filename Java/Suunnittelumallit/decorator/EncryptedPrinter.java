public class EncryptedPrinter extends PrinterDecorator {
    private final int shift = 1;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        super.print(encrypted);
    }

    // Shifting one UTF-16 bit to the right, encryption :D
    public String encrypt(String message) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + shift);
        }
        return new String(chars);
    }

    // Decrypts message
    public String decrypt(String message) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - shift);
        }
        return new String(chars);
    }
}
