// This class inherits the Investor class
// This class represents a Mutual Fund
public class MutualFund extends Investor {
    // Unique ID of a Mutual Fund
    private int mutualFundId;
    // The Net Average Value per unit of the Fund
    private double nav;
    // Indicates whether a Mutual Fund is active or not
    private boolean isActive;
    
    public static final int MIN_SHARES = 3;
    public static int count = 0;
    // Default Constructor
    public MutualFund() {
        super();
        // Ensures that every Mutual Fund instance has a unique mutualFundId
        this.mutualFundId = ++count;
        // nav = 0.0 because the Fund does not have shares yet
        this.nav = 0.0;
    }
    
    // Parameterized Constructor
    public MutualFund(String name) {
        super(name);
        this.mutualFundId = ++count;
        this.nav = 0.0;
    }
    
    // Returns the unique mutualFundId
    public int getMutualFundId() {
        return mutualFundId;
    }

    // Returns the Net Average Value per unit of the Fund
    public double getNav() {
        return nav;
    }
    
    // Returns whether the Mutual Fund is active or not
    public boolean isActive() {
        return isActive;
    }
    
    
    // Helper function to update the nav value whenever a share is added/removed/updated
    private void updateNav() {
        long totalShareValue = 0;
        double totalShares = 0;
        for(int i = 0; i < shares.size(); i++) {
            totalShareValue += investedAmount.get(i);
            totalShares += shareQuantity.get(i);
        }
        nav = totalShareValue / totalShares;
    }
    
    // Overriding Investor's addShare method, to activate the Mutual fund when
    // the number of different shares owned by the Mutual Fund equals/exceeds MIN_SHARES
    @Override
    public boolean addShare(Share share, int quantity) {
        boolean result = super.addShare(share, quantity);
        if(result && shares.size() == 3) {
            isActive = true;
        }
        // NAV is updated on successful addition of the share
        if(result) {updateNav();}
        return result;
    }
    
    // Overriding Investor's removeShare method, to check that shareCount >= MIN_SHARES
    @Override
    public boolean removeShare(Share share, int quantity) {
        // Checks if the Fund is not active, in which case selling shares is forbidden
        if(!isActive) {
            System.out.println("Cannot remove this Share because it the mutual fund is not active yet");
            return false;
        }
        int index = getIndexOfShare(share);
        // This is to ensure that removing a share would not violate minimum share count property
        if(shareQuantity.get(index)== quantity && shares.size() <= MIN_SHARES) {
            System.out.println("Cannot remove this Share because it violates minimum different share count property");
            return false;
        }
        boolean result = super.removeShare(share, quantity);
        // NAV is updated on successful removal of the share
        if(result) {updateNav();}
        return result;
    }
    
    // Returns a String representation of only Mutual Fund Information
    public String getMutualFundInfo() {
        String result = "Mutual Fund ID: " + mutualFundId;
        result += "\nNAV per unit: " + nav;
        result += "\nIs the Mutual Fund Active? " + (isActive ? "Yes" : "No");
        return result;
    }
    
    @Override
    // Returns the String representation of the Mutual Fund Instance, with both Mutual
    // Fund information and Investor information
    public String toString() {
        String result = super.toString();
        if(shares.size() == 0) {
            result += "\n";
        }
        result += getMutualFundInfo();
        return result;
    }
}
