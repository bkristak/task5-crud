package atomcode.service;

import atomcode.db.*;
import atomcode.utility.InputUtils;

import java.util.List;

public class CRUDmanager {
    private final PokemonDAO pokemonDAO;
    private final TrainerDAO trainerDAO;

    public CRUDmanager() {
        this.pokemonDAO = new PokemonDAO();
        this.trainerDAO = new TrainerDAO();
    }

    public void printOptions() {
        System.out.println("Program started.\n");
        while(true) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - List the pokemons that belong to a given trainer");
            System.out.println("2 - List trainers that are sorted by who has how many pokemons");
            System.out.println("3 - Catch a Pokemon (select a trainer who catches, then a Pokemon that doesn't belong to anyone)");
            System.out.println("4 - Exit the program");
            System.out.println("99 - Surprise?\n");
            System.out.print("User input: ");
            final int userChoice = InputUtils.readInt();
            switch (userChoice) {
                case 1 -> {
                    System.out.println("User selected option 1 - List the pokemons that belong to a given trainer.\n");
                    readPokemonsAndTrainers();
                }
                case 2 -> {
                    System.out.println("User selected option 2 - List trainers that are sorted by who has how many pokemons.\n");
                    readTrainersAndCountPokemons();
                }
                case 3 -> {
                    System.out.println("User selected option 3 - Catch a Pokemon\n");
                    catchPokemonWithTrainer();
                }
                case 4 -> {
                    System.out.println("Good bye!");
                    return;
                }
                case 99 -> System.out.println("No surprise for today :) \n");
                default -> System.out.println("Invalid user choice.");
            }
        }
    }

    public void readPokemonsAndTrainers() {
        List<PokemonWithTrainer> pokemonsWithTrainers = pokemonDAO.listPokemonsByTrainer();
        System.out.println("Reading pokemons with given trainers initiated...\n");
        pokemonsWithTrainers.stream()
                .forEach(pokemonWithTrainer ->
                        System.out.println("Pokemon: " + pokemonWithTrainer.getPokemon().getName() +
                        ", Trainer: " + pokemonWithTrainer.getTrainer().getName()));
        System.out.println("Reading pokemons with given trainers finished.\n");
    }

    public void readTrainersAndCountPokemons() {
        List<TrainerPokemonCount> trainerPokemonCounts = trainerDAO.listTrainersPokemonsCount();
        System.out.println("Reading trainers that are sorted by who has how many pokemons initiated...\n");
        trainerPokemonCounts.stream()
                .forEach(trainerPokemonCount ->
                        System.out.println("Trainer: " + trainerPokemonCount.getTrainer().getName() +
                                ", Pokemon count: " + trainerPokemonCount.getPokemonCount()));
        System.out.println("Reading trainers sorted by who has how many pokemons finished.\n");
    }

    public void catchPokemonWithTrainer() {
        System.out.println("Catching a pokemon initiated...\n");

        System.out.println("Available trainers: ");
        List<Trainer> listOfAllTrainers = trainerDAO.readAllTrainers();
        for (int i = 0; i < listOfAllTrainers.size(); i++) {
            System.out.println(i+1 + " - " + listOfAllTrainers.get(i).getName());
        }
        String selectedTrainerName = "No name";
        int selectedTrainerId = -1;
        while (true) {
            System.out.print("Select trainer number who will be catching new pokemon: ");
            final int trainerChoice = InputUtils.readInt();
            if (trainerChoice < 1 || trainerChoice > listOfAllTrainers.size()) {
                System.out.println("Invalid choice.");
            } else {
                selectedTrainerName = listOfAllTrainers.get(trainerChoice - 1).getName();
                selectedTrainerId = listOfAllTrainers.get(trainerChoice - 1).getId();
                System.out.println("Trainer selected by the user: " + selectedTrainerName + "\n");
                break;
            }
        }

        System.out.println("Available pokemons to be caught: ");
        List<Pokemon> listUncaughtPokemons = pokemonDAO.readUncaughtPokemons();
        for (int i = 0; i < listUncaughtPokemons.size(); i++) {
            System.out.println(i+1 + " - " + listUncaughtPokemons.get(i).getName());
        }
        String selectedPokemonName = "No name";
        int selectedPokemonId = -1;
        while (true) {
            System.out.print("Select pokemon number who will be caught: ");
            final int pokemonChoice = InputUtils.readInt();
            if (pokemonChoice < 1 || pokemonChoice > listUncaughtPokemons.size()) {
                System.out.println("Invalid choice.");
            } else {
                selectedPokemonName = listUncaughtPokemons.get(pokemonChoice -1).getName();
                selectedPokemonId = listUncaughtPokemons.get(pokemonChoice - 1).getId();
                System.out.println("Pokemon selected to be caught: " + selectedPokemonName + "\n");
                break;
            }
        }

        pokemonDAO.updatePokemonWithTrainerId(selectedPokemonId, selectedTrainerId, selectedPokemonName, selectedTrainerName);

        System.out.println("New status of pokemons caught by trainers is:");
        readTrainersAndCountPokemons();
    }
}
