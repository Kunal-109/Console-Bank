package domain;

public class Account {
    private final String accountNumber;
    private final String customerID;
    private Double balance ;
    private final String accountType;

    public Account(String accountNumber, String customerID, Double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public String getCustomerID() {
        return customerID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

}
