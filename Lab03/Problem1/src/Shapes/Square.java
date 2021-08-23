package Shapes;

public class Square extends Shape {
	// Constructors
	public Square() {
	}

	public Square(int w) {
		super(w, w);
	}

	public Square(int w, int h) {
		super(w, w);
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

	// Setters
	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}

	public void setWidth(int height) {
		this.height = height;
		this.width = height;
	}
}
