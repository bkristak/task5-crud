-- @block
USE crud_pok;
INSERT INTO trainers (name, created_on) VALUES
    ('trainer1', CURRENT_DATE),
    ('trainer2', CURRENT_DATE),
    ('trainer3', CURRENT_DATE),
    ('trainer4', CURRENT_DATE),
    ('trainer5', CURRENT_DATE),
    ('trainer6', CURRENT_DATE);

-- @block
USE crud_pok;
INSERT INTO pokemon_strengths (strength, strength_desc, created_on) VALUES
    (1, 'weak', CURRENT_DATE),
    (2, 'moderate', CURRENT_DATE),
    (3, 'average', CURRENT_DATE),
    (4, 'strong', CURRENT_DATE),
    (5, 'stronger than strong', CURRENT_DATE);

-- @block
USE crud_pok;
INSERT INTO pokemons (name, trainer_id, strength_id, created_on) VALUES
    ('pokemon1', NULL, 1, CURRENT_DATE),
    ('pokemon2', NULL, 3, CURRENT_DATE),
    ('pokemon3', 2, 4, CURRENT_DATE),
    ('pokemon4', 5, 3, CURRENT_DATE),
    ('pokemon5', NULL, 2, CURRENT_DATE),
    ('pokemon6', 3, 5, CURRENT_DATE),
    ('pokemon7', NULL, 1, CURRENT_DATE),
    ('pokemon8', 4, 5, CURRENT_DATE),
    ('pokemon9', 1, 3, CURRENT_DATE),
    ('pokemon10', 6, 2, CURRENT_DATE);

