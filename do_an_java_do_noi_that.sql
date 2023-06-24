-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 22, 2023 at 02:37 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `do_an_java_do_noi_that`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Table'),
(2, 'Sofa'),
(3, 'Lighting'),
(4, 'Kitchen'),
(5, 'Chair'),
(6, 'Carpet'),
(7, 'Bed');

-- --------------------------------------------------------

--
-- Table structure for table `chuc_vu`
--

CREATE TABLE `chuc_vu` (
  `idcv` bigint NOT NULL,
  `tencv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chuc_vu`
--

INSERT INTO `chuc_vu` (`idcv`, `tencv`) VALUES
(1, 'Kế Toán'),
(2, 'Bán Hàng');

-- --------------------------------------------------------

--
-- Table structure for table `images_detail`
--

CREATE TABLE `images_detail` (
  `id` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `images_detail`
--

INSERT INTO `images_detail` (`id`, `image`, `product_id`) VALUES
(24, 'ButterflyTable_276x289.jpg', 8),
(25, 'ButterflyTable_276x289(1).jpg', 8),
(27, 'BellHighTable_276x289.jpg', 9),
(28, 'BellHighTable_276x289(1).jpg', 9),
(29, 'BellHighTable_276x289(2).jpg', 9),
(31, 'Sesann_276x289 (1).jpg', 10),
(32, 'Sesann_276x289 (2).jpg', 10),
(33, 'Sesann_276x289 (3).jpg', 10),
(34, 'Sella_276x289 (1).jpg', 11),
(35, 'Sella_276x289 (2).jpg', 11),
(36, 'Sella_276x289 (3).jpg', 11),
(37, 'Sella_276x289 (4).jpg', 11),
(38, 'Pixel_276x289 (1).jpg', 12),
(39, 'Pixel_276x289 (2).jpg', 12),
(40, 'Pixel_276x289 (3).jpg', 12),
(41, 'Pacha Sofa 2-Seater_276x289 (1).jpg', 13),
(42, 'Pacha Sofa 2-Seater_276x289 (2).jpg', 13),
(43, 'Nuvola Sofa_276x289 (1).jpg', 14),
(44, 'Nuvola Sofa_276x289 (2).jpg', 14),
(45, 'Nuvola Sofa_276x289 (3).jpg', 14),
(46, 'Nuvola Sofa_276x289 (4).jpg', 14),
(47, 'New York Suite_276x289.jpg', 15),
(48, 'My Taos_276x289 (1).jpg', 16),
(49, 'My Taos_276x289 (2).jpg', 16),
(50, 'My Taos_276x289 (3).jpg', 16),
(51, 'Life_276x289.jpg', 17),
(52, 'Julep_276x289 (1).jpg', 18),
(53, 'Julep_276x289 (2).jpg', 18),
(54, 'Julep_276x289 (3).jpg', 18),
(55, 'Julep Chaise-Longue_276x289 (1).jpg', 19),
(56, 'Julep Chaise-Longue_276x289 (2).jpg', 19),
(57, 'Julep Chaise-Longue_276x289 (3).jpg', 19),
(58, 'Harold_276x289 (1).jpg', 20),
(59, 'Harold_276x289 (2).jpg', 20),
(60, 'Harold_276x289 (3).jpg', 20),
(61, 'Free System_276x289 (1).jpg', 21),
(62, 'Free System_276x289 (2).jpg', 21),
(63, 'Free System_276x289 (3).jpg', 21),
(64, 'Extrasoft_276x289 (1).jpg', 22),
(65, 'Extrasoft_276x289 (2).jpg', 22),
(66, 'Extrasoft_276x289 (3).jpg', 22),
(67, 'Clara_276x289 (1).jpg', 23),
(68, 'Clara_276x289 (2).jpg', 23),
(69, 'Clara_276x289 (3).jpg', 23),
(70, 'Clara Dormeuse_276x289 (1).jpg', 24),
(71, 'Clara Dormeuse_276x289 (2).jpg', 24),
(72, 'Clara Dormeuse_276x289 (3).jpg', 24),
(73, 'Calmo Sofa_276x289 (1).jpg', 25),
(74, 'Calmo Sofa_276x289 (2).jpg', 25),
(75, 'Bibambola_276x289 (1).jpg', 26),
(76, 'Bibambola_276x289 (2).jpg', 26),
(77, 'Bibambola_276x289 (3).jpg', 26),
(78, 'Atoll-276x289.jpg', 27),
(79, 'Atoll-276x289(1).jpg', 27),
(80, 'VitraLighting_276x289.jpg', 28),
(81, 'VitraLighting_276x289(1).jpg', 28),
(82, 'VitraLighting_276x289(2).jpg', 28),
(83, 'TacchiniLighting_276x289.jpg', 29),
(84, 'TacchiniLighting_276x289(1).jpg', 29),
(85, 'TacchiniLighting_276x289(2).jpg', 29),
(86, 'SantaColeLighting_276x289.jpg', 30),
(87, 'SantaColeLighting_276x289(1).jpg', 30),
(88, 'SantaColeLighting_276x289(2).jpg', 30),
(89, 'RollHillLighting_276x289.jpg', 31),
(90, 'RollHillLighting_276x289(1).jpg', 31),
(91, 'RollHillLighting_276x289(2).jpg', 31),
(92, 'RakumbaLighting_276x289.jpg', 32),
(93, 'RakumbaLighting_276x289(1).jpg', 32),
(94, 'RakumbaLighting_276x289(2).jpg', 32),
(95, 'ObelloLighting_276x289.jpg', 33),
(96, 'ObelloLighting_276x289(1).jpg', 33),
(97, 'ObelloLighting_276x289(2).jpg', 33),
(98, 'ObelloLighting_276x289(3).jpg', 33),
(99, 'MetropolLighting_276x289.jpg', 34),
(100, 'MetropolLighting_276x289(1).jpg', 34),
(101, 'MetropolLighting_276x289(2).jpg', 34),
(102, 'MetropolLighting_276x289(3).jpg', 34),
(103, 'LaurentLighting_276x289.jpg', 35),
(104, 'LaurentLighting_276x289(1).jpg', 35),
(105, 'LaurentLighting_276x289(2).jpg', 35),
(106, 'LariLighting_276x289.jpg', 36),
(107, 'LariLighting_276x289(1).jpg', 36),
(108, 'LariLighting_276x289(2).jpg', 36),
(109, 'LambertFilsLighting_276x289.jpg', 37),
(110, 'LambertFilsLighting_276x289(1).jpg', 37),
(111, 'LambertFilsLighting_276x289(2).jpg', 37),
(112, 'GubiLighting_276x289.jpg', 38),
(113, 'GubiLighting_276x289(1).jpg', 38),
(114, 'GubiLighting_276x289(2).jpg', 38),
(115, 'BellyFermLighting_276x289.jpg', 39),
(116, 'BellyFermLighting_276x289(1).jpg', 39),
(117, 'BellyFermLighting_276x289(2).jpg', 39),
(118, 'Modern Round Faux Marble Dining Table for 8-10 with White Lazy Susan, Gold Stainless Steel Base_276x289 (1).jpg', 41),
(119, 'Modern Round Faux Marble Dining Table for 8-10 with White Lazy Susan, Gold Stainless Steel Base_276x289 (2).jpg', 41),
(120, 'Modern Round Faux Marble Dining Table for 8-10 with White Lazy Susan, Gold Stainless Steel Base_276x289 (3).jpg', 41),
(121, '/images/kitchen/Modern Round Faux Marble Dining Table for 8-10 with White Lazy Susan, Gold Stainless Steel Base_276x289 (4).jpg', 41),
(122, 'Modern Marble Dining Table For Kitchen With Lazy Susan, Dark Gray Titanium Load-bearing Base_276x289 (1).jpg', 42),
(123, 'Modern Marble Dining Table For Kitchen With Lazy Susan, Dark Gray Titanium Load-bearing Base_276x289 (2).jpg', 42),
(124, 'Modern Marble Dining Table For Kitchen With Lazy Susan, Dark Gray Titanium Load-bearing Base_276x289 (3).jpg', 42),
(125, 'Modern Marble Dining Table For Kitchen With Lazy Susan, Dark Gray Titanium Load-bearing Base_276x289 (4).jpg', 42),
(126, 'Bura Modern Faux Marble Dining Table with White Rectangular Tabletop Gold Stainless Legs, Dining Room Table for 4_276x289 (1).jpg', 43),
(127, 'Bura Modern Faux Marble Dining Table with White Rectangular Tabletop Gold Stainless Legs, Dining Room Table for 4_276x289 (2).jpg', 43),
(128, 'Bura Modern Faux Marble Dining Table with White Rectangular Tabletop Gold Stainless Legs, Dining Room Table for 4_276x289 (3).jpg', 43),
(129, 'Bura Modern Faux Marble Dining Table with White Rectangular Tabletop Gold Stainless Legs, Dining Room Table for 4_276x289 (4).jpg', 43),
(130, 'Antique Home Styles Rubber Wood Top Kitchen Cart Butcher Block with 1 Door 1 Drawer_276x289 (1).jpg', 44),
(131, 'Antique Home Styles Rubber Wood Top Kitchen Cart Butcher Block with 1 Door 1 Drawer_276x289 (2).jpg', 44),
(132, 'Antique Home Styles Rubber Wood Top Kitchen Cart Butcher Block with 1 Door 1 Drawer_276x289 (3).jpg', 44),
(133, 'Antique Home Styles Rubber Wood Top Kitchen Cart Butcher Block with 1 Door 1 Drawer_276x289 (4).jpg', 44),
(134, 'American Home Styles Antique White Painting Rubber Wood Top Kitchen Trash Cart with 1 Drawer 1 Door_276x289 (1).jpg', 45),
(135, 'American Home Styles Antique White Painting Rubber Wood Top Kitchen Trash Cart with 1 Drawer 1 Door_276x289 (2).jpg', 45),
(136, 'American Home Styles Antique White Painting Rubber Wood Top Kitchen Trash Cart with 1 Drawer 1 Door_276x289 (3).jpg', 45),
(137, 'American Home Styles Antique White Painting Rubber Wood Top Kitchen Trash Cart with 1 Drawer 1 Door_276x289 (4).jpg', 45),
(138, 'American Home Styles Antique Rubber Wood Top Rolling Kitchen Island with 2 Door 2 Drawer_276x289 (1).jpg', 46),
(139, 'American Home Styles Antique Rubber Wood Top Rolling Kitchen Island with 2 Door 2 Drawer_276x289 (2).jpg', 46),
(140, 'American Home Styles Antique Rubber Wood Top Rolling Kitchen Island with 2 Door 2 Drawer_276x289 (3).jpg', 46),
(141, 'American Home Styles Antique Rubber Wood Top Rolling Kitchen Island with 2 Door 2 Drawer_276x289 (4).jpg', 46),
(142, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials_276x289 (1).jpg', 47),
(143, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials_276x289 (2).jpg', 47),
(144, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials_276x289 (3).jpg', 47),
(145, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials_276x289 (4).jpg', 47),
(146, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials_276x289 (5).jpg', 47),
(147, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials_276x289 (6).jpg', 47),
(148, 'Yard SeChair_276x289.jpg', 48),
(149, 'Rival Chair Natural_276x289.jpg', 49),
(150, 'Rival Chair Natural_276x289(1).jpg', 49),
(151, 'Rival Chair Natural_276x289(2).jpg', 49),
(152, 'Puff Chair_276x289.jpg', 50),
(153, 'Pouf Chair_276x289.jpg', 51),
(154, 'Panton Chair Classic_276x289.jpg', 54),
(155, 'Panton Chair Classic_276x289(1).jpg', 54),
(156, 'Panton Chair Classic_276x289(2).jpg', 54),
(157, 'Med_276x289.jpg', 55),
(158, 'Med_276x289(1).jpg', 55),
(159, 'Med_276x289(2).jpg', 55),
(160, 'Marvelous Modern 3 Seater_276x289.jpg', 56),
(161, 'Marilyn_276x289.jpg', 57),
(162, 'Marilyn_276x289 (1).jpg', 57),
(163, 'Marilyn_276x289 (2).jpg', 57),
(164, 'Lucky Chair_276x289.jpg', 58),
(165, 'KAILA FABRIC CHAIR_276x289.jpg', 59),
(166, 'KAILA FABRIC CHAIR_276x289(1).jpg', 59),
(167, 'KAILA FABRIC CHAIR_276x289(2).jpg', 59),
(168, 'KAILA FABRIC CHAIR_276x289(3).jpg', 59),
(169, 'Jalis Counter Stool_276x289.jpg', 60),
(170, 'Flair O_276x289.jpg', 61),
(171, 'Flair O_276x289(1).jpg', 61),
(172, 'Flair O_276x289(2).jpg', 61),
(173, 'Eames Fiberglass Side Chair DSR Basic Dark_276x289.jpg', 62),
(174, 'Eames Fiberglass Side Chair DSR Basic Dark_276x289 (1).jpg', 62),
(175, 'Eames Fiberglass Side Chair DSR Basic Dark_276x289 (2).jpg', 62),
(176, 'Cut Chair With 4 Spoke Base_276x289.jpg', 63),
(177, 'Chair With Armrests_276x289.jpg', 64),
(178, 'Canvas Chair_276x289.jpg', 65),
(179, 'Canvas Chair_276x289(1).jpg', 65),
(180, 'Burnham Windsor Chair_276x289.jpg', 66),
(181, 'Burnham Windsor Chair_276x289(1).jpg', 66),
(182, 'Burnham Windsor Chair_276x289(2).jpg', 66),
(183, 'Bombi Chair_276x289.jpg', 67),
(184, 'TackCarpet_276x289.jpg', 68),
(185, 'TackCarpet_276x289(1).jpg', 68),
(186, 'TackCarpet_276x289(2).jpg', 68),
(187, 'StereoCarpet_276x289.jpg', 69),
(188, 'StereoCarpet_276x289(1).jpg', 69),
(189, 'ScopeRugCarpet_276x289.jpg', 70),
(190, 'ScopeRugCarpet_276x289(1).jpg', 70),
(191, 'PatchwordCarpet_276x289.jpg', 71),
(192, 'PatchwordCarpet_276x289(1).jpg', 71),
(193, 'PatchwordCarpet_276x289(2).jpg', 71),
(194, 'PatchwordCarpet_276x289(3).jpg', 71),
(195, 'NuragicWhiteCarpet_276x289.jpg', 72),
(196, 'NuragicWhiteCarpet_276x289(1).jpg', 72),
(197, 'NuragicWhiteCarpet_276x289(2).jpg', 72),
(198, 'MimicRugCarpet_276x289.jpg', 73),
(199, 'MimicRugCarpet_276x289(1).jpg', 73),
(200, 'InkyDhowCarpet_276x289.jpg', 74),
(201, 'InkyDhowCarpet_276x289(1).jpg', 74),
(202, 'BandedCarpet_276x289.jpg', 75),
(203, 'BandedCarpet_276x289(1).jpg', 75),
(204, 'BandedCarpet_276x289(2).jpg', 75),
(205, 'AllusionCarpet_276x289.jpg', 76),
(206, 'AllusionCarpet_276x289(1).jpg', 76),
(207, 'AllusionCarpet_276x289(2).jpg', 76),
(208, 'AllusionCarpet_276x289(3).jpg', 76),
(209, 'AlloverCarpet_276x289.jpg', 77),
(210, 'AlloverCarpet_276x289(1).jpg', 77),
(211, 'AlloverCarpet_276x289(2).jpg', 77),
(212, 'AlloverCarpet_276x289(3).jpg', 77),
(213, 'PixelBoxBed_276x289.jpg', 78),
(214, 'PixelBoxBed_276x289(1).jpg', 78),
(215, 'PixelBoxBed_276x289(2).jpg', 78),
(216, 'GregoryBed_276x289.jpg', 79),
(217, 'GregoryBed_276x289(1).jpg', 79),
(218, 'GregoryBed_276x289(2).jpg', 79),
(219, 'DuBoisLowBed_276x289.jpg', 80),
(220, 'DuBoisLowBed_276x289(1).jpg', 80),
(221, 'DuBoisLowBed_276x289(2).jpg', 80),
(222, 'DuBoisLowBed_276x289(3).jpg', 80),
(223, 'CompanionsBed_276x289.jpg', 81),
(224, 'CompanionsBed_276x289(1).jpg', 81),
(225, 'CompanionsBed_276x289(2).jpg', 81),
(226, 'CapoBed_276x289.jpg', 82),
(227, 'CabNightBed_276x289.jpg', 83),
(228, 'BambolettoBed_276x289.jpg', 84),
(229, 'BambolettoBed_276x289(1).jpg', 84),
(230, 'BambolettoBed_276x289(2).jpg', 84),
(265, 'b4778883-2382-4455-af0a-989d325bd5ca.png', 108),
(269, 'd1b2fcba-d3d7-4e82-a1ec-6f7cff572be1.png', 108),
(291, 'abd89017-5bc8-4350-ba46-2e971aa1ae5c.png', 108),
(294, '6f88367e-295d-4ee3-8b5e-a4dc3f473590.png', 108),
(302, '10554151-dd1f-4e03-8c4f-af126850e47d.png', 108),
(305, '6950866f-ecd9-4ee8-afd5-30792776f39e.png', 108),
(306, '177f83af-78e8-4a89-8f69-edb56cb6ac9c.png', 108),
(308, 'cee8b3ed-6cc2-4557-ac99-2ead97af0b9c.png', 108),
(309, '895cf86e-d9f7-461f-8ad3-72186c9daf22.png', 108),
(310, '1e05f424-f0a7-46ac-b117-1f6c6d3ebe53.png', 108),
(311, 'f6fa75d7-bba6-4293-a5a5-2166992fb9cd.png', 108),
(312, 'ea661f9f-624d-4bb0-ac24-848c4a290bba.png', 108),
(313, '5b761668-ce29-4fd2-b044-f5b4bb7356fd.png', 108),
(314, '53cf8986-dd59-4557-8ded-04ac5ce13773.png', 108),
(315, 'fa338a6a-8394-436d-b43c-916a8b1908bd.png', 108),
(316, '048dc60f-e337-4005-a12b-0bc56daeb8c0.png', 108),
(317, 'fdf6548b-3361-4648-afff-c3cc913e5301.png', 108),
(318, 'aad9f8ca-96be-4e6b-8bed-4530713cf27e.png', 8),
(319, '3abc2f8c-01e1-440d-9f3c-17206250cb1f.png', 8),
(320, 'a9038ead-dc79-41b4-a704-7fcfbac090d1.png', 8),
(321, 'c38c9244-91b8-4ed3-bde4-47181f4fe889.png', 8);

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `id_kh` int NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `ngay_sinh` time(6) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `id_user` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`id_kh`, `dia_chi`, `email`, `gioi_tinh`, `hoten`, `ngay_sinh`, `sdt`, `id_user`) VALUES
(2, 'HCM', 'a@gmail.com', b'0', 'Nguyễn Văn A', NULL, NULL, 16),
(5, 'HCM', 'a@gmail.com', b'0', 'Nguyễn Văn A', NULL, NULL, 15),
(6, 'HCM', 'a@gmail.com', b'0', 'Nguyễn Văn A', NULL, NULL, 17),
(7, 'HCM', 'a@gmail.com', b'0', 'Nguyễn Văn A', NULL, NULL, 18),
(8, 'HCM', 'a@gmail.com', b'0', 'Nguyễn Văn A', NULL, NULL, NULL),
(9, 'HCM', 'a@gmail.com', b'0', 'Nguyễn Văn A', NULL, NULL, NULL),
(10, NULL, 'abc@gmail.com', NULL, 'THANH LUAN', NULL, NULL, 19),
(11, NULL, 'truond7@gmail.com', NULL, 'Thảo', NULL, NULL, 20),
(12, NULL, 'truondjdd7@gmail.com', NULL, 'Thảo', NULL, NULL, 21);

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `idnv` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `id_cv` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`idnv`, `email`, `hoten`, `sdt`, `id_cv`, `user_id`, `gioi_tinh`) VALUES
(1, 'nv1@gmail.com', 'Nguyễn Thị Hồng', '0835238239', 2, 15, b'0'),
(2, 'nv2@gmail.com', 'Nguyễn Văn A', '0123456789', 1, 17, b'1'),
(3, 'nv3@gmail.com', 'Nguyễn Văn B', '0123456789', 2, 16, b'1'),
(4, 'nv4@gmail.com', 'Nguyễn Văn B', '0123456789', 2, NULL, b'0'),
(5, 'nv5@gmail.com', 'Nguyễn Văn D', '0123456789', 2, NULL, NULL),
(6, 'nv6@gmail.com', 'Nguyễn Văn E', '0123456789', 2, NULL, NULL),
(7, 'nv7@gmail.com', 'Nguyễn Văn D', '0123456789', 2, NULL, NULL),
(8, 'nv8@gmail.com', 'Nguyễn Văn D', '0123456789', 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int NOT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `total_price` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `order_date`, `customer_id`, `total_price`) VALUES
(14, '2023-06-17 20:32:02.875940', 2, 244401008),
(15, '2023-06-22 07:15:01.788722', 7, 27850000),
(16, '2023-06-22 07:40:40.782711', 10, 4050000),
(17, '2023-06-22 07:43:32.158325', 10, 1650000);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `id` int NOT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `product_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `price`, `quantity`, `order_id`, `product_id`) VALUES
(23, 25200000, 18, 14, 9),
(25, 9, 1, 14, 108),
(26, 999, 1, 14, 102),
(27, 15400000, 2, 14, 75),
(28, 144000000, 4, 14, 47),
(29, 26100000, 3, 14, 74),
(31, 3000000, 2, 14, 67),
(33, 9600000, 6, 14, 31),
(34, 1800000, 1, 15, 15),
(35, 1900000, 1, 15, 57),
(36, 11900000, 1, 15, 83),
(37, 12250000, 5, 15, 49),
(38, 3400000, 2, 16, 8);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` bigint NOT NULL,
  `price` bigint DEFAULT NULL,
  `soluong` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `price`, `soluong`, `name`, `title`, `category_id`) VALUES
(8, 1700000, 100, 'Butterfly Table', 'SEM — HANNES PEER Butterfly Table', 1),
(9, 1400000, 100, 'Bell High Table', 'CLASSICON — SEBASTIAN HERKNER Bell High Table', 1),
(10, 2200000, 100, 'Sesann Sofa', 'TACCHINI — GIANFRANCO FRATTINI Sesann Sofa', 2),
(11, 3000000, 100, 'Sella Sofa', 'TACCHINI — CARLO DE CARLI Sella Sofa', 2),
(12, 2500000, 100, 'Pixel Sofa', 'SABA ITALIA — SERGIO BICEGO Pixel Sofa', 2),
(13, 1300000, 100, 'Pacha Sofa 2-Seater', 'GUBI — PIERRE PAULIN Pacha Sofa 2-Seater', 2),
(14, 1900000, 100, 'Nuvola Sofa', 'SEM — HANNES PEER Nuvola Sofa\r\n', 2),
(15, 1800000, 100, 'New York Suite Sofa', 'SABA ITALIA — SERGIO BICEGO New York Suite Sofa', 2),
(16, 2100000, 100, 'My Taos Sofa', 'SABA ITALIA — SERGIO BICEGO My Taos Sofa', 2),
(17, 2550000, 100, 'Life Sofa', 'ACERBIS — ROBERTO MONSANI Life Sofa', 2),
(18, 1700000, 100, 'Julep Sofa', 'TACCHINI — JONAS WAGELL Julep Sofa', 2),
(19, 1400000, 100, 'Julep Chaise-Longue Sofa', 'TACCHINI — JONAS WAGELL Julep Chaise-Longue Sofa', 2),
(20, 2300000, 100, 'Harold Sofa', 'MERIDIANI — ANDREA PARISIO Harold Sofa', 2),
(21, 1650000, 100, 'Free System Sofa', 'ACERBIS — CLAUDIO SALOCCHI Free System Sofa', 2),
(22, 2150000, 100, 'Extrasoft Sofa', 'LIVING DIVANI — PIERO LISSONI Extrasoft Sofa', 2),
(23, 1200000, 100, 'Clara Sofa\r\n\r\n', 'BAXTER — CHRISTOPHE DELCOURT Clara Sofa', 2),
(24, 1800000, 100, 'Clara Dormeuse Sofa', 'BAXTER — CHRISTOPHE DELCOURT Clara Dormeuse Sofa', 2),
(25, 1450000, 100, 'Calmo Sofa', 'FREDERICIA — HUGO PASSOS Calmo Sofa', 2),
(26, 1850000, 100, 'Bibambola Sofa', 'B&B ITALIA — MARIO BELLINI Bibambola Sofa', 2),
(27, 1100000, 100, 'Atoll Sofa', 'B&B ITALIA — ANTONIO CITTERIO Atoll Sofa', 2),
(28, 900000, 100, 'Vitra Lighting', 'VITRA — ISAMU NOGUCHI Akari 10A Lighting', 3),
(29, 1300000, 100, 'TACCHINI Lighting', 'TACCHINI — UMBERTO RIVA A.D.A. Lighting', 3),
(30, 800000, 100, 'SANTA & COLE Lighting', 'SANTA & COLE — MIGUEL MILÁ Cesta Lighting', 3),
(31, 1600000, 100, 'ROLL & HILL Lighting', 'ROLL & HILL — MCKENZIE & KEIM Apollo 6 Lights', 3),
(32, 1700000, 100, 'RAKUMBA Lighting', 'RAKUMBA — TOM SKEEHAN Argyle Lighting', 3),
(33, 500000, 100, 'Obello Lighting', 'Obello Lighting', 3),
(34, 1200000, 100, 'Metropol Pendant Lighting', 'RAKUMBA — SEBASTIAN HERKNER Metropol Pendant Lighting', 3),
(35, 700000, 100, 'Laurent Lighting', 'LAMBERT & FILS — Laurent 05 Lighting', 3),
(36, 950000, 100, 'Lari Lighting', 'KARAKTER — ANGELO MANGIAROTTI Lari Lighting', 3),
(37, 1150000, 100, 'Atomium Lighting', 'LAMBERT & FILS — Atomium Lighting', 3),
(38, 700000, 100, 'GUBI Lighting', 'GUBI — PAAVO TYNELL Lighting', 3),
(39, 400000, 100, 'Belly Ferm Lighting', 'FERM LIVING — Braided Lampshade Belly Lighting', 3),
(41, 33000000, 100, 'Modern Round Faux Marble Dining Table for 8-10 with White Lazy Susan, Gold Stainless Steel Base', 'Lấy cảm hứng từ sự quyến rũ của không gian âm nghệ thuật, chân đế màu vàng sang trọng của Bàn ăn bằng đá cẩm thạch Gwen Pedastal mang đến nét lấp lánh của người nổi tiếng cho phong cách trang trí thời trang cao cấp.', 4),
(42, 24000000, 100, 'Modern Marble Dining Table For Kitchen With Lazy Susan, Dark Gray Titanium Load-bearing Base', 'Bàn phòng ăn hình tròn bằng đá cẩm thạch này, vẫn là một mẫu có đường vân đẹp mắt trong những năm tới. Với thiết kế hiện đại, thể hiện vẻ ngoài đơn giản nhưng bền lâu.', 4),
(43, 41000000, 100, 'Bura Modern Faux Marble Dining Table with White Rectangular Tabletop Gold Stainless Legs, Dining Room Table for 4', 'Bàn ăn này được làm bằng một phiến đá cẩm thạch trắng chắc chắn và nằm thanh lịch trên khung tối giản vượt thời gian. Bản thân khung được làm bằng thép không gỉ chất lượng cao và phù hợp để sử dụng trong nhà. ', 4),
(44, 9000000, 100, 'Antique Home Styles Rubber Wood Top Kitchen Cart Butcher Block with 1 Door 1 Drawer', 'Đảo bếp Hodedah là một bổ sung phong cách nhưng đầy đủ chức năng cho bất kỳ ngôi nhà nào. Nó có một thiết kế linh hoạt và lý tưởng cho những ngôi nhà có cả nội thất truyền thống hoặc nhà tranh.', 4),
(45, 9333000, 100, 'American Home Styles Antique White Painting Rubber Wood Top Kitchen Trash Cart with 1 Drawer 1 Door', 'Đảo bếp America cung cấp thêm không gian cho nhu cầu lưu trữ nhà bếp của bạn giúp cuộc sống của bạn thoải mái.', 4),
(46, 10000000, 100, 'American Home Styles Antique Rubber Wood Top Rolling Kitchen Island with 2 Door 2 Drawer', 'Hai ngăn kéo lớn và hai tủ đựng đồ lớn, có giá treo khăn hai bên mang đến không gian lưu trữ rộng rãi\r\nThiết kế hiện đại và thanh lịch pha trộn vào nhà', 4),
(47, 36000000, 100, '001 Luxurious Customized Kitchen Cabinet and Countertop with Plywood MDF Board HDF Board Materials', 'Tủ nên được thiết kế một cách thiết thực bao gồm hệ thống kệ bên trong hoặc các phụ kiện, để đặt những đồ vật không thể thiếu như kho gia vị, Đồ Văn Phòng Phẩm, Rổ Rổ, Magic Corner.....v.v., theo ý thức tổ chức của chúng ta. ', 4),
(48, 5000000, 100, 'Yard SeChair', 'Nâng cao yếu tố thoải mái cho không gian sân trong của bạn với chiếc ghế địu này. Thiết kế bền bỉ, chiếc ghế địu này có khung thép sơn tĩnh điện và có thể xếp chồng lên nhau để cất giữ và thuận tiện.\r\n', 5),
(49, 2450000, 100, 'Rival Chair Natural', 'Ghế đối thủ, được thiết kế bởi Konstantin Grcic, đại diện cho một cách giải thích mới về ghế gỗ. Các chân được làm từ một mảnh bạch dương duy nhất gợi lại hoạt động của nhựa đúc.', 5),
(50, 1700000, 100, 'Puff Chair', 'Một chiếc ghế lười nhỏ gọn và thoải mái, được làm từ chất liệu nhung mềm mại và màu sắc tươi sáng. Với thiết kế đặc biệt, ghế Puff giúp người sử dụng thư giãn và nghỉ ngơi một cách thoải mái. ', 5),
(51, 1500000, 100, 'Pouf Chair', 'Một chiếc ghế nhỏ gọn và đa năng, được làm từ vải nhung mềm mại và có một dạng hình tròn hoặc hình vuông. Ghế Pouf là một phụ kiện nội thất trang nhã và hiện đại cho không gian sống của bạn.', 5),
(54, 2560000, 100, 'Panton Chair Classic', 'Một biểu tượng của thiết kế nội thất hiện đại, ghế Panton Classic được thiết kế bởi nhà thiết kế danh tiếng Verner Panton. Được làm từ chất liệu nhựa polypropylene mềm mại, ghế Panton Classic có hình dáng cong độc đáo và một màu sắc tươi sáng. ', 5),
(55, 1000000, 100, 'Med', 'Med là một chiếc ghế được thiết kế bởi Lodovico Acerbis và Giotto Stoppino vào năm 1983, được công ty đề xuất lại vào năm 2022 trong một phiên bản sửa đổi mới.', 5),
(56, 2100000, 100, 'Marvelous Modern 3', 'Với khung gỗ chắc chắn và lớp nệm êm ái, Marvelous Modern 3 là một sự kết hợp hoàn hảo giữa kiểu dáng tinh tế và sự thoải mái.', 5),
(57, 1900000, 100, 'Marilyn', 'Marylin là chiếc ghế do Draga & Aurel thiết kế cho Baxter. Cơ thể cứng cáp của nó chào đón bạn như một chiếc vỏ sò, mang đến một chỗ ngồi thoải mái và uốn lượn.', 5),
(58, 1200000, 100, 'Lucky Chair', 'Một chiếc ghế đơn giản nhưng may mắn, mang đến không gian sống của bạn một cái nhìn đáng yêu và phong cách.', 5),
(59, 950000, 100, 'KAILA FABRIC CHAIR', 'Một chiếc ghế bọc vải Kaila đẹp mắt, mang đến không gian sống của bạn sự sang trọng và thoải mái. Ghế Kaila có thiết kế hiện đại với khung gỗ chắc chắn và lớp đệm mềm mại, tạo ra một trải nghiệm ngồi thoải mái và êm ái.', 5),
(60, 500000, 100, 'Jalis Counter Stool', 'Một chiếc ghế cao đứng với thiết kế độc đáo và hiện đại, mang đến không gian bếp của bạn sự phong cách và tiện nghi.', 5),
(61, 2000000, 100, 'Flair O', 'Flair O là một chiếc ghế bành được thiết kế bởi Monica Armani cho B&B Italia. Lấy cảm hứng từ một bông hoa thoải mái nở rộ, Flair O được đặc trưng bởi thiết kế mềm mại, uyển chuyển với những đường nét ngọt ngào. ', 5),
(62, 999000, 100, 'Eames Fiberglass Side Chair DSR Basic Dark', 'Được Charles và Ray Eames hình thành vào những năm 1950, DSR bằng sợi thủy tinh (Đế chân ghế bên có chiều cao phòng ăn) ra đời từ sự kết hợp giữa chân đế Tháp Eiffel bằng kim loại nhẹ và tối giản.', 5),
(63, 1200000, 100, 'Cut Chair With 4 Spoke Base', 'Một chiếc ghế với thiết kế độc đáo và sáng tạo, mang đến không gian sống của bạn một cái nhìn hiện đại và đầy phong cách.', 5),
(64, 1100000, 100, 'Chair With Armrests', 'Một chiếc ghế với các cần đỡ tay hai bên, mang đến không gian sống của bạn sự thoải mái và hỗ trợ tối đa khi ngồi.', 5),
(65, 2600000, 100, 'Canvas Chair', 'Được thiết kế vào năm 1970 bởi Børge Mogensen cho Fredericia, Canvas là một chiếc ghế có thiết kế thiết yếu, thiết thực và trang nhã.', 5),
(66, 1700000, 100, 'Burnham Windsor Chair', 'Một chiếc ghế Windsor mang phong cách Burnham, mang đến không gian sống của bạn sự thanh lịch và truyền thống.', 5),
(67, 1500000, 100, 'Bombi Chair', 'Một chiếc ghế đơn giản và đáng yêu, mang đến không gian sống của bạn sự thoải mái và phong cách. Ghế Bombi có khung gỗ chắc chắn và lớp đệm mềm mại, tạo ra một trải nghiệm ngồi thoải mái.', 5),
(68, 3000000, 100, 'Tack Carpet', 'TackCarpet là một loại thảm có lớp dính phía dưới giúp nó bám chắc vào mặt sàn. Với đặc tính này, TackCarpet được sử dụng phổ biến trong các khu vực có lưu lượng người đi lại cao như văn phòng, cửa hàng và khách sạn.', 6),
(69, 5500000, 100, 'Stereo Carpet', 'Một loại thảm độc đáo với tính năng âm thanh tích hợp. Với hệ thống loa được tích hợp sẵn dưới lớp thảm, StereoCarpet cho phép bạn tận hưởng âm nhạc và trải nghiệm âm thanh tuyệt vời ngay dưới chân.', 6),
(70, 13000000, 100, 'Scope Rug Carpet', 'Một loại thảm có mô hình thiết kế phạm vi, giống như một ống nhòm, đưa người dùng vào một thế giới mới. ', 6),
(71, 7400000, 100, 'Patchword Carpet', 'Một loại thảm được tạo thành từ những mảnh vải đa dạng và đa màu sắc. Mỗi mảnh vải được ghép chồng lên nhau tạo thành một mô hình ngẫu nhiên và phong cách tổng hợp.', 6),
(72, 11000000, 100, 'Nuragic White Carpet', 'Một loại thảm được lấy cảm hứng từ nền văn hóa Nuragic ở đảo Sardinia, Ý. Với tông màu trắng tinh khiết, NuragicWhiteCarpet mang đến một cảm giác thanh lịch và sang trọng cho không gian.', 6),
(73, 11500000, 100, 'Mimic Rug Carpet', 'Một loại thảm có thiết kế đặc biệt nhằm mô phỏng hoặc bắt chước hình ảnh của các vật thể tự nhiên hoặc vật liệu khác.', 6),
(74, 8700000, 100, 'Inky Dhow Carpet', 'Một loại thảm được thiết kế với mẫu in dựa trên hình ảnh của một con thuyền dhow.', 6),
(75, 7700000, 100, 'Banded Carpet', 'Một loại thảm có mẫu dải trang trí độc đáo và sắc nét. Với các dải màu tương phản, BandedCarpet tạo ra một hiệu ứng hấp dẫn và đồng thời tạo sự tương phản về màu sắc trong không gian.', 6),
(76, 660000, 100, 'Allusion Carpet', 'Một loại thảm mang tính nghệ thuật cao với mẫu thiết kế tạo ấn tượng mô phỏng các hiện tượng tự nhiên hoặc cảm nhận trừu tượng.', 6),
(77, 4700000, 100, 'Allover Carpet', 'Một loại thảm với mẫu thiết kế đa dạng và phủ rộng trên toàn bề mặt. Thiết kế AlloverCarpet được trải qua từng khoảng trống trên thảm, tạo ra một mô hình đồng nhất và liên tục.', 6),
(78, 10000000, 100, 'Pixel Box Bed', 'Một giường phòng ngủ hiện đại với thiết kế đơn giản và tinh tế. Với khung giường bằng gỗ chắc chắn và màu sắc trang nhã, nó tạo ra một không gian nghỉ ngơi ấm cúng và thư giãn trong phòng ngủ của bạn. ', 7),
(79, 9800000, 100, 'Gregory Bed', 'Một giường phòng ngủ cao cấp với một thiết kế cổ điển và sang trọng. Với khung giường bằng gỗ cứng và hoa văn tỉ mỉ, giường này mang lại một không gian nghỉ ngơi thanh lịch và trang nhã trong phòng ngủ của bạn.', 7),
(80, 15700000, 100, 'DuBoisLow Bed', 'Một chiếc giường phòng ngủ hiện đại với thiết kế thấp và tinh tế. Với khung giường mạnh mẽ bằng kim loại và màu sắc đen huyền bí, nó mang lại một không gian nghỉ ngơi hiện đại và tinh thần trong phòng ngủ của bạn.', 7),
(81, 19200000, 100, 'Companions Bed', 'Một chiếc giường phòng ngủ đa chức năng với một thiết kế thông minh và linh hoạt. Với khung giường đơn giản và trang nhã, nó tạo ra một không gian nghỉ ngơi thoải mái và tiện nghi trong phòng ngủ của bạn.', 7),
(82, 13350000, 100, 'Capo Bed', 'Một chiếc giường phòng ngủ hiện đại với một thiết kế độc đáo và phong cách. Với khung giường bằng gỗ tự nhiên và đường nét mượt mà, nó mang đến một không gian nghỉ ngơi ấm cúng và sang trọng trong phòng ngủ của bạn. ', 7),
(83, 11900000, 100, 'CabNight Bed', 'Một chiếc giường phòng ngủ đương đại với một thiết kế đơn giản và phong cách. Với khung giường bằng gỗ và màu sắc trang nhã, nó tạo ra một không gian nghỉ ngơi ấm cúng và thư giãn trong phòng ngủ của bạn. ', 7),
(84, 20000000, 100, 'Bamboletto Bed', 'Chiếc giường phòng ngủ đa năng với thiết kế hiện đại và sáng tạo. Với khung giường bằng gỗ tre tự nhiên và màu sắc tự nhiên, nó mang lại không gian nghỉ ngơi gần gũi với thiên nhiên trong phòng ngủ của bạn.', 7),
(86, 5000, 0, 'Ban A', 'Test Ban A', 4),
(87, 90000, 900, 'Ban A', 'Test Ban A', 2),
(102, 999, 999, 'Tham ABC', 'Test Tham', 6),
(108, 9, 99, 'bb test bb', 'Test Ban A', 4);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` bigint NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `username` varchar(50) NOT NULL,
  `id_role` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `password`, `username`, `id_role`) VALUES
(15, 'truongngophucthinh2007@gmail.com', 'Thảo', '$2a$10$8HLeti2RDgCvYgBIgzUuQ.dnoeAe7VSN1Ps2zrnF4LxHRQW.FIzIy', 'nhen19', 2),
(16, 'dendekun5@gmail.com', 'Đô', '$2a$10$pM0CGVhN9Fzh9RcvVd1PxuooSfjQYNL2qf6WWHKbxjuYeiwHpWNJu', 'dendekun', 2),
(17, 'khoinguyen29082002@gmail.com', 'Khôi', '$2a$10$Z4/nW4Iyzp0YKvm/rqjbq.iB6JEZtP2PrSTrR5Mq9pQHOtufn21Vq', 'binbb23', 2),
(18, 'xuantoannguyen2212@gmail.com', 'Nguyen Xuan Toan', '$2a$10$V9hPLPTPpw6nZqhmqanuDOhbu32YVEOyJaghEXLH/APjDIUKzkEH.', 'xuantoan', 1),
(19, 'abc@gmail.com', 'THANH LUAN', '$2a$10$wftVMzCXMWS3dvRpaTmZMeADlAXcIQXpQFHCZ94XFRkynFmujt1Vy', 'QDUYET1', 1),
(20, 'truond7@gmail.com', 'Thảo', '$2a$10$IGDKNus9/vidqXuTJEjEXe8R33PVQV2cU.4ry1mPDd9jYQY3CGs1W', 'thao', 2),
(21, 'truondjdd7@gmail.com', 'Thảo', '$2a$10$KdvPUytGjdzzoWdunmywo.KBlPmkGSNUU3PRslLNf.CCD7QuqZuDm', 'thao2', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chuc_vu`
--
ALTER TABLE `chuc_vu`
  ADD PRIMARY KEY (`idcv`);

--
-- Indexes for table `images_detail`
--
ALTER TABLE `images_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl0hr8sv5m6iw25nrbdnragm0e` (`product_id`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`id_kh`),
  ADD UNIQUE KEY `UK_m43a92mt6hxo3pkfpxhth3qq8` (`id_user`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`idnv`),
  ADD UNIQUE KEY `UK_aalrsrbhd3au1rkgjtamvlmrj` (`user_id`),
  ADD KEY `FKorl1sgk99ys4krxd17u4i2mfc` (`id_cv`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgq9fv85nnx2ha640cabuc8jv8` (`customer_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjyu2qbqt8gnvno9oe9j2s2ldk` (`order_id`),
  ADD KEY `FK4q98utpd73imf4yhttm3w0eax` (`product_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1cf90etcu98x1e6n9aks3tel3` (`category_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD KEY `FK6njoh3pti5jnlkowken3r8ttn` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `chuc_vu`
--
ALTER TABLE `chuc_vu`
  MODIFY `idcv` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `images_detail`
--
ALTER TABLE `images_detail`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=322;

--
-- AUTO_INCREMENT for table `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `id_kh` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `idnv` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `images_detail`
--
ALTER TABLE `images_detail`
  ADD CONSTRAINT `FKl0hr8sv5m6iw25nrbdnragm0e` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD CONSTRAINT `FKqxr5j7ijmuqcpfes9kct27gws` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD CONSTRAINT `FK13px5gwe1873itbesjxfq2epv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKorl1sgk99ys4krxd17u4i2mfc` FOREIGN KEY (`id_cv`) REFERENCES `chuc_vu` (`idcv`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKgq9fv85nnx2ha640cabuc8jv8` FOREIGN KEY (`customer_id`) REFERENCES `khach_hang` (`id_kh`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `FK4q98utpd73imf4yhttm3w0eax` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKjyu2qbqt8gnvno9oe9j2s2ldk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK1cf90etcu98x1e6n9aks3tel3` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK6njoh3pti5jnlkowken3r8ttn` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
