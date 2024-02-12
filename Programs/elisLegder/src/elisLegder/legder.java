package elisLegder;

public class legder {
    private String date, details;
    private double credit, debit, balance;
    
    public legder(String date, String details, Double credit, Double debit, Double balance) {
        this.date = date;
        this.details = details;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getCredit() {
        return this.credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return this.debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}