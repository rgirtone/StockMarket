// This class inherits the Investor class
// This class represents a Corporate Investor
public class CorporateInvestor extends Investor {
    // Unique ID of every CorporateInvestor instance
    private int corporateId;
    // Date of Establishment
    private String dateOfEstablishment;
    // The ID of the Share instance that the company owns
    private int companyShareId;
    // Indicates if the company shares are allowed to be sold or not
    private boolean isCompanyShareOnHold;
    
    public static int count = 0;
    
    // Default Constructor
    public CorporateInvestor() {
        super();
        // Ensures that every CorporateInvestor has a unique corporateId
        this.corporateId = ++count;
    }

    // Parameterized Constructor
    public CorporateInvestor(String name, String dateOfEstablishment, int companyShareId,
            boolean isCompanyShareOnHold) {
        super(name);
        this.corporateId = ++count;
        this.dateOfEstablishment = dateOfEstablishment;
        this.companyShareId = companyShareId;
        this.isCompanyShareOnHold = isCompanyShareOnHold;
    }

    // Returns the unique corporateId
    public int getCorporateId() {
        return corporateId;
    }

    // Returns the date of establishment
    public String getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    // Returns the ID of the share that the company owns
    public int getCompanyShareId() {
        return companyShareId;
    }

    // Returns if the company share is on hold for sale or not
    public boolean isCompanyShareOnHold() {
        return isCompanyShareOnHold;
    }

    // Sets the date of establishment
    public void setDateOfEstablishment(String dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    // Sets the ID of the share that the company owns
    public void setCompanyShareId(int companyShareId) {
        this.companyShareId = companyShareId;
    }

    // Sets if the company share is on hold for sale or not
    public void setCompanyShareOnHold(boolean isCompanyShareOnHold) {
        this.isCompanyShareOnHold = isCompanyShareOnHold;
    }

    // Overriding Investor's removeShare method, to check if the company's share is on hold
    @Override
    public boolean removeShare(Share share, int quantity) {
        // Checks if the share to be sold is the company owned share, and if the company's share is on hold
        // If this is the case, then selling this share is forbidden
        if(share.getShareId() == companyShareId && isCompanyShareOnHold) {
            System.out.println("This share cannot be sold as it is on hold by the company");
            return false;
        }
        // If the above condition does not hold, the method proceeds with the Superclass's method
        return super.removeShare(share, quantity);
    }
    
    // Returns the String representation of only Corporate Information
    public String getCorporateInfo() {
        String result = "Corporate ID: " + corporateId;
        result += "\nDate of Establishment: " + dateOfEstablishment;
        result += "\nCompany Share ID: " + companyShareId;
        result += "\nIs Company Share on Hold? " + (isCompanyShareOnHold ? "Yes" : "No");
        return result;
    }
    
    @Override
    // Returns the String representation of the CorporateInvestor instance, which includes
    // both Investor and Corporate information
    public String toString() {
        String result = super.toString();
        if(shares.size() == 0) {
            result += "\n";
        }
        result += getCorporateInfo();
        return result;
    }
    
}
