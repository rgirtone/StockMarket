// This class inherits the Investor class
// This class represents an Individual Investor
public class IndividualInvestor extends Investor {
    // The total amount available for an Individual Investor to invest in shares
    private double amountAvailable;
    
    // Default Constructor
    public IndividualInvestor() {
        super();
        this.amountAvailable = 0.0;
    }

    // Parameterized Constructor
    public IndividualInvestor(String name, double amountAvailable) {
        super(name);
        this.amountAvailable = amountAvailable;
    }
    
    // Returns the total amount available for an Individual Investor to invest in shares
    public double getAmountAvailable() {
        return this.amountAvailable;
    }
    
    // Add amount to invest in Shares
    public void addAmountAvailable(double amountAvailable) {
        this.amountAvailable += amountAvailable;
    }
    
    // Overriding Investor's addShare method, to check if amount is available for Investment
    @Override
    public boolean addShare(Share share, int quantity) {
        double amountToInvest = share.getValue() * quantity;
        // Checks if the required amount for buying the share exceeds the amount available
        // to invest
        if(amountToInvest > amountAvailable) {
            System.out.println("The investor does not have enough amount to invest!");
            return false;
        }
        boolean result = super.addShare(share, quantity);
        // Updates the amount available to invest after buying shares
        if(result) {
            amountAvailable -= amountToInvest;
        }
        return result;
    }
    
    @Override
    // Returns the String representation of an IndividualInvestor instance
    public String toString() {
        String result = super.toString();
        if(shares.size() == 0) {
            result += "\n";
        }
        result += "Amount Available to Invest: " + this.amountAvailable + "\n";
        return result;
    }

}
