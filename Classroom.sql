-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: May 05, 2016 at 01:01 PM
-- Server version: 5.5.42
-- PHP Version: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Classroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `ListWork`
--

CREATE TABLE `ListWork` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

CREATE TABLE `Person` (
  `id` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`id`, `user`, `pass`, `name`, `position`) VALUES
(1, 'student', 'student', 'Student', 'STUDENT'),
(2, 'teacher', 'teacher', 'Teacher', 'TEACHER'),
(3, 'student1', 'student1', 'student1', 'STUDENT'),
(5, 'student2', 'student2', 'student2', 'STUDENT'),
(6, 'student3', 'student3', 'student3', 'STUDENT'),
(7, 'st', 'st', 'Kanisorn', 'STUDENT');

-- --------------------------------------------------------

--
-- Table structure for table `Work`
--

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Work`
--

INSERT INTO `Work` (`id`, `name`, `description`, `answer`, `status`, `score`, `tch`, `std`, `path`) VALUES
(2, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', 'sadfasdgasdfafg', 1, 0, 2, 3, NULL),
(3, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', '', 0, 0, 2, 5, NULL),
(4, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', '', 0, 0, 2, 6, NULL),
(5, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', 'abcdefghijklmnopqrstuvwsyz', 1, 0, 2, 1, NULL),
(6, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', 'asdfasgsadfasdg', 1, 0, 2, 3, NULL),
(7, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', '', 0, 0, 2, 5, NULL),
(8, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', '', 0, 0, 2, 6, NULL),
(9, '[INT105] REPORT 3 ', ' Lorem Ipsum ....  nothing', 'asdfasfadafdsfdasf', 2, 10, 2, 1, NULL),
(10, '[INT105] REPORT 3 ', ' Lorem Ipsum ....  nothing', '', 0, 0, 2, 3, NULL),
(11, '[INT105] REPORT 3 ', ' Lorem Ipsum ....  nothing', '', 0, 0, 2, 5, NULL),
(12, '[INT105] REPORT 3 ', ' Lorem Ipsum ....  nothing', '', 0, 0, 2, 6, NULL),
(13, '[INT105] REPORT 3 ', ' Lorem Ipsum ....  nothing', '', 0, 0, 2, 7, NULL),
(14, 'a', 'a', '', 0, 0, 2, 1, NULL),
(15, 'a', 'a', '', 0, 0, 2, 3, NULL),
(16, 'a', 'a', '', 0, 0, 2, 5, NULL),
(17, 'a', 'a', '', 0, 0, 2, 6, NULL),
(18, 'a', 'a', '', 0, 0, 2, 7, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ListWork`
--
ALTER TABLE `ListWork`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `ListWork`
--
ALTER TABLE `ListWork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Person`
--
ALTER TABLE `Person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `Work`
--
ALTER TABLE `Work`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
