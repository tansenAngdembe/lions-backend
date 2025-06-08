-- liquibase formatted sql
-- changeset ayush:1

CREATE TABLE IF NOT EXISTS events (
     id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     event_date DATE NOT NULL,
     event_title VARCHAR(255) NOT NULL,
    event_description TEXT,
    event_location VARCHAR(255),
    event_time VARCHAR(250),
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    )