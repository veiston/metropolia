public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build configurations
        Computer gamingPC = director.constructComputer(new GamingComputerBuilder());
        System.out.println("Gaming PC: " + gamingPC);

        Computer officePC = director.constructComputer(new OfficeComputerBuilder());
        System.out.println("Office PC: " + officePC);
    }
}
