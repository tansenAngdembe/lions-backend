-- liquibase formatted sql
-- changeset ayush:1

INSERT INTO admins (email, password, is_admin)
VALUES ('admin@admin.com', '$2a$12$tf2Pzhe3pJnsDftI2XTQn.mF.fEmerT5tOALdCaMxAk95s5OTk4YK', TRUE);
