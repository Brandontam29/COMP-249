package main;

import java.util.Arrays;

public class A extends Marks {

	public A(String[] subjects, int[] grades) {
		super(subjects, grades);
	}

	protected int[] getPercentage(String subject0, String subject1, String subject2) {
		int index0 = Arrays.asList(this.subjects).indexOf(subject0);
		int index1 = Arrays.asList(this.subjects).indexOf(subject1);
		int index2 = Arrays.asList(this.subjects).indexOf(subject2);

		int[] percentages = { this.grades[index0], this.grades[index1], this.grades[index2] };

		return percentages;
	}

}
