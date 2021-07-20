USE digital_innovation_one;

CREATE TABLE curso(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    duracao_horas FLOAT NOT NULL
);

INSERT INTO curso(nome, duracao_horas) VALUES('HTML5', 2);
INSERT INTO curso(nome, duracao_horas) VALUES('CSS3', 4);
INSERT INTO curso(nome, duracao_horas) VALUES('FLEXBOX', 6);

SELECT * FROM curso;