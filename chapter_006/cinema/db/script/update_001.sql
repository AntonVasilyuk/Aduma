CREATE TABLE IF NOT EXISTS halls (id SERIAL PRIMARY KEY, row INT NOT NULL ,
        place INT NOT NULL , occupied VARCHAR(10) NOT NULL, userID INT);

CREATE TABLE IF NOT EXISTS accounts (id SERIAL PRIMARY KEY, name VARCHAR(50) ,
              phone VARCHAR(15) NOT NULL, idPlace INT NOT NULL );

INSERT INTO halls (id, row, place, occupied) VALUES (11, 1, 1, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (12, 1, 2, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (13, 1, 3, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (21, 2, 1, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (22, 2, 2, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (23, 2, 3, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (31, 3, 1, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (32, 3, 2, 'free' );
INSERT INTO halls (id, row, place, occupied) VALUES (33, 3, 3, 'free' );
