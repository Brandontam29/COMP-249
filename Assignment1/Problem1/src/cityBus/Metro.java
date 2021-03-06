package cityBus;

public class Metro extends CityBus {

	// Data Members
	private int numberOfVehicles = 0;
	private String cityName = "N/A";

	// Constructors
	public Metro() {
		super();
	}

	public Metro(double ticketPrice, int numberOfStops, long routeNumber, int operationYear, String lineName,
			String driverName, int numberOfVehicles, String cityName) {
		super(ticketPrice, numberOfStops, routeNumber, operationYear, lineName, driverName);
		this.numberOfVehicles = numberOfVehicles;
		this.cityName = cityName;
	}

	public Metro(Metro Metro) {
		super(Metro);
		numberOfVehicles = Metro.numberOfVehicles;
		cityName = Metro.cityName;
	}

	// Methods
	public String tostring() {
		return "there is a total of " + numberOfVehicles + " vehicles in " + cityName + ".";
	}

	public boolean equalTo(Metro Metro) {
		if (Metro == null) {
			return false;
		}
		if (getClass() != Metro.getClass()) {
			return false;
		}
		if (numberOfVehicles == Metro.numberOfVehicles && cityName == Metro.cityName)
			return true;
		return false;
	}

	// Getters and Setters
	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public void setNumberOfVehicles(int numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
