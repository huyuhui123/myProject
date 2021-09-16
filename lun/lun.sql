/*
Navicat MySQL Data Transfer

Source Server         : JSP
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : lun

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-09-16 16:00:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lun
-- ----------------------------
DROP TABLE IF EXISTS `lun`;
CREATE TABLE `lun` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `u_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
