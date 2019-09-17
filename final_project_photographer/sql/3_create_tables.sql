USE `photographer`;

CREATE TABLE IF NOT EXISTS `localized_text`
(
    `id`      INT NOT NULL AUTO_INCREMENT,
    `russian` VARCHAR(512) DEFAULT NULL,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `photo_category`
(
    `id`                INT NOT NULL AUTO_INCREMENT,
    `cover_image_path`  VARCHAR(255) DEFAULT NULL,
    `localized_name_id` INT          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_photo_category_localized_text` (`localized_name_id`),
    CONSTRAINT `FK_photo_category_localized_text` FOREIGN KEY (`localized_name_id`) REFERENCES `localized_text` (`id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `album`
(
    `id`                       INT NOT NULL AUTO_INCREMENT,
    `date`                     DATE DEFAULT NULL,
    `localized_name_id`        INT  DEFAULT NULL,
    `localized_description_id` INT  DEFAULT NULL,
    `photo_category_id`        INT  DEFAULT NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_album_localized_name` (`localized_name_id`),
    KEY `FK_album_localized_description` (`localized_description_id`),
    KEY `FK_album_photo_category` (`photo_category_id`),
    CONSTRAINT `FK_album_localized_name` FOREIGN KEY (`localized_name_id`) REFERENCES `localized_text` (`id`),
    CONSTRAINT `FK_album_localized_description` FOREIGN KEY (`localized_description_id`) REFERENCES `localized_text` (`id`),
    CONSTRAINT `FK_album_photo_category` FOREIGN KEY (`photo_category_id`) REFERENCES `photo_category` (`id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `photo`
(
    `id`       INT NOT NULL AUTO_INCREMENT,
    `path`     VARCHAR(255) DEFAULT NULL,
    `album_id` INT          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_photo_album` (`album_id`),
    CONSTRAINT `FK_photo_album` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `email`        VARCHAR(255) NOT NULL,
    `password`     NCHAR(64) NOT NULL,
    `name`         VARCHAR(45) NOT NULL,
    `phone_number` VARCHAR(18) NOT NULL,
    `role`         TINYINT DEFAULT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `like`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `user_id`      INT NOT NULL,
    `photo_id`     INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    KEY `FK_like_user` (`user_id`),
    KEY `FK_like_photo` (`photo_id`),
    CONSTRAINT `FK_like_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `FK_like_photo` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`)

) DEFAULT CHARSET = utf8;

