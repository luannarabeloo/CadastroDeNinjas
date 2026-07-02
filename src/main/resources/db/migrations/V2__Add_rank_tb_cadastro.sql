-- V2: Migrations para adcionar a coluna rank na tabela tb_cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);