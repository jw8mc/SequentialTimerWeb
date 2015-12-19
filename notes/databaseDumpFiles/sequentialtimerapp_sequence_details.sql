CREATE DATABASE  IF NOT EXISTS `sequentialtimerapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sequentialtimerapp`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: sequentialtimerapp
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `sequence_details`
--

DROP TABLE IF EXISTS `sequence_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence_details` (
  `timer_sequence_id` int(11) NOT NULL,
  `sequential_timer_id` int(11) NOT NULL,
  `preceding_timer_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `preceeding_timer_id` (`preceding_timer_id`),
  KEY `sequential_timer` (`sequential_timer_id`,`preceding_timer_id`),
  KEY `timer_sequence` (`timer_sequence_id`),
  CONSTRAINT `sequence_details_ibfk_1` FOREIGN KEY (`timer_sequence_id`) REFERENCES `timer_sequences` (`id`),
  CONSTRAINT `sequence_details_ibfk_2` FOREIGN KEY (`sequential_timer_id`) REFERENCES `sequential_timers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_details`
--

LOCK TABLES `sequence_details` WRITE;
/*!40000 ALTER TABLE `sequence_details` DISABLE KEYS */;
INSERT INTO `sequence_details` (`timer_sequence_id`, `sequential_timer_id`, `preceding_timer_id`, `id`) VALUES (1,2,0,2),(1,3,2,3),(1,4,3,4),(1,5,4,5),(2,1,0,6),(2,2,1,7),(2,3,2,8);
/*!40000 ALTER TABLE `sequence_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
