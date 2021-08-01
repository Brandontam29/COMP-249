import java.util.Random;
import java.util.Scanner;

public class CargoTest {
	
	/*
	public static String rs() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}*/
	
	public static void main(String[] args){
		/*
		Truck truck = new Truck("KYC", "City1", "City2", 1234);
		
		try {
			
			truck.load(new Letter(rs(), rs(), 5));
			truck.load(new Box(rs(), rs(), 32));
			truck.load(new MetalCrate(rs(), rs(), 99));
			truck.load(new WoodCrate(rs(), rs(), 66));
			truck.load(new Box(rs(), rs(), 16));
			truck.load(new Letter(rs(), rs(), 222));
			
		} catch (PackageException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Gross income: " + truck.income);
		System.out.println("Truck weight: " + truck.grossW);
		System.out.println("Driving to destination...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Arrived at destination.");
		
		truck.unload();*/
		int ans = -1;
		Truck truck = null;
		Scanner sc = new Scanner(System.in);
		while (ans != 0) {
			System.out.println("What would you like to do?\n"
					+ "\t1. Start a cargo\n"
					+ "\t\ta. Driver name\n"
					+ "\t\tb. Unload weight(kg; lb)\n"
					+ "\t\tc. Originating city\n"
					+ "\t\td. Destination city\n"
					+ "\t2. Load the truck with packages\n"
					+ "\t\ta. Package tracking number\n"
					+ "\t\tb. Package weight(oz; lb)\n"
					+ "\t3. Unload a package\n"
					+ "\t4. The number of packages loaded\n"
					+ "\t5. The gross income earned by shipping of the cargo\n"
					+ "\t6. Weight the truck(after it has been completely loaded)\n"
					+ "\t7. Drive the truck to destination\n"
					+ "\t0. To quit\n"
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
				truck = new Truck(name, origin, destination, weight);
			}
			else if (ans == 2) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				Package pkg = null;
				System.out.println("a. Enter tracking number: ");
				String tn = sc.next();
				System.out.println("b. Enter package weight: ");
				float weight = sc.nextFloat();
				try {
					Package.packageValid(tn, weight);
				} catch (PackageException e) {
					e.printStackTrace();
					continue;
				}
				String type = tn.substring(tn.length() - 1);
				
				if (type.equals("0"))
					pkg = new Letter(tn, weight);
				if (type.equals("1"))
					pkg = new Box(tn, weight);
				if (type.equals("2"))
					pkg = new WoodCrate(tn, weight);
				if (type.equals("3"))
					pkg = new MetalCrate(tn, weight);
				try {
					truck.load(pkg);
				} catch (PackageException e) {
					e.printStackTrace();
					continue;
				}
				System.out.println("Shipping cost: " + pkg.shippingCost);
			}
			
			else if (ans == 3) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				try {
					truck.unload();
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
				System.out.println("The truck has " + truck.numberOfPackages + " packages loaded.");
			}
			
			else if (ans == 5) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				System.out.println("The gross income is " + truck.income + ".");
			}
			
			else if (ans == 6) {
				if (truck == null) {
					System.out.println("Truck does not exist. Please start a new cargo.");
					continue;
				}
				System.out.println("The weight of the truck is " + truck.grossW + ".");
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
