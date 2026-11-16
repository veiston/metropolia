public class SmartTV extends Device {
    private static final int DEFAULT_VOLUME = 25;

    public SmartTV() {
        super("SmartTV", DEFAULT_VOLUME);
    }

    public void browseInternet(String url) {
        if (isEnabled()) {
            System.out.println("SmartTV browsing: " + url);
        } else {
            System.out.println("Cannot browse: SmartTV is off");
        }
    }
}
