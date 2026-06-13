CREATE TABLE participates (
    id SERIAL PRIMARY KEY,
    item_id INT NOT NULL REFERENCES items(id),
    user_id INT NOT NULL REFERENCES j_user(id),
    UNIQUE(item_id, user_id)
);