-- liquibase formatted sql

-- liquibase formatted sql

-- changeset mihailfedorov:1646554716000-1
CREATE TABLE captcha_codes (id INT NOT NULL, code TINYTEXT NOT NULL, secret_code TINYTEXT NOT NULL, time datetime NOT NULL, CONSTRAINT PK_CAPTCHA_CODES PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-2
CREATE TABLE global_settings (id INT NOT NULL, code VARCHAR(255) NOT NULL, name VARCHAR(255) NOT NULL, value VARCHAR(255) NOT NULL, CONSTRAINT PK_GLOBAL_SETTINGS PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-3
CREATE TABLE hibernate_sequence (next_val BIGINT NULL);

-- changeset mihailfedorov:1646554716000-4
CREATE TABLE post_comments (id INT NOT NULL, text TEXT NOT NULL, time datetime NOT NULL, parent_id INT NULL, post_id INT NULL, user_id INT NOT NULL, CONSTRAINT PK_POST_COMMENTS PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-5
CREATE TABLE post_votes (id INT AUTO_INCREMENT NOT NULL, time datetime NOT NULL, value TINYINT(3) NOT NULL, post_id_id INT NOT NULL, user_id_id INT NOT NULL, CONSTRAINT PK_POST_VOTES PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-6
CREATE TABLE posts (id INT NOT NULL, is_active TINYINT(3) NOT NULL, moderation_status VARCHAR(255) NOT NULL, text TEXT NOT NULL, time datetime NOT NULL, title VARCHAR(255) NOT NULL, view_count INT NOT NULL, moderator_id INT NULL, user_id INT NULL, CONSTRAINT PK_POSTS PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-7
CREATE TABLE tag2post (id INT NOT NULL, post_id_id INT NOT NULL, tag_id_id INT NOT NULL, CONSTRAINT PK_TAG2POST PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-8
CREATE TABLE tags (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NOT NULL, CONSTRAINT PK_TAGS PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-9
CREATE TABLE users (id INT NOT NULL, code VARCHAR(255) NULL, email VARCHAR(255) NOT NULL, is_moderator TINYINT(3) NOT NULL, name VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, photo TEXT NULL, reg_time datetime NOT NULL, CONSTRAINT PK_USERS PRIMARY KEY (id));

-- changeset mihailfedorov:1646554716000-10
INSERT INTO hibernate_sequence (next_val) VALUES (1),(1),(1),(1),(1),(1);;

-- changeset mihailfedorov:1646554716000-11
INSERT INTO post_comments (id, text, time, parent_id, post_id, user_id) VALUES (1, 'comment1', '2017-12-31T12:04:01', NULL, 1, 1),(2, 'comment', '2017-12-31T12:04:01', NULL, 1, 2),(3, 'comment', '2017-12-31T12:04:01', 2, 1, 3),(4, 'comment', '2017-12-31T12:04:01', NULL, 1, 4),(5, 'comment', '2017-12-31T12:04:01', NULL, 1, 3),(6, 'comment', '2017-12-31T12:04:01', NULL, 2, 4),(7, 'comment', '2017-12-31T12:04:01', NULL, 2, 1),(8, 'comment', '2017-12-31T12:04:01', 7, 2, 2),(9, 'comment', '2017-12-31T12:04:01', 8, 2, 3),(10, 'comment', '2017-12-31T12:04:01', NULL, 2, 4),(11, 'comment', '2017-12-31T12:04:01', NULL, 2, 1),(12, 'comment', '2017-12-31T12:04:01', NULL, 3, 2),(13, 'comment', '2017-12-31T12:04:01', NULL, 4, 1),(14, 'comment', '2017-12-31T12:04:01', NULL, 5, 2),(15, 'comment', '2017-12-31T12:04:01', NULL, 5, 3),(16, 'comment', '2017-12-31T12:04:01', NULL, 5, 4),(17, 'comment', '2017-12-31T12:04:01', NULL, 6, 1),(18, 'comment', '2017-12-31T12:04:01', NULL, 6, 2);;

-- changeset mihailfedorov:1646554716000-12
INSERT INTO post_votes (id, time, value, post_id_id, user_id_id) VALUES (1, '2014-12-31T12:04:01', 1, 1, 1),(2, '2014-01-23T12:04:01', -1, 1, 2),(3, '2014-02-23T12:04:01', 1, 1, 3),(4, '2014-03-23T12:04:01', -1, 2, 3),(5, '2014-04-19T12:04:01', 1, 3, 4),(6, '2014-05-08T12:04:01', -1, 4, 2),(7, '2014-06-05T12:04:01', 1, 5, 3);;

-- changeset mihailfedorov:1646554716000-13
INSERT INTO posts (id, is_active, moderation_status, text, time, title, view_count, moderator_id, user_id) VALUES (1, 1, 'ACCEPTED', 'Текст поста №1', '2012-12-31T12:04:01', 'Пост №1', 12, 2, 1),(2, 0, 'NEW', 'Текст поста №2', '2013-12-31T12:04:01', 'Пост №2', 0, 2, 2),(3, 1, 'ACCEPTED', 'Текст поста №3', '2014-12-31T12:04:01', 'Пост №3', 34, 1, 4),(4, 1, 'ACCEPTED', 'Текст поста №4', '2015-12-31T12:04:01', 'Пост №4', 7, 3, 1),(5, 0, 'DECLINED', 'Текст поста №5', '2016-12-31T12:04:01', 'Пост №5', 12, 2, 3),(6, 1, 'ACCEPTED', 'Текст поста №6', '2017-12-31T12:04:01', 'Пост №6', 12, 3, 1);;

-- changeset mihailfedorov:1646554716000-14
INSERT INTO tag2post (id, post_id_id, tag_id_id) VALUES (1, 1, 1),(2, 2, 2),(3, 3, 2),(4, 4, 5),(5, 5, 7),(6, 6, 6),(7, 1, 6),(8, 2, 6),(9, 3, 3),(10, 4, 3),(11, 5, 4),(12, 6, 4),(13, 1, 1),(14, 2, 1),(15, 3, 7),(16, 4, 7);;

-- changeset mihailfedorov:1646554716000-15
INSERT INTO tags (id, name) VALUES (1, 'Новости'),(2, 'Слухи'),(3, 'Истории'),(4, 'События'),(5, 'Спорт'),(6, 'Игры'),(7, 'Авто');;

-- changeset mihailfedorov:1646554716000-16
INSERT INTO users (id, code, email, is_moderator, name, password, reg_time) VALUES (1, '', 'user1@mail.com', 1, 'user1', '1', '1998-12-31T00:00'),(2, '', 'user2@mail.com', 1, 'user2', '1', '1999-12-31T00:00'),(3, '', 'user3@mail.com', 1, 'user3', '1', '2000-12-31T00:00'),(4, '', 'user4@mail.com', 0, 'user4', '1', '2001-12-31T00:00');;

-- changeset mihailfedorov:1646554716000-17
CREATE INDEX FK3w1tccwvbve5dxagef0o8ij5d ON tag2post(tag_id_id);

-- changeset mihailfedorov:1646554716000-18
CREATE INDEX FK5lidm6cqbc7u4xhqpxm898qme ON posts(user_id);

-- changeset mihailfedorov:1646554716000-19
CREATE INDEX FK6m7nr3iwh1auer2hk7rd05riw ON posts(moderator_id);

-- changeset mihailfedorov:1646554716000-20
CREATE INDEX FKa95djnmk3mqwa11yidm8kpq95 ON tag2post(post_id_id);

-- changeset mihailfedorov:1646554716000-21
CREATE INDEX FKaawaqxjs3br8dw5v90w7uu514 ON post_comments(post_id);

-- changeset mihailfedorov:1646554716000-22
CREATE INDEX FKc3b7s6wypcsvua2ycn4o1lv2c ON post_comments(parent_id);

-- changeset mihailfedorov:1646554716000-23
CREATE INDEX FKksqs5aonajvsg58njqjyvvrvb ON post_votes(user_id_id);

-- changeset mihailfedorov:1646554716000-24
CREATE INDEX FKrxv1qti7a7o46mv7b28gate2o ON post_votes(post_id_id);

-- changeset mihailfedorov:1646554716000-25
CREATE INDEX FKsnxoecngu89u3fh4wdrgf0f2g ON post_comments(user_id);

-- changeset mihailfedorov:1646554716000-26
ALTER TABLE tag2post ADD CONSTRAINT FK3w1tccwvbve5dxagef0o8ij5d FOREIGN KEY (tag_id_id) REFERENCES tags (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-27
ALTER TABLE posts ADD CONSTRAINT FK5lidm6cqbc7u4xhqpxm898qme FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-28
ALTER TABLE posts ADD CONSTRAINT FK6m7nr3iwh1auer2hk7rd05riw FOREIGN KEY (moderator_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-29
ALTER TABLE tag2post ADD CONSTRAINT FKa95djnmk3mqwa11yidm8kpq95 FOREIGN KEY (post_id_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-30
ALTER TABLE post_comments ADD CONSTRAINT FKaawaqxjs3br8dw5v90w7uu514 FOREIGN KEY (post_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-31
ALTER TABLE post_comments ADD CONSTRAINT FKc3b7s6wypcsvua2ycn4o1lv2c FOREIGN KEY (parent_id) REFERENCES post_comments (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-32
ALTER TABLE post_votes ADD CONSTRAINT FKksqs5aonajvsg58njqjyvvrvb FOREIGN KEY (user_id_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-33
ALTER TABLE post_votes ADD CONSTRAINT FKrxv1qti7a7o46mv7b28gate2o FOREIGN KEY (post_id_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset mihailfedorov:1646554716000-34
ALTER TABLE post_comments ADD CONSTRAINT FKsnxoecngu89u3fh4wdrgf0f2g FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

