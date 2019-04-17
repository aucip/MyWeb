# Host: localhost  (Version: 5.5.32)
# Date: 2019-04-13 18:13:39
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;

DROP DATABASE IF EXISTS `javaweb`;
CREATE DATABASE `javaweb` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `javaweb`;

#
# Source for table "comment"
#

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `essayPid` int(10) NOT NULL DEFAULT '0',
  `ID` int(8) NOT NULL DEFAULT '0',
  `content` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

#
# Data for table "comment"
#

INSERT INTO `comment` VALUES (1,1,3,'hhh, 真是欢乐'),(2,1,2,'还在写文章！！！代码敲了吗？'),(3,1,1,'不想写了'),(4,1,1,'???'),(5,1,1,'我还以为不行嘞'),(6,1,1,'希望不要再出bug'),(7,1,1,'最后一测！！！！'),(8,8,1,'火钳刘明');

#
# Source for table "draft"
#

DROP TABLE IF EXISTS `draft`;
CREATE TABLE `draft` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(10) NOT NULL DEFAULT '0',
  `headline` varchar(30) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL,
  `content` varchar(20000) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

#
# Data for table "draft"
#

INSERT INTO `draft` VALUES (1,1,'猪突猛进','2019-02-10','默认内容'),(2,2,'你好，人间','2019-02-11','默认内容'),(3,2,'奇怪','2019-02-13','默认内容'),(4,1,'升职记','2019-02-09','默认内容');

#
# Source for table "essay"
#

DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(10) NOT NULL DEFAULT '0',
  `headline` varchar(30) NOT NULL DEFAULT '1',
  `type` varchar(255) DEFAULT NULL,
  `content` varchar(20000) NOT NULL DEFAULT '',
  `date` date DEFAULT '0000-00-00',
  `skim` int(11) NOT NULL DEFAULT '0',
  `thump` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

#
# Data for table "essay"
#

INSERT INTO `essay` VALUES (1,1,'一次旅行','小说','默认内容','2019-04-09',0,0),(2,1,'交水电费','小说','很感动的风格','2019-04-09',0,0),(3,1,'谈赌博危害','小说','默认内容','2019-04-09',0,0),(4,2,'生命的二十四小时','小说','默认内容','2019-04-09',0,0),(5,2,'勇敢者之心','小说','默认内容','2019-04-09',0,0),(6,1,'生命之水','小说','默认内容','2019-04-09',0,0),(7,2,'最后一天','日记','默认内容','2019-04-09',0,0),(8,2,'胜多负少','小说','默认内容','2019-04-09',0,0);

#
# Source for table "userrel"
#

DROP TABLE IF EXISTS `userrel`;
CREATE TABLE `userrel` (
  `ID` int(10) NOT NULL DEFAULT '1',
  `fanID` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`,`fanID`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

#
# Data for table "userrel"
#

INSERT INTO `userrel` VALUES (1,2),(1,3),(1,4),(2,3),(2,4);

#
# Source for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(12) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT '',
  `age` int(6) DEFAULT NULL,
  `profession` varchar(20) DEFAULT NULL,
  `tele` char(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `habby` varchar(255) DEFAULT NULL,
  `autograph` varchar(255) DEFAULT NULL,
  `PathOFBg` varchar(255) DEFAULT '',
  `PathOfHead` varchar(255) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'fishman','123',18,'teacher','15571824568','876@qq.com','english','世事漫随流水，醒来一梦浮生','D:\\javaWeb\\eclipse-mars','D:\\javaWeb\\workspaces\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MyWeb\\headImage\\1.png'),(2,'cat','123',15,'student','12444589945','8763@qq.com','math','love life,love study','D:\\javaWeb\\eclipse-mars','D:\\javaWeb\\eclipse-mars'),(3,'onlyYou','123',12,'student','12548648897','152@qq.com','math','no,no,no','D:\\javaWeb\\eclipse-mars','D:\\javaWeb\\eclipse-mars'),(4,'beginer','123',11,'student','13878489975','154@163.com','math','go home now','D:\\javaWeb\\eclipse-mars','D:\\javaWeb\\eclipse-mars');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
