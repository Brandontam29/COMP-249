

public class MetalCrate extends Crate{
	public MetalCrate(String tracking, float weight) {
		super(weight);
		tracking = origin + destination + "3";
		shippingCost = (float) (weight * 3);
		type = "MetalCrate";
		this.tracking = tracking;
	}
	
	@Override
	public void check() throws PackageException {
		if (weight > 100) {
			throw new PackageException("Package too heavy. MetalCrate, " + tracking + ", " + weight + ".");
		}
	}
	
}
