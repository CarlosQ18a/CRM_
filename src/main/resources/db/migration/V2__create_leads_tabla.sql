CREATE TABLE IF NOT EXISTS leads (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    customer_id BIGINT,
    source VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
    );