-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: PoliceRecords
-- ------------------------------------------------------
-- Server version	8.0.32-0ubuntu0.22.04.2

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
-- Table structure for table `Crime`
--

DROP TABLE IF EXISTS `Crime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Crime` (
  `crime_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(10) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `ps_area` varchar(15) NOT NULL,
  `cr_date` date NOT NULL,
  `name_of_victim` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`crime_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Crime`
--

LOCK TABLES `Crime` WRITE;
/*!40000 ALTER TABLE `Crime` DISABLE KEYS */;
INSERT INTO `Crime` VALUES (3,'Robbery','10Kg','Panvel','2023-03-30','Vinod'),(4,'Theft','2 KG Of gold and Rs. 5000 stolen from house','Khandeshwar','2023-01-01','Gauresh Sapkal'),(5,'Robbery','Rs. 20000 stolen from car','khandeshwar','2023-03-30','Phule'),(6,'Robbery','Laptop stolen from office.','Khandeshwar','2021-02-28','Raj Jadhav'),(7,'Robbery','Gold and Money from house','Khandeshwar','2022-02-27','Nikhil Kumar');
/*!40000 ALTER TABLE `Crime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Crime_Criminal_Records`
--

DROP TABLE IF EXISTS `Crime_Criminal_Records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Crime_Criminal_Records` (
  `crime_id` int DEFAULT NULL,
  `criminal_id` int DEFAULT NULL,
  KEY `crime_id` (`crime_id`),
  KEY `criminal_id` (`criminal_id`),
  CONSTRAINT `Crime_Criminal_Records_ibfk_1` FOREIGN KEY (`crime_id`) REFERENCES `Crime` (`crime_id`) ON DELETE CASCADE,
  CONSTRAINT `Crime_Criminal_Records_ibfk_2` FOREIGN KEY (`criminal_id`) REFERENCES `Criminal` (`criminal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Crime_Criminal_Records`
--

LOCK TABLES `Crime_Criminal_Records` WRITE;
/*!40000 ALTER TABLE `Crime_Criminal_Records` DISABLE KEYS */;
INSERT INTO `Crime_Criminal_Records` VALUES (7,11),(6,7);
/*!40000 ALTER TABLE `Crime_Criminal_Records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Criminal`
--

DROP TABLE IF EXISTS `Criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Criminal` (
  `criminal_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(6) NOT NULL,
  `identifying_mark` varchar(30) NOT NULL,
  `first_arrest_date` date DEFAULT NULL,
  `arrested_from_ps_area` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`criminal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Criminal`
--

LOCK TABLES `Criminal` WRITE;
/*!40000 ALTER TABLE `Criminal` DISABLE KEYS */;
INSERT INTO `Criminal` VALUES (1,'Prasad Thorat','2001-02-02','Male','Right Hand Facture','2022-12-01','Kalamboli'),(3,'Dattatray Patil','1998-01-01','Male','Mole on right leg ankle','2023-01-01','Kharghar'),(4,'Sugankumar Rajkumar','1999-02-23','Male','Mole on left hand palm','2022-02-28','Khandeshwar'),(5,'Naveen Kumar','2001-05-24','Male','fracture marks on left hand','2023-01-31','Kharghar'),(6,'Ankit Choubey','1996-07-26','Male','Mole on right ear','2021-08-23','Pune'),(7,'Piyush Sharma','1985-01-28','Male','Injury mark on right leg ankle','2008-01-24','Mumbai'),(8,'Harshitha','1980-09-15','Female','Mole on face new mouth','2001-08-18','Vashi'),(9,'Kancham Durga','1985-09-16','Female','Mole on right hand shoulder','2012-01-20','Mumbai'),(10,'Alka Sinha','1999-10-03','Female','Mole on right hand palm','2018-08-18','Kharghar'),(11,'Abhishek Ghadge','1984-11-11','Male','Injury mark on right shoulder','2012-09-23','Khandeshwar');
/*!40000 ALTER TABLE `Criminal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 19:40:32
