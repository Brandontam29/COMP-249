package main;

//-----------------------------------------------------
//Assignment 2
//Part: 1 
//Written by: Brandon Tam 40100539 and Kai Yuan Chen 40130869
//-----------------------------------------------------

import java.util.Scanner;

import exception.PackageException;
import shippingMethod.Box;
import shippingMethod.Letter;
import shippingMethod.MetalCrate;
import shippingMethod.Package;
import shippingMethod.WoodCrate;
import transport.Truck;

public class CargoTest {

	public static void main(String[] args) {

		int ans = -1;
		Truck truck = null;
		Scanner sc = new Scanner(System.in);
		while (ans != 0) {
			System.out.println("What would you like to do?\n" + "\t1. Start a cargo\n" + "\t\ta. Driver name\n"
					+ "\t\tb. Unload weight(kg; lb)\n" + "\t\tc. Originating city\n" + "\t\td. Destination city\n"
					+ "\t2. Load the truck with packages\n" + "\t\ta. Package tracking number\n"
					+ "\t\tb. Package weight(oz; lb)\n" + "\t3. Unload a package\n"
					+ "\t4. The number of packages loaded\n" + "\t5. The gross income earned by shipping of the cargo\n"
					+ "\t6. Weight the truck(after it has been completely loaded)\n"
					+ "\t7. Drive the truck to destination\n" + "\t0. To quit\n"
					+ "Please enter your choice and press <Enter>");
			ans = sc.nextInt();
			if (ans == 1) {
				if (truck != null)
					System.out.println("Warning, there is already an existing truck. Replacing existing one...");
				System.out.println("a. Enter driver name: ");
				String name = sc.next();
				System.out.println("b. Enter truck weight: ");
				float weight = sc.nextFloat();
				System.out.println("c. Enter truck origin: ");
				String origin = sc.next();
				System.out.println("d. Enter truck destination: ");
				String destination = sc.next();
				truck = new Truck(name, weight, origin, destination);
			} else if (ans == 2) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				Package pkg = new Letter("temp", 0);
				System.out.println("a. Enter tracking number: ");
				String tn = sc.next();
				System.out.println("b. Enter package weight: ");
				float weight = sc.nextFloat();

				try {
					String type = pkg.determineType(tn);
					switch (type) {
					case "Letter":
						pkg = new Letter(tn, weight);
						break;
					case "Box":
						pkg = new Box(tn, weight);
						break;
					case "WoodCrate":
						pkg = new WoodCrate(tn, weight);
						break;
					case "MetalCrate":
						pkg = new MetalCrate(tn, weight);
						break;
					}
				} catch (PackageException e1) {
					e1.printStackTrace();
				}

				try {
					truck.loadPackage(pkg);
				} catch (PackageException e) {
					e.printStackTrace();
				}

				System.out.println("Shipping cost: " + pkg.getShippingCost());
			}

			else if (ans == 3) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				try {
					truck.unloadPackage();
				} catch (PackageException e) {
					e.printStackTrace();
					continue;
				}
			}

			else if (ans == 4) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				System.out.println("The truck has " + truck.getPackageCount() + " packages loaded.");
			}

			else if (ans == 5) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				System.out.println("The gross income is " + truck.getGrossIncome() + ".");
			}

			else if (ans == 6) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				System.out.println("The weight of the truck is " + truck.getLoadedWeight() + " pounds or "
						+ Math.round(truck.toKilograms((float) truck.getLoadedWeight()) * 100f) / 100f + " kilograms.");
			}

			else if (ans == 7) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				System.out.println("The truck drove to destination.");
			}

			else {
				if (ans != 0) {
					System.out.println("Please enter a valid number.");
				}
			}
			System.out.println("------------");

		}

		System.out.println("Exiting");
		sc.close();
	}

}
