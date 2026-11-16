public class TemperatureUnit {
    private int id;
    private String name;
    private String symbol;
    private String description;

    public TemperatureUnit(int id, String name, String symbol, String description) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
    }

    public TemperatureUnit(int id, String name, String symbol) {
        this(id, name, symbol, "");
    }

    public TemperatureUnit(String name, String symbol) {
        this(0, name, symbol, "");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}
