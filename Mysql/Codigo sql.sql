
CREATE Database if not exists mercado;

USE mercado;

CREATE TABLE if not exists usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL 
);

CREATE TABLE if not exists produtos (
 id INT AUTO_INCREMENT PRIMARY KEY,
  nomeProduto VARCHAR(100) NOT NULL,
  datafabricao INT NOT NULL,
  dataVencimento INT NOT NULL,
  valor INT NOT NULL,
  quantidade INT NOT NULL,
  marca VARCHAR(50) NOT NULL,
  estado VARCHAR(50) NOT NULL
);

ALTER TABLE usuarios ADD COLUMN is_admin INTEGER DEFAULT 0;

select * from usuarios;
select * from produtos