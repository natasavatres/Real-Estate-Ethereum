/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 10.1.32-MariaDB : Database - real_estate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`real_estate` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `real_estate`;

/*Table structure for table `contract` */

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `address_contract` varchar(60) NOT NULL,
  `address_buyer` varchar(60) DEFAULT NULL,
  `address_seller` varchar(60) DEFAULT NULL,
  `id_real_estate` int(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`address_contract`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contract` */

insert  into `contract`(`address_contract`,`address_buyer`,`address_seller`,`id_real_estate`,`date`) values 
('0xe0f66057cfc027ac560ea29a257908b1d43bca2f','000','000',0,'2018-06-15');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `address` varchar(60) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `private_key` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`address`,`username`,`password`,`first_name`,`last_name`,`private_key`) values 
('0x3590aca93338b0721966a8d0c96ebf2c4c87c544','admin','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918','Administrator','Administrator','bc5b578e0dcb2dbf98dd6e5fe62cb5a28b84a55e15fc112d4ca88e1f62bd7c35'),
('0x3590aca93338b0721966a8d0c96ebf2c4c87c544','mica','28197B5BC773560247F924D4BDAEC0424CFD019846DB4DAFCCCB06CE77D3FADE','Milica','Jelic','bc5b578e0dcb2dbf98dd6e5fe62cb5a28b84a55e15fc112d4ca88e1f62bd7c35'),
('0x8cc5a1a0802db41db826c2fcb72423744338dcb0','nata','5183D093E6153294550841731A95ACACADCA6FE133BB36E0F7A3BBE6342E8DC7','Natasa','Vatres','df504d175ae63abf209bad9dda965310d99559620550e74521a6798a41215f46');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
