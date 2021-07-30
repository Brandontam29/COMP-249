package shippingMethod;

public class Letter extends Package {
	// Variables
	float maxWeight = 2.00f;

	// Constructors
	public Letter(int trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxLoad(2.00f);

		float shippingCost = weight * 0.05f;
		super.setShippingCost(shippingCost);
	}
}
