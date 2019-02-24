<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd
    http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd">
    logicalFilePath="create.sql">
    <changeSet id="1" author="Duma">
      <sql>
        CREATE TABLE IF NOT EXISTS halls (id SERIAL PRIMARY KEY, row INT NOT NULL ,
                place INT NOT NULL , occupied VARCHAR(10) NOT NULL, userID INT);

        CREATE TABLE IF NOT EXISTS accounts (id SERIAL PRIMARY KEY, name VARCHAR(50) ,
                      phone VARCHAR(15) NOT NULL, idPlace INT NOT NULL );

        INSERT INTO halls (row, place, occupied) VALUES (1, 1, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (1, 2, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (1, 3, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (2, 1, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (2, 2, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (2, 3, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (3, 1, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (3, 2, 'free' );
        INSERT INTO halls (row, place, occupied) VALUES (3, 3, 'free' );
      </sql>
    </changeSet>
</databaseChangeLog>
