package warships;

public class Warship {

	// Variables
	private long Snumber;
	private String Name;
	private int Cyear;
	private String oCountry;
	private double Price;
	private double Speed;

	// Constructors
	public Warship() {
		Snumber = 0;
		Name = "";
		Cyear = 0;
		oCountry = "";
		Price = 0;
		Speed = 0;
	}

	public Warship(long Snumber, String Name, int Cyear, String oCountry, double Price, double Speed) {
		Snumber = this.Snumber;
		Name = this.Name;
		Cyear = this.Cyear;
		oCountry = this.oCountry;
		Price = this.Price;
		Speed = this.Speed;
	}

	public Warship(String lineinfo) {
		String[] info = lineinfo.split(" ");
		try {
			Snumber = Long.parseLong(info[0]);
			Name = info[1];
			Cyear = Integer.parseInt(info[2]);
			oCountry = info[3];
			Price = Double.parseDouble(info[4]);
			Speed = Double.parseDouble(info[5]);
		} catch (Exception e) {
			System.out.println("this ship is missing information");
		}
	}

	public Warship(Warship Warship) // CopyConstructor
	{
		Snumber = Warship.Snumber;
		Name = Warship.Name;
		Cyear = Warship.Cyear;
		oCountry = Warship.oCountry;
		Price = Warship.Price;
		Speed = Warship.Speed;
	}

	public long getSerial() // getters
	{
		return Snumber;
	}

	public String getName() {
		return Name;
	}

	public int getCyear() {
		return Cyear;
	}

	public String getoCountry() {
		return oCountry;
	}

	public double getPrice() {
		return Price;
	}

	public double getSpeed() {
		return Speed;
	}

	public void setSerial(long Snumber) // setters
	{
		Snumber = this.Snumber;
	}

	public void setName(String Name) {
		Name = this.Name;
	}

	public void setCyear(int Cyear) {
		Cyear = this.Cyear;
	}

	public void setoCountry(String oCountry) {
		oCountry = this.oCountry;
	}

	public void setPrice(double Price) {
		Price = this.Price;
	}

	public void setSpeed(double Speed) {
		Speed = this.Speed;
	}

	public boolean equalsTo(Warship warship) {
		if (warship == null) {
			return false;
		}
		if (Snumber == warship.Snumber) {
			return true;
		}
		return false;
	}

	public String toString() {
		return Snumber + " " + Name + " " + Cyear + " " + oCountry + " " + Price + " " + Speed;
	}
}
