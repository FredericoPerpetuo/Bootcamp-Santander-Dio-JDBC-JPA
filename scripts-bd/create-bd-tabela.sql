CREATE database filme_library;

USE filme_library;

CREATE TABLE aluno (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR(80) NOT NULL,
    ano INTEGER NOT NULL,
    pais VARCHAR(80) NOT NULL,
    diretor VARCHAR(80) NOT NULL
);
