-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Mar 24, 2016 at 01:07 PM
-- Server version: 5.5.42
-- PHP Version: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Classroom`
--
CREATE DATABASE IF NOT EXISTS `Classroom` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`id`, `user`, `pass`, `name`, `position`) VALUES
(1, 'student', 'student', 'Student', 'STUDENT'),
(2, 'teacher', 'teacher', 'Teacher', 'TEACHER'),
(3, 'student1', 'student1', 'student1', 'STUDENT'),
(5, 'student2', 'student2', 'student2', 'STUDENT'),
(6, 'student3', 'student3', 'student3', 'STUDENT');

-- --------------------------------------------------------

--
-- Table structure for table `Work`
--

DROP TABLE IF EXISTS `Work`;
CREATE TABLE `Work` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` int(1) NOT NULL,
  `point` int(11) NOT NULL,
  `tch` int(11) NOT NULL,
  `std` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Work`
--

INSERT INTO `Work` (`id`, `name`, `description`, `status`, `point`, `tch`, `std`, `path`) VALUES
(1, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', 0, 0, 2, 1, NULL),
(2, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', 0, 0, 2, 3, NULL),
(3, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', 0, 0, 2, 5, NULL),
(4, '[INT105] REPORT 1 ', ' Lorem Ipsum .... ', 0, 0, 2, 6, NULL),
(5, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', 0, 0, 2, 1, NULL),
(6, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', 0, 0, 2, 3, NULL),
(7, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', 0, 0, 2, 5, NULL),
(8, '[INT105] REPORT 2 ', ' Lorem Ipsum .... ', 0, 0, 2, 6, NULL);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `Work`
--
ALTER TABLE `Work`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
