public class TempRecord {
    private int id;
    private double inputValue;
    private int sourceUnitId;
    private double outputValue;
    private int targetUnitId;

    public TempRecord(int id, double inputValue, int sourceUnitId, double outputValue, int targetUnitId) {
        this.id = id;
        this.inputValue = inputValue;
        this.sourceUnitId = sourceUnitId;
        this.outputValue = outputValue;
        this.targetUnitId = targetUnitId;
    }

    public TempRecord(double inputValue, int sourceUnitId, double outputValue, int targetUnitId) {
        this(0, inputValue, sourceUnitId, outputValue, targetUnitId);
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
}
