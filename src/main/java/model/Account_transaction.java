package model;

public class Account_transaction {
    private Integer id = null;
    private String account_id;
    private Integer transaction_id;

    public Account_transaction(String account_id, Integer transaction_id) {
        this.account_id = account_id;
        this.transaction_id = transaction_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }
}
