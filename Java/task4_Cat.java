public class task4_Cat {
    private String name;

    public task4_Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        task4_Cat cat1 = new task4_Cat("Whiskers");
        task4_Cat cat2 = new task4_Cat("Rex"); /* added cat: Rex */

        // Call the meow method on all the cat instances
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();
    }
}