public class TempRecord {
    private int id;
    private double inputValue;
    private int sourceUnitId;
    private double outputValue;
    private int targetUnitId;
    private String language;
    private String timestamp;

    public TempRecord(int id, double inputValue, int sourceUnitId, double outputValue, int targetUnitId, String language, String timestamp) {
        this.id = id;
        this.inputValue = inputValue;
        this.sourceUnitId = sourceUnitId;
        this.outputValue = outputValue;
        this.targetUnitId = targetUnitId;
        this.language = language;
        this.timestamp = timestamp;
    }

    public TempRecord(double inputValue, int sourceUnitId, double outputValue, int targetUnitId, String language, String timestamp) {
        this(0, inputValue, sourceUnitId, outputValue, targetUnitId, language, timestamp);
    }

    public TempRecord(int id, double inputValue, int sourceUnitId, double outputValue, int targetUnitId) {
        this(id, inputValue, sourceUnitId, outputValue, targetUnitId, "en", "");
    }

    public TempRecord(double inputValue, int sourceUnitId, double outputValue, int targetUnitId) {
        this(0, inputValue, sourceUnitId, outputValue, targetUnitId, "en", "");
    }

    public int getId() {
        return id;
    }

    public double getInputValue() {
        return inputValue;
    }

    public int getSourceUnitId() {
        return sourceUnitId;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public int getTargetUnitId() {
        return targetUnitId;
    }

    public String getLanguage() {
        return language;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
