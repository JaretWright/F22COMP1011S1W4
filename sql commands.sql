CREATE DATABASE F22;
USE F22;
DROP TABLE artists;
CREATE TABLE artists
(
	artistID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	firstName VARCHAR(30),
    lastName VARCHAR(30),
    birthday DATE
);

INSERT INTO artists (firstName, lastName, birthday) VALUES ('Rihanna','Rihanna','1988-02-20');
INSERT INTO artists (firstName, lastName, birthday) VALUES ('Bruno','Mars','1985-10-08');
INSERT INTO artists (firstName, lastName, birthday) VALUES ('Michael','Jackson','1958-08-29');
INSERT INTO artists (firstName, lastName, birthday) VALUES ('Freddie','Mercury','1946-09-05');

SELECT * FROM artists;

