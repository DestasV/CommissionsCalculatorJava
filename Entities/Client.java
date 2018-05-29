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
public class Client {
    public static final String TYPE_LEGAL = "legal";
    public static final String TYPE_NATURAL = "natural";
    private int id;
    private String type;

    public Client(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
