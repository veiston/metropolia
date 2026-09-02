public abstract class OrganizationComponent {
    public abstract String getName();
    public abstract double getSalary();

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to this component.");
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from this component.");
    }

    public abstract String toXml(int indent);

    public void printXml() {
        System.out.print(toXml(0));
    }

    public void printTotalSalary() {
        System.out.println("Total salary of " + getName() + ": " + getSalary());
    }
}
