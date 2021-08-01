package Warships;

import java.io.*;
import java.util.*;

public class WarshipInventory1 {
	public static final String inputfile="Initial_Warship_Infor.txt";
	private static Warship[]wsArr=new Warship[50];//Create an empty array of 50
	private static Scanner keyboard = new Scanner(System.in);
	
public static boolean checkDuplicate(long Snumber,int index) //check if there is duplicate serial number
	{
		if(Snumber==wsArr[index].getSerial())
		{
			return true;
		}
		return false;
	}
public static void fixSerialNumber() throws DuplicateSerialNumberException
	{
		Scanner input = new Scanner(System.in);
		long newSerialNumber;
		System.out.println("Duplicate Serial Number detected, please enter a new one: ");
		System.out.print(input.next());
	}
public static void fixInventory(String filename, String finalfilename)
	{
	int linenumber=0;
	Scanner input = null;
	if (wsArr.length<=1)
		{
			{
				FileWriter output = null;
				try {
					output=new FileWriter(finalfilename);
				}catch(IOException e) {}
				try {
					output.close();
				}catch(IOException e) 
					{
					System.out.println("The file could not be closed");
					}
			} // if there is only one or zero record in the array
		}
	else {
 
	try {
		input=new Scanner(new FileReader(filename)); //the input
		}catch(IOException e)
			{	
			System.out.println("The file could not be opened ");
			}
	while(input.hasNextLine())
		{
			Warship comparaison = new Warship(input.nextLine());
			if(WarshipInventory1.checkDuplicate(comparaison.getSerial(),linenumber)==true) // if two of the ship has the same serial number
			{
				
			}
		}
	}
	{
		FileWriter output = null;
		try {
			output=new FileWriter(finalfilename);
		}catch(IOException e) {}
		try {
			output.close();
		}catch(IOException e) 
			{
			System.out.println("The file could not be closed");
			}
	}
	input.close();
	}
}
