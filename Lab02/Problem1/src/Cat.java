
public class Cat extends Animal {
	// Data Members
	private String color;

	// Constructor
	public Cat(String name, int numberOfLegs, Boolean vegetarian, String color) {
		super(name, numberOfLegs, vegetarian);
		this.color = color;
	}

	// Methods
	@Override
	public void roar() {
		miao();
	}

	public void miao() {
		System.out.println("Miao!");
	}

	// Getters and Setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
