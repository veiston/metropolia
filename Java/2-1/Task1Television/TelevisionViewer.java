public class TelevisionViewer {
    public static void main(String[] args) {
        /* Create a Television */
        Television myTV = new Television();

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);
            boolean tired = false;

            /* Turn on the TV if it's off */
            if (!myTV.isOn()) {
                myTV.pressOnOff();
            }

            /* Start from channel 1 */
            myTV.setChannel(1);

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);

                if (myTV.getChannel() % 4 == 0) {
                    tired = true;
                }
            }

            myTV.pressOnOff();
            System.out.println("Falling asleep");
        }
    }
}