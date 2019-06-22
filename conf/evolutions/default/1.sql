# --- !Ups

-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: messma_debug
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Table structure for table `play_evolutions`
--

CREATE TABLE IF NOT EXISTS`play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `apply_script` mediumtext,
  `revert_script` mediumtext,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `accesspoints`
--

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS`projects` (
  `_id_project` int(11) NOT NULL,
  `title` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `buildingInfo` varchar(256) NOT NULL,
  PRIMARY KEY (`_id_project`),
  UNIQUE KEY `_id_project` (`_id_project`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shemes`
--

CREATE TABLE IF NOT EXISTS`shemes` (
  `_id_sheme` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gridRows` int(11) NOT NULL,
  `gridCols` int(11) NOT NULL,
  `plan` LONGTEXT NOT NULL,
  `fk_id_project` int(11) NOT NULL,
  PRIMARY KEY (`_id_sheme`),
  KEY `id` (`_id_sheme`),
  KEY `fk_id_project` (`fk_id_project`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `stands`
--


--
-- Table structure for table `vectors`
--

CREATE TABLE IF NOT EXISTS`vectors` (
  `_id_vector` varchar(50) NOT NULL,
  `distance` int(11) NOT NULL,
  `fk_id_grid_point_start` int(11) NOT NULL,
  `fk_id_grid_point_end` int(11) NOT NULL,
  PRIMARY KEY (`_id_vector`),
  KEY `fk_vector_gridpoints1_idx` (`fk_id_grid_point_start`),
  KEY `fk_vector_gridpoints2_idx` (`fk_id_grid_point_end`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `gridpoints`
--

CREATE TABLE IF NOT EXISTS`gridpoints` (
  `_id_grid_point` int(11) NOT NULL,
  `pos_x` int(11) DEFAULT NULL,
  `pos_y` int(11) DEFAULT NULL,
  `fk_id_sheme` varchar(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`_id_grid_point`),
  KEY `fk_sheme` (`fk_id_sheme`),
  CONSTRAINT `gridpoints_ibfk_1` FOREIGN KEY (`fk_id_sheme`) REFERENCES `shemes` (`_id_sheme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE IF NOT EXISTS`accesspoints` (
  `_id_mac` varchar(45) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `activity` tinyint(1) NOT NULL,
  PRIMARY KEY (`_id_mac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grid_has_accesspoints`
--

CREATE TABLE IF NOT EXISTS`grid_has_accesspoints` (
  `pk_grid_accesspoint` varchar(50) NOT NULL,
  `signal_power` int(11) NOT NULL,
  `fk_id_gridPoint` varchar(11) NOT NULL,
  `fk_id_mac` varchar(45) NOT NULL,
  PRIMARY KEY (`pk_grid_accesspoint`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE IF NOT EXISTS`stands` (
  `_id_stand` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `fk_id_grid_point` int(11) NOT NULL,
  `logo` LONGTEXT NOT NULL,
  PRIMARY KEY (`_id_stand`),
  KEY `FK_GID` (`fk_id_grid_point`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `navigate_history`
--

CREATE TABLE IF NOT EXISTS`navigate_history` (
  `pk_start_end` varchar(101) NOT NULL,
  `count` int(11) NOT NULL,
  `start_point` varchar(50) NOT NULL,
  `end_point` varchar(50) NOT NULL,
  PRIMARY KEY (`pk_start_end`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-21 21:12:28