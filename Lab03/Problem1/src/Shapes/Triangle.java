package Shapes;

public class Triangle extends Shape {
	// Data Members
	private int angle = 90;

	// Constructors
	public Triangle() {
	}

	public Triangle(int w) {
		super(w, w);
	}

	public Triangle(int h, int w) {
		super(w, w);
	}

	// Methods
	public void draw() {
		System.out.println();
		int i, j;

		for (i = 1; i < getWidth(); i++) {

			for (j = 1; j < i; j++) {
				System.out.print(getPattern() + " ");
			}

			System.out.println("");
		}

	}

	public String toString() {
		return getClass() + " => Height: " + getHeight() + " Width: " + getWidth() + " Angle: " + getAngle();
	}

	// Getters
	public int getAngle() {
		return angle;
	}
}
