

public class Box extends Package{
	
	public Box(String tracking, float weight) {
		type = "Box";
		this.origin = "";
		this.destination = "";
		this.weight = weight; // in ounces
		this.tracking = tracking;
		shippingCost = (float) (weight * 2);
	}

	@Override
	public void check() throws PackageException {
		if (weight > 40) {
			throw new PackageException("Package too heavy. Box, " + tracking + ", " + weight + ".");
		}
	}
	
}
