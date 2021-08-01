

public class WoodCrate extends Crate{
	public WoodCrate(String tracking, float weight) {
		super(weight);
		tracking = origin + destination + "2";
		shippingCost = (float) (weight * 2.5);
		type = "WoodCrate";
		this.tracking = tracking;
	}
	
	@Override
	public void check() throws PackageException {
		if (weight > 80) {
			throw new PackageException("Package too heavy. WoodCrate, " + tracking + ", " + weight + ".");
		}
	}
	
}
