package shippingMethod;

public class WoodCrate extends Crate {
	// Constructors
	public WoodCrate(int trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxLoad(80f);

		float shippingCost = weight * 2.5f;
		super.setShippingCost(shippingCost);
	}
}
