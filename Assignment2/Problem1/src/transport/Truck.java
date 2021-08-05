package transport;

import exception.PackageException;
import shippingMethod.Package;

public class Truck {

	// Variables
	private String driverName = "N/A";
	private String originatingCity = "N/A";
	private String destinationCity = "N/A";

	private float unloadedWeight; // In pounds
	private float loadedWeight;

	private int packageCount = 0;
	final private int MAX_PACKAGE_COUNT = 200;
	private Package[] packages = new Package[MAX_PACKAGE_COUNT];

	private float grossIncome = 0; // costs of all packages

	// Constructors
	public Truck(String driverName) {
		this.driverName = driverName;
	}

	public Truck(String driverName, float unloadedWeight, String originatingCity, String destinationCity) {
		this.driverName = driverName;
		this.unloadedWeight = unloadedWeight;
		this.loadedWeight = unloadedWeight;
		this.originatingCity = originatingCity;
		this.destinationCity = destinationCity;
	}

	// Methods
	public void loadPackage(Package cargo) throws PackageException {
		if (packageCount >= MAX_PACKAGE_COUNT) {
			throw new PackageException("Cannot load package. Truck is full. Get some space by unloading.");
		}

		if (!cargo.isValid()) {
			return;
		}

		int emptyIndex = 300;

		for (int i = 0; i < MAX_PACKAGE_COUNT; i++) {
			if (packages[i] == null) {
				emptyIndex = i;
				break;
			}
		}

		this.packages[emptyIndex] = cargo;
		this.packageCount += 1;
		this.grossIncome += cargo.getShippingCost();
		this.loadedWeight += cargo.getWeight();
		if (this.getClass().getSimpleName().equals("Letter")) {
			this.loadedWeight += this.toPounds(cargo.getWeight());
		} else {
			this.loadedWeight += cargo.getWeight();
		}

	}

	public void loadPackage(int index, Package cargo) throws PackageException {
		if (packageCount >= MAX_PACKAGE_COUNT) {
			throw new PackageException("Cannot load package. Truck is full. Get some space by unloading.");
		}
		if (this.packages[index] != null) {
			throw new PackageException("Cannot load package. This spot is taken");
		}
		if (!cargo.isValid()) {
			return;
		}

		this.packages[index] = cargo;
		this.packageCount += 1;
		this.grossIncome += cargo.getShippingCost();
		if (this.getClass().getSimpleName().equals("Letter")) {
			this.loadedWeight += this.toPounds(cargo.getWeight());
		} else {
			this.loadedWeight += cargo.getWeight();
		}
	}

	public void unloadPackage() throws PackageException {
		int index = 0;
		for (int i = MAX_PACKAGE_COUNT - 1; i >= 0; i--) {
			if (packages[i] != null) {
				index = i;
				break;
			}
		}

		if (this.getClass().getSimpleName().equals("Letter")) {
			this.loadedWeight -= this.toPounds(packages[index].getWeight());
		} else {
			this.loadedWeight -= packages[index].getWeight();
		}
		this.grossIncome -= packages[index].getShippingCost();

		this.packageCount -= 1;
		this.packages[index] = null;

	}

	public void unloadPackage(int index) throws PackageException {
		if (this.packages[index] == null) {
			throw new PackageException("Cannot unload this package. This spot is already empty.");
		}

		if (this.getClass().getSimpleName().equals("Letter")) {
			this.loadedWeight -= this.toPounds(packages[index].getWeight());
		} else {
			this.loadedWeight -= packages[index].getWeight();
		}
		this.grossIncome -= packages[index].getShippingCost();

		this.packageCount -= 1;
		this.packages[index] = null;

	}

	// Conversion
	public float toKilograms(float pounds) {
		float kilograms = pounds / 2.205f;

		return kilograms;
	}

	public float toPounds(float kilograms) {
		float pounds = kilograms * 2.205f;

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

	public float getUnloadedWeight() {
		return unloadedWeight;
	}

	public void setUnloadedWeight(float unloadedWeight) {
		this.unloadedWeight = unloadedWeight;
	}

	public float getLoadedWeight() {
		return loadedWeight;
	}

	public void setLoadedWeight(float loadedWeight) {
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
