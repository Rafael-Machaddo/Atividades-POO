CREATE DATABASE  IF NOT EXISTS `todolist`;
USE `todolist`;

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(128) NOT NULL,
  `isDone` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;


LOCK TABLES `tasks` WRITE;
INSERT INTO `tasks` VALUES (7,'eqeqw',0);
UNLOCK TABLES;
