-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eventdb
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventtable`
--

DROP TABLE IF EXISTS `eventtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventtable` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `startdate` datetime NOT NULL,
  `enddate` datetime NOT NULL,
  `place` varchar(45) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  `details` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `createdate` datetime NOT NULL,
  `sendMail` varchar(45) DEFAULT 'false',
  PRIMARY KEY (`event_id`),
  KEY `fk_Event_Group1_idx` (`group_id`),
  KEY `fk_EventTable_UserTable1_idx` (`user_id`),
  CONSTRAINT `fk_EventTable_UserTable1` FOREIGN KEY (`user_id`) REFERENCES `usertable` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Group1` FOREIGN KEY (`group_id`) REFERENCES `grouptable` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventtable`
--

LOCK TABLES `eventtable` WRITE;
/*!40000 ALTER TABLE `eventtable` DISABLE KEYS */;
INSERT INTO `eventtable` VALUES (2,'IoT・BIの課題','2019-06-20 14:00:00','2019-06-24 18:00:00','天神ビブレ',NULL,'connpassからは若干名を募集します。',2,'2019-06-26 13:53:55',''),(13,'機械学習','2019-06-01 16:00:00','2019-06-01 18:00:00','東京ドームシティ ミーツポート店',1,'・振り返り、初参加者の自己紹介（5〜10min）\r\n・概論の解説（50min）',1,'2019-06-26 13:31:41','false'),(26,'CSS3講座','2019-06-28 13:00:00','2019-07-05 13:00:00','横浜ランドマークタワー',NULL,'HTML5/CSS3の基本知識習得者。\r\nWindowsの基本操作、タイピングができる方。',1,'2019-06-26 16:28:04','false'),(27,'シニアプログラミング','2019-06-20 08:00:00','2019-06-30 18:00:00','渋谷',4,'すっかり定番となった「シニアプログラミングもくもく会」。ついに1周年です。みなさんお気軽にご参加ください！',1,'2019-06-19 13:50:52','false'),(28,'機械学習','2019-06-10 13:30:00','2019-06-20 18:00:00','上野動物園',2,'このイベントは Call for Code Challenge に使える機械学習を使用したコードパターンについて最初に解説し、次に実際にコードパターンを参照しながら、アプリを作成していただきます。',1,'2019-06-26 13:54:44','false'),(29,'7月新卒懇親会','2019-07-01 13:00:00','2019-07-31 13:00:00','J PREP 自由が丘校 新2号館',NULL,'7月新卒のお申込み、お待ちしております！',1,'2019-06-26 13:51:18','false'),(30,'機械学習入門','2019-06-01 08:00:00','2019-06-10 18:00:00','秋葉原駅',3,'機械学習の理論を学ぶ上で、数学の基礎的な知識は欠かせません。そこで、機械学習を理解することに特化した数学基礎講座を開講いたします。',1,'2019-06-19 13:50:21','false'),(33,'営業懇親会','2019-06-10 13:00:00','2019-06-30 13:00:00','五反田駅',NULL,'お申込み、お待ちしております！',1,'2019-06-19 13:31:31','false'),(37,'Swift勉強会','2019-06-01 06:05:00','2019-06-30 06:05:00','五反田',NULL,'Swiftの勉強がある方はお気軽い参考してください。',1,'2019-06-19 13:35:20','false'),(38,'Java技術勉強会','2019-06-20 09:00:00','2019-06-30 18:00:00','東京五反田',NULL,'基本参加が無料の場合が多いです。\r\n勉強会後に懇親会が開かれる場合があり、参加者の方との交流が出来ます。',7,'2019-06-19 13:38:35','true'),(39,'Tableau復習','2019-06-25 09:00:00','2019-06-30 18:00:00','早稲田大学',3,'復習ブートキャンプ？なぜこんなことやるのでしょう？',1,'2019-06-19 13:50:37','false'),(40,'Python入門','2019-06-25 08:00:00','2019-06-30 18:00:00','秋葉原駅',3,'※本講座は、動画復習対応講座でございます。受講した翌日から3日間、動画を公開いたします。聞き逃してしまった箇所の補填やより深い理解のためにお役立ていただけると幸いです！',1,'2019-06-19 13:55:20','false');
/*!40000 ALTER TABLE `eventtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grouptable`
--

DROP TABLE IF EXISTS `grouptable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grouptable` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(45) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grouptable`
--

LOCK TABLES `grouptable` WRITE;
/*!40000 ALTER TABLE `grouptable` DISABLE KEYS */;
INSERT INTO `grouptable` VALUES (1,'総務部'),(2,'人事部'),(3,'技術部'),(4,'営業部');
/*!40000 ALTER TABLE `grouptable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jointable`
--

DROP TABLE IF EXISTS `jointable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jointable` (
  `join_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  PRIMARY KEY (`join_id`),
  KEY `fk_Participation_Event1_idx` (`event_id`),
  KEY `fk_JoinTable_UserTable1_idx` (`user_id`),
  CONSTRAINT `fk_JoinTable_UserTable1` FOREIGN KEY (`user_id`) REFERENCES `usertable` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participation_Event1` FOREIGN KEY (`event_id`) REFERENCES `eventtable` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jointable`
--

LOCK TABLES `jointable` WRITE;
/*!40000 ALTER TABLE `jointable` DISABLE KEYS */;
INSERT INTO `jointable` VALUES (13,1,26),(15,1,28),(27,1,33),(28,1,30);
/*!40000 ALTER TABLE `jointable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typetable`
--

DROP TABLE IF EXISTS `typetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typetable` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typetable`
--

LOCK TABLES `typetable` WRITE;
/*!40000 ALTER TABLE `typetable` DISABLE KEYS */;
INSERT INTO `typetable` VALUES (1,'使用者'),(2,'管理者');
/*!40000 ALTER TABLE `typetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertable` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(45) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `type_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `createdate` datetime NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_User_Group_idx` (`group_id`),
  KEY `fk_User_Type1_idx` (`type_id`),
  CONSTRAINT `fk_User_Group` FOREIGN KEY (`group_id`) REFERENCES `grouptable` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Type1` FOREIGN KEY (`type_id`) REFERENCES `typetable` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES (1,'taro','$2a$10$8ZoVzNspzCtr4sS8v9kT6O8AcfJtNoD4Uyq06goAAkSAWgzKv9d2O','山田 太郎',2,3,'2019-06-24 11:18:49','img20190612165030.png','1'),(2,'jiro','$2a$10$8ZoVzNspzCtr4sS8v9kT6O8AcfJtNoD4Uyq06goAAkSAWgzKv9d2O','鈴木 次郎',2,1,'2019-06-24 14:02:31','img20190624140231.jpg','1'),(3,'saburo','$2a$10$MaQK4Ie12e402cLNanqY4OGA2jyWxb5Nma1sHS9LdDEhudMtcNZKS','田中 三郎',2,2,'2019-05-30 17:07:02',NULL,'1'),(4,'shiro','$2a$10$8ZoVzNspzCtr4sS8v9kT6O8AcfJtNoD4Uyq06goAAkSAWgzKv9d2O','佐藤 四朗',1,4,'2019-05-28 13:59:32',NULL,'1'),(6,'tatsuo','$2a$10$zF3A8vX6VRhV0/vp.nWzPeeWdI.m8wrNCmBnaIm4bLz8LO1I.V6Vm','三上 辰夫',1,3,'2019-05-30 17:11:36',NULL,'1'),(7,'kcyu','$2a$10$4iu9z9Ms5O.A65KHbSgeO.hiAZFnU9CXZqjhr/.BNhnmfSOxiRg2W','鈕',1,3,'2019-06-17 14:52:28','img20190617143855.jpg','k-cyu@beat-tech.co.jp');
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-26 17:46:48
