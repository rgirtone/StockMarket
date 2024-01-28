import java.util.ArrayList;

// This class represents an Investor in a Stock Market
public class Investor {
    // Protected members of the Investor class, to be inherited by all subclasses
    
    // Unique ID of an Investor
    protected int investorId;
    
    protected String name;
    
    // Stores the IDs of the shares owned by the Investor
    protected ArrayList<Integer> shares;
    // Stores the quantity of each share owned by the Investor
    protected ArrayList<Integer> shareQuantity;
    // Stores the amount invested amount in each share owned by the Investor
    protected ArrayList<Double> investedAmount;
    
    // Indicated the current number of Investors created
    public static int count = 0;
    // Indicates the total number of shares allowed to buy for an Investor
    public static final int SHARES_LIMIT = 25;
    
    // Default Constructor
    public Investor() {
        // This ensures that the ID of each investor is Unique
        this.investorId = ++count;
        this.shares = new ArrayList<Integer>();
        this.shareQuantity = new ArrayList<Integer>();
        this.investedAmount = new ArrayList<Double>();
    }
    
    // Parameterized Constructor
    public Investor(String name) {
        this();
        this.name = name;
    }

    // Returns ID of the Investor
    public int getInvestorId() {
        return investorId;
    }
    
    // Returns Name of the Investor
    public String getName() {
        return name;
    }

    // Returns the list of IDs of shares owned by the Investor
    public ArrayList<Integer> getShares() {
        return shares;
    }
    
    // Returns the quantity of each share owned by the Investor
    public ArrayList<Integer> getShareQuantity() {
        return shareQuantity;
    }

    // Returns the amount invested in each share owned by the Investor
    public ArrayList<Double> getInvestedAmount() {
        return investedAmount;
    }
    
    // Sets the Name of the Investor
    public void setName(String name) {
        this.name = name;
    }
    
    // Helper function to get the index where the share should be added/updated
    protected int getIndexOfShare(Share share) {
        int i = 0;
        for(; i < shares.size(); i++) {
            if(shares.get(i) == share.getShareId()) {
                // This indicated that the share already exists in the shares ArrayList
                break;
            }
        }
        return i;
    }
    
    // Function to add/update a share
    public boolean addShare(Share share, int quantity) {
        int index = getIndexOfShare(share);
        // To check if the shares limit has been reached
        if(index == 25) {
            System.out.println("This Investor already has 25 shares!");
            return false;
        }
        // If index == shares.size(), the share has not been added yet
        if(index == shares.size()) {
            shares.add(share.getShareId());
            shareQuantity.add(quantity);
            investedAmount.add(share.getValue() * quantity);
            return true;
        }
        // If index != shares.size(), this means we should instead update
        // the quantity of the existing share
        shareQuantity.set(index, shareQuantity.get(index) + quantity);
        investedAmount.set(index, investedAmount.get(index) + share.getValue() * quantity);
        return true;
    }
    
    // Function to remove/update a share
    public boolean removeShare(Share share, int quantity) {
        int index = getIndexOfShare(share);
        // A check to make sure that the share to be removed is owned by the Investor
        if(index == shares.size()) {
            System.out.println("The investor does not own this share!");
            return false;
        }
        // A check to make sure that the Investor has enough quantity of the shares to sell
        if(quantity > shareQuantity.get(index)) {
            System.out.println("The investor does not have enough shares");
            return false;
        }
        // This calculates the average amount invested in the share, per share
        double avgRateOfShare = investedAmount.get(index) / shareQuantity.get(index);
        // Re-adjusting share quantity and invested amount
        shareQuantity.set(index, shareQuantity.get(index) - quantity);
        investedAmount.set(index, investedAmount.get(index) - avgRateOfShare * quantity);
        // Resetting absurd investedAmount value, if any
        if(investedAmount.get(index) < 0) {
            investedAmount.set(index, 0.0);
        }
        // Removing the share entirely, if its quantity is 0
        if(shareQuantity.get(index) == 0) {
            shares.remove(index);
            shareQuantity.remove(index);
            investedAmount.remove(index);
        }
        return true;
    }

    @Override
    // Method to return the String representation of an Investor instance
    public String toString() {
        String result = "Investor ID: " + investorId;
        result += "\nName: " + name;
        //Displaying share details only when the investor has some shares
        if(shares.size() != 0) {
            result += "\nShare Details: \n";
        }
        for(int i = 0; i < shares.size(); i++) {
            result += "Share ID: " + shares.get(i);
            result += ", Quantity: " + shareQuantity.get(i);
            result += ", Invested Amount: " + investedAmount.get(i);
            result += ", Average Rate: " + (investedAmount.get(i) / shareQuantity.get(i));
            result += "\n";
        }
        return result;
    }
    
    
}
