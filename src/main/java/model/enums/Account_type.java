package model.enums;

public enum Account_type {
    DEBIT("debit_account"),
    CREDIT("credit_account");

    public final String label;

    Account_type(String label) {
        this.label = label;
    }

    public static Account_type fromString(String text) {
        for (Account_type at : Account_type.values()) {
            if (at.label.equalsIgnoreCase(text)) {
                return at;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return label;
    }
}
