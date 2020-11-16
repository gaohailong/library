/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-09-16 22:14:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bid` varchar(30) NOT NULL,
  `bookname` varchar(50) NOT NULL,
  `writer` varchar(50) NOT NULL,
  `publication` varchar(50) NOT NULL,
  `isborrowed` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1-1', '数据结构', '严蔚敏', '清华出版社', '1');
INSERT INTO `books` VALUES ('1-2', '数据结构', '严蔚敏', '清华出版社', '0');
INSERT INTO `books` VALUES ('1-3', '数据结构', '严蔚敏', '清华出版社', '0');
INSERT INTO `books` VALUES ('4-2', '操作系统', '王大仙', '机械工业出版社', '1');

-- ----------------------------
-- Table structure for borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `borrowinfo`;
CREATE TABLE `borrowinfo` (
  `uid` varchar(30) NOT NULL,
  `bid` varchar(30) NOT NULL,
  `borrowtime` varchar(50) DEFAULT NULL,
  `returntime` varchar(50) DEFAULT NULL,
  `ishistory` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`bid`),
  KEY `foreign_bid` (`bid`),
  CONSTRAINT `foreign_bid` FOREIGN KEY (`bid`) REFERENCES `books` (`bid`),
  CONSTRAINT `foreign_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowinfo
-- ----------------------------
INSERT INTO `borrowinfo` VALUES ('student', '1-1', '2019-09-16 22:11:43', '', '0');
INSERT INTO `borrowinfo` VALUES ('student', '4-2', '2019-09-16 22:11:56', '', '-1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', 'admin', '13798630976', '2');
INSERT INTO `user` VALUES ('student', 'student', 'student', '18732509218', '0');
INSERT INTO `user` VALUES ('worker', 'worker', 'worker', '18790823424', '1');
