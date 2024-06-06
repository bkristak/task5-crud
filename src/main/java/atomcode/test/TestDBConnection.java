package atomcode.test;

import atomcode.db.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// created just to test some features...
public class TestDBConnection {
    public static void main(String[] args) {

        TrainerDAO trainerDAO = new TrainerDAO();
        List<Trainer> listOfAllTrainers = trainerDAO.readAllTrainers();
        for (int i = 0; i < listOfAllTrainers.size(); i++) {
            System.out.println(i+1 + ". " + listOfAllTrainers.get(i).getName());
        }


        /*
        // test 5 -- 2. Select All Trainers. The user can select a trainer from this list.
        TrainerDAO trainerDAO = new TrainerDAO();
        List<Trainer> listOfAllTrainers = trainerDAO.listAllTrainers();
        for (int i = 0; i < listOfAllTrainers.size(); i++) {
            System.out.println(i+1 + ". " + listOfAllTrainers.get(i).getName());
        }


        // test 4 -- 1. Select Uncaught Pokemon with ordered number index
        PokemonDAO pokemonDAO = new PokemonDAO();
        List<Pokemon> listUncaughtPokemon = pokemonDAO.readUncaughtPokemons();
        for (int i = 0; i < listUncaughtPokemon.size(); i++) {
            System.out.println(i+1 + ". " + listUncaughtPokemon.get(i).getName());
        }


        // test 3 -- List trainers that are sorted by who has how many pokemons
        TrainerDAO trainerDAO = new TrainerDAO();
        List<TrainerPokemonCount> trainerPokemonCounts = trainerDAO.listTrainersPokemonsCount();

        trainerPokemonCounts.stream()
                .forEach(trainerPokemonCount ->
                        System.out.println("Trainer name: " + trainerPokemonCount.getTrainer().getName()
                        + ", Pokemon count: " + trainerPokemonCount.getPokemonCount()));


        // test2 -- List the pokemons that belong to a given trainer
        PokemonDAO pokemonDAO = new PokemonDAO();
        List<PokemonWithTrainer> pokemonsWithTrainers = pokemonDAO.listPokemonsByTrainer();

        pokemonsWithTrainers.stream()
                .forEach(pokemonWithTrainer ->
                        System.out.println("Pokemon: " + pokemonWithTrainer.getPokemon().getName()
                                        + ", Trainer: " + pokemonWithTrainer.getTrainer().getName()));


        //  test1 if HikariCPDataSource connection works
        System.out.println("Starting connection test.");
        try (Connection connection = HikariCPDataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Connection to MySQL successful.");
            } else {
                System.out.println("Failed to make connection to MySQL.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL exception: " + e.getMessage());
        }
        */
    }
}
