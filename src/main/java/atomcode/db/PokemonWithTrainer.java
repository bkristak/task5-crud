package atomcode.db;

public class PokemonWithTrainer {
    private Pokemon pokemon;
    private Trainer trainer;

    public PokemonWithTrainer(Pokemon pokemon, Trainer trainer) {
        this.pokemon = pokemon;
        this.trainer = trainer;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
