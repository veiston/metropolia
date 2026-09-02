public class Main {
    public static void main(String[] args) {
        // Create company
        Department company = new Department("Metropolia");

        // create sub-departments
        Department cafeteria = new Department("Sodexo");
        Department principal = new Department("Principal");
        Department teacher = new Department("Teacher");
        Department cleaner = new Department("Cleaner");

        // Create employees
        Employee emp1 = new Employee("Veikka", 6000.0);
        Employee emp2 = new Employee("Joonatan", 5000.0);
        Employee emp3 = new Employee("Moona", 4500.0);
        Employee emp4 = new Employee("Kalle", 4800.0);
        Employee ceo = new Employee("Joni", 10000.0);

        // Organizational structure
        company.add(ceo);
        company.add(cafeteria);
        company.add(cleaner);

        cafeteria.add(principal);
        cafeteria.add(teacher);

        principal.add(emp1);
        principal.add(emp2);
        teacher.add(emp3);
        cleaner.add(emp4);

        // Print total salary
        System.out.println(" Total Salary ");
        company.printTotalSalary();
        cafeteria.printTotalSalary();

        // Print full organization structure
        System.out.println("\n Organization Structure (XML) ");
        company.printXml();

        // ;odification
        System.out.println(" Modifying Organization (Removing Joonatan, Adding Tiina to Cleaner) ");
        principal.remove(emp2);
        Employee emp5 = new Employee("Tiina", 5200.0);
        cleaner.add(emp5);

        // Print updated total salary and XML
        System.out.println("\n Updated Total Salary ");
        company.printTotalSalary();

        System.out.println("\n Updated Organization Structure (XML) ");
        company.printXml();
    }
}
