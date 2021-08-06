package main;

import java.util.Arrays;

public class B extends Marks {

	public B(String[] subjects, int[] grades) {
		super(subjects, grades);
	}

	protected int[] getPercentage(String subject0, String subject1, String subject2) {
		int index0 = Arrays.asList(this.subjects).indexOf(subject0);
		int index1 = Arrays.asList(this.subjects).indexOf(subject1);
		int index2 = Arrays.asList(this.subjects).indexOf(subject2);

		int[] percentages = { this.grades[index0], this.grades[index1], this.grades[index2] };

		return percentages;
	}

	protected int[] getPercentage(String subject0, String subject1, String subject2, String subject3) {
		int index0 = Arrays.asList(this.subjects).indexOf(subject0);
		int index1 = Arrays.asList(this.subjects).indexOf(subject1);
		int index2 = Arrays.asList(this.subjects).indexOf(subject2);
		int index3 = Arrays.asList(this.subjects).indexOf(subject3);

		int[] percentages = { this.grades[index0], this.grades[index1], this.grades[index2], this.grades[index3] };

		return percentages;
	}

}
