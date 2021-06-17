-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 15:28:18
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca_g3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `idAutor` int(11) NOT NULL,
  `dni` bigint(20) DEFAULT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `nacionalidad` varchar(30) NOT NULL,
  `fechaNac` date NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`idAutor`, `dni`, `apellido`, `nombre`, `nacionalidad`, `fechaNac`, `activo`) VALUES
(54, 5748365, 'Louis-Ferdinand', 'Céline', 'Francia', '1894-05-24', 1),
(55, 1657826, 'Oscar', 'Wilde', 'Irlanda', '1854-10-16', 1),
(56, 3459461, 'Willian', 'Shakespeare', 'Reino Unido', '1564-04-05', 0),
(57, 4562168, 'Paulo', 'Coelho', 'Brasil', '1947-08-24', 1),
(58, 8416783, 'Charles', 'Dilkens', 'Reino Unido', '1812-02-07', 1),
(59, 3754170, 'Aldous', 'Huxley', 'Reino Unido', '1894-06-26', 0),
(61, 12222, 'prueba', 'prueba', 'arg', '1894-06-26', 1),
(69, 1212, 'prueba', 'prueba', 'arg', '1894-06-26', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `idEjemplar` int(11) NOT NULL,
  `idLibro` int(11) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`idEjemplar`, `idLibro`, `estado`, `activo`) VALUES
(73, 66, 'Disponible', 1),
(74, 67, 'Disponible', 1),
(75, 68, 'Retraso', 1),
(76, 68, 'Disponible', 1),
(77, 70, 'Disponible', 1),
(78, 70, 'Disponible', 1),
(79, 70, 'Disponible', 1),
(80, 71, 'Disponible', 1),
(81, 72, 'Disponible', 1),
(82, 73, 'Disponible', 1),
(83, 73, 'Disponible', 1),
(84, 74, 'Disponible', 1),
(85, 75, 'Disponible', 1),
(86, 75, 'Disponible', 1),
(87, 76, 'Disponible', 1),
(88, 76, 'Disponible', 1),
(89, 77, 'Disponible', 1),
(90, 78, 'Disponible', 1),
(91, 78, 'Disponible', 1),
(92, 78, 'Disponible', 1),
(93, 78, 'Disponible', 1),
(94, 78, 'Disponible', 1),
(95, 78, 'Disponible', 1),
(98, 67, 'Disponible', 1),
(99, 68, 'Disponible', 1),
(100, 68, 'Disponible', 1),
(101, 70, 'Disponible', 1),
(102, 70, 'Disponible', 1),
(103, 70, 'Disponible', 1),
(104, 71, 'Disponible', 1),
(105, 72, 'Disponible', 1),
(106, 73, 'Disponible', 1),
(107, 73, 'Disponible', 1),
(108, 74, 'Disponible', 1),
(109, 75, 'Disponible', 1),
(110, 75, 'Disponible', 1),
(111, 76, 'Disponible', 1),
(112, 76, 'Disponible', 1),
(113, 77, 'Disponible', 1),
(114, 78, 'Disponible', 1),
(115, 78, 'Disponible', 1),
(116, 78, 'Disponible', 1),
(117, 78, 'Disponible', 1),
(118, 78, 'Disponible', 1),
(119, 78, 'Disponible', 1),
(120, 78, 'Disponible', 1),
(121, 67, 'Disponible', 1),
(122, 67, 'Disponible', 1),
(123, 68, 'Retraso', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `idLector` int(11) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`idLector`, `dni`, `apellido`, `nombre`, `email`, `estado`) VALUES
(28, 42744219, 'Gomez', 'Renzo', 'prueba@gmail.com', 1),
(29, 23568456, 'Altamirano', 'Franco', 'prueba@gmail.com', 0),
(30, 42395443, 'Martinez', 'Maria', 'prueba@gmail.com', 1),
(31, 12435745, 'Cabañez', 'Maria', 'prueba@gmail.com', 1),
(32, 47234244, 'Gatica', 'Marcos', 'Marcos@gmail.com', 1),
(33, 33583430, 'Fernandez', 'Macarena', 'prueba@hotmail.com', 1),
(34, 9567254, 'Rivarola', 'Jorge', 'prueba@gmail.com', 1),
(35, 472954430, 'Quiroga', 'Ariell', 'prueba@gmail.com', 1),
(36, 39583434, 'Garro', 'Emiliano', 'emilianoGarro1998@gmail.com', 1),
(51, 95672547, 'Rivarola', 'Jorge', 'prueba@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `idAutor` int(11) NOT NULL,
  `isbn` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `editorial` varchar(30) NOT NULL,
  `anio` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idLibro`, `idAutor`, `isbn`, `nombre`, `tipo`, `editorial`, `anio`, `activo`) VALUES
(66, 54, '2398', 'Viaje al fin de la noche', 'Novela', 'Denoël', 1932, 1),
(67, 54, '2399', 'Muerte a crédito', 'Ficción', 'deBolsillo', 2021, 1),
(68, 55, '4624', 'El retrato de Dorian Gray', 'Horror', 'AGeBe', 1840, 1),
(69, 55, '4683', 'El Fantasma de Canterville', 'Ficcion', 'AGeBe', 1887, 1),
(70, 56, '6753', 'Romeo y Julieta', 'Tragedia', 'Alma', 1597, 1),
(71, 56, '7876', 'Mucho ruido y pocas nueces', 'Romance', 'Alianza', 2020, 1),
(72, 57, '5875', 'El Alquimista', 'Drama', 'Planeta', 1988, 1),
(73, 57, '5786', 'Once Minutos', 'Ficcion', 'Booket', 2003, 1),
(74, 58, '5987', 'Cuentos de Navidad', 'Ficcion', 'Austral', 1843, 1),
(75, 58, '8732', 'Tiempos Dificiles', 'Ficcion', 'Alianza', 1854, 1),
(76, 59, '4216', 'Un Mundo Feliz', 'Novela', 'Edhasa', 1932, 1),
(77, 59, '1654', 'La Isla', 'Novela', 'Octaedro', 1862, 1),
(78, 59, '5375', 'Las Puertas de la Percepción', 'Ficcion', 'Debolsillo', 2018, 1),
(96, 69, 'asdasd', 'asd', 'asd', 'asd', 2016, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE `multa` (
  `idMulta` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaDevolucion` date NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `multa`
--

INSERT INTO `multa` (`idMulta`, `fechaInicio`, `fechaDevolucion`, `activo`) VALUES
(60, '2021-06-17', '2021-06-19', 0),
(61, '2020-02-28', '2021-06-06', 0),
(62, '2020-02-28', '2021-06-06', 1),
(63, '2020-02-28', '2021-06-06', 1),
(64, '2021-06-17', '2021-06-19', 1),
(65, '2021-06-17', '2021-06-19', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `idEjemplar` int(11) DEFAULT NULL,
  `idLector` int(11) DEFAULT NULL,
  `idMulta` int(11) DEFAULT NULL,
  `fechaPrestamo` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `idEjemplar`, `idLector`, `idMulta`, `fechaPrestamo`, `fechaDevolucion`, `activo`) VALUES
(105, 74, 29, 60, '2021-04-17', '2021-06-17', 0),
(106, 76, 30, 60, '2021-06-17', '2021-06-17', 0),
(107, 74, 29, NULL, '2021-06-17', '2021-06-17', 0),
(108, 75, 28, NULL, '2021-06-17', '2021-06-17', 0),
(110, 73, 28, NULL, '2021-06-17', '2021-06-17', 0),
(111, 75, 28, NULL, '2021-06-17', '2021-06-17', 0),
(112, 74, 28, NULL, '2021-06-17', '2021-06-17', 0),
(113, 75, 29, NULL, '2021-01-17', NULL, 0),
(114, 74, 32, 64, '2021-04-17', '2021-06-17', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`idAutor`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`idEjemplar`),
  ADD KEY `idLibro` (`idLibro`);

--
-- Indices de la tabla `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`idLector`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `idAutor` (`idAutor`),
  ADD KEY `idAutor_2` (`idAutor`);

--
-- Indices de la tabla `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`idMulta`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `idEjemplar` (`idEjemplar`),
  ADD KEY `idLector` (`idLector`),
  ADD KEY `idMulta` (`idMulta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `idEjemplar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- AUTO_INCREMENT de la tabla `lector`
--
ALTER TABLE `lector`
  MODIFY `idLector` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`idLector`) REFERENCES `lector` (`idLector`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `prestamo_ibfk_3` FOREIGN KEY (`idMulta`) REFERENCES `multa` (`idMulta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
