public class Task3Customer {
	public static void main(String[] args) {
		/* Create customers */
		Customer first = new Customer();
		Customer second = new Customer();

		/* Set timestamps (milliseconds) */
		first.setStartTime(System.currentTimeMillis());
		first.setEndTime(first.getStartTime() + 2500);

		second.setStartTime(System.currentTimeMillis());
		second.setEndTime(second.getStartTime() + 4000);

		/* Print results */
		printCustomer(first);
		printCustomer(second);
	}

	private static void printCustomer(Customer customer) {
		/* Print time in ms and seconds */
		System.out.println("Customer id: " + customer.getId());
		System.out.println("Time spent: " + customer.getTimeSpent() + " ms");
		System.out.println("Time spent: " + (customer.getTimeSpent() / 1000.0) + " s");
	}
}

class Customer {
	private static int nextId = 1;

	private final int id;
	private long startTime;
	private long endTime;

	public Customer() {
		this.id = nextId++;
	}

	public int getId() {
		return id;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getTimeSpent() {
		return endTime - startTime;
	}
}
