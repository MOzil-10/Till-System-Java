package models;

public class TillModel {
    private int tillBalance;
    private int amountPaid;
    private int change;
    private int totalTransaction;
    private String changeBreakDown;

    public TillModel(int tillBalance, int amountPaid, int change, int totalTransaction, String changeBreakDown) {
        this.tillBalance = tillBalance;
        this.amountPaid = amountPaid;
        this.change = change;
        this.totalTransaction = totalTransaction;
        this.changeBreakDown = changeBreakDown;
    }

    // Setters
    public void setTillBalance(int tillBalance) {
        this.tillBalance = tillBalance;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void setTotalTransaction(int totalTransaction) {
        this.totalTransaction = totalTransaction;
    }

    public void setChangeBreakDown(String changeBreakDown) {
        this.changeBreakDown = changeBreakDown;
    }

    // Getters
    public int getTillBalance() {
        return tillBalance;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public int getChange() {
        return change;
    }

    public int getTotalTransaction() {
        return totalTransaction;
    }

    public String getChangeBreakDown() {
        return changeBreakDown;
    }

    // toString method
    @Override
    public String toString() {
        return "TillModel{" +
                "tillBalance=" + tillBalance +
                ", amountPaid=" + amountPaid +
                ", change=" + change +
                ", totalTransaction=" + totalTransaction +
                ", changeBreakDown='" + changeBreakDown + '\'' +
                '}';
    }
}
