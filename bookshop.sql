-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookshop
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `count` int NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `photo` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Book_pk2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,1,'io','wer',1,1,'asd','2024-06-25 11:26:24','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(5,1,'123','123',1,2,'123123','2024-06-25 10:47:03','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(7,8,'委屈恶气','·12',1,213,'123','2024-06-25 11:42:42','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(8,10,'问清楚e','123123',23,12,'我的身份我','2024-06-25 16:51:50','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(10,10,'背你的','风格和',10,2,'额外人发','2024-06-25 16:52:28','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(11,10,'梵蒂冈','地方官',1,3,'温热无法','2024-06-25 16:52:39','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(12,10,'二五','士大夫',45,2,'这个用户很懒，什么也没留下~','2024-06-25 16:52:49','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(13,8,'房管局','好几个',99,6,'异教徒','2024-06-25 16:53:26','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(14,8,'从v下','费用很高',234,2,'这个用户很懒，什么也没留下~','2024-06-25 16:53:37','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(15,8,'热狗','个人',43,232,'让阿塞分公司','2024-06-25 16:53:51','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(19,9,'高数','lsf',12,1,'儿','2024-06-25 23:27:52','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(20,9,'上都能解决','123',12,1,'231','2024-06-25 23:28:08','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `buyer_id` int NOT NULL,
  `buyer_name` varchar(100) NOT NULL,
  `seller_id` int NOT NULL,
  `seller_name` varchar(100) NOT NULL,
  `book_id` int NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `price` int NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `record_pk2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,1,'管理员',9,'柳生发',18,'123423',1,'2024-06-25 22:12:20'),(2,1,'管理员',8,'李泽宇',17,'是',44,'2024-06-25 22:13:01'),(3,1,'管理员',8,'李泽宇',17,'是',44,'2024-06-25 22:19:28'),(4,1,'管理员',8,'李泽宇',16,'夫人特色弱覆盖',999,'2024-06-25 22:21:47'),(5,1,'管理员',8,'李泽宇',15,'热狗',43,'2024-06-25 22:22:00'),(6,1,'管理员',8,'李泽宇',15,'热狗',43,'2024-06-25 22:26:38'),(7,1,'管理员',8,'李泽宇',14,'从v下',234,'2024-06-25 22:27:29'),(8,1,'管理员',8,'李泽宇',14,'从v下',234,'2024-06-25 22:31:12'),(9,8,'李泽宇',10,'带我去',9,'额外大王',123,'2024-06-25 22:57:25');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `money` int NOT NULL DEFAULT '100',
  `address` varchar(150) NOT NULL,
  `photo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ldx','$2a$10$aeu/6zjS81ALIj8CZ5UnaOy/Ja35KSsP3s4W6x.pZOn4lwmFJ5FUq','管理员',532,'123','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(7,'123a4d','$2a$10$m.Eh/eNViIB7Pc2o/QGjPu4YyGE1k/1WcIfBT/5UWW0dIi4EMi1fq','aa',100,'sada','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(8,'lizeyu','$2a$10$ILxPzjh/YbmhpgTtT5rxxO/JoCflQXSGo1buNe3qAxRvQ4ohdBm.i','李泽宇',1618,'123','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(9,'liushengfa','$2a$10$zwisAaThTrCRvWIXArwu3eX/gL/xq5YGK22VuGS.twkwHFI.xepJy','柳生发',102,'三缺二','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg'),(10,'dongwenqiang','$2a$10$k.bn0v.Mamcjvax3WOvbFu91eULvTJTxoxLfry1rHeQMHpa50VrbW','带我去',223,'我去饿','https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg');
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

-- Dump completed on 2024-06-28  0:13:41
