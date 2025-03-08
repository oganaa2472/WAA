-- USERS

INSERT INTO user_details_model (id, username, password)
VALUES (111, 'uinan@miu.edu',  '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO user_details_model (id, username, password)
VALUES (112, 'john@miu.edu',  '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (113, 'muhyidean@miu.edu', 'muhyidean', 'al-tarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
--
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (114, 'levi@miu.edu', 'keith', 'levi', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
--
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (115, 'okalu@miu.edu', 'obinna', 'kalu', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
--
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (116, 'tina@miu.edu', 'tina', 'xing', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO authority (id, role)
VALUES (1, 'ADMIN');
INSERT INTO authority (id, role)
VALUES (2, 'CLIENT');

INSERT INTO user_details_model_authorities (user_details_model_id, authorities_id)
VALUES (111, 1);
INSERT INTO user_details_model_authorities (user_details_model_id, authorities_id)
VALUES (112, 1);
INSERT INTO user_details_model_authorities (user_details_model_id, authorities_id)
VALUES (111, 2);

-- Posts
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (111,'iPhone',
--         'inserts users into the database when the app starts','test', 111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (112, 'iPad', 'that inserts users into the database when the app starts','test', 111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (113, 'Speakers',  'that inserts users into the database when the app starts','test', 111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (114, 'SD Card',  'that inserts users into the database when the app starts','test', 111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (115, 'Fridge',  'that inserts users into the database when the app starts','test',111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (116, 'Smart TV',  'that inserts users into the database when the app starts','test', 111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (117, 'MacBook',  'that inserts users into the database when the app starts','test',111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (118, 'Smart Watch',  'that inserts users into the database when the app starts','test', 111);
--
-- INSERT INTO posts (id, name,content, author, user_id)
-- VALUES (119, 'Pen', 'that inserts users into the database when the app starts','test new', 112);
--
-- -- Comments
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (111,'awesome phone',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (112,'awesome !',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (113,'it sucks',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (114,'its great',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (115,'awesome phone',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (116,'amazing phone',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (117,'awesome phone',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (118,'amazing phone',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (119,'awesome phone',111);
--
-- INSERT INTO comment (id,name,post_id)
-- VALUES (120,'amazing phone',111);
-- --
-- --
-- INSERT INTO REVIEW (id,comment,number_of_stars,product_id)
-- VALUES (11,'awesome tablet',5,112);
