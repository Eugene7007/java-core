-- Создаем таблицу клиентов
CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         full_name VARCHAR(100) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создаем таблицу счетов
CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          client_id INT REFERENCES clients(id),
                          balance NUMERIC(12, 2) DEFAULT 0
);

-- Добавим тестовые данные
INSERT INTO clients (full_name) VALUES ('Ivan Petrov'), ('Anna Ivanova');
INSERT INTO accounts (client_id, balance) VALUES (1, 1000.00), (2, 500.00);

CREATE OR REPLACE PROCEDURE add_bonus(
    p_client_id INT,
    p_bonus NUMERIC(12,2) DEFAULT 50.00
)
    LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE accounts
    SET balance = balance + p_bonus
    WHERE client_id = p_client_id;
END;
$$;