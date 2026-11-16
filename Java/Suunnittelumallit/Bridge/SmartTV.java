public class SmartTV implements Device {
    private boolean on = false;
    private int volume = 25;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.clamp(volume, MIN_VOLUME, MAX_VOLUME);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void browseInternet(String url) {
        if (on) {
            System.out.println("SmartTV browsing: " + url);
        } else {
            System.out.println("Cannot browse: SmartTV is off");
        }
    }

    @Override
    public void printStatus() {
        if (on) {
            System.out.println("SmartTV is enabled");
        } else {
            System.out.println("SmartTV is disabled");
        }
        System.out.println("Current volume: " + volume + "%");
        System.out.println("Current channel: " + channel);
    }
}
