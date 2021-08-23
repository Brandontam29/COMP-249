
public class Animal {
	// Data Members
	private String name;
	private int numberOfLegs;
	private Boolean vegetarian;

	// Constructor
	public Animal(String name, int numberOfLegs, Boolean vegetarian) {
		this.name = name;
		this.numberOfLegs = numberOfLegs;
		this.vegetarian = vegetarian;
	}

	// Method
	public void roar() {
		System.out.println("Roar!");
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public Boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	// Main
	public static void main(String[] args) {
		Cat cat = new Cat("Catou", 4, false, "White");
		Dog dog = new Dog("Dog", 4, false, "Blond", "Golden Retriever");

		cat.roar();
		cat.miao();

		dog.roar();
		dog.bark();
	}

}
