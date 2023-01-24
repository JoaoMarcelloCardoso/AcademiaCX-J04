INSERT INTO tb_department(name, type) VALUES ('Gestão', 'Administrativo');

INSERT INTO tb_department(name, type) VALUES ('Informática', 'TI');


INSERT INTO tb_user(department_id, name, email, username, password) VALUES (1, 'Maria', 'maria@gmail.com', 'maria', '$2a$10$GPNmzVYog.Q81JrX3DXh/.z2Zz7e3O0luuYBuEGls05kkcwZlkmy2');

INSERT INTO tb_user(department_id, name, email, username, password) VALUES (1, 'Bob', 'bob@gmail.com', 'bob', '$2a$10$SbzS94gwPiSUmi535IQjS.jo0xeLwq38QRGOPLW6616CTs.aHXotu');

INSERT INTO tb_user(department_id, name, email, username, password) VALUES (2, 'Alex', 'alex@gmail.com', 'alex', '$2a$10$SbzS94gwPiSUmi535IQjS.jo0xeLwq38QRGOPLW6616CTs.aHXotu');

INSERT INTO tb_user(department_id, name, email, username, password) VALUES (2, 'Ana', 'ana@gmail.com', 'ana', '$2a$10$SbzS94gwPiSUmi535IQjS.jo0xeLwq38QRGOPLW6616CTs.aHXotu');
