-- Cria a sequência para IDs de usuários
CREATE SEQUENCE IF NOT EXISTS user_seq START 1 INCREMENT 1;

-- Cria a tabela de usuários
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(200) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

