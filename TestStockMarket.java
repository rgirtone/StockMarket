// Main Driver Class, used to test the Stock Market and simulate it
public class TestStockMarket {
	// A static stock market object
	private static StockMarket sm;

	// A sub-menu used for addition/buying operations
	public static void additionMenu() {
		int choice;
		boolean continueLoop = true;
		while(continueLoop) {
			choice = 0;
			System.out.println("\nChoose an addition operation:");
			System.out.println("1. Add a Share to the Market");
			System.out.println("2. Add an Investor to the Market");
			System.out.println("3. Buy a Share for an Investor");
			System.out.println("4. Return to Main Menu");
			System.out.print("Enter choice: ");

			// Check for choice validity
			try {
				choice = Console.readInt();
			} catch (Exception e) {

			}

			System.out.println();
			boolean isSuccessful = true;
			switch(choice) {
				case 1:
					isSuccessful = sm.addShare();
					break;
				case 2:
					isSuccessful = sm.addInvestor();
					break;
				case 3:
					isSuccessful = sm.addShareToInvestor();
					break;
				case 4:
					continueLoop = false;
					break;
				default:
					// Invoked if the choice entered is invalid/incorrect
					System.out.println("Invalid choice, try again!!");
					break;
			}
			// Checks if the choice is valid, and the operation was successful, and
			// displays a appropriate message
			if(choice >=1 && choice <= 3) {
				if(isSuccessful) {
					System.out.println("Operation Success");
				}
				else {
					System.out.println("Operation Failed");
				}
			}
		}
		// Returns the control to the main menu
		mainMenu();
	}

	// A sub-menu used for removal/selling operations
	public static void removalMenu() {
		int choice;
		boolean continueLoop = true;
		while(continueLoop) {
			choice = 0;
			System.out.println("\nChoose a Removal/Selling operation:");
			System.out.println("1. Remove a Share from the Market");
			System.out.println("2. Remove an Investor from the Market");
			System.out.println("3. Sell a Share of an Investor");
			System.out.println("4. Return to Main Menu");
			System.out.print("Enter choice: ");

			// Check for choice validity
			try {
				choice = Console.readInt();
			} catch (Exception e) {}

			System.out.println();
			boolean isSuccessful = true;
			switch(choice) {
				case 1:
					isSuccessful = sm.removeShare();
					break;
				case 2:
					isSuccessful = sm.removeInvestor();
					break;
				case 3:
					isSuccessful = sm.removeShareOfInvestor();
					break;
				case 4:
					continueLoop = false;
					break;
				default:
					// Invoked if the choice entered is invalid/incorrect
					System.out.println("Invalid choice, try again!");
					break;
			}

			// Checks if the choice is valid, and the operation was successful, and
			// displays a appropriate message
			if(choice >=1 && choice <= 3) {
				if(isSuccessful) {
					System.out.println("Operation Success");
				}
				else {
					System.out.println("Operation Failed");
				}
			}
		}
		// Returns the control to the main menu
		mainMenu();
	}

	// A sub-menu used for updation operations
	public static void updationMenu() {
		int choice;
		boolean continueLoop = true;
		while(continueLoop) {
			choice = 0;
			System.out.println("\nChoose an updation operation:");
			System.out.println("1. Update a Share's Value");
			System.out.println("2. Update Individual Investor's Available Amount");
			System.out.println("3. Update an Investor's Name");
			System.out.println("4. Update Share-on-hold status for a Corporate Investor");
			System.out.println("5. Return to Main Menu");
			System.out.print("Enter choice: ");

			// Check for choice validity
			try {
				choice = Console.readInt();
			} catch (Exception e) {}

			System.out.println();
			boolean isSuccessful = true;
			switch(choice) {
				case 1:
					isSuccessful = sm.updateShareValue();
					break;
				case 2:
					isSuccessful = sm.updateAvailableAmountForInvestor();
					break;
				case 3:
					isSuccessful = sm.updateNameOfInvestor();
					break;
				case 4:
					isSuccessful = sm.updateShareOnHoldStatus();
				case 5:
					continueLoop = false;
					break;
				default:
					// Invoked if the choice entered is invalid/incorrect
					System.out.println("Invalid choice, try again!!");
					break;
			}
			// Checks if the choice is valid, and the operation was successful, and
			// displays a appropriate message
			if(choice >=1 && choice <= 3) {
				if(isSuccessful) {
					System.out.println("Operation Success");
				}
				else {
					System.out.println("Operation Failed");
				}
			}
		}
		// Returns the control to the main menu
		mainMenu();
	}

	// A sub-menu used for removal/selling operations
	public static void printingMenu() {
		int choice;
		boolean continueLoop = true;
		while(continueLoop) {
			choice = 0;
			System.out.println("\nChoose a Display operation:");
			System.out.println("1. Display all Shares");
			System.out.println("2. Display all Investors");
			System.out.println("3. Return to Main Menu");
			System.out.print("Enter choice: ");

			// Check for choice validity
			try {
				choice = Console.readInt();
			} catch (Exception e) {}

			System.out.println();
			switch(choice) {
				case 1:
					sm.printAllShares();
					break;
				case 2:
					sm.printAllInvestors();
					break;
				case 3:
					continueLoop = false;
					break;
				default:
					// Invoked if the choice entered is invalid/incorrect
					System.out.println("Invalid choice, try again!!");
					break;
			}
		}
		// Returns the control to the main menu
		mainMenu();
	}

	// The main menu for this program.
	// This menu divided various operations into a set of categories.
	// The user chooses a category and then proceeds by choosing a specific
	// operation of a selected category in the sub-menu.
	// The user can then return back to the main menu and either carry-on
	// other operations, or quit
	public static void mainMenu() {
		int choice = 0;
		System.out.println("\nChoose a category of operations:");
		// Categories
		System.out.println("1. Additon/Buying");
		System.out.println("2. Removal/Selling");
		System.out.println("3. Updatation");
		System.out.println("4. Display");
		System.out.print("Enter choice, or enter any other value to quit: ");

		// Check for choice validity
		// Nothing is done if the choice is invalid, and the function simply does nothing
		// and returns at the end
		try {
			choice = Console.readInt();
		} catch (Exception e) {
			return;
		}

		switch(choice) {
			case 1:
				additionMenu();
				break;
			case 2:
				removalMenu();
				break;
			case 3:
				updationMenu();
				break;
			case 4:
				printingMenu();
				break;
			default:
				break;
		}
	}

	// Main Driver Method
	public static void main(String[] args) {
		sm = new StockMarket();
		System.out.println("Welcome to the Stock Market");
		// Invoking the main menu
		mainMenu();
		System.out.println("\nGood Bye!!");
	}

}
