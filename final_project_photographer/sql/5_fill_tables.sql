USE photographer;

INSERT INTO user (email, password, name, phone_number, role)
VALUES ('somemail1@gmail.com', 'Aa123+', 'Nata', '+375-29-255-04-62', 2);
INSERT INTO user (email, password, name, phone_number, role)
VALUES ('somemail2@gmail.com', 'Aa123+', 'Dina', '+375-29-255-04-62', 2);
INSERT INTO user (email, password, name, phone_number, role)
VALUES ('somemail3@gmail.com', 'Aa123+', 'Michael', '+375-29-255-04-62', 2);

INSERT INTO localized_text(id, russian)
VALUES (1, 'Свадебные');
INSERT INTO localized_text(id, russian)
VALUES (2, 'Портрет');
INSERT INTO localized_text(id, russian)
VALUES (3, 'Дети');
INSERT INTO localized_text(id, russian)
VALUES (4, 'Ирина и Кирилл');
INSERT INTO localized_text(id, russian)
VALUES (5, 'Прекраснейшее событие в жизни молодых! Хочется, чтобы
оно отложилось в нашей памяти только яркими воспоминаниями,
а чтобы эти воспоминания можно было сохранить для своих детей, внуков и даже правнуко');
INSERT INTO localized_text(id, russian)
VALUES (6, 'Сказка Анжелы');
INSERT INTO localized_text(id, russian)
VALUES (7, 'Индивидуальная фотосессия в студии в студии ARt');
INSERT INTO localized_text(id, russian)
VALUES (8, 'Маленький Петенька');

INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (1, 'wedding_category', 1);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (2, 'portrait_category', 2);
INSERT INTO photo_category (id, cover_image_path, localized_name_id)
VALUES (3, 'kids_category', 3);

INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (1, '2018-07-01', 4, 5, 1);
INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (2, '2018-09-11', 6, 7, 2);
INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id)
VALUES (3, '2018-11-23', 8, null, 3);

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




