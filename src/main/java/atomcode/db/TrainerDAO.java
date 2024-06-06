package atomcode.db;

import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class TrainerDAO {
    private static String READ_TRAINERS_POKEMON_COUNT = "SELECT t.name AS trainer_name, COUNT(*) AS pokemon_count " +
            "FROM pokemons p " +
            "JOIN trainers t ON p.trainer_id = t.id " +
            "WHERE p.trainer_id IS NOT NULL " +
            "GROUP BY t.name " +
            "ORDER BY pokemon_count DESC, t.name";
    private static String READ_ALL_TRAINERS = "SELECT name AS trainer_name, id AS trainer_id " +
            "FROM trainers " +
            "ORDER BY trainer_name;";

    private static final Logger logger = getLogger(TrainerDAO.class);

    public List<Trainer> readAllTrainers() {
        List<Trainer> listOfAllTrainers = new ArrayList<>();
        try(
                Connection connection = HikariCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_ALL_TRAINERS);
                ResultSet resultSet = statement.executeQuery();
                ) {
            while (resultSet.next()) {
                String trainerName = resultSet.getString("trainer_name");
                int trainerId = resultSet.getInt("trainer_id");
                Trainer trainer = new Trainer();
                trainer.setName(trainerName);
                trainer.setId(trainerId);
                listOfAllTrainers.add(trainer);
            }
        } catch (SQLException e) {
            logger.error("Error reading data: " + e);
        }
        return listOfAllTrainers;
    }

    public List<TrainerPokemonCount> listTrainersPokemonsCount () {
        List<TrainerPokemonCount> trainerPokemonCounts = new ArrayList<>();
        try (
                Connection connection = HikariCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_TRAINERS_POKEMON_COUNT);
                ResultSet resultSet = statement.executeQuery();
                ) {
            while (resultSet.next()) {
             String trainerName = resultSet.getString("trainer_name");
             int pokemonCount = resultSet.getInt("pokemon_count");

             Trainer trainer = new Trainer();
             trainer.setName(trainerName);
             TrainerPokemonCount trainerPokemonCount = new TrainerPokemonCount(trainer, pokemonCount);

             trainerPokemonCounts.add(trainerPokemonCount);

            }
        } catch (SQLException e) {
            logger.error("Error reading data. " + e);
        }
        return trainerPokemonCounts;
    }

}
