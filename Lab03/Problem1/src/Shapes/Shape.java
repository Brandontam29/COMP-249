package Shapes;

public class Shape {
	// Data Members
	protected int height = 0;
	protected int width = 0;
	private char pattern = '*';

	// Constructors
	public Shape() {

	}

	public Shape(int h, int w) {
		this.height = h;
		this.width = w;
	}

	// Methods
	public String toString() {
		return getClass() + " => Height: " + getHeight() + " Width: " + getWidth();
	}

	// Getters and Setters
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public char getPattern() {
		return pattern;
	}

	public void setPattern(char pattern) {
		this.pattern = pattern;
	}

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(4, 10);
		Square square = new Square(5, 5);
		Triangle triangle = new Triangle(6, 6);

		System.out.println(rectangle.toString());
		System.out.println(square.toString());
		System.out.println(triangle.toString());
		
		rectangle.draw();
		square.draw();
		triangle.draw();
	}

}
