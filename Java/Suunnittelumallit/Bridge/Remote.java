// Abstraction side of the bridge: works with any Device
public class Remote {
    private static final int VOLUME_STEP = 10;
    private static final int CHANNEL_STEP = 1;

    protected final Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void power() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - VOLUME_STEP);
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + VOLUME_STEP);
    }

    public void channelDown() {
        device.setChannel(device.getChannel() - CHANNEL_STEP);
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + CHANNEL_STEP);
    }
}
