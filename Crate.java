

public class Crate extends Package{
	
	public Crate(float weight) {
		this.origin = "";
		this.destination = "";
		this.weight = weight; // in ounces
	}

	@Override
	public void check() throws PackageException {
	}
}
