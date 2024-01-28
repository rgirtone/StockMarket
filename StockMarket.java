import java.util.ArrayList;

//This class represents a Stock Market
public class StockMarket {
    // The list of shares in the market
    private ArrayList<Share> shares;
    // The quantity of each share in the market, corresponding to the shares list
    private ArrayList<Integer> shareQuantity;
    // The list of investors registered in the market
    private ArrayList<Investor> investors;
    
    // It is the limit for number of different shares that can be registered in the market
    public static final int SHARES_LIMIT = 25;
    // It is the limit for number of different investors that can be registered in the market
    public static final int INVESTORS_LIMIT = 100;
    
    // Default Constructor
    public StockMarket() {
        this.shares = new ArrayList<Share>();
        this.shareQuantity = new ArrayList<Integer>();
        this.investors = new ArrayList<Investor>();
    }

    // Helper function to find the Share by its companyId, and returns its index in the shares list
    private int findShareByCompanyId(int companyId) {
        for(int i = 0; i < shares.size(); i++) {
            if(shares.get(i).getCompanyId() == companyId) {
                // This means the share corresponding to the companyId has been found
                return i;
            }
        }
        // If the share is not found, index = -1 is returned
        return -1;
    }
    
    // Helper function to find the Share by its unique ID, and returns its index in the shares list
    private int findShareById(int id) {
        for(int i = 0; i < shares.size(); i++) {
            if(shares.get(i).getShareId() == id) {
                // This means the share with the given ID has been found
                return i;
            }
        }
        // If the share is not found, index = -1 is returned
        return -1;
    }
    
    // Helper function to find the Investor by its Name, and returns its index in the investors list
    private int findInvestorByName(String name) {
        for(int i = 0; i < investors.size(); i++) {
            if(investors.get(i).getName().equalsIgnoreCase(name)) {
                // This means the investor with the given name has been found
                return i;
            }
        }
        // If the investor is not found, index = -1 is returned
        return -1;
    }
    
    // This function adds a share to the market though user input
    public boolean addShare() {
        // Checks if the shares list has reached its limit
        if(shares.size() == SHARES_LIMIT) {
            System.out.println("No Share can be added, total shares limit for the Market reached");
            return false;
        }
        // Asking user input for company's ID who owns the share to be added
        System.out.print("Enter the Company ID: ");
        int companyId = Console.readInt();
        // Checks if any share with the same company ID exists or not
        if(findShareByCompanyId(companyId) != -1) {
            System.out.println("The Share for this company already exists");
            return false;
        }
        // Asking user input for the current value of the share
        System.out.print("Enter the Share's value: ");
        double value = Console.readDouble();
        Share share = new Share(companyId, value);
        shares.add(share);
        // Asking user input for the quantity of the share to be added
        System.out.print("Enter the Share's Quantity: ");
        int quantity = Console.readInt();
        shareQuantity.add(quantity);
        return true;
    }
    
    // This function removes a share from the market
    public boolean removeShare() {
        // Checks if the market has any shares to remove
        if(shares.size() == 0) {
            System.out.println("The market currently has no Shares");
            return false;
        }
        // Asking user input for company's ID who owns the share to be removed
        System.out.print("Enter the Company ID: ");
        int companyId = Console.readInt();
        int index = findShareByCompanyId(companyId);
        // Checks if the share with the company ID exists or not
        if(index == -1) {
            System.out.println("The Share for this company does not exist");
            return false;
        }
        // Asking user input for the quantity of the share to be removed
        System.out.print("Enter the Number of Shares to be removed: ");
        int quantity = Console.readInt();
        // Checks if the share has enough quantity to be removed
        if(shareQuantity.get(index) < quantity) {
            System.out.println("Not enough shares to remove");
            return false;
        }
        // Updates the share's quantity after removal
        shareQuantity.set(index, shareQuantity.get(index) - quantity);
        // Removes the share completely from the market, if quantity = 0
        if(shareQuantity.get(index) == 0) {
            shareQuantity.remove(index);
            shares.remove(index);
        }
        return true;
    }
    
    // Helper function to add a Corporate Investor to the list of Investors
    private void addCorporateInvestor(String name) {
        // Asking user input for relevant details
        System.out.print("Enter Date of Establishment (dd-mm-yyyy): ");
        String doe = Console.readLine();
        System.out.print("Enter the ID of company share: ");
        int companyShareId = Console.readInt();
        System.out.print("Is Company Share on Hold (yes/no): ");
        String shareHold = Console.readLine();
        boolean isCompanyShareOnHold = shareHold.equalsIgnoreCase("yes");
        CorporateInvestor corporateInvestor = new CorporateInvestor(name, doe, companyShareId, isCompanyShareOnHold);
        investors.add(corporateInvestor);
    }
    
    // Helper function to add a Mutual Fund to the list of Investors
    private void addMutualFund(String name) {
        MutualFund mutualFund = new MutualFund(name);
        investors.add(mutualFund);
    }
    
    // Helper function to add an Individual Investor to the list of Investors
    private void addIndividualInvestor(String name) {
        // Asking user input for relevant details
        System.out.print("Enter the Individual Investor's Available amount to Invest: ");
        double amountAvailable = Console.readDouble();
        IndividualInvestor individualInvestor = new IndividualInvestor(name, amountAvailable);
        investors.add(individualInvestor);
    }
    
    // Function to add an Investor to the Market
    public boolean addInvestor() {
        // Checks if the investors list has reached its limit
        if(investors.size() == INVESTORS_LIMIT) {
            System.out.println("No Investor can be added, total investors limit for the Market reached");
            return false;
        }
        // Asking user input for the Investor's name
        System.out.print("Enter Name: ");
        String name = Console.readLine();
        int indexOfInvestor = findInvestorByName(name);
        // Checking if any Investor with the given name exists
        if(indexOfInvestor != -1) {
            System.out.println("The Investor already exists");
            return false;
        }
        // Asking user input for choosing the type of Investor to be added
        System.out.println("Choose the type of Investor:");
        System.out.println("1. Corporate");
        System.out.println("2. Mutual Fund");
        System.out.println("3. Individual Investor");
        int choice = 0;
        // Making sure the user enters a valid choice
        while(choice < 1 || choice > 3) {
            System.out.print("Enter choice: ");
            choice = Console.readInt();
            if(choice >=1 && choice <= 3) {
                break;
            }
            System.out.println("Invalid Choice, try again!");
        }
        // Calling helper functions w.r.t the type of Investor choosen
        switch(choice) {
            case 1:
                addCorporateInvestor(name);
                break;
            case 2:
                addMutualFund(name);
                break;
            case 3:
                addIndividualInvestor(name);
                break;
        }
        return true;
    }
    
    // Function to remove an Investor from the Market
    public boolean removeInvestor() {
        // Checking if the market has any investors to remove
        if(investors.size() == 0) {
            System.out.println("The Market has no Investors to remove!");
            return false;
        }
        // Asking user input for the Investor's name
        System.out.print("Enter Name: ");
        String name = Console.readLine();
        // Checking if any Investor with the given name exists
        int indexOfInvestor = findInvestorByName(name);
        if(indexOfInvestor == -1) {
            System.out.println("The Investor does not exist");
            return false;
        }
        investors.remove(indexOfInvestor);
        return true;
    }
    
    // Function to buy a share for an Investor
    public boolean addShareToInvestor() {
        // Asking user input for the Investor's name
        System.out.print("Enter the Investor's Name: ");
        String name = Console.readLine();
        int indexOfInvestor = findInvestorByName(name);
        // Checking if any Investor with the given name exists
        if(indexOfInvestor == -1) {
            System.out.println("The Investor does not exist");
            return false;
        }
        // Asking user input for the Share's ID
        System.out.print("Enter the Share ID: ");
        int shareId = Console.readInt();
        int indexOfShare = findShareById(shareId);
        // Checking if any share with the given ID exists
        if(indexOfShare == -1) {
            System.out.println("This Share does not exist");
            return false;
        }
        // Asking user input for the quantity of the share to buy
        System.out.print("Enter the quantity of the Share: ");
        int quantity = Console.readInt();
        // Checks if enough quantity of the share exists in the market
        if(quantity > shareQuantity.get(indexOfShare)) {
            System.out.println("Enough shares Not available to Purchase");
            return false;
        }
        Share share = shares.get(indexOfShare);
        Investor investor = investors.get(indexOfInvestor);
        
        boolean result = false;
        // Invoking the addShare method of the investor, depending upon its subclass
        if(investor instanceof CorporateInvestor) {
            result = ((CorporateInvestor)investor).addShare(share, quantity);
        } else if (investor instanceof MutualFund) {
            result = ((MutualFund)investor).addShare(share, quantity);
        } else {
            result = ((IndividualInvestor)investor).addShare(share, quantity);
        }
        
        // Updated the quantity left of the share in the market, if
        // buying a share is successful
        if(result) {
            shareQuantity.set(indexOfShare, shareQuantity.get(indexOfShare) - quantity);
        }
        
        return result;
    }
    
    // Function to sell a share(s) of an Investors
    public boolean removeShareOfInvestor() {
        // Asking user input for the Investor's name
        System.out.print("Enter the Investor's Name: ");
        String name = Console.readLine();
        int indexOfInvestor = findInvestorByName(name);
        // Checking if any Investor with the given name exists
        if(indexOfInvestor == -1) {
            System.out.println("The Investor does not exist");
            return false;
        }
        // Asking user input for the Share's ID
        System.out.print("Enter the Share ID: ");
        int shareId = Console.readInt();
        int indexOfShare = findShareById(shareId);
        // Checking if any Share with the given ID exists
        if(indexOfShare == -1) {
            System.out.println("This Share does not exist");
            return false;
        }
        // Asking user input for the quantity of the share to be sold
        System.out.print("Enter the quantity of the Share: ");
        int quantity = Console.readInt();
        Share share = shares.get(indexOfShare);
        Investor investor = investors.get(indexOfInvestor);
        
        boolean result = false;
        // Invoking the removeShare method of the investor, depending upon its subclass
        if(investor instanceof CorporateInvestor) {
            result = ((CorporateInvestor)investor).removeShare(share, quantity);
        } else if (investor instanceof MutualFund) {
            result = ((MutualFund)investor).removeShare(share, quantity);
        } else {
            result = ((IndividualInvestor)investor).removeShare(share, quantity);
        }
        
        // Updated the quantity left of the share in the market, if
        // selling a share is successful
        if(result) {
            shareQuantity.set(indexOfShare, shareQuantity.get(indexOfShare) + quantity);
        }
        
        return result;
    }
    
    // Function to update the share's current value
    public boolean updateShareValue() {
        // Asking user input for the Share's ID
        System.out.print("Enter the Share ID: ");
        int shareId = Console.readInt();
        int indexOfShare = findShareById(shareId);
        // Checking if any Share with the given ID exists
        if(indexOfShare == -1) {
            System.out.println("This Share does not exist");
            return false;
        }
        // Asking user input for the share's new value
        System.out.print("Enter the Updated Share Value: ");
        double value = Console.readDouble();
        shares.get(indexOfShare).setValue(value);
        return true;
    }
    
    // Function to update the available amount for the Investor
    public boolean updateAvailableAmountForInvestor() {
        // Asking user input for the Investor's name
        System.out.print("Enter the Investor's Name: ");
        String name = Console.readLine();
        int indexOfInvestor = findInvestorByName(name);
        // Checking if any Investor with the given name exists
        if(indexOfInvestor == -1) {
            System.out.println("The Investor does not exist");
            return false;
        }
        Investor investor = investors.get(indexOfInvestor);
        // Checking if the investor is an instance of IndividualInvestor, because
        // the amountAvailable attribute is only valid for an Individual Investor
        if(!(investor instanceof IndividualInvestor)) {
            System.out.println("This Investor is not an Individual Investor");
            return false;
        }
        // Asking user input for the amount to be added
        System.out.print("Enter the amount to be added: ");
        double amount = Console.readDouble();
        ((IndividualInvestor)investor).addAmountAvailable(amount);
        return true;
    }
    
    // Function to update the name of an Investor
    public boolean updateNameOfInvestor() {
        // Asking user input for the Investor's Previous Name
        System.out.print("Enter the Investor's Previous Name: ");
        String prevName = Console.readLine();
        int indexOfInvestor = findInvestorByName(prevName);
        // Checking if any Investor with the given name exists
        if(indexOfInvestor == -1) {
            System.out.println("The Investor does not exist");
            return false;
        }
        // Asking user input for the Investor's New Name
        System.out.print("Enter the Investor's New Name: ");
        String newName = Console.readLine();
        investors.get(indexOfInvestor).setName(newName);
        return true;
    }
    
    // Function to update the share-on-hold status of a CorporateInvestor
    public boolean updateShareOnHoldStatus() {
        // Asking user input for the Investor's Previous Name
        System.out.print("Enter the Investor's Name: ");
        String name = Console.readLine();
        int indexOfInvestor = findInvestorByName(name);
        // Checking if any Investor with the given name exists
        if(indexOfInvestor == -1) {
            System.out.println("The Investor does not exist");
            return false;
        }
        Investor investor = investors.get(indexOfInvestor);
        // Checking if the investor is an instance of CorporateInvestor, because
        // the companyShareOnHold attribute is only valid for a CorporateInvestor
        if(!(investor instanceof CorporateInvestor)) {
            System.out.println("This Investor is not a Corporate Investor");
            return false;
        }
        // Asking user input for the new share-on-hold status
        System.out.print("Is the Company's Share on Hold (yes/no): ");
        boolean isCompanyShareOnHold = Console.readLine().equalsIgnoreCase("yes");
        ((CorporateInvestor)investor).setCompanyShareOnHold(isCompanyShareOnHold);
        return true;
    }
    
    // Function to print all Shares
    public void printAllShares() {
        if(shares.size() == 0) {
            System.out.println("No Shares in the Market");
            return;
        }
        System.out.println("Shares Details:");
        for(int i = 0; i < shares.size(); i++) {
            System.out.println(shares.get(i) + ", Quantity Left: " + shareQuantity.get(i));
        }
    }
    
    // Function to print all Investors
    public void printAllInvestors() {
        if(investors.size() == 0) {
            System.out.println("No Investors in the Market");
            return;
        }
        System.out.println("Investors Details:");
        for(int i = 0; i < investors.size(); i++) {
            Investor investor = investors.get(i);
            // Invoking toString methods, based on subclasses
            if(investor instanceof CorporateInvestor) {
                System.out.println((CorporateInvestor)investor);
            } else if (investor instanceof MutualFund) {
                System.out.println((MutualFund)investor);
            } else {
                System.out.println((IndividualInvestor)investor);
            }
            System.out.println();
        }
    }

}
