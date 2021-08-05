package shippingMethod;

public class MetalCrate extends Crate {
	// Constructors
	public MetalCrate(String trackingNumber, float weight) {
		super(trackingNumber, weight);

		setMaxWeight(100f);

		float shippingCost = weight * 3f;
		super.setShippingCost(shippingCost);
	}
}
