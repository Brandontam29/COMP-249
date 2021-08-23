package main;

public abstract class Marks {
	String[] subjects;
	int[] grades;

	public Marks(String[] subjects, int[] grades) {
		this.subjects = subjects;
		this.grades = grades;
	}

	abstract protected int[] getPercentage(String str1, String str2, String str3);
}
