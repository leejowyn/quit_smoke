-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 25, 2022 at 08:38 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stopsmoking`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET latin1 NOT NULL,
  `email` varchar(64) CHARACTER SET latin1 NOT NULL,
  `password` text CHARACTER SET latin1 NOT NULL,
  `amt_cigarette` int(30) NOT NULL,
  `price_cigarette` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `amt_cigarette`, `price_cigarette`) VALUES
(1, 'Tommy', 'tommytan2002@hotmail.com', 'Tom123!', 0, 0),
(2, 'androidx.appcompat.widget.AppC', 'androidx.appcompat.widget.AppCompatEditText{681e792 VFED..CL. ..', '$2y$10$octey6okI.SW9l3kpx0v0.52k6yY8zkm7fRS1qNE11.6f9Sgo48Ka', 0, 0),
(3, 'Tommy', 'tomm@hotmail.com', '$2y$10$ds9Kh6tx953xZfOxYwRVB..oBEFREHohgANMi.XURu81ZEJ12HfSy', 0, 0),
(4, 'T', 'tommytommy1@hotmail.com', '$2y$10$3.TzBiuO7qhPE2IDlhXsduqa5y0E5ra95G3vsxLN8JxzWJ6N8bdQq', 0, 0),
(5, 'Tommy', 'tommy12@hotmail.com', '$2y$10$dvbT1lN4VEtHMl4QP4CPgOYrBFythv4GLKajxd4IWAGNvkU2IyERC', 0, 0),
(6, '', '', '$2y$10$FOk/4yLZvNXgeZy.zrvi2uSNDz.BIrUInFptkV39mHVQCcGXepBZy', 0, 0),
(7, '', '', '$2y$10$FSKsY7B.OkgnTxTLbwzcj.YxMQ/rdmzTOCe1c2akFnFrHROcX8vNG', 0, 0),
(8, '', '', '', 0, 0),
(9, 'Tommy', 'tommy21@hotmail.com', '$2y$10$1v8YoNalqpZScfwqVgz4ZOlQMooY9UPKhtf6GukIVl7.JNRMR4ev2', 10, 23),
(10, 'tommy', 'tommy', '$2y$10$ZJ.rY/mZGOd11J3jqjuqUe0LyV08pAXbSyvE2daknT.zskijkYJOa', 12, 23),
(11, 'tommy', 'tommy', '$2y$10$/DBFoM1t/EN1EXYMsLykLe9cApRSHjgSn/kFHI6VAN1WVkBuODmcO', 12, 23),
(12, '', '', '$2y$10$IzcXA2HpysBLRD5B/2B7M..3cgI/8hQukMHBcGgWKmBEUGGae.3bu', 0, 0),
(13, '', '', '$2y$10$o79V1SQhQOP1epRT4bZ5u.TjS7iGyPvbYZ1nSBqSHukcHWASDiCLK', 0, 0),
(14, '', '', '$2y$10$Y/Vvhe.PoddlYx7qzuDB.eqUJYTe3rq0s0HE3B/sfv6kmC3pjLgce', 0, 0),
(15, '', '', '$2y$10$fUIiVhdjo2J532JvMGiWburY1HIMf7fge/IpoK3kc/3LkQuWQfZ8C', 0, 0),
(16, '', '', '$2y$10$DbX038TRzZtRk.4y.QUHmuY80nVoM0XX/VTqsRnC0lh.00jDad1FC', 0, 0),
(17, '', '', '$2y$10$lbdqisl4slAPLQr2bKtLB.vbH5Kl5ufLkQ.FFSrIkalqpNwT7qSXi', 0, 0),
(18, 'Tommy', 'wadaw', '$2y$10$HidX5aGGVEyjcdicyKh9Yutw7QUT3HsjxAxk7EZqrrVX2GTdhbt2S', 0, 0),
(19, 'Tommy', 'wadaw', '$2y$10$sNYmvykqV37qTuiQNx9TIe64.rinsWGb9GTBr/NOCzvIFe2EWawdW', 0, 0),
(20, 'Tommy', 'wadaw', '$2y$10$dDL3WDZCibu6hBby5lUn0e/qrivHgdwMffscQBSs2uh62Mjd43tA.', 0, 0),
(21, 'Tommy', 'wadaw', '$2y$10$gG8JNqFN11aexfKpfjKo5ujXddAgRvDl.I1JO65RF/azs.Kk8wYSe', 0, 0),
(22, 'wdawd', 'tommytan2020@hotmail.com', '$2y$10$9jYJg5UqX3j910bgbFKPxeyiuddpgVc3t1jiJzZyKeWfVC33JR/Qq', 0, 0),
(23, 'wdawd', 'tommytan2020@hotmail.com', '$2y$10$9tvxvOoqpshni1N/.u/qqOgmijYmeRjDGD2HQPU67.9jQ9owzshc6', 0, 0),
(24, 'Tommy', 'tommy2012@hotmail.com', '$2y$10$pfcEOJpl1tIu7UcLejMORe1n7Tf5.roE0CrWSm8Fnzv8DdaKHFdaK', 0, 0),
(25, 'Tommy', 'tommytan2002@hotmail.com', '$2y$10$rZQXxNSpjK5.MaT7rEO1EOwiaspWWCefLB85/48gQZJxZGMnatNha', 12, 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
