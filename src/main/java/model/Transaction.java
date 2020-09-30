package model;

import model.enums.Transaction_type;

import java.sql.Date;

public class Transaction {
    private Integer id;
    private String debtor_acc;
    private String creditor_acc;
    private Double amount;
    private Date execution_date;
    private Transaction_type transaction_type;
    private String currency;

    public Transaction(Integer id, String debtor_acc, String creditor_acc, Double amount, Date execution_date, Transaction_type transaction_type, String currency) {
        this.id = id;
        this.debtor_acc = debtor_acc;
        this.creditor_acc = creditor_acc;
        this.amount = amount;
        this.execution_date = execution_date;
        this.transaction_type = transaction_type;
        this.currency = currency;
    }

    public Transaction(String debtor_acc, String creditor_acc, Double amount, Date execution_date, Transaction_type transaction_type, String currency) {
        this.debtor_acc = debtor_acc;
        this.creditor_acc = creditor_acc;
        this.amount = amount;
        this.execution_date = execution_date;
        this.transaction_type = transaction_type;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDebtor_acc() {
        return debtor_acc;
    }

    public void setDebtor_acc(String debtor_acc) {
        this.debtor_acc = debtor_acc;
    }

    public String getCreditor_acc() {
        return creditor_acc;
    }

    public void setCreditor_acc(String creditor_acc) {
        this.creditor_acc = creditor_acc;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getExecution_date() {
        return execution_date;
    }

    public void setExecution_date(Date execution_date) {
        this.execution_date = execution_date;
    }

    public Transaction_type getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(Transaction_type transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;


    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", debtor_acc='" + debtor_acc + '\'' +
                ", creditor_acc='" + creditor_acc + '\'' +
                ", amount=" + amount +
                ", execution_date=" + execution_date +
                ", transaction_type=" + transaction_type +
                ", currency='" + currency + '\'' +
                '}';
    }
}
