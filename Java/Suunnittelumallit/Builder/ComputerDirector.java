public class ComputerDirector {
    public Computer constructComputer(ComputerBuilder builder) {
        // Assemble computer using builder
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
        return builder.getComputer();
    }
}
