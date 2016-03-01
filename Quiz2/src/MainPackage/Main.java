package MainPackage;

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Main {
	
	//Variables
	static Scanner reader = new Scanner(System.in);
	static double initialTuition;
	static double percentIncreaseTuition;
	static double repaymentAPR;
	static double term;
	static double finalTuition;
	
	/**
	 * Runs everything
	 * @param args
	 */
	
	public static void main(String[] args){
		
		getInputs();
		calculateResults();
		
	}
	
	/**
	 * Asks the users for input on variables
	 */
	
	public static void getInputs(){
		System.out.println("What is the initial tuition cost?");
		initialTuition = reader.nextDouble();
		finalTuition = initialTuition;
		System.out.println("What is the percentage increases for tuition?");
		percentIncreaseTuition = reader.nextDouble();
		System.out.println("What is the repayment APR?");
		repaymentAPR = reader.nextDouble()/100;
		System.out.println("How many months are in a term?");
		term = reader.nextInt();
	}
	
	/**
	 * Calculates the results and prints them out
	 * based on the variables provided by the user.
	 */
	
	public static void calculateResults(){
		//This is to print out the tuition every semester:
		System.out.println("This is the tuition you have to pay every school year:");
		for(int i = 0; i < 4; i ++){
			if (i == 0)
				System.out.println("Freshman Year:");
			else if (i == 1)
				System.out.println("Sophomore Year:");
			else if (i == 1)
				System.out.println("Junior Year:");
			else
				System.out.println("Senior Year:");
			for(int j = 0; j < 2; j++){
				if (j == 0)
					System.out.printf("\tFall semester: %.2f \n", finalTuition);
				else
					System.out.printf("\tSpring semester: %.2f \n", finalTuition);
				//Now to print out the monthly values:
				System.out.println("\t\tFor each month, you have to pay: ");
				System.out.printf("\t\t %.2f \n", -1 * FinanceLib.pmt(repaymentAPR, term, finalTuition, initialTuition, true));
			}
			//This is to show what the tuition will be like
			//per school year, with the percentage
			//increases.
			finalTuition = finalTuition + (finalTuition * (percentIncreaseTuition/100));
		}
		
	}

}
