USE photographer;

SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` ORDER BY `id`;

SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` WHERE `id`=11;