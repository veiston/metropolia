public interface Device {
    int MIN_VOLUME = 0;
    int MAX_VOLUME = 100;

    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
    void printStatus();
}
