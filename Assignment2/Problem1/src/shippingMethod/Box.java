package shippingMethod;

public class Box extends Package {
	// Constructors
	public Box(int trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxLoad(40f);

		float shippingCost = weight * 2f;
		super.setShippingCost(shippingCost);
	}
}
