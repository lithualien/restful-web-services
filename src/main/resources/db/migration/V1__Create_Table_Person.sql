DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)