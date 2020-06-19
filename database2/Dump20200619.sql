CREATE DATABASE  IF NOT EXISTS `big_five_safari` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `big_five_safari`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: big_five_safari
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accomodatie`
--

DROP TABLE IF EXISTS `accomodatie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accomodatie` (
  `accomodatieCode` varchar(400) NOT NULL,
  `naam` varchar(300) NOT NULL,
  `stad` varchar(500) NOT NULL,
  `land` varchar(250) NOT NULL,
  `kamer` varchar(400) NOT NULL,
  `personen` int(11) NOT NULL,
  `soort` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`accomodatieCode`),
  CONSTRAINT `rexexpCode` CHECK (regexp_like(`accomodatieCode`, '^....[0-9]$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accomodatie`
--

LOCK TABLES `accomodatie` WRITE;
/*!40000 ALTER TABLE `accomodatie` DISABLE KEYS */;
INSERT INTO `accomodatie` VALUES ('HEVO1','Etosha Village','Okaukuejo','Namibië','Standaard kamer met 2 Bedden',2,'Hotel'),('HHIH1','Holiday Inn','Harare','Zimbabwe','Standaard kamer',3,'Hotel'),('HIBZ1','Indigo Beach','Zanzibar','Tanzania','Swahili-stijl budget tweepersoonskamer',2,'Hotel'),('HIBZ2','Indigo Beach','Zanzibar','Tanzania','Bungalow met uitzicht op de tuin',8,'Hotel'),('HPHC1','Premier Hotel Cape Town','Kaapstad','Zuid-Afrika','Familie loft met queensize bed en 2 aparte bedden',4,'Hotel'),('HRHB1','Bulawayo Rainbow Hotel','Bulawayo','Zimbabwe','Deluxe tweepersoonskamer',2,'Hotel'),('HRMS1','River Manor Boutique Hotel','Stellen Bosch','Zuid-Afrika','Loft studio kamer',2,'Hotel'),('HRMS2','River Manor Boutique Hotel','Stellen Bosch','Zuid-Afrika','Superior tweepersoonskamer',2,'Hotel'),('HSCW1','Safari Court Hotel','Windhoek','Namibië','Classic tweepersoonskamer met 2 aparte bedden',2,'Hotel'),('HZBK1','Zanbluu Beach Hotel','Kiwengwa','Tanzania','Superior Suite met uitzicht op zee en eigen zwembad',2,'Hotel'),('LAAC1','Sasa Safari Camp','Outjo','Namibië','Tweepersoonskamer met Uitzicht',2,'Safari lodge'),('LASL1','Africa Safari Lodge','Mariental','Namibië','Familiekamer',4,'Safari lodge'),('LBBL1','Baby Bush Lodge','Kiwengwa','Tanzania','Bruidssuite met Balkon',2,'Safari lodge'),('LIE1','Impala Ecolodge','Kisumu','Kenia','Luxe suite',2,'Safari lodge'),('LIML1','Immanuel Wilderness Lodge','Windhoek','Namibië','Tweepersoonskamer met Uitzicht op de Tuin',2,'Safari lodge'),('LML1','Mika Lodge','Lusaka','Zambia','Executive Suite',2,'Safari lodge'),('LNZL1','Ngoma Zanga Lodge','Livingstone','Zambia','Deluxe kamer met kingsize bed',3,'Safari lodge');
/*!40000 ALTER TABLE `accomodatie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `boekingsoverzicht`
--

DROP TABLE IF EXISTS `boekingsoverzicht`;
/*!50001 DROP VIEW IF EXISTS `boekingsoverzicht`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `boekingsoverzicht` AS SELECT 
 1 AS `naam`,
 1 AS `stad`,
 1 AS `land`,
 1 AS `kamer`,
 1 AS `naamReiziger`,
 1 AS `aankomstDatum`,
 1 AS `dagen`,
 1 AS `betaald`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotel` (
  `accomodatieCode` varchar(50) NOT NULL,
  `prijsPerNacht` float DEFAULT NULL,
  `ontbijt` varchar(100) NOT NULL,
  PRIMARY KEY (`accomodatieCode`),
  KEY `fk_verzinzelf_idx` (`accomodatieCode`),
  CONSTRAINT `fk_verzinzelf` FOREIGN KEY (`accomodatieCode`) REFERENCES `accomodatie` (`accomodatieCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('HEVO1',191,'Y'),('HHIH1',64,'N'),('HIBZ1',75,'Y'),('HIBZ2',243,'N'),('HPHC1',127,'N'),('HRHB1',90,'Y'),('HRMS1',99,'Y'),('HRMS2',166,'Y'),('HSCW1',105,'N'),('HZBK1',369,'Y');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reiziger`
--

DROP TABLE IF EXISTS `reiziger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reiziger` (
  `reizigersCode` varchar(250) NOT NULL,
  `voornaam` varchar(300) NOT NULL,
  `achternaam` varchar(300) NOT NULL,
  `adres` varchar(550) NOT NULL,
  `postcode` varchar(100) NOT NULL,
  `plaats` varchar(350) NOT NULL,
  `land` varchar(300) NOT NULL,
  `hoofdreiziger` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`reizigersCode`),
  KEY `fk_verzinzelf4_idx` (`hoofdreiziger`),
  CONSTRAINT `fk_verzinzelf4` FOREIGN KEY (`hoofdreiziger`) REFERENCES `reiziger` (`reizigersCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reiziger`
--

LOCK TABLES `reiziger` WRITE;
/*!40000 ALTER TABLE `reiziger` DISABLE KEYS */;
INSERT INTO `reiziger` VALUES ('FadilO','Omar','Fadil','Houtsberg 16','6091 NA','Leveroy','Nederland','FadilT'),('FadilT','Tahera','Fadil','Houtsberg 16','6091 NA','Leveroy','Nederland',NULL),('FonteijnC','Claar','Fonteijn','Castricummerwerf 70','1901 RF','Castricum','Nederland','MeijerP'),('JeremyB','Bram','Jeremy','Rijksstraatweg 289','3956 CP','Leersum','Nederland','JeremyD'),('JeremyD','Demitri','Jeremy','Rijksstraatweg 289','3956 CP','Leersum','Nederland',NULL),('JeremyD1','Devid','Jeremy','De Kronkels 25','3752 LM','Bunschoten','Nederland','JeremyD'),('MeijerP','Pieter','Meijer','Expeditiestraat 2','1135 GB','Edam','Nederland',NULL),('MulderD','Derek','Mulder','Lakenblekerstraat 49A','1431 GE','Aalsmeer','Nederland','MulderF'),('MulderF','Frank','Mulder','Lakenblekerstraat 49A','1431 GE','Aalsmeer','Nederland',NULL),('MulderS','Sophie','Mulder','Lakenblekerstraat 49A','1431 GE','Aalsmeer','Nederland','MulderF'),('NazariM','Moustafa','Nazari','Vlakdissen 12','1648 HJ','Den Goorn','Nederland',NULL),('NguyenR','Roy','Nguyen','Bukkemweg 1','5081 CT','Hilvarenbeek','Nederland',NULL),('RijenF','Fred','van Rijen','Einsteinstraat 10','1446 VG','Purmerend','Nederland','MulderF'),('WongH','Hu','Wong','Rembrandtstraat 7','3662 HN','Oud-Bijerland','Nederland',NULL);
/*!40000 ALTER TABLE `reiziger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservering`
--

DROP TABLE IF EXISTS `reservering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reservering` (
  `idReservering` int(11) NOT NULL,
  `accomodatieCode` varchar(400) DEFAULT NULL,
  `reizigersCode` varchar(400) DEFAULT NULL,
  `aankomstDatum` date DEFAULT NULL,
  `vertrekDatum` date DEFAULT NULL,
  `betaald` varchar(45) NOT NULL,
  PRIMARY KEY (`idReservering`),
  KEY `fk_verzinzelf2_idx` (`accomodatieCode`),
  KEY `fk_verzinzelf3_idx` (`reizigersCode`),
  CONSTRAINT `fk_verzinzelf2` FOREIGN KEY (`accomodatieCode`) REFERENCES `accomodatie` (`accomodatieCode`),
  CONSTRAINT `fk_verzinzelf3` FOREIGN KEY (`reizigersCode`) REFERENCES `reiziger` (`reizigersCode`),
  CONSTRAINT `checkDatum` CHECK (`aankomstDatum` < `vertrekDatum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservering`
--

LOCK TABLES `reservering` WRITE;
/*!40000 ALTER TABLE `reservering` DISABLE KEYS */;
INSERT INTO `reservering` VALUES (1,'HIBZ2','FadilT','2020-07-12','2020-07-19','Nee'),(2,'HSCW1','JeremyD','2020-07-10','2020-07-19','Ja'),(3,'HPHC1','WongH','2020-07-31','2020-08-05','Nee'),(4,'LBBL1','FadilT','2020-07-19','2020-07-23','Nee'),(5,'LNZL1','MulderF','2020-08-12','2020-08-14','Ja'),(6,'HRHB1','NazariM','2020-07-01','2020-07-05','Nee'),(7,'LNZL1','NazariM','2020-07-05','2020-07-08','Nee'),(8,'HRMS1','NguyenR','2020-07-24','2020-07-26','Ja'),(9,'HPHC1','NguyenR','2020-07-26','2020-07-31','Ja'),(10,'LIE1','NguyenR','2020-08-01','2020-08-06','Ja'),(11,'LAAC1','MeijerP','2020-08-19','2020-08-27','Nee'),(12,'LIML1','MeijerP','2020-08-27','2020-08-31','Nee');
/*!40000 ALTER TABLE `reservering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `safarilodge`
--

DROP TABLE IF EXISTS `safarilodge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `safarilodge` (
  `accomodatieCode` varchar(400) NOT NULL,
  `prijsPerWeek` float DEFAULT NULL,
  `autoHuur` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`accomodatieCode`),
  KEY `fk_verzinzelf1_idx` (`accomodatieCode`),
  CONSTRAINT `fk_verzinzelf1` FOREIGN KEY (`accomodatieCode`) REFERENCES `accomodatie` (`accomodatieCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `safarilodge`
--

LOCK TABLES `safarilodge` WRITE;
/*!40000 ALTER TABLE `safarilodge` DISABLE KEYS */;
INSERT INTO `safarilodge` VALUES ('LAAC1',447,'N'),('LASL1',946,'Y'),('LBBL1',939,'Y'),('LIE1',1182,'N'),('LIML1',788,'Y'),('LML1',1091,'Y'),('LNZL1',899,'Y');
/*!40000 ALTER TABLE `safarilodge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'big_five_safari'
--

--
-- Dumping routines for database 'big_five_safari'
--
/*!50003 DROP FUNCTION IF EXISTS `GeboektOp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `GeboektOp`(pCode VARCHAR(50), pDatum DATE) RETURNS varchar(50) CHARSET utf8
BEGIN
DECLARE reizigersCode varchar(50) DEFAULT NULL;
	SELECT reiziger_code into reizigersCode
    FROM big_five_safari.reservering
	WHERE accomodatieCode = pCode AND aankomstDatum = pDatum;
    
    IF reizigersCode is null
    THEN return null;
    ELSE
    return reizigersCode;
    
    end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verwijderAccommodatie` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verwijderAccommodatie`(IN pAccomodatieCode VARCHAR(400))
BEGIN
START TRANSACTION;
DELETE accomodatie FROM accomodatie
INNER join reservering on accomodatie.accomodatieCode = reservering.accomodatieCode
WHERE reservering.betaald = 'Ja' and accomodatie.accomodatieCode = pAccomodatieCode;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `boekingsoverzicht`
--

/*!50001 DROP VIEW IF EXISTS `boekingsoverzicht`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `boekingsoverzicht` AS select `accomodatie`.`naam` AS `naam`,`accomodatie`.`stad` AS `stad`,`accomodatie`.`land` AS `land`,`accomodatie`.`kamer` AS `kamer`,concat(`reiziger`.`voornaam`,' ',`reiziger`.`achternaam`) AS `naamReiziger`,`reservering`.`aankomstDatum` AS `aankomstDatum`,(to_days(`reservering`.`vertrekDatum`) - to_days(`reservering`.`aankomstDatum`)) AS `dagen`,`reservering`.`betaald` AS `betaald` from ((`reservering` join `reiziger` on((`reiziger`.`reizigersCode` = `reservering`.`reizigersCode`))) join `accomodatie` on((`accomodatie`.`accomodatieCode` = `reservering`.`accomodatieCode`))) order by `reservering`.`aankomstDatum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-19 22:42:18
