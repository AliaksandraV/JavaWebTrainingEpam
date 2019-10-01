USE `photographer`;

CREATE TABLE `localized_text`
(
    `id`      INT          NOT NULL AUTO_INCREMENT,
    `russian` VARCHAR(512) NULL,
    CONSTRAINT `PK_localized` PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE `photo_category`
(
    `id`                INT           NOT NULL AUTO_INCREMENT,
    `cover_image_path`  VARCHAR(4096) NULL,
    `localized_name_id` INT           NULL,
    CONSTRAINT `PK_photo_category` PRIMARY KEY (`id`),
#     KEY `FK_photo_category_localized_text` (`localized_name_id`),
    CONSTRAINT `FK_photo_category_localized_text` FOREIGN KEY (`localized_name_id`) REFERENCES `localized_text` (`id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE `album`
(
    `id`                       INT  NOT NULL AUTO_INCREMENT,
    `date`                     DATE NULL,
    `localized_name_id`        INT  NULL,
    `localized_description_id` INT  NULL,
    `photo_category_id`        INT  NOT NULL,
    CONSTRAINT `PK_album` PRIMARY KEY (`id`),
    KEY `FK_album_localized_name` (`localized_name_id`),
    KEY `FK_album_localized_description` (`localized_description_id`),
    KEY `FK_album_photo_category` (`photo_category_id`),
    CONSTRAINT `FK_album_localized_name` FOREIGN KEY (`localized_name_id`) REFERENCES `localized_text` (`id`) ON DELETE CASCADE,
    CONSTRAINT `FK_album_localized_description` FOREIGN KEY (`localized_description_id`) REFERENCES `localized_text` (`id`) ON DELETE CASCADE,
    CONSTRAINT `FK_album_photo_category` FOREIGN KEY (`photo_category_id`) REFERENCES `photo_category` (`id`) ON DELETE CASCADE
) DEFAULT CHARSET = utf8;

CREATE TABLE `photo`
(
    `id`       INT           NOT NULL AUTO_INCREMENT,
    `path`     VARCHAR(4096) NOT NULL,
    `album_id` INT           NOT NULL,
    CONSTRAINT `PK_photo` PRIMARY KEY (`id`),
    KEY `FK_photo_album` (`album_id`),
    CONSTRAINT `FK_photo_album` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`) ON DELETE CASCADE
) DEFAULT CHARSET = utf8;

CREATE TABLE `user`
(
    `id`           INT          NOT NULL AUTO_INCREMENT,
    `email`        VARCHAR(255) NOT NULL,
    `password`     NCHAR(64)    NOT NULL,
    `name`         VARCHAR(45)  NOT NULL,
    `phone_number` VARCHAR(18)  NOT NULL,
    `role`         TINYINT      NOT NULL,
    CONSTRAINT `PK_user` PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_email` (`email` ASC)
) DEFAULT CHARSET = utf8;


CREATE TABLE `like`
(
    `id`       INT NOT NULL AUTO_INCREMENT,
    `user_id`  INT NOT NULL,
    `photo_id` INT NOT NULL,
    CONSTRAINT `PK_like` PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    KEY `FK_like_user` (`user_id`),
    KEY `FK_like_photo` (`photo_id`),
    CONSTRAINT `FK_like_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    CONSTRAINT `FK_like_photo` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`) ON DELETE CASCADE

) DEFAULT CHARSET = utf8;

