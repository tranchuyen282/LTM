-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 30, 2020 lúc 05:40 AM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlnh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblcalamviec`
--

CREATE TABLE `tblcalamviec` (
  `id` int(10) NOT NULL,
  `gioBatDau` time(6) NOT NULL DEFAULT current_timestamp(6),
  `gioKetThuc` time(6) DEFAULT NULL,
  `thu` int(10) DEFAULT NULL,
  `ngay` date DEFAULT NULL,
  `luongTrenCa` int(10) DEFAULT NULL,
  `soLuongNhanVien` int(10) DEFAULT NULL,
  `soLuongDaDangKy` int(10) DEFAULT NULL,
  `tuanLamViecid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblcalamviec`
--

INSERT INTO `tblcalamviec` (`id`, `gioBatDau`, `gioKetThuc`, `thu`, `ngay`, `luongTrenCa`, `soLuongNhanVien`, `soLuongDaDangKy`, `tuanLamViecid`) VALUES
(1, '08:30:00.000000', '12:00:00.000000', 2, '2019-11-04', 100, 10, 4, 1),
(2, '13:30:00.000000', '18:00:00.000000', 2, '2019-11-04', 100, 15, 1, 1),
(3, '18:00:00.000000', '23:00:00.000000', 2, '2019-11-04', 100, 15, 1, 1),
(4, '08:00:00.000000', '12:00:00.000000', 2, '2019-11-25', 100, 15, 1, 4),
(5, '13:30:00.000000', '17:30:00.000000', 2, '2019-11-25', 100, 16, 1, 4),
(6, '08:30:01.000000', '12:00:00.000000', 3, '2019-11-26', 150, 10, 1, 4),
(7, '13:30:00.000000', '18:00:00.000000', 3, '2019-11-26', 150, 5, 5, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldiachi`
--

CREATE TABLE `tbldiachi` (
  `id` int(10) NOT NULL,
  `soNha` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phuong` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quan` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thanhPho` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldiachi`
--

INSERT INTO `tbldiachi` (`id`, `soNha`, `phuong`, `quan`, `thanhPho`) VALUES
(1, '28', 'Mộ Lao', 'Hà Đông', 'Hà Nội'),
(2, '04', 'Mỗ Lao ', 'Hà Đông ', 'Hà Nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblhovaten`
--

CREATE TABLE `tblhovaten` (
  `id` int(10) NOT NULL,
  `ho` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblhovaten`
--

INSERT INTO `tblhovaten` (`id`, `ho`, `ten`) VALUES
(1, 'Trần ', 'Chuyên'),
(2, 'Nguyễn ', 'Phương');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblthanhvien`
--

CREATE TABLE `tblthanhvien` (
  `id` int(11) NOT NULL,
  `username` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vaiTro‎` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HoVaTenid` int(10) DEFAULT NULL,
  `DiaChiid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblthanhvien`
--

INSERT INTO `tblthanhvien` (`id`, `username`, `password`, `vaiTro‎`, `HoVaTenid`, `DiaChiid`) VALUES
(1, '1', '1', 'HCNS', 1, 1),
(2, '2', '2', 'Lễ tân', 2, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbltuanlamviec`
--

CREATE TABLE `tbltuanlamviec` (
  `id` int(10) NOT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `ngayKetThuc` date DEFAULT NULL,
  `thang` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nam` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbltuanlamviec`
--

INSERT INTO `tbltuanlamviec` (`id`, `ngayBatDau`, `ngayKetThuc`, `thang`, `nam`) VALUES
(1, '2019-11-04', '2019-11-10', '11', '2019'),
(2, '2019-11-11', '2019-11-17', '11', '2019'),
(3, '2019-11-18', '2019-11-24', '11', '2019'),
(4, '2019-11-25', '2019-11-30', '11', '2019');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblviecdangkylam_vieccheckinout`
--

CREATE TABLE `tblviecdangkylam_vieccheckinout` (
  `id` int(10) NOT NULL,
  `thoiGianDangKy` timestamp NULL DEFAULT NULL,
  `gioCheckIn` time(6) DEFAULT NULL,
  `gioCheckOut` time(6) DEFAULT NULL,
  `CaLamViecid` int(10) DEFAULT NULL,
  `thanhVienid` int(10) DEFAULT NULL,
  `idHCNS` int(10) DEFAULT NULL,
  `ViecTinhTraLuongid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblviecdangkylam_vieccheckinout`
--

INSERT INTO `tblviecdangkylam_vieccheckinout` (`id`, `thoiGianDangKy`, `gioCheckIn`, `gioCheckOut`, `CaLamViecid`, `thanhVienid`, `idHCNS`, `ViecTinhTraLuongid`) VALUES
(1, '2019-11-10 20:54:51', '07:55:24.000000', '13:00:00.000000', 1, 1, 1, 1),
(10, '2019-11-18 06:17:42', '13:00:00.000000', '18:00:00.000000', 2, 2, NULL, 9),
(12, '2019-11-18 07:32:20', NULL, NULL, 4, 1, NULL, NULL),
(13, '2019-11-18 07:32:20', NULL, NULL, 5, 1, NULL, NULL),
(14, '2019-11-18 07:32:20', NULL, NULL, 6, 1, NULL, NULL),
(16, '2019-11-18 08:19:21', NULL, NULL, 7, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblviectinh_traluong`
--

CREATE TABLE `tblviectinh_traluong` (
  `id` int(10) NOT NULL,
  `thuongThem` int(10) DEFAULT NULL,
  `phatThem` int(10) DEFAULT NULL,
  `thoiGianTinh` timestamp(6) NULL DEFAULT NULL,
  `thang` int(10) DEFAULT NULL,
  `idHCNS` int(10) DEFAULT NULL,
  `idThanhVien` int(10) DEFAULT NULL,
  `thoiGianTra` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblviectinh_traluong`
--

INSERT INTO `tblviectinh_traluong` (`id`, `thuongThem`, `phatThem`, `thoiGianTinh`, `thang`, `idHCNS`, `idThanhVien`, `thoiGianTra`) VALUES
(1, 0, 0, '2019-11-17 17:00:00.000000', 11, 1, 1, NULL),
(9, 10, 0, '2019-11-18 08:32:33.000000', 11, 1, 2, NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblcalamviec`
--
ALTER TABLE `tblcalamviec`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tuanLamViecid` (`tuanLamViecid`);

--
-- Chỉ mục cho bảng `tbldiachi`
--
ALTER TABLE `tbldiachi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblhovaten`
--
ALTER TABLE `tblhovaten`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblthanhvien`
--
ALTER TABLE `tblthanhvien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `HoVaTenid` (`HoVaTenid`),
  ADD KEY `DiaChiid` (`DiaChiid`);

--
-- Chỉ mục cho bảng `tbltuanlamviec`
--
ALTER TABLE `tbltuanlamviec`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblviecdangkylam_vieccheckinout`
--
ALTER TABLE `tblviecdangkylam_vieccheckinout`
  ADD PRIMARY KEY (`id`),
  ADD KEY `CaLamViecid` (`CaLamViecid`),
  ADD KEY `thanhVienid` (`thanhVienid`),
  ADD KEY `idHCNS` (`idHCNS`),
  ADD KEY `ViecTinhTraLuongid` (`ViecTinhTraLuongid`);

--
-- Chỉ mục cho bảng `tblviectinh_traluong`
--
ALTER TABLE `tblviectinh_traluong`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idHCNS` (`idHCNS`),
  ADD KEY `idThanhVien` (`idThanhVien`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tblcalamviec`
--
ALTER TABLE `tblcalamviec`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `tbldiachi`
--
ALTER TABLE `tbldiachi`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tblhovaten`
--
ALTER TABLE `tblhovaten`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tblthanhvien`
--
ALTER TABLE `tblthanhvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tbltuanlamviec`
--
ALTER TABLE `tbltuanlamviec`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tblviecdangkylam_vieccheckinout`
--
ALTER TABLE `tblviecdangkylam_vieccheckinout`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `tblviectinh_traluong`
--
ALTER TABLE `tblviectinh_traluong`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tblcalamviec`
--
ALTER TABLE `tblcalamviec`
  ADD CONSTRAINT `tblcalamviec_ibfk_1` FOREIGN KEY (`tuanLamViecid`) REFERENCES `tbltuanlamviec` (`id`);

--
-- Các ràng buộc cho bảng `tblthanhvien`
--
ALTER TABLE `tblthanhvien`
  ADD CONSTRAINT `tblthanhvien_ibfk_1` FOREIGN KEY (`HoVaTenid`) REFERENCES `tblhovaten` (`id`),
  ADD CONSTRAINT `tblthanhvien_ibfk_2` FOREIGN KEY (`DiaChiid`) REFERENCES `tbldiachi` (`id`);

--
-- Các ràng buộc cho bảng `tblviecdangkylam_vieccheckinout`
--
ALTER TABLE `tblviecdangkylam_vieccheckinout`
  ADD CONSTRAINT `tblviecdangkylam_vieccheckinout_ibfk_1` FOREIGN KEY (`CaLamViecid`) REFERENCES `tblcalamviec` (`id`),
  ADD CONSTRAINT `tblviecdangkylam_vieccheckinout_ibfk_2` FOREIGN KEY (`thanhVienid`) REFERENCES `tblthanhvien` (`id`),
  ADD CONSTRAINT `tblviecdangkylam_vieccheckinout_ibfk_3` FOREIGN KEY (`idHCNS`) REFERENCES `tblthanhvien` (`id`),
  ADD CONSTRAINT `tblviecdangkylam_vieccheckinout_ibfk_4` FOREIGN KEY (`ViecTinhTraLuongid`) REFERENCES `tblviectinh_traluong` (`id`);

--
-- Các ràng buộc cho bảng `tblviectinh_traluong`
--
ALTER TABLE `tblviectinh_traluong`
  ADD CONSTRAINT `tblviectinh_traluong_ibfk_1` FOREIGN KEY (`idHCNS`) REFERENCES `tblthanhvien` (`id`),
  ADD CONSTRAINT `tblviectinh_traluong_ibfk_2` FOREIGN KEY (`idThanhVien`) REFERENCES `tblthanhvien` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
