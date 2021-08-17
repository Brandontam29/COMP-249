package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SubDictionary {
	ArrayList<String> aList;

	public SubDictionary(String input) {
		ArrayList<String> temp;
		// Read file
		temp = textToArray(input);

		// Filter
		filterArray(temp);

		// Sort the list
		sortArray(temp);

		// Remove Duplicates
		removeDuplicates(temp);

		this.aList = temp;
	}

	// Public Methods
	public void printAll() {
		int size = this.aList.size();
		char currentLetter = 'A' - 1;

		System.out.println("The document produced this sub-dictionary, which includes " + size + " entries.");

		for (int i = 0; i < size; i++) {
			if (this.aList.get(i).startsWith(String.valueOf(currentLetter))) {
				System.out.println(this.aList.get(i));
			} else {
				while (!this.aList.get(i).startsWith(String.valueOf(currentLetter))) {
					currentLetter += 1;
				}

				System.out.println("\n" + currentLetter + "\n==");
				System.out.println(this.aList.get(i));
			}
		}
	}

	public int getSize() {
		return this.aList.size();
	}

	// Private Methods

	private ArrayList<String> textToArray(String text) {
		// Variables
		String s;
		String word = null;
		ArrayList<String> temp = new ArrayList<String>();

		try {
			// Read the file
			FileReader fr = new FileReader(text);
			BufferedReader br = new BufferedReader(fr);

			// Add each word
			while ((s = br.readLine()) != null) {
				Scanner scan = new Scanner(s);
				while (scan.hasNext()) {
					word = scan.next().toUpperCase();
					temp.add(word);
				}

				scan.close();

			}

			br.close();

			fr.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return temp;
	}

	private void sortArray(ArrayList<String> aList) {
		aList.sort(null);
	}

	private void removeDuplicates(ArrayList<String> aList) {
		for (int i = 0; i < aList.size() - 1; i++) {
			if (aList.get(i).equals(aList.get(i + 1))) {
				aList.set(i, "");
			}
		}

		removeEmpty(aList);
	}

	private void filterArray(ArrayList<String> aList) {
		// Find exception
//		ArrayList<String> exceptions = findException(aList);
//		System.out.println(exceptions);

		// Remove words with 's or 'm
		removeContractions(aList);

		// Remove symbols
		removeSymbols(aList);

		// Remove words with numbers and letters in them
		removeLeet(aList);

		// Remove single letter non-words
		removeSingleLetter(aList);

		// Add the exceptions
//		aList.addAll(exceptions);

		// Remove empty
		removeEmpty(aList);

		// Remove duplicate
		removeDuplicate(aList);

	}

//	private ArrayList<String> findException(ArrayList<String> aList) {
//		ArrayList<String> temp = new ArrayList<String>();
//
//		for (int i = 0; i < aList.size(); i++) {
//			System.out.println(aList.get(i));
//			if (aList.get(i).contains("MC\u00B2")) {
//				aList.get(i).replace(\u002c', "adgasdfasdf");
//				temp.add(aList.get(i));
//				aList.set(i, "");
//			}
//		}
//		return temp;
//
//	}

	private void removeContractions(ArrayList<String> aList) {
		aList.replaceAll(s -> s.replaceAll("'M", ""));
		aList.replaceAll(s -> s.replaceAll("'S", ""));
	}

	private void removeSymbols(ArrayList<String> aList) {
		aList.replaceAll(s -> s.replaceAll("[^A-Z0-9]", ""));

	}

	private void removeLeet(ArrayList<String> aList) {
		aList.removeIf(s -> s.matches(".*\\d.*"));
	}

	public static void removeSingleLetter(ArrayList<String> aList) {
		aList.removeIf(s -> (s.length() == 1 && !(s.matches("A") || s.matches("I"))));
	}

	public static void removeEmpty(ArrayList<String> aList) {
		aList.removeIf(s -> s.isEmpty());
	}

	public static void removeDuplicate(ArrayList<String> aList) {
		aList.removeIf(s -> s.isEmpty());

	}

}
