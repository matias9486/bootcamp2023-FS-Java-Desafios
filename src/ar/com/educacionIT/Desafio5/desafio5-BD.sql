CREATE DATABASE IF NOT EXISTS `desafio5`;
USE `desafio5`;

#CREAR TABLAS
CREATE TABLE IF NOT EXISTS `placeholder` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT,
  `name` VARCHAR(45),
  `userName` VARCHAR(45),
  `email` VARCHAR(45),
  `phone` VARCHAR(45),
  `website` VARCHAR(45),
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS  `pokemon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pokemonId` INT,
  `name` VARCHAR(45),
  `height` INT,
  `weight` VARCHAR(45),
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `covid` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` INT,
  `states` INT,
  `positive` INT,
  `negative` INT,
  `pending` INT,
  `death` INT,
  `hospitalized` INT,
  `totalTestResults` INT,  
  PRIMARY KEY (`id`));