-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: web_news_db
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles` (
  `ArticleID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Content` text NOT NULL,
  `AuthorID` int DEFAULT NULL,
  `CategoryID` int DEFAULT NULL,
  `publication_date` date DEFAULT NULL,
  `Views` int DEFAULT '0',
  `Likes` int DEFAULT '0',
  `Dislikes` int DEFAULT '0',
  `image_base64` text,
  PRIMARY KEY (`ArticleID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (1,'Bài viết 1','Nội dung bài viết 1',1,1,'2023-10-01',0,0,0,NULL),(2,'Bài viết 2','Nội dung bài viết 2',2,2,'2023-10-02',0,0,0,NULL),(3,'Bài viết 3','Nội dung bài viết 3',1,2,'2023-10-03',0,0,0,NULL),(4,'Bài viết 4','Nội dung bài viết 4',1,1,'2023-10-01',0,0,0,NULL),(5,'Bài viết 5','Nội dung bài viết 5',2,2,'2023-10-02',0,0,0,NULL),(6,'Bài viết 6','Nội dung bài viết 6',1,3,'2023-10-03',0,0,0,NULL),(7,'Bài viết 7','Nội dung bài viết 7',1,4,'2023-10-01',0,0,0,NULL),(8,'Bài viết 8','Nội dung bài viết 8',2,5,'2023-10-02',0,0,0,NULL),(9,'Bài viết 9','Nội dung bài viết 9',1,4,'2023-10-03',0,0,0,NULL),(10,'Bài viết 10','Nội dung bài viết 10',1,5,'2023-10-01',0,0,0,NULL),(11,'Bài viết 11','Nội dung bài viết 11',2,5,'2023-10-02',0,0,0,NULL),(12,'Bài viết 12','Nội dung bài viết 12',1,3,'2023-10-03',0,0,0,NULL),(13,'Bài viết 13','Nội dung bài viết 13',1,3,'2023-10-01',0,0,0,NULL),(14,'Bài viết 14','Nội dung bài viết 14',2,2,'2023-10-02',0,0,0,NULL),(15,'Bài viết 15','Nội dung bài viết 15',1,1,'2023-10-03',0,0,0,NULL),(16,'Bài viết 16','Nội dung bài viết 16',1,4,'2023-10-01',0,0,0,NULL),(17,'Bài viết 17','Nội dung bài viết 17',2,5,'2023-10-02',0,0,0,NULL),(18,'Bài viết 18','Nội dung bài viết 18',1,4,'2023-10-03',0,0,0,NULL),(19,'Bài viết 19','Nội dung bài viết 19',1,5,'2023-10-01',0,0,0,NULL),(20,'Bài viết 20','Nội dung bài viết 20',2,5,'2023-10-02',0,0,0,NULL),(21,'Bài viết 21','Nội dung bài viết 21',1,3,'2023-10-03',0,0,0,NULL),(22,'Bài viết 22','Nội dung bài viết 22',1,3,'2023-10-01',0,0,0,NULL),(23,'Bài viết 23','Nội dung bài viết 23',2,2,'2023-10-02',0,0,0,NULL),(24,'Bài viết 24','Nội dung bài viết 24',1,1,'2023-10-03',0,0,0,NULL),(25,'Bài viết 25','Nội dung bài viết 25',1,4,'2023-10-01',0,0,0,NULL),(26,'Bài viết 26','Nội dung bài viết 26',2,5,'2023-10-02',0,0,0,NULL),(27,'Bài viết 27','Nội dung bài viết 27',1,4,'2023-10-03',0,0,0,NULL),(28,'Bài viết 28','Nội dung bài viết 28',1,5,'2023-10-01',0,0,0,NULL),(29,'Bài viết 29','Nội dung bài viết 29',2,5,'2023-10-02',0,0,0,NULL),(30,'Bài viết 30','Nội dung bài viết 30',1,3,'2023-10-03',0,0,0,NULL),(31,'Bài viết 31','Nội dung bài viết 31',1,3,'2023-10-01',0,0,0,NULL),(32,'Bài viết 32','Nội dung bài viết 32',2,2,'2023-10-02',0,0,0,NULL),(33,'Bài viết 33','Nội dung bài viết 33',1,1,'2023-10-03',0,0,0,NULL),(34,'Bài viết 34','Nội dung bài viết 34',1,4,'2023-10-01',0,0,0,NULL),(35,'Bài viết 35','Nội dung bài viết 35',2,5,'2023-10-02',0,0,0,NULL),(36,'Bài viết 36','Nội dung bài viết 36',1,4,'2023-10-03',0,0,0,NULL),(37,'Bài viết 37','Nội dung bài viết 37',1,5,'2023-10-01',0,0,0,NULL),(38,'Bài viết 38','Nội dung bài viết 38',2,5,'2023-10-02',0,0,0,NULL),(39,'Bài viết 39','Nội dung bài viết 39',1,3,'2023-10-03',0,0,0,NULL),(40,'Bài viết 40','Nội dung bài viết 40',1,3,'2023-10-01',0,0,0,NULL),(41,'Bài viết 41','Nội dung bài viết 41',2,2,'2023-10-02',0,0,0,NULL),(42,'Bài viết 42','Nội dung bài viết 42',1,1,'2023-10-03',0,0,0,NULL),(43,'Bài viết 43','Nội dung bài viết 43',1,3,'2023-10-01',0,0,0,NULL);
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articletags`
--

DROP TABLE IF EXISTS `articletags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articletags` (
  `ArticleID` int DEFAULT NULL,
  `TagID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articletags`
--

LOCK TABLES `articletags` WRITE;
/*!40000 ALTER TABLE `articletags` DISABLE KEYS */;
INSERT INTO `articletags` VALUES (1,1),(1,3),(2,2),(2,4);
/*!40000 ALTER TABLE `articletags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `AuthorID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Bio` text,
  PRIMARY KEY (`AuthorID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Tác giả 1','Tiểu sử tác giả 1'),(2,'Tác giả 2','Tiểu sử tác giả 2'),(3,'Tác giả 3','Tiểu sử tác giả 3');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Code` varchar(255) NOT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Thế giới','THE_GIOI'),(2,'Kinh tế','KINH_TE'),(3,'Giải trí','GIAI_TRI'),(4,'Khoa học','KHOA_HOC'),(5,'Công nghệ','CONG_NGHE');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `CommentID` int NOT NULL AUTO_INCREMENT,
  `ArticleID` int DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `CommentText` text NOT NULL,
  `CommentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`CommentID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'Người bình luận 1','email1@example.com','Nội dung bình luận 1','2023-10-04 12:00:00'),(2,1,'Người bình luận 2','email2@example.com','Nội dung bình luận 2','2023-10-05 14:30:00');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tags` (
  `TagID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Code` varchar(255) NOT NULL,
  PRIMARY KEY (`TagID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'Chính trị','CHINH_TRI'),(2,'Thể thao','THE_THAO'),(3,'Sức khỏe','SUC_KHOE'),(4,'Âm nhạc','AM_NHAC');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'loda','$2a$10$8IF6t2wj.wwiLzkV4/L5Ouysz.OCBlgdUkyz4iQqdC62iJ.LPV6mK');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-05 22:05:57
