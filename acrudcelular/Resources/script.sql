CREATE DATABASE agenda;

CREATE TABLE contatos( 
id int not null auto_increment primary key,
nome VARCHAR(40),
idade int,
dataCadastro DATE
)