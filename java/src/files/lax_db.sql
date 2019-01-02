
CREATE DATABASE IF NOT EXISTS  `lax_db`;
USE `lax_db`;


-- users table
-- users SEND issues
-- users HAVE roles:
-- Manager, Designer, Developer
-- PASSWORD holds 64 hexadecimal digits to represent the user's password
CREATE TABLE IF NOT EXISTS `users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `fullName` VARCHAR(50) NOT NULL,
    `username` VARCHAR(10) NOT NULL,
    `password` VARCHAR(64) NOT NULL,
    `role` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
);

-- issues table
-- issues HAVE users
CREATE TABLE IF NOT EXISTS `issues` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `content` VARCHAR(250) NOT NULL,
    `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `lax_db`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);