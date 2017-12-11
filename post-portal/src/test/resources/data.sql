INSERT INTO USER VALUES(3, 'jonny', '123', 'John', 'Huge');
INSERT INTO USER VALUES(4, 'franky', '123', 'Frank', 'Sinatra');


INSERT INTO POST VALUES('1w12wws', null, 'Hello', {ts '2017-12-07 18:47:52.69'}, 3, 'Montreal', 12.21, 22.22, 12);
INSERT INTO POST VALUES('aaaaaaa', null, 'Hello', {ts '2017-12-10 18:47:52.69'}, 4, 'Montreal', 12.21, 22.22, 12);
INSERT INTO POST VALUES('bbbbbbb', 'aaaaaaa', 'Bonjour', {ts '2017-12-10 19:47:52.69'}, 4, 'Montreal', 12.21, 22.22, 2);
INSERT INTO POST VALUES('ccccccc', 'bbbbbbb', 'Salam', {ts '2017-12-10 20:52:52.69'}, 4, 'Tehran', 12.21, -22.22, 21);
INSERT INTO POST VALUES('ddddddd', null, 'Bye', {ts '2017-12-10 18:52:52.69'}, 4, 'Toronto', 12.21, 22.22, -21);

