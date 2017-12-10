DROP TABLE IF EXISTS USER;
CREATE TABLE USER( id BIGINT NOT NULL PRIMARY KEY,
                   username VARCHAR(255) NOT NULL,
                   password VARCHAR(255) NOT NULL,
                   firstname VARCHAR(255) NOT NULL,
                   lastname VARCHAR(255));

DROP TABLE IF EXISTS POST;
CREATE TABLE POST( id VARCHAR(255),
                   text VARCHAR(255) NOT NULL,
                   creation_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                   user_id BIGINT,
                   city VARCHAR(255),
                   latitude DECIMAL(9,6),
                   longitude DECIMAL(9,6),
                   temperature DOUBLE,
                   foreign key (user_id) references USER(id));