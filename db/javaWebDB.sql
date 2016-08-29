-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jsfapp
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alunos`
--

DROP TABLE IF EXISTS `alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alunos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `matricula` varchar(45) DEFAULT NULL,
  `nota_01` float DEFAULT NULL,
  `nota_02` float DEFAULT NULL,
  `nota_03` float DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdyvfn7ghcndbpw94gkrsn3llf` (`curso_id`),
  CONSTRAINT `FKdyvfn7ghcndbpw94gkrsn3llf` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos`
--

LOCK TABLES `alunos` WRITE;
/*!40000 ALTER TABLE `alunos` DISABLE KEYS */;
INSERT INTO `alunos` VALUES (82,'Vagner Panarello Filho','30222',0,0,0,53),(83,'Caio Pehalver','4234',0,0,0,53),(84,'Eduardo Heinen','312343',0,0,0,53),(85,'Anilton Lopes','454322',0,0,0,53),(86,'Vinicius Torres','344542',0,0,0,53);
/*!40000 ALTER TABLE `alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `escola_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4eil9sfgi0mm7ghvh8pcn5w4` (`escola_id`),
  CONSTRAINT `FK4eil9sfgi0mm7ghvh8pcn5w4` FOREIGN KEY (`escola_id`) REFERENCES `escolas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (53,'Desv. App Java, SOA & IoT','1001',43),(54,'Engenharia de Software e Servições','1002',43),(55,'Engenharia Elétrica','10200',44),(56,'Engenharia Mecânica','10201',44),(57,'Engenharia Quimica','10202',44),(58,'Engenharia Materiais','10203',44),(59,'Big Data (Data Science)','1003',43),(60,'Digital Data Marketing','1004',43),(61,'Digital Games','1005',43),(62,'Master in Information Technology','1006',43);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplinas`
--

DROP TABLE IF EXISTS `disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplinas` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `professor_id` int(11) DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq627jme5tputmc878n3p0iwdk` (`curso_id`),
  KEY `FK65hjssh37rhxxic719byjh0qk` (`professor_id`),
  CONSTRAINT `FK65hjssh37rhxxic719byjh0qk` FOREIGN KEY (`professor_id`) REFERENCES `professores` (`id`),
  CONSTRAINT `FKq627jme5tputmc878n3p0iwdk` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinas`
--

LOCK TABLES `disciplinas` WRITE;
/*!40000 ALTER TABLE `disciplinas` DISABLE KEYS */;
INSERT INTO `disciplinas` VALUES (76,'DES. ANDROID COM CLOUD (AWS)','3123',64,53),(77,'METODOLOGIA DE DESENVOLVIMENTO ÁGIL','3123',67,53),(78,'EMPREENDEDORISMO E INOVAÇÃO','4324',66,53),(79,'RESPONSIVE - WEB (HTML5, AJAX, JQUERY)','4324432',68,53),(80,'ARQUITETURA SOA COM TOGAF','87688',63,53),(81,'EJB 3.0','87867',65,53),(87,'Mecanica dos Fluidos','2312323',64,56);
/*!40000 ALTER TABLE `disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escolas`
--

DROP TABLE IF EXISTS `escolas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escolas` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escolas`
--

LOCK TABLES `escolas` WRITE;
/*!40000 ALTER TABLE `escolas` DISABLE KEYS */;
INSERT INTO `escolas` VALUES (43,'FIAP','Lins de Vanconcelos'),(44,'FEI','Av. Humberto Castelo Branco'),(49,'FIAP - Paulista','Av. Paulista');
/*!40000 ALTER TABLE `escolas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notas` (
  `id` int(11) NOT NULL,
  `nota_01` float DEFAULT NULL,
  `nota_02` float DEFAULT NULL,
  `nota_03` float DEFAULT NULL,
  `aluno_id` int(11) DEFAULT NULL,
  `disciplina_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtril82q8l63osqidsxuaaw4y8` (`aluno_id`),
  KEY `FKb6ei38we61y9yvv8jyjkw8d1b` (`disciplina_id`),
  CONSTRAINT `FKb6ei38we61y9yvv8jyjkw8d1b` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplinas` (`id`),
  CONSTRAINT `FKtril82q8l63osqidsxuaaw4y8` FOREIGN KEY (`aluno_id`) REFERENCES `alunos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (2,1,2,3,82,76);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professores`
--

DROP TABLE IF EXISTS `professores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professores` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `registro` varchar(45) DEFAULT NULL,
  `especializacao` varchar(45) DEFAULT NULL,
  `escola_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlipcxx8s2awwgbbrmk7uh1y0e` (`escola_id`),
  CONSTRAINT `FKlipcxx8s2awwgbbrmk7uh1y0e` FOREIGN KEY (`escola_id`) REFERENCES `escolas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professores`
--

LOCK TABLES `professores` WRITE;
/*!40000 ALTER TABLE `professores` DISABLE KEYS */;
INSERT INTO `professores` VALUES (63,'MARCOS ROBERTO MACEDO','23213','Milonga',43),(64,'HEIDER PINHOLI LOPES','321','AWS',43),(65,'EMILIO CELSO DE SOUZA','34234','JPA-WEB',43),(66,'BRUNO GHIZONI','423423','INOVACAO',43),(67,'FABIO MINORU SAKAMOTOI','323','AGILE',43),(68,'SUELEN GOULARTE CARVALHO','312312','POKEMON',43);
/*!40000 ALTER TABLE `professores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-29  3:11:19
