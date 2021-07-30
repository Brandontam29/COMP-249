package ferry;

import publicTransportation.PublicTransportation;

public class Ferry extends PublicTransportation {
	
	// Data Members
	private int buildYear = 0;
	private String shipName = "N/A";

	// Constructors
	public Ferry() {
		super();
	}

	public Ferry(double ticketPrice, int numberOfStops, int buildYear, String shipName) {
		super(ticketPrice, numberOfStops);
		this.buildYear = buildYear;
		this.shipName = shipName;
	}

	public Ferry(Ferry Ferry) {
		super(Ferry);
		buildYear = Ferry.buildYear;
		shipName = Ferry.shipName;
	}

	// Methods
	public String tostring() {
		return "This ship is built in " + buildYear + " and it is called: " + shipName + ".";
	}

	public boolean equalTo(Ferry Ferry) {
		if (buildYear == Ferry.buildYear && shipName == Ferry.shipName)
			return true;
		return false;
	}

	// Getters and Setters
	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

}
