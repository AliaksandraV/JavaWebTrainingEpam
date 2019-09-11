USE `photographer`;

CREATE TABLE IF NOT EXISTS `localized_text`
(
    `id`      INT NOT NULL AUTO_INCREMENT,
    `russian` varchar(512) DEFAULT NULL,
    `english` varchar(512) DEFAULT NULL,
    `german`  varchar(512) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `role`
(
    `id`   INT NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `photo_category`
(
    `id`                INT NOT NULL AUTO_INCREMENT,
    `cover_image_path`  varchar(255) DEFAULT NULL,
    `localized_name_id` INT   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_photo_category_localized_text` (`localized_name_id`),
    CONSTRAINT `FK_photo_category_localized_text` FOREIGN KEY (`localized_name_id`) REFERENCES `localized_text` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `album`
(
    `id`                INT NOT NULL AUTO_INCREMENT,
    `date`              date       DEFAULT NULL,
    `localized_name_id` INT DEFAULT NULL,
    `photo_category_id` INT DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_album_localized_text` (`localized_name_id`),
    KEY `FK_album_photo_category` (`photo_category_id`),
    CONSTRAINT `FK_album_localized_text` FOREIGN KEY (`localized_name_id`) REFERENCES `localized_text` (`id`),
    CONSTRAINT `FK_album_photo_category` FOREIGN KEY (`photo_category_id`) REFERENCES `photo_category` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `photo`
(
    `id`       INT NOT NULL AUTO_INCREMENT,
    `path`     varchar(255) DEFAULT NULL,
    `album_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_photo_album` (`album_id`),
    CONSTRAINT `FK_photo_album` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `email`        VARCHAR(45) NOT NULL,
    `password`     VARCHAR(45) NOT NULL,
    `name`         VARCHAR(45) NULL,
    `phone_number` VARCHAR(45) NOT NULL,
    `role_id`      bigint(20)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_user_role` (`role_id`),
    CONSTRAINT `FK_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC)
);



