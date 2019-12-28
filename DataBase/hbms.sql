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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `booking_info` */

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
(54);

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotel_id` int(10) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `available_ac` int(50) NOT NULL,
  `available_non_ac` int(50) NOT NULL,
  `image` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`),
  UNIQUE KEY `hotel_name` (`hotel_name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotel_id`,`hotel_name`,`location`,`available_ac`,`available_non_ac`,`image`) values 
(1,'Taj Hotel','Mumbai',50,66,'https://cdn.pixabay.com/photo/2018/08/08/13/34/taj-mahal-palace-hotel-3592184__340.jpg'),
(2,'Oberoi','Goa',65,67,'https://cdn.pixabay.com/photo/2015/09/28/21/32/the-palm-962785__340.jpg'),
(3,'Velocity Inc.','Goa',23,30,'https://cdn.pixabay.com/photo/2016/11/17/09/28/hotel-1831072__340.jpg'),
(4,'Trilok','Banglore',24,53,'https://cdn.pixabay.com/photo/2014/07/05/08/21/pool-384573__340.jpg'),
(8,'Paradise Resort','Goa',45,55,'https://cdn.pixabay.com/photo/2019/12/13/06/58/stockholm-4692351__340.jpg'),
(11,'Mansion','Mumbai',10,20,'https://cdn.pixabay.com/photo/2015/03/26/10/10/building-691033__340.jpg'),
(12,'Hotel Treeside','Pune',21,40,'https://cdn.pixabay.com/photo/2018/01/03/04/14/architecture-3057553__340.jpg'),
(13,'Dwarka','Pune',30,50,'https://cdn.pixabay.com/photo/2015/11/27/07/08/singapore-1065091__340.jpg'),
(14,'Bageecha','Banglore',35,40,'https://cdn.pixabay.com/photo/2017/03/10/06/15/quebec-2131892__340.jpg'),
(16,'Mayuri','Goa',40,20,'https://cdn.pixabay.com/photo/2015/02/02/08/34/hotel-620641__340.jpg');

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
  `room_facility` varchar(255) NOT NULL,
  `room_capacity` int(10) NOT NULL,
  `room_status` varchar(50) NOT NULL,
  `hotel_id` int(10) NOT NULL,
  `room_type` varchar(10) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`,`room_capacity`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`room_id`,`room_rent`,`room_facility`,`room_capacity`,`room_status`,`hotel_id`,`room_type`,`image`) values 
(1,15000.000,'AC',2,'Unavaialable',1,'1','https://cdn.pixabay.com/photo/2016/11/21/16/21/bed-1846251__340.jpg'),
(3,10000.000,'NON-AC',3,'Available',1,'2','https://cdn.pixabay.com/photo/2016/03/28/09/34/bedroom-1285156__340.jpg'),
(4,1000.000,'AC',2,'Available',2,'1','https://cdn.pixabay.com/photo/2016/04/15/11/43/hotel-1330834__340.jpg'),
(5,1500.000,'NON-AC',3,'Available',2,'2','https://cdn.pixabay.com/photo/2016/07/08/23/36/beach-house-interior-1505461__340.jpg'),
(6,5000.000,'AC',2,'Available',3,'1','https://cdn.pixabay.com/photo/2018/02/27/13/13/bedroom-3185433__340.jpg'),
(7,3000.000,'NON-AC',2,'Available',3,'2','https://cdn.pixabay.com/photo/2018/02/27/13/13/bedroom-3185433__340.jpg'),
(8,1500.000,'AC',3,'Available',4,'2','https://cdn.pixabay.com/photo/2018/01/23/20/48/bedroom-3102376__340.jpg'),
(9,800.000,'NON-AC',3,'Available',4,'2','https://cdn.pixabay.com/photo/2014/09/26/19/45/bedroom-462772__340.jpg'),
(10,4000.000,'AC',4,'Available',8,'3','https://cdn.pixabay.com/photo/2014/09/26/19/45/bedroom-462772__340.jpg'),
(11,2500.000,'NON-AC',3,'Available',8,'3','https://cdn.pixabay.com/photo/2016/06/03/18/36/bedroom-window-1434067__340.jpg'),
(12,12500.000,'AC',12,'Available',11,'8','https://cdn.pixabay.com/photo/2018/02/24/17/17/window-3178666__340.jpg'),
(13,8000.000,'NON-AC',7,'Available',11,'5','https://cdn.pixabay.com/photo/2018/02/24/17/17/window-3178666__340.jpg'),
(14,2400.000,'AC',2,'Available',2,'2','https://cdn.pixabay.com/photo/2016/03/16/22/17/hotel-room-1261900__340.jpg'),
(15,7410.000,'AC',0,'Available',11,'2','https://cdn.pixabay.com/photo/2016/04/15/11/48/hotel-1330847__340.jpg'),
(16,6542.000,'AC',0,'Available',12,'2','https://cdn.pixabay.com/photo/2016/07/08/23/33/palmetto-bay-1505455__340.jpg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique` (`user_email`),
  KEY `password` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_email`,`user_type`,`password`,`nationality`,`phoneNumber`,`address`) values 
(1,'akash','akash@gmail.com','admin','Akash@11','Indian','7066705460','Boisar'),
(2,'pooja','pooja@gmail.com','user','Pooja@123','Indian','7066705460','Boisar'),
(3,'diksha','diksha@gmail.com','employee','diksha@123','Indian','7066705460','Boisar'),
(40,'admin','admin@gmail.com','admin','Admin@123','Indian','7066705460','Boisar'),
(41,'user','user@gmail.com','user','User@123','Indian','7066705460','Boisar'),
(42,'manager','manager@gmail.com','manager','Manager@123','Indian','7066705460','Boisar'),
(43,'employee','employee@gmail.com','employee','Employee@123','Indian','7066705460','Boisar'),
(52,'Ramesh','ramesh@gmail.com','user','Ramesh@123','Indian','9423372928','House No. 135 C,Tambada Pada,Near R'),
(53,'Sheetal','sheetal@gmail.com','user','Sheetal@123','Indian','9512233366','Pune');

/*Table structure for table `user_other_info` */

DROP TABLE IF EXISTS `user_other_info`;

CREATE TABLE `user_other_info` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_other_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
