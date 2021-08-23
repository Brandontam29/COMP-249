package Shapes;

public class Rectangle extends Shape {
	// Constructors
	public Rectangle() {
	}

	public Rectangle(int h, int w) {
		super(h, w);
	}

	// Methods
	public void draw() {
		System.out.println();
		for (int i = 0; i < getWidth(); i++) {
			System.out.print(getPattern() + " ");
		}

		for (int i = 0; i < getHeight() - 2; i++) {
			System.out.print("\n" + getPattern() + " ");

			for (int j = 0; j < getWidth() - 2; j++) {
				System.out.print("  ");
			}

			System.out.print(getPattern());

		}
		System.out.println();
		for (int i = 0; i < getWidth(); i++) {
			System.out.print(getPattern() + " ");
		}
	}
}
