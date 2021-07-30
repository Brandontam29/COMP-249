package AirCraft;
import PublicTransportation.PublicTransportation;

enum ClassType {
	HELICOPTER, AIRLINE, GLIDER, BALLOON,
}

enum MaintenanceType {
	WEEKLY, MONTHLY, YEARLY,
}

public class AirCraft extends PublicTransportation {
	// Data Member
	ClassType classType;
	MaintenanceType maintenanceType;

	// Constructors

	public AirCraft() {
		super();
	}

	public AirCraft(double ticketPrice, int numberOfSteps, ClassType classType, MaintenanceType maintenanceType) {
		super(ticketPrice, numberOfSteps);
		this.classType = classType;
		this.maintenanceType = maintenanceType;
	}

	public AirCraft(AirCraft AirCraft) {
		super(AirCraft);
	}

	// Methods
	public String toString() {
		return "Aircraft is a " + classType + " and its maintenance is done " + maintenanceType + ".";
	}

	public boolean equalTo(AirCraft airCraft) {
		if (airCraft == null) {
			return false;
		}

		if (getClass() != airCraft.getClass()) {
			return false;
		}

		if (this.classType == airCraft.classType && maintenanceType == airCraft.maintenanceType)
			return true;

		return false;
	}

	// Getters and Setters
	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

	public MaintenanceType getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(MaintenanceType maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

}
