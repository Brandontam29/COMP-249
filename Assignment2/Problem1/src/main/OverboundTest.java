package main;

import exception.PackageException;
import shippingMethod.Letter;
import transport.Truck;

public class OverboundTest {

	public static void main(String[] args) {

		// Initialization
		Truck truck = new Truck("Kai Yuan Chen", 7000, "Brossard", "Madagascar");

		// Load packages
		for (int i = 0; i < 200; i++) {
			Letter letter = new Letter("Montreal-Texas-01234", 32f);
			try {
				truck.loadPackage(i, letter);
			} catch (PackageException e) {
				e.printStackTrace();
			}
		}

		// Load 1 extra package
		Letter letter2 = new Letter("Montreal-Texas-01234", 32f);
		try {
			truck.loadPackage(letter2);
		} catch (PackageException e) {
			e.printStackTrace();
		}

		// Print info
		System.out.println("Depart at: " + truck.getOriginatingCity());
		System.out.println("Destination: " + truck.getDestinationCity());

		System.out.println("\n***Loading truck***\n");
		System.out.println("Packages: " + truck.getPackageCount());
		System.out.println("Loaded weight: " + truck.getLoadedWeight());

		System.out.println("\n***Driving Truck***");
		System.out.println("\n***Truck has arrived and unloaded***\n");
		System.out.println("Unloaded weight: " + truck.getUnloadedWeight());
		System.out.println("Gross income: " + truck.getGrossIncome());

	}
}
