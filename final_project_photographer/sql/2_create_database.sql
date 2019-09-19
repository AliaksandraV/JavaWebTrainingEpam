CREATE DATABASE IF NOT EXISTS `photographer` DEFAULT CHARACTER SET utf8;

CREATE USER editor IDENTIFIED BY 'Aa123+';

GRANT SELECT, INSERT, UPDATE, DELETE
    ON `photographer`.*
    TO photographer@localhost;

