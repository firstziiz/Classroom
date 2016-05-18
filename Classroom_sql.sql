-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: May 18, 2016 at 04:53 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Classroom`
--
CREATE DATABASE IF NOT EXISTS `Classroom` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `Classroom`;

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person` (
  `id` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`id`, `user`, `pass`, `name`, `position`) VALUES
(12, 'umaporn', 'umaporn', 'Dr.Umaporn', 'TEACHER'),
(13, 'olarn', 'olarn', 'Dr.Olarn', 'TEACHER'),
(14, 'sumet', 'sumet', 'Dr.Sumet', 'TEACHER'),
(15, 'tony', 'tony', 'Mr.Tony', 'TEACHER'),
(16, '581001', '581001', 'Tom Allen', 'STUDENT'),
(17, '581002', '581002', 'Jerry Insert', 'STUDENT'),
(18, '581003', '581003', 'Sofia Coppola', 'STUDENT'),
(19, '581004', '581004', 'Ball Loon', 'STUDENT'),
(20, '581005', '581005', 'Black Panther', 'STUDENT'),
(21, '581006', '581006', 'JuneJune Poonpiriya', 'STUDENT'),
(22, '581007', '581007', 'Scarlet Witch', 'STUDENT'),
(23, '581008', '581008', 'Chan Tavat', 'STUDENT'),
(24, '581009', '581009', 'Pome Weerapat', 'STUDENT'),
(25, '581010', '581010', 'Oh Tawatchai', 'STUDENT'),
(26, '581011', '581011', 'Bam Nich', 'STUDENT'),
(27, '581012', '581012', 'Myy Funjorb', 'STUDENT'),
(28, '581013', '581013', 'Mac Ker', 'STUDENT'),
(29, '581014', '581014', 'Tar Brazil', 'STUDENT'),
(30, '581015', '581015', 'Dargon Slayer', 'STUDENT'),
(31, '581016', '581016', 'John Lennon', 'STUDENT'),
(32, '581017', '581017', 'Vision Impossible', 'STUDENT'),
(33, '581018', '581018', 'Jarvis Friday', 'STUDENT'),
(34, '581019', '581019', 'Veronica Hastarabista', 'STUDENT'),
(35, '581020', '581020', 'Ron Renger', 'STUDENT'),
(36, '581021', '581021', 'Koda Takechi', 'STUDENT'),
(37, '581022', '581022', 'Nobi Nobita', 'STUDENT'),
(38, '581023', '581023', 'Rupas Grant', 'STUDENT'),
(39, '581024', '581024', 'Lupin Thethird', 'STUDENT'),
(40, '581025', '581025', 'Conan Thawisan', 'STUDENT'),
(41, '581026', '581026', 'Jean Awy', 'STUDENT'),
(42, '581027', '581027', 'Khajohn Klin', 'STUDENT'),
(43, '581028', '581028', 'Rose Wise', 'STUDENT'),
(44, '581029', '581029', 'Jack Dawson', 'STUDENT'),
(45, '581030', '581030', 'Bell Kemisara', 'STUDENT');

-- --------------------------------------------------------

--
-- Table structure for table `Work`
--

DROP TABLE IF EXISTS `Work`;
CREATE TABLE `Work` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `status` int(1) NOT NULL,
  `score` int(11) NOT NULL,
  `tch` int(11) NOT NULL,
  `std` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Work`
--

INSERT INTO `Work` (`id`, `name`, `description`, `answer`, `status`, `score`, `tch`, `std`, `path`) VALUES
(3, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 16, NULL),
(4, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 17, NULL),
(5, 'INT105 Java Collection  ', 'Describe about Java Collection.', 'dsfsdfpsdfkpsg', 1, 0, 12, 18, NULL),
(6, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 19, NULL),
(7, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 20, NULL),
(8, 'INT105 Java Collection  ', 'Describe about Java Collection.', 'Hi I''m Java Students . Oh yeah', 1, 0, 12, 21, NULL),
(9, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 22, NULL),
(10, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 23, NULL),
(11, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 24, NULL),
(12, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 25, NULL),
(13, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 26, NULL),
(14, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 27, NULL),
(15, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 28, NULL),
(16, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 29, NULL),
(17, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 30, NULL),
(18, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 31, NULL),
(19, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 32, NULL),
(20, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 33, NULL),
(21, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 34, NULL),
(22, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 35, NULL),
(23, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 36, NULL),
(24, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 37, NULL),
(25, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 38, NULL),
(26, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 39, NULL),
(27, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 40, NULL),
(28, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 41, NULL),
(29, 'INT105 Java Collection  ', 'Describe about Java Collection.', 'joeijdfiikfhjvcilj;p/hgi', 1, 0, 12, 42, NULL),
(30, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 43, NULL),
(31, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 44, NULL),
(32, 'INT105 Java Collection  ', 'Describe about Java Collection.', '', 0, 0, 12, 45, NULL),
(33, 'Webtech Project', 'description your project', 'ofodgmkfdmbkdmbkdnkbndvxkvjoxkzncuhsduci', 1, 0, 14, 16, NULL),
(34, 'Webtech Project', 'description your project', '', 0, 0, 14, 17, NULL),
(35, 'Webtech Project', 'description your project', 'dsfofkkdsmfshgj/sgko;sjf;lk', 1, 0, 14, 18, NULL),
(36, 'Webtech Project', 'description your project', '', 0, 0, 14, 19, NULL),
(37, 'Webtech Project', 'description your project', 'eieieieieiei', 1, 0, 14, 20, NULL),
(38, 'Webtech Project', 'description your project', '', 0, 0, 14, 21, NULL),
(39, 'Webtech Project', 'description your project', '', 0, 0, 14, 22, NULL),
(40, 'Webtech Project', 'description your project', '', 0, 0, 14, 23, NULL),
(41, 'Webtech Project', 'description your project', '', 0, 0, 14, 24, NULL),
(42, 'Webtech Project', 'description your project', '', 0, 0, 14, 25, NULL),
(43, 'Webtech Project', 'description your project', '', 0, 0, 14, 26, NULL),
(44, 'Webtech Project', 'description your project', '', 0, 0, 14, 27, NULL),
(45, 'Webtech Project', 'description your project', '', 0, 0, 14, 28, NULL),
(46, 'Webtech Project', 'description your project', '', 0, 0, 14, 29, NULL),
(47, 'Webtech Project', 'description your project', '', 0, 0, 14, 30, NULL),
(48, 'Webtech Project', 'description your project', '', 0, 0, 14, 31, NULL),
(49, 'Webtech Project', 'description your project', '', 0, 0, 14, 32, NULL),
(50, 'Webtech Project', 'description your project', '', 0, 0, 14, 33, NULL),
(51, 'Webtech Project', 'description your project', '', 0, 0, 14, 34, NULL),
(52, 'Webtech Project', 'description your project', '', 0, 0, 14, 35, NULL),
(53, 'Webtech Project', 'description your project', '', 0, 0, 14, 36, NULL),
(54, 'Webtech Project', 'description your project', '', 0, 0, 14, 37, NULL),
(55, 'Webtech Project', 'description your project', '', 0, 0, 14, 38, NULL),
(56, 'Webtech Project', 'description your project', '', 0, 0, 14, 39, NULL),
(57, 'Webtech Project', 'description your project', '', 0, 0, 14, 40, NULL),
(58, 'Webtech Project', 'description your project', '', 0, 0, 14, 41, NULL),
(59, 'Webtech Project', 'description your project', '', 0, 0, 14, 42, NULL),
(60, 'Webtech Project', 'description your project', '', 0, 0, 14, 43, NULL),
(61, 'Webtech Project', 'description your project', '', 0, 0, 14, 44, NULL),
(62, 'Webtech Project', 'description your project', '', 0, 0, 14, 45, NULL),
(63, 'Platform Lab ll', 'create your google appengine ', 'sdfknlfmssgmcv,lvf', 1, 0, 13, 16, NULL),
(64, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 17, NULL),
(65, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 18, NULL),
(66, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 19, NULL),
(67, 'Platform Lab ll', 'create your google appengine ', 'abcdefghijklmnop', 1, 0, 13, 20, NULL),
(68, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 21, NULL),
(69, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 22, NULL),
(70, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 23, NULL),
(71, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 24, NULL),
(72, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 25, NULL),
(73, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 26, NULL),
(74, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 27, NULL),
(75, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 28, NULL),
(76, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 29, NULL),
(77, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 30, NULL),
(78, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 31, NULL),
(79, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 32, NULL),
(80, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 33, NULL),
(81, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 34, NULL),
(82, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 35, NULL),
(83, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 36, NULL),
(84, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 37, NULL),
(85, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 38, NULL),
(86, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 39, NULL),
(87, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 40, NULL),
(88, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 41, NULL),
(89, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 42, NULL),
(90, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 43, NULL),
(91, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 44, NULL),
(92, 'Platform Lab ll', 'create your google appengine ', '', 0, 0, 13, 45, NULL),
(123, 'English week4', 'toy project', '', 0, 0, 15, 16, NULL),
(124, 'English week4', 'toy project', '', 0, 0, 15, 17, NULL),
(125, 'English week4', 'toy project', '', 0, 0, 15, 18, NULL),
(126, 'English week4', 'toy project', 'Babie ', 1, 0, 15, 19, NULL),
(127, 'English week4', 'toy project', 'Pin ball', 1, 0, 15, 20, NULL),
(128, 'English week4', 'toy project', '', 0, 0, 15, 21, NULL),
(129, 'English week4', 'toy project', '', 0, 0, 15, 22, NULL),
(130, 'English week4', 'toy project', '', 0, 0, 15, 23, NULL),
(131, 'English week4', 'toy project', '', 0, 0, 15, 24, NULL),
(132, 'English week4', 'toy project', '', 0, 0, 15, 25, NULL),
(133, 'English week4', 'toy project', '', 0, 0, 15, 26, NULL),
(134, 'English week4', 'toy project', '', 0, 0, 15, 27, NULL),
(135, 'English week4', 'toy project', '', 0, 0, 15, 28, NULL),
(136, 'English week4', 'toy project', '', 0, 0, 15, 29, NULL),
(137, 'English week4', 'toy project', '', 0, 0, 15, 30, NULL),
(138, 'English week4', 'toy project', '', 0, 0, 15, 31, NULL),
(139, 'English week4', 'toy project', '', 0, 0, 15, 32, NULL),
(140, 'English week4', 'toy project', '', 0, 0, 15, 33, NULL),
(141, 'English week4', 'toy project', '', 0, 0, 15, 34, NULL),
(142, 'English week4', 'toy project', '', 0, 0, 15, 35, NULL),
(143, 'English week4', 'toy project', '', 0, 0, 15, 36, NULL),
(144, 'English week4', 'toy project', '', 0, 0, 15, 37, NULL),
(145, 'English week4', 'toy project', '', 0, 0, 15, 38, NULL),
(146, 'English week4', 'toy project', '', 0, 0, 15, 39, NULL),
(147, 'English week4', 'toy project', '', 0, 0, 15, 40, NULL),
(148, 'English week4', 'toy project', '', 0, 0, 15, 41, NULL),
(149, 'English week4', 'toy project', '', 0, 0, 15, 42, NULL),
(150, 'English week4', 'toy project', '', 0, 0, 15, 43, NULL),
(151, 'English week4', 'toy project', '', 0, 0, 15, 44, NULL),
(152, 'English week4', 'toy project', '', 0, 0, 15, 45, NULL),
(153, 'English week7', 'interview tourist', '', 0, 0, 15, 16, NULL),
(154, 'English week7', 'interview tourist', 'sdfkpsfkwlmvkn cmxvdfb', 1, 0, 15, 17, NULL),
(155, 'English week7', 'interview tourist', '', 0, 0, 15, 18, NULL),
(156, 'English week7', 'interview tourist', '', 0, 0, 15, 19, NULL),
(157, 'English week7', 'interview tourist', 'VDIO', 1, 0, 15, 20, NULL),
(158, 'English week7', 'interview tourist', '', 0, 0, 15, 21, NULL),
(159, 'English week7', 'interview tourist', '', 0, 0, 15, 22, NULL),
(160, 'English week7', 'interview tourist', '', 0, 0, 15, 23, NULL),
(161, 'English week7', 'interview tourist', '', 0, 0, 15, 24, NULL),
(162, 'English week7', 'interview tourist', '', 0, 0, 15, 25, NULL),
(163, 'English week7', 'interview tourist', '', 0, 0, 15, 26, NULL),
(164, 'English week7', 'interview tourist', '', 0, 0, 15, 27, NULL),
(165, 'English week7', 'interview tourist', '', 0, 0, 15, 28, NULL),
(166, 'English week7', 'interview tourist', '', 0, 0, 15, 29, NULL),
(167, 'English week7', 'interview tourist', '', 0, 0, 15, 30, NULL),
(168, 'English week7', 'interview tourist', '', 0, 0, 15, 31, NULL),
(169, 'English week7', 'interview tourist', '', 0, 0, 15, 32, NULL),
(170, 'English week7', 'interview tourist', '', 0, 0, 15, 33, NULL),
(171, 'English week7', 'interview tourist', '', 0, 0, 15, 34, NULL),
(172, 'English week7', 'interview tourist', '', 0, 0, 15, 35, NULL),
(173, 'English week7', 'interview tourist', '', 0, 0, 15, 36, NULL),
(174, 'English week7', 'interview tourist', '', 0, 0, 15, 37, NULL),
(175, 'English week7', 'interview tourist', '', 0, 0, 15, 38, NULL),
(176, 'English week7', 'interview tourist', '', 0, 0, 15, 39, NULL),
(177, 'English week7', 'interview tourist', '', 0, 0, 15, 40, NULL),
(178, 'English week7', 'interview tourist', '', 0, 0, 15, 41, NULL),
(179, 'English week7', 'interview tourist', '', 0, 0, 15, 42, NULL),
(180, 'English week7', 'interview tourist', '', 0, 0, 15, 43, NULL),
(181, 'English week7', 'interview tourist', '', 0, 0, 15, 44, NULL),
(182, 'English week7', 'interview tourist', '', 0, 0, 15, 45, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Person`
--
ALTER TABLE `Person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Work`
--
ALTER TABLE `Work`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Person`
--
ALTER TABLE `Person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `Work`
--
ALTER TABLE `Work`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=183;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
