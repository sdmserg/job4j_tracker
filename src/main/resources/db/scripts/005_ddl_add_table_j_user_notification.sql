CREATE TABLE j_user_notification (
    id SERIAL PRIMARY KEY,
    messenger TEXT,
    identify TEXT,
    j_user_id INT REFERENCES j_user(id)
);