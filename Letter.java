

public class Letter extends Package{
	
	public Letter(String tracking,  float weight) {
		type = "Letter";
		this.origin = "";
		this.destination = "";
		this.weight = weight; // in ounces
		this.tracking = tracking;
		shippingCost = (float) (weight * 0.05);
	}

	@Override
	public void check() throws PackageException {
		if (weight > 32) {
			throw new PackageException("Package too heavy, package not loaded. Letter, " + tracking + ", " + weight + ".");
		}
		
	}
	
}
