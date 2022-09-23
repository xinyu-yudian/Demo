/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - xuanke
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xuanke` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xuanke`;

/*Table structure for table `college` */

DROP TABLE IF EXISTS `college`;

CREATE TABLE `college` (
  `collegeID` int(11) NOT NULL,
  `collegeName` varchar(200) NOT NULL COMMENT '课程名',
  PRIMARY KEY (`collegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `college` */

insert  into `college`(`collegeID`,`collegeName`) values (1,'计算机系'),(2,'设计系'),(3,'财经系');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseID` int(11) NOT NULL,
  `courseName` varchar(200) NOT NULL COMMENT '课程名称',
  `teacherID` int(11) NOT NULL,
  `courseTime` varchar(200) DEFAULT NULL COMMENT '开课时间',
  `classRoom` varchar(200) DEFAULT NULL COMMENT '开课地点',
  `courseWeek` int(200) DEFAULT NULL COMMENT '学时',
  `courseType` varchar(20) DEFAULT NULL COMMENT '课程类型',
  `collegeID` int(11) NOT NULL COMMENT '所属院系',
  `score` int(11) NOT NULL COMMENT '学分',
  `people` int(8) DEFAULT NULL COMMENT '限制人数',
  PRIMARY KEY (`courseID`),
  KEY `collegeID` (`collegeID`),
  KEY `teacherID` (`teacherID`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`),
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`courseID`,`courseName`,`teacherID`,`courseTime`,`classRoom`,`courseWeek`,`courseType`,`collegeID`,`score`,`people`) values (1,'C语言程序设计',1001,'周二','科401',18,'必修课',1,3,8),(2,'Python爬虫技巧',1001,'周四','X402',18,'必修课',1,3,10),(3,'数据结构',1001,'周四','科401',18,'必修课',1,2,10),(4,'Java程序设计',1002,'周五','科401',18,'必修课',1,2,10),(5,'英语',1002,'周四','X302',18,'必修课',2,2,10),(6,'服装设计',1003,'周一','科401',18,'选修课',2,2,10);

/*Table structure for table `coursedate` */

DROP TABLE IF EXISTS `coursedate`;

CREATE TABLE `coursedate` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `starttime` varchar(30) DEFAULT NULL,
  `endtime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `coursedate` */

insert  into `coursedate`(`id`,`starttime`,`endtime`) values (4,'2020-10-02 18:02:15','2020-10-10 18:25:55'),(5,'2020-12-15 17:28:28','2020-12-16 17:28:30'),(6,'2021-04-24','2021-06-01 20:02:41'),(7,'2021-04-24 21:01:21','2021-04-30 21:01:25'),(8,'2021-04-29 21:06:02','2021-06-01 20:02:41'),(9,'2021-04-24 21:40:28','2021-06-01 20:02:41'),(10,'',''),(11,'',''),(12,'',''),(13,'2021-04-26 08:42:28','2021-06-01 20:02:41'),(14,'2021-04-29 21:06:02','2021-06-01 20:02:41'),(15,'2021-04-26 08:43:38','2021-06-01 20:02:41');

/*Table structure for table `dati` */

DROP TABLE IF EXISTS `dati`;

CREATE TABLE `dati` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `stuid` int(11) DEFAULT NULL,
  `zuoyeid` int(11) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `fen` int(11) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  `riqi` varchar(255) DEFAULT NULL,
  `ownedCousrse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `dati` */

insert  into `dati`(`id`,`stuid`,`zuoyeid`,`filename`,`fen`,`bz`,`riqi`,`ownedCousrse`) values (1,10001,1,'12345.jpg',NULL,NULL,'2021-04-02 02:50:39',NULL),(2,10001,1,'22.png',NULL,NULL,'2021-04-02 02:55:03',NULL),(3,10001,1,'修稿.sql',NULL,'周日之前交','2021-04-23 14:35:54',NULL),(4,10001,1,'1730090926-董莹莹-4周周记.docx',NULL,'周日之前交','2021-04-24 11:02:28',NULL),(5,10001,40,'xuanke.sql',NULL,'231213123','2021-04-25 23:17:23',NULL),(6,10001,34,'dyy.txt',NULL,'3213123213','2021-04-25 23:43:55','Python爬虫技巧'),(7,10001,34,'微信图片_20210424111726.jpg',NULL,'3333333','2021-04-26 00:04:59','Python爬虫技巧'),(8,10001,34,'新建文本文档.txt',NULL,'作业','2021-04-26 08:16:48','Python爬虫技巧'),(9,10002,51,'2答辩组-64号-张颖.ppt',NULL,'提交','2021-04-27 08:20:52','数据结构');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleID` int(11) NOT NULL,
  `roleName` varchar(20) NOT NULL,
  `permissions` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleID`,`roleName`,`permissions`) values (0,'admin',NULL),(1,'teacher',NULL),(2,'student',NULL);

/*Table structure for table `selectedcourse` */

DROP TABLE IF EXISTS `selectedcourse`;

CREATE TABLE `selectedcourse` (
  `courseID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `mark` int(11) DEFAULT NULL COMMENT '成绩',
  `coursedate` varchar(50) DEFAULT NULL COMMENT '选课时间',
  KEY `courseID` (`courseID`),
  KEY `studentID` (`studentID`),
  CONSTRAINT `selectedcourse_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`),
  CONSTRAINT `selectedcourse_ibfk_2` FOREIGN KEY (`studentID`) REFERENCES `student` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `selectedcourse` */

insert  into `selectedcourse`(`courseID`,`studentID`,`mark`,`coursedate`) values (1,10001,98,NULL),(1,10003,NULL,'2020-12-02 22:16:20'),(2,10001,NULL,'2021-04-25 01:49:36'),(3,10002,NULL,'2021-04-25 21:41:38');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birthYear` date DEFAULT NULL COMMENT '出生日期',
  `grade` date DEFAULT NULL COMMENT '入学时间',
  `collegeID` int(11) NOT NULL COMMENT '院系id',
  PRIMARY KEY (`userID`),
  KEY `collegeID` (`collegeID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`)
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`userID`,`userName`,`sex`,`birthYear`,`grade`,`collegeID`) values (10001,'黄欣悦','男','1996-09-02','2015-09-02',1),(10002,'米欣','男','1995-09-14','2015-09-02',3),(10003,'陈小陈','男','1996-09-02','2015-09-02',2),(10004,'华晨宇','男','1996-09-02','2015-09-02',2),(10005,'左右','男','1996-09-02','2015-09-02',2),(10006,'小拉','女','1996-09-02','2015-09-02',1);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birthYear` date NOT NULL,
  `degree` varchar(20) DEFAULT NULL COMMENT '学历',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `grade` date DEFAULT NULL COMMENT '入职时间',
  `collegeID` int(11) NOT NULL COMMENT '院系',
  PRIMARY KEY (`userID`),
  KEY `collegeID` (`collegeID`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`userID`,`userName`,`sex`,`birthYear`,`degree`,`title`,`grade`,`collegeID`) values (1001,'刘老师','女','1990-03-08','硕士','副教授','2015-09-02',2),(1002,'张老师','男','1996-09-02','本科','普通教师','2015-09-02',1),(1003,'软老师','男','1996-09-02','硕士','助教','2017-07-07',1);

/*Table structure for table `userlogin` */

DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '2' COMMENT '角色权限',
  PRIMARY KEY (`userID`),
  KEY `role` (`role`),
  CONSTRAINT `userlogin_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `userlogin` */

insert  into `userlogin`(`userID`,`userName`,`password`,`role`) values (1,'admin','123',0),(8,'10001','123',2),(9,'10002','123',2),(10,'10003','123',2),(11,'10005','123',2),(12,'10004','123',2),(13,'10006','123',2),(14,'1001','123',1),(15,'1002','123',1),(16,'1003','123',1);

/*Table structure for table `zuoye` */

DROP TABLE IF EXISTS `zuoye`;

CREATE TABLE `zuoye` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `teaid` int(11) DEFAULT NULL,
  `riqi` varchar(255) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  `ownedCousrse` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `zuoye` */

insert  into `zuoye`(`id`,`filename`,`teaid`,`riqi`,`bz`,`ownedCousrse`,`starttime`,`endtime`) values (29,'123',1001,NULL,'123','C语言程序设计',NULL,NULL),(30,'123',1001,NULL,'123','C语言程序设计',NULL,NULL),(31,'111111',1001,NULL,'1111111','C语言程序设计',NULL,NULL),(32,'123',1001,NULL,'周日之前交','C语言程序设计',NULL,NULL),(33,'111111',1001,NULL,'11111','数据结构',NULL,NULL),(34,'22222',1001,NULL,'周日之前交','Python爬虫技巧',NULL,NULL),(39,'222',1001,NULL,'222','数据结构',NULL,NULL),(40,'44444',1001,NULL,'周日之前交','Python爬虫技巧',NULL,NULL),(41,'python第一章',1001,NULL,'周日之前交','Python爬虫技巧',NULL,NULL),(42,'数据结果第一章',1001,NULL,'周日之前交','数据结构',NULL,NULL),(43,'',1001,NULL,'','C语言程序设计',NULL,NULL),(44,'dyy',1001,NULL,'dyy','C语言程序设计','2021-04-26 22:09:00','2021-06-01 20:02:41'),(45,'测试',1001,NULL,'数据结构测试','数据结构','2021-04-26 22:40:54','2021-05-25 13:43:43'),(46,'快快快',1001,NULL,'1`2312','Python爬虫技巧','2021-04-26 22:54:51','2021-04-27 22:55:00'),(47,'dyy添加',1001,NULL,'dyy','数据结构','2021-04-26 23:06:05','2021-04-29 23:06:11'),(48,'1111111',1001,NULL,'11111','C语言程序设计','2021-04-26 23:07:01','2021-04-29 23:07:05'),(49,'睡觉',1001,NULL,'睡觉','Python爬虫技巧','2021-01-21 23:08:15','2021-01-22 20:02:41'),(50,'zhnwww',1001,NULL,'zhh','Python爬虫技巧','2021-04-26 23:17:08','2021-04-26 23:17:13'),(51,'数据结构周二',1001,NULL,'下周一上交','数据结构','2021-04-27 08:18:52','2021-05-06 08:18:57'),(52,'python第二章',1001,NULL,'周日之前交','Python爬虫技巧','2021-04-27 16:07:11','2021-04-27 16:07:16'),(53,'123',1001,NULL,'周日之前交','Python爬虫技巧','2021-04-29 14:43:39','2021-06-01 20:02:41'),(55,'python策划',1001,NULL,'周日之前交','Python爬虫技巧','2021-04-28 15:27:16','2021-05-28 15:27:20');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
