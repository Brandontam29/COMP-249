

public abstract class Package {
	String tracking;
	float weight, shippingCost;
	String origin, destination, type;
	
	public static void packageValid(String tn, float weight) throws PackageException {
		String type = tn.substring(tn.length() - 1);
		if (!(type.equals("0") || type.equals("1") || type.equals("2") || type.equals("3"))) {
			throw new PackageException("Package not loaded. Unknown Package, " + tn + ", " + weight + ".");
		}
	}
	
	public double toOunces(double w) {
		return w/32;
	}
	
	public double toPounds(double w) {
		return w*32;
	}
	
	public abstract void check() throws PackageException;
}
