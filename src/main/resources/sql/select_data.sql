-- @block
USE crud_pok;
SELECT * FROM pokemon_strengths;

-- @block
USE crud_pok;
SELECT * FROM pokemons;

-- @block
USE crud_pok;
SELECT * FROM trainers;

-- @block
-- List the pokemons that belong to a given trainer
USE crud_pok;
SELECT p.name AS pokemon_name, t.name AS trainer_name
FROM pokemons p
JOIN trainers t ON p.trainer_id = t.id
WHERE p.trainer_id IS NOT NULL
ORDER BY t.name;

-- @block
-- List trainers that are sorted by who has how many pokemons
USE crud_pok;
SELECT t.name AS trainer_name, COUNT(*) AS pokemon_count
FROM pokemons p
JOIN trainers t ON p.trainer_id = t.id
WHERE p.trainer_id IS NOT NULL
GROUP BY trainer_name
ORDER BY pokemon_count DESC, trainer_name;


-- @block
-- List the Pokemons that are not caught (do not belong to anyone)
USE crud_pok;
SELECT name FROM pokemons
WHERE trainer_id IS NULL
ORDER BY name;
