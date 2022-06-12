/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.21-MariaDB : Database - olshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`olshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `olshop`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

/*Table structure for table `checkout` */

DROP TABLE IF EXISTS `checkout`;

CREATE TABLE `checkout` (
  `id_checkout` int(11) NOT NULL AUTO_INCREMENT,
  `id_pelanggan` int(11) NOT NULL,
  `status` varchar(225) NOT NULL,
  `total` varchar(225) NOT NULL,
  `created_at` varchar(225) NOT NULL,
  PRIMARY KEY (`id_checkout`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `checkout` */

/*Table structure for table `diskon` */

DROP TABLE IF EXISTS `diskon`;

CREATE TABLE `diskon` (
  `id_diskon` int(11) NOT NULL AUTO_INCREMENT,
  `id_produk` int(11) NOT NULL,
  `harga_diskon` double NOT NULL,
  PRIMARY KEY (`id_diskon`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `diskon` */

insert  into `diskon`(`id_diskon`,`id_produk`,`harga_diskon`) values 
(1,24,5000);

/*Table structure for table `kategory` */

DROP TABLE IF EXISTS `kategory`;

CREATE TABLE `kategory` (
  `id_kategori` int(11) NOT NULL AUTO_INCREMENT,
  `kategori` varchar(100) CHARACTER SET latin1 NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kategory` */

insert  into `kategory`(`id_kategori`,`kategori`,`user_id`) values 
(1,'Kategori 1',1);

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT,
  `email_pelanggan` varchar(100) NOT NULL,
  `password_pelanggan` varchar(50) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `telepon_pelanggan` varchar(25) NOT NULL,
  PRIMARY KEY (`id_pelanggan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`id_pelanggan`,`email_pelanggan`,`password_pelanggan`,`nama_pelanggan`,`telepon_pelanggan`) values 
(4,'ega@gmail.com','123456','Ega','085');

/*Table structure for table `pembelian` */

DROP TABLE IF EXISTS `pembelian`;

CREATE TABLE `pembelian` (
  `id_pembelian` int(11) NOT NULL AUTO_INCREMENT,
  `id_pelanggan` int(11) NOT NULL,
  `tanggal_pembelian` date NOT NULL,
  `total_pembelian` int(11) NOT NULL,
  PRIMARY KEY (`id_pembelian`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pembelian` */

insert  into `pembelian`(`id_pembelian`,`id_pelanggan`,`tanggal_pembelian`,`total_pembelian`) values 
(1,4,'2022-06-14',1),
(2,4,'2022-06-29',2);

/*Table structure for table `pembelian_produk` */

DROP TABLE IF EXISTS `pembelian_produk`;

CREATE TABLE `pembelian_produk` (
  `id_pembelian_produk` int(11) NOT NULL AUTO_INCREMENT,
  `id_pembelian` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  PRIMARY KEY (`id_pembelian_produk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pembelian_produk` */

insert  into `pembelian_produk`(`id_pembelian_produk`,`id_pembelian`,`id_produk`,`jumlah`) values 
(1,1,24,10),
(2,2,25,5);

/*Table structure for table `produk` */

DROP TABLE IF EXISTS `produk`;

CREATE TABLE `produk` (
  `id_produk` int(11) NOT NULL AUTO_INCREMENT,
  `nama_produk` varchar(100) NOT NULL,
  `harga_produk` int(11) NOT NULL,
  `berat_produk` int(11) NOT NULL,
  `foto_produk` varchar(100) NOT NULL,
  `deskripsi_produk` text NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `id_diskon` int(11) NOT NULL,
  `id_promo` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`id_produk`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `produk` */

insert  into `produk`(`id_produk`,`nama_produk`,`harga_produk`,`berat_produk`,`foto_produk`,`deskripsi_produk`,`id_kategori`,`id_diskon`,`id_promo`,`qty`) values 
(24,'kaos distro',100000,2,'dst1.jpg','“Vapor Shirt made by all international and creative artists. Check these details!\r\nBahan katun asli (cek testimoni dari pembeli sebelumnya dan review langsung dari kita, ya!)\r\nDijamin, bahan kaos gak akan buat kamu gerah karena mengandung katun asli. Hasil akhirnya: lembut, nyaman dipakai, dan ringan\r\nVarian warna: mejikuhibiniu, termasuk warna-warna soft (cek katalog kita yuk!)\r\nLengan pendek dan lengan panjang (request to us!)\r\n',12,0,2,40),
(25,'Kaos 3 second',150000,3,'dst2.jpg','						“Vapor Shirt made by all international and creative artists. Check these details!\r\n\r\n    Bahan katun asli (cek testimoni dari pembeli sebelumnya dan review langsung dari kita, ya!)\r\n    Dijamin, bahan kaos gak akan buat kamu gerah karena mengandung katun asli. Hasil akhirnya: lembut, nyaman dipakai, dan ringan\r\n    Varian warna: mejikuhibiniu, termasuk warna-warna soft (cek katalog kita yuk!)\r\n    Lengan pendek dan lengan panjang (request to us!)\r\n				',0,0,0,0);

/*Table structure for table `promo` */

DROP TABLE IF EXISTS `promo`;

CREATE TABLE `promo` (
  `id_promo` int(11) NOT NULL AUTO_INCREMENT,
  `id_produk` int(11) NOT NULL,
  `harga_promo` double NOT NULL,
  PRIMARY KEY (`id_promo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `promo` */

insert  into `promo`(`id_promo`,`id_produk`,`harga_promo`) values 
(24,24,2000);

/*Table structure for table `recyclerview` */

DROP TABLE IF EXISTS `recyclerview`;

CREATE TABLE `recyclerview` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `gambar_url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `recyclerview` */

insert  into `recyclerview`(`id`,`judul`,`gambar_url`) values 
(1,'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l','https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1565938792/nxu9altmvzosylzy2y8o.jpg'),
(2,'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l','https://media.suara.com/pictures/336x188/2020/10/03/57216-new-bmw-g-310-gs.jpg'),
(3,'harga mobil murah penjualan meningkat','https://asset.kompas.com/crops/4PicRHAedGDIPRGQ_XPKxEQ2BSo=/68x60:626x432/750x500/data/photo/2020/08/23/5f41e726e2329.jpg'),
(4,'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l','https://2.bp.blogspot.com/-iB3LLndbXNY/WYKglkSy6VI/AAAAAAAAkJg/GOMGJ3pkJwMReGBGGORxdHjWo2q10GpkQCLcBGAs/s1600/black-news-blogger-theme-responsive.JPG'),
(6,'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l','https://pusatdigitalprintingjepara.com/wp-content/uploads/2019/01/Ingin-Membuat-Desain-Yang-Keren-Baca-Artikel-Desain-Grafis-Ini.jpeg'),
(7,'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l','https://asset.kompas.com/crops/4PicRHAedGDIPRGQ_XPKxEQ2BSo=/68x60:626x432/750x500/data/photo/2020/08/23/5f41e726e2329.jpg');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(60) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`id`,`email`,`password`) values 
(1,'rsmdewis2409@gmail.com','e10adc3949ba59abbe56e057f20f883e'),
(3,'berlian@gmail.com','e10adc3949ba59abbe56e057f20f883e'),
(4,'nofa@gmail.com','e10adc3949ba59abbe56e057f20f883e');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
