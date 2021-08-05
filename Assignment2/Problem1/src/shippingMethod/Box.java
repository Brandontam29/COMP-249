package shippingMethod;

public class Box extends Package {
	// Constructors
	public Box(String trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxWeight(40f);

		float shippingCost = weight * 2f;
		super.setShippingCost(shippingCost);
	}
}
