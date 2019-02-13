CREATE TABLE users (
  id              SERIAL PRIMARY KEY,
  username           VARCHAR(100) NOT NULL,
  password  VARCHAR(100) NULL
);

INSERT into users (id, username, password)
    values (1,'juan', 'pedro'),
           (2,'juancho', 'pedrodo');