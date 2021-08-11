package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {

			// Read the file
			FileReader fr = new FileReader("Input2.txt");
			BufferedReader br = new BufferedReader(fr);

			// Variables
			String s;
			String word = null;
			ArrayList<String> aListWords = new ArrayList<String>();

			while ((s = br.readLine()) != null) {

				Scanner scan = new Scanner(s);

				while (scan.hasNext()) {
					word = scan.next().toUpperCase();
					aListWords.add(word);
				}

				scan.close();

			}

			br.close();

			fr.close();

			// Remove words with 's or 'm
			removeContractions(aListWords);

			// Remove symbols
			removeSymbols(aListWords);

			// Remove words with numbers and letters in them
			removeMixed(aListWords);

			// Remove single letter non-words
			removeSingle(aListWords);

			// Remove empty
			removeEmpty(aListWords);

			// Remove duplicate
			removeDuplicate(aListWords);

			// Sort the list

			// Print the output
			int size = aListWords.size();

			for (int i = 0; i < size; i++) {
				System.out.println(aListWords.get(i));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void removeContractions(ArrayList<String> aList) {
		aList.replaceAll(s -> s.replaceAll("'M", ""));
		aList.replaceAll(s -> s.replaceAll("'S", ""));
	}

	public static void removeSymbols(ArrayList<String> aList) {
		aList.replaceAll(s -> s.replaceAll("[^A-Z0-9]", ""));
	}

	public static void removeMixed(ArrayList<String> aList) {
		aList.removeIf(s -> s.matches(".*\\d.*"));
	}

	public static void removeSingle(ArrayList<String> aList) {
		aList.removeIf(s -> (s.length() == 1 && !(s.matches("A") || s.matches("I"))));
	}

	public static void removeEmpty(ArrayList<String> aList) {
		aList.removeIf(s -> s.isEmpty());
	}

	public static void removeDuplicate(ArrayList<String> aList) {
		aList.removeIf(s -> s.isEmpty());

	}
}
