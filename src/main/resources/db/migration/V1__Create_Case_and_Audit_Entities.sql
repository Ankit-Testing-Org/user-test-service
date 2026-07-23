CREATE TABLE case_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(255) NOT NULL
);

CREATE TABLE audit_entity (
    id UUID PRIMARY KEY,
    case_id UUID NOT NULL,
    action VARCHAR(255) NOT NULL,
    actor VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,
    details VARCHAR(255)
);