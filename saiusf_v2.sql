-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-05-2026 a las 12:11:23
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `saiusf_v2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `status` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`id`, `nombre`, `status`) VALUES
(1, 'Informática', 1),
(2, 'Administración de Empresas', 1),
(4, 'Contaduría', 1),
(5, 'Electrónica', 1),
(6, 'Electotecnia', 1),
(7, 'Mecánica', 1),
(8, 'Educación Inicial', 1),
(9, 'Educación Integral', 1),
(10, 'Educación Especial', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `detalles` text DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `duracion_horas` int(11) NOT NULL,
  `id_facilitador` int(11) NOT NULL,
  `id_periodo` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT 1,
  `modalidad` enum('Presencial','Virtual','Semipresencial') DEFAULT 'Presencial',
  `fecha_inicial` date NOT NULL,
  `uuid` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `nombre`, `detalles`, `precio`, `duracion_horas`, `id_facilitador`, `id_periodo`, `status`, `modalidad`, `fecha_inicial`, `uuid`) VALUES
(9, 'cloud', 'awdadadwadadwadwadawdwadwadwadwadwadwadwadwadwadwadadwadwadwadawdwadadaw', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-05', '963aee78-483c-11f1-8368-989096b76016'),
(10, 'PLIUL', 'PLIUL', 25.00, 120, 1, 2, 1, 'Presencial', '2026-05-07', '5f55bba0-4a2c-11f1-853d-989096b76016'),
(12, 'Gestión del tiempo y productividad personal: ser eficaz, eficiente y efectivo', 'Gestión del tiempo y productividad personal: ser eficaz, eficiente y efectivo', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', ''),
(13, 'Comunicación efectiva, oratoria y autoconfianza', 'Comunicación efectiva, oratoria y autoconfianza', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', ''),
(14, 'Excel Avanzado DashBoards, pensamiento creativo para solucionar problemas', 'Excel Avanzado DashBoards, pensamiento creativo para solucionar problemas', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '94207777-4dea-11f1-91a2-989096b76016'),
(15, 'Proyect management para liderar equipo modernos (SCRUM/AGILE)', 'Proyect management para liderar equipo modernos (SCRUM/AGILE)', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '94207cc0-4dea-11f1-91a2-989096b76016'),
(16, 'Power Bi: El Futuro del análisis de datos para la toma de decisiones', 'Power Bi: El Futuro del análisis de datos para la toma de decisiones', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '94207ddd-4dea-11f1-91a2-989096b76016'),
(17, 'Ética profesional y prevención del Lavado de Dinero, el blindaje para tu profesión', 'Ética profesional y prevención del Lavado de Dinero, el blindaje para tu profesión', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '94207e92-4dea-11f1-91a2-989096b76016'),
(18, 'Manejo de softwares Administrativos para la Gestión de Nómina y la orientación al detalle', 'Manejo de softwares Administrativos para la Gestión de Nómina y la orientación al detalle', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421f7f2-4dea-11f1-91a2-989096b76016'),
(19, 'Estrategias de Gestión Fiscal y mecanismos de adaptación tributaria', 'Estrategias de Gestión Fiscal y mecanismos de adaptación tributaria', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421f94d-4dea-11f1-91a2-989096b76016'),
(20, 'Inteligencia Emocional, manejo del estrés y autocontrol', 'Inteligencia Emocional, manejo del estrés y autocontrol', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421f9d3-4dea-11f1-91a2-989096b76016'),
(21, 'Aula Digital 360, Clases que inspiran con Creatividad e innovación', 'Aula Digital 360, Clases que inspiran con Creatividad e innovación', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fa58-4dea-11f1-91a2-989096b76016'),
(22, 'Arduinos: Descomponer problemas grandes para programar hardware', 'Arduinos: Descomponer problemas grandes para programar hardware', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fac3-4dea-11f1-91a2-989096b76016'),
(23, 'Manejo de la Comunicación Técnica Clara y Emprendimiento', 'Manejo de la Comunicación Técnica Clara y Emprendimiento', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fb34-4dea-11f1-91a2-989096b76016'),
(24, 'Soldando soluciones: Integración de habilidades técnicas de soldadura y pensamiento crítico', 'Soldando soluciones: Integración de habilidades técnicas de soldadura y pensamiento crítico', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fba4-4dea-11f1-91a2-989096b76016'),
(25, 'Sistemas de control y PLC', 'Sistemas de control y PLC', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fc05-4dea-11f1-91a2-989096b76016'),
(26, 'Inicia tu camino en programación: De cero a el codigo', 'Inicia tu camino en programación: De cero a el codigo', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fc6e-4dea-11f1-91a2-989096b76016'),
(27, 'Pensamiento Crítico: Pienso y resuelvo problemas', 'Pensamiento Crítico: Pienso y resuelvo problemas', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fcc7-4dea-11f1-91a2-989096b76016'),
(28, 'Ciencia de Datos e IA de Alto Impacto: Pensamiento Crítico para un Mundo Predictivo', 'Ciencia de Datos e IA de Alto Impacto: Pensamiento Crítico para un Mundo Predictivo', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fd28-4dea-11f1-91a2-989096b76016'),
(29, 'Cloud Architect: Estrategías, Costos (AWS/Azafra)', 'Cloud Architect: Estrategías, Costos (AWS/Azafra)', 25.00, 20, 1, 1, 1, 'Presencial', '2026-05-12', '9421fd9b-4dea-11f1-91a2-989096b76016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `id` int(11) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT 'M',
  `procedencia` varchar(100) NOT NULL,
  `semestre` varchar(20) DEFAULT NULL,
  `id_carrera` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT 1,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `uuid` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`id`, `cedula`, `nombre`, `apellido`, `telefono`, `correo`, `sexo`, `procedencia`, `semestre`, `id_carrera`, `status`, `fecha_registro`, `uuid`) VALUES
(1, '33570566', 'Freiber Jose', 'Rodriguez Santiago', '04146740348', 'freibersantiago123@gmail.com', 'M', 'Interno', 'Sexto semestre', 1, 1, '2026-05-04 04:00:00', 'bd43fdc1-476e-11f1-a79c-989096b76016'),
(2, '31829023', 'Eban', 'Marrufo', '04246190061', 'infove15nabe@gmail.com', 'M', 'Interno', 'Sexto semestre', 1, 1, '2026-05-06 04:00:00', 'b4d78e52-491a-11f1-89fe-989096b76016'),
(3, '12345678', 'Jesus', 'Vicuña', '04141234567', 'v@gmail.com', 'M', 'Interno', 'Sexto semestre', 1, 1, '2026-05-07 04:00:00', '343f3833-4a80-11f1-92f2-989096b76016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facilitadores`
--

CREATE TABLE `facilitadores` (
  `id` int(11) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `grado_academico` varchar(20) DEFAULT 'Lcdo.',
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 1,
  `uuid` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `facilitadores`
--

INSERT INTO `facilitadores` (`id`, `cedula`, `nombre`, `apellido`, `grado_academico`, `telefono`, `correo`, `status`, `uuid`) VALUES
(1, '12345678', 'Luis', 'Perez', 'Ing.', '04141231231', 'luis@gmail.com', 1, '3e9495c4-477c-11f1-a79c-989096b76016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `id` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `fecha_inscripcion` date DEFAULT curdate(),
  `estado` enum('En Curso','Aprobado','Reprobado') DEFAULT 'En Curso',
  `status` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`id`, `id_estudiante`, `id_curso`, `fecha_inscripcion`, `estado`, `status`) VALUES
(6, 1, 29, '2026-05-11', 'Aprobado', 1),
(7, 2, 29, '2026-05-11', 'Aprobado', 1),
(9, 3, 29, '2026-05-11', 'Aprobado', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodos`
--

CREATE TABLE `periodos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `status` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `periodos`
--

INSERT INTO `periodos` (`id`, `nombre`, `fecha_inicio`, `status`) VALUES
(1, '1-2026', '2026-05-05', 1),
(2, '2-2026', '2026-09-02', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` enum('Coordinador','Beca','Soporte') NOT NULL,
  `status` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `name`, `username`, `password`, `rol`, `status`) VALUES
(1, 'Freiber Rodriguez', 'admin', 'admin', 'Soporte', 1),
(3, 'Carmelo Boscan', 'Carmelo', 'Carmelo', 'Coordinador', 1),
(4, 'prueba', 'prueba', 'beca', 'Beca', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_facilitador` (`id_facilitador`),
  ADD KEY `id_periodo` (`id_periodo`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cedula` (`cedula`),
  ADD KEY `id_carrera` (`id_carrera`);

--
-- Indices de la tabla `facilitadores`
--
ALTER TABLE `facilitadores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cedula` (`cedula`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_estudiante` (`id_estudiante`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Indices de la tabla `periodos`
--
ALTER TABLE `periodos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=241;

--
-- AUTO_INCREMENT de la tabla `facilitadores`
--
ALTER TABLE `facilitadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `periodos`
--
ALTER TABLE `periodos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`id_facilitador`) REFERENCES `facilitadores` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cursos_ibfk_2` FOREIGN KEY (`id_periodo`) REFERENCES `periodos` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `inscripciones_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id`),
  ADD CONSTRAINT `inscripciones_ibfk_2` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
