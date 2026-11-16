public class Main {
    public static void main(String[] args) {
        // Test date adapter
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2026);
        date.setMonth(11);
        date.setDay(5);

        System.out.println("Initial Date: " + date);

        date.advanceDays(30);
        System.out.println("After 30 days: " + date);

        date.advanceDays(60);
        System.out.println("After 60 more days: " + date);
    }
}
