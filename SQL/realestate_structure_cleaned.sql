
use realestate;

-- execute SET/DROPS one at a time
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `house_photos`;
DROP TABLE IF EXISTS `listing_detail`;
DROP TABLE IF EXISTS `realtor`;
SET FOREIGN_KEY_CHECKS = 1;


-- execute CREATE TABLE one at a time
CREATE TABLE `address` (
  `house_number` int DEFAULT NULL,
  `street` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `state` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `zip` int NOT NULL,
  `apt_suite` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `realtor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `picture` mediumblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `listing_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `num_bedrooms` float DEFAULT NULL,
  `num_baths` float NOT NULL,
  `realtor_id` int NOT NULL,
  `price` int DEFAULT NULL,
  `adress_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `listing_detail_FK_1` (`adress_id`),
  KEY `listing_detail_FK` (`realtor_id`),
  CONSTRAINT `listing_detail_FK` FOREIGN KEY (`realtor_id`) REFERENCES `realtor` (`id`),
  CONSTRAINT `listing_detail_FK_1` FOREIGN KEY (`adress_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `house_photos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `listing_id` int DEFAULT NULL,
  `is_default` tinyint(1) DEFAULT NULL,
  `photo` mediumblob,
  PRIMARY KEY (`id`),
  KEY `housephotos_FK` (`listing_id`),
  CONSTRAINT `housephotos_FK` FOREIGN KEY (`listing_id`) REFERENCES `listing_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
