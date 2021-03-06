package cityBus;

public class Tram extends CityBus {

	// Data Members
	private int maxSpeed = 0;

	// Constructors
	public Tram() {
		super();
	}

	public Tram(double ticketPrice, int numberOfStops, long routeNumber, int operationYear, String lineName,
			String driverName, int maxSpeed) {
		super(ticketPrice, numberOfStops, routeNumber, operationYear, lineName, driverName);
		this.maxSpeed = maxSpeed;
	}

	public Tram(Tram Tram) {
		super(Tram);
		maxSpeed = Tram.maxSpeed;
	}

	// Methods
	public String toString() {
		return "This tram costs " + getTicketPrice() + " and it operates at a maximum speed of " + maxSpeed + " km/h.";
	}

	public boolean equalTo(Tram Tram) {
		if (Tram == null) {
			return false;
		}
		if (getClass() != Tram.getClass()) {
			return false;
		}
		if (maxSpeed == Tram.maxSpeed)
			return true;
		return false;
	}

	// Getters and Setters
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
