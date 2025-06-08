-- liquibase formatted sql
-- changeset ayush:1
-- preconditions onFail="CONTINUE" onError="HALT"

CREATE TABLE IF NOT EXISTS profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    member_number VARCHAR(50) NOT NULL,
    address VARCHAR(500) NOT NULL,
    category VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL,
    priority INT NOT NULL,
    image LONGBLOB NOT NULL,
    is_deleted BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
