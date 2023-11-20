CREATE DATABASE  IF NOT EXISTS `bandesal_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bandesal_app`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bandesal_app
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `bandesal_blogs`
--

DROP TABLE IF EXISTS `bandesal_blogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bandesal_blogs` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandesal_blogs`
--
-- ORDER BY:  `ID`

LOCK TABLES `bandesal_blogs` WRITE;
/*!40000 ALTER TABLE `bandesal_blogs` DISABLE KEYS */;
/*!40000 ALTER TABLE `bandesal_blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bandesal_blogs_readers`
--

DROP TABLE IF EXISTS `bandesal_blogs_readers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bandesal_blogs_readers` (
  `R_ID` int DEFAULT NULL,
  `B_ID` int DEFAULT NULL,
  KEY `FK_READERS_idx` (`R_ID`),
  KEY `FK_BLOGS_idx` (`B_ID`),
  CONSTRAINT `FK_BLOGS` FOREIGN KEY (`B_ID`) REFERENCES `bandesal_blogs` (`ID`),
  CONSTRAINT `FK_READERS` FOREIGN KEY (`R_ID`) REFERENCES `bandesal_readers` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandesal_blogs_readers`
--

LOCK TABLES `bandesal_blogs_readers` WRITE;
/*!40000 ALTER TABLE `bandesal_blogs_readers` DISABLE KEYS */;
/*!40000 ALTER TABLE `bandesal_blogs_readers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bandesal_readers`
--

DROP TABLE IF EXISTS `bandesal_readers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bandesal_readers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(8) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandesal_readers`
--
-- ORDER BY:  `ID`

LOCK TABLES `bandesal_readers` WRITE;
/*!40000 ALTER TABLE `bandesal_readers` DISABLE KEYS */;
/*!40000 ALTER TABLE `bandesal_readers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bandesal_usuarios`
--

DROP TABLE IF EXISTS `bandesal_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bandesal_usuarios` (
  `id` int NOT NULL,
  `nombre` varchar(400) NOT NULL,
  `usr` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `fecha_modificacion` date DEFAULT NULL,
  `two_fact_auth` varchar(400) DEFAULT NULL,
  `correo_electronico` varchar(400) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandesal_usuarios`
--
-- ORDER BY:  `id`

LOCK TABLES `bandesal_usuarios` WRITE;
/*!40000 ALTER TABLE `bandesal_usuarios` DISABLE KEYS */;
INSERT INTO `bandesal_usuarios` (`id`, `nombre`, `usr`, `password`, `fecha_creacion`, `fecha_modificacion`, `two_fact_auth`, `correo_electronico`, `estado`) VALUES (1,'BANDESAL','bandesal','$2a$12$HvsGyskxrYqEhd65vF8khul1hdeIauvOqIIG4K5jaApA2b2D9yV4a','2023-11-18','2023-11-18',NULL,'bandesal@gmail.com','A');
/*!40000 ALTER TABLE `bandesal_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-19 23:22:45
