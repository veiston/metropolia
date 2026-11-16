public class SmartRemote extends Remote {
    private static final int MUTED_VOLUME = 0;

    public SmartRemote(Device device) {
        super(device);
    }

    public void mute() {
        // Mute device volume
        device.setVolume(MUTED_VOLUME);
    }

    public void voiceControl(String command) {
        // Voice command processing
        System.out.println("Processing voice command: " + command);
        switch (command.toLowerCase()) {
            case "turn on" -> device.enable();
            case "turn off" -> device.disable();
            case "mute" -> mute();
            default -> System.out.println("Unknown voice command: " + command);
        }
    }
}
