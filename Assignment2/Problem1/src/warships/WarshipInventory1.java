package warships;

//-----------------------------------------------------
//Assignment 2
//Part: 2
//Written by: Kai Yuan Chen 40130869 and Brandon Tam 40100539 
//-----------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WarshipInventory1 {
	public static final String inputfile = "Initial_Cargoship_Info.txt";
	private static Warship[] wsArr = new Warship[50];// Create an empty array of 50

	public static boolean checkDuplicate(long Snumber, int index) // check if there is duplicate serial number
	{
		if (Snumber == wsArr[index].getSerial()) {
			return true;
		}
		return false;
	}

	public static long fixSerialNumber() throws DuplicateSerialNumberException {
		Scanner input = new Scanner(System.in);
		long newSerialNumber = input.nextLong();
		for (int i = 0; i < wsArr.length; i++) {
			if (wsArr[i] == null)
				continue;
			if (newSerialNumber == wsArr[i].getSerial()) {
				throw new DuplicateSerialNumberException();
			}
		}
		return newSerialNumber;
	}

	public static void fixInventory(String finalfilename) throws DuplicateSerialNumberException {
		int lineNumber = 0;
		Scanner input = null;

		populateWSArray();

		int numberofelements = 0;
		for (int i = 0; i < wsArr.length; i++) {
			if (wsArr[i] != null)
				numberofelements++;
		}

		if (numberofelements < 2) {
			{
				FileWriter output = null;
				try {
					output = new FileWriter(finalfilename);
				} catch (IOException e) {
				}
				try {
					output.close();
				} catch (IOException e) {
					System.out.println("The file could not be closed");
				}
			} // if there is only one or zero record in the array
			System.out.println("There is no need to fix the file as there isn't a lot of ships");
		} else {

			try {
				input = new Scanner(new FileReader(inputfile)); // the input
			} catch (IOException e) {
				System.out.println("The file could not be opened ");
			}
			Warship comparison = null;
			for (int i = 0; i < numberofelements; i++) {
				System.out.println(wsArr[i]);
				comparison = wsArr[i];
				int changed = 0;
				for (int j = 0; j < numberofelements; j++) {
					if (j == i)
						continue;
					if (checkDuplicate(comparison.getSerial(), j) == true) // if two of the ship has the same serial
																			// number
					{
						System.out.print("Duplicate Serial Number, please enter a new one: ");
						while (true) {
							try {
								long s = fixSerialNumber();
								System.out.println(s);
								wsArr[i].setSerial(s);
								System.out.println(wsArr[i].getSerial());
								changed = 1;
								break;
							} catch (DuplicateSerialNumberException e) {
								System.out.println("The entered number is already taken."); // if the entered number is
																							// still taken
							}
						}
						if (changed == 1)
							break;

					}
				}
			}
			FileWriter output = null;
			try {
				output = new FileWriter(finalfilename);
			} catch (IOException e) {
			}
			try {
				output.close();
			} catch (IOException e) {
				System.out.println("The file could not be closed");
			}
		}
		input.close();
	}

	public static void displayFileContents(String filename) {
		Scanner input = null;
		try {
			input = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e) // check if the file can be found or not
		{
			e.printStackTrace();
			System.out.println("File not found");
			return;
		}
		while (input.hasNextLine()) {
			Warship boat = new Warship(input.nextLine());
			System.out.println(boat.toString()); // prints out line by line
		}
	}

	public static void populateWSArray() {
		Scanner input;
		try {
			input = new Scanner(new FileReader(inputfile));
			int i = 0;
			while (input.hasNextLine()) {
				if (i > 49) {
					System.out.println("Too many ships. Ignoring extra");
					break;
				}
				Warship ship = new Warship(input.nextLine());
				wsArr[i] = ship;
				i++;

			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) // throws DuplicateSerialNumberException
	{
		Scanner keyboard = new Scanner(System.in);
		String finalname = "";
		System.out.print("Please enter the name of the output file, which will have the correct information: ");

		while (true) {
			finalname = keyboard.nextLine();
			File finalfile = new File(finalname);

			if (finalfile.exists()) {
				System.out.println("There is an exisiting file called " + finalname);
				System.out.println("Please Enter another file name to create: ");
				continue;
			}

			try {
				finalfile.createNewFile();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Attempting to open file: Initial_Cargoship_Info.txt");
		try {
			fixInventory(finalname);
		} catch (DuplicateSerialNumberException e) {
			e.printStackTrace();
		}
		WarshipInventory1.displayFileContents(inputfile);

		keyboard.close();
		try {
			PrintWriter myWriter = new PrintWriter(finalname + ".txt");

			for (int i = 0; i < wsArr.length; i++) {
				if (wsArr[i] == null)
					continue;
				System.out.println(wsArr[i].toString());
				myWriter.println(wsArr[i].toString());

			}
			myWriter.close();
		} catch (IOException e) {
		}
		WarshipInventory1.displayFileContents(finalname + ".txt");
	}

}