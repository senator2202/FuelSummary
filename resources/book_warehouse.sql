-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.31-log - MySQL Community Server (GPL)
-- Операционная система:         Win32
-- HeidiSQL Версия:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных ak2
CREATE DATABASE IF NOT EXISTS `ak2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ak2`;

-- Дамп структуры для таблица ak2.drivers
CREATE TABLE IF NOT EXISTS `drivers` (
  `id_driver` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_driver`),
  UNIQUE KEY `id_driver` (`id_driver`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ak2.drivers: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
REPLACE INTO `drivers` (`id_driver`, `name`) VALUES
	(25, 'Пстыга И.Н.'),
	(27, 'Абляк А.В.'),
	(1457, 'Корик С.Н.'),
	(1904, 'Синица О.А.'),
	(1971, 'Кунейко В.С.'),
	(2021, 'Лойко А.А.'),
	(3565, 'Слабко Н.С.'),
	(4161, 'Шейна О.И.'),
	(4227, 'Шуленко О Н'),
	(5230, 'Степуль А.М.'),
	(5398, 'Шаров Н.С.'),
	(5673, 'Ануфриенок В.В.'),
	(5970, 'Казачонок В А'),
	(8664, 'Лапуцкий Ф М'),
	(8923, 'Харитонов С.Г.'),
	(9024, 'Бачило А.А.'),
	(9050, 'Шумский Л.И.'),
	(9075, 'Бабушкин В.М.'),
	(9253, 'Герман В С'),
	(9318, 'Норка В В'),
	(9385, 'Наумов П.И.'),
	(9644, 'Кравчук Г.Ф.'),
	(9921, 'Красовский Л.Е.'),
	(13470, 'Ивашко Н Н'),
	(19061, 'Мартынов В.И.'),
	(20017, 'Алехнович А А'),
	(20525, 'Митьков А.Е.'),
	(30661, 'Кречко А.С.'),
	(30718, 'Климович Л.А.'),
	(32212, 'Шляхтенок Л.Л.'),
	(32300, 'Черенков И.П.'),
	(36188, 'Чумаров В.В.');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
