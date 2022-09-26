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
INSERT INTO artists (firstName, lastName, birthday) VALUES ('Jack','Johnson','1975-05-18');

SELECT * FROM artists;

CREATE TABLE songs
(
	songID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    genre VARCHAR(20),
    length INT,
    artistID INT,
    FOREIGN KEY (artistID) REFERENCES artists(artistID)
);

SELECT * FROM songs;


