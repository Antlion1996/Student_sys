/*
Navicat MySQL Data Transfer

Source Server         : aaaa
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : studentdb

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2015-09-28 16:57:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '超级管理员');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Id` int(11) NOT NULL,
  `name` varchar(20) default NULL,
  `teacher_id` int(11) default NULL,
  PRIMARY KEY  (`Id`),
  KEY `teacher_course` (`teacher_id`),
  CONSTRAINT `teacher_course` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '面向对象程序设计', '201');
INSERT INTO `course` VALUES ('2', '软件项目管理', '202');
INSERT INTO `course` VALUES ('3', '基于ssh框架项目开发', '203');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `course_id` int(11) default NULL,
  `score` double(6,1) default NULL,
  PRIMARY KEY  (`Id`),
  KEY `stu_score` (`student_id`),
  KEY `course_score` (`course_id`),
  CONSTRAINT `course_score` FOREIGN KEY (`course_id`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_score` FOREIGN KEY (`student_id`) REFERENCES `student` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '101', '1', '100.0');
INSERT INTO `score` VALUES ('2', '102', '1', '99.0');
INSERT INTO `score` VALUES ('4', '101', '3', '222.0');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Id` int(11) NOT NULL,
  `name` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `sex` int(20) default NULL,
  `clazz` varchar(20) default NULL,
  `birthday` varchar(20) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('101', '林大雷', '1111', '1', '13软件2', '1996-03-24');
INSERT INTO `student` VALUES ('102', '萧炎亮', '0000', '0', '13软件1', '1995-08-01');
INSERT INTO `student` VALUES ('103', '叶凡凯', '0000', '1', '13软件1', '1994-01-23');
INSERT INTO `student` VALUES ('104', '李牧尘', '1111', '0', '13软件1', '1997-12-05');
INSERT INTO `student` VALUES ('105', '刘红枫', '0000', '1', '13软件2', '1995-11-15');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Id` int(11) NOT NULL,
  `name` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `sex` int(11) default NULL,
  `birthday` varchar(20) default NULL,
  `course_id` int(11) default NULL,
  `professional` varchar(20) default NULL,
  PRIMARY KEY  (`Id`),
  KEY `course_teacher` (`course_id`),
  CONSTRAINT `course_teacher` FOREIGN KEY (`course_id`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('201', '李青山', '0000', '1', '1965-01-01', '1', '教授');
INSERT INTO `teacher` VALUES ('202', '唐嫣然', '0000', '1', '1968-01-01', '2', '教授');
INSERT INTO `teacher` VALUES ('203', '萧玄茂', '0000', '1', '1978-01-01', '3', '高级教师');
