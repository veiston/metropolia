public class Car extends AbstractVehicle {
	private final String color;

	public Car() {
		super("Auto", "Bensiini");
		this.color = "Punainen";
	}

	protected String getDetails() {
		return "Väri: " + color;
	}
}
