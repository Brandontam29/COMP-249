
public class Person {

	// Data Members
	private String name;
	private int age;
	private char gender;

	// Constructors
	public Person() {
		this.name = null;
		this.age = 0;
		this.gender = ' ';
	}

	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// Methods
	public String toString() {
		String information = "Name: " + this.name + "Age: " + this.age + "Gender: " + this.gender;

		return information;
	}

	public Boolean equals(Person person) {
		return (this.name == person.name && this.age == person.age && this.gender == person.gender);
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}
