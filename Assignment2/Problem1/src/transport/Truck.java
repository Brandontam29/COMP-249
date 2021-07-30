package transport;

import shippingMethod.Package;

public class Truck {

	// Variables
	private String driverName = "N/A";
	private String originatingCity = "N/A";
	private String destinationCity = "N/A";

	private int unloadedWeight; // In pounds
	private int loadedWeight;

	private int packageCount = 0;
	final private int MAX_PACKAGE_COUNT = 200;
	private Package[] packages = new Package[MAX_PACKAGE_COUNT];

	private float grossIncome = 0; // costs of all packages

	// Constructors
	public Truck(String driverName) {
		this.driverName = driverName;
	}

	public Truck(String driverName, int unloadedWeight, String originatingCity, String destinationCity) {
		this.driverName = driverName;
		this.unloadedWeight = unloadedWeight;
		this.loadedWeight = unloadedWeight;
		this.originatingCity = originatingCity;
		this.destinationCity = destinationCity;
	}

	// Methods
	public void loadPackage(int spot, Package cargo) {
		if (this.packages[spot] == null) {
			this.packages[spot] = cargo;
			this.packageCount += 1;
			this.grossIncome += cargo.getShippingCost();
			this.loadedWeight += cargo.getWeight();
		} else {
			throw()
		}

	}

	public void unloadPackage(int spot, Package cargo) {
		this.packages[spot] = null;
		this.packageCount -= 1;
		this.grossIncome -= cargo.getShippingCost();
		this.loadedWeight -= cargo.getWeight();
	}

	// Conversion
	public double toKilograms(double pounds) {
		double kilograms = pounds / 2.205;

		return kilograms;
	}

	public double toPounds(double kilograms) {
		double pounds = kilograms * 2.205;

		return pounds;
	}

	// Getters and Setters
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getOriginatingCity() {
		return originatingCity;
	}

	public void setOriginatingCity(String originatingCity) {
		this.originatingCity = originatingCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getUnloadedWeight() {
		return unloadedWeight;
	}

	public void setUnloadedWeight(int unloadedWeight) {
		this.unloadedWeight = unloadedWeight;
	}

	public int getLoadedWeight() {
		return loadedWeight;
	}

	public void setLoadedWeight(int loadedWeight) {
		this.loadedWeight = loadedWeight;
	}

	public int getMAX_PACKAGE_COUNT() {
		return MAX_PACKAGE_COUNT;
	}

	public int getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}

	public Package[] getPackages() {
		return packages;
	}

	public void setPackages(Package[] packages) {
		this.packages = packages;
	}

	// Prevent floating point rounding error
	public float getGrossIncome() {
		float rounded = Math.round(grossIncome * 100f) / 100f;
		return rounded;
	}

	public void setGrossIncome(float grossIncome) {
		this.grossIncome = grossIncome;
	}
}
