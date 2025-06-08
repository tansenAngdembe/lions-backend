-- liquibase formatted sql
-- changeset ayush:1

CREATE TABLE IF NOT EXISTS clubs (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    club_name VARCHAR(255) NOT NULL,
    club_id VARCHAR(255) NOT NULL,
    chartered_date DATE NOT NULL,
    member BIGINT NOT NULL,
    extension_chairperson VARCHAR(200),
    guiding_lion_one VARCHAR(200),
    guiding_lion_two VARCHAR(200),
    total_member BIGINT,
    member_added BIGINT,
    member_dropped BIGINT,
    district_multiple VARCHAR(255),
    logo_url LONGTEXT,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
