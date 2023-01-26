INSERT INTO produto
(id, sku, nome)
VALUES
    (1, 'SKU0001', 'Placa de vídeo'),
    (2, 'SKU0002', 'Memória RAM'),
    (3, 'SKU0003', 'SSD'),
    (4, 'SKU0004', 'Placa Mãe'),
    (5, 'SKU0005', 'Processador'),
    (6, 'SKU0006', 'Gabinete');

INSERT INTO cliente
(id, cpf, nome)
VALUES
    (1, '12345678901', 'João Silva'),
    (2, '23456789012', 'Maria Costa'),
    (3, '34567890123', 'José Ferreira');

INSERT INTO carrinho
(id, datahora, total, cliente_id)
VALUES
    (1, '2022-01-22 15:01:00', 150, 1),
    (2, '2022-01-11 16:44:00', 230, 2),
    (3, '2022-01-22 17:33:00', 160, 3),
    (4, '2022-01-12 11:41:00', 170, 1),
    (5, '2022-01-21 12:14:00', 930, 2),
    (6, '2022-01-04 17:51:00', 530, 3);


INSERT INTO endereco
(id, cep, logradouro, numero, bairro, cidade, uf, cliente_id)
VALUES
    (1, '12345678', 'Rua dos Bobos', '0', 'Bairro dos Bobos', 'Cidade dos Bobos', 'PR', 1),
    (2, '87654321', 'Avenida das Flores', '1', 'Bairro das Flores', 'Cidade das Flores', 'PR', 2),
    (3, '11111111', 'Rua dos Pássaros', '2', 'Bairro dos Pássaros', 'Cidade dos Pássaros', 'PR', 3),
    (4, '33333333', 'Rua dos Animais', '4', 'Bairro dos Animais', 'Cidade dos Animais', 'PR', 1),
    (5, '66666666', 'Avenida das Montanhas', '7', 'Bairro das Montanhas', 'Cidade das Montanhas', 'PR', 3),
    (6, '56789098', 'Rua das Árvores', '2', 'Bairro das Árvores', 'Cidade das Árvores', 'PR', 2);

INSERT INTO preco
(id, valor, produto_id, cliente_id)
VALUES
    (1, 530, 2, 3),
    (2, 254, 3, 2),
    (3, 302, 1, 1),
    (4, 501, 2, 2),
    (5, 256, 3, 1),
    (6, 322, 1, 3),
    (7, 555, 2, 1),
    (8, 251, 3, 3),
    (9, 302, 1, 2);

INSERT INTO item
(id, quantidade, total, produto_id, preco_id, carrinho_id)
VALUES
    (1, 100, 10, 1, 1, 3),
    (2, 99, 40, 2, 3, 2),
    (3, 122, 90, 3, 2, 1),
    (4, 111, 100, 1, 4, 3),
    (5, 520, 500, 2, 5, 2),
    (6, 333, 300, 3, 6, 1);

