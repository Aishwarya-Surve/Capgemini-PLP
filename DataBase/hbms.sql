/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 5.5.27 : Database - hotel_management_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel_management_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel_management_system`;

/*Table structure for table `booking_info` */

DROP TABLE IF EXISTS `booking_info`;

CREATE TABLE `booking_info` (
  `booking_id` int(10) NOT NULL AUTO_INCREMENT,
  `room_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `amount` double(8,3) NOT NULL,
  `payment_status` varchar(10) DEFAULT NULL,
  `mode_of_payment` varchar(10) DEFAULT NULL,
  `checkin_date` date NOT NULL,
  `checkout_date` date NOT NULL,
  `hotel_id` int(10) NOT NULL,
  PRIMARY KEY (`booking_id`,`room_id`,`checkout_date`),
  KEY `room_id` (`room_id`),
  KEY `user_id` (`user_id`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `booking_info_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `booking_info_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `booking_info_ibfk_3` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `booking_info` */

insert  into `booking_info`(`booking_id`,`room_id`,`user_id`,`amount`,`payment_status`,`mode_of_payment`,`checkin_date`,`checkout_date`,`hotel_id`) values 
(1,1,2,3000.000,'paid','Debit Card','2019-12-21','2019-12-22',1),
(1,1,2,3000.000,'paid','Debit Card','2019-12-29','2019-12-31',1),
(3,1,2,1500.000,'paid','cash','2019-12-30','2019-12-31',1),
(5,4,2,4000.000,'Done','cash','2019-12-27','2019-12-31',2),
(6,1,2,1500.000,'Done','card','2019-12-27','2019-12-28',1);

/*Table structure for table `food_order` */

DROP TABLE IF EXISTS `food_order`;

CREATE TABLE `food_order` (
  `order_id` int(10) NOT NULL,
  `food_id` int(10) NOT NULL,
  `food_type` varchar(50) NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `food_price` double(6,2) NOT NULL,
  `food_quantity` int(10) NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `food_order` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(20);

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotel_id` int(10) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `available_ac` int(50) NOT NULL,
  `available_non_ac` int(50) NOT NULL,
  `image` int(50) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`),
  UNIQUE KEY `hotel_name` (`hotel_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotel_id`,`hotel_name`,`location`,`available_ac`,`available_non_ac`,`image`) values 
(1,'Taj Hotel','Mumbai',50,71,101),
(2,'Oberoi','Goa',55,74,102),
(3,'Velocity Inc.','Goa',23,32,103),
(4,'Trilok','Banglore',24,56,104),
(8,'Paradise Resort','Goa',45,57,105),
(11,'Mansion','Mumbai',10,20,106);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) DEFAULT NULL,
  `manager_email` varchar(255) DEFAULT NULL,
  `manager_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`manager_id`,`hotel_id`,`manager_email`,`manager_name`,`password`,`user_type`) values 
(1,2,'shani@gmail.com','shani','Shani@123','manager');

/*Table structure for table `menu_card` */

DROP TABLE IF EXISTS `menu_card`;

CREATE TABLE `menu_card` (
  `food_id` int(10) NOT NULL,
  `food_type` varchar(50) NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `food_price` double(6,2) DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu_card` */

/*Table structure for table `menu_cart` */

DROP TABLE IF EXISTS `menu_cart`;

CREATE TABLE `menu_cart` (
  `food_id` int(11) NOT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `food_price` double DEFAULT NULL,
  `food_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu_cart` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_id` int(10) NOT NULL AUTO_INCREMENT,
  `room_rent` double(8,3) NOT NULL,
  `room_type` varchar(10) NOT NULL,
  `room_capacity` int(10) NOT NULL,
  `room_status` varchar(50) NOT NULL,
  `hotel_id` int(10) NOT NULL,
  `room_facility` varchar(255) NOT NULL,
  PRIMARY KEY (`room_id`,`room_capacity`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`room_id`,`room_rent`,`room_type`,`room_capacity`,`room_status`,`hotel_id`,`room_facility`) values 
(1,1500.000,'1',2,'Unavaialable',1,'ac'),
(3,2000.000,'2',3,'Available',1,'nonac'),
(4,1000.000,'1',2,'Available',2,'ac'),
(5,1500.000,'2',3,'Available',2,'NON-AC'),
(6,5000.000,'1',2,'Available',3,'ac'),
(7,3000.000,'2',2,'Available',3,'nonac'),
(8,1500.000,'2',3,'Available',4,'ac'),
(9,800.000,'2',3,'Available',4,'nonac'),
(10,4000.000,'3',4,'Available',8,'ac'),
(11,2500.000,'3',3,'Available',8,'nonac'),
(12,12500.000,'8',12,'Available',11,'ac'),
(13,8000.000,'5',6,'Available',11,'nonac');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique` (`user_email`),
  KEY `password` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_email`,`user_type`,`password`) values 
(1,'akash','akash@gmail.com','admin','Akash@11'),
(2,'pooja','pooja@gmail.com','user','Pooja@123'),
(3,'diksha','diksha@gmail.com','employee','diksha@123'),
(6,'Tiger Shroff','tiger@gmail.com','manager','Tiger@123'),
(8,'Nishi Shah','nishi@gmail.com','manager','Nishi@123'),
(9,'qwerty','qwerty@gmail.com','user','Qwerty@123'),
(19,'Mayuri Shinde','shinde@gmail.com','user','Shinde@123');

/*Table structure for table `user_other_info` */

DROP TABLE IF EXISTS `user_other_info`;

CREATE TABLE `user_other_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_no` bigint(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_email` (`user_email`),
  KEY `password` (`password`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_other_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user_other_info` */

insert  into `user_other_info`(`id`,`user_id`,`user_name`,`user_type`,`user_email`,`password`,`phone_no`,`address`,`nationality`) values 
(6,2,'pooja','user','pooja@gmail.com','Pooja@123',7066754520,'Nagpur','Indian');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
