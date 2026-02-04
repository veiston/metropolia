public class Television {
    /* Channel currently being watched */
    private int channel;

    /* Allowed channels */
    private int[] channels = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /* At the start, the TV is off */
    private boolean isOn = false;

    /* Check that the channel exists */
    private boolean isValidChannel(int selectedChannel) {
        for (int channel : channels) {
            if (channel == selectedChannel) {
                return true;
            }
        }
        return false;
    }

    /* Tell if the TV is on */
    public boolean isOn() {
        return isOn;
    }

    /* Return current channel */
    public int getChannel() {
        return channel;
    }

    /* Set a new channel (only works when TV is on) */
    public void setChannel(int selectedChannel) {
        if (!isOn) {
            return;
        }

        if (isValidChannel(selectedChannel)) {
            this.channel = selectedChannel;
        } else {
            this.channel = channels[0];
        }
    }

    /* On/off button */
    public void pressOnOff() {
        isOn = !isOn;
    }
}