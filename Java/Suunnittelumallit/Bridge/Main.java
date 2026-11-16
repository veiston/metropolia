public class Main {
    public static void main(String[] args) {
        // Test remotes and devices
        Device tv = new Tv();
        Remote remote = new Remote(tv);
        remote.power();
        remote.volumeUp();
        tv.printStatus();

        System.out.println();
        Device radio = new Radio();
        Remote radioRemote = new Remote(radio);
        radioRemote.power();
        radio.printStatus();

        System.out.println();
        SmartTV smartTv = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTv);
        smartRemote.voiceControl("turn on");
        smartTv.browseInternet("https://metropolia.fi");
        smartRemote.voiceControl("mute");
        smartTv.printStatus();
    }
}
