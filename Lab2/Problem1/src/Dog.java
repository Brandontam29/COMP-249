
public class Dog extends Animal {
	// Data Members

	private String color;
	private String breed;

	// Constructor
	public Dog(String name, int numberOfLegs, Boolean vegetarian, String color, String breed) {
		super(name, numberOfLegs, vegetarian);
		this.color = color;
		this.setBreed(breed);
	}

	// Methods
	@Override
	public void roar() {
		bark();
	}

	public void bark() {
		System.out.println("Woof!");
	}

	// Getters and Setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

}
