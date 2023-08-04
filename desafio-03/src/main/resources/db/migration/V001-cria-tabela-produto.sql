CREATE TABLE produto
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    nome    VARCHAR(100) NOT NULL,
    preco   DOUBLE       NOT NULL,
    estoque INT          NOT NULL
);
