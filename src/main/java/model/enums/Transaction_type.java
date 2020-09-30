package model.enums;

public enum  Transaction_type {
    WITHDRAW("withdraw"),
    DEPOSIT("deposit"),
    TRANSFER("transfer");

    private final String label;

    Transaction_type(String label) {
        this.label = label;
    }

    public static Transaction_type fromString(String text) {
        for (Transaction_type tt : Transaction_type.values()) {
            if (tt.label.equalsIgnoreCase(text)) {
                return tt;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return label;
    }
}
