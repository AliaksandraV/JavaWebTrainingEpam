USE photographer;

SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` ORDER BY `id`;

SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` WHERE `id`=11;

INSERT INTO photo_category (cover_image_path, localized_name_id) VALUES (?, ?);
