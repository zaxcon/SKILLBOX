-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bookshop
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Лёгкое чтение',NULL,'slug'),(2,'Фантастика',1,'slug'),(3,'Боевики',1,'slug'),(4,'Детективы',1,'slug'),(5,'Триллер',4,'slug'),(6,'Крутой детектив',4,'slug'),(7,'Иронический детектив',4,'slug'),(8,'Про маньяков',4,'slug'),(9,'Шпионский детектив',4,'slug'),(10,'Криминальный детектив',4,'slug'),(11,'Классический детектив',4,'slug'),(12,'Политический детектив',4,'slug'),(13,'Фэнтези',1,'slug'),(14,'Романы',1,'slug'),(15,'Ужасы',1,'slug'),(16,'Приключения',1,'slug'),(17,'Серьёзное чтение',NULL,'slug'),(18,'Биографии',17,'slug'),(19,'Деловая литература',NULL,'slug'),(20,'Управление экономикой',19,'slug'),(21,'Карьера',19,'slug'),(22,'Маркетинг, PR, реклама',19,'slug'),(23,'Финансы',19,'slug'),(24,'Бизнес-справочники',19,'slug'),(25,'Личные финансы',19,'slug'),(26,'Менеджмент',19,'slug'),(27,'Зарубежная деловая литература',19,'slug'),(28,'Личная эффективность',19,'slug'),(29,'Тайм-менеджмент',19,'slug'),(30,'Малый бизнес',19,'slug'),(31,'Продажи',19,'slug'),(32,'Стартапы и создание бизнеса',19,'slug'),(33,'Корпоративная культура',19,'slug'),(34,'Банковское дело',19,'slug'),(35,'Логистика',19,'slug'),(36,'Недвижимость(',19,'slug'),(37,'Интернет-бизнес',19,'slug'),(38,'Ораторское искусство / риторика',19,'slug'),(39,'Привлечение клиентов и лояльность',19,'slug'),(40,'Делопроизводство',19,'slug'),(41,'Переговоры',19,'slug'),(42,'Государственное и муниципальное управление, политическое управление',19,'slug'),(43,'О бизнесе популярно',19,'slug'),(44,'Ценные бумаги / инвестиции',19,'slug'),(45,'Бухучет / налогообложение / аудит',19,'slug'),(46,'Российская практика',19,'slug'),(47,'Истории успеха',19,'slug'),(48,'Интернет-маркетинг',19,'slug'),(49,'Лидерство',19,'slug'),(50,'Проектный менеджмент',19,'slug'),(51,'Управление качеством',19,'slug'),(52,'Финансовый менеджмент',19,'slug'),(53,'Управление персоналом',19,'slug'),(54,'Бизнес-процессы',19,'slug'),(55,'Управление бизнесом',19,'slug'),(56,'Драматургия',NULL,'slug'),(57,'Античная драма',56,'slug'),(58,'Комедия',56,'slug'),(59,'Сценарий',56,'slug'),(60,'Драма, пьеса',56,'slug');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 21:10:14
