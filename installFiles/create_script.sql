-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: skijumping
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `all_time_points_system`
--

DROP TABLE IF EXISTS `all_time_points_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `all_time_points_system` (
  `idall_time_points_system` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `pos_1` decimal(4,1) unsigned DEFAULT NULL,
  `pos_2` decimal(4,1) unsigned DEFAULT NULL,
  `pos_3` decimal(4,1) unsigned DEFAULT NULL,
  `pos_4` decimal(4,1) unsigned DEFAULT NULL,
  `pos_5` decimal(4,1) unsigned DEFAULT NULL,
  `pos_6` decimal(4,1) unsigned DEFAULT NULL,
  `pos_7` decimal(4,1) unsigned DEFAULT NULL,
  `pos_8` decimal(4,1) unsigned DEFAULT NULL,
  `pos_9` decimal(4,1) unsigned DEFAULT NULL,
  `pos_10` decimal(4,1) unsigned DEFAULT NULL,
  `pos_11` decimal(4,1) unsigned DEFAULT NULL,
  `pos_12` decimal(4,1) unsigned DEFAULT NULL,
  `pos_13` decimal(4,1) unsigned DEFAULT NULL,
  `pos_14` decimal(4,1) unsigned DEFAULT NULL,
  `pos_15` decimal(4,1) unsigned DEFAULT NULL,
  `pos_16` decimal(4,1) unsigned DEFAULT NULL,
  `pos_17` decimal(4,1) unsigned DEFAULT NULL,
  `pos_18` decimal(4,1) unsigned DEFAULT NULL,
  `pos_19` decimal(4,1) unsigned DEFAULT NULL,
  `pos_20` decimal(4,1) unsigned DEFAULT NULL,
  PRIMARY KEY (`idall_time_points_system`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `all_time_points_system`
--

LOCK TABLES `all_time_points_system` WRITE;
/*!40000 ALTER TABLE `all_time_points_system` DISABLE KEYS */;
INSERT INTO `all_time_points_system` VALUES (1,30.0,18.0,15.0,12.0,10.0,8.0,6.0,4.0,2.0,1.0,0.5,0.5,0.5,0.5,0.5,NULL,NULL,NULL,NULL,NULL),(2,45.0,27.0,22.5,18.0,15.0,12.0,9.0,6.0,3.0,1.5,1.0,1.0,1.0,1.0,1.0,NULL,NULL,NULL,NULL,NULL),(3,90.0,54.0,45.0,36.0,30.0,24.0,18.0,12.0,6.0,3.0,2.0,2.0,2.0,2.0,2.0,1.0,1.0,1.0,1.0,1.0),(4,150.0,90.0,75.0,60.0,50.0,40.0,30.0,20.0,10.0,5.0,4.0,4.0,4.0,4.0,4.0,3.0,3.0,3.0,3.0,3.0);
/*!40000 ALTER TABLE `all_time_points_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `idcity` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `region_idregion` mediumint unsigned NOT NULL,
  PRIMARY KEY (`idcity`),
  KEY `fk_city_region1_idx` (`region_idregion`),
  CONSTRAINT `fk_city_region1` FOREIGN KEY (`region_idregion`) REFERENCES `region` (`idregion`)
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Planica',12),(2,'Bystra',227),(3,'Katowice',227),(4,'Zakopane',221),(5,'Bielsko-Biała',227),(6,'Chochołów',221),(7,'Szczyrk',227),(8,'Karpacz',217),(9,'Biały Dunajec',221),(10,'Poronin',221),(11,'Goleszów',227),(12,'Lubawka',217),(13,'Gilowice',227),(14,'Stare Bystre',221),(15,'Zagórz',226),(16,'Gdańsk',220),(17,'Rzeszów',226),(18,'Olsztyn',223),(19,'Wisła',227),(20,'Höhnhart',18),(21,'Seekirchen',19),(22,'Muerzzuschlag',20),(23,'Absam',21),(24,'Klagenfurt',1),(25,'Kitzbühel',21),(26,'Fohnsdorf',20),(27,'Bad Ischl',18),(28,'Sankt Anton am Arlberg',21),(29,'Bischofshofen',19),(30,'Breitenwang',21),(31,'Egg',22),(32,'Ehrwald',21),(34,'Trofaiach',20),(35,'Fieberbrunn',21),(36,'Kehlegg',22),(37,'Mayrhofen',21),(38,'Rottenmann',20),(39,'Saalfelden',19),(40,'Schwarzenberg ',22),(41,'Waldzell',18),(42,'Wörgl',21),(43,'Langenegg',22),(45,'Telfs',21),(46,'Achomitz',1),(47,'Bad Goisern',18),(48,'Riezlern',22),(49,'Dornbirn',22),(50,'Innsbruck',21),(51,'Schwarzach im Pongau',19),(52,'Villach',1),(53,'Hittisau',22),(54,'Velden',1),(55,'Sankt Veit im Pongau',19),(56,'Hinzenbach',18),(57,'Rauris',19),(58,'Ramingstein',19),(59,'Bad Mitterndorf',20),(60,'Andelsbuch',22),(61,'Bad Hofgastein',19),(62,'Eisenerz',20),(63,'Murau',20),(64,'Ramsau',20),(65,'Schoppernau',22),(66,'Sibratsgfaell',22),(67,'Tschagguns',22),(68,'Vomp',21),(69,'Haus im Ennstal',20),(70,'Wien',23),(71,'Liberec',71),(72,'Calgary',24),(73,'Frenstat',75),(74,'Desna',71),(75,'Lomnice nad Popelkou',71),(76,'Nové Město na Moravě',69),(77,'Kozlovice',75),(78,'Harrachov',71),(79,'Frenštát pod Radhoštěm',75),(81,'Rožnov pod Radhoštěm',69),(82,'Trinec',75),(83,'Andsumäe',92),(84,'Tallinn',78),(85,'Otepää',90),(86,'Elva',89),(87,'Voru',92),(88,'Vagula',92),(92,'Harjavalta',438),(93,'Helsinki',442),(94,'Hyvinkää',443),(95,'Jyvaskyla',433),(96,'Kajaani',428),(97,'Kitee',429),(98,'Kouvola',441),(99,'Kuusamo',97),(100,'Lahti',439),(101,'Lapua',434),(102,'Lieksa',429),(103,'Rovaniemi',95),(104,'Paimio',443),(105,'Kuopio',430),(106,'Saarijärvi',433),(107,'Seinäjoki',434),(108,'Siilinjärvi',430),(109,'Simpele',432),(110,'Taivalkoski',97),(111,'Tampere',437),(112,'Vuokatti',428),(113,'Ylistaro',434),(114,'Gérardmer',450),(115,'Annecy',445),(116,'Mouthe',446),(117,'Annemasse',445),(118,'Autrans',445),(119,'Bois-d\'Amont',446),(120,'Courchevel',445),(121,'Chamonix',445),(122,'Chaux-Neuve',446),(123,'Pontarlier',446),(124,'Frasne',446),(125,'La Rosière',446),(126,'Le Bonhomme',450),(127,'Le Grand Bornand',445),(128,'Les Contamines-Montjoie',445),(129,'Les Fourgs',446),(130,'Les Houches',446),(131,'Plateau-des-Petites-Roches',445),(132,'Les Rousses',446),(133,'Mont Noir',451),(134,'Morbier',446),(135,'Morzine',445),(136,'Les Hôpitaux-Vieux',446),(137,'Oye-et-Pallet',446),(138,'Prémanon',446),(139,'Méribel',445),(140,'Saint-Gervais, Isère',445),(141,'Xonrupt-Longemer',450),(142,'Samoëns',445),(143,'Ventron',450),(144,'Schwarzenberg',116),(145,'Rittersgrün',116),(146,'Oberwiesenthal',116),(147,'Oberstdorf',110),(148,'Wartenberg',110),(149,'Bischofsgrün',110),(150,'Eisenbach',109),(151,'Degenfeld (Schwäbisch Gmünd)',109),(152,'Furtwangen im Schwarzwald',109),(153,'Siegsdorf',110),(154,'Hinterzarten',109),(155,'Königsbronn',109),(156,'Lüdenscheid',114),(157,'Menzenschwand',109),(158,'Zella-Mehlis',118),(159,'Titisee-Neustadt',109),(160,'Garmisch-Partenkirchen',110),(161,'Ruhpolding',110),(162,'Schönwald im Schwarzwald',109),(163,'Schonach im Schwarzwald',109),(164,'Steinbach-Hallenberg',118),(165,'Traunstein',110),(166,'Villingen-Schwenningen',109),(167,'Wiesensteig',109),(168,'Willingen',111),(169,'Gmund am Tegernsee',110),(170,'Aue-Bad Schlema',116),(171,'Berchtesgaden',110),(172,'Meinerzhagen',114),(173,'Winterberg',114),(174,'Scheibenberg',116),(175,'Baiersbronn',109),(176,'Biberau',118),(177,'Cursdorf',118),(178,'Eilenburg',116),(179,'Meßstetten',109),(180,'Freudenstadt',109),(181,'Mitteltal',109),(182,'Stützengrün',116),(183,'Zschopau',116),(184,'Goldlauter-Heidersbach',118),(185,'Bad Griesbach im Rottal',110),(186,'Breitnau',109),(187,'Eberbach',109),(188,'Geyer',116),(189,'Bad Tabarz',118),(190,'Buchenberg',110),(191,'Neuenrade',114),(192,'Klingenthal',116),(193,'Pfullingen',109),(194,'Ruhla',118),(195,'Rodewisch',116),(196,'Johanngeorgenstadt',116),(197,'Lauscha',118),(198,'Bad Freienwalde (Oder)',107),(199,'Aschau im Chiemgau',110),(200,'Braunlage',113),(201,'Brotterode',118),(202,'Rastbüchl',110),(203,'Grüna (Chemnitz)',116),(204,'Isny im Allgäu',109),(205,'Kiefersfelden',110),(206,'Kleinschmalkalden',118),(207,'Oberschönau',118),(208,'Oberaudorf',110),(209,'Oberhof',118),(210,'Reit im Winkl',110),(211,'Schmiedefeld am Rennsteig',118),(212,'Warmensteinach',110),(213,'Otterskirchen',110),(214,'Berlin',108),(215,'Munich',110),(216,'Dortmund',114),(217,'Cologne',114),(218,'Aachen',114),(219,'Blasiwald und Unterkrummen',109),(223,'Sopot',220),(224,'Gdynia',220),(225,'Rumia',220),(226,'Nowy Targ',221),(227,'Szaflary',221),(229,'Ustrzyki Górne',226),(230,'Ustrzyki Dolne',226),(231,'Wrocław',217),(233,'Ustroń',227),(234,'Dzianisz',221),(235,'Ząb',221),(236,'Czarny Dunajec',221),(237,'Kartuzy',220),(238,'Kościerzyna',220),(239,'Przywidz',220),(240,'Pruszcz Gdański',220),(241,'Szklarska Poręba',217),(242,'Szlembark',221),(243,'Chojnice',220),(244,'Toggenburg',338),(245,'Einsiedeln',326),(246,'Kandersteg',323),(247,'Jelenia Góra',227),(248,'Almaty',165),(249,'Shchuchinsk',163),(250,'Moscow',307),(251,'Krasnoyarsk',254),(252,'Nizhny Tagil',296),(253,'Żukowo',220),(254,'Reda',220),(256,'Wejherowo',220),(258,'Elbląg',220),(262,'Rasnov',230),(263,'Kielce',228),(265,'Oslo',203),(266,'Tczew',220),(267,'Knurow',221),(268,'Lublin',222),(269,'Asiago',146),(270,'Szczecin',458),(271,'Police',458),(272,'Toruń',459),(273,'Sapporo',147),(274,'Tokyo',155),(275,' Breitenbrunn/Erzgebirge',116),(276,'Zielona Góra',219),(277,'Paris',452),(278,'Rum',21),(279,'Čeladná',75),(280,'Pragelato',140),(281,'Grabs',338),(282,'Spittal an der Drau',1),(283,'Ruka',97),(284,'Seefeld in Tirol',21),(285,'Ried im Innkreis',18),(286,'Krasnaya Polyana',253),(287,'Stams',21),(288,'Bydgoszcz',459),(289,'Å',207),(290,'Trondheim',214),(291,'Bergen',213),(292,'Drammen',209),(293,'Moss',209),(294,'Aremark',209),(295,'Skiptvet',209),(296,'Ås',209),(297,'Lillestrøm',209),(298,'Nes',209),(299,'Lørenskog',209),(300,'Ullensaker',209),(301,'Vikersund',209),(302,'Hel',220),(303,'Seeboden',1),(304,'Jablonec nad Nisou',71),(305,'Schwäbisch Gmünd',109),(306,'Schwäbisch Gmünd',109),(307,'Buczkowice',227),(308,'Hachimantai',149),(309,'Linz',18),(310,'Jesenice',12),(311,'Salzburg',19),(312,'Lillehammer',210),(313,'Kranj',12),(324,'AAAAAAAAa',18),(325,'AAAAAAAAWEQ',17),(326,'BBBBBBBBBBBBBBB',67);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competition`
--

DROP TABLE IF EXISTS `competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competition` (
  `idcompetition` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `season_idseason` tinyint unsigned NOT NULL,
  `date_1` date NOT NULL,
  `date_2` date DEFAULT NULL,
  `series_idseries_major` tinyint unsigned NOT NULL,
  `series_idseries_minor` tinyint unsigned DEFAULT NULL,
  `hill_version_idhill_version` mediumint unsigned NOT NULL,
  `meter_value` decimal(2,1) unsigned DEFAULT '0.0' COMMENT 'Points per meter.',
  `gate_factor` decimal(4,2) unsigned DEFAULT '0.00' COMMENT 'Points per meter.\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n',
  `wind_factor_tail` decimal(4,2) unsigned DEFAULT '0.00' COMMENT 'Points per m/s.',
  `wind_factor_front` decimal(4,2) unsigned DEFAULT '0.00' COMMENT 'Points per m/s.\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n',
  `first_round_start_time` time DEFAULT NULL,
  `first_round_base_gate` tinyint unsigned DEFAULT NULL,
  `first_round_air_temp_start` decimal(3,1) DEFAULT NULL,
  `first_round_air_temp_finish` decimal(3,1) DEFAULT NULL,
  `first_round_snow_temp_start` decimal(3,1) DEFAULT NULL,
  `first_round_snow_temp_finish` decimal(3,1) DEFAULT NULL,
  `first_round_humidity_start` decimal(3,1) unsigned DEFAULT NULL,
  `first_round_humidity_finish` decimal(3,1) unsigned DEFAULT NULL,
  `first_round_min_wind` decimal(4,2) DEFAULT NULL,
  `first_round_max_wind` decimal(4,2) DEFAULT NULL,
  `first_round_avg_wind` decimal(4,2) DEFAULT NULL,
  `second_round_start_time` datetime DEFAULT NULL,
  `second_round_end_time` datetime DEFAULT NULL,
  `second_round_base_gate` tinyint unsigned DEFAULT NULL,
  `second_round_air_temp_finish` decimal(3,1) DEFAULT NULL,
  `second_round_snow_temp_start` decimal(3,1) DEFAULT NULL,
  `second_round_snow_temp_finish` decimal(3,1) DEFAULT NULL,
  `second_round_humidity_start` decimal(3,1) unsigned DEFAULT NULL,
  `second_round_humidity_finish` decimal(3,1) unsigned DEFAULT NULL,
  `second_round_min_wind` decimal(4,2) DEFAULT NULL,
  `second_round_max_wind` decimal(4,2) DEFAULT NULL,
  `second_round_avg_wind` decimal(4,2) DEFAULT NULL,
  `third_round_start_time` datetime DEFAULT NULL,
  `third_round_end_time` datetime DEFAULT NULL,
  `third_round_base_gate` tinyint unsigned DEFAULT NULL,
  `third_round_air_temp_start` decimal(3,1) DEFAULT NULL,
  `third_round_air_temp_finish` decimal(3,1) DEFAULT NULL,
  `third_round_snow_temp_start` decimal(3,1) DEFAULT NULL,
  `third_round_snow_temp_finish` decimal(3,1) DEFAULT NULL,
  `third_round_humidity_start` decimal(3,1) unsigned DEFAULT NULL,
  `third_round_humidity_finish` decimal(3,1) unsigned DEFAULT NULL,
  `third_round_min_wind` decimal(4,2) DEFAULT NULL,
  `third_round_max_wind` decimal(4,2) DEFAULT NULL,
  `third_round_avg_wind` decimal(4,2) DEFAULT NULL,
  `fourth_round_start_time` datetime DEFAULT NULL,
  `fourth_round_end_time` datetime DEFAULT NULL,
  `fourth_round_base_gate` tinyint unsigned DEFAULT NULL,
  `fourth_round_air_temp_start` decimal(3,1) DEFAULT NULL,
  `fourth_round_air_temp_finish` decimal(3,1) DEFAULT NULL,
  `fourth_round_snow_temp_start` decimal(3,1) DEFAULT NULL,
  `fourth_round_snow_temp_finish` decimal(3,1) DEFAULT NULL,
  `fourth_round_humidity_start` decimal(3,1) unsigned DEFAULT NULL,
  `fourth_round_humidity_finish` decimal(3,1) unsigned DEFAULT NULL,
  `fourth_round_min_wind` decimal(4,2) DEFAULT NULL,
  `fourth_round_max_wind` decimal(4,2) DEFAULT NULL,
  `fourth_round_avg_wind` decimal(4,2) DEFAULT NULL,
  `weather_idweather` tinyint unsigned DEFAULT NULL,
  `is_team` tinyint unsigned DEFAULT '0',
  `first_round_end_time` datetime DEFAULT NULL,
  `second_round_air_temp_start` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`idcompetition`),
  KEY `fk_competition_season1_idx` (`season_idseason`),
  KEY `fk_competition_series1_idx` (`series_idseries_major`),
  KEY `fk_competition_series2_idx` (`series_idseries_minor`),
  KEY `fk_competition_hill_version1_idx` (`hill_version_idhill_version`),
  KEY `fk_competition_weather1_idx` (`weather_idweather`),
  CONSTRAINT `fk_competition_hill_version1` FOREIGN KEY (`hill_version_idhill_version`) REFERENCES `hill_version` (`idhill_version`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_competition_season1` FOREIGN KEY (`season_idseason`) REFERENCES `season` (`idseason`),
  CONSTRAINT `fk_competition_series1` FOREIGN KEY (`series_idseries_major`) REFERENCES `series` (`idseries`),
  CONSTRAINT `fk_competition_series2` FOREIGN KEY (`series_idseries_minor`) REFERENCES `series` (`idseries`),
  CONSTRAINT `fk_competition_weather1` FOREIGN KEY (`weather_idweather`) REFERENCES `weather` (`idweather`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competition`
--

LOCK TABLES `competition` WRITE;
/*!40000 ALTER TABLE `competition` DISABLE KEYS */;
INSERT INTO `competition` VALUES (68,102,'2021-03-21',NULL,28,40,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(69,102,'2021-04-06',NULL,54,NULL,7,1.8,NULL,NULL,2.34,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(72,102,'2020-12-10','2020-12-10',5,NULL,1,1.2,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(73,103,'2022-01-03',NULL,16,NULL,9,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(82,102,'2021-03-18',NULL,9,10,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(84,102,'2021-03-05',NULL,3,NULL,9,NULL,NULL,NULL,NULL,'13:00:00',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(85,102,'2021-02-13',NULL,9,NULL,11,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(86,102,'2020-12-29',NULL,9,12,9,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(88,102,'2020-11-29',NULL,9,NULL,26,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(91,102,'2021-02-14',NULL,9,NULL,11,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(94,101,'2019-12-29',NULL,9,NULL,9,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(103,101,'2020-01-26',NULL,9,NULL,11,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(111,101,'2020-03-01',NULL,9,NULL,7,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(112,101,'2020-02-28',NULL,9,NULL,7,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(124,102,'2020-11-28',NULL,9,NULL,26,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(126,102,'2021-01-24',NULL,9,NULL,7,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(127,102,'2021-03-28',NULL,9,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(129,101,'2019-11-30',NULL,9,NULL,26,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(139,100,'2018-12-30',NULL,9,12,9,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(141,98,'2017-03-02',NULL,3,NULL,7,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(142,98,'2017-02-25',NULL,3,NULL,8,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(143,95,'2014-03-02',NULL,9,NULL,7,1.8,NULL,NULL,NULL,'10:00:00',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(146,102,'2021-04-24',NULL,38,NULL,26,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL),(147,102,'2021-01-03',NULL,9,12,27,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(148,102,'2021-01-01',NULL,9,12,28,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(165,97,'2016-01-24',NULL,9,NULL,11,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(166,102,'2021-04-12',NULL,38,NULL,26,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(167,102,'2021-01-06',NULL,9,12,29,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(169,102,'2021-01-16',NULL,11,NULL,11,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL),(170,102,'2021-01-17',NULL,9,NULL,11,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(171,102,'2021-01-23',NULL,11,NULL,7,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL),(175,93,'2011-12-29',NULL,9,12,9,NULL,NULL,NULL,NULL,'14:00:00',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(176,93,'2012-01-01',NULL,9,12,28,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `competition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `idcountry` smallint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `code` char(3) NOT NULL,
  PRIMARY KEY (`idcountry`)
) ENGINE=InnoDB AUTO_INCREMENT=754 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (501,'Afghanistan','AFG'),(502,'Åland','ALA'),(503,'Albania','ALB'),(504,'Algeria','DZA'),(505,'American Samoa','ASM'),(506,'Andorra','AND'),(507,'Angola','AGO'),(508,'Anguilla','AIA'),(509,'Antarctica','ATA'),(510,'Antigua and Barbuda','ATG'),(511,'Argentina','ARG'),(512,'Armenia','ARM'),(513,'Aruba','ABW'),(514,'Australia','AUS'),(515,'Austria','AUT'),(516,'Azerbaijan','AZE'),(517,'Bahamas','BHS'),(518,'Bahrain','BHR'),(519,'Bangladesh','BGD'),(520,'Barbados','BRB'),(521,'Belarus','BLR'),(522,'Belgium','BEL'),(523,'Belize','BLZ'),(524,'Benin','BEN'),(525,'Bermuda','BMU'),(526,'Bhutan','BTN'),(527,'Bolivia','BOL'),(528,'Bonaire','BES'),(529,'Bosnia and Herzegovina','BIH'),(530,'Botswana','BWA'),(531,'Bouvet Island','BVT'),(532,'Brazil','BRA'),(533,'British Indian Ocean Territory','IOT'),(534,'British Virgin Islands','VGB'),(535,'Brunei','BRN'),(536,'Bulgaria','BGR'),(537,'Burkina Faso','BFA'),(538,'Burundi','BDI'),(539,'Cambodia','KHM'),(540,'Cameroon','CMR'),(541,'Canada','CAN'),(542,'Cape Verde','CPV'),(543,'Cayman Islands','CYM'),(544,'Central African Republic','CAF'),(545,'Chad','TCD'),(546,'Chile','CHL'),(547,'China','CHN'),(548,'Christmas Island','CXR'),(549,'Cocos [Keeling] Islands','CCK'),(550,'Colombia','COL'),(551,'Comoros','COM'),(552,'Cook Islands','COK'),(553,'Costa Rica','CRI'),(554,'Croatia','HRV'),(555,'Cuba','CUB'),(556,'Curacao','CUW'),(557,'Cyprus','CYP'),(558,'Czech Republic','CZE'),(559,'Democratic Republic of the Congo','COD'),(560,'Denmark','DNK'),(561,'Djibouti','DJI'),(562,'Dominica','DMA'),(563,'Dominican Republic','DOM'),(564,'East Timor','TLS'),(565,'Ecuador','ECU'),(566,'Egypt','EGY'),(567,'El Salvador','SLV'),(568,'Equatorial Guinea','GNQ'),(569,'Eritrea','ERI'),(570,'Estonia','EST'),(571,'Ethiopia','ETH'),(572,'Falkland Islands','FLK'),(573,'Faroe Islands','FRO'),(574,'Fiji','FJI'),(575,'Finland','FIN'),(576,'France','FRA'),(577,'French Guiana','GUF'),(578,'French Polynesia','PYF'),(579,'French Southern Territories','ATF'),(580,'Gabon','GAB'),(581,'Gambia','GMB'),(582,'Georgia','GEO'),(583,'Germany','GER'),(584,'Ghana','GHA'),(585,'Gibraltar','GIB'),(586,'Greece','GRC'),(587,'Greenland','GRL'),(588,'Grenada','GRD'),(589,'Guadeloupe','GLP'),(590,'Guam','GUM'),(591,'Guatemala','GTM'),(592,'Guernsey','GGY'),(593,'Guinea','GIN'),(594,'Guinea-Bissau','GNB'),(595,'Guyana','GUY'),(596,'Haiti','HTI'),(597,'Heard Island and McDonald Islands','HMD'),(598,'Honduras','HND'),(599,'Hong Kong','HKG'),(600,'Hungary','HUN'),(601,'Iceland','ISL'),(602,'India','IND'),(603,'Indonesia','IDN'),(604,'Iran','IRN'),(605,'Iraq','IRQ'),(606,'Ireland','IRL'),(607,'Isle of Man','IMN'),(608,'Israel','ISR'),(609,'Italy','ITA'),(610,'Ivory Coast','CIV'),(611,'Jamaica','JAM'),(612,'Japan','JPN'),(613,'Jersey','JEY'),(614,'Jordan','JOR'),(615,'Kazakhstan','KAZ'),(616,'Kenya','KEN'),(617,'Kiribati','KIR'),(618,'Kosovo','XKX'),(619,'Kuwait','KWT'),(620,'Kyrgyzstan','KGZ'),(621,'Laos','LAO'),(622,'Latvia','LVA'),(623,'Lebanon','LBN'),(624,'Lesotho','LSO'),(625,'Liberia','LBR'),(626,'Libya','LBY'),(627,'Liechtenstein','LIE'),(628,'Lithuania','LTU'),(629,'Luxembourg','LUX'),(630,'Macao','MAC'),(631,'Macedonia','MKD'),(632,'Madagascar','MDG'),(633,'Malawi','MWI'),(634,'Malaysia','MYS'),(635,'Maldives','MDV'),(636,'Mali','MLI'),(637,'Malta','MLT'),(638,'Marshall Islands','MHL'),(639,'Martinique','MTQ'),(640,'Mauritania','MRT'),(641,'Mauritius','MUS'),(642,'Mayotte','MYT'),(643,'Mexico','MEX'),(644,'Micronesia','FSM'),(645,'Moldova','MDA'),(646,'Monaco','MCO'),(647,'Mongolia','MNG'),(648,'Montenegro','MNE'),(649,'Montserrat','MSR'),(650,'Morocco','MAR'),(651,'Mozambique','MOZ'),(652,'Myanmar [Burma]','MMR'),(653,'Namibia','NAM'),(654,'Nauru','NRU'),(655,'Nepal','NPL'),(656,'Netherlands','NLD'),(657,'New Caledonia','NCL'),(658,'New Zealand','NZL'),(659,'Nicaragua','NIC'),(660,'Niger','NER'),(661,'Nigeria','NGA'),(662,'Niue','NIU'),(663,'Norfolk Island','NFK'),(664,'North Korea','PRK'),(665,'Northern Mariana Islands','MNP'),(666,'Norway','NOR'),(667,'Oman','OMN'),(668,'Pakistan','PAK'),(669,'Palau','PLW'),(670,'Palestine','PSE'),(671,'Panama','PAN'),(672,'Papua New Guinea','PNG'),(673,'Paraguay','PRY'),(674,'Peru','PER'),(675,'Philippines','PHL'),(676,'Pitcairn Islands','PCN'),(677,'Poland','POL'),(678,'Portugal','PRT'),(679,'Puerto Rico','PRI'),(680,'Qatar','QAT'),(681,'Republic of the Congo','COG'),(682,'Réunion','REU'),(683,'Romania','ROU'),(684,'Russia','RUS'),(685,'Rwanda','RWA'),(686,'Saint Barthélemy','BLM'),(687,'Saint Helena','SHN'),(688,'Saint Kitts and Nevis','KNA'),(689,'Saint Lucia','LCA'),(690,'Saint Martin','MAF'),(691,'Saint Pierre and Miquelon','SPM'),(692,'Saint Vincent and the Grenadines','VCT'),(693,'Samoa','WSM'),(694,'San Marino','SMR'),(695,'São Tomé and Príncipe','STP'),(696,'Saudi Arabia','SAU'),(697,'Senegal','SEN'),(698,'Serbia','SRB'),(699,'Seychelles','SYC'),(700,'Sierra Leone','SLE'),(701,'Singapore','SGP'),(702,'Sint Maarten','SXM'),(703,'Slovakia','SVK'),(704,'Slovenia','SLO'),(705,'Solomon Islands','SLB'),(706,'Somalia','SOM'),(707,'South Africa','ZAF'),(708,'South Georgia and the South Sandwich Islands','SGS'),(709,'South Korea','KOR'),(710,'South Sudan','SSD'),(711,'Spain','ESP'),(712,'Sri Lanka','LKA'),(713,'Sudan','SDN'),(714,'Suriname','SUR'),(715,'Svalbard and Jan Mayen','SJM'),(716,'Swaziland','SWZ'),(717,'Sweden','SWE'),(718,'Switzerland','SUI'),(719,'Syria','SYR'),(720,'Taiwan','TWN'),(721,'Tajikistan','TJK'),(722,'Tanzania','TZA'),(723,'Thailand','THA'),(724,'Togo','TGO'),(725,'Tokelau','TKL'),(726,'Tonga','TON'),(727,'Trinidad and Tobago','TTO'),(728,'Tunisia','TUN'),(729,'Turkey','TUR'),(730,'Turkmenistan','TKM'),(731,'Turks and Caicos Islands','TCA'),(732,'Tuvalu','TUV'),(733,'U.S. Minor Outlying Islands','UMI'),(734,'U.S. Virgin Islands','VIR'),(735,'Uganda','UGA'),(736,'Ukraine','UKR'),(737,'United Arab Emirates','ARE'),(738,'United Kingdom','GBR'),(739,'United States','USA'),(740,'Uruguay','URY'),(741,'Uzbekistan','UZB'),(742,'Vanuatu','VUT'),(743,'Vatican City','VAT'),(744,'Venezuela','VEN'),(745,'Vietnam','VNM'),(746,'Wallis and Futuna','WLF'),(747,'Western Sahara','ESH'),(748,'Yemen','YEM'),(749,'Zambia','ZMB'),(750,'Zimbabwe','ZWE');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disqualification_type`
--

DROP TABLE IF EXISTS `disqualification_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disqualification_type` (
  `iddisqualification_type` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `disqualification_type` varchar(45) NOT NULL,
  PRIMARY KEY (`iddisqualification_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disqualification_type`
--

LOCK TABLES `disqualification_type` WRITE;
/*!40000 ALTER TABLE `disqualification_type` DISABLE KEYS */;
INSERT INTO `disqualification_type` VALUES (1,'none'),(2,'skis'),(3,'suit'),(4,'boots'),(5,'dsq'),(6,'dns');
/*!40000 ALTER TABLE `disqualification_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `idgender` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`idgender`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Female'),(2,'Male');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hill`
--

DROP TABLE IF EXISTS `hill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hill` (
  `idhill` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `venue_idvenue` mediumint unsigned NOT NULL,
  `size_of_hill_idsize_of_hill` tinyint unsigned NOT NULL,
  `photo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idhill`),
  KEY `fk_hill_venue1_idx` (`venue_idvenue`),
  KEY `fk_hill_size_of_hill1_idx` (`size_of_hill_idsize_of_hill`),
  CONSTRAINT `fk_hill_size_of_hill1` FOREIGN KEY (`size_of_hill_idsize_of_hill`) REFERENCES `size_of_hill` (`idsize_of_hill`),
  CONSTRAINT `fk_hill_venue1` FOREIGN KEY (`venue_idvenue`) REFERENCES `venue` (`idvenue`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hill`
--

LOCK TABLES `hill` WRITE;
/*!40000 ALTER TABLE `hill` DISABLE KEYS */;
INSERT INTO `hill` VALUES (1,'Letalnica Bratov Gorisek',1,5,NULL),(8,'Salpausselkä',9,4,NULL),(9,'Salpausselkä',9,3,NULL),(11,'Schattenberg',12,4,NULL),(12,'Skocznia im. Adama Małysza w Wiśle-Malince',13,4,'malinka.jpg-aa6c75d1-5c16-4da7-b090-45c34b695285'),(21,'Wielka Krokiew im. Stanisława Marusarza',2,4,'zakopane.jpg-25055246-f7a1-4944-8606-f1e2eab6a510'),(72,'Rukatunturi',11,4,NULL),(73,'Bergisel',15,4,NULL),(74,'Große Olympiaschanze',14,4,NULL),(75,'Paul-Ausserleitner-Schanze',5,4,NULL),(76,'Certak',7,4,NULL),(77,'UAS',18,4,NULL);
/*!40000 ALTER TABLE `hill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hill_version`
--

DROP TABLE IF EXISTS `hill_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hill_version` (
  `idhill_version` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `hill_idhill` mediumint unsigned NOT NULL,
  `first_year` smallint unsigned DEFAULT NULL,
  `last_year` smallint unsigned DEFAULT NULL,
  `k_point` decimal(4,1) unsigned NOT NULL,
  `hill_size` decimal(4,1) unsigned DEFAULT NULL,
  `inrun_length` decimal(5,2) unsigned DEFAULT NULL,
  `es` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Length of the inrun from the lowest to the highest start.',
  `gamma` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Angle of the straight part of the inrun.',
  `r1` decimal(5,2) DEFAULT NULL COMMENT 'Radius of the transition curve in E2 (End of the transition curve; beginning of the table).',
  `t` decimal(4,2) unsigned DEFAULT NULL,
  `alpha` decimal(4,2) unsigned DEFAULT NULL,
  `s` decimal(3,2) unsigned DEFAULT NULL,
  `v0` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Speed at the end of the inrun.',
  `h` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Height difference between take-off and K-point.',
  `n` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Horizontal distance between take-off and K-point.',
  `P` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Beginning of the landing area',
  `l1` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Length of the curve between beginning of the landing area (P) and K.',
  `l2` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Length of the curve between K and end of the landing area (L).',
  `beta_p` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Angle at P.',
  `beta` decimal(4,2) unsigned DEFAULT NULL,
  `beta_l` decimal(4,2) unsigned DEFAULT NULL,
  `L` decimal(5,2) unsigned DEFAULT NULL COMMENT 'End of the landing area.',
  `rl` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Radius of the circular landing area',
  `r2` decimal(5,2) DEFAULT NULL COMMENT 'Radius of the transition curve from L to U at U (end of the transition curve to the outrun).',
  `a` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Length of the outrun after the end of the transition curve to the outrun.',
  `fis_certificate` varchar(120) DEFAULT NULL,
  `b1` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Prepared width of the inrun.',
  `b2` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Width of the knoll at the base of the takeoff',
  `bk` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Width at K',
  `bu` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Width at the end of the transition curve to the outrun (U).',
  `d` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Horizontal distance between the takeoff and the projected middle of the lowest\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\njudge cabin along the jumping hill axis line.',
  `q` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Horizontal distance between the front of the judge tower and the jumping hill\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\naxis line\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\r.',
  `valid_since` date DEFAULT NULL,
  `valid_until` date DEFAULT NULL,
  `e1` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Length of the inrun from the highest start',
  `e2` decimal(4,2) unsigned DEFAULT NULL COMMENT 'Length of the inrun from the lowest start to take-off.',
  `r2l` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Radius of the transition curve from L to U at L',
  `zu` decimal(5,2) unsigned DEFAULT NULL COMMENT 'Difference in Height between the takeoff and the lowest point U',
  PRIMARY KEY (`idhill_version`),
  KEY `fk_hill_version_hill1_idx` (`hill_idhill`),
  CONSTRAINT `fk_hill_version_hill1` FOREIGN KEY (`hill_idhill`) REFERENCES `hill` (`idhill`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hill_version`
--

LOCK TABLES `hill_version` WRITE;
/*!40000 ALTER TABLE `hill_version` DISABLE KEYS */;
INSERT INTO `hill_version` VALUES (1,1,2020,2025,200.0,240.0,133.80,31.00,35.10,110.00,8.00,11.25,2.93,30.00,102.00,170.45,183.00,17.00,40.00,35.60,33.20,29.60,240.00,744.00,50.00,130.00,'http://medias1.fis-ski.com/pdf/homologations/JP/SLO/FLY3_SLO_Planica_HS240.pdf',3.10,14.30,36.09,39.97,115.66,30.01,'2020-03-08','2025-04-30',NULL,NULL,NULL,NULL),(2,1,1994,2013,185.0,215.0,124.00,25.00,38.50,100.32,8.50,11.25,2.00,28.60,94.98,157.80,168.00,17.00,30.00,36.50,34.14,30.00,215.00,744.00,50.00,130.00,NULL,3.00,NULL,34.60,42.00,101.00,27.00,'1994-01-01',NULL,NULL,NULL,NULL,NULL),(3,1,1984,1993,185.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,33.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1984-01-01',NULL,NULL,NULL,NULL,NULL),(4,1,1972,1983,165.0,NULL,NULL,NULL,42.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1972-01-01',NULL,NULL,NULL,NULL,NULL),(5,1,1969,1971,153.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1969-01-01',NULL,NULL,NULL,NULL,NULL),(7,8,2017,2021,116.0,130.0,NULL,14.80,38.64,95.55,6.45,10.50,3.41,25.70,56.60,100.70,100.00,16.00,14.00,37.70,34.70,32.20,130.00,305.80,92.87,83.00,'http://medias4.fis-ski.com/pdf/homologations/JP/FIN/139_FIN_13_Lahti_HS130.pdf',2.68,0.00,24.45,24.70,63.86,56.39,'2017-02-13','2021-12-31',90.00,75.20,NULL,78.23),(8,9,2017,2021,90.0,100.0,NULL,19.08,37.50,86.00,6.10,10.80,2.80,24.50,42.92,78.60,78.10,10.91,10.00,35.50,33.00,30.71,100.00,250.00,84.88,83.00,'http://medias1.fis-ski.com/pdf/homologations/JP/FIN/180_FIN_19_Lahti_HS100.pdf',2.45,5.60,18.00,19.60,45.50,30.50,'2017-02-13','2021-12-31',83.05,63.97,NULL,62.53),(9,11,2020,2025,120.0,137.0,NULL,27.00,35.00,115.00,6.50,11.00,3.38,25.90,59.52,103.51,108.85,11.15,17.42,37.43,35.50,33.56,137.42,321.00,100.00,95.00,'http://medias2.fis-ski.com/pdf/homologations/JP/GER/149_GER_19_Oberstdorf_HS137.pdf',2.82,0.00,24.00,26.40,87.00,44.00,'2020-07-20','2025-04-30',106.00,0.00,NULL,86.06),(11,21,2019,2018,125.0,140.0,NULL,22.00,35.00,90.00,6.50,11.00,3.13,28.28,62.37,107.76,109.00,16.00,15.00,37.05,34.30,31.40,140.00,310.00,99.30,103.00,'http://medias2.fis-ski.com/pdf/homologations/JP/POL/105_POL_1_Zakopane_HS140.pdf',2.60,0.10,25.00,27.50,84.00,35.00,'2019-11-19','2018-11-18',98.70,76.70,168.00,89.11),(26,72,NULL,NULL,120.0,142.0,NULL,32.25,35.00,103.00,6.75,11.00,3.50,26.30,59.25,103.05,111.79,30.00,15.20,38.00,35.00,32.50,142.00,347.00,108.00,138.00,'https://medias4.fis-ski.com/pdf/homologations/JP/FIN/61_FIN_1_Ruka__Kuusamo_HS142.pdf',2.50,2.00,25.80,27.80,80.30,34.60,'2020-10-17','2021-04-30',97.85,NULL,NULL,91.08),(27,73,NULL,NULL,120.0,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,74,NULL,NULL,125.0,142.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,75,NULL,NULL,125.0,142.0,NULL,23.71,27.00,NULL,6.50,11.00,4.50,26.20,62.36,107.61,110.70,14.83,17.00,37.50,35.80,31.60,142.00,335.00,115.00,98.00,'https://medias3.fis-ski.com/pdf/homologations/JP/AUT/5_AUT_5_Bischofshofen_HS142.pdf',2.45,10.35,24.20,26.40,83.60,52.13,'2018-10-21','2023-10-20',118.50,NULL,NULL,NULL),(41,12,NULL,NULL,120.0,140.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hill_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jury`
--

DROP TABLE IF EXISTS `jury`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jury` (
  `idjury` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `jury_type_idjury_type` tinyint unsigned NOT NULL,
  `person_idperson` mediumint unsigned NOT NULL,
  PRIMARY KEY (`idjury`),
  KEY `fk_jury_jury_type1_idx` (`jury_type_idjury_type`),
  KEY `fk_jury_person1_idx` (`person_idperson`),
  CONSTRAINT `fk_jury_jury_type1` FOREIGN KEY (`jury_type_idjury_type`) REFERENCES `jury_type` (`idjury_type`) ON DELETE CASCADE,
  CONSTRAINT `fk_jury_person1` FOREIGN KEY (`person_idperson`) REFERENCES `person` (`idperson`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jury`
--

LOCK TABLES `jury` WRITE;
/*!40000 ALTER TABLE `jury` DISABLE KEYS */;
INSERT INTO `jury` VALUES (8,1,65),(9,5,66),(16,5,8),(18,6,82),(21,7,66);
/*!40000 ALTER TABLE `jury` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jury_competition`
--

DROP TABLE IF EXISTS `jury_competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jury_competition` (
  `idjury_competition` int NOT NULL AUTO_INCREMENT,
  `competition_idcompetition` mediumint unsigned NOT NULL,
  `jury_idjury` mediumint unsigned NOT NULL,
  PRIMARY KEY (`idjury_competition`),
  KEY `fk_idx` (`competition_idcompetition`),
  KEY `fk_jury_competition_jury_idx` (`jury_idjury`),
  CONSTRAINT `fk_jury_competition_competition` FOREIGN KEY (`competition_idcompetition`) REFERENCES `competition` (`idcompetition`) ON DELETE CASCADE,
  CONSTRAINT `fk_jury_competition_jury` FOREIGN KEY (`jury_idjury`) REFERENCES `jury` (`idjury`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jury_competition`
--

LOCK TABLES `jury_competition` WRITE;
/*!40000 ALTER TABLE `jury_competition` DISABLE KEYS */;
INSERT INTO `jury_competition` VALUES (7,73,8),(8,166,8),(9,68,21),(11,146,8),(12,166,16),(13,69,8),(14,69,16);
/*!40000 ALTER TABLE `jury_competition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jury_type`
--

DROP TABLE IF EXISTS `jury_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jury_type` (
  `idjury_type` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `jury_type` varchar(45) NOT NULL,
  PRIMARY KEY (`idjury_type`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jury_type`
--

LOCK TABLES `jury_type` WRITE;
/*!40000 ALTER TABLE `jury_type` DISABLE KEYS */;
INSERT INTO `jury_type` VALUES (1,'Race Director'),(2,'Technical Delegate'),(3,'Chief Of Competition'),(4,'Assistant TD'),(5,'Assistant RD'),(6,'Equipment Control'),(7,'Judge');
/*!40000 ALTER TABLE `jury_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overall_standing`
--

DROP TABLE IF EXISTS `overall_standing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overall_standing` (
  `idoverall_standing` int NOT NULL AUTO_INCREMENT,
  `series_idseries` tinyint unsigned NOT NULL,
  `season_idseason` tinyint unsigned NOT NULL,
  `ski_jumper_idski_jumper` mediumint unsigned NOT NULL,
  `points` decimal(6,2) NOT NULL DEFAULT '0.00',
  `ranking` mediumint unsigned DEFAULT NULL,
  PRIMARY KEY (`idoverall_standing`),
  KEY `fk_overall_standings_series_idx` (`series_idseries`),
  KEY `fk_overall_standings_season_idx` (`season_idseason`),
  KEY `fk_overall_standings_ski_jumper_idx` (`ski_jumper_idski_jumper`),
  CONSTRAINT `fk_overall_standings_season` FOREIGN KEY (`season_idseason`) REFERENCES `season` (`idseason`),
  CONSTRAINT `fk_overall_standings_series` FOREIGN KEY (`series_idseries`) REFERENCES `series` (`idseries`),
  CONSTRAINT `fk_overall_standings_ski_jumper` FOREIGN KEY (`ski_jumper_idski_jumper`) REFERENCES `ski_jumper` (`idski_jumper`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overall_standing`
--

LOCK TABLES `overall_standing` WRITE;
/*!40000 ALTER TABLE `overall_standing` DISABLE KEYS */;
INSERT INTO `overall_standing` VALUES (73,9,102,50,693.00,1),(74,9,102,51,604.00,2),(75,9,102,54,313.00,8),(76,9,102,44,391.00,7),(77,9,102,52,241.00,9),(78,9,102,53,217.00,11),(79,9,102,49,506.00,3),(80,9,102,2,461.00,5),(81,9,102,58,441.00,6),(82,9,102,55,474.00,4),(83,9,102,57,229.00,10),(84,9,102,56,167.00,12),(85,9,102,1,0.00,0),(86,9,102,6,0.00,0),(87,9,101,57,320.00,2),(88,9,101,54,41.00,10),(89,9,101,49,240.00,3),(90,9,101,51,341.00,1),(91,9,101,56,55.00,9),(92,9,101,44,117.00,7),(93,9,101,2,239.00,4),(94,9,101,50,74.00,8),(95,9,101,55,126.00,5),(96,9,101,52,120.00,6),(97,9,100,49,100.00,1),(98,9,100,50,80.00,2),(99,9,100,57,60.00,3),(100,9,100,44,40.00,4),(101,9,100,55,36.00,5),(102,9,100,2,32.00,6),(103,9,100,54,26.00,7),(104,9,100,51,22.00,8),(105,9,100,52,4.00,9),(106,12,100,49,282.30,1),(107,12,100,50,281.90,2),(108,12,100,57,280.50,3),(109,12,100,44,268.30,4),(110,12,100,55,268.00,5),(111,12,100,2,267.60,6),(112,12,100,54,265.20,7),(113,12,100,51,262.90,8),(114,12,100,52,214.60,9),(115,12,100,53,109.20,10),(116,9,95,2,100.00,1),(117,9,95,57,50.00,2),(118,9,95,52,36.00,3),(119,12,102,51,785.20,2),(120,12,102,2,809.90,1),(121,12,102,50,776.50,3),(122,12,102,57,743.20,7),(123,12,102,56,594.40,8),(124,12,102,54,745.80,6),(125,12,102,49,766.70,4),(126,12,102,44,763.30,5),(127,12,102,53,214.50,12),(128,12,102,55,589.00,9),(129,12,102,52,458.80,11),(130,12,102,58,509.20,10),(146,9,97,57,100.00,1),(147,9,97,52,80.00,2),(148,9,97,49,36.00,3),(149,9,97,2,32.00,4),(150,9,97,56,29.00,5),(151,9,93,5,100.00,1),(152,9,93,9,22.00,2),(153,9,93,2,8.00,3),(154,9,93,50,1.00,4),(155,12,93,5,283.30,1),(156,12,93,9,234.80,2),(157,12,93,2,221.10,3),(158,12,93,50,187.10,4),(159,12,93,44,103.70,5);
/*!40000 ALTER TABLE `overall_standing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `idperson` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender_idgender` tinyint unsigned NOT NULL,
  `country_idcountry` smallint unsigned NOT NULL,
  `city_idcity` mediumint unsigned DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idperson`),
  KEY `fk_person_country1_idx` (`country_idcountry`),
  KEY `fk_person_city1_idx` (`city_idcity`),
  KEY `fk_person_gender1_idx` (`gender_idgender`),
  CONSTRAINT `fk_person_city1` FOREIGN KEY (`city_idcity`) REFERENCES `city` (`idcity`),
  CONSTRAINT `fk_person_country1` FOREIGN KEY (`country_idcountry`) REFERENCES `country` (`idcountry`),
  CONSTRAINT `fk_person_gender1` FOREIGN KEY (`gender_idgender`) REFERENCES `gender` (`idgender`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Adam','Małysz',2,677,19,'1977-12-03',NULL),(4,'Sven','Hannawald',2,583,275,'1974-11-08',NULL),(5,'Martin','Schmitt',2,583,166,'1978-01-28',NULL),(6,'Gregor','Schlierenzauer',2,515,278,'1990-01-05','schleire.jpg-2e5c7637-a655-407e-b504-5c84d77d6844'),(7,'Janne','Ahonen',2,575,100,'1977-05-10',NULL),(8,'Jakub','Janda',2,558,279,'1978-04-26',NULL),(11,'Simon','Ammann',2,718,281,'1981-06-23','ammann.jpg-d11511bb-a986-4308-ac30-b4af474bea44'),(12,'Andreas','Küttel',2,718,281,NULL,'malinka.jpg-10d30f57-4b42-4326-ac21-86a154c4d4a7'),(13,'Andreas','Goldberger',2,515,285,'1972-11-28',NULL),(15,'Roman','Koudelka',2,558,75,'1989-07-08',NULL),(65,'Walter','Hofer',2,515,303,'1955-02-24',NULL),(66,'Borek','Sedlak',2,558,304,'1981-06-14',NULL),(67,'Janne','Ahonen',2,575,100,'1977-05-10',NULL),(68,'Piotr','Żyła',2,677,19,'1987-01-15','Perceptron.png'),(69,'Jan','Kowalski',2,515,273,'2021-03-28',NULL),(71,'Jens','Weissflog',2,583,275,'1964-07-20',NULL),(74,'Jan ','Nowak',2,677,3,'2021-03-31',NULL),(75,'Janusz','Nowak',2,677,3,'2021-03-31',NULL),(79,'Janusz','Kowalski',2,677,3,'1998-04-01','P.png'),(80,'Carina','Vogt',1,583,305,'1990-02-05','P.png'),(81,'Apoloniusz','Tajner',2,677,11,'1954-04-17',NULL),(82,'Łukasz','Kruczek',2,677,307,'1975-11-01',NULL),(83,'Ryoyu','Kobayashi',2,612,308,'1996-11-08','blank-profile-picture-973460_1280.png'),(88,'Markus','Eisenbichler',2,583,153,'1991-04-02',NULL),(89,'Karl','Geiger',2,583,147,'1993-02-11','blank-profile-picture-973460_1280.png'),(90,'Michael','Hayboeck',2,515,309,'1991-03-05','blank-profile-picture-973460_1280.png'),(91,'Bor','Pavlovcic',2,704,310,'1998-06-27','blank-profile-picture-973460_1280.png'),(92,'Daniel','Huber',2,515,311,'1993-01-02','blank-profile-picture-973460_1280.png'),(93,'Robert','Johannsson',2,666,312,'1990-03-23','blank-profile-picture-973460_1280.png'),(94,'Domen','Prevc',2,704,313,'1990-06-04','blank-profile-picture-973460_1280.png'),(95,'Stefan','Kraft',2,515,51,'1993-05-12','kraft.jpg-d62508b6-9c05-4d68-a42e-009e0eac57c0'),(96,'Halvor Egner','Granerud',2,666,290,'1996-05-28','granerud.jpg-c92e4af5-aede-4933-a167-7148591022f5'),(97,'Jan','Kowalski',2,515,273,'2021-03-28',NULL),(124,'Kamil','Stoch',2,677,235,'1987-05-11','Kamil_Stoch_Atlas.jpg-13267dda-0275-487c-b248-bbdcbc12c82a'),(128,'sadfs','dsfs',2,515,218,'2021-05-03','CamScanner 05-17-2021 10.37_1.jpg-8ddf191a-2cdc-436f-9711-f1d58ff745f9'),(129,'Do','Usuniecia',2,515,26,'2021-06-17','Bez tytułu1.png-99c4ccf1-3cfb-4d4a-b899-bd53f81066f6'),(130,'Jan ','Kowalski',2,515,30,'2021-06-02',NULL),(131,'Jan','KOwalski',2,515,6,'2021-06-14','geiger.jpeg-9736e30b-8ede-41a2-aa45-dbcb17290a6a'),(132,'Jan','Kowalski',2,677,16,'2021-06-15','kraft.jpg-ab7531dc-4fa5-46cd-92d2-16835c72447b');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point_system`
--

DROP TABLE IF EXISTS `point_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `point_system` (
  `idpoint_system` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `pos_1` smallint unsigned DEFAULT '0',
  `pos_2` smallint unsigned DEFAULT '0',
  `pos_3` smallint unsigned DEFAULT '0',
  `pos_4` smallint unsigned DEFAULT '0',
  `pos_5` smallint unsigned DEFAULT '0',
  `pos_6` smallint unsigned DEFAULT '0',
  `pos_7` smallint unsigned DEFAULT '0',
  `pos_8` smallint unsigned DEFAULT '0',
  `pos_9` smallint unsigned DEFAULT '0',
  `pos_10` smallint unsigned DEFAULT '0',
  `pos_11` smallint unsigned DEFAULT '0',
  `pos_12` smallint unsigned DEFAULT '0',
  `pos_13` smallint unsigned DEFAULT '0',
  `pos_14` smallint unsigned DEFAULT '0',
  `pos_15` smallint unsigned DEFAULT '0',
  `pos_16` smallint unsigned DEFAULT '0',
  `pos_17` smallint unsigned DEFAULT '0',
  `pos_18` smallint unsigned DEFAULT '0',
  `pos_19` smallint unsigned DEFAULT '0',
  `pos_20` smallint unsigned DEFAULT '0',
  `pos_21` smallint unsigned DEFAULT '0',
  `pos_22` smallint unsigned DEFAULT '0',
  `pos_23` smallint unsigned DEFAULT '0',
  `pos_24` smallint unsigned DEFAULT '0',
  `pos_25` smallint unsigned DEFAULT '0',
  `pos_26` smallint unsigned DEFAULT '0',
  `pos_27` smallint unsigned DEFAULT '0',
  `pos_28` smallint unsigned DEFAULT '0',
  `pos_29` smallint unsigned DEFAULT '0',
  `pos_30` smallint unsigned DEFAULT '0',
  PRIMARY KEY (`idpoint_system`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point_system`
--

LOCK TABLES `point_system` WRITE;
/*!40000 ALTER TABLE `point_system` DISABLE KEYS */;
INSERT INTO `point_system` VALUES (1,100,80,60,50,45,40,36,32,29,26,24,22,20,18,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1),(2,25,20,15,12,11,10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(3,400,350,300,250,200,150,100,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(4,200,160,120,100,90,80,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(5,60,50,40,30,20,15,14,13,12,11,10,9,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(6,200,175,150,125,100,75,50,25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `point_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `points_scale`
--

DROP TABLE IF EXISTS `points_scale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `points_scale` (
  `idpoints_scale` tinyint NOT NULL AUTO_INCREMENT,
  `max_value` mediumint unsigned NOT NULL,
  PRIMARY KEY (`idpoints_scale`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `points_scale`
--

LOCK TABLES `points_scale` WRITE;
/*!40000 ALTER TABLE `points_scale` DISABLE KEYS */;
INSERT INTO `points_scale` VALUES (1,400),(2,200),(3,100),(4,60),(5,25),(6,1);
/*!40000 ALTER TABLE `points_scale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `points_scale_value`
--

DROP TABLE IF EXISTS `points_scale_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `points_scale_value` (
  `idpoints_scale_value` int NOT NULL AUTO_INCREMENT,
  `rank` tinyint unsigned NOT NULL,
  `points` mediumint unsigned NOT NULL,
  `points_scale_idpoints_scale` tinyint NOT NULL,
  PRIMARY KEY (`idpoints_scale_value`),
  KEY `fk_point_system_value_point_scale_idx` (`points_scale_idpoints_scale`),
  CONSTRAINT `fk_points_scale_value_points_scale` FOREIGN KEY (`points_scale_idpoints_scale`) REFERENCES `points_scale` (`idpoints_scale`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `points_scale_value`
--

LOCK TABLES `points_scale_value` WRITE;
/*!40000 ALTER TABLE `points_scale_value` DISABLE KEYS */;
INSERT INTO `points_scale_value` VALUES (1,1,100,3),(2,2,80,3),(3,3,60,3),(4,4,50,3),(5,5,45,3),(6,6,40,3),(7,7,36,3),(8,8,32,3),(9,9,29,3),(10,10,26,3),(11,11,24,3),(12,12,22,3),(13,13,20,3),(14,14,18,3),(15,15,16,3),(16,16,15,3),(17,17,14,3),(18,18,13,3),(19,19,12,3),(20,20,11,3),(21,21,10,3),(22,22,9,3),(23,23,8,3),(24,24,7,3),(25,25,6,3),(26,26,5,3),(27,27,4,3),(28,28,3,3),(29,29,2,3),(30,30,1,3),(31,1,400,1),(32,2,350,1),(33,3,300,1),(34,4,250,1),(35,5,200,1),(36,6,150,1),(37,7,100,1),(38,8,50,1),(39,1,200,2),(40,2,175,2),(41,3,150,2),(42,1,60,4),(43,2,50,4),(44,3,45,4),(45,1,25,5),(46,2,18,5),(47,3,15,5),(48,4,12,5),(49,1,1,6),(50,1,1,6),(51,1,1,6);
/*!40000 ALTER TABLE `points_scale_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualification`
--

DROP TABLE IF EXISTS `qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qualification` (
  `idqualification` int NOT NULL AUTO_INCREMENT,
  `competition_idcompetition` mediumint unsigned NOT NULL,
  `date1` date NOT NULL,
  `judge_idjudge_a` mediumint unsigned DEFAULT NULL,
  `judge_idjudge_b` mediumint unsigned DEFAULT NULL,
  `judge_idjudge_c` mediumint unsigned DEFAULT NULL,
  `judge_idjudge_d` mediumint unsigned DEFAULT NULL,
  `judge_idjudge_e` mediumint unsigned DEFAULT NULL,
  `judge_idjudge_sc` mediumint unsigned DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `base_gate` int DEFAULT NULL,
  `air_temp_start` decimal(3,1) DEFAULT NULL,
  `air_temp_finish` decimal(3,1) DEFAULT NULL,
  `snow_temp_start` decimal(3,1) DEFAULT NULL,
  `snow_temp_finish` decimal(3,1) DEFAULT NULL,
  `humidity_start` decimal(3,1) DEFAULT NULL,
  `humidity_finish` decimal(3,1) DEFAULT NULL,
  `min_wind` decimal(4,2) DEFAULT NULL,
  `max_wind` decimal(4,2) DEFAULT NULL,
  `avg_wind` decimal(4,2) DEFAULT NULL,
  `weather_idweather` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`idqualification`),
  KEY `fk_qualification_competition1_idx` (`competition_idcompetition`) /*!80000 INVISIBLE */,
  KEY `fk_qualification_jury1_idx` (`judge_idjudge_a`),
  KEY `fk_qualification_jury2_idx` (`judge_idjudge_b`),
  KEY `fk_qualification_jury3_idx` (`judge_idjudge_c`),
  KEY `fk_qualification_jury4_idx` (`judge_idjudge_d`),
  KEY `fk_qualification_jury5_idx` (`judge_idjudge_e`),
  KEY `fk_qualification_jury6_idx` (`judge_idjudge_sc`),
  KEY `fk_qualification_weather1_idx` (`weather_idweather`),
  CONSTRAINT `fk_qualification_competition1` FOREIGN KEY (`competition_idcompetition`) REFERENCES `competition` (`idcompetition`) ON DELETE CASCADE,
  CONSTRAINT `fk_qualification_jury1` FOREIGN KEY (`judge_idjudge_a`) REFERENCES `jury` (`idjury`) ON DELETE SET NULL,
  CONSTRAINT `fk_qualification_jury2` FOREIGN KEY (`judge_idjudge_b`) REFERENCES `jury` (`idjury`) ON DELETE SET NULL,
  CONSTRAINT `fk_qualification_jury3` FOREIGN KEY (`judge_idjudge_c`) REFERENCES `jury` (`idjury`) ON DELETE SET NULL,
  CONSTRAINT `fk_qualification_jury4` FOREIGN KEY (`judge_idjudge_d`) REFERENCES `jury` (`idjury`) ON DELETE SET NULL,
  CONSTRAINT `fk_qualification_jury5` FOREIGN KEY (`judge_idjudge_e`) REFERENCES `jury` (`idjury`) ON DELETE SET NULL,
  CONSTRAINT `fk_qualification_jury6` FOREIGN KEY (`judge_idjudge_sc`) REFERENCES `jury` (`idjury`) ON DELETE SET NULL,
  CONSTRAINT `fk_qualification_weather1` FOREIGN KEY (`weather_idweather`) REFERENCES `weather` (`idweather`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualification`
--

LOCK TABLES `qualification` WRITE;
/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region` (
  `idregion` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `country_idcountry` smallint unsigned NOT NULL,
  PRIMARY KEY (`idregion`),
  KEY `fk_region_country_idx` (`country_idcountry`),
  CONSTRAINT `fk_region_country` FOREIGN KEY (`country_idcountry`) REFERENCES `country` (`idcountry`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=460 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Carinthia',515),(2,'Central Sava',704),(3,'Central Slovenia',704),(4,'Coastal–Karst',704),(5,'Drava',704),(6,'Gorizia',704),(7,'Littoral–Inner Carniola',704),(8,'Lower Sava',704),(9,'Mura',704),(10,'Savinja',704),(11,'Southeast Slovenia',704),(12,'Upper Carniola',704),(17,'Lower Austria',515),(18,'Upper Austria',515),(19,'Salzburg',515),(20,'Styria',515),(21,'Tyrol',515),(22,'Vorarlberg',515),(23,'Vienna',515),(24,'Alberta',541),(25,'British Columbia',541),(26,'Manitoba',541),(27,'Ontario',541),(28,'Quebec',541),(29,'Saskatchewan',541),(30,'Yukon',541),(31,'Hebei',547),(32,'Heilongjiang',547),(33,'Anhui',547),(34,'Beijing',547),(35,'Chongqing',547),(36,'Fujian',547),(37,'Guangdong',547),(38,'Gansu',547),(39,'Guangxi Zhuang',547),(40,'Guizhou',547),(41,'Henan',547),(42,'Hubei',547),(43,'Hainan',547),(44,'Hunan',547),(45,'Jilin',547),(46,'Jiangsu',547),(47,'Jiangxi',547),(48,'Liaoning',547),(49,'Macau',547),(50,'Inner Mongolia',547),(51,'Ningxia Hui',547),(52,'Qinghai',547),(53,'Sichuan',547),(54,'Shandong',547),(55,'Shanghai',547),(56,'Shaanxi',547),(57,'Shanxi',547),(58,'Tianjin',547),(59,'Taiwan',547),(60,'Xinjiang Uyghur',547),(61,'Tibet',547),(62,'Yunnan',547),(63,'Zhejiang',547),(64,'Prague',558),(65,'South Moravian',558),(66,'South Bohemian',558),(67,'Pardubice',558),(68,'Hradec Králové',558),(69,'Vysočina',558),(70,'Karlovy Vary',558),(71,'Liberec',558),(72,'Olomouc',558),(73,'Plzeň',558),(74,'Central Bohemian',558),(75,'Moravian-Silesian',558),(76,'Ústí nad Labem',558),(77,'Zlín',558),(78,'Harju',570),(79,'Hiiu',570),(80,'Ida-Viru',570),(81,'Jõgeva',570),(82,'Järva',570),(83,'Lääne',570),(84,'Lääne-Viru',570),(85,'Põlva',570),(86,'Pärnu',570),(87,'Rapla',570),(88,'Saare',570),(89,'Tartu',570),(90,'Valga',570),(91,'Viljandi',570),(92,'Võru',570),(95,'Lapland',575),(97,'North Ostrobothnia',575),(107,'Brandenburg',583),(108,'Berlin',583),(109,'Baden-Württemberg',583),(110,'Bavaria',583),(111,'Hesse',583),(112,'Mecklenburg-Vorpommern',583),(113,'Lower Saxony',583),(114,'North Rhine-Westphalia',583),(115,'Rhineland-Palatinate',583),(116,'Saxony',583),(117,'Saxony-Anhalt',583),(118,'Thuringia',583),(119,'Northern Hungary',600),(120,'Northern Great Plain',600),(121,'Southern Great Plain',600),(122,'Central Hungary',600),(123,'Central Transdanubia',600),(124,'Central Transdanubia',600),(125,'Southern Transdanubia',600),(126,'Sofia',536),(127,'Abruzzo',609),(128,'Aosta Valley',609),(129,'Apulia',609),(130,'Basilicata',609),(131,'Calabria',609),(132,'Campania',609),(133,'Emilia-Romagna',609),(134,'Friuli Venezia Giulia',609),(135,'Lazio',609),(136,'Liguria',609),(137,'Lombardy',609),(138,'Marche',609),(139,'Molise',609),(140,'Piedmont',609),(141,'Sardinia',609),(142,'Sicilia',609),(143,'Trentino-South Tyrol',609),(144,'Tuscany',609),(145,'Umbria',609),(146,'Veneto',609),(147,'Hokkaidō',612),(148,'Aomori',612),(149,'Iwate',612),(150,'Miyagi',612),(151,'Akita',612),(152,'Yamagata',612),(153,'Fukushima',612),(154,'Gunma',612),(155,'Tokyo',612),(156,'Niigata',612),(157,'Toyama',612),(158,'Ishikawa',612),(159,'Nagano',612),(160,'Gifu',612),(161,'Hyōgo',612),(162,'Tottori',612),(163,'Akmola',615),(164,'Aktobe',615),(165,'Almaty City',615),(166,'Almaty',615),(167,'Atyrau',615),(168,'Baikonur',615),(169,'East Kazakhstan',615),(170,'Jambyl',615),(171,'Karaganda',615),(172,'Kostanay',615),(173,'Kyzylorda',615),(174,'Mangystau',615),(175,'North Kazakhstan',615),(176,'Nur-Sultan',615),(177,'Pavlodar',615),(178,'Shymkent',615),(179,'Turkistan',615),(180,'West Kazakhstan',615),(181,'North Chungcheong',709),(182,'South Chungcheong',709),(183,'Gangwon',709),(184,'Gyeonggi',709),(185,'North Gyeongsang',709),(186,'South Gyeongsang',709),(187,'North Jeolla',709),(188,'South Jeolla',709),(189,'Jeju',709),(190,'Drenthe',656),(191,'Flevoland',656),(192,'Friesland',656),(193,'Friesland',656),(194,'Gelderland',656),(195,'Groningen',656),(196,'Limburg',656),(197,'North Brabant',656),(198,'North Holland',656),(199,'Overijssel',656),(200,'South Holland',656),(201,'Utrecht',656),(202,'Zeeland',656),(203,'Oslo',666),(204,'Rogaland',666),(205,'Møre og Romsdal',666),(206,'Nord-Trøndelag',666),(207,'Nordland',666),(208,'Svalbard',666),(209,'Viken',666),(210,'Innlandet',666),(211,'Vestfold og Telemark',666),(212,'Agder',666),(213,'Vestland',666),(214,'Trøndelag',666),(215,'Troms og Finnmark',666),(216,'Podlaskie',677),(217,'Lower Silesia',677),(218,'Łódź',677),(219,'Lubusz',677),(220,'Pomerania',677),(221,'Lesser Poland',677),(222,'Lublin',677),(223,'Warmia-Masuria',677),(224,'Opole',677),(225,'Greater Poland',677),(226,'Subcarpathia',677),(227,'Silesia',677),(228,'Świętokrzyskie',677),(229,'Masovia',677),(230,'Brașov',683),(231,'Adygea',684),(232,'Bashkortostan',684),(233,'Buryatia',684),(234,'Altai',684),(235,'Dagestan',684),(236,'Ingushetia',684),(237,'Kabardino-Balkar',684),(238,'Kalmykia',684),(239,'Karachay-Cherkess',684),(240,'Karelia',684),(241,'Komi',684),(242,'Mari El',684),(243,'Mordovia',684),(244,'Sakha (Yakutia)',684),(245,'North Ossetia-Alania',684),(246,'Tatarstan',684),(247,'Tuva',684),(248,'Udmurt',684),(249,'Khakassia',684),(250,'Chechen',684),(251,'Chuvash',684),(252,'Altai Krai',684),(253,'Krasnodar Krai',684),(254,'Krasnoyarsk Krai',684),(255,'Primorsky Krai',684),(256,'Stavropol Krai',684),(257,'Khabarovsk Krai',684),(258,'Amur Oblast',684),(259,'Arkhangelsk Oblast',684),(260,'Astrakhan Oblast',684),(261,'Belgorod Oblast',684),(262,'Bryansk Oblast',684),(263,'Vladimir Oblast',684),(264,'Vladimir Oblast',684),(265,'Vologda Oblast',684),(266,'Voronezh Oblast',684),(267,'Voronezh Oblast',684),(268,'Irkutsk Oblast',684),(269,'Kaliningrad Oblast',684),(270,'Kaluga Oblast',684),(271,'Kamchatka Krai',684),(272,'Kemerovo Oblast',684),(273,'Kirov Oblast',684),(274,'Kostroma Oblast',684),(275,'Kurgan Oblast',684),(276,'Kursk Oblast',684),(277,'Leningrad Oblast',684),(278,'Lipetsk Oblast',684),(279,'Magadan Oblast',684),(280,'Moscow Oblast',684),(281,'Murmansk Oblast',684),(282,'Nizhny Novgorod Oblast',684),(283,'Novgorod Oblast',684),(284,'Novgorod Oblast',684),(285,'Omsk Oblast',684),(286,'Orenburg Oblast',684),(287,'Oryol Oblast',684),(288,'Penza Oblast',684),(289,'Perm Krai',684),(290,'Pskov Oblast',684),(291,'Rostov Oblast',684),(292,'Ryazan Oblast',684),(293,'Samara Oblast',684),(294,'Saratov Oblast',684),(295,'Sakhalin Oblast',684),(296,'Sverdlovsk Oblast',684),(297,'Smolensk Oblast',684),(298,'Tambov Oblast',684),(299,'Tver Oblast',684),(300,'Tomsk Oblast',684),(301,'Tula Oblast',684),(302,'Tyumen Oblast',684),(303,'Ulyanovsk Oblast',684),(304,'Chelyabinsk Oblast',684),(305,'Zabaykalsky Krai',684),(306,'Yaroslavl Oblast',684),(307,'Moscow',684),(308,'Saint Petersburg',684),(309,'Jewish Autonomous Oblast',684),(310,'Nenets Autonomous Okrug',684),(311,'Khanty–Mansi Autonomous Okrug – Yugra',684),(312,'Chukotka Autonomous Okrug',684),(313,'Yamalo-Nenets Autonomous Okrug',684),(314,'Zurich',718),(323,'Bern',718),(324,'Luzern',718),(325,'Uri',718),(326,'Schwyz',718),(327,'Obwalden',718),(328,'Nidwalden',718),(329,'Glarus',718),(330,'Zug',718),(331,'Fribourg',718),(332,'Solothurn',718),(333,'Basel-Stadt',718),(334,'Basel-Landschaft',718),(335,'Schaffhausen',718),(336,'Appenzell Ausserrhoden',718),(337,'Appenzell Innerrhoden',718),(338,'St. Gallen',718),(339,'Graubünden',718),(340,'Aargau',718),(341,'Thurgau',718),(342,'Ticino',718),(343,'Vaud',718),(344,'Valais',718),(345,'Neuchâtel',718),(346,'Genève',718),(347,'Jura',718),(348,'Bratislava',703),(349,'Trnava',703),(350,'Trenčín',703),(351,'Nitra',703),(352,'Žilina',703),(353,'Banská Bystrica',703),(354,'Prešov',703),(355,'Košice',703),(356,'Ångermanland',717),(357,'Blekinge',717),(358,'Bohuslän',717),(359,'Dalarna',717),(360,'Dalsland',717),(361,'Gotland',717),(362,'Gästrikland',717),(363,'Halland',717),(364,'Hälsingland',717),(365,'Härjedalen',717),(366,'Jämtland',717),(367,'Lappland',717),(368,'Medelpad',717),(369,'Norrbotten',717),(370,'Närke',717),(371,'Öland',717),(372,'Östergötland',717),(373,'Skåne',717),(374,'Småland',717),(375,'Södermanland',717),(376,'Uppland',717),(377,'Värmland',717),(378,'Västmanland',717),(379,'Västerbotten',717),(380,'Västergötland',717),(381,'Cherkasy Oblast',736),(382,'Chernihiv Oblast',736),(383,'Chernivtsi Oblast',736),(384,'Dnipropetrovsk Oblast',736),(385,'Donetsk Oblast',736),(386,'Ivano-Frankivsk Oblast',736),(387,'Kharkiv Oblast',736),(388,'Kherson Oblast',736),(389,'Khmelnytskyi Oblast',736),(390,'Kyiv Oblast',736),(391,'Kirovohrad Oblast',736),(392,'Luhansk Oblast',736),(393,'Lviv Oblast',736),(394,'Mykolaiv Oblast',736),(395,'Odessa Oblast',736),(396,'Poltava Oblast',736),(397,'Rivne Oblast',736),(398,'Sumy Oblast',736),(399,'Ternopil Oblast',736),(400,'Vinnytsia Oblast',736),(401,'Volyn Oblast',736),(402,'Zakarpattia Oblast',736),(403,'Zaporizhzhia Oblast',736),(404,'Zhytomyr Oblast',736),(405,'Alaska',739),(406,'California',739),(407,'Colorado',739),(408,'Connecticut',739),(409,'Idaho',739),(410,'Illinois',739),(411,'Indiana',739),(412,'Massachusetts',739),(413,'Maine',739),(414,'Michigan',739),(415,'Minnesota',739),(416,'Montana',739),(417,'North Dakota',739),(418,'New Hampshire',739),(419,'Nevada',739),(420,'New York',739),(421,'Oregon',739),(422,'South Dakota',739),(423,'Utah',739),(424,'Vermont',739),(425,'Washington',739),(426,'Wisconsin',739),(427,'Erzurum Province',729),(428,'Kainuu',575),(429,'North Karelia',575),(430,'North Savo',575),(431,'Southern Savonia',575),(432,'South Karelia',575),(433,'Central Finland',575),(434,'South Ostrobothnia',575),(435,'Ostrobothnia',575),(436,'Central Ostrobothnia',575),(437,'Pirkanmaa',575),(438,'Satakunta',575),(439,'Päijänne Tavastia',575),(440,'Kanta-Häme',575),(441,'Kymenlaakso',575),(442,'Uusimaa',575),(443,'Southwest Finland',575),(444,'Åland',575),(445,'Auvergne-Rhône-Alpes',576),(446,'Bourgogne-Franche-Comté',576),(447,'Bretagne',576),(448,'Centre-Val de Loire',576),(449,'Corse',576),(450,'Grand Est',576),(451,'Hauts-de-France',576),(452,'Île-de-France',576),(453,'Normandie',576),(454,'Nouvelle-Aquitaine',576),(455,'Occitanie',576),(456,'Pays de la Loire',576),(457,'Provence-Alpes-Côte d\'Azur',576),(458,'West Pomeranian',677),(459,'Kuyavian-Pomeranian',677);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `idresult` int unsigned NOT NULL AUTO_INCREMENT,
  `competition_idcompetition` mediumint unsigned NOT NULL,
  `ski_jumper_idski_jumper` mediumint unsigned NOT NULL,
  `first_round_speed` decimal(4,1) DEFAULT NULL,
  `first_round_distance` decimal(4,1) unsigned DEFAULT '0.0',
  `first_round_distance_points` decimal(4,1) DEFAULT '0.0',
  `first_round_judge_a` decimal(3,1) unsigned DEFAULT '0.0',
  `first_round_judge_b` decimal(3,1) unsigned DEFAULT NULL,
  `first_round_judge_c` decimal(3,1) unsigned DEFAULT '0.0',
  `first_round_judge_d` decimal(3,1) unsigned DEFAULT '0.0',
  `first_round_judge_e` decimal(3,1) unsigned DEFAULT '0.0',
  `first_round_judge_points` decimal(3,1) unsigned DEFAULT '0.0',
  `first_round_gate` tinyint unsigned DEFAULT NULL,
  `first_round_gate_coach_request` tinyint DEFAULT '0',
  `first_round_gate_points` decimal(3,1) DEFAULT '0.0',
  `first_round_wind` decimal(4,2) DEFAULT NULL,
  `first_round_wind_points` decimal(3,1) DEFAULT '0.0',
  `first_round_total` decimal(4,1) unsigned DEFAULT '0.0',
  `first_round_rank` smallint unsigned DEFAULT NULL,
  `total_points` decimal(5,1) unsigned DEFAULT '0.0',
  `second_round_speed` decimal(4,1) unsigned DEFAULT NULL,
  `second_round_distance` decimal(4,1) unsigned DEFAULT '0.0',
  `second_round_distance_points` decimal(4,1) DEFAULT NULL,
  `second_round_judge_a` decimal(3,1) unsigned DEFAULT '0.0',
  `second_round_judge_b` decimal(3,1) unsigned DEFAULT '0.0',
  `second_round_judge_c` decimal(3,1) unsigned DEFAULT '0.0',
  `second_round_judge_d` decimal(3,1) unsigned DEFAULT '0.0',
  `second_round_judge_e` decimal(3,1) unsigned DEFAULT '0.0',
  `second_round_judge_points` decimal(3,1) unsigned DEFAULT '0.0',
  `second_round_gate` tinyint unsigned DEFAULT NULL,
  `second_round_gate_coach_request` tinyint DEFAULT NULL,
  `second_round_gate_points` decimal(3,1) DEFAULT '0.0',
  `second_round_wind` decimal(4,2) DEFAULT NULL,
  `second_round_wind_points` decimal(3,1) DEFAULT '0.0',
  `second_round_total` decimal(4,1) unsigned DEFAULT '0.0',
  `second_round_rank` smallint unsigned DEFAULT NULL,
  `third_round_speed` decimal(4,1) unsigned DEFAULT NULL,
  `third_round_distance` decimal(4,1) unsigned DEFAULT '0.0',
  `third_round_distance_points` decimal(4,1) DEFAULT NULL,
  `third_round_judge_a` decimal(3,1) unsigned DEFAULT '0.0',
  `third_round_judge_b` decimal(3,1) unsigned DEFAULT '0.0',
  `third_round_judge_c` decimal(3,1) unsigned DEFAULT '0.0',
  `third_round_judge_d` decimal(3,1) unsigned DEFAULT '0.0',
  `third_round_judge_e` decimal(3,1) unsigned DEFAULT '0.0',
  `third_round_judge_points` decimal(3,1) unsigned DEFAULT '0.0',
  `third_round_gate` tinyint unsigned DEFAULT NULL,
  `third_round_gate_coach_request` tinyint DEFAULT NULL,
  `third_round_gate_points` decimal(3,1) DEFAULT '0.0',
  `third_round_wind` decimal(4,2) DEFAULT NULL,
  `third_round_wind_points` decimal(3,1) DEFAULT '0.0',
  `third_round_total` decimal(4,1) unsigned DEFAULT '0.0',
  `third_round_rank` smallint unsigned DEFAULT NULL,
  `fourth_round_speed` decimal(4,1) unsigned DEFAULT NULL,
  `fourth_round_distance` decimal(4,1) unsigned DEFAULT '0.0',
  `fourth_round_distance_points` decimal(4,1) DEFAULT NULL,
  `fourth_round_judge_a` decimal(3,1) unsigned DEFAULT '0.0',
  `fourth_round_judge_b` decimal(3,1) unsigned DEFAULT '0.0',
  `fourth_round_judge_c` decimal(3,1) unsigned DEFAULT '0.0',
  `fourth_round_judge_d` decimal(3,1) unsigned DEFAULT '0.0',
  `fourth_round_judge_e` decimal(3,1) unsigned DEFAULT '0.0',
  `fourth_round_judge_points` decimal(3,1) unsigned DEFAULT '0.0',
  `fourth_round_gate` tinyint unsigned DEFAULT NULL,
  `fourth_round_gate_coach_request` tinyint DEFAULT NULL,
  `fourth_round_gate_points` decimal(3,1) DEFAULT '0.0',
  `fourth_round_wind` decimal(4,2) DEFAULT NULL,
  `fourth_round_wind_points` decimal(3,1) DEFAULT '0.0',
  `fourth_round_total` decimal(4,1) unsigned DEFAULT '0.0',
  `fourth_round_rank` smallint unsigned DEFAULT NULL,
  `total_rank` smallint unsigned DEFAULT NULL,
  `qualification_idqualification` int unsigned DEFAULT NULL,
  `disqualification_type_iddisqualification_type` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`idresult`),
  KEY `fk_result_competition1_idx` (`competition_idcompetition`),
  KEY `fk_result_ski_jumper1_idx` (`ski_jumper_idski_jumper`),
  KEY `fk_result_disqualification_type_idx` (`disqualification_type_iddisqualification_type`),
  CONSTRAINT `fk_result_competition1` FOREIGN KEY (`competition_idcompetition`) REFERENCES `competition` (`idcompetition`) ON DELETE CASCADE,
  CONSTRAINT `fk_result_disqualification_type` FOREIGN KEY (`disqualification_type_iddisqualification_type`) REFERENCES `disqualification_type` (`iddisqualification_type`),
  CONSTRAINT `fk_result_ski_jumper1` FOREIGN KEY (`ski_jumper_idski_jumper`) REFERENCES `ski_jumper` (`idski_jumper`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1141 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,68,1,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.8,0,270.9,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(2,68,2,NULL,120.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.2,0,263.7,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(3,68,6,NULL,121.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.0,0,240.4,NULL,99.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,100.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(13,72,1,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.8,0,270.9,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(14,72,2,NULL,120.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.2,0,263.7,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(15,72,6,NULL,244.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.0,0,240.4,NULL,99.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,100.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(127,82,49,32.0,235.5,80.0,NULL,NULL,NULL,NULL,NULL,NULL,3,0,4.0,NULL,0.0,224.2,0,452.5,NULL,244.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,228.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(128,82,50,NULL,232.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,210.8,0,445.1,NULL,238.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,234.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(129,82,51,NULL,224.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,203.2,0,431.3,NULL,238.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,228.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(130,82,52,NULL,230.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,210.8,0,430.2,NULL,227.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,219.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(131,82,53,NULL,231.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,211.3,0,428.2,NULL,228.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,216.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(132,82,54,NULL,228.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,203.4,0,420.4,NULL,227.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,217.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(133,82,55,NULL,217.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,195.2,0,419.9,NULL,234.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,224.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(134,82,56,NULL,231.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,211.9,0,418.9,NULL,222.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,207.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(135,82,44,NULL,214.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,194.1,0,413.2,NULL,230.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,219.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,10,NULL,NULL),(136,82,2,NULL,200.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,173.7,0,173.7,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,32,NULL,NULL),(204,85,49,NULL,136.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.8,0,268.9,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(205,85,53,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.1,0,266.4,NULL,130.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(206,85,44,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.2,0,257.5,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(207,85,55,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.1,0,256.8,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(208,85,50,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.4,0,249.8,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(209,85,56,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.4,0,246.7,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(210,85,2,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.9,0,244.7,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,20,NULL,NULL),(211,85,51,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.5,0,239.8,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,23,NULL,NULL),(212,85,52,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,116.4,0,236.6,NULL,131.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,120.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,25,NULL,NULL),(213,85,54,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,0.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,999,NULL,NULL),(224,84,57,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.8,0,276.5,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(225,84,55,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.1,0,272.1,NULL,135.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(226,84,51,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.7,0,267.4,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(227,84,44,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.4,0,264.4,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(228,84,54,NULL,133.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.7,0,255.3,NULL,123.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(229,84,50,NULL,122.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.5,0,231.8,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(230,84,2,NULL,120.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,112.9,0,230.0,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,19,NULL,NULL),(231,84,49,NULL,117.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,90.3,0,90.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,34,NULL,NULL),(232,84,53,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,0.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,999,NULL,NULL),(233,86,51,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.8,0,291.1,NULL,136.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,151.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(234,86,2,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.0,0,288.3,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,152.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(235,86,50,NULL,118.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.7,0,274.3,NULL,142.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,152.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(236,86,57,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.9,0,273.6,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(237,86,56,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.0,0,266.2,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(238,86,54,NULL,121.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.3,0,265.4,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,13,NULL,NULL),(239,86,49,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.4,0,265.2,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(240,86,44,NULL,119.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.0,0,256.7,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,21,NULL,NULL),(241,86,53,NULL,117.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.8,0,118.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,33,NULL,NULL),(242,86,55,NULL,115.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.3,0,113.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,39,NULL,NULL),(243,86,52,NULL,112.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,108.0,0,108.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,48,NULL,NULL),(251,88,58,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.0,0,282.0,NULL,142.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,152.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(252,88,50,NULL,141.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.2,0,272.1,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(253,88,55,NULL,138.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.6,0,249.9,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(254,88,2,NULL,130.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.5,0,246.5,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(255,88,51,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.1,0,242.5,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(256,88,49,NULL,121.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,104.0,0,214.5,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,110.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,15,NULL,NULL),(257,88,53,NULL,130.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.2,0,212.7,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,99.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(258,88,44,NULL,121.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,103.9,0,198.2,NULL,116.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,94.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,23,NULL,NULL),(281,91,58,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,150.5,0,298.1,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,147.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(282,91,55,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.8,0,293.8,NULL,142.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,157.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(283,91,57,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.6,0,290.2,NULL,131.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,145.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(284,91,49,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.9,0,284.8,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(285,91,54,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.0,0,284.5,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,10,NULL,NULL),(286,91,50,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.1,0,283.0,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(287,91,53,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.8,0,281.3,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,13,NULL,NULL),(288,91,56,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.6,0,273.0,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,16,NULL,NULL),(289,91,52,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.1,0,272.6,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(290,91,51,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.9,0,269.8,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,22,NULL,NULL),(291,91,2,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.2,0,268.6,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,23,NULL,NULL),(292,91,44,NULL,120.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.2,0,129.2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,33,NULL,NULL),(312,94,49,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,154.8,0,305.1,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,150.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(313,94,51,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,147.1,0,295.9,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,148.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(314,94,57,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,145.6,0,291.2,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,145.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(315,94,44,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.3,0,281.5,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(316,94,55,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.7,0,279.8,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(317,94,56,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.2,0,279.5,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(318,94,50,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.7,0,277.8,NULL,123.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,11,NULL,NULL),(319,94,52,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.8,0,272.8,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(320,94,2,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.5,0,267.0,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,19,NULL,NULL),(401,103,2,NULL,137.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.4,0,295.7,NULL,140.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,152.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(402,103,57,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.9,0,290.6,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,147.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(403,103,51,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.1,0,282.4,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,147.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(404,103,49,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.9,0,277.6,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(405,103,44,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.6,0,274.8,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(406,103,50,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.3,0,265.5,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(407,103,55,NULL,128.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.7,0,258.2,NULL,131.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,15,NULL,NULL),(408,103,52,NULL,122.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.1,0,256.3,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,18,NULL,NULL),(409,103,54,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.5,0,255.7,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,19,NULL,NULL),(410,103,56,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,120.6,0,246.6,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,22,NULL,NULL),(493,111,51,NULL,122.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.6,0,266.4,NULL,130.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(494,111,57,NULL,119.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.4,0,260.5,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(495,111,52,NULL,118.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.8,0,259.1,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(496,111,44,NULL,116.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,115.9,0,251.6,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(497,111,49,NULL,122.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.5,0,250.2,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(498,111,55,NULL,117.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,114.1,0,250.0,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(499,111,2,NULL,114.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,108.8,0,244.9,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(500,111,50,NULL,116.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.0,0,238.0,NULL,119.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(501,111,54,NULL,117.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,115.0,0,236.4,NULL,118.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,20,NULL,NULL),(502,111,56,NULL,111.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,104.4,0,223.3,NULL,116.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,26,NULL,NULL),(503,112,57,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.1,0,284.1,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(504,112,51,NULL,128.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.5,0,279.1,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(505,112,2,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.9,0,271.6,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(506,112,52,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.2,0,265.4,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(507,112,55,NULL,120.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.4,0,256.5,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(508,112,49,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.6,0,254.2,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(509,112,50,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.3,0,249.0,NULL,119.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(510,112,54,NULL,120.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,120.2,0,239.4,NULL,118.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,25,NULL,NULL),(511,112,56,NULL,119.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.2,0,238.8,NULL,121.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,120.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,27,NULL,NULL),(512,112,44,NULL,116.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,109.2,0,109.2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,37,NULL,NULL),(623,124,50,NULL,146.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,158.4,0,313.4,NULL,141.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,155.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(624,124,44,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.3,0,294.1,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,152.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(625,124,58,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.5,0,291.2,NULL,142.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,152.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(626,124,55,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.9,0,275.7,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(627,124,53,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.9,0,274.9,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(628,124,51,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.9,0,265.2,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(629,124,2,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.6,0,257.9,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(630,124,49,NULL,112.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,92.6,0,92.6,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,38,NULL,NULL),(640,126,55,NULL,128.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.8,0,265.9,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(641,126,50,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.7,0,264.2,NULL,128.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(642,126,51,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.9,0,264.0,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(643,126,58,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.1,0,263.5,NULL,137.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(644,126,57,NULL,125.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.8,0,257.8,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(645,126,52,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.9,0,254.3,NULL,122.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(646,126,49,NULL,119.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.4,0,252.7,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(647,126,44,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.8,0,251.2,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,11,NULL,NULL),(648,126,2,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.5,0,247.4,NULL,121.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,16,NULL,NULL),(649,126,54,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.0,0,247.0,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(650,126,53,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,116.5,0,240.5,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,21,NULL,NULL),(651,126,56,NULL,117.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,112.1,0,178.7,NULL,97.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,66.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,30,NULL,NULL),(676,129,57,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.0,0,271.4,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(677,129,54,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.3,0,270.3,NULL,133.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(678,129,49,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.1,0,267.3,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(679,129,51,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.4,0,263.5,NULL,136.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(680,129,56,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.9,0,252.8,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,11,NULL,NULL),(681,129,44,NULL,123.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,112.0,0,250.2,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,13,NULL,NULL),(682,129,2,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.7,0,236.7,NULL,118.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,111.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,16,NULL,NULL),(683,129,50,NULL,121.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,108.6,0,209.1,NULL,114.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,100.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,23,NULL,NULL),(684,129,52,NULL,118.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,96.9,0,96.9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,36,NULL,NULL),(685,129,55,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,0.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,0,NULL,NULL),(776,139,49,NULL,138.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,147.2,0,282.3,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(777,139,50,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.5,0,281.9,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(778,139,57,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.8,0,280.5,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,145.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(779,139,44,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.3,0,268.3,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(780,139,55,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.1,0,268.0,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(781,139,2,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.7,0,267.6,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(782,139,54,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.4,0,265.2,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,10,NULL,NULL),(783,139,51,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.1,0,262.9,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(784,139,52,NULL,118.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,114.2,0,214.6,NULL,109.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,100.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,27,NULL,NULL),(785,139,53,NULL,116.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,109.2,0,109.2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,40,NULL,NULL),(796,141,57,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.6,0,279.3,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(797,141,44,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.8,0,276.7,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(798,141,2,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.7,0,264.8,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(799,141,52,NULL,121.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.1,0,260.3,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,11,NULL,NULL),(800,141,50,NULL,125.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.6,0,258.0,NULL,123.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,13,NULL,NULL),(801,141,6,NULL,115.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,111.9,0,225.6,NULL,116.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,23,NULL,NULL),(802,142,57,NULL,99.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.8,0,270.8,NULL,98.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(803,142,50,NULL,95.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.3,0,263.6,NULL,100.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(804,142,2,NULL,96.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.8,0,262.5,NULL,99.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(805,142,52,NULL,98.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.9,0,254.4,NULL,95.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,123.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(806,142,55,NULL,93.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,120.1,0,242.6,NULL,94.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,16,NULL,NULL),(807,142,44,NULL,91.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.0,0,240.2,NULL,94.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,19,NULL,NULL),(808,142,6,NULL,90.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,114.7,0,226.3,NULL,89.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,111.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,25,NULL,NULL),(809,142,56,NULL,89.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,108.1,0,108.1,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,34,NULL,NULL),(810,143,2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,281.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(811,143,57,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,266.5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(812,143,52,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,259.5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(813,143,51,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,118.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,31,NULL,NULL),(814,143,6,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,115.9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,36,NULL,NULL),(820,69,58,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.1,0,288.5,NULL,140.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,153.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(821,69,53,NULL,140.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.8,0,287.8,NULL,146.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,155.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(822,69,50,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.0,0,285.7,NULL,141.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,149.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(823,69,55,NULL,140.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.5,0,280.1,NULL,138.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,146.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(824,69,2,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.3,0,277.8,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(825,69,49,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.5,0,257.9,NULL,137.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,13,NULL,NULL),(826,69,57,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.9,0,252.5,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,16,NULL,NULL),(827,69,44,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.8,0,245.9,NULL,135.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(828,69,54,NULL,130.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,111.7,0,229.6,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,27,NULL,NULL),(829,69,56,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.7,0,129.7,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,30,NULL,NULL),(830,69,52,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,104.0,0,104.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,32,NULL,NULL),(831,69,51,NULL,123.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,99.9,0,99.9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,38,NULL,NULL),(832,147,2,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.7,0,261.6,NULL,130.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(833,147,44,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.1,0,246.2,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(834,147,50,NULL,120.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.4,0,245.0,NULL,128.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(835,147,49,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.3,0,244.3,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,116.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(836,147,57,NULL,121.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.2,0,243.5,NULL,127.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(837,147,52,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.6,0,242.5,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,114.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(838,147,55,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.4,0,238.2,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,118.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(839,147,58,NULL,116.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,111.9,0,234.3,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,15,NULL,NULL),(840,147,51,NULL,117.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,109.2,0,234.2,NULL,128.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,16,NULL,NULL),(841,147,54,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.9,0,233.8,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,113.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,17,NULL,NULL),(842,147,56,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.8,0,221.0,NULL,116.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,101.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,30,NULL,NULL),(843,148,58,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.7,0,274.9,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(844,148,44,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.3,0,260.4,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,136.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(845,148,2,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.5,0,260.0,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(846,148,51,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.7,0,259.9,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(847,148,49,NULL,133.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,125.0,0,257.2,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(848,148,50,NULL,137.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,129.4,0,257.2,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(849,148,54,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.9,0,246.6,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(850,148,55,NULL,124.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,115.3,0,237.5,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,122.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,18,NULL,NULL),(851,148,57,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,120.6,0,226.1,NULL,124.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,105.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,28,NULL,NULL),(852,148,52,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,108.3,0,108.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,34,NULL,NULL),(853,148,56,NULL,122.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,107.2,0,107.2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,37,NULL,NULL),(854,148,53,NULL,118.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,95.7,0,95.7,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,44,NULL,NULL),(956,165,57,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,157.6,0,307.3,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,149.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(957,165,52,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,148.2,0,299.8,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,151.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,2,NULL,NULL),(958,165,49,NULL,131.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.1,0,275.8,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(959,165,2,NULL,131.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,144.3,0,274.7,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,130.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(960,165,56,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,146.5,0,273.5,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,127.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,9,NULL,NULL),(961,165,44,NULL,121.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,119.8,0,119.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,40,NULL,NULL),(962,167,2,NULL,139.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,150.9,0,300.7,NULL,140.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,149.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,1,NULL,NULL),(963,167,51,NULL,138.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.6,0,277.3,NULL,133.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(964,167,57,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.5,0,275.9,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(965,167,55,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.0,0,274.8,NULL,139.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,5,NULL,NULL),(966,167,52,NULL,133.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.4,0,274.6,NULL,137.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(967,167,44,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.3,0,273.9,NULL,136.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,7,NULL,NULL),(968,167,54,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.5,0,268.9,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,131.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,10,NULL,NULL),(969,167,58,NULL,133.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.8,0,268.1,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,133.3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,12,NULL,NULL),(970,167,49,NULL,130.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.7,0,265.8,NULL,135.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(971,167,50,NULL,120.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,108.8,0,108.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,35,NULL,NULL),(972,167,56,NULL,119.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,105.3,0,105.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,38,NULL,NULL),(1023,170,55,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.7,0,292.9,NULL,141.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,151.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,3,NULL,NULL),(1024,170,54,NULL,132.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,139.5,0,288.9,NULL,139.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,149.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,4,NULL,NULL),(1025,170,49,NULL,132.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.8,0,282.4,NULL,136.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,143.6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,6,NULL,NULL),(1026,170,50,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.2,0,279.1,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,141.9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(1027,170,56,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,138.7,0,279.1,NULL,134.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,140.4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,8,NULL,NULL),(1028,170,2,NULL,128.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,134.5,0,276.7,NULL,134.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,142.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,11,NULL,NULL),(1029,170,52,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,126.1,0,273.1,NULL,138.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,147.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,14,NULL,NULL),(1030,170,58,NULL,131.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,137.5,0,266.0,NULL,127.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,23,NULL,NULL),(1031,170,51,NULL,126.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,128.1,0,260.3,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,25,NULL,NULL),(1032,170,53,NULL,120.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,110.8,0,110.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,NULL,0,41,NULL,NULL),(1085,166,58,NULL,149.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,154.3,0,154.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,1,NULL,NULL),(1086,166,44,NULL,137.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,135.0,0,135.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,2,NULL,NULL),(1087,166,50,NULL,143.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,132.9,0,132.9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,3,NULL,NULL),(1088,166,57,NULL,136.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,124.5,0,124.5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,6,NULL,NULL),(1089,166,54,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,121.9,0,121.9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,7,NULL,NULL),(1090,166,55,NULL,129.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,117.4,0,117.4,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,11,NULL,NULL),(1091,166,49,NULL,126.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,116.5,0,116.5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,14,NULL,NULL),(1092,166,53,NULL,129.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,115.8,0,115.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,15,NULL,NULL),(1093,166,51,NULL,123.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,109.3,0,109.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,23,NULL,NULL),(1094,166,2,NULL,125.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,107.4,0,107.4,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,27,NULL,NULL),(1095,166,52,NULL,107.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,92.1,0,92.1,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,41,NULL,NULL),(1096,127,51,NULL,231.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,238.8,0,459.3,NULL,232.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,220.5,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,1,NULL,NULL),(1097,127,49,NULL,242.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,249.0,0,452.4,NULL,217.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,203.4,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,2,NULL,NULL),(1098,127,50,NULL,221.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,222.8,0,447.9,NULL,230.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,225.1,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,3,NULL,NULL),(1099,127,56,NULL,233.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,221.3,0,442.5,NULL,233.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,221.2,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,4,NULL,NULL),(1100,127,54,NULL,237.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,227.5,0,438.2,NULL,226.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,210.7,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,5,NULL,NULL),(1101,127,53,NULL,249.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,230.1,0,430.1,NULL,218.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,200.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,7,NULL,NULL),(1102,127,55,NULL,232.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,221.3,0,426.7,NULL,222.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,205.4,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,9,NULL,NULL),(1103,127,52,NULL,245.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,222.1,0,425.8,NULL,224.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,203.7,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,10,NULL,NULL),(1104,127,44,NULL,226.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,202.5,0,415.4,NULL,230.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,212.9,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,13,NULL,NULL),(1105,127,58,NULL,239.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,225.4,0,401.1,NULL,204.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,175.7,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,16,NULL,NULL),(1106,127,57,NULL,220.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,201.4,0,399.3,NULL,217.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,197.9,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,17,NULL,NULL),(1107,127,2,NULL,216.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,197.3,0,381.9,NULL,206.5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,184.6,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0.0,0.0,0,20,NULL,NULL),(1108,175,5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,283.3,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,1,NULL,NULL),(1109,175,9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,234.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,12,NULL,NULL),(1110,175,2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,221.1,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,23,NULL,NULL),(1111,175,50,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,187.1,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,30,NULL,NULL),(1112,175,44,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,103.7,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,36,NULL,NULL),(1113,176,5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,274.5,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,1,NULL,NULL),(1114,176,2,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,268.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,4,NULL,NULL),(1115,176,9,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,255.0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,10,NULL,NULL),(1116,176,44,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,214.8,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,NULL,0.0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0.0,0,28,NULL,NULL);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `season` (
  `idseason` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `season` smallint unsigned NOT NULL,
  PRIMARY KEY (`idseason`),
  UNIQUE KEY `season_UNIQUE` (`season`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
INSERT INTO `season` VALUES (1,1920),(2,1921),(3,1922),(4,1923),(5,1924),(6,1925),(7,1926),(8,1927),(9,1928),(10,1929),(11,1930),(12,1931),(13,1932),(14,1933),(15,1934),(16,1935),(17,1936),(18,1937),(19,1938),(20,1939),(21,1940),(22,1941),(23,1942),(24,1943),(25,1944),(26,1945),(27,1946),(28,1947),(29,1948),(30,1949),(31,1950),(32,1951),(33,1952),(34,1953),(35,1954),(36,1955),(37,1956),(38,1957),(39,1958),(40,1959),(41,1960),(42,1961),(43,1962),(44,1963),(45,1964),(46,1965),(47,1966),(48,1967),(49,1968),(50,1969),(51,1970),(52,1971),(53,1972),(54,1973),(55,1974),(56,1975),(57,1976),(58,1977),(59,1978),(60,1979),(61,1980),(62,1981),(63,1982),(64,1983),(65,1984),(66,1985),(67,1986),(68,1987),(69,1988),(70,1989),(71,1990),(72,1991),(73,1992),(74,1993),(75,1994),(76,1995),(77,1996),(78,1997),(79,1998),(80,1999),(81,2000),(82,2001),(83,2002),(84,2003),(85,2004),(86,2005),(87,2006),(88,2007),(89,2008),(90,2009),(91,2010),(92,2011),(93,2012),(94,2013),(95,2014),(96,2015),(97,2016),(98,2017),(99,2018),(100,2019),(101,2020),(102,2021),(103,2022),(104,2023);
/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `series` (
  `idseries` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `points_scale_idpoints_scale` tinyint DEFAULT NULL,
  PRIMARY KEY (`idseries`),
  KEY `fk_series_point_scale1_idx` (`points_scale_idpoints_scale`),
  CONSTRAINT `fk_series_point_scale1` FOREIGN KEY (`points_scale_idpoints_scale`) REFERENCES `points_scale` (`idpoints_scale`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (1,'Winter Olympic Games',NULL),(2,'Winter Olympic Games Team',NULL),(3,'FIS Nordic World Ski Championships',NULL),(4,'FIS Nordic World Ski Championships Team ',NULL),(5,'FIS Ski Flying World Championships',NULL),(6,'FIS Ski Flying World Championships Team',NULL),(7,'FIS Junior Ski Jumping World Championships',NULL),(8,'FIS Junior Ski Jumping World Championships Team',NULL),(9,'FIS Ski Jumping World Cup',3),(10,'FIS Ski Flying World Cup',3),(11,'Nations Cup',1),(12,'Four Hills Tournament',6),(13,'K.O.P. International Ski Flying Week',NULL),(14,'Swiss Tournament',NULL),(15,'Nordic Tournament',NULL),(16,'Bohemia Tournament',NULL),(17,'FIS Team Tour',NULL),(18,'Raw Air',6),(19,'Willingen Five',NULL),(20,'Planica7',NULL),(21,'Titisee-Neustadt Five',NULL),(22,'FIS Ski Jumping Grand Prix',3),(23,'Four Nations Grand Prix',NULL),(24,'Poland Tour',NULL),(25,'Summer Nations Cup',NULL),(26,'FIS Ski Jumping Continental Cup',3),(27,'FIS Ski Jumping Summer Continental Cup',3),(28,'FIS Cup',3),(29,'FIS Ski Jumping Alpen Cup',NULL),(30,'Kongsberg Cup & Trophy',NULL),(31,'Holmenkollen Ski Festival',NULL),(32,'International Ski Flying Week',NULL),(33,'Grand Prix of Nations',NULL),(34,'Tatra Cup',NULL),(35,'Copper Peak Ski Flying',NULL),(36,'Thunder Bay International',NULL),(37,'Sapporo International',NULL),(38,'Czech-Marusarz Memorial',NULL),(39,'Flubergrennet',NULL),(40,'3 Countries Tournament',NULL),(41,'Friendship Tournament',NULL),(42,'Iron Mountain International',NULL),(43,'Garmisch Wintersportwoche',NULL),(44,'Murau International',NULL),(45,'European Youth Festival',NULL),(46,'European Youth Festival Team',NULL),(47,'Winter Universiade',NULL),(48,'Winter Universiade Team',NULL),(49,'Youth Olympic Winter Games',NULL),(50,'Youth Olympic Winter Games Team',NULL),(51,'North American Ski Jumping & NC Championships',NULL),(52,'International Miyasama Ski Games',NULL),(53,'Europa-Park FIS Youth Cup',NULL),(54,'Asian Winter Games',NULL),(55,'Opa Games',NULL);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size_of_hill`
--

DROP TABLE IF EXISTS `size_of_hill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size_of_hill` (
  `idsize_of_hill` tinyint unsigned NOT NULL,
  `designation` varchar(20) NOT NULL,
  `min_hs` tinyint unsigned NOT NULL,
  `max_hs` smallint unsigned NOT NULL,
  `min_distance_t_k` tinyint unsigned NOT NULL COMMENT '\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n',
  `max_distance_t_k` smallint unsigned NOT NULL,
  PRIMARY KEY (`idsize_of_hill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size_of_hill`
--

LOCK TABLES `size_of_hill` WRITE;
/*!40000 ALTER TABLE `size_of_hill` DISABLE KEYS */;
INSERT INTO `size_of_hill` VALUES (1,'Small Hill',0,49,0,44),(2,'Medium Hill',50,84,45,75),(3,'Normal Hill',85,109,76,98),(4,'Large Hill',110,145,99,130),(5,'Flying Hill',185,1000,166,1000);
/*!40000 ALTER TABLE `size_of_hill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ski_club`
--

DROP TABLE IF EXISTS `ski_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ski_club` (
  `idski_club` smallint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `city_idcity` mediumint unsigned DEFAULT NULL,
  PRIMARY KEY (`idski_club`),
  KEY `fk_ski_club_city1_idx` (`city_idcity`),
  CONSTRAINT `fk_ski_club_city1` FOREIGN KEY (`city_idcity`) REFERENCES `city` (`idcity`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ski_club`
--

LOCK TABLES `ski_club` WRITE;
/*!40000 ALTER TABLE `ski_club` DISABLE KEYS */;
INSERT INTO `ski_club` VALUES (1,'ND Ratece Planica',1),(7,'AZS AWF Katowice',3),(8,'AZS Zakopane',4),(9,'KS Bbts Bielsko-Biala',5),(10,'KS Chocholow',NULL),(11,'KS Eve-nement Zakopane',4),(12,'KS Rutkow-Ski',4),(13,'KS Sniezka Karpacz',8),(14,'KS Start Krokiew Zakopane',4),(15,'KS Wisla Ustronianka',19),(16,'LKS \"Biali\" Bialy Dunajec',9),(18,'LKS Klimczok Bystra',2),(19,'LKS Olimpia Goleszow',11),(20,'LKS Poroniec Poronin',10),(21,'Luks-Ski Lubawka',12),(22,'PKS Olimpijczyk Gilowice',13),(23,'SKS Start Zakopane',4),(24,'SS-R LZS Sokol Szczyrk',7),(25,'TS Wisla Zakopane',4),(26,'Uks Soltysianie',14),(27,'WKS Zakopane',4),(28,'WSS Wisla',19),(29,'ZKN Sokol Zagorz',15),(30,'ZTS Zakucie Zagorz',15),(31,'ASVOE SC Hoehnhart',20),(32,'ASVOE SC Raiffeisen Seekirchen',21),(33,'ESV Muerzzuschlag-Steiermark',22),(34,'HSV Absam-Bergisel',23),(35,'KSG Klagenfurt-Kaernten',24),(36,'Kitzbueheler Ski Club - KSC',25),(37,'Naturfreunde Fohnsdorf',26),(38,'Nordic Skiteam Salzkammergut-Oberoe',64),(39,'SC Arlberg',28),(40,'SC Bischofshofen',29),(41,'SC Breitenwang-Tirol',30),(42,'SC Egg',31),(43,'SC Ehrwald',32),(44,'SC Erzbergland',62),(45,'SC Fieberbrunn',35),(47,'SC Hoehenart',20),(48,'SC Kehlegg',36),(49,'SC Mayerhofen-Tirol',37),(50,'SC Rottenmann',38),(51,'SC Saalfelden',39),(52,'SC Schwarzenberg',40),(53,'SC Seekirchen-Salzburg',21),(54,'SC Waldzell',41),(55,'SC Woergl',42),(56,'SK Telfs',45),(57,'SU Haus im Ennstal-Steiermark',69),(58,'SV Achomitz-Zahomc',46),(59,'SV Bad Goisern NTS',47),(60,'SV Casino Kleinwalsertal',48),(61,'SV Dornbirn-Vorarlberg',49),(62,'SV Innsbruck-Bergisel',50),(63,'SV Schwarzach-Salzburg',NULL),(64,'SV Villach',52),(65,'SVU Hittisau',53),(66,'SZ Velden',54),(67,'Skisprungclub Wiener Stadtadler',70),(68,'TSU St. Veit im Pongau',55),(69,'UVB Hinzenbach',56),(70,'Union SC Rauris',57),(71,'Union Sk ramingstein',58),(72,'WSC Bad Mitterndorf',59),(73,'WSV Andelsbuch',60),(74,'WSV Bad Hofgastein',61),(75,'WSV Bad Ischl-NTS-Oberoesterreich',27),(76,'WSV Eisenerz',62),(77,'WSV Murau',63),(78,'WSV Ramsau',64),(79,'WSV Schoppernau',65),(80,'WSV Sibratsgfaell',66),(81,'WSV Sparkasse Bad Ischl',27),(82,'WSV Tschagguns',67),(83,'WSV Vomp',68),(84,'WSV Woergl',42),(85,'Altius Nordic Ski Club',72),(86,'Dukla Frenstat',79),(87,'Dukla Liberec',71),(88,'LSK Lomnice nad Popelkou',NULL),(89,'SK Jested Liberec',71),(90,'SKI Klub Kozlovice',77),(91,'SKL Nove Mesto nad Morave',76),(92,'Ski Klub Harrachov',78),(93,'TJ Frenstat pod Radhostem',79),(94,'TJ MEZ Frenstat',79),(95,'TJ Roznov pod Radhostem',81),(96,'TJ Trinec',82),(97,'Andsumae Sk',83),(98,'ES Pohjakotkas',84),(99,'Nomme Skiclub',84),(100,'Otepaa Sportclub',85),(101,'Pohjakotkas-Otepaa',85),(102,'Skiclub Elva',86),(103,'Vaguli SK',88),(104,'Voru Sportschool',87),(105,'Harjavallan Jymy',92),(106,'Helsingin Maekihyppaeaejaet',93),(107,'Hyvinkään Hiihtoserua',94),(108,'Jyvaskylan Hiihtoseura',95),(109,'KL SkiJumping Team',100),(110,'Kainuun Hiihtoseura',96),(111,'Kiteen Urheilijat',97),(113,'Kouvolan Hiihtoseura',98),(114,'Kuusamon Erä-Veikot',99),(115,'Lahden Hiihtoseura',100),(116,'Lapuan Virkia',101),(117,'Lieksan Hiihtoseura',102),(119,'Ounasvaaran Hiihtoseura',103),(120,'Paimion Urheilijat',104),(121,'Puijon Hiihtoseura',105),(122,'Saarijaerven Ponsi',106),(123,'Seinajoki Ski club',107),(124,'Siilinjarven Ponnistus',108),(125,'Simpeleen Urheilijat',109),(126,'Skiclub Syväskylä',95),(127,'Taivalkosken Kuohu',110),(128,'Tampereen Pyrintoe',111),(129,'Vuokattisport Club',112),(130,'Ylistaron Kilpaveljet',113),(132,'SC Auerbach',148),(133,'SC Bubenbach',150),(134,'SC Hammer',NULL),(135,'SC Waldau',159),(136,'Fortuna Pöhla',144),(137,'Fsv Rittersgruen',145),(138,'SC 1906 Oberstdorf',147),(139,'SC Bischofsgrün',149),(140,'SC Degenfeld',151),(141,'SC Furtwangen',152),(142,'SC Hinterzarten',154),(143,'SC Königsbronn',155),(144,'SC Luedenscheid',156),(145,'SC Menzenschwand',157),(146,'SC Motor Zella-Mehlis',158),(147,'SC Neustadt',159),(148,'SC Partenkirchen',160),(149,'SC Ruhpolding',161),(150,'SC Schoenwald',162),(151,'SC Schonach',163),(152,'SC Steinbach-Hallenberg',164),(153,'SC Traunstein',165),(154,'SC Villingen',NULL),(155,'SC Wiesensteig',167),(156,'SC Willingen',168),(157,'SF Gmund-Duernbach',169),(158,'SG Nickelhuette Aue',170),(159,'SK Berchtesgaden',171),(160,'SK Meinerzhagen',172),(161,'SK Winterberg',173),(162,'SSV 1846 Scheibenberg e.V.',174),(163,'SV Baiersbronn',175),(164,'SV Biberau',176),(165,'SV Cursdorf',177),(166,'SV Lok Eilenburg',178),(167,'SV Meßstetten',179),(168,'SV Mitteltal-Obertal',181),(169,'SV Oberwiesenthal',146),(170,'SV Stuetzengruen',182),(171,'SV Zschopau',183),(172,'SWV Goldlauter',184),(173,'SZ Bad Grießbach',185),(174,'SZ Breitnau',186),(175,'SZK Eberbach',187),(176,'Sc Schluchsee-blasiwald',219),(177,'Ssv Geyer',188),(178,'TSV Siegsdorf',NULL),(179,'TUS Neuenrade',191),(180,'Tabarzer Sv 1887',189),(181,'Tsv Buchenberg',190),(182,'VSC Klingenthal',192),(183,'Vfl Pfullingen',193),(184,'WSC 07 Ruhla',194),(185,'WSC Erzgebirge Oberwiesenthal',146),(186,'WSG Rodewisch',195),(187,'WSV 08 Johanngeorgenstadt',196),(188,'WSV 08 Lauscha',197),(189,'WSV 1923 Bad Freienwalde e.V.',198),(190,'WSV Aschau',199),(191,'WSV Braunlage',200),(192,'WSV Brotterode',201),(193,'WSV DJK Rastbüchl',202),(194,'WSV Grüna',203),(195,'WSV Isny e.V.',204),(196,'WSV Kiefersfelden',205),(197,'WSV Kleinschmalkalden',206),(198,'WSV Ober-Unterschoenau',207),(199,'WSV Oberaudorf',208),(200,'WSV Oberhof 05',209),(201,'WSV Rastbüchl',202),(202,'WSV Reit im Winkl',210),(203,'WSV Schmiedefeld',211),(204,'WSV Steinbach',164),(205,'WSV Warmensteinach',212),(206,'SC Einsiedeln',245),(207,'SSC Toggenburg',244),(209,'U.S. Asiago',269),(210,'Skiforeningen',265),(211,'CSS Dinamo Râşnov',262),(212,'SC Seefeld',284),(214,'Rossport',250),(215,'SV Brunnentalschanze Stams',287),(216,'Vikersund IF',301);
/*!40000 ALTER TABLE `ski_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ski_jumper`
--

DROP TABLE IF EXISTS `ski_jumper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ski_jumper` (
  `idski_jumper` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `person_idperson` mediumint unsigned NOT NULL,
  `is_active` tinyint DEFAULT '1' COMMENT 'Boolean.',
  `skis_idskis` tinyint unsigned DEFAULT NULL,
  `all_time_points` decimal(6,1) unsigned DEFAULT '0.0',
  `ski_club_idski_club` smallint unsigned DEFAULT NULL,
  `fis_code` int unsigned DEFAULT NULL,
  PRIMARY KEY (`idski_jumper`),
  KEY `fk_ski_jumper_person1_idx` (`person_idperson`),
  KEY `fk_ski_jumper_skis1_idx` (`skis_idskis`),
  KEY `fk_ski_jumper_ski_club1_idx` (`ski_club_idski_club`),
  CONSTRAINT `fk_ski_jumper_person1` FOREIGN KEY (`person_idperson`) REFERENCES `person` (`idperson`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `fk_ski_jumper_ski_club1` FOREIGN KEY (`ski_club_idski_club`) REFERENCES `ski_club` (`idski_club`) ON DELETE CASCADE,
  CONSTRAINT `fk_ski_jumper_skis1` FOREIGN KEY (`skis_idskis`) REFERENCES `skis` (`idskis`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ski_jumper`
--

LOCK TABLES `ski_jumper` WRITE;
/*!40000 ALTER TABLE `ski_jumper` DISABLE KEYS */;
INSERT INTO `ski_jumper` VALUES (1,1,0,3,0.0,15,2039),(2,124,1,3,NULL,11,4321),(3,4,0,8,0.0,142,NULL),(5,6,0,3,NULL,62,5040),(6,67,0,1,NULL,115,1995),(9,11,0,3,NULL,207,2067),(11,13,1,3,0.0,54,NULL),(44,68,1,3,NULL,28,4325),(46,71,0,3,NULL,NULL,2354),(49,83,1,3,NULL,NULL,6288),(50,88,1,3,NULL,178,5253),(51,89,1,3,NULL,138,5567),(52,90,1,3,NULL,69,5288),(53,91,1,7,NULL,1,6845),(54,92,1,3,NULL,53,5945),(55,93,1,3,NULL,NULL,5589),(56,94,1,7,NULL,NULL,7091),(57,95,0,3,NULL,63,5497),(58,96,0,3,NULL,NULL,6880);
/*!40000 ALTER TABLE `ski_jumper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skis`
--

DROP TABLE IF EXISTS `skis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skis` (
  `idskis` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  PRIMARY KEY (`idskis`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skis`
--

LOCK TABLES `skis` WRITE;
/*!40000 ALTER TABLE `skis` DISABLE KEYS */;
INSERT INTO `skis` VALUES (1,'Atomic'),(2,'Elan'),(3,'Fischer'),(4,'Fluege.de'),(5,'Kaestle'),(6,'Sport 2000'),(7,'Slatnar'),(8,'Rossignol');
/*!40000 ALTER TABLE `skis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_overall_standing`
--

DROP TABLE IF EXISTS `team_overall_standing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_overall_standing` (
  `idteam_overall_standing` int NOT NULL AUTO_INCREMENT,
  `series_idseries` tinyint unsigned NOT NULL,
  `season_idseason` tinyint unsigned NOT NULL,
  `country_idcountry` smallint unsigned NOT NULL,
  `points` decimal(6,2) DEFAULT '0.00',
  `ranking` mediumint unsigned DEFAULT NULL,
  PRIMARY KEY (`idteam_overall_standing`),
  KEY `fk_team_overall_standings_season_idx` (`season_idseason`),
  KEY `fk_team_overall_standings_series_idx` (`series_idseries`),
  KEY `fk_team_overall_standings_country_idx` (`country_idcountry`),
  CONSTRAINT `fk_team_overall_standings_country` FOREIGN KEY (`country_idcountry`) REFERENCES `country` (`idcountry`) ON DELETE RESTRICT,
  CONSTRAINT `fk_team_overall_standings_season` FOREIGN KEY (`season_idseason`) REFERENCES `season` (`idseason`) ON DELETE RESTRICT,
  CONSTRAINT `fk_team_overall_standings_series` FOREIGN KEY (`series_idseries`) REFERENCES `series` (`idseries`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_overall_standing`
--

LOCK TABLES `team_overall_standing` WRITE;
/*!40000 ALTER TABLE `team_overall_standing` DISABLE KEYS */;
INSERT INTO `team_overall_standing` VALUES (125,11,102,515,2216.00,4),(126,11,102,677,2404.00,3),(127,11,102,666,2530.00,2),(128,11,102,704,1168.00,6),(129,11,102,612,1412.00,5),(130,11,102,583,3044.00,1),(131,11,102,575,150.00,7),(132,11,102,718,150.00,7),(133,11,93,515,100.00,0),(134,11,93,718,22.00,0),(135,11,93,677,8.00,0),(136,11,93,583,1.00,0);
/*!40000 ALTER TABLE `team_overall_standing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_result`
--

DROP TABLE IF EXISTS `team_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_result` (
  `idteam_result` int NOT NULL AUTO_INCREMENT,
  `country_idcountry` smallint unsigned NOT NULL,
  `total_points` decimal(5,1) unsigned DEFAULT NULL,
  `total_rank` smallint unsigned DEFAULT NULL,
  `competition_idcompetition` mediumint unsigned NOT NULL,
  PRIMARY KEY (`idteam_result`),
  KEY `fk_team_result_competition_idx` (`competition_idcompetition`),
  KEY `fk_team_result_country_idx` (`country_idcountry`),
  CONSTRAINT `fk_team_result_competition` FOREIGN KEY (`competition_idcompetition`) REFERENCES `competition` (`idcompetition`) ON DELETE CASCADE,
  CONSTRAINT `fk_team_result_country` FOREIGN KEY (`country_idcountry`) REFERENCES `country` (`idcountry`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_result`
--

LOCK TABLES `team_result` WRITE;
/*!40000 ALTER TABLE `team_result` DISABLE KEYS */;
INSERT INTO `team_result` VALUES (1,666,1024.2,1,146),(2,677,1018.3,2,146),(3,583,1014.4,3,146),(4,515,1003.0,4,146),(5,612,957.3,5,146),(6,704,938.0,6,146),(7,718,792.8,7,146),(8,575,772.0,8,146),(9,739,310.1,9,146),(233,515,991.2,1,169),(234,677,982.3,2,169),(235,666,974.8,3,169),(236,704,936.9,4,169),(237,612,925.1,5,169),(238,583,870.3,6,169),(239,575,801.9,7,169),(240,718,700.5,8,169),(241,609,336.6,9,169),(251,666,1024.2,1,171),(252,677,1018.3,2,171),(253,583,1014.4,3,171),(254,515,1003.0,4,171),(255,612,957.3,5,171),(256,704,938.0,6,171),(257,718,792.8,7,171),(258,575,772.0,8,171),(259,739,310.1,9,171);
/*!40000 ALTER TABLE `team_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_result_individual`
--

DROP TABLE IF EXISTS `team_result_individual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_result_individual` (
  `idteam_result_individual` int NOT NULL AUTO_INCREMENT,
  `ski_jumper_idski_jumper` mediumint unsigned NOT NULL,
  `first_round_distance` decimal(4,1) unsigned DEFAULT NULL,
  `second_round_distance` decimal(4,1) unsigned DEFAULT NULL,
  `team_result_idteam_result` int NOT NULL,
  PRIMARY KEY (`idteam_result_individual`),
  KEY `fk_team_result_individual_ski_jumper_idx` (`ski_jumper_idski_jumper`),
  KEY `fk_team_result_individual_team_result_idx` (`team_result_idteam_result`),
  CONSTRAINT `fk_team_result_individual_ski_jumper` FOREIGN KEY (`ski_jumper_idski_jumper`) REFERENCES `ski_jumper` (`idski_jumper`) ON DELETE CASCADE,
  CONSTRAINT `fk_team_result_individual_team_result` FOREIGN KEY (`team_result_idteam_result`) REFERENCES `team_result` (`idteam_result`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_result_individual`
--

LOCK TABLES `team_result_individual` WRITE;
/*!40000 ALTER TABLE `team_result_individual` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_result_individual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'admin','skijumpingstats@gmail.com','$2a$10$8DRuZ5rA9o08JrnrzehCC.XSHG/sPQbF9T/fC.5iW3P7lFZMawZve'),(5,'frontend','skijumpingstatsF@gmail.com','$2a$10$K1Dcs5IV2hVBZMa0vRZ5nuTuKZfTlCC9tSP5hKot22ps1fTQ48Ety'),(7,'moderator','sjsmod@gmail.com','$2a$10$.DBXYG1ELM.JlalfzOXAlOxINoSRZ9GI6jQ0P4zV.Z5RlYXGOZGmq');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  KEY `fk_user_roles_user1_idx` (`user_id`),
  KEY `fk_user_roles_roles1_idx` (`role_id`),
  CONSTRAINT `fk_user_roles_roles1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_roles_users1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,3),(5,1),(7,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venue` (
  `idvenue` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `year_of_opening` smallint unsigned DEFAULT NULL,
  `capacity` mediumint unsigned DEFAULT NULL,
  `ski_club_idski_club` smallint unsigned DEFAULT NULL,
  `city_idcity` mediumint unsigned NOT NULL,
  PRIMARY KEY (`idvenue`),
  KEY `fk_venue_ski_club1_idx` (`ski_club_idski_club`),
  KEY `fk_venue_city1_idx` (`city_idcity`),
  CONSTRAINT `fk_venue_city1` FOREIGN KEY (`city_idcity`) REFERENCES `city` (`idcity`),
  CONSTRAINT `fk_venue_ski_club1` FOREIGN KEY (`ski_club_idski_club`) REFERENCES `ski_club` (`idski_club`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (1,'Letalnica',1969,50000,1,1),(2,'Wielka Krokiew',1925,26000,25,4),(3,'Średnia Krokiew',1950,0,25,4),(4,'Schanzen Einsiedeln',2005,0,206,245),(5,'Sepp Bradl-Skistadion',1947,30000,40,29),(7,'Areál velkých můstků Čerťák',1979,50000,92,78),(8,'Holmenkollen',1892,30000,210,265),(9,'Salpausselkä',1922,80000,115,100),(10,'Puijo',1949,0,121,105),(11,'Ruka',1964,0,114,283),(12,'Audi Arena',1925,25500,138,147),(13,'Malinka',1933,8000,15,19),(14,'Olympiaschanze',1934,21000,148,160),(15,'Bergisel',1927,22500,62,50),(16,'Mühlenkopf',1925,38000,156,168),(17,'Vogtland Arena',2006,30000,182,192),(18,'Hochfirst',1932,25000,147,159),(19,'Valea Cărbunării',1936,0,211,262),(20,'Casino Arena',1931,25000,212,284),(21,'Tauplitz',1949,40000,72,59),(22,'Ještěd',1966,10000,87,71),(23,'Skalite',1937,0,24,7),(24,'RusSki Gorki Jumping Center',2012,7500,214,286),(25,'Skiflugschanze',1950,40000,138,147),(26,'Kanzlersgrund',1959,0,200,209),(27,'Chiemgau Arena',1961,0,149,161),(28,'Adler-Skistadion',1924,20000,142,154),(29,'Inselbergschanze',1923,0,192,201),(30,'Ulanowice',1924,0,21,12),(31,'Orlinek',1912,0,13,8),(33,'Langenwaldschanze',1924,8000,151,163),(35,'Wisła Centrum',1964,0,15,19),(39,'Zakucie',2004,0,30,15),(41,'Ounasvaara',1927,0,119,103);
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weather`
--

DROP TABLE IF EXISTS `weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weather` (
  `idweather` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `weather` varchar(40) NOT NULL,
  PRIMARY KEY (`idweather`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weather`
--

LOCK TABLES `weather` WRITE;
/*!40000 ALTER TABLE `weather` DISABLE KEYS */;
INSERT INTO `weather` VALUES (1,'overcast'),(2,'lightly snowfall'),(3,'snowfall'),(4,'clear'),(5,'sunny'),(6,'rain'),(7,'partly cloudy / rain'),(8,'partly cloudy'),(9,'cloudy'),(10,'brief rain and snowfall'),(11,'mist');
/*!40000 ALTER TABLE `weather` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-24 11:33:22
