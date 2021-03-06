package main;

//-----------------------------------------------------
//Assignment 1
//Part: 1 
//Written by: Brandon Tam 40100539 and Kai Yuan Chen 40130869
//-----------------------------------------------------

import airCraft.AirCraft;
import cityBus.CityBus;
import cityBus.Metro;
import cityBus.Tram;
import ferry.Ferry;
import publicTransportation.PublicTransportation;

public class Driver {

	public static void main(String[] args) {
		
		// Data Members
		PublicTransportation[] transportArray = new PublicTransportation[15];

		PublicTransportation pt = new PublicTransportation();
		CityBus citybus = new CityBus();
		AirCraft aircraft = new AirCraft();
		Ferry ferry = new Ferry();
		Metro metro = new Metro();
		Tram tram = new Tram();

		// Display information of each
		System.out.println(pt.toString());
		System.out.println(citybus.toString());
		System.out.println(aircraft.toString());
		System.out.println(ferry.toString());
		System.out.println(metro.toString());
		System.out.println(tram.toString());

		// Populate Array
		for (int i = 0; i < transportArray.length; i++) {
			int option = i % 6;

			switch (option) {
			case 0:
				transportArray[i] = new PublicTransportation();
				break;

			case 1:
				transportArray[i] = new CityBus();
				break;

			case 2:
				transportArray[i] = new AirCraft();
				break;

			case 3:
				transportArray[i] = new Ferry();
				break;

			case 4:
				transportArray[i] = new Metro();
				break;

			case 5:
				transportArray[i] = new Tram();
				break;

			default:
				transportArray[i] = new PublicTransportation();
				break;
			}
		}

		// Trace Array
		int lowestCostIndex = 0;
		int highestCostIndex = 0;

		for (int i = 0; i < transportArray.length - 1; i++) {
			if (transportArray[i].getTicketPrice() < transportArray[i + 1].getTicketPrice()) {
				lowestCostIndex = i;
			}

			if (transportArray[i].getTicketPrice() > transportArray[i + 1].getTicketPrice()) {
				highestCostIndex = i;
			}

		}

		System.out.println("\nThe event least expensive ticket price is: " + transportArray[lowestCostIndex]
				+ "\n with an index of " + lowestCostIndex);
		System.out.println("\nThe event with the most expensive ticket price is: " + transportArray[highestCostIndex]
				+ "\n with an index of " + highestCostIndex);

	}
}