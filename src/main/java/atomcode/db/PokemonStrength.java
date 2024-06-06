package atomcode.db;

import java.sql.Timestamp;
// class for future use
public class PokemonStrength {
    private int id;
    private int strength;
    private String strengthDescription;
    private Timestamp createdOn;

    public PokemonStrength () {};

    public PokemonStrength(int id, int strength, String strengthDescription, Timestamp createdOn) {
        this.id = id;
        this.strength = strength;
        this.strengthDescription = strengthDescription;
        this.createdOn = createdOn;
    }

    public int getId() {
        return id;
    }

    public int getStrength() {
        return strength;
    }

    public String getStrengthDescription() {
        return strengthDescription;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStrengthDescription(String strengthDescription) {
        this.strengthDescription = strengthDescription;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}
