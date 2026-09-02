public class Employee extends OrganizationComponent {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXml(int indent) {
        return "  ".repeat(indent) + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />\n";
    }
}
