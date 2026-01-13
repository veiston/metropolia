

public class Task4Cat {
    private String name;

    public Task4Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Task4Cat cat1 = new Task4Cat("Whiskers");
        Task4Cat cat2 = new Task4Cat("Rex"); /* added cat: Rex */

        // Call the meow method on all the cat instances
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();

    }
}