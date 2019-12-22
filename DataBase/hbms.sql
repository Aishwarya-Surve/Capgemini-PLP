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
  `payment_status` varchar(10) NOT NULL,
  `mode_of_payment` varchar(10) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `booking_info` */

insert  into `booking_info`(`booking_id`,`room_id`,`user_id`,`amount`,`payment_status`,`mode_of_payment`,`checkin_date`,`checkout_date`,`hotel_id`) values 
(1,1,2,3000.000,'paid','Debit Card','2019-12-21','2019-12-22',1);

/*Table structure for table `food_order` */

DROP TABLE IF EXISTS `food_order`;

CREATE TABLE `food_order` (
  `order_id` int(10) NOT NULL,
  `food_id` int(10) NOT NULL,
  `food_type` varchar(50) NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `food_price` double(6,2) NOT NULL,
  `food_quantity` int(10) NOT NULL,
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
(4);

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotel_id` int(10) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `available_ac` int(50) NOT NULL,
  `available_non_ac` int(50) NOT NULL,
  PRIMARY KEY (`hotel_id`),
  UNIQUE KEY `hotel_name` (`hotel_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotel_id`,`hotel_name`,`location`,`available_ac`,`available_non_ac`) values 
(1,'Taj Hotel','Mumbai',50,75),
(2,'Oberoi','Goa',50,50),
(3,'Velocity Inc.','Goa',23,32),
(4,'Trilok','Banglore',24,56);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`room_id`,`room_rent`,`room_type`,`room_capacity`,`room_status`,`hotel_id`,`room_facility`) values 
(1,1500.000,'1',1,'Unavaialable',1,'AC');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_email`,`user_type`,`password`) values 
(1,'akash','akash@gmail.com','admin','Akash@11'),
(2,'pooja','pooja@gmail.com','user','pooja@123'),
(3,'diksha','diksha@gmail.com','employee','diksha@123');

/*Table structure for table `user_other_info` */

DROP TABLE IF EXISTS `user_other_info`;

CREATE TABLE `user_other_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `phone_no` bigint(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`phone_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_other_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
