package atomcode.db;

import java.sql.Timestamp;

public class Pokemon {
    private int id;
    private String name;
    private int trainerId;
    private int strengthId;
    private Timestamp createdOn;

    public Pokemon() {}

    public Pokemon(int id, String name, int trainerId, int strengthId, Timestamp createdOn) {
        this.id = id;
        this.name = name;
        this.trainerId = trainerId;
        this.strengthId = strengthId;
        this.createdOn = createdOn;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getTrainerId(){return trainerId;}
    public void setTrainerId(int trainerId) {this.trainerId = trainerId;}
    public int getStrengthId() {return strengthId;}
    public void setStrengthId(int strengthId) {this.strengthId = strengthId;}
    public Timestamp getCreatedOn() {return createdOn;}
    public void setCreatedOn(Timestamp createdOn) {this.createdOn = createdOn;}
}
