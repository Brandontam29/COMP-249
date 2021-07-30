package shippingMethod;

public abstract class Package {
	protected int trackingNumber;
	protected float weight;
	protected float shippingCost;
	protected float maxLoad;

	public Package(int trackingNumber, float weight) {
		this.trackingNumber = trackingNumber;
		this.weight = weight;
	}

	// Methods
	protected Boolean isTooHeavy(float weight) {
		if (weight > maxLoad) {
			String message = this.getClass().getName() + " is too heavy";
			System.out.println(message);
		}

		return (weight > maxLoad);
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

	public int getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(int trackingNumber) {
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

	public float getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(float maxLoad) {
		this.maxLoad = maxLoad;
	}
}
