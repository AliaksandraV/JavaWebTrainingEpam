USE photographer;

INSERT INTO user (email, password_hash, salt, name, phone_number, role)
VALUES ('somemail1@gmail.com', 'ckUATNHLvfht0jZK7q88lFKrMJgz7HQNZvOEsKaqYtA=', 'rbdofMRNAQyR1EjG', 'Nata', '+375-29-255-04-62', 2);
INSERT INTO user (email, password_hash, salt, name, phone_number, role)
VALUES ('somemail2@gmail.com', 'ckUATNHLvfht0jZK7q88lFKrMJgz7HQNZvOEsKaqYtA=', 'rbdofMRNAQyR1EjG', 'Dina', '+375-29-255-04-62', 2);
INSERT INTO user (email, password_hash, salt, name, phone_number, role)
VALUES ('somemail3@gmail.com', 'ckUATNHLvfht0jZK7q88lFKrMJgz7HQNZvOEsKaqYtA=', 'rbdofMRNAQyR1EjG', 'Michael', '+375-29-255-04-62', 2);

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
INSERT INTO localized_text(id, russian)
VALUES (16, 'Аня+Илья');

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

INSERT INTO album (id, cover_image_path,   localized_name_id, localized_description_id, photo_category_id)
VALUES (1, '/img/lovestory.jpg', 8, 9, 1);
INSERT INTO album (id, cover_image_path,   localized_name_id, localized_description_id, photo_category_id)
VALUES (2, '/img/lovestory.jpg', 10, 11, 2);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (3, '/img/lovestory.jpg', 12, null, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (4, '/img/lovestory.jpg', 13, 14, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (5, '/img/lovestory.jpg', null, 15, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (6, '/img/lovestory.jpg', 8, 9, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (7, '/img/lovestory.jpg', 10, 11, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (8, '/img/lovestory.jpg', 8, 9, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (9, '/img/lovestory.jpg', 10, 11, 3);
INSERT INTO album (id, cover_image_path,  localized_name_id, localized_description_id, photo_category_id)
VALUES (10, '/Users/alex/testFiles/photos/1500-e56ea79a478feae645d32947afd683e3.jpg', '2018-09-11', 16, 11, 1);

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
INSERT INTO photo(id, path, album_id)
VALUES (7, '/img/photos/1500-0c4351492f8e5c8c06ded3ae0bc637b4.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (8, '/img/photos/1500-1e661c8cc2cc61d75233c2dc04380beb.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (9, '/img/photos/1500-01ad7e0a43208c8e90c8780c4c256e45.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (10, '/img/photos/1500-2a9c9999fbd96277c657083f7d4cc711.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (11, '/img/photos/1500-2c47417ecb54fbdd07f8a4d417133a53.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (12, '/img/photos/1500-5f881f86e73d948345ae9004ffd6c8c8.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (13, '/img/photos/1500-6da8c392bd43406ead1a91dd9580d70f.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (14, '/img/photos/1500-13f2fd190b81607ed2f25cbb7fdba236.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (15, '/img/photos/1500-23d5d1d572e9acb713fd21774933803d.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (16, '/img/photos/1500-60ff1d6abdeb608cbc89f9c520ed47a4.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (17, '/img/photos/1500-69f0ea47af725fb0e819cc75f8bb2762.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (18, '/img/photos/1500-93aea3a06c7bb76c925353eb256aa488.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (19, '/img/photos/1500-0499a40db6599c63a2d40aca2ecb69f5.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (20, '/img/photos/1500-8878a39a8e9ae69be91db80361a82459.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (21, '/img/photos/1500-59645bed6059b05ef004806b55df8fad.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (22, '/img/photos/1500-21206241022d04e51c75b9f680d297fe.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (23, '/img/photos/1500-e56ea79a478feae645d32947afd683e3.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (24, '/img/photos/1500-f75e76392e66cc41ec49c54990a67204.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (25, '/img/photos/1500-f160967ce542b064e0d2ba877a9cc0bd.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (26, '/img/photos/1500-fcca74d7e6dacddce2b37865935c11f7.jpg', 10);
INSERT INTO photo(id, path, album_id)
VALUES (27, '/img/photos/1500-ff3fb1b725926266fecf6568d3d3cc34.jpg', 10);


INSERT INTO `like` (user_id, photo_id)
VALUES (1, 1);
INSERT INTO `like` (user_id, photo_id)
VALUES (2, 1);
INSERT INTO `like` (user_id, photo_id)
VALUES (3, 1);




