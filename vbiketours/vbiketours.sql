-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2015 at 03:25 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `country`, `first_name`, `last_name`, `address_1`, `address_2`, `city`, `state`, `post_code`, `email`, `phone`, `pickup_location`, `additional_infos`) VALUES
(1, 'VN', 'sdg', 'sdgwb', 'jsdgjfdgj', 'gjfxgjfxj', 'sgd', 'wxcbxcvnvcx', 12345, 'jfcc', 'rdj', 'cjk', 'cgk'),
(2, 'VN', 'sdg', 'dhssdh', 'wsdbwdb', 'wxbvwcb', 'wvncvxcbwxb', 'wxcbxcvnvcx', 12345, 'fgjdghdj@shsh', 'hfjdgk', 'fh', 'wb'),
(3, 'VN', 'sdg', 'dhssdh', 'wsdbwdb', 'wxbvwcb', 'wvncvxcbwxb', 'wxcbxcvnvcx', 12345, 'fgjdghdj@shsh', 'hfjdgk', 'fh', 'wb'),
(4, 'VN', '', '', '', '', '', '', 12345, 'hj@jhk', '0123456789', '', ''),
(5, 'VN', '', '', '', '', '', '', 0, 'fgjdghdj@shsh.com', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) unsigned NOT NULL,
  `payment_type` tinyint(1) NOT NULL,
  `cart` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
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
  `validity_start` date NOT NULL,
  `validity_end` date NOT NULL,
  `picture` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`id`, `name`, `summary`, `description`, `fitness`, `vehicle`, `duration`, `style`, `route`, `nb_passenger_max`, `price`, `start_time`, `validity_start`, `validity_end`, `picture`) VALUES
(1, 'Saigon Sightseeing Tours', 'Experience French Architecture Sights and The  Vietnamese Daily life in Saigon.', '-  Pick up &amp; introducing how to ride on the bike from our English speaking drivers &amp; tour guides.\n\n \n\n- Explore around French Colonial sights in Saigon, including Opera House, Presidential Palace, the Notre Dame Cathedral, and the Central Post Office, a bit of History and Culture of Saigon City.\n\n \n\n- Discover the Southern culture of Vietnam through the temples &amp; pagodas have insisted inside Saigon hundreds years ago.\n\n \n\n- Experience the daily life of Saigonese through a local market to know what is like. This is not a tourist destination or any guide books and it is the unseen Saigon experience.\n\n \n\n- Exciting Saigon by going to China-town, the biggest area of Chinese in Saigon city.', 'English', 'Motorbike', '3 Hours', 'Experience', 'Saigon city', 0, 40, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(2, 'Saigon City Tours', 'Discover unseen through History, Architecture, Human and Culture of Saigon City on Motobikes.', '- During our first stop we will speaking about itinerary for the day &amp; a bit of history of Saigon City.\n\n \n\n- Explore some French Colonial sights in Saigon, including Opera House, Presidential Palace, the Notre Dame Cathedral, the Central Post Office.\n\n \n\n- Discover the culture Southern of Vietnam through the temples &amp; pagodas have insisted inside Saigon hundreds year ago.\n\n \n\n- Experience the daily life of Saigonese through a local market to know what is like. This isn’t a tourist destination or any guide books and it is the unseen Saigon experience.\n\n \n\n- We have lunch with special Vietnamese foods.', 'English', 'Motorbike', '4.5 Hours', 'Experience', 'Saigon City', 0, 48, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(3, 'Saigon Foodie Tours', 'Tasting Vietnam traditional dishes and various speacial street foods in Saigon City.', '- Pick up and introducing how to ride on the bike from our English speaking drivers and tour guides.\r\n\r\n \r\n\r\n- Tasty traditional Vietnamese dishes inside Saigon, as well as delicious foods of the Northern, Middle and Southern in Vietnam.\r\n\r\n \r\n\r\n- Discover delicious Vietnamese dishes throughout various locations in Saigon we stop for enjoying on the way of motorbike tours. These are not tourist destinations or any guide book you have ever read or tasted.\r\n\r\n \r\n\r\n- Experience with special Vietnamese foods around Saigon city that the tourists have never had a chance to experience before.', 'English', 'Motorbike', '4.5 Hours', 'Experience', 'Saigon City', 0, 66, '13:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(4, 'Family Cooking Tours', 'Experience short training how to cook Vietnam traditional dishes in a family of Saigon City...', '- Our English speaking cooking guide will pick up you from your Hotel and bring you to the local market in Saigon where you can see how Vietnamese people trade with goods and foodstuffs. You will choose the dishes you want to cook from our menu of traditional Vietnamese food and we buy the ingredients for the dishes you was chosen. \r\n\r\n \r\n\r\n- After buying the foodstuffs we’ll go to our family cooking house to wash and prepare the ingredients. Our cooking guide will telling and describes you the way how to cook the delectable Vietnamese dishes. Your palate will explores the taste of dishes you''ve selected from the menu, of the northern, middle and southern regions of Vietnam. You can take the &quot;wooden spoon&quot; in your hand and find out how to cook Vietnamese food, our cooking guide will support and explain you the way to cook.\r\n\r\n \r\n\r\n- Let’s indulge your senses when you enjoy the delicious self cooked meals, the extraordinary, culinary delights &quot;alla Vietnam&quot;.\r\n\r\n \r\n\r\n- At the end the English speaking drivers will bring you back to the Hotel.\r\n \r\n\r\n- Tasty traditional Vietnamese dishes inside Saigon, as well as delicious foods of the Northern, Middle and Southern in Vietnam.\r\n\r\n \r\n\r\n- Discover delicious Vietnamese dishes throughout various locations in Saigon we stop for enjoying on the way of motorbike tours. These are not tourist destinations or any guide book you have ever read or tasted.\r\n\r\n \r\n\r\n- Experience with special Vietnamese foods around Saigon city that the tourists have never had a chance to experience before.', 'English', 'Motorbike', '4.5 Hours', 'Experience', 'Saigon City', 0, 66, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(5, 'Cu Chi Tunnel Tours', 'Discover 200km network battleground Cuchi Tunnels, fresh vegetables garden and wild life animal farm.', '- Explore fresh Vegetables Garden at countryside on the way we go Cu Chi tunnels by motorbike and visiting the handicraft factory.\n\n \n\n- Discover the battleground Cu Chi tunnels which the secret of 200km network of underground tunnels that we dug–outs were being used as kitchens, hospitals, water wells, weapon factory… during the Vietnam–USA war. We can also try shooting with many kinds of weapons (pay the bullets) if we want.\n\n \n\n- Experience the daily life of the peoples through visiting the village at Cu Chi to know what is like now after the finished war nearly 40 years. This is not a tourist destination or any guide book you have heard and read.\n\n \n\n- We have lunch with kindly Vietnamese farmers.', 'English', 'Motorbike', '9 Hours', 'Exploration', 'Saigon to Cuchi Tunnels', 0, 118, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(6, 'Mekong Delta Tours', 'Explore Mekong Delta with free felling on Motorbikes.', '- From Saigon city we go to My Tho - Ben Tre province and Cai Be floating market by motorbikes.\r\n\r\n \r\n\r\n- Visiting the Vinh Trang pagoda which is well known for its special architecture and ancien in My Tho.\r\n\r\n \r\n\r\n- Take local boat go along Tien River for the sightseeing of fishing port, stift house, boat building workshop. Seeing Dragon, Unicorn, Phoenix and Turtle Islands which are named with holy animals in Vietnamese Culture and enjoy the tropical fruits in garden and try honey tea for free and listen to Vietnamese traditioning music in Ben Tre.\r\n\r\n \r\n\r\n- Experience of making coconut candy by skillful craftsmen, enjoy your lunch at local restaurant. \r\n\r\n \r\n\r\n- We go to Cai Be floating market and stay at the homestay one night and have dinner with warming local family.\r\n\r\n \r\n\r\n- Explore Cai Be floating market in the morning and to experience the real life of locals by motobikes.\r\n\r\n \r\n\r\n- We go back to Saigon city by motorbikes after unforgettable adventure in Mekong Delta.', 'English', 'Motorbike', '2 Days 1 Night', 'Exploration', 'Saigon to Mekong Delta', 0, 268, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(7, 'Private Tours', 'Create your own tour.', '- When you come to the big city like Saigon for traveling, and you would like to go somewhere to check out something what you are interested in, for example shopping, eating, spa, bars, beer clubs or something else, ...then you will understand more deeply about the custom of Vietnam throughout the daily life of people inside Saigon.\r\n\r\n \r\n\r\n- The “Private Tour by motorbike” offers you the best and personalized experience in the daily growing city Saigon.  \r\n\r\n \r\n\r\n- We''ll also help you when shopping by consulting and bargaining with the vendors to get what you want with the best price and the best quality.\r\n\r\n \r\n\r\n- We can take you around to discover the places which never have described in any guide books.\r\n\r\n \r\n\r\n- Let us show you the “Real Saigon” is changing every day.', 'English', 'Motorbike', 'your choice', 'Personalised', 'your choice', 0, 0, '08:00:00', '2015-01-01', '2018-01-01', '1.jpg'),
(8, 'Discover Phan Thiet, Mui Ne On Motorbike, Motorcross Tours', '', '', '', 'Motorbike, Motocross', '', '', '', 0, 300, '00:00:00', '2015-01-01', '2018-01-01', '1.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
