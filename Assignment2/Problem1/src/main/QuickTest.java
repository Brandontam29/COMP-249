package main;

import exception.PackageException;
import shippingMethod.Box;
import shippingMethod.Letter;
import shippingMethod.MetalCrate;
import shippingMethod.WoodCrate;
import transport.Truck;

public class QuickTest {
	public static void main(String[] args) {
		// Initialization
		Truck truck = new Truck("Kai Yuan Chen", 7000, "Brossard", "Madagascar");

		// Load packages
		for (int i = 0; i < 23; i++) {
			Letter letter = new Letter("Montreal-Texas-01234", 32f);
			try {
				truck.loadPackage(i, letter);
			} catch (PackageException e) {
				e.printStackTrace();
			}
		}

		for (int i = 23; i < 41; i++) {
			WoodCrate woodCrate = new WoodCrate("California-Vancouver-23994", 32f);
			try {
				truck.loadPackage(i, woodCrate);
			} catch (PackageException e) {
				e.printStackTrace();
			}
		}

		for (int i = 41; i < 90; i++) {
			Box box = new Box("XinJiang-Taipei-1234", 32f);
			try {
				truck.loadPackage(i, box);
			} catch (PackageException e) {
				e.printStackTrace();
			}
		}

		for (int i = 90; i < 150; i++) {
			MetalCrate metalCrate = new MetalCrate("Berlin-Sydney-98734", 32f);
			try {
				truck.loadPackage(metalCrate);
			} catch (PackageException e) {
				e.printStackTrace();
			}
		}

		// Unload packages
		for (int i = 30; i < 60; i++) {
			try {
				truck.unloadPackage(i);
			} catch (PackageException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 20; i++) {
			try {
				truck.unloadPackage();
			} catch (PackageException e) {
				e.printStackTrace();
			}
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
