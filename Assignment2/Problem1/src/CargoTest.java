import java.util.Scanner;
import shippingMethod.Letter;

public class CargoTest {
	public static void main(String[] args) {
		// Program introduction
		System.out.println(
				"******************************************\n        Welcome to the Cargo App\n******************************************");
		System.out.println("What would you like to do?");

		System.out.println("    1. Start a cargo");
		System.out.println(
				"\ta. Start a cargo\n\tb. Unload weight(kg; lb)\n\tc. Originating city\n\td. Destination city");
		System.out.println("    2. Load the truck with packages");
		System.out.println("\ta. Package tracking number\n\tb. Package weight(oz;lb)\n\tc. Package shipping cost");
		System.out.println("    3. Unload a package");
		System.out.println("    4. View the number of packages loaded");
		System.out.println("    5. View the gross income earned by cargo shipping");
		System.out.println("    6. Weight the truck(after being loaded)");
		System.out.println("    7. Drive the truck to destination");
		System.out.println("    0. Exit system");
		System.out.println("Please enter your hcoice and press <Enter>:");

		// Variable declaration
		Scanner sc = new Scanner(System.in);
		int option;
		Truck truck = new Truck("Kai Yuan Chen");

		for (int i = 0; i < truck.getPackageCount(); i++) {
			
			truck.addPackage(i, );
		}

	}

	public Package generatePackage() {
		int packageType = (int) Math.random() * 4;
		
		switch(packageType) {
		case 0:
			Letter package = new Letter(7654, 4.00f);
		}
		
		
		
	}return package;
}
