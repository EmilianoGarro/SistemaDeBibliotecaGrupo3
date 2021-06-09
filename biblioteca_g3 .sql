-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2021 a las 03:02:58
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
(42, 5748365, 'Louis-Ferdinand', 'Céline', 'Francia', '1894-05-27', 1),
(43, 1657826, 'Oscar', 'Wilde', 'Irlanda', '1854-10-16', 1),
(44, 3459461, 'Willian', 'Shakespeare', 'Reino Unido', '1564-04-05', 0),
(45, 4562168, 'Paulo', 'Coelho', 'Brasil', '1947-08-24', 1),
(46, 8416783, 'Charles', 'Dilkens', 'Reino Unido', '1812-02-07', 1),
(47, 3754170, 'Aldous', 'Huxley', 'Reino Unido', '1894-06-26', 0),
(53, 1212, 'prueba', 'prueba', 'arg', '1894-06-26', 1);

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
(48, 0, 'Disponible', 1),
(49, 49, 'Disponible', 1),
(50, 50, 'Disponible', 1),
(51, 50, 'Disponible', 1),
(52, 52, 'Disponible', 1),
(53, 52, 'Disponible', 1),
(54, 52, 'Disponible', 1),
(55, 53, 'Disponible', 1),
(56, 54, 'Disponible', 1),
(57, 55, 'Disponible', 1),
(58, 55, 'Disponible', 1),
(59, 56, 'Disponible', 1),
(60, 57, 'Disponible', 1),
(61, 57, 'Disponible', 1),
(62, 58, 'Disponible', 1),
(63, 58, 'Disponible', 1),
(64, 59, 'Disponible', 1),
(65, 60, 'Disponible', 1),
(66, 60, 'Disponible', 1),
(67, 60, 'Disponible', 1),
(68, 60, 'Disponible', 1),
(69, 60, 'Disponible', 1),
(70, 60, 'Disponible', 1);

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
(18, 42744219, 'Gomez', 'Renzo', 'prueba1@gmail.com', 0),
(19, 23568456, 'Altamirano', 'Franco', 'prueba2@gmail.com', 1),
(20, 42395443, 'Martinez', 'Maria', 'prueba3@gmail.com', 1),
(21, 12435745, 'Cabañez', 'Maria', 'prueba4@gmail.com', 1),
(22, 47234244, 'Gatica', 'Marcos', 'Marcos@gmail.com', 1),
(23, 33583430, 'Fernandez', 'Macarena', 'prueba5@hotmail.com', 1),
(24, 9567254, 'Rivarola', 'Jorge', 'prueba6@gmail.com', 1),
(25, 47295443, 'Quiroga', 'Ariel', 'prueba7@gmail.com', 1),
(26, 39583434, 'Garro', 'Emiliano', 'emilianoGarro1998@gmail.com', 1);

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
(0, 42, '2398', 'Viaje al fin de la noche', 'Novela', 'Denoël', 1932, 1),
(49, 42, '2399', 'Muerte a crédito', 'Ficción', 'deBolsillo', 2021, 0),
(50, 43, '4624', 'El retrato de Dorian Gray', 'Horror', 'AGeBe', 1840, 0),
(51, 43, '4683', 'El Fantasma de Canterville', 'Ficcion', 'AGeBe', 1887, 1),
(52, 44, '6753', 'Romeo y Julieta', 'Tragedia', 'Alma', 1597, 1),
(53, 44, '7876', 'Mucho ruido y pocas nueces', 'Romance', 'Alianza', 2020, 1),
(54, 45, '5875', 'El Alquimista', 'Drama', 'Planeta', 1988, 1),
(55, 45, '5786', 'Once Minutos', 'Ficcion', 'Booket', 2003, 1),
(56, 46, '5987', 'Cuentos de Navidad', 'Ficcion', 'Austral', 1843, 1),
(57, 46, '8732', 'Tiempos Dificiles', 'Ficcion', 'Alianza', 1854, 1),
(58, 47, '4216', 'Un Mundo Feliz', 'Novela', 'Edhasa', 1932, 1),
(59, 47, '1654', 'La Isla', 'Novela', 'Octaedro', 1862, 1),
(60, 47, '5375', 'Las Puertas de la Percepción', 'Ficcion', 'Debolsillo', 2018, 1);

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
(8, '2000-01-25', '2021-06-06', 1),
(9, '1992-01-25', '2021-06-06', 0),
(10, '2012-01-25', '2021-06-06', 0),
(11, '2020-02-28', '2021-06-06', 1),
(12, '2021-06-08', '2021-06-10', 1);

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
(18, 48, 19, NULL, '2021-06-08', NULL, 1),
(21, 48, 24, NULL, NULL, NULL, 0),
(27, 48, 24, NULL, NULL, NULL, 0),
(28, 48, 24, NULL, NULL, NULL, 0);

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
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `idEjemplar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT de la tabla `lector`
--
ALTER TABLE `lector`
  MODIFY `idLector` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

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
