DROP TABLE IF EXISTS POST;
CREATE TABLE POST( id BIGINT NOT NULL AUTO_INCREMENT,
                   text VARCHAR(255) NOT NULL,
                   creation_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                   user_id BIGINT,
                   foreign key (user_id) references POST(id));

DROP TABLE IF EXISTS USER;
CREATE TABLE USER( id BIGINT NOT NULL AUTO_INCREMENT,
                   username VARCHAR(255) NOT NULL,
                   password VARCHAR(255) NOT NULL,
                   firstname VARCHAR(255) NOT NULL,
                   lastname VARCHAR(255));

