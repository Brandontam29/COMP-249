package publicTransportation;

//-----------------------------------------------------------------------------------------------------
//Assignment 1
//Written by Kai Yuan Chen 40130869 & Brandon Tam 40100539
//For COMP 249-U - Summer 2021
//-----------------------------------------------------------------------------------------------------

public class PublicTransportation {

	// Data members
	private double ticketPrice = 0d;
	private int numberOfStops = 0;
	// These variables are private since they do not need to be protected as this
	// package do not possess a sub class to use these variables in

	// Constructors
	public PublicTransportation() {
	}

	public PublicTransportation(double ticketPrice, int numberOfStops) {
		this.ticketPrice = ticketPrice;
		this.numberOfStops = numberOfStops;
	}

	public PublicTransportation(PublicTransportation publicTransportation) {
		this.ticketPrice = publicTransportation.ticketPrice;
		this.numberOfStops = publicTransportation.numberOfStops;
	}

	// Methods
	public String toString() {
		return "The total travel is going to cost " + ticketPrice + " and it is going to have " + numberOfStops
				+ " stops.";
	}

	public boolean equalTo(PublicTransportation PublicTransportation) {
		if (PublicTransportation == null) // checking if it is empty or not
		{
			return false;
		}
		if (getClass() != PublicTransportation.getClass()) // checking if both are the same type or not
		{
			return false;
		}
		if (ticketPrice == PublicTransportation.ticketPrice && numberOfStops == PublicTransportation.numberOfStops)
			return true;
		return false;
	}

	// Getters and Setters
	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

}
