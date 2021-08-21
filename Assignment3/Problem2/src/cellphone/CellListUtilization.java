package cellphone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {
	public static void main(String[] args) {

		CellList list1 = new CellList();
		CellList list2 = new CellList();

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to the cellphone list");
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("Cell_Info.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (input.hasNextLine()) {
			long serialNum = input.nextLong();
			String brand = input.next();
			double price = input.nextDouble();
			int year = input.nextInt();

			if (!list1.contains(serialNum))
				list1.addToStart(new CellPhone(serialNum, brand, year, price));

			if (!list2.contains(serialNum))
				list2.addToStart(new CellPhone(serialNum, brand, year, price));
		}

		System.out.println("\n");
		list1.showContents();
		System.out.println("\n");
		list2.showContents();

		System.out.print("\nplease enter a serial number: ");
		long check = keyboard.nextLong();
		if (list1.contains(check))
			System.out.println("cellphone with the serial number you entered was found in the list");
		else
			System.out.println("no cellphone with the serial number you entered was found in the list");

		System.out.print("\nplease enter a 2nd serial number: ");
		long check2 = keyboard.nextLong();
		if (list1.contains(check))
			System.out.println("cellphone with the 2nd serial number you entered was found in the list");
		else
			System.out.println("no cellphone with the 2nd serial number you entered was found in the list");

		list1.deleteFromStart();
		list1.deleteFromIndex(3);
		list2.deleteFromStart();

		if (list1.equals(list2))
			System.out.println("\nTest1: both lists are the same\n");
		else
			System.out.println("\nTest1: both lists are different\n");

		list1.showContents();
		System.out.println("\n");
		list2.showContents();

		list2.deleteFromIndex(3);

		if (list1.equals(list2))
			System.out.println("\nboth lists are the same\n");

		CellPhone test = new CellPhone(101, "test", 101, 101.0);
		list1.replaceAtIndex(test, 4);
		list1.showContents();

		list1.insertAtIndex(test, 2);
		list1.showContents();

		if (list1.contains(101))
			System.out.println("Correct insertion\n");

		System.out.println("Thank you for using the cellphone list");

		keyboard.close();
	}
}
