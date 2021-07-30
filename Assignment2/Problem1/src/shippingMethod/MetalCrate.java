package shippingMethod;

public class MetalCrate extends Crate {
	// Constructors
	public MetalCrate(int trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxLoad(100f);

		float shippingCost = weight * 3f;
		super.setShippingCost(shippingCost);
	}
}
