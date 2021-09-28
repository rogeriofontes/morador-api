DROP TABLE IF EXISTS tb_moradores;

CREATE TABLE tb_moradores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    email VARCHAR(60) NOT NULL,
    idade INT NOT NULL
);

INSERT INTO tb_moradores (nome, email, idade) values
('Joao', 'joao@localhost.com', 88),
('Maria', 'maria@localhost.com', 66),
('Ze', 'ze@localhost.com', 34);