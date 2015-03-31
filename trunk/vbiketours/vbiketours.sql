-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2015 at 07:00 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vbiketours`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `country` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pickup_location` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `additional_infos` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) unsigned NOT NULL,
  `payment_type` tinyint(1) NOT NULL,
  `cart_id` int(10) unsigned NOT NULL,
  `payment_succes` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE IF NOT EXISTS `tour` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `summary` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `fitness` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `vehicle` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `duration` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `style` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `route` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `nb_passenger_max` int(11) NOT NULL,
  `price` double NOT NULL,
  `start_time` time NOT NULL,
  `validity_start` datetime NOT NULL,
  `validity_end` datetime NOT NULL,
  `picture` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`id`, `name`, `summary`, `description`, `fitness`, `vehicle`, `duration`, `style`, `route`, `nb_passenger_max`, `price`, `start_time`, `validity_start`, `validity_end`, `picture`) VALUES
(1, 'Saigon Sightseeing Tours', 'Experience French Architecture Sights and The  Vietnamese Daily life in Saigon.....', '-  Pick up &amp; introducing how to ride on the bike from our English speaking drivers &amp; tour guides.\r\n\r\n \r\n\r\n- Explore around French Colonial sights in Saigon, including Opera House, Presidential Palace, the Notre Dame Cathedral, and the Central Post Office, a bit of History and Culture of Saigon City.\r\n\r\n \r\n\r\n- Discover the Southern culture of Vietnam through the temples &amp; pagodas have insisted inside Saigon hundreds years ago.\r\n\r\n \r\n\r\n- Experience the daily life of Saigonese through a local market to know what is like. This is not a tourist destination or any guide books and it is the unseen Saigon experience.\r\n\r\n \r\n\r\n- Exciting Saigon by going to China-town, the biggest area of Chinese in Saigon city.', 'english', 'Motorbike', '3', 'experience', 'Saigon city', 0, 40, '08:00:00', '2015-01-01 00:00:00', '2018-01-01 00:00:00', '1.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
