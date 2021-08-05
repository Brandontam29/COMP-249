package shippingMethod;

import exception.PackageException;

public abstract class Package {
	protected String trackingNumber;
	protected float weight;
	protected float shippingCost;
	protected float maxWeight;

	public Package(String trackingNumber, float weight) {
		this.trackingNumber = trackingNumber;
		this.weight = weight;
	}

	// Methods
	public String determineType(String trackingNumber) throws PackageException {
		int digit = smallestDigit(trackingNumber);
		String type = "Unknown";
		switch (digit) {
		case 0:
			type = "Letter";
			break;
		case 1:
			type = "Box";
			break;
		case 2:
			type = "WoodCrate";
			break;
		case 3:
			type = "MetalCrate";
			break;
		default:
			throw new PackageException("Tracking number invalid.");
		}
		return type;
	}

	public Boolean isValid() throws PackageException {
		return (trackingMatch() && !isTooHeavy(this.weight));
	}

	public Boolean isTooHeavy(float weight) throws PackageException {
		String unit = " pounds";

		if (this.getClass().getSimpleName().equals("Letter")) {
			unit = " ounces";
		}

		if (weight > maxWeight) {
			String message = this.getClass().getSimpleName() + " package of " + weight + unit
					+ " is too heavy, The max load is " + this.maxWeight + unit + ".";
			throw new PackageException(message);
		}

		return (weight > maxWeight);
	}

	public Boolean trackingMatch() throws PackageException {
		Boolean match = false;

		String type = this.getClass().getSimpleName();
		String digitType = determineType(this.trackingNumber);

		match = type.equals(digitType);

		if (!match) {
			throw new PackageException("Tracking number invalid for " + type + " type of package.");
		}

		return match;
	}

	private int smallestDigit(String str) {

		String numberString = str.replaceAll("[^\\d]", "");
		int number = Integer.parseInt(numberString);

		int smallest = 10;

		for (int i = 0; i < numberString.length(); i++) {
			int digit = number % 10;
			number /= 10;

			smallest = Math.min(digit, smallest);
		}
		return smallest;
	}

	// Conversion methods
	public float toOunces(float pounds) {
		float ounces = pounds * 16;

		return ounces;
	}

	public float toPounds(float ounces) {
		float pounds = ounces / 16;

		return pounds;
	}

	// Getters and setters

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(float shippingCost) {
		this.shippingCost = shippingCost;
	}

	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}
}
