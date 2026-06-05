CREATE SEQUENCE IF NOT EXISTS cartitem_seq START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS cartitem (
    id BIGINT PRIMARY KEY DEFAULT nextval('cartitem_seq'),
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_cartitem_user FOREIGN KEY (user_id) REFERENCES users(id)
);