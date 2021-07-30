
// -----------------------------------------------------
// Assignment 1
// Part: 2
// Written by: Brandon Tam 40100539 and Kai Yuan Chen 40130869
// -----------------------------------------------------
import AirCraft.AirCraft;
import CityBus.CityBus;
import CityBus.Metro;
import CityBus.Tram;
import Ferry.Ferry;
import PublicTransportation.PublicTransportation;

public class DriverTwo {

	static PublicTransportation[] copyArray(PublicTransportation[] arr) {

		PublicTransportation[] copyArr = new PublicTransportation[arr.length];

		for (int i = 0; i < copyArr.length; i++) {
			String option = arr[i].getClass().getName();
			switch (option) {
			case "PublicTransportation.PublicTransportation":
				copyArr[i] = new PublicTransportation(arr[i]);
				break;

			case "CityBus.CityBus":
				copyArr[i] = new CityBus((CityBus) arr[i]);
				break;

			case "AirCraft.AirCraft":
				copyArr[i] = new AirCraft((AirCraft) arr[i]);
				break;

			case "Ferry.Ferry":
				copyArr[i] = new Ferry((Ferry) arr[i]);
				break;

			case "CityBus.Metro":
				copyArr[i] = new Metro((Metro) arr[i]);
				break;

			case "CityBus.Tram":
				copyArr[i] = new Tram((Tram) arr[i]);
				break;
			}

		}

		return copyArr;

	}

	public static void main(String[] args) {
		// Data Members
		PublicTransportation[] transportArray = new PublicTransportation[12];

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

		PublicTransportation[] transportCopyArr = copyArray(transportArray);

		// Print information of both arrays
		System.out.println("Original Array\n");
		for (int i = 0; i < transportArray.length; i++) {
			System.out.println(transportArray[i].toString());
		}

		System.out.println("\nCopied Array\n");
		for (int i = 0; i < transportCopyArr.length - 1; i++) {
			System.out.println(transportCopyArr[i].toString());
		}

		// Print information of both arrays
		Boolean arrayAreEqual = true;
		for (int i = 0; i < transportArray.length; i++) {

			if (!transportArray[i].equalTo(transportCopyArr[i])) {
				arrayAreEqual = false;
			}
		}

		if (arrayAreEqual) {
			System.out.println("\nBoth arrays are the same!");
		} else {
			System.out.println("\nThe copying made an error... Both arrays are different!");
		}

	}
}