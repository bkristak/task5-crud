-- @block
CREATE DATABASE crud_pok;

-- @block
USE crud_pok;
CREATE TABLE trainers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(35) UNIQUE NOT NULL,
  created_on DATETIME NOT NULL
);

-- @block
USE crud_pok;
CREATE TABLE pokemon_strengths (
  id INT PRIMARY KEY AUTO_INCREMENT,
  strength TINYINT NOT NULL UNIQUE CHECK (strength BETWEEN 1 AND 10),
  strength_desc VARCHAR(255) NOT NULL,
  created_on DATETIME NOT NULL
)

-- @block
USE crud_pok;
CREATE TABLE pokemons (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(35) UNIQUE NOT NULL,
  trainer_id INT,
  strength_id INT NOT NULL,
  created_on DATETIME NOT NULL,
  FOREIGN KEY (trainer_id) REFERENCES trainers(id),
  FOREIGN KEY (strength_id) REFERENCES pokemon_strengths(id)
);

