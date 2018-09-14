-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Set-2018 às 20:44
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--
CREATE DATABASE IF NOT EXISTS `java` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `java`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_aluno`
--

CREATE TABLE `tb_aluno` (
  `idAluno` int(11) NOT NULL,
  `nmAluno` varchar(50) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `idTurma` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `tb_aluno`
--

TRUNCATE TABLE `tb_aluno`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cursos`
--

CREATE TABLE `tb_cursos` (
  `idCurso` int(11) NOT NULL,
  `nmCurso` varchar(50) DEFAULT NULL,
  `periodoCurso` varchar(20) DEFAULT NULL,
  `duracao` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `tb_cursos`
--

TRUNCATE TABLE `tb_cursos`;
--
-- Extraindo dados da tabela `tb_cursos`
--

INSERT INTO `tb_cursos` (`idCurso`, `nmCurso`, `periodoCurso`, `duracao`) VALUES
(1, 'Curso1', 'Matutino', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_professores`
--

CREATE TABLE `tb_professores` (
  `idProfessor` int(50) NOT NULL,
  `nmProfessor` varchar(100) DEFAULT NULL,
  `cpf` int(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `tb_professores`
--

TRUNCATE TABLE `tb_professores`;
--
-- Extraindo dados da tabela `tb_professores`
--

INSERT INTO `tb_professores` (`idProfessor`, `nmProfessor`, `cpf`) VALUES
(1, 'professor1', 123),
(2, 'professor2', 123456789),
(3, 'professor3', 123456),
(4, 'professor4', 112233),
(5, 'professor4', 1122334455),
(6, 'professor', 789456),
(7, 'professor007', 456);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_turmas`
--

CREATE TABLE `tb_turmas` (
  `idTurma` int(11) NOT NULL,
  `nmTurma` varchar(50) NOT NULL,
  `idProfessor` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `tb_turmas`
--

TRUNCATE TABLE `tb_turmas`;
--
-- Extraindo dados da tabela `tb_turmas`
--

INSERT INTO `tb_turmas` (`idTurma`, `nmTurma`, `idProfessor`, `idCurso`) VALUES
(2, 'Turma 2', 5, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_aluno`
--
ALTER TABLE `tb_aluno`
  ADD PRIMARY KEY (`idAluno`),
  ADD KEY `idTurma` (`idTurma`);

--
-- Indexes for table `tb_cursos`
--
ALTER TABLE `tb_cursos`
  ADD PRIMARY KEY (`idCurso`);

--
-- Indexes for table `tb_professores`
--
ALTER TABLE `tb_professores`
  ADD PRIMARY KEY (`idProfessor`);

--
-- Indexes for table `tb_turmas`
--
ALTER TABLE `tb_turmas`
  ADD PRIMARY KEY (`idTurma`),
  ADD KEY `idProfessor` (`idProfessor`),
  ADD KEY `idCurso` (`idCurso`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_aluno`
--
ALTER TABLE `tb_aluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_cursos`
--
ALTER TABLE `tb_cursos`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tb_professores`
--
ALTER TABLE `tb_professores`
  MODIFY `idProfessor` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_turmas`
--
ALTER TABLE `tb_turmas`
  MODIFY `idTurma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
