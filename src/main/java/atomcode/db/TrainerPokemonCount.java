package atomcode.db;

public class TrainerPokemonCount {
    private Trainer trainer;
    private int pokemonCount;

    public TrainerPokemonCount(Trainer trainer, int pokemonCount) {
        this.trainer = trainer;
        this.pokemonCount = pokemonCount;
    }
    public Trainer getTrainer() {return trainer;}
    public int getPokemonCount() {return pokemonCount;}
}
