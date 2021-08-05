package shippingMethod;

public class WoodCrate extends Crate {
	// Constructors
	public WoodCrate(String trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxWeight(80f);

		float shippingCost = weight * 2.5f;
		super.setShippingCost(shippingCost);
	}
}
