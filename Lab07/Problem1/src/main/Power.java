package main;

public class Power {

	public static void main(String[] args) {
		System.out.println(power(0, 0));
		System.out.println(power(1, 1));
		System.out.println(power(2, 2));
		System.out.println(power(3, 3));
		System.out.println(power(4, 4));
		System.out.println(power(5, 5));
		System.out.println(power(6, 6));
		System.out.println(power(7, 7));
	}

	public static int power(int x, int y) {
		if (y == 0) {
			return 1;
		}

		int answer = (x * power(x, y - 1));
		return answer;
	}

}
