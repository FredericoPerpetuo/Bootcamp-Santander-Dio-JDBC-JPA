CREATE TABLE livro (
    id SMALLSERIAL NOT NULL,
	titulo VARCHAR(80) NOT NULL,
    autor VARCHAR(80) NOT NULL,
	editora VARCHAR(80) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO livro (titulo, autor, editora) VALUES ('Olhai os lírios do campo', 'Érico Veríssimo', 'Companhia das Letras');
INSERT INTO livro (titulo, autor, editora) VALUES ('Dom Casmurro', 'Machado de Assis', 'Editora Moderna');
INSERT INTO livro (titulo, autor, editora) VALUES ('1984', 'George Orwell', 'Companhia de Bolso');


SELECT * FROM livro;