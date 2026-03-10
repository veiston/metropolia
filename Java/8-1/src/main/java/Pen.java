public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color color;
    private boolean capOn; // true = cap on

    // Default pen
    public Pen() {
        this.color = Color.RED;
        this.capOn = true;
    }
    public Pen(Color color) {
        this.color = color;
        this.capOn = true;
    }

    public void capOff() { capOn = false; }
    public void capOn()  { capOn = true; }

    // Color change is only allowed when the cap is on
    public void changeColor(Color color) {
        if (capOn) this.color = color;
    }

    public String draw() {
        return capOn ? "" : "Drawing " + color;
    }
}
