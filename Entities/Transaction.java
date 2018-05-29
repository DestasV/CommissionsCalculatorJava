/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Entities;

/**
 *
 * @author destas
 */
public class Transaction {
    public static final String CASH_IN = "cash_in";
    public static final String CASH_OUT = "cash_out";

    private String date;
    private Client client;
    private String type;
    private Money sum;

    public Transaction(String date, Client client, String type, Money sum) {
        this.date = date;
        this.client = client;
        this.type = type;
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Money getSum() {
        return sum;
    }

    public void setSum(Money sum) {
        this.sum = sum;
    }
}
