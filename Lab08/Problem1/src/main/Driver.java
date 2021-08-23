package main;

public class Driver {
	public static void main(String[] args) {
		String[] subjects = { "french", "english", "math", "history", "science" };
		int[] aGrades = { 99, 88, 77, 66, 55 };
		int[] bGrades = { 22, 33, 44, 55, 66 };

		A a = new A(subjects, aGrades);
		B b = new B(subjects, bGrades);
		int[] aPercentages = a.getPercentage("french", "math", "science");
		int[] bPercentages = b.getPercentage("french", "math", "science", "history");

		System.out.println("Student A's Grades");
		for (int i = 0; i < aPercentages.length; i++) {
			System.out.println(aPercentages[i]);
		}
		System.out.println("\nStudent B's Grades");
		for (int i = 0; i < bPercentages.length; i++) {
			System.out.println(bPercentages[i]);
		}
	}
}
