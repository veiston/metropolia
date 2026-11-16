// Implementation side of the bridge: remotes only talk to this API
public abstract class Device {
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;
    private static final int FIRST_CHANNEL = 1;

    private final String name;
    private boolean isEnabled = false;
    private int volume;
    private int channel = FIRST_CHANNEL;

    protected Device(String name, int volume) {
        this.name = name;
        setVolume(volume);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public int getVolume() {
        return volume;
    }

    public final void setVolume(int volume) {
        this.volume = Math.clamp(volume, MIN_VOLUME, MAX_VOLUME);
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = Math.max(channel, FIRST_CHANNEL);
    }

    public void printStatus() {
        if (isEnabled) {
            System.out.println(name + " is enabled");
        } else {
            System.out.println(name + " is disabled");
        }
        System.out.println("Current volume: " + volume + "%");
        System.out.println("Current channel: " + channel);
    }
}
