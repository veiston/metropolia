public class SmartRemote extends Remote {
    public SmartRemote(Device device) {
        super(device);
    }

    public void mute() {
        // Mute device volume
        device.setVolume(0);
    }

    public void voiceControl(String command) {
        // Voice command processing
        System.out.println("Processing voice command: " + command);
        if (command.equalsIgnoreCase("turn on")) {
            device.enable();
        } else if (command.equalsIgnoreCase("turn off")) {
            device.disable();
        } else if (command.equalsIgnoreCase("mute")) {
            mute();
        }
    }
}
