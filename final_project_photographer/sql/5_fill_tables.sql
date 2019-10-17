USE photographer;

INSERT INTO user (email, password, name, phone_number, role)
VALUES ('somemail1@gmail.com', 'Aa123+', 'Nata', '+375-29-255-04-62', 2);
INSERT INTO user (email, password, name, phone_number, role)
VALUES ('somemail2@gmail.com', 'Aa123+', 'Dina', '+375-29-255-04-62', 2);
INSERT INTO user (email, password, name, phone_number, role)
VALUES ('somemail3@gmail.com', 'Aa123+', 'Michael', '+375-29-255-04-62', 2);

INSERT INTO localized_text(id, russian)
VALUES (1, 'Love story');
INSERT INTO localized_text(id, russian)
VALUES (2, 'Свадьба');
INSERT INTO localized_text(id, russian)
VALUES (3, 'Портрет');
INSERT INTO localized_text(id, russian)
VALUES (4, 'Семейная');
INSERT INTO localized_text(id, russian)
VALUES (5, 'Студия');
INSERT INTO localized_text(id, russian)
VALUES (6, 'Дети');
INSERT INTO localized_text(id, russian)
VALUES (7, 'Беременность');
INSERT INTO localized_text(id, russian)
VALUES (8, 'Ирина и Кирилл');
INSERT INTO localized_text(id, russian)
VALUES (9, 'Прекраснейшее событие в жизни молодых! Хочется, чтобы
оно отложилось в нашей памяти только яркими воспоминаниями,
а чтобы эти воспоминания можно было сохранить для своих детей, внуков и даже правнуко');
INSERT INTO localized_text(id, russian)
VALUES (10, 'Сказка Анжелы');
INSERT INTO localized_text(id, russian)
VALUES (11, 'Индивидуальная фотосессия в студии в студии ARt');
INSERT INTO localized_text(id, russian)
VALUES (12, 'Маленький Петенька');
INSERT INTO localized_text(id, russian)
VALUES (13, 'Пустая дата');
INSERT INTO localized_text(id, russian)
VALUES (14, 'Описание в пустая дата');
INSERT INTO localized_text(id, russian)
VALUES (15, 'Описание в пустое имя');

INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (1, '/img/lovestory.jpg', 1);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (2, '/img/wedding.jpg', 2);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (3, '/img/portrait.jpg', 3);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (4, '/img/family.jpg', 4);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (5, '/img/studio.jpg', 5);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (6, '/img/baby.jpg', 6);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (7, '/img/pregnancy.jpg', 7);

INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (1, '/img/lovestory.jpg', '2018-07-01', 8, 9, 1);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (2, '/img/lovestory.jpg', '2018-09-11', 10, 11, 2);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (3, '/img/lovestory.jpg', '2018-11-23', 12, null, 3);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (4, '/img/lovestory.jpg', null, 13, 14, 3);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (5, '/img/lovestory.jpg', '2019-07-09', null, 15, 3);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (6, '/img/lovestory.jpg', '2018-07-01', 8, 9, 3);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (7, '/img/lovestory.jpg', '2018-09-11', 10, 11, 3);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (8, '/img/lovestory.jpg', '2018-07-01', 8, 9, 3);
INSERT INTO album (id, cover_image_path, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (9, '/img/lovestory.jpg', '2018-09-11', 10, 11, 3);

INSERT INTO photo(id, path, album_id)
VALUES (1, 'path1', 1);
INSERT INTO photo(id, path, album_id)
VALUES (2, 'path2', 1);
INSERT INTO photo(id, path, album_id)
VALUES (3, 'path3', 2);
INSERT INTO photo(id, path, album_id)
VALUES (4, 'path4', 2);
INSERT INTO photo(id, path, album_id)
VALUES (5, 'path5', 3);
INSERT INTO photo(id, path, album_id)
VALUES (6, 'path6', 3);

INSERT INTO `like` (user_id, photo_id)
VALUES (1, 1);
INSERT INTO `like` (user_id, photo_id)
VALUES (2, 1);
INSERT INTO `like` (user_id, photo_id)
VALUES (3, 1);




