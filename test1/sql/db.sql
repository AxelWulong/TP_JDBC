-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           10.4.6-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour cg90_java_ava_test1
CREATE DATABASE IF NOT EXISTS `java_ava_jdbc_evaluations` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `java_ava_jdbc_evaluations`;

-- Listage de la structure de la table note
CREATE TABLE IF NOT EXISTS `note` (
  `stagiaire_id` int(11) NOT NULL,
  `matiere_id` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  PRIMARY KEY (`stagiaire_id`,`matiere_id`),
  KEY `fk_stagiaire_idx` (`stagiaire_id`),
  CONSTRAINT `fk_stagiaire` FOREIGN KEY (`stagiaire_id`) REFERENCES `stagiaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matiere` FOREIGN KEY (`matiere_id`) REFERENCES `matiere` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table stagiaire
CREATE TABLE IF NOT EXISTS `stagiaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` varchar(10) NOT NULL,
  `grade` varchar(3) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la matiere
CREATE TABLE IF NOT EXISTS `matiere` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `domaine` varchar(50) NOT NULL,
  `coefficient` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
