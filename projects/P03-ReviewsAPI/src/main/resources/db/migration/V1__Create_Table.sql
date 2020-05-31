CREATE TABLE IF NOT EXISTS `jdndc3`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` TEXT NOT NULL,
  `Cost` DOUBLE NOT NULL,
  `CreatedDateTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS  `jdndc3`.`reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subject` TEXT NOT NULL,
  `review_text` TEXT NULL,
  `products_id` INT NOT NULL,
  `createddatetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `reviewsproductId`
    FOREIGN KEY (`products_id`)
    REFERENCES `jdndc3`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS  `jdndc3`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment_text` TEXT NOT NULL,
  `reviews_id` INT NOT NULL,
  `CreatedDateTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `commentsproductId`
    FOREIGN KEY (`reviews_id`)
    REFERENCES `jdndc3`.`reviews` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

