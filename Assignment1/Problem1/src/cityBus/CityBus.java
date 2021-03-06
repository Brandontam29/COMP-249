
package cityBus;

import publicTransportation.PublicTransportation;

public class CityBus extends PublicTransportation {

	// Data Members
	protected long routeNumber = 0L;// these variables are all protected, and can be access to the sub classes
									// within the same package. We also use
	protected int operationYear = 0;// it because it is the only package out of the three that has sub classes.
	protected String lineName = "N/A";
	protected String driverName = "N/A";

	// Constructors
	public CityBus() {
		super();
	}

	public CityBus(double ticketprice, int numberOfStops, long routeNumber, int operationYear, String lineName,
			String drivername) {
		super(ticketprice, numberOfStops);
		this.routeNumber = routeNumber;
		this.operationYear = operationYear;
		this.lineName = lineName;
		this.driverName = drivername;
	}

	// Copy Constructor
	public CityBus(CityBus cityBus) {
		super(cityBus);
		routeNumber = cityBus.routeNumber;
		operationYear = cityBus.operationYear;
		lineName = cityBus.lineName;
		driverName = cityBus.driverName;
	}

	// Methods
	public String toString() {
		return "This is CityBus no." + routeNumber + " which started operation on year " + operationYear + " named "
				+ lineName + ", which is conducted by " + driverName + ".";
	}

	public boolean equalTo(CityBus CityBus) {
		if (CityBus == null) // check if the statement is empty or not
		{
			return false;
		}
		if (getClass() != CityBus.getClass()) // checking if they are the same class or not
		{
			return false;
		}
		if (routeNumber == CityBus.routeNumber && operationYear == CityBus.operationYear && lineName == CityBus.lineName
				&& driverName == CityBus.driverName)
			return true;
		return false;
	}

	// Getters and setters
	public long getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(long routeNumber) {
		this.routeNumber = routeNumber;
	}

	public int getOperationYear() {
		return operationYear;
	}

	public void setOperationYear(int beginOperationYear) {
		this.operationYear = beginOperationYear;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
