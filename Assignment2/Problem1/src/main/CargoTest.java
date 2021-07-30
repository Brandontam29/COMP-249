package main;

import shippingMethod.Box;
import shippingMethod.Letter;
import shippingMethod.MetalCrate;
import shippingMethod.WoodCrate;
import transport.Truck;

public class CargoTest {
	public static void main(String[] args) {
		Truck truck = new Truck("Kai Yuan Chen", 7000, "Brossard", "Montreal");

		System.out.println(truck.getOriginatingCity());
		System.out.println(truck.getDestinationCity());

		for (int i = 0; i < 23; i++) {
			Letter letter = new Letter(3210, 32f);
			truck.loadPackage(i, letter);
		}

		for (int i = 23; i < 41; i++) {
			WoodCrate woodCrate = new WoodCrate(3333, 32f);
			truck.loadPackage(i, woodCrate);
		}

		for (int i = 41; i < 90; i++) {
			Box box = new Box(3333, 32f);
			truck.loadPackage(i, box);
		}

		for (int i = 41; i < 90; i++) {
			Box box = new Box(3333, 32f);
			truck.loadPackage(i, box);
		}

		for (int i = 91; i < 150; i++) {
			MetalCrate metalCrate = new MetalCrate(3333, 32f);
			truck.loadPackage(i, metalCrate);
		}

		System.out.println(truck.getPackageCount());
		System.out.println(truck.getGrossIncome());

	}
}
