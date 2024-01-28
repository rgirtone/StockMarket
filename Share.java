// This class represents a Share to be bought/sold in a Stock market
public class Share {
    // Unique ID for each share instance
    private int shareId;
    // ID of the company to which the share belongs
    private int companyId;
    // Current trading value of the share
    private double value;
    
    public static int count = 0;
    
    // Default Constructor
    public Share() {
        // This ensures that every new instance has a unique ID
        this.shareId = ++count;
    }
    
    // Parameterized Constructor
    public Share(int companyId, double value) {
        this();
        this.companyId = companyId;
        this.value = value;
    }

    // Returns the share ID
    public int getShareId() {
        return shareId;
    }

    // Returns the company ID to which the share belongs
    public int getCompanyId() {
        return companyId;
    }

    // Returns the current trading value of the share
    public double getValue() {
        return value;
    }
    
    // Sets the company ID
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    // Sets the current trading value of the share
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    // Returns a String representation of a Share instance
    public String toString() {
        return "Share ID: " + shareId + ", Company ID: " + companyId + ", Current Value: " + value;
    }
    
}
