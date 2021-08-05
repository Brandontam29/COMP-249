package shippingMethod;

public class Letter extends Package {
	// Constructors
	public Letter(String trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxWeight(32f);

		float shippingCost = weight * 0.05f;
		super.setShippingCost(shippingCost);
	}
}
