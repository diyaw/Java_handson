import java.util.*;


public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("What do you wish to calculate ?");
        System.out.println("1. EMI\n2.SIP");
        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        
        while(true) {
        	if(choice == 1) {
        		double principal = 0, rate = 0;
        		int yearsEMI = 0;
        		System.out.println("\nEnter the details for EMI Calculation.");
	        	try {	
        			System.out.print("Loan Amount: ");
	        		principal = sc.nextDouble();
	        		if(principal < 0) {
	        			throw new InputMismatchException("Principal amount cannot be negative");
	        		}
	        		System.out.print("\nInterest Rate (per annum): ");
	        		rate = sc.nextDouble();
	        		if(rate < 0) {
	        			throw new InputMismatchException("Rate cannot be negative");
	        		}
	        		System.out.print("\nNumber of years for loan period: ");
	        		yearsEMI = sc.nextInt();
	        		if(yearsEMI < 0) {
	        			throw new InputMismatchException("Time cannot be negative");
	        		}
	        	}catch(InputMismatchException e) {
        			System.out.println(e);
        			break;
	        	}
        		EMI emiObj = new EMI();
        		emiObj.setLoanAmount(principal);
        		emiObj.setNoYears(yearsEMI);
        		emiObj.setInterestRate(rate);
        		emiObj.calculateEMI();
        		System.out.println("\nEMI = "+emiObj.getEmi());
        		break;
        	}
        	else if(choice == 2) {
        		double amount = 0, rateExp = 0;
        		int yearsSIP = 0;
        		System.out.println("\nEnter the details for SIP Calculation.");
        		try {
	        		System.out.print("Amount Invested at the start of every payment interval: ");
	        		amount = sc.nextDouble();
	        		if(amount < 0) {
        				throw new InputMismatchException("Amount cannot be negative");
        			}
	        		System.out.print("\nNumber of years for SIP: ");
	        		yearsSIP = sc.nextInt();
	        		if(yearsSIP < 0) {
        				throw new InputMismatchException("Time cannot be negative");
        			}
	        		System.out.print("\nYearly Interest rate expectation: ");
	        		rateExp = sc.nextDouble();
	        		if(rateExp < 0) {
        				throw new InputMismatchException("Rate cannot be negative");
        			}
        		}catch(InputMismatchException e) {
        			System.out.println(e);
        			break;
        		}
        		
        		SIP sipObj = new SIP();
        		sipObj.setAmount(amount);
        		sipObj.setTime(yearsSIP);
        		sipObj.setRate(rateExp);
        		sipObj.calculateSIP();
        		System.out.println("\nSIP = "+sipObj.getSip());
        		break;
        	}
        	else {
        		System.out.println("Please input a valid option");
        		System.out.println("Enter option: ");
        		choice = sc.nextInt();
        	}
        }
        sc.close();
	}

}
