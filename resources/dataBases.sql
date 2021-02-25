-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 23 fév. 2021 à 14:26
-- Version du serveur :  8.0.19
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bd_cabinetmedicale`
--

-- --------------------------------------------------------

--
-- Structure de la table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `id_appointment` int NOT NULL AUTO_INCREMENT,
  `DateofChecking` datetime DEFAULT NULL,
  `DateofAppointment` datetime DEFAULT NULL,
  `id_patient` int DEFAULT NULL,
  `TypeofIllness` varchar(100) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `notification` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_appointment`),
  KEY `Appointment_FK` (`id_patient`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `appointment`
--

INSERT INTO `appointment` (`id_appointment`, `DateofChecking`, `DateofAppointment`, `id_patient`, `TypeofIllness`, `Description`, `notification`) VALUES
(22, '2021-02-06 00:00:00', '2021-03-24 00:00:00', 3, 'Allergie', 'Allergie du peau', 1),
(23, '2021-02-16 00:00:00', '2021-02-27 00:00:00', 3, 'aaaaaaa', 'aaaaaaaa', 1),
(24, '2021-02-16 00:00:00', '2021-02-27 00:00:00', 3, 'aaaaaaa', 'aaaaaaaa', 1);

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id_consultation` int NOT NULL AUTO_INCREMENT,
  `motif` varchar(100) DEFAULT NULL,
  `ConsultationDate` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `id_prescription` int DEFAULT NULL,
  `id_patient` int DEFAULT NULL,
  PRIMARY KEY (`id_consultation`),
  KEY `consultation_FK` (`id_patient`),
  KEY `consultation_FK_1` (`id_prescription`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id_consultation`, `motif`, `ConsultationDate`, `price`, `id_prescription`, `id_patient`) VALUES
(19, 'Traitement', '2021-02-27', 250, 18, 3),
(20, 'traitement', '2021-02-26', 111, NULL, 3),
(21, 'AAAAA', '2021-02-27', 200, 19, 3);

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `id_doctor` int NOT NULL AUTO_INCREMENT,
  `speciality` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_doctor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `doctor`
--

INSERT INTO `doctor` (`id_doctor`, `speciality`) VALUES
(2, 'généraliste');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id_patient` int NOT NULL AUTO_INCREMENT,
  `BirthDate` date DEFAULT NULL,
  `sex` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id_patient`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `BirthDate`, `sex`) VALUES
(3, '1997-02-01', 'Homme');

-- --------------------------------------------------------

--
-- Structure de la table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
CREATE TABLE IF NOT EXISTS `prescription` (
  `id_prescription` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `dateOfPrescription` date DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `medicationList` text,
  PRIMARY KEY (`id_prescription`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `prescription`
--

INSERT INTO `prescription` (`id_prescription`, `title`, `dateOfPrescription`, `description`, `medicationList`) VALUES
(18, 'Traitement d\'allergie', '2021-02-27', 'Traitement d\'allergie du peau', 'reno 20g - Alto 10g');
-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id_user` int NOT NULL AUTO_INCREMENT,
  `accountType` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'patient',
  `cin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `USER_UN` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`firstName`, `lastName`, `phone`, `email`, `password`, `id_user`, `accountType`, `cin`) VALUES
('Ali', 'KAMALI', '614141414', 'ali@gmail.com', 'ali1234', 2, 'doctor', 'UA1213141'),
('Walid', 'Barrada', '613214151', 'Walid@gmail.com', 'walid1234', 3, 'patient', 'U771177');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `Appointment_FK` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`);

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `consultation_FK` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consultation_FK_1` FOREIGN KEY (`id_prescription`) REFERENCES `prescription` (`id_prescription`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `Doctor_FK` FOREIGN KEY (`id_doctor`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `Patient_FK` FOREIGN KEY (`id_patient`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
