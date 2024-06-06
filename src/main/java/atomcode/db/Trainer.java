package atomcode.db;

import java.sql.Timestamp;

public class Trainer {
    private int id;
    private String name;
    private Timestamp createdOn;

    public Trainer() {}

    public Trainer(int id, String name, Timestamp createdOn) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Timestamp getCreatedOn() {return createdOn;}
    public void setCreatedOn(Timestamp createdOn) {this.createdOn = createdOn;}
}
