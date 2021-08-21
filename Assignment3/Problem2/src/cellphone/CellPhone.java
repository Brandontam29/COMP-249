package cellphone;

import java.util.Scanner;

public class CellPhone {

	private long serialNum;
	private String brand;
	private int year;
	private double price;

	// getters and setters
	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// constructors
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public CellPhone(CellPhone c, long serialNum) {
		this.serialNum = serialNum;
		this.brand = c.brand;
		this.year = c.year;
		this.price = c.price;
	}

	public CellPhone clone() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a new serial number: ");
		long serial = keyboard.nextLong();
		return new CellPhone(this, serial);
	}

	public String toString() {
		return "[" + this.serialNum + ": " + this.brand + " " + this.price + "$ " + this.year + "]  --> ";
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if (this.getClass() != o.getClass())
			return false;
		else {
			CellPhone chosenone = (CellPhone) o;
			return this.brand.equalsIgnoreCase(chosenone.brand) && this.price == chosenone.price
					&& this.year == chosenone.year;
		}
	}

}
