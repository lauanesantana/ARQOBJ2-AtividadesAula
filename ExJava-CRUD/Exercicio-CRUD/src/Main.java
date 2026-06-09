public class Main {

    public static void main(String[] args) {

        Produto produto = new Produto();

        produto.cadastrarProduto(
                "Vestido Zara",
                3500.00,
                3
        );

        Cliente cliente = new Cliente();

        cliente.buscarClientePorId(1);

    }
}
/* MEU BANCO DE DADOS:::::: */ 
/* CREATE DATABASE meu_banco;

USE meu_banco;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco DECIMAL(10,2),
    quantidade INT
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);

INSERT INTO clientes (nome, email)
VALUES ('Lauane Alves', 'lauane@email.com'); */ 