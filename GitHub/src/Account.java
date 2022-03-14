import java.util.Scanner;

public class Account {

	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	Account(String cName,String cID){
		customerName = cName;
		customerID = cID;
	}
	
	void deposit (int amount) {
		if(amount !=0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	// DALO SA VYBERAT VIAC AKO BOLO REALNE NA UCTE
	/* void withdraw (int amount) {
		if(amount !=0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	} */
	
	
	// FIX
	void withdraw (int amount) {
		if(amount != 0) {
			balance = balance - amount;
			if (balance >= 0) {
				previousTransaction = - amount;
			}
			else if (balance < 0) {
				System.out.println("Error - Not enough funds to withdraw");
				balance = balance + amount;
			}
		}
	}
	
	
	void getPreviousTransaction () {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + previousTransaction);
		}
		else {
			System.out.println("No transaction has been made");
		}
	}
	
	void getInterestRate(int years) {
		double interestRate = .1100;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("Actual interest rate is: " + (100 * interestRate) + "%");
		System.out.println("After " + years + " you will have: " + newBalance);	
	}
	
	void ShowMenu () {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + customerName + "!");
		System.out.println();
		System.out.println("What would you like to do ?");
		System.out.println();
		System.out.println("A - Show balance");
		System.out.println("B - Deposit");
		System.out.println("C - Withdraw");
		System.out.println("D - Check previous transaction");
		System.out.println("E - Calculate interest rate");
		System.out.println("F - Quit");
		
	do {
		System.out.println("Enter your option:");
		System.out.println();
		char option1 = scanner.next().charAt(0);
		option = Character.toUpperCase(option1);
		
		switch(option) {
		case 'A' :	
			System.out.println("=================================");
			System.out.println("Your balance is: " + balance);
			System.out.println("=================================");
		break;
		
		
		case 'B' :
			System.out.println("Enter amount you want to deposit: ");
			int amount = scanner.nextInt();
			deposit(amount);
			break;
		
			
		case 'C' :
			System.out.println("Enter amount you want to withdraw: ");
			int amount2 = scanner.nextInt();
			withdraw(amount2);
			break;
			
		
		case 'D' :
		System.out.println("==================================");
		getPreviousTransaction();
		System.out.println("==================================");
		break;
		
		
		case'E' :
		System.out.println("For how many years do you want to invest: ");
		int years = scanner.nextInt();
		getInterestRate(years);
		break;
		
		
		case 'F' :
			System.out.println("==============================");
			break;
			
			
		default : 
			System.out.println("Error - Invalid character. Please type A, B, C, D, E, F");
		}
		
		
		
	}   while (option != 'F');
			System.out.println("Thank you for banking with us!");
	}
		
}