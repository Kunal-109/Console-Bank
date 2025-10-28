package domain;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private final String accountNumber;
    private final Double amount;
    private final LocalDateTime timestamp;
    private final String note;
    private final Type type;

    public Transaction(String accountNumber, Double amount, String id, String note, LocalDateTime timestamp, Type type) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
        this.note = note;
        this.type = type;
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public String getNote() {
        return note;
    }

    public Type getType() {
        return type;
    }
}
