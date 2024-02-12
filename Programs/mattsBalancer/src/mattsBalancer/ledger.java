package mattsBalancer;

import java.sql.*;

public class ledger {
    private String date, details;
    private double credit, debit, balance;
    Statement stmt;
    Connection c;
    
    public ledger(String date, String details, Double credit, Double debit, Double balance) {
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
    public void connect() {
        c = null;
        stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");
        } catch ( Exception e ) {
        	System.err.println("Error getting class for name org.sqlite.JDBC");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        try {
        	c = DriverManager.getConnection("jdbc:sqlite:file:/Users/Matthew/Documents/LedgerData/"
          		+ "MattsLedger.sqlite");
        } catch ( Exception e ) {
        	System.err.println("Error getting connection to MattsLedger.sqlite");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}