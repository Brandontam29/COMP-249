

public class Truck {
	String name, origin, destination;
	float grossW, unloadedW, income;
	int numberOfPackages;
	Package[] packages;
	
	public Truck(String name, String origin, String destination, float unloadedW) {
		this.name = name;
		this.origin = origin;
		this.destination = destination;
		grossW = unloadedW;
		this.unloadedW = unloadedW;
		income = 0;
		numberOfPackages = 0;
		packages = new Package[200];
	}
	
	public void load(Package pkg) throws PackageException{
		pkg.check();
		makeSpace(pkg);
		packages[0] = pkg;
		grossW += pkg.weight;
		income += pkg.shippingCost;
		numberOfPackages++;
	}
	
	public void unload() throws PackageException{
		
		if (packages[0] == null)
			throw new PackageException("Truck is empty.");
		System.out.println("Unloading package. Type: " + packages[0].type + ", tracking number: " + packages[0].tracking + ", weight: " + packages[0].weight + ".");
		grossW -= packages[0].weight;
		numberOfPackages--;
		for (int i = 0 ; i < 199; i++) {
			packages[i] = packages[i+1];
		}
		packages[199] = null;
	}
	
	private void makeSpace(Package pkg) throws PackageException{
		if (packages[199] != null) {
			throw new PackageException("Truck is full, package not loaded. " + pkg.type + ", " + pkg.tracking + ", " + pkg.weight + ".");
		}
		for (int i = 199; i > 0; i--) { //free up the first spot
			packages[i] = packages[i-1];
		}
		packages[0] = null;
	}
	
	public double toKg(double w) {
		return w/2.205;
	}
	
	public double toPounds(double w) {
		return w*2.205;
	}
}
