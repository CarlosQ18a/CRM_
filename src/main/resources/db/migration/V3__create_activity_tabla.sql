-- Crear la tabla activity
CREATE TABLE IF NOT EXISTS activity (
                                        id SERIAL PRIMARY KEY,
                                        description VARCHAR(255) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lead_id BIGINT,
    FOREIGN KEY (lead_id) REFERENCES leads(id)
    );
