USE photographer;

DROP TABLE `like`;
DROP TABLE `photo`;
DROP TABLE `album`;
DROP TABLE `photo_category`;
DROP TABLE `localized_text`;


SELECT `id`,
       `date`,
       `localized_name_id`,
       `localized_description_id`,
       `photo_category_id`
FROM `album`
ORDER BY `id`;

SELECT `id`,
       `date`,
       `localized_name_id`,
       `localized_description_id`,
       `photo_category_id`
FROM `album`
WHERE `id` = 11;

INSERT INTO photo_category (cover_image_path, localized_name_id)
VALUES (?, ?);

DELETE
FROM photo
WHERE id = 1;

SELECT id, user_id, photo_id
FROM `like`
where id = 1;

SELECT id,
       date,
       `localized_name_id`,
       `localized_description_id`,
       `photo_category_id`
FROM `album`
WHERE photo_category_id = 3;

SELECT photo.id, photo.path, photo.album_id
FROM `photo`
WHERE album_id = 3;

SELECT a.id,
       a.date,
       a.localized_name_id,
       a.localized_description_id,
       a.photo_category_id,
       lt.russian  as name,
       lt2.russian as description
FROM album a
         LEFT JOIN localized_text lt
                   ON a.localized_name_id = lt.id
         LEFT JOIN localized_text lt2
                   ON a.localized_description_id = lt2.id
ORDER BY id;

SELECT a.id,
       a.date,
       a.localized_name_id,
       a.localized_description_id,
       a.photo_category_id,
       lt.russian  as name,
       lt2.russian as description
FROM album a
         LEFT JOIN localized_text lt
                   ON a.localized_name_id = lt.id
         LEFT JOIN localized_text lt2
                   ON a.localized_description_id = lt2.id
WHERE a.id = 5;

SELECT a.id,
       a.date,
       a.localized_name_id,
       a.localized_description_id,
       a.photo_category_id,
       lt.russian  as name,
       lt2.russian as description
FROM album a
         LEFT JOIN localized_text lt
                   ON a.localized_name_id = lt.id
         LEFT JOIN localized_text lt2
                   ON a.localized_description_id = lt2.id
WHERE photo_category_id = 1;

SELECT a.id,
       a.cover_image_path,
       a.date,
       a.localized_name_id,
       a.localized_description_id,
       a.photo_category_id,
       lt.russian  AS name,
       lt2.russian AS description
FROM album a
         LEFT JOIN localized_text lt ON a.localized_name_id = lt.id
         LEFT JOIN localized_text lt2 ON a.localized_description_id = lt2.id
ORDER BY id;

SELECT id, path, album_id
FROM photo
WHERE album_id = 10
ORDER BY id
LIMIT 5 OFFSET 0;

SELECT COUNT(id)
FROM photo
WHERE album_id = 10;

SELECT pc.id,
       pc.cover_image_path,
       pc.localized_name_id,
       lt.russian as name
FROM photo_category pc
         LEFT JOIN localized_text lt on pc.localized_name_id = lt.id
ORDER BY pc.id;

SELECT pc.id,
       pc.cover_image_path,
       pc.localized_name_id,
       lt.russian as name
FROM photo_category pc
         LEFT JOIN localized_text lt on pc.localized_name_id = lt.id
WHERE pc.id = 1;