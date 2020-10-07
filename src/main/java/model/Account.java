package model;

import model.enums.Account_type;

public class Account {

    private String iban;
    private Integer user_id;
    private Integer disposable_balance;
    private Integer credit;
    private Account_type account_type;
    private Integer interest_rate;
    private String currency;

    public Account(String iban, Integer user_id, Integer disposable_balance,
                   Integer credit, Account_type account_type,
                   Integer interest_rate, String currency) {

        this.iban = iban;
        this.user_id = user_id;
        this.disposable_balance = disposable_balance;
        this.credit = credit;
        this.account_type = account_type;
        this.interest_rate = interest_rate;
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDisposable_balance() {
        return disposable_balance;
    }

    public void setDisposable_balance(Integer disposable_balance) {
        this.disposable_balance = disposable_balance;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Account_type getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Account_type account_type) {
        this.account_type = account_type;
    }

    public Integer getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Integer interest_rate) {
        this.interest_rate = interest_rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", user_id=" + user_id +
                ", disposable_balance=" + disposable_balance +
                ", credit=" + credit +
                ", account_type=" + account_type +
                ", interest_rate=" + interest_rate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
