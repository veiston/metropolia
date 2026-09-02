import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        double total = 0.0;
        for (OrganizationComponent component : components) {
            total += component.getSalary();
        }
        return total;
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public String toXml(int indent) {
        StringBuilder sb = new StringBuilder();
        String indentation = "  ".repeat(indent);
        sb.append(indentation).append("<Department name=\"").append(name).append("\">\n");
        for (OrganizationComponent component : components) {
            sb.append(component.toXml(indent + 1));
        }
        sb.append(indentation).append("</Department>\n");
        return sb.toString();
    }
}
