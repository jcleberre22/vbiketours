-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 09 Avril 2015 à 09:46
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `vbiketours`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `country` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `address_1` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `address_2` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `state` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `post_code` int(11) NOT NULL,
  `email` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pickup_location` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `additional_infos` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=64 ;

--
-- Contenu de la table `customer`
--

INSERT INTO `customer` (`id`, `country`, `first_name`, `last_name`, `address_1`, `address_2`, `city`, `state`, `post_code`, `email`, `phone`, `pickup_location`, `additional_infos`) VALUES
(1, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(2, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(3, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(4, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(5, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(6, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(7, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(8, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(9, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(10, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(11, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(12, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(13, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(14, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(15, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(16, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(17, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(18, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(19, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(20, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(21, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(22, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(23, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(24, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(25, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(26, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(27, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(28, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(29, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(30, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(31, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(32, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(33, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(34, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(35, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', ''),
(36, 'VN', 'drsh', 'sdgwb', 'jsdgjfdgj', 'gjfxgjfxj', 'sgd', 'hcjgdkh', 12345, 'fgjdghdj@shsh.com', '12345', ',j,hgb', ''),
(37, 'VN', 'drsh', 'sdg', 'wsdbwdb', 'wxbvwcb', 'sgd', 'hcjgdkh', 12345, 'fgjdghdj@shsh.com', '12345', 'ste', ''),
(38, 'VN', 'drsh', 'sdg', 'jsdgjfdgj', 'jhdshsge', 'wvncvxcbwxb', 'wxcbxcvnvcx', 12345, 'fgjdghdj@df', 'hfjdgk', 'dhgf', ''),
(39, 'VN', 'drsh', 'sdg', 'jsdgjfdgj', 'jhdshsge', 'wvncvxcbwxb', 'wxcbxcvnvcx', 12345, 'fgjdghdj@df', 'hfjdgk', 'dhgf', ''),
(40, 'VN', 'drsh', 'sdg', 'jsdgjfdgj', 'jhdshsge', 'wvncvxcbwxb', 'wxcbxcvnvcx', 12345, 'fgjdghdj@df', 'hfjdgk', 'dhgf', ''),
(41, 'VN', 'sdg', 'dhssdh', 'jsdgjfdgj', '', 'sgd', '1245', 12345, 'fgjdghdj@shsh.com', '12345', 'gjk', ''),
(42, 'VN', 'sdg', 'dhssdh', 'jsdgjfdgj', '', 'sgd', 'hcjgdkh', 7, 'fgjdghdj@shsh.com', '12345', 'sdfg', ''),
(43, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'gjfxgjfxj', 'wvncvxcbwxb', 'wxcbxcvnvcx', 12345, 'fgjdghdj@shsh.com', '0212145', 'hgjg', ''),
(44, 'VN', 'drsh', 'sdgwb', 'wsdbwdb', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 12345, 'fgjdghdj@shsh.com', '12345', 'hgfhk', ''),
(45, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 2, 'fgjdghdj@shsh.com', '12345', 'tufik', ''),
(46, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'sfg', ''),
(47, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'erg', ''),
(48, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'sdgs', ''),
(49, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'sdg', ''),
(50, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'sfg', ''),
(51, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 2, 'fgjdghdj@shsh.com', '12345', 'kigsd', ''),
(52, 'VN', 'drsh', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'iyfk', ''),
(53, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'jhf', ''),
(54, 'VN', 'sdg', 'dhssdh', 'luiqehzpijre', '', 'fxgjfjf', 'wxcbxcvnvcx', 12345, 'fgjdghdj@shsh.com', '12345', 'esry', ''),
(55, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 2, 'fgjdghdj@shsh.com', '12345', 'htfjh', ''),
(56, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 3, 'fgjdghdj@shsh.com', '12345', 'jhgi', ''),
(57, 'VN', 'drsh', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'wxcbxcvnvcx', 2, 'fgjdghdj@shsh.com', '12345', 'hgfklil', ''),
(58, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'gjfxgjfxj', 'wvncvxcbwxb', 'hcjgdkh', 2, 'fgjdghdj@shsh.com', '12345', 'jhfj', ''),
(59, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 3, 'fgjdghdj@shsh.com', '12345', 'jhito', ''),
(60, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 3, 'fgjdghdj@shsh.com', '12345', 'jhito', ''),
(61, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 1, 'fgjdghdj@shsh.com', '12345', 'jhyfk', ''),
(62, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'wxbvwcb', 'wvncvxcbwxb', 'hcjgdkh', 3, 'fgjdghdj@shsh.com', '12345', 'jgjk', ''),
(63, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', '', 'wvncvxcbwxb', 'hcjgdkh', 2, 'fgjdghdj@shsh.com', '12345', 'kjgk', '');

-- --------------------------------------------------------

--
-- Structure de la table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cart` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'serialised object',
  `payment_type` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `payment_method` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `payment_succes` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `customer_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=64 ;

--
-- Contenu de la table `order`
--

INSERT INTO `order` (`id`, `cart`, `payment_type`, `payment_method`, `payment_succes`, `customer_id`) VALUES
(1, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:22:"\0Booking\0_nb_childrens";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"1";s:15:"\0Booking\0_price";d:40;}}s:12:"\0Cart\0_price";d:40;}', 'full', 'paypal', '0', 1),
(2, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"3";s:22:"\0Booking\0_nb_childrens";s:1:"2";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:264;}}s:12:"\0Cart\0_price";d:264;}', 'full', 'paypal', '0', 2),
(3, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"3";s:22:"\0Booking\0_nb_childrens";s:1:"2";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:264;}}s:12:"\0Cart\0_price";d:264;}', 'full', 'paypal', '0', 3),
(4, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 4),
(5, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:2:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"1";s:15:"\0Booking\0_price";d:40;}i:1;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:1;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:106;}', 'full', 'paypal', '0', 5),
(6, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 6),
(7, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 7),
(8, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 8),
(9, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 9),
(10, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 10),
(11, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 11),
(12, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 12),
(13, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 13),
(14, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 14),
(15, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 15),
(16, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 16),
(17, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 17),
(18, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 18),
(19, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 19),
(20, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 20),
(21, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 21),
(22, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 22),
(23, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 23),
(24, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 24),
(25, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 25),
(26, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 26),
(27, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 27),
(28, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 28),
(29, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 29),
(30, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 30),
(31, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 31),
(32, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 32),
(33, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 33),
(34, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 34),
(35, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:0:"";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 35),
(36, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:2:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}i:1;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:1;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"5";s:15:"\0Booking\0_price";d:118;}}s:12:"\0Cart\0_price";d:166;}', 'full', 'paypal', '0', 36),
(37, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:2:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}i:1;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:1;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"5";s:15:"\0Booking\0_price";d:118;}}s:12:"\0Cart\0_price";d:166;}', 'cash', 'paypal', '0', 37),
(38, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:2:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}i:1;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:1;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"5";s:15:"\0Booking\0_price";d:118;}}s:12:"\0Cart\0_price";d:166;}', 'cash', 'paypal', '0', 38),
(39, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:2:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}i:1;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:1;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"5";s:15:"\0Booking\0_price";d:118;}}s:12:"\0Cart\0_price";d:166;}', 'cash', 'paypal', '0', 39),
(40, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:2:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}i:1;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:1;s:14:"\0Booking\0_date";s:10:"2015-04-07";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"5";s:15:"\0Booking\0_price";d:118;}}s:12:"\0Cart\0_price";d:166;}', 'cash', 'paypal', '0', 40),
(41, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'cash', 'paypal', '0', 41),
(42, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'cash', 'paypal', '0', 42),
(43, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 43),
(44, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 44),
(45, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 45),
(46, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 46),
(47, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 47),
(48, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 48),
(49, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"5";s:15:"\0Booking\0_price";d:118;}}s:12:"\0Cart\0_price";d:118;}', 'full', 'paypal', '0', 49),
(50, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 50),
(51, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 51),
(52, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 52),
(53, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 53),
(54, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"3";s:15:"\0Booking\0_price";d:66;}}s:12:"\0Cart\0_price";d:66;}', 'full', 'paypal', '0', 54),
(55, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 55),
(56, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 56),
(57, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 57),
(58, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 58),
(59, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 59),
(60, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 60),
(61, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 61),
(62, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 62),
(63, 'O:4:"Cart":2:{s:19:"\0Cart\0_booking_list";a:1:{i:0;O:7:"Booking":6:{s:12:"\0Booking\0_id";i:0;s:14:"\0Booking\0_date";s:10:"2015-04-09";s:19:"\0Booking\0_nb_adults";s:1:"1";s:21:"\0Booking\0_nb_children";s:1:"0";s:17:"\0Booking\0_tour_id";s:1:"2";s:15:"\0Booking\0_price";d:48;}}s:12:"\0Cart\0_price";d:48;}', 'full', 'paypal', '0', 63);

-- --------------------------------------------------------

--
-- Structure de la table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `checkoutstatus` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TIMESTAMP` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DESC` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `AMT` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `PAYMENTREQUESTINFO_0_TRANSACTIONID` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PAYERID` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PAYERSTATUS` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FIRSTNAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `LASTNAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTONAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTOSTREET` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTOCITY` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTOSTATE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTOZIP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTOCOUNTRYNAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SHIPTOCOUNTRYCODE` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `CURRENCYCODE` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `tour`
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
  `validity_start` date NOT NULL,
  `validity_end` date NOT NULL,
  `picture` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Contenu de la table `tour`
--

INSERT INTO `tour` (`id`, `name`, `summary`, `description`, `fitness`, `vehicle`, `duration`, `style`, `route`, `nb_passenger_max`, `price`, `start_time`, `validity_start`, `validity_end`, `picture`) VALUES
(1, 'Saigon Sightseeing Tours', 'Experience French Architecture Sights and The  Vietnamese Daily life in Saigon.', '-  Pick up &amp; introducing how to ride on the bike from our English speaking drivers &amp; tour guides.\n\n \n\n- Explore around French Colonial sights in Saigon, including Opera House, Presidential Palace, the Notre Dame Cathedral, and the Central Post Office, a bit of History and Culture of Saigon City.\n\n \n\n- Discover the Southern culture of Vietnam through the temples &amp; pagodas have insisted inside Saigon hundreds years ago.\n\n \n\n- Experience the daily life of Saigonese through a local market to know what is like. This is not a tourist destination or any guide books and it is the unseen Saigon experience.\n\n \n\n- Exciting Saigon by going to China-town, the biggest area of Chinese in Saigon city.', 'English', 'Motorbike', '3 Hours', 'Experience', 'Saigon city', 0, 40, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(2, 'Saigon City Tours', 'Discover unseen through History, Architecture, Human and Culture of Saigon City on Motobikes.', '- During our first stop we will speaking about itinerary for the day &amp; a bit of history of Saigon City.\n\n \n\n- Explore some French Colonial sights in Saigon, including Opera House, Presidential Palace, the Notre Dame Cathedral, the Central Post Office.\n\n \n\n- Discover the culture Southern of Vietnam through the temples &amp; pagodas have insisted inside Saigon hundreds year ago.\n\n \n\n- Experience the daily life of Saigonese through a local market to know what is like. This isn’t a tourist destination or any guide books and it is the unseen Saigon experience.\n\n \n\n- We have lunch with special Vietnamese foods.', 'English', 'Motorbike', '4.5 Hours', 'Experience', 'Saigon City', 0, 48, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(3, 'Saigon Foodie Tours', 'Tasting Vietnam traditional dishes and various speacial street foods in Saigon City.', '- Pick up and introducing how to ride on the bike from our English speaking drivers and tour guides.\r\n\r\n \r\n\r\n- Tasty traditional Vietnamese dishes inside Saigon, as well as delicious foods of the Northern, Middle and Southern in Vietnam.\r\n\r\n \r\n\r\n- Discover delicious Vietnamese dishes throughout various locations in Saigon we stop for enjoying on the way of motorbike tours. These are not tourist destinations or any guide book you have ever read or tasted.\r\n\r\n \r\n\r\n- Experience with special Vietnamese foods around Saigon city that the tourists have never had a chance to experience before.', 'English', 'Motorbike', '4.5 Hours', 'Experience', 'Saigon City', 0, 66, '13:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(4, 'Family Cooking Tours', 'Experience short training how to cook Vietnam traditional dishes in a family of Saigon City...', '- Our English speaking cooking guide will pick up you from your Hotel and bring you to the local market in Saigon where you can see how Vietnamese people trade with goods and foodstuffs. You will choose the dishes you want to cook from our menu of traditional Vietnamese food and we buy the ingredients for the dishes you was chosen. \r\n\r\n \r\n\r\n- After buying the foodstuffs we’ll go to our family cooking house to wash and prepare the ingredients. Our cooking guide will telling and describes you the way how to cook the delectable Vietnamese dishes. Your palate will explores the taste of dishes you''ve selected from the menu, of the northern, middle and southern regions of Vietnam. You can take the &quot;wooden spoon&quot; in your hand and find out how to cook Vietnamese food, our cooking guide will support and explain you the way to cook.\r\n\r\n \r\n\r\n- Let’s indulge your senses when you enjoy the delicious self cooked meals, the extraordinary, culinary delights &quot;alla Vietnam&quot;.\r\n\r\n \r\n\r\n- At the end the English speaking drivers will bring you back to the Hotel.\r\n \r\n\r\n- Tasty traditional Vietnamese dishes inside Saigon, as well as delicious foods of the Northern, Middle and Southern in Vietnam.\r\n\r\n \r\n\r\n- Discover delicious Vietnamese dishes throughout various locations in Saigon we stop for enjoying on the way of motorbike tours. These are not tourist destinations or any guide book you have ever read or tasted.\r\n\r\n \r\n\r\n- Experience with special Vietnamese foods around Saigon city that the tourists have never had a chance to experience before.', 'English', 'Motorbike', '4.5 Hours', 'Experience', 'Saigon City', 0, 66, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(5, 'Cu Chi Tunnel Tours', 'Discover 200km network battleground Cuchi Tunnels, fresh vegetables garden and wild life animal farm.', '- Explore fresh Vegetables Garden at countryside on the way we go Cu Chi tunnels by motorbike and visiting the handicraft factory.\n\n \n\n- Discover the battleground Cu Chi tunnels which the secret of 200km network of underground tunnels that we dug–outs were being used as kitchens, hospitals, water wells, weapon factory… during the Vietnam–USA war. We can also try shooting with many kinds of weapons (pay the bullets) if we want.\n\n \n\n- Experience the daily life of the peoples through visiting the village at Cu Chi to know what is like now after the finished war nearly 40 years. This is not a tourist destination or any guide book you have heard and read.\n\n \n\n- We have lunch with kindly Vietnamese farmers.', 'English', 'Motorbike', '9 Hours', 'Exploration', 'Saigon to Cuchi Tunnels', 0, 118, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(6, 'Mekong Delta Tours', 'Explore Mekong Delta with free felling on Motorbikes.', '- From Saigon city we go to My Tho - Ben Tre province and Cai Be floating market by motorbikes.\r\n\r\n \r\n\r\n- Visiting the Vinh Trang pagoda which is well known for its special architecture and ancien in My Tho.\r\n\r\n \r\n\r\n- Take local boat go along Tien River for the sightseeing of fishing port, stift house, boat building workshop. Seeing Dragon, Unicorn, Phoenix and Turtle Islands which are named with holy animals in Vietnamese Culture and enjoy the tropical fruits in garden and try honey tea for free and listen to Vietnamese traditioning music in Ben Tre.\r\n\r\n \r\n\r\n- Experience of making coconut candy by skillful craftsmen, enjoy your lunch at local restaurant. \r\n\r\n \r\n\r\n- We go to Cai Be floating market and stay at the homestay one night and have dinner with warming local family.\r\n\r\n \r\n\r\n- Explore Cai Be floating market in the morning and to experience the real life of locals by motobikes.\r\n\r\n \r\n\r\n- We go back to Saigon city by motorbikes after unforgettable adventure in Mekong Delta.', 'English', 'Motorbike', '2 Days 1 Night', 'Exploration', 'Saigon to Mekong Delta', 0, 268, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(7, 'Private Tours', 'Create your own tour.', '- When you come to the big city like Saigon for traveling, and you would like to go somewhere to check out something what you are interested in, for example shopping, eating, spa, bars, beer clubs or something else, ...then you will understand more deeply about the custom of Vietnam throughout the daily life of people inside Saigon.\r\n\r\n \r\n\r\n- The “Private Tour by motorbike” offers you the best and personalized experience in the daily growing city Saigon.  \r\n\r\n \r\n\r\n- We''ll also help you when shopping by consulting and bargaining with the vendors to get what you want with the best price and the best quality.\r\n\r\n \r\n\r\n- We can take you around to discover the places which never have described in any guide books.\r\n\r\n \r\n\r\n- Let us show you the “Real Saigon” is changing every day.', 'English', 'Motorbike', 'your choice', 'Personalised', 'your choice', 0, 0, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(8, 'Discover Phan Thiet, Mui Ne On Motorbike, Motorcross Tours', '', '', 'English', 'Motorbike, Motocross', '', 'Exploration', '', 0, 300, '00:00:00', '2015-01-01', '2018-01-01', '1.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
