-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2021 a las 22:14:03
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

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
(0, 5748365, 'Céline', 'Louis-Ferdinand', 'Francia', '1894-05-27', 1),
(1, 1657826, 'Wilde', 'Oscar', 'Irlanda', '1854-10-16', 1),
(2, 3459461, 'Shakespeare', 'Willian', 'Reino Unido', '1564-04-05', 1),
(3, 4562168, 'Coelho', 'Paulo', 'Brasil', '1947-08-24', 1),
(4, 8416783, 'Dilkens', 'Charles', 'Reino Unido', '1812-02-07', 1),
(5, 3754170, 'Huxley', 'Aldous', 'Reino Unido', '1894-06-26', 1);

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
(1, 0, 'Bueno', 0),
(2, 1, 'Nuevo', 0),
(3, 0, 'Muy Bueno', 1),
(4, 2, 'Bueno', 1),
(5, 2, 'Muy Bueno', 1),
(6, 3, 'Muy Bueno', 0),
(7, 4, 'Malo', 0),
(8, 4, 'Bueno', 0),
(9, 5, 'Bueno', 1),
(10, 6, 'Muy bueno', 1),
(11, 7, 'Bueno', 0),
(12, 7, 'Muy Bueno', 1),
(13, 8, 'Bueno', 1),
(14, 9, 'Muy Bueno', 1),
(15, 9, 'Malo', 1),
(16, 10, 'Nuevo', 0),
(18, 10, 'Muy Bueno', 1),
(19, 11, 'Muy Bueno', 0),
(20, 12, 'Bueno', 0),
(21, 12, 'Muy Bueno', 1),
(22, 12, 'Malo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `idLector` int(11) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`idLector`, `dni`, `apellido`, `nombre`, `estado`) VALUES
(1, 42744219, 'Gomez', 'Renzo', 0),
(2, 23568456, 'Altamirano', 'Franco', 1),
(3, 42395443, 'Martinez', 'Maria', 1),
(4, 12435745, 'Cabañez', 'Maria', 1),
(5, 47234244, 'Gatica', 'Marcos', 1),
(6, 33583430, 'Fernandez', 'Macarena', 1),
(7, 9567254, 'Rivarola', 'Jorge', 1),
(8, 47295443, 'Quiroga', 'Ariel', 1),
(9, 39583434, 'Garro', 'Emiliano', 1),
(10, 28543694, 'Pogliese', 'Javier', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `idAutor` int(11) NOT NULL,
  `isbn` int(11) NOT NULL,
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
(0, 0, 2398, 'Viaje al fin de la noche', 'Novela', 'Denoël', 1932, 1),
(1, 0, 2399, 'Muerte a crédito', 'Ficción', 'deBolsillo', 2021, 1),
(2, 1, 4624, 'El retrato de Dorian Gray', 'Horror', 'AGeBe', 1840, 1),
(3, 1, 4683, 'El Fantasma de Canterville', 'Ficcion', 'AGeBe', 1887, 1),
(4, 2, 6753, 'Romeo y Julieta', 'Tragedia', 'Alma', 1597, 1),
(5, 2, 7876, 'Mucho ruido y pocas nueces', 'Romance', 'Alianza', 2020, 1),
(6, 3, 5875, 'El Alquimista', 'Drama', 'Planeta', 1988, 1),
(7, 3, 5786, 'Once Minutos', 'Ficcion', 'Booket', 2003, 1),
(8, 4, 5981, 'Cuentos de Navidad', 'Ficcion', 'Austral', 1843, 1),
(9, 4, 8732, 'Tiempos Dificiles', 'Ficcion', 'Alianza', 1854, 1),
(10, 5, 4216, 'Un Mundo Feliz', 'Novela', 'Edhasa', 1932, 1),
(11, 5, 1654, 'La Isla', 'Novela', 'Octaedro', 1862, 1),
(12, 5, 5375, 'Los Puertas de la Percepción', 'Ficcion', 'Debolsillo', 2018, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE `multa` (
  `idMulta` int(11) NOT NULL,
  `idPrestamo` int(11) NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `multa`
--

INSERT INTO `multa` (`idMulta`, `idPrestamo`, `fechaInicio`, `fechaFin`) VALUES
(0, 5, '2021-05-15', '0000-00-00'),
(1, 12, '2021-05-25', '0000-00-00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `idEjemplar` int(11) NOT NULL,
  `idLector` int(11) NOT NULL,
  `fechaPrestamo` date NOT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `idEjemplar`, `idLector`, `fechaPrestamo`, `fechaDevolucion`, `activo`) VALUES
(1, 11, 2, '2021-04-22', '2021-05-22', 0),
(2, 4, 4, '2021-04-12', '2021-05-12', 0),
(3, 2, 4, '2021-05-01', '2021-05-31', 1),
(4, 9, 7, '2021-02-01', '2021-03-03', 0),
(5, 7, 9, '2021-04-15', '2021-05-15', 1),
(6, 22, 9, '2021-03-01', '2021-04-01', 0),
(7, 22, 6, '2021-04-01', '2021-05-01', 0),
(8, 6, 1, '2020-12-13', '2021-01-12', 1),
(9, 16, 5, '2021-05-22', '2021-06-21', 1),
(10, 19, 4, '2021-05-25', '2021-06-24', 1),
(11, 20, 4, '2021-05-25', '2021-06-24', 1),
(12, 3, 3, '2021-04-25', '2021-05-25', 1);

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
  ADD PRIMARY KEY (`idMulta`),
  ADD KEY `idLector` (`idPrestamo`),
  ADD KEY `idPrestamo` (`idPrestamo`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `idEjemplar` (`idEjemplar`),
  ADD KEY `idLector` (`idLector`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `idEjemplar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `lector`
--
ALTER TABLE `lector`
  MODIFY `idLector` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `idMulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

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
-- Filtros para la tabla `multa`
--
ALTER TABLE `multa`
  ADD CONSTRAINT `multa_ibfk_1` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`idLector`) REFERENCES `lector` (`idLector`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
