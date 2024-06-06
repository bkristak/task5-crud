package atomcode.db;

import org.slf4j.Logger;

import javax.xml.transform.Result;

import static org.slf4j.LoggerFactory.getLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {
    private static final String READ_POKEMON_WITH_TRAINER = "SELECT p.name AS pokemon_name, t.name AS trainer_name " +
            "FROM pokemons p " +
            "JOIN trainers t ON p.trainer_id = t.id " +
            "WHERE p.trainer_id IS NOT NULL " +
            "ORDER BY t.name;";
    private static final String READ_UNCAUGHT_POKEMON = "SELECT name AS pokemon_name, id AS pokemon_id " +
            "FROM pokemons " +
            "WHERE trainer_id IS NULL " +
            "ORDER BY pokemon_name;";
    private static final String UPDATE_POKEMON_WITH_TRAINER_ID = "UPDATE pokemons " +
            "SET trainer_id=? " +
            "WHERE id=?;";
    private static final Logger logger = getLogger(PokemonDAO.class);

    public void updatePokemonWithTrainerId(int selectedPokemonId, int selectedTrainerId, String selectedPokemonName, String selectedTrainerName) {
        System.out.println("Pokemon is being catched...\n");
        System.out.println("trainer id = " + selectedTrainerId);
        System.out.println("pokmeon id = " + selectedPokemonId);
       try (
               Connection connection = HikariCPDataSource.getConnection();
               PreparedStatement statement = connection.prepareStatement(UPDATE_POKEMON_WITH_TRAINER_ID);
               ) {
            statement.setInt(1, selectedTrainerId);
            statement.setInt(2, selectedPokemonId);
            statement.executeUpdate();
           System.out.println("Pokemon " + selectedPokemonName + " has been caught by trainer " + selectedTrainerName + "!\n");
       } catch (SQLException e) {
            logger.error("Error updading data:" + e);
       }
    }

    public List<Pokemon> readUncaughtPokemons() {
        List<Pokemon> listUncaughtPokemons = new ArrayList<>();
        try (
                Connection connection = HikariCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_UNCAUGHT_POKEMON);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String pokemonName = resultSet.getString("pokemon_name");
                int pokemonId = resultSet.getInt("pokemon_id");
                Pokemon pokemon = new Pokemon();
                pokemon.setName(pokemonName);
                pokemon.setId(pokemonId);
                listUncaughtPokemons.add(pokemon);
            }
        } catch (SQLException e) {
            logger.error("Error reading data: " + e);
        }
        return listUncaughtPokemons;
    }

    public List<PokemonWithTrainer> listPokemonsByTrainer() {
        List<PokemonWithTrainer> pokemonsWithTrainers = new ArrayList<>();
        try (
                Connection connection = HikariCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_POKEMON_WITH_TRAINER);
                ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String pokemonName = resultSet.getString("pokemon_name");
                    String trainerName = resultSet.getString("trainer_name");

                    Pokemon pokemon = new Pokemon();
                    pokemon.setName(pokemonName);
                    Trainer trainer = new Trainer();
                    trainer.setName(trainerName);

                    PokemonWithTrainer pokemonWithTrainer = new PokemonWithTrainer(pokemon, trainer);
                    pokemonsWithTrainers.add(pokemonWithTrainer);

                }
        } catch (SQLException e) {
            logger.error("Error reading data.", e);
        }
        return pokemonsWithTrainers;
    }
}
