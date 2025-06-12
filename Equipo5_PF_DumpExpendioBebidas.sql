CREATE DATABASE  IF NOT EXISTS `expendio_bebidas` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `expendio_bebidas`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: expendio_bebidas
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id_admin` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (5,'Debian Yael','$2a$10$QNsI34C2jokYNK6udleIvesMcsSuSTnWrwXaZ4vSG.kcHkStd398m','yael@gmail.com'),(7,'Mauricio','$2a$10$8HL6pXLcWSF0ic0BQQSDQeS5IMT7teXb4/NXdIIAXsBku39Edjr0y','mauricio@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `analisis_ventas`
--

DROP TABLE IF EXISTS `analisis_ventas`;
/*!50001 DROP VIEW IF EXISTS `analisis_ventas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `analisis_ventas` AS SELECT 
 1 AS `id_bebida`,
 1 AS `producto`,
 1 AS `categoria`,
 1 AS `stock_actual`,
 1 AS `stock_minimo`,
 1 AS `clientes_unicos`,
 1 AS `cantidad_total_vendida`,
 1 AS `ingresos_totales`,
 1 AS `estado_venta`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebida` (
  `id_bebida` int NOT NULL AUTO_INCREMENT,
  `precio_unitario` decimal(10,0) NOT NULL,
  `stock_minimo` int NOT NULL,
  `stock_actual` int NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `tamaño` int NOT NULL,
  `categoria` enum('REFRESCO','JUGO','AGUA','CERVEZA','ENERGÉTICA','TE','CAFE','LACTEO') NOT NULL,
  PRIMARY KEY (`id_bebida`),
  UNIQUE KEY `nombre_unico` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (1,15,10,20,'Coca-Cola',600,'REFRESCO'),(2,14,8,20,'Pepsi',600,'REFRESCO'),(3,20,8,20,'Jugo de Naranja',500,'JUGO'),(4,18,6,11,'Jugo de Manzana',500,'JUGO'),(5,10,15,20,'Agua Mineral',500,'AGUA'),(6,22,12,12,'Agua de Coco',500,'AGUA'),(7,25,12,22,'Cerveza Corona',355,'CERVEZA'),(8,24,10,22,'Cerveza Modelo',355,'CERVEZA'),(9,18,5,20,'Café Americano',250,'CAFE'),(10,22,5,23,'Café Latte',250,'CAFE'),(11,12,7,22,'Té Verde',500,'TE'),(12,10,6,20,'Té de Manzanilla',500,'TE'),(15,25,9,20,'Leche de Almendras',1000,'LACTEO'),(16,18,10,20,'Sprite',600,'REFRESCO'),(17,16,8,20,'Fanta',600,'REFRESCO'),(18,22,7,20,'Jugo de Piña',500,'JUGO'),(19,24,9,22,'Cerveza Victoria',355,'CERVEZA'),(20,26,8,24,'Cerveza Heineken',350,'CERVEZA'),(21,15,12,10,'Agua Purificada',1000,'AGUA'),(22,20,6,22,'Café Mocha',250,'CAFE'),(23,14,5,23,'Té Negro',500,'TE'),(25,25,10,20,'Leche de Soya',1000,'LACTEO');
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `paterno` varchar(15) NOT NULL,
  `materno` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `rfc` varchar(13) DEFAULT NULL,
  `codigo_postal` int NOT NULL,
  `colonia` varchar(30) NOT NULL,
  `ciudad` varchar(25) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'CLIENTE GENERAL','-','-','clientegeneral@expendio.com','-','CLGE00000012D',0,'-','-','-'),(2,'María','López','Martínez','maria.lopez@gmail.com','2288402140','LOMM900202',91020,'Obrero Campesina','Xalapa','Veracruz'),(3,'Carlos','García','Sánchez','carlos.garcia@outlook.com','2284950320','GASC850303',91030,'Jose Cardel','Xalapa','Veracruz'),(4,'Ana','Martínez','Fernández','ana.martinez@hotmail.com','2287654321','MAFA920404',91040,'Revolución','Xalapa','Veracruz'),(5,'Luis','Hernández','Gutiérrez','luis.hernandez@gmail.com','2298765432','HEGL870505',91700,'Boca del Río','Boca del Río','Veracruz'),(6,'Patricia','Díaz','Vázquez','patricia.diaz@outlook.com','2289876543','DIVP950606',91050,'Mártires de Chicago','Xalapa','Veracruz'),(7,'Jorge','Ramírez','Santos','jorge.ramirez@gmail.com','2291234567','RASJ880707',91720,'Playa Linda','Veracruz','Veracruz'),(8,'Sofía','Castro','Mendoza','sofia.castro@hotmail.com','2282345678','CAMS900808',91060,'Lomas Verdes','Xalapa','Veracruz');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `folio` varchar(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` decimal(10,0) NOT NULL,
  `id_pedido_proveedor` int NOT NULL,
  PRIMARY KEY (`folio`,`id_pedido_proveedor`),
  KEY `fk_Compra_Pedido_Proveedor1_idx` (`id_pedido_proveedor`),
  CONSTRAINT `fk_Compra_Pedido_Proveedor1` FOREIGN KEY (`id_pedido_proveedor`) REFERENCES `pedido_proveedor` (`id_pedido_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES ('C0010296857','2025-06-11',602,19),('C0046833791','2025-06-11',406,15),('C0176108037','2025-06-11',392,16),('C0399363224','2025-06-11',280,18),('C0783679713','2025-06-11',3304,20),('C0936709592','2025-06-11',351,17),('FAC20230001','2025-05-28',105,10),('FAC20230003','2025-05-28',179,12);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_actualizar_stock_compra` AFTER INSERT ON `compra` FOR EACH ROW BEGIN
    DECLARE v_id_bebida INT;
    DECLARE v_cantidad INT;
    DECLARE done INT DEFAULT FALSE;
    
    -- Cursor para recorrer los detalles del pedido de proveedor
    DECLARE cur_detalles CURSOR FOR
        SELECT id_bebida, cantidad
        FROM Detalle_Pedido_Proveedor
        WHERE id_pedido_proveedor = NEW.id_pedido_proveedor;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    -- Se eliminan las sentencias de transacción explícitas
    OPEN cur_detalles;
    
    read_loop: LOOP
        FETCH cur_detalles INTO v_id_bebida, v_cantidad;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Actualizar stock de la bebida
        UPDATE Bebida 
        SET stock_actual = stock_actual + v_cantidad
        WHERE id_bebida = v_id_bebida;
        
    END LOOP;
    
    CLOSE cur_detalles;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `detalle_pedido_cliente`
--

DROP TABLE IF EXISTS `detalle_pedido_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedido_cliente` (
  `id_bebida` int NOT NULL,
  `id_pedido_cliente` int NOT NULL,
  `cantidad` int NOT NULL,
  `subtotal` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_bebida`,`id_pedido_cliente`),
  KEY `fk_Bebida_has_Pedido_Cliente_Pedido_Cliente1_idx` (`id_pedido_cliente`),
  KEY `fk_Bebida_has_Pedido_Cliente_Bebida1_idx` (`id_bebida`),
  CONSTRAINT `fk_Bebida_has_Pedido_Cliente_Bebida1` FOREIGN KEY (`id_bebida`) REFERENCES `bebida` (`id_bebida`),
  CONSTRAINT `fk_detalle_pedido` FOREIGN KEY (`id_pedido_cliente`) REFERENCES `pedido_cliente` (`id_pedido_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido_cliente`
--

LOCK TABLES `detalle_pedido_cliente` WRITE;
/*!40000 ALTER TABLE `detalle_pedido_cliente` DISABLE KEYS */;
INSERT INTO `detalle_pedido_cliente` VALUES (1,1,5,75),(1,10,2,30),(1,100,2,30),(1,118,2,27),(1,123,2,27),(1,124,2,27),(1,125,2,27),(1,128,2,27),(1,129,2,27),(1,130,2,27),(1,167,1,14),(2,1,3,60),(2,206,5,60),(2,208,2,24),(3,2,10,100),(3,114,3,60),(3,115,3,60),(4,3,8,200),(4,127,3,54),(5,176,2,18),(5,178,2,18),(5,179,2,18),(5,180,2,18),(5,181,2,18),(5,182,2,18),(5,183,2,18),(5,185,2,18),(5,186,2,18),(5,187,2,18),(5,188,2,18),(5,199,2,18),(5,202,4,36),(6,133,1,22),(6,134,1,22),(6,135,1,22),(6,211,5,110),(7,202,5,113),(7,207,6,135),(8,199,3,65),(8,200,3,65),(9,146,1,18),(9,147,1,18),(11,8,8,96),(11,212,4,48),(12,154,3,30),(12,157,1,10),(12,158,1,10),(15,209,4,85),(15,210,2,50),(16,161,1,18),(16,162,1,18),(16,163,1,18),(16,164,1,18),(16,165,1,18),(16,166,1,18),(16,177,1,18),(16,184,1,18),(17,203,6,86),(18,213,2,44),(19,169,1,22),(19,171,1,22),(19,173,1,22),(19,175,2,43),(20,170,1,23),(20,213,2,52),(21,107,3,45),(21,108,3,45),(21,109,3,45),(21,110,3,45),(21,113,3,45),(23,204,1,13),(25,205,5,113);
/*!40000 ALTER TABLE `detalle_pedido_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedido_proveedor`
--

DROP TABLE IF EXISTS `detalle_pedido_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedido_proveedor` (
  `id_pedido_proveedor` int NOT NULL,
  `id_bebida` int NOT NULL,
  `subtotal` decimal(10,0) NOT NULL,
  `cantidad` int NOT NULL,
  `precio_compra` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_pedido_proveedor`,`id_bebida`),
  KEY `fk_Pedido_Proveedor_has_Bebida_Bebida1_idx` (`id_bebida`),
  KEY `fk_Pedido_Proveedor_has_Bebida_Pedido_Proveedor1_idx` (`id_pedido_proveedor`),
  CONSTRAINT `fk_Pedido_Proveedor_has_Bebida_Bebida1` FOREIGN KEY (`id_bebida`) REFERENCES `bebida` (`id_bebida`),
  CONSTRAINT `fk_Pedido_Proveedor_has_Bebida_Pedido_Proveedor1` FOREIGN KEY (`id_pedido_proveedor`) REFERENCES `pedido_proveedor` (`id_pedido_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido_proveedor`
--

LOCK TABLES `detalle_pedido_proveedor` WRITE;
/*!40000 ALTER TABLE `detalle_pedido_proveedor` DISABLE KEYS */;
INSERT INTO `detalle_pedido_proveedor` VALUES (10,1,105,10,11),(12,3,70,5,14),(12,5,56,8,7),(12,7,53,3,18),(15,1,210,20,11),(15,2,196,20,14),(16,3,252,18,14),(16,5,140,20,10),(17,18,246,16,15),(17,21,105,10,15),(18,4,126,10,13),(18,6,154,10,22),(19,15,350,20,18),(19,16,252,20,18),(20,7,350,20,18),(20,8,336,20,24),(20,9,252,20,18),(20,10,308,20,22),(20,11,168,20,12),(20,12,140,20,10),(20,17,224,20,16),(20,19,336,20,24),(20,20,364,20,26),(20,22,280,20,20),(20,23,196,20,14),(20,25,350,20,25);
/*!40000 ALTER TABLE `detalle_pedido_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (3,'Abraham Cano Ramírez','$2a$10$bed25OHJJNR5XfbuKu9zZ.mOf.CXQ8IDWga9GU9/wVT9cnPMyVchm','abraham@gmail.com'),(4,'Guillermo Velázquez Rosiles','$2a$10$cFFvnWZ48MoxCJOK0CmcU.m33RP22OO8ag/Qbm2xXMD9uRTiJPQBC','guillermo@gmail.com'),(6,'Uriel Cendón Díaz','$2a$10$ojscMkp/3ZnfJ/p4WywFWOMdvhQ20Lnxs.jdHbGZmrUVGaWplHahi','uriel@gmail.com');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_cliente`
--

DROP TABLE IF EXISTS `pedido_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_cliente` (
  `id_pedido_cliente` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` enum('PENDIENTE','ENTREGADO','CANCELADO') NOT NULL DEFAULT 'PENDIENTE',
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id_pedido_cliente`),
  UNIQUE KEY `id_pedido_cliente` (`id_pedido_cliente`,`id_cliente`),
  KEY `fk_Pedido_Cliente_Cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_Pedido_Cliente_Cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_cliente`
--

LOCK TABLES `pedido_cliente` WRITE;
/*!40000 ALTER TABLE `pedido_cliente` DISABLE KEYS */;
INSERT INTO `pedido_cliente` VALUES (1,'2023-10-01',100.00,'ENTREGADO',1),(2,'2023-10-02',150.00,'PENDIENTE',2),(3,'2023-10-03',200.00,'CANCELADO',3),(8,'2025-05-28',96.00,'PENDIENTE',2),(10,'2025-05-28',0.00,'PENDIENTE',1),(100,'2025-05-28',30.00,'ENTREGADO',1),(107,'2023-11-15',52.00,'ENTREGADO',3),(108,'2023-11-15',52.00,'ENTREGADO',3),(109,'2023-11-15',52.00,'ENTREGADO',3),(110,'2023-11-15',52.00,'ENTREGADO',3),(113,'2023-11-15',52.00,'ENTREGADO',3),(114,'2023-11-15',70.00,'ENTREGADO',3),(115,'2023-11-15',70.00,'ENTREGADO',3),(118,'2025-05-30',31.00,'ENTREGADO',3),(123,'2025-05-30',31.00,'ENTREGADO',3),(124,'2025-05-30',31.00,'ENTREGADO',3),(125,'2025-05-30',31.00,'ENTREGADO',3),(127,'2023-11-15',63.00,'ENTREGADO',3),(128,'2025-05-30',31.00,'ENTREGADO',3),(129,'2025-05-30',31.00,'ENTREGADO',3),(130,'2025-05-30',31.00,'ENTREGADO',3),(133,'2025-05-30',26.00,'ENTREGADO',3),(134,'2025-05-30',26.00,'ENTREGADO',3),(135,'2025-05-30',26.00,'ENTREGADO',3),(146,'2025-05-30',21.00,'ENTREGADO',3),(147,'2025-05-30',21.00,'ENTREGADO',3),(154,'2023-11-15',35.00,'ENTREGADO',3),(157,'2023-11-15',12.00,'ENTREGADO',3),(158,'2023-11-15',12.00,'ENTREGADO',3),(161,'2023-11-15',21.00,'ENTREGADO',3),(162,'2023-11-15',21.00,'ENTREGADO',3),(163,'2023-11-15',21.00,'ENTREGADO',3),(164,'2023-11-15',21.00,'ENTREGADO',3),(165,'2025-05-30',21.00,'ENTREGADO',4),(166,'2025-05-30',21.00,'ENTREGADO',4),(167,'2023-11-15',16.00,'ENTREGADO',1),(169,'2023-11-15',25.00,'ENTREGADO',1),(170,'2023-11-15',27.00,'ENTREGADO',1),(171,'2023-11-15',25.00,'ENTREGADO',1),(173,'2023-11-15',25.00,'ENTREGADO',1),(175,'2023-01-01',50.00,'ENTREGADO',1),(176,'2023-12-01',21.00,'ENTREGADO',1),(177,'2025-05-31',21.00,'ENTREGADO',4),(178,'2023-12-15',21.00,'ENTREGADO',1),(179,'2023-12-15',21.00,'ENTREGADO',1),(180,'2023-12-15',21.00,'ENTREGADO',1),(181,'2023-12-15',21.00,'ENTREGADO',1),(182,'2023-12-15',21.00,'ENTREGADO',1),(183,'2023-12-15',21.00,'ENTREGADO',1),(184,'2025-05-31',21.00,'ENTREGADO',4),(185,'2023-12-15',21.00,'ENTREGADO',1),(186,'2023-12-15',21.00,'ENTREGADO',1),(187,'2023-12-15',21.00,'ENTREGADO',1),(188,'2023-12-15',21.00,'ENTREGADO',1),(189,'2023-12-15',0.00,'PENDIENTE',1),(190,'2023-12-15',0.00,'ENTREGADO',1),(191,'2023-12-15',0.00,'PENDIENTE',1),(192,'2023-12-15',0.00,'PENDIENTE',1),(193,'2023-12-15',0.00,'CANCELADO',1),(194,'2023-12-15',0.00,'PENDIENTE',1),(195,'2023-12-15',0.00,'CANCELADO',1),(196,'2023-12-15',0.00,'PENDIENTE',1),(197,'2023-12-15',0.00,'PENDIENTE',1),(198,'2023-12-15',0.00,'PENDIENTE',1),(199,'2023-12-15',96.00,'ENTREGADO',1),(200,'2023-12-15',75.00,'CANCELADO',1),(202,'2025-06-10',172.26,'ENTREGADO',1),(203,'2025-06-10',100.22,'ENTREGADO',1),(204,'2025-06-10',14.62,'ENTREGADO',1),(205,'2025-06-10',130.50,'ENTREGADO',1),(206,'2025-06-10',69.02,'ENTREGADO',1),(207,'2025-06-10',156.60,'ENTREGADO',1),(208,'2025-06-10',27.61,'ENTREGADO',2),(209,'2025-06-10',98.60,'PENDIENTE',2),(210,'2025-06-10',58.00,'ENTREGADO',3),(211,'2025-06-10',127.60,'PENDIENTE',6),(212,'2025-06-10',55.68,'CANCELADO',8),(213,'2025-06-11',111.36,'CANCELADO',5);
/*!40000 ALTER TABLE `pedido_cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_generar_pedidos_automaticos` BEFORE UPDATE ON `pedido_cliente` FOR EACH ROW BEGIN
    DECLARE v_id_bebida INT;
    DECLARE v_cantidad_vendida INT;
    DECLARE v_stock_actual INT;
    DECLARE v_stock_minimo INT;
    DECLARE v_nombre_bebida VARCHAR(20);
    DECLARE v_rfc_proveedor VARCHAR(13);
    DECLARE v_cantidad_pedir INT;
    DECLARE v_mensaje_error VARCHAR(255);
    DECLARE done INT DEFAULT FALSE;

    -- Cursor para recorrer los detalles del pedido
    DECLARE cur_detalles CURSOR FOR
        SELECT id_bebida, cantidad
        FROM detalle_pedido_cliente
        WHERE id_pedido_cliente = NEW.id_pedido_cliente;

    -- Manejador para fin de cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Solo ejecuta cuando el estado cambia a COMPLETADO
    IF NEW.estado = 'COMPLETADO' AND OLD.estado != 'COMPLETADO' THEN

        -- Validar stock suficiente
        OPEN cur_detalles;

        read_loop: LOOP
            FETCH cur_detalles INTO v_id_bebida, v_cantidad_vendida;
            IF done THEN
                LEAVE read_loop;
            END IF;

            SELECT stock_actual, stock_minimo, nombre
            INTO v_stock_actual, v_stock_minimo, v_nombre_bebida
            FROM bebida
            WHERE id_bebida = v_id_bebida
            FOR UPDATE;

            IF v_stock_actual < v_cantidad_vendida THEN
                SET v_mensaje_error = CONCAT(
                    'Stock insuficiente para ', v_nombre_bebida,
                    '. Stock actual: ', v_stock_actual,
                    ', solicitado: ', v_cantidad_vendida
                );
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_mensaje_error;
            END IF;
        END LOOP;

        CLOSE cur_detalles;
        SET done = FALSE;

        -- Actualizar stock y generar pedidos si es necesario
        OPEN cur_detalles;

        read_loop2: LOOP
            FETCH cur_detalles INTO v_id_bebida, v_cantidad_vendida;
            IF done THEN
                LEAVE read_loop2;
            END IF;

            -- Actualizar stock
            UPDATE bebida
            SET stock_actual = stock_actual - v_cantidad_vendida
            WHERE id_bebida = v_id_bebida;

            -- Revisar stock luego de restar
            SELECT stock_actual, stock_minimo
            INTO v_stock_actual, v_stock_minimo
            FROM bebida
            WHERE id_bebida = v_id_bebida;

            -- Si el stock es igual o menor al mínimo, genera pedido automático
            IF v_stock_actual <= v_stock_minimo THEN
                CALL sp_obtener_proveedor_bebida(v_id_bebida, v_rfc_proveedor);

                SET v_cantidad_pedir = (v_stock_minimo * 3) - v_stock_actual;

                IF v_cantidad_pedir < (v_stock_minimo * 2) THEN
                    SET v_cantidad_pedir = v_stock_minimo * 2;
                END IF;

                CALL sp_crear_pedido_automatico(v_id_bebida, v_cantidad_pedir, v_rfc_proveedor);
            END IF;
        END LOOP;

        CLOSE cur_detalles;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pedido_proveedor`
--

DROP TABLE IF EXISTS `pedido_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_proveedor` (
  `id_pedido_proveedor` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` decimal(10,0) NOT NULL,
  `estado` enum('PENDIENTE','RECIBIDO','CANCELADO') NOT NULL DEFAULT 'PENDIENTE',
  `rfc` varchar(13) NOT NULL,
  PRIMARY KEY (`id_pedido_proveedor`,`rfc`),
  KEY `fk_Pedido_Proveedor_Proveedor1_idx` (`rfc`),
  CONSTRAINT `fk_Pedido_Proveedor_Proveedor1` FOREIGN KEY (`rfc`) REFERENCES `proveedor` (`rfc`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_proveedor`
--

LOCK TABLES `pedido_proveedor` WRITE;
/*!40000 ALTER TABLE `pedido_proveedor` DISABLE KEYS */;
INSERT INTO `pedido_proveedor` VALUES (10,'2025-05-28',105,'RECIBIDO','BEBE770101B12'),(11,'2025-05-28',0,'CANCELADO','JUGO990303J34'),(12,'2025-05-28',179,'RECIBIDO','JUTR120101BBC'),(14,'2025-05-28',0,'CANCELADO','BEBE770101B12'),(15,'2025-06-11',406,'RECIBIDO','BEBE770101B12'),(16,'2025-06-11',392,'RECIBIDO','JUGO990303J34'),(17,'2025-06-11',351,'RECIBIDO','JUTR120101BBC'),(18,'2025-06-11',280,'RECIBIDO','JUGO990303J34'),(19,'2025-06-11',602,'RECIBIDO','JUGO990303J34'),(20,'2025-06-11',3304,'RECIBIDO','JUTR120101BBC');
/*!40000 ALTER TABLE `pedido_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productos_mas_vendidos`
--

DROP TABLE IF EXISTS `productos_mas_vendidos`;
/*!50001 DROP VIEW IF EXISTS `productos_mas_vendidos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos_mas_vendidos` AS SELECT 
 1 AS `id_bebida`,
 1 AS `nombre`,
 1 AS `total_vendida`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `productos_menos_vendidos`
--

DROP TABLE IF EXISTS `productos_menos_vendidos`;
/*!50001 DROP VIEW IF EXISTS `productos_menos_vendidos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos_menos_vendidos` AS SELECT 
 1 AS `id_bebida`,
 1 AS `nombre`,
 1 AS `total_vendida`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `productos_no_vendidos`
--

DROP TABLE IF EXISTS `productos_no_vendidos`;
/*!50001 DROP VIEW IF EXISTS `productos_no_vendidos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos_no_vendidos` AS SELECT 
 1 AS `id_bebida`,
 1 AS `producto`,
 1 AS `id_cliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `productos_stock_bajo`
--

DROP TABLE IF EXISTS `productos_stock_bajo`;
/*!50001 DROP VIEW IF EXISTS `productos_stock_bajo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos_stock_bajo` AS SELECT 
 1 AS `id_bebida`,
 1 AS `nombre`,
 1 AS `stock_actual`,
 1 AS `stock_minimo`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS `promocion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocion` (
  `id_promocion` int NOT NULL AUTO_INCREMENT,
  `porcentaje` double NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`id_promocion`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

LOCK TABLES `promocion` WRITE;
/*!40000 ALTER TABLE `promocion` DISABLE KEYS */;
INSERT INTO `promocion` VALUES (1,10,'2023-10-15','2026-12-31'),(2,15,'2023-10-31','2026-12-31'),(3,15,'2025-07-11','2025-08-11'),(4,15,'2025-07-11','2025-08-11'),(5,15,'2025-06-12','2025-07-12'),(6,15,'2025-09-11','2025-10-12'),(7,35,'2025-06-12','2025-06-13');
/*!40000 ALTER TABLE `promocion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocion_bebida`
--

DROP TABLE IF EXISTS `promocion_bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocion_bebida` (
  `id_bebida` int NOT NULL,
  `id_promocion` int NOT NULL,
  PRIMARY KEY (`id_bebida`,`id_promocion`),
  KEY `fk_Bebida_has_Promocion_Promocion1_idx` (`id_promocion`),
  KEY `fk_Bebida_has_Promocion_Bebida1_idx` (`id_bebida`),
  CONSTRAINT `fk_Bebida_has_Promocion_Bebida1` FOREIGN KEY (`id_bebida`) REFERENCES `bebida` (`id_bebida`),
  CONSTRAINT `fk_Bebida_has_Promocion_Promocion1` FOREIGN KEY (`id_promocion`) REFERENCES `promocion` (`id_promocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion_bebida`
--

LOCK TABLES `promocion_bebida` WRITE;
/*!40000 ALTER TABLE `promocion_bebida` DISABLE KEYS */;
INSERT INTO `promocion_bebida` VALUES (1,1),(2,2),(3,4),(1,5),(25,6);
/*!40000 ALTER TABLE `promocion_bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocion_cliente`
--

DROP TABLE IF EXISTS `promocion_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocion_cliente` (
  `id_cliente` int NOT NULL,
  `id_promocion` int NOT NULL,
  PRIMARY KEY (`id_cliente`,`id_promocion`),
  KEY `fk_Cliente_has_Promocion_Promocion1_idx` (`id_promocion`),
  KEY `fk_Cliente_has_Promocion_Cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_Cliente_has_Promocion_Cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_Cliente_has_Promocion_Promocion1` FOREIGN KEY (`id_promocion`) REFERENCES `promocion` (`id_promocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion_cliente`
--

LOCK TABLES `promocion_cliente` WRITE;
/*!40000 ALTER TABLE `promocion_cliente` DISABLE KEYS */;
INSERT INTO `promocion_cliente` VALUES (1,1),(2,2),(1,3),(8,7);
/*!40000 ALTER TABLE `promocion_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `rfc` varchar(13) NOT NULL,
  `razon_social` varchar(25) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `codigo_postal` int NOT NULL,
  `colonia` varchar(30) NOT NULL,
  `ciudad` varchar(25) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`rfc`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('BEBE770101B12','Bebidas del Golfo','2291122885','ventas@bebidasgolfo.com',91700,'Industrial','Veracruz','Veracruz'),('JUGO990303J34','Jugos Naturales SA de CV','2293344556','pedidos@jugosnaturales.com',91710,'Boca del Río','Boca del Río','Veracruz'),('JUTR120101BBC','Jugo Tropick SA de CV','2288156060','ventas@jugotropick.com',91030,'José Cardel','Xalapa','Veracruz');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `folio` varchar(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_pedido_cliente` int NOT NULL,
  PRIMARY KEY (`id_venta`),
  UNIQUE KEY `id_pedido_cliente` (`id_pedido_cliente`),
  KEY `fk_Venta_Pedido_Cliente1_idx` (`id_pedido_cliente`),
  CONSTRAINT `fk_venta_pedido` FOREIGN KEY (`id_pedido_cliente`) REFERENCES `pedido_cliente` (`id_pedido_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'FOLIO001','2023-10-01',1),(2,'FOLIO002','2023-10-02',2),(3,'FOLIO003','2023-10-03',3),(4,'V250528001','2025-05-28',100),(5,'','2025-05-30',107),(6,'','2025-05-30',108),(7,'','2025-05-30',109),(8,'','2025-05-30',110),(9,'FOLIO123','2025-05-30',113),(10,'FOLIO123','2025-05-30',114),(11,'FOLIO123','2025-05-30',115),(12,'','2025-05-30',125),(13,'FOLIO123','2025-05-30',127),(14,'','2025-05-30',128),(15,'','2025-05-30',129),(16,'','2025-05-30',130),(17,'','2025-05-30',133),(18,'','2025-05-30',134),(19,'','2025-05-30',135),(20,'','2025-05-30',146),(21,'','2025-05-30',147),(22,'FOLIO123','2025-05-30',154),(23,'FOLIO123','2025-05-30',157),(24,'FOLIO123','2025-05-30',158),(25,'FOLIO123','2025-05-30',161),(26,'FOLIO123','2025-05-30',162),(27,'FOLIO123','2025-05-30',163),(28,'FOLIO123','2025-05-30',164),(29,'','2025-05-30',165),(30,'FOLIO1','2025-05-30',166),(31,'TEST123','2025-05-30',167),(32,'TEST123','2025-05-30',169),(33,'TEST123','2025-05-30',170),(34,'TEST123','2025-05-30',171),(35,'TEST123','2025-05-30',173),(36,'TEST123','2025-05-31',175),(37,'FOLIO123','2025-05-31',176),(38,'FOLIO1','2025-05-31',177),(39,'TEST123','2025-05-31',178),(40,'TEST123','2025-05-31',179),(41,'FOLIO123','2025-05-31',180),(42,'FOLIO123','2025-05-31',181),(43,'FOLIO123','2025-05-31',182),(44,'FOLIO123','2025-05-31',183),(45,'FOLIO1','2025-05-31',184),(46,'FOLIO123','2025-05-31',185),(47,'TEST123','2025-05-31',186),(48,'FOLIO123','2025-05-31',187),(49,'TEST123','2025-05-31',188),(50,'V0787498228','2025-06-10',203),(51,'V0787498228','2025-06-10',204),(52,'V0787498228','2025-06-10',205),(53,'V0791448699','2025-06-10',206),(54,'V0572382115','2025-06-10',207);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `ventas_por_producto`
--

DROP TABLE IF EXISTS `ventas_por_producto`;
/*!50001 DROP VIEW IF EXISTS `ventas_por_producto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ventas_por_producto` AS SELECT 
 1 AS `id_bebida`,
 1 AS `producto`,
 1 AS `cantidad_vendida`,
 1 AS `total_ventas`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_stock_bajo`
--

DROP TABLE IF EXISTS `vw_stock_bajo`;
/*!50001 DROP VIEW IF EXISTS `vw_stock_bajo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_stock_bajo` AS SELECT 
 1 AS `id_bebida`,
 1 AS `nombre`,
 1 AS `categoria`,
 1 AS `tamaño`,
 1 AS `stock_actual`,
 1 AS `stock_minimo`,
 1 AS `precio_unitario`,
 1 AS `deficit_stock`,
 1 AS `estado_stock`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_ventas_anuales`
--

DROP TABLE IF EXISTS `vw_ventas_anuales`;
/*!50001 DROP VIEW IF EXISTS `vw_ventas_anuales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_ventas_anuales` AS SELECT 
 1 AS `año`,
 1 AS `total_anual`,
 1 AS `cantidad_ventas`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_ventas_mensuales`
--

DROP TABLE IF EXISTS `vw_ventas_mensuales`;
/*!50001 DROP VIEW IF EXISTS `vw_ventas_mensuales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_ventas_mensuales` AS SELECT 
 1 AS `año`,
 1 AS `mes`,
 1 AS `total_mensual`,
 1 AS `cantidad_ventas`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_ventas_semanales`
--

DROP TABLE IF EXISTS `vw_ventas_semanales`;
/*!50001 DROP VIEW IF EXISTS `vw_ventas_semanales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_ventas_semanales` AS SELECT 
 1 AS `año`,
 1 AS `semana`,
 1 AS `total_semanal`,
 1 AS `cantidad_ventas`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'expendio_bebidas'
--

--
-- Dumping routines for database 'expendio_bebidas'
--
/*!50003 DROP PROCEDURE IF EXISTS `añadir_detalle_pedido_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `añadir_detalle_pedido_proveedor`(
    IN p_id_pedido_proveedor INT,
    IN p_id_bebida INT,
    IN p_cantidad INT
)
BEGIN
    DECLARE v_precio_unitario DECIMAL(10,2);
    DECLARE v_subtotal DECIMAL(10,2);
    DECLARE v_mensaje_error VARCHAR(255);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;
    
    SELECT precio_unitario INTO v_precio_unitario
    FROM bebida
    WHERE id_bebida = p_id_bebida;

    IF v_precio_unitario IS NULL THEN
        SET v_mensaje_error = CONCAT('La bebida con ID ', p_id_bebida, ' no existe.');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_mensaje_error;
    END IF;

    SET v_subtotal = v_precio_unitario * p_cantidad* 0.7;

    IF EXISTS (
        SELECT 1 FROM detalle_pedido_proveedor
        WHERE id_pedido_proveedor = p_id_pedido_proveedor AND id_bebida = p_id_bebida
    ) THEN
        UPDATE detalle_pedido_proveedor
        SET 
            cantidad = cantidad + p_cantidad,
            subtotal = subtotal + v_subtotal
        WHERE id_pedido_proveedor = p_id_pedido_proveedor AND id_bebida = p_id_bebida;
    ELSE
        INSERT INTO detalle_pedido_proveedor (
            id_pedido_proveedor, id_bebida, subtotal, cantidad, precio_compra
        )
        VALUES (
            p_id_pedido_proveedor, p_id_bebida, v_subtotal, p_cantidad, v_precio_unitario
        );
    END IF;
	
    UPDATE pedido_proveedor
    SET total = total + v_subtotal
    WHERE id_pedido_proveedor = p_id_pedido_proveedor;

    COMMIT;
    
    SELECT 
        p_id_pedido_proveedor AS pedido,
        p_id_bebida AS bebida,
        p_cantidad AS cantidad_agregada,
        v_precio_unitario AS precio_unitario,
        v_subtotal AS subtotal_agregado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `bebida_mas_vendida_a_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bebida_mas_vendida_a_cliente`(
    IN p_id_cliente INT,
    OUT p_bebida_nombre VARCHAR(20),
    OUT p_ventas_count INT
)
BEGIN
    SELECT 
        b.nombre,
        SUM(dpc.cantidad) AS total_vendido
    INTO 
        p_bebida_nombre,
        p_ventas_count
    FROM 
        detalle_pedido_cliente dpc
    JOIN 
        pedido_cliente pc ON dpc.id_pedido_cliente = pc.id_pedido_cliente
    JOIN 
        bebida b ON dpc.id_bebida = b.id_bebida
    WHERE 
        pc.id_cliente = p_id_cliente
        AND pc.estado = 'ENTREGADO' 
    GROUP BY 
        b.id_bebida, b.nombre
    ORDER BY 
        total_vendido DESC
    LIMIT 1;
    
    
    IF p_ventas_count IS NULL THEN
        SET p_bebida_nombre = 'No purchases found';
        SET p_ventas_count = 0;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cancelar_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cancelar_pedido`(IN pedido_id INT)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;
    
    IF EXISTS (
        SELECT 1
        FROM pedido_cliente
        WHERE id_pedido_cliente = pedido_id AND estado = 'PENDIENTE'
    ) THEN

        
        UPDATE pedido_cliente
        SET estado = 'CANCELADO'
        WHERE id_pedido_cliente = pedido_id;

        
        UPDATE bebida b
        JOIN detalle_pedido_cliente d
            ON b.id_bebida = d.id_bebida
        SET b.stock_actual = IFNULL(b.stock_actual, 0) + d.cantidad
        WHERE d.id_pedido_cliente = pedido_id;

        COMMIT;

    ELSE
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El pedido no está en estado PENDIENTE o no existe.';
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_agregar_detalle_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_agregar_detalle_pedido`(
    IN p_id_pedido_cliente INT,
    IN p_id_bebida INT,
    IN p_cantidad INT,
    OUT p_resultado TEXT
)
BEGIN
    DECLARE v_error_msg TEXT;
    DECLARE v_existe_pedido INT;
    DECLARE v_existe_bebida INT;
    DECLARE v_stock_actual INT;
    DECLARE v_stock_msg TEXT;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1 v_error_msg = MESSAGE_TEXT;
        ROLLBACK;
        SET p_resultado = CONCAT('Error: ', LEFT(v_error_msg, 200));
    END;
    
    START TRANSACTION;
    
    SELECT COUNT(*) INTO v_existe_pedido FROM pedido_cliente 
    WHERE id_pedido_cliente = p_id_pedido_cliente;
    
    IF v_existe_pedido = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El pedido especificado no existe';
    END IF;
    
    SELECT stock_actual INTO v_stock_actual FROM bebida 
    WHERE id_bebida = p_id_bebida;
    
    IF v_stock_actual < p_cantidad THEN
        SET v_stock_msg = CONCAT('Stock insuficiente. Disponible: ', v_stock_actual);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_stock_msg;
    END IF;
    
    CALL sp_crear_detalle_pedido_cliente(p_id_bebida, p_id_pedido_cliente, p_cantidad);
    
    COMMIT;
    SET p_resultado = 'Detalle de pedido añadido exitosamente';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_completar_pedido_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`expendioAdmin`@`localhost` PROCEDURE `sp_completar_pedido_cliente`(
    IN p_id_pedido INT,
    OUT p_id_venta INT
)
BEGIN
    DECLARE v_total DECIMAL(10,2);
    DECLARE v_estado_actual VARCHAR(20);
    DECLARE v_cliente_id INT;
    DECLARE v_folio VARCHAR(11);
    DECLARE v_mensaje_error VARCHAR(255);
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;

    SELECT estado, id_cliente INTO v_estado_actual, v_cliente_id
    FROM Pedido_Cliente
    WHERE id_pedido_cliente = p_id_pedido;
    
    IF v_estado_actual IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El pedido no existe';
    ELSEIF v_estado_actual != 'PENDIENTE' THEN
		SET v_mensaje_error = CONCAT('Estado actual no permitido: ', v_estado_actual);
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = v_mensaje_error;
    END IF;
    
    SELECT SUM(dpc.precio_venta * dpc.cantidad) INTO v_total
    FROM Detalle_Pedido_Cliente dpc
    WHERE dpc.id_pedido_cliente = p_id_pedido;
    
    IF v_total IS NULL OR v_total <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El pedido no tiene detalles válidos';
    END IF;
    
    SET v_folio = CONCAT(
        'V',
        DATE_FORMAT(CURDATE(), '%y%m%d'),
        LPAD((SELECT COUNT(*) + 1 FROM Venta WHERE DATE(fecha) = CURDATE()), 3, '0')
    );
    
    IF LENGTH(v_folio) > 11 THEN
        SET v_folio = CONCAT('V', LPAD(p_id_pedido, 10, '0')); -- Alternativa segura
    END IF;
    
    UPDATE Pedido_Cliente 
    SET estado = 'ENTREGADO',
        total = v_total
    WHERE id_pedido_cliente = p_id_pedido;
    
    INSERT INTO Venta (folio, fecha, total, id_pedido_cliente)
    VALUES (v_folio, CURDATE(), v_total, p_id_pedido);
    
    SET p_id_venta = LAST_INSERT_ID();
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_completar_pedido_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`expendioAdmin`@`localhost` PROCEDURE `sp_completar_pedido_proveedor`(
     IN p_id_pedido_proveedor INT,
     IN p_folio_factura VARCHAR(11)
)
BEGIN
    DECLARE v_total DECIMAL(10,2);
    DECLARE v_estado_actual VARCHAR(20);
    DECLARE v_id_compra INT;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    -- Verificar existencia y estado del pedido
    SELECT estado INTO v_estado_actual
    FROM Pedido_Proveedor
    WHERE id_pedido_proveedor = p_id_pedido_proveedor;

    IF v_estado_actual IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El pedido a proveedor no existe';
    ELSEIF v_estado_actual != 'PENDIENTE' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El pedido a proveedor no está en estado PENDIENTE';
    END IF;

    -- Calcular total
    SELECT SUM(subtotal) INTO v_total
    FROM Detalle_Pedido_Proveedor
    WHERE id_pedido_proveedor = p_id_pedido_proveedor;

    IF v_total IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El pedido a proveedor no tiene detalles';
    END IF;

    -- Actualizar estado y total del pedido
    UPDATE Pedido_Proveedor 
    SET estado = 'RECIBIDO',
        total = v_total
    WHERE id_pedido_proveedor = p_id_pedido_proveedor;

    -- Insertar en Compra y obtener ID generado
    INSERT INTO Compra (folio, fecha, total, id_pedido_proveedor)
    VALUES (p_folio_factura, CURDATE(), v_total, p_id_pedido_proveedor);

    SET v_id_compra = LAST_INSERT_ID();

    COMMIT;

    -- Opcional: retornar ID generado
    SELECT v_id_compra AS id_compra_creada;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultar_pedidos_pendientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`expendioAdmin`@`localhost` PROCEDURE `sp_consultar_pedidos_pendientes`(
    IN p_rfc_proveedor VARCHAR(13),
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE
)
BEGIN
    SELECT 
        pp.id_pedido_proveedor,
        pp.fecha,
        pp.rfc,
        pr.razon_social AS proveedor,
        COALESCE(pr.telefono, 'N/A') AS telefono_proveedor,
        COALESCE(pr.email, 'N/A') AS email_proveedor,
        b.nombre AS bebida,
        b.categoria,
        b.tamaño,
        dpp.cantidad,
        dpp.precio_compra,
        dpp.subtotal,
        (dpp.cantidad * dpp.precio_compra) AS total_calculado
    FROM Pedido_Proveedor pp
    INNER JOIN Proveedor pr ON pp.rfc = pr.rfc
    INNER JOIN Detalle_Pedido_Proveedor dpp ON pp.id_pedido_proveedor = dpp.id_pedido_proveedor
    INNER JOIN Bebida b ON dpp.id_bebida = b.id_bebida
    WHERE pp.estado = 'PENDIENTE'
    AND (p_rfc_proveedor IS NULL OR pp.rfc = p_rfc_proveedor)
    AND (p_fecha_inicio IS NULL OR pp.fecha >= p_fecha_inicio)
    AND (p_fecha_fin IS NULL OR pp.fecha <= p_fecha_fin)
    ORDER BY pp.fecha DESC, pr.razon_social, b.nombre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_consultar_stock_bajo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`expendioAdmin`@`localhost` PROCEDURE `sp_consultar_stock_bajo`()
BEGIN
    SELECT 
        b.id_bebida,
        b.nombre,
        b.categoria,
        b.tamaño,
        b.stock_actual,
        b.stock_minimo,
        b.precio_unitario,
        (b.stock_minimo - b.stock_actual) AS deficit_stock,
        CASE 
            WHEN b.stock_actual = 0 THEN 'SIN STOCK'
            WHEN b.stock_actual < b.stock_minimo THEN 'STOCK CRÍTICO'
            ELSE 'STOCK NORMAL'
        END AS estado_stock
    FROM Bebida b
    WHERE b.stock_actual <= b.stock_minimo
    ORDER BY 
        CASE 
            WHEN b.stock_actual = 0 THEN 1
            WHEN b.stock_actual < b.stock_minimo THEN 2
            ELSE 3
        END,
        b.stock_actual ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_crear_detalle_pedido_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_detalle_pedido_cliente`(
    IN p_id_bebida INT,
    IN p_id_pedido_cliente INT,
    IN p_cantidad INT
)
BEGIN
    DECLARE v_precio_unitario DECIMAL(10,2);
    DECLARE v_descuento_cliente DECIMAL(5,2) DEFAULT 0.00;
    DECLARE v_descuento_bebida DECIMAL(5,2) DEFAULT 0.00;
    DECLARE v_descuento_final DECIMAL(5,2) DEFAULT 0.00;
    DECLARE v_subtotal DECIMAL(10,2);
    DECLARE v_stock_actual INT;
    DECLARE v_id_cliente INT;
    DECLARE v_existe_pedido INT;
    DECLARE v_existe_bebida INT;
    DECLARE v_error_msg VARCHAR(255);
    DECLARE v_iva DECIMAL(5,2) DEFAULT 1.16; 
    
    SELECT COUNT(*) INTO v_existe_pedido FROM pedido_cliente 
    WHERE id_pedido_cliente = p_id_pedido_cliente;
    
    IF v_existe_pedido = 0 THEN
        SET v_error_msg = 'El pedido especificado no existe';
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_error_msg;
    END IF;
    
    SELECT COUNT(*) INTO v_existe_bebida FROM bebida 
    WHERE id_bebida = p_id_bebida;
    
    IF v_existe_bebida = 0 THEN
        SET v_error_msg = 'La bebida especificada no existe';
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_error_msg;
    END IF;
    
    SELECT CAST(precio_unitario AS DECIMAL(10,2)), stock_actual 
    INTO v_precio_unitario, v_stock_actual
    FROM bebida 
    WHERE id_bebida = p_id_bebida;
    
    IF v_stock_actual < p_cantidad THEN
        SET v_error_msg = CONCAT('No hay suficiente stock disponible. Stock actual: ', v_stock_actual);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_error_msg;
    END IF;
    
    SELECT id_cliente INTO v_id_cliente 
    FROM pedido_cliente 
    WHERE id_pedido_cliente = p_id_pedido_cliente;
    
    SELECT IFNULL((
        SELECT CAST(p.porcentaje AS DECIMAL(5,2))
        FROM promocion_cliente pc
        JOIN promocion p ON pc.id_promocion = p.id_promocion
        WHERE pc.id_cliente = v_id_cliente
        AND CURDATE() BETWEEN p.fecha_inicio AND IFNULL(p.fecha_fin, CURDATE())
        LIMIT 1
    ), 0.00) INTO v_descuento_cliente;
    
    SELECT IFNULL((
        SELECT CAST(p.porcentaje AS DECIMAL(5,2))
        FROM promocion_bebida pb
        JOIN promocion p ON pb.id_promocion = p.id_promocion
        WHERE pb.id_bebida = p_id_bebida
        AND CURDATE() BETWEEN p.fecha_inicio AND IFNULL(p.fecha_fin, CURDATE())
        LIMIT 1
    ), 0.00) INTO v_descuento_bebida;
    
    SET v_descuento_final = CAST(GREATEST(v_descuento_cliente, v_descuento_bebida) / 100 AS DECIMAL(5,2));
    
    SET v_subtotal = CAST(ROUND(p_cantidad * v_precio_unitario * (1 - v_descuento_final), 2) AS DECIMAL(10,2));
    
    INSERT INTO detalle_pedido_cliente (id_bebida, id_pedido_cliente, cantidad, subtotal)
    VALUES (p_id_bebida, p_id_pedido_cliente, p_cantidad, v_subtotal);
    
    UPDATE bebida 
    SET stock_actual = stock_actual - p_cantidad
    WHERE id_bebida = p_id_bebida;
    
    UPDATE pedido_cliente 
    SET total = CAST(total + ROUND(v_subtotal * v_iva, 2) AS DECIMAL(10,2))
    WHERE id_pedido_cliente = p_id_pedido_cliente;
    
    SELECT 
        id_bebida,
        id_pedido_cliente,
        cantidad,
        CAST(subtotal AS DECIMAL(10,2)) AS subtotal,
        CAST(subtotal * v_iva AS DECIMAL(10,2)) AS subtotal_con_iva
    FROM detalle_pedido_cliente 
    WHERE id_bebida = p_id_bebida AND id_pedido_cliente = p_id_pedido_cliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_crear_pedido_automatico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`expendioAdmin`@`localhost` PROCEDURE `sp_crear_pedido_automatico`(
     IN p_id_bebida INT,
     IN p_cantidad_pedida INT,
     IN p_rfc_proveedor VARCHAR(13)
)
BEGIN
    DECLARE v_precio_compra DECIMAL(10,2);
    DECLARE v_id_pedido INT;
    DECLARE v_subtotal DECIMAL(10,2);
    DECLARE v_proveedor_existe INT DEFAULT 0;
    DECLARE v_rfc_seleccionado VARCHAR(13);
    DECLARE v_mensaje_error VARCHAR(255);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    -- Validar proveedor
    IF p_rfc_proveedor IS NULL OR p_rfc_proveedor = '' THEN
        CALL sp_obtener_proveedor_bebida(p_id_bebida, v_rfc_seleccionado);
    ELSE
        SET v_rfc_seleccionado = p_rfc_proveedor;
    END IF;

    -- Verificar que el proveedor existe
    SELECT COUNT(*) INTO v_proveedor_existe
    FROM Proveedor 
    WHERE rfc = v_rfc_seleccionado;

    IF v_proveedor_existe = 0 THEN
        SET v_mensaje_error = CONCAT('El proveedor con RFC ', v_rfc_seleccionado, ' no existe.');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_mensaje_error;
    END IF;

    -- Obtener precio de compra (70% del precio de venta)
    SELECT precio_unitario * 0.7 INTO v_precio_compra
    FROM Bebida
    WHERE id_bebida = p_id_bebida;

    IF v_precio_compra IS NULL THEN
        SET v_mensaje_error = CONCAT('La bebida con ID ', p_id_bebida, ' no existe');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = v_mensaje_error;
    END IF;

    -- Calcular subtotal
    SET v_subtotal = v_precio_compra * p_cantidad_pedida;

    -- Buscar pedido pendiente para este proveedor hoy
    SELECT id_pedido_proveedor INTO v_id_pedido
    FROM Pedido_Proveedor
    WHERE rfc = v_rfc_seleccionado 
      AND estado = 'PENDIENTE'
      AND fecha = CURDATE()
    LIMIT 1;

    -- Si no existe, crear nuevo pedido
    IF v_id_pedido IS NULL THEN
        INSERT INTO Pedido_Proveedor (fecha, estado, rfc, total)
        VALUES (CURDATE(), 'PENDIENTE', v_rfc_seleccionado, 0);

        SET v_id_pedido = LAST_INSERT_ID();
    END IF;

    -- Agregar detalle al pedido (actualizar si ya existe)
    IF EXISTS (
        SELECT 1 FROM Detalle_Pedido_Proveedor 
        WHERE id_pedido_proveedor = v_id_pedido 
          AND id_bebida = p_id_bebida
    ) THEN
        UPDATE Detalle_Pedido_Proveedor 
        SET cantidad = cantidad + p_cantidad_pedida,
            subtotal = subtotal + v_subtotal
        WHERE id_pedido_proveedor = v_id_pedido 
          AND id_bebida = p_id_bebida;
    ELSE
        INSERT INTO Detalle_Pedido_Proveedor (
            id_pedido_proveedor, 
            id_bebida, 
            subtotal, 
            cantidad, 
            precio_compra
        )
        VALUES (
            v_id_pedido, 
            p_id_bebida, 
            v_subtotal, 
            p_cantidad_pedida, 
            v_precio_compra
        );
    END IF;

    COMMIT;

    -- Retornar información del pedido generado
    SELECT 
        v_id_pedido as id_pedido_proveedor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_crear_pedido_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_pedido_cliente`(
    IN p_id_cliente INT,
    IN p_fecha DATE,
    IN p_estado ENUM('PENDIENTE', 'ENTREGADO', 'CANCELADO')
)
BEGIN
    INSERT INTO pedido_cliente (fecha, total, estado, id_cliente)
    VALUES (p_fecha, 0, p_estado, p_id_cliente);

    SELECT LAST_INSERT_ID() AS id_pedido_cliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_proveedor_bebida` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`expendioAdmin`@`localhost` PROCEDURE `sp_obtener_proveedor_bebida`(
    IN p_id_bebida INT,
    OUT p_rfc_proveedor VARCHAR(13)
)
BEGIN
    -- Primero intentar con proveedores que ya han surtido esta bebida
    SELECT p.rfc INTO p_rfc_proveedor
    FROM Proveedor p
    INNER JOIN Pedido_Proveedor pp ON p.rfc = pp.rfc
    INNER JOIN Detalle_Pedido_Proveedor dpp ON pp.id_pedido_proveedor = dpp.id_pedido_proveedor
    WHERE dpp.id_bebida = p_id_bebida
    AND pp.estado = 'COMPLETADO'
    GROUP BY p.rfc
    ORDER BY COUNT(*) DESC, MAX(pp.fecha) DESC
    LIMIT 1;
    
    -- Si no se encontró, tomar cualquier proveedor
    IF p_rfc_proveedor IS NULL THEN
        SELECT rfc INTO p_rfc_proveedor
        FROM Proveedor
        LIMIT 1;
    END IF;
    
    -- Si no hay proveedores registrados
    IF p_rfc_proveedor IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'No hay proveedores registrados en el sistema';
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrar_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_venta`(
    IN p_id_pedido_cliente INT,
    IN p_folio VARCHAR(11)
)
BEGIN
    DECLARE v_fecha_actual DATE;
    DECLARE v_estado_actual VARCHAR(20);

    
    SET v_fecha_actual = CURDATE();

    
    SELECT estado INTO v_estado_actual
    FROM pedido_cliente
    WHERE id_pedido_cliente = p_id_pedido_cliente;

    IF v_estado_actual IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El pedido no existe';
    ELSEIF v_estado_actual != 'PENDIENTE' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Solo se pueden registrar ventas de pedidos PENDIENTES';
    END IF;

    
    INSERT INTO venta (folio, fecha, id_pedido_cliente)
    VALUES (p_folio, v_fecha_actual, p_id_pedido_cliente);

    
    UPDATE pedido_cliente
    SET estado = 'ENTREGADO'
    WHERE id_pedido_cliente = p_id_pedido_cliente;

    
    SELECT 
        LAST_INSERT_ID() AS id_venta,
        p_folio AS folio,
        v_fecha_actual AS fecha,
        p_id_pedido_cliente AS id_pedido_cliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_transaccion_pedido_completo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_transaccion_pedido_completo`(
    IN p_id_cliente INT,
    IN p_fecha DATE,
    IN p_estado ENUM('PENDIENTE', 'ENTREGADO', 'CANCELADO'),
    IN p_id_bebida INT,
    IN p_cantidad INT,
    IN p_folio VARCHAR(11),
    OUT p_resultado TEXT,  
    OUT p_id_pedido_generado INT
)
BEGIN
    DECLARE v_error_msg TEXT;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1 v_error_msg = MESSAGE_TEXT;
        ROLLBACK;
        SET p_resultado = CONCAT('Error: ', LEFT(v_error_msg, 200));  
        SET p_id_pedido_generado = NULL;
        SELECT p_resultado AS mensaje_error;
    END;
    
    START TRANSACTION;
    
    CALL sp_crear_pedido_cliente(p_id_cliente, p_fecha, p_estado);
    SET p_id_pedido_generado = LAST_INSERT_ID();
    
    CALL sp_crear_detalle_pedido_cliente(p_id_bebida, p_id_pedido_generado, p_cantidad);
    
    call sp_registrar_venta(p_id_pedido_generado, p_folio);
    
    COMMIT;
    SET p_resultado = 'Pedido creado exitosamente';
    
    SELECT 
        p_resultado AS resultado,
        p_id_pedido_generado AS id_pedido;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificar_promocion_bebida` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_verificar_promocion_bebida`(
    IN p_id_bebida INT,
    OUT p_porcentaje_descuento DOUBLE
)
BEGIN
    DECLARE v_fecha_actual DATE;
    SET v_fecha_actual = CURDATE();

    
    SELECT IFNULL((
        SELECT p.porcentaje
        FROM Promocion_Bebida pb
        JOIN Promocion p ON pb.id_promocion = p.id_promocion
        WHERE pb.id_bebida = p_id_bebida
        AND v_fecha_actual >= p.fecha_inicio
        AND (p.fecha_fin IS NULL OR v_fecha_actual <= p.fecha_fin)
        LIMIT 1
    ), 0) INTO p_porcentaje_descuento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_verificar_promocion_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_verificar_promocion_cliente`(
    IN p_id_cliente INT,
    OUT p_porcentaje_descuento DOUBLE
)
BEGIN
    DECLARE v_fecha_actual DATE;
    SET v_fecha_actual = CURDATE();

    
    SELECT IFNULL((
        SELECT p.porcentaje
        FROM Promocion_Cliente pc
        JOIN Promocion p ON pc.id_promocion = p.id_promocion
        WHERE pc.id_cliente = p_id_cliente
        AND v_fecha_actual >= p.fecha_inicio
        AND (p.fecha_fin IS NULL OR v_fecha_actual <= p.fecha_fin)
        LIMIT 1
    ), 0) INTO p_porcentaje_descuento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `analisis_ventas`
--

/*!50001 DROP VIEW IF EXISTS `analisis_ventas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `analisis_ventas` AS select `b`.`id_bebida` AS `id_bebida`,`b`.`nombre` AS `producto`,`b`.`categoria` AS `categoria`,`b`.`stock_actual` AS `stock_actual`,`b`.`stock_minimo` AS `stock_minimo`,count(distinct `pc`.`id_cliente`) AS `clientes_unicos`,sum(`dpc`.`cantidad`) AS `cantidad_total_vendida`,sum(`dpc`.`subtotal`) AS `ingresos_totales`,(case when (sum(`dpc`.`cantidad`) is null) then 'No vendido' when (sum(`dpc`.`cantidad`) = 0) then 'No vendido' else 'Vendido' end) AS `estado_venta` from ((`bebida` `b` left join `detalle_pedido_cliente` `dpc` on((`b`.`id_bebida` = `dpc`.`id_bebida`))) left join `pedido_cliente` `pc` on((`dpc`.`id_pedido_cliente` = `pc`.`id_pedido_cliente`))) group by `b`.`id_bebida`,`b`.`nombre`,`b`.`categoria`,`b`.`stock_actual`,`b`.`stock_minimo` order by sum(`dpc`.`subtotal`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_mas_vendidos`
--

/*!50001 DROP VIEW IF EXISTS `productos_mas_vendidos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_mas_vendidos` AS select `b`.`id_bebida` AS `id_bebida`,`b`.`nombre` AS `nombre`,ifnull((select sum(`dp`.`cantidad`) from `detalle_pedido_cliente` `dp` where (`dp`.`id_bebida` = `b`.`id_bebida`)),0) AS `total_vendida` from `bebida` `b` where (ifnull((select sum(`dp`.`cantidad`) from `detalle_pedido_cliente` `dp` where (`dp`.`id_bebida` = `b`.`id_bebida`)),0) = (select max(ifnull((select sum(`dp2`.`cantidad`) from `detalle_pedido_cliente` `dp2` where (`dp2`.`id_bebida` = `b2`.`id_bebida`)),0)) from `bebida` `b2`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_menos_vendidos`
--

/*!50001 DROP VIEW IF EXISTS `productos_menos_vendidos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_menos_vendidos` AS select `b`.`id_bebida` AS `id_bebida`,`b`.`nombre` AS `nombre`,ifnull((select sum(`dp`.`cantidad`) from `detalle_pedido_cliente` `dp` where (`dp`.`id_bebida` = `b`.`id_bebida`)),0) AS `total_vendida` from `bebida` `b` where (ifnull((select sum(`dp`.`cantidad`) from `detalle_pedido_cliente` `dp` where (`dp`.`id_bebida` = `b`.`id_bebida`)),0) = (select min(ifnull((select sum(`dp2`.`cantidad`) from `detalle_pedido_cliente` `dp2` where (`dp2`.`id_bebida` = `b2`.`id_bebida`)),0)) from `bebida` `b2`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_no_vendidos`
--

/*!50001 DROP VIEW IF EXISTS `productos_no_vendidos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_no_vendidos` AS select `b`.`id_bebida` AS `id_bebida`,`b`.`nombre` AS `producto`,`pc`.`id_cliente` AS `id_cliente` from ((`bebida` `b` left join `detalle_pedido_cliente` `dpc` on((`b`.`id_bebida` = `dpc`.`id_bebida`))) left join `pedido_cliente` `pc` on((`dpc`.`id_pedido_cliente` = `pc`.`id_pedido_cliente`))) where `b`.`id_bebida` in (select `dpc`.`id_bebida` from (`detalle_pedido_cliente` `dpc` join `pedido_cliente` `pc` on((`dpc`.`id_pedido_cliente` = `pc`.`id_pedido_cliente`)))) is false */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_stock_bajo`
--

/*!50001 DROP VIEW IF EXISTS `productos_stock_bajo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_stock_bajo` AS select `bebida`.`id_bebida` AS `id_bebida`,`bebida`.`nombre` AS `nombre`,`bebida`.`stock_actual` AS `stock_actual`,`bebida`.`stock_minimo` AS `stock_minimo` from `bebida` where (`bebida`.`stock_actual` <= `bebida`.`stock_minimo`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ventas_por_producto`
--

/*!50001 DROP VIEW IF EXISTS `ventas_por_producto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ventas_por_producto` AS select `b`.`id_bebida` AS `id_bebida`,`b`.`nombre` AS `producto`,sum(`dpc`.`cantidad`) AS `cantidad_vendida`,sum(`dpc`.`subtotal`) AS `total_ventas` from (((`detalle_pedido_cliente` `dpc` join `bebida` `b` on((`dpc`.`id_bebida` = `b`.`id_bebida`))) join `pedido_cliente` `pc` on((`dpc`.`id_pedido_cliente` = `pc`.`id_pedido_cliente`))) join `venta` `v` on((`pc`.`id_pedido_cliente` = `v`.`id_pedido_cliente`))) group by `b`.`id_bebida`,`b`.`nombre` order by sum(`dpc`.`subtotal`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_stock_bajo`
--

/*!50001 DROP VIEW IF EXISTS `vw_stock_bajo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_stock_bajo` AS select `b`.`id_bebida` AS `id_bebida`,`b`.`nombre` AS `nombre`,`b`.`categoria` AS `categoria`,`b`.`tamaño` AS `tamaño`,`b`.`stock_actual` AS `stock_actual`,`b`.`stock_minimo` AS `stock_minimo`,`b`.`precio_unitario` AS `precio_unitario`,(`b`.`stock_minimo` - `b`.`stock_actual`) AS `deficit_stock`,(case when (`b`.`stock_actual` = 0) then 'SIN STOCK' when (`b`.`stock_actual` < `b`.`stock_minimo`) then 'STOCK CRÍTICO' else 'STOCK NORMAL' end) AS `estado_stock` from `bebida` `b` where (`b`.`stock_actual` <= `b`.`stock_minimo`) order by (case when (`b`.`stock_actual` = 0) then 1 when (`b`.`stock_actual` < `b`.`stock_minimo`) then 2 else 3 end),`b`.`stock_actual` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_ventas_anuales`
--

/*!50001 DROP VIEW IF EXISTS `vw_ventas_anuales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY INVOKER */
/*!50001 VIEW `vw_ventas_anuales` AS select year(`venta`.`fecha`) AS `año`,sum(`pedido_cliente`.`total`) AS `total_anual`,count(`venta`.`id_venta`) AS `cantidad_ventas` from (`venta` join `pedido_cliente` on((`pedido_cliente`.`id_pedido_cliente` = `venta`.`id_pedido_cliente`))) group by year(`venta`.`fecha`) order by year(`venta`.`fecha`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_ventas_mensuales`
--

/*!50001 DROP VIEW IF EXISTS `vw_ventas_mensuales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY INVOKER */
/*!50001 VIEW `vw_ventas_mensuales` AS select year(`venta`.`fecha`) AS `año`,month(`venta`.`fecha`) AS `mes`,sum(`pedido_cliente`.`total`) AS `total_mensual`,count(`venta`.`id_venta`) AS `cantidad_ventas` from (`venta` join `pedido_cliente` on((`pedido_cliente`.`id_pedido_cliente` = `venta`.`id_pedido_cliente`))) group by year(`venta`.`fecha`),month(`venta`.`fecha`) order by year(`venta`.`fecha`),month(`venta`.`fecha`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_ventas_semanales`
--

/*!50001 DROP VIEW IF EXISTS `vw_ventas_semanales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY INVOKER */
/*!50001 VIEW `vw_ventas_semanales` AS select year(`venta`.`fecha`) AS `año`,week(`venta`.`fecha`,1) AS `semana`,sum(`pedido_cliente`.`total`) AS `total_semanal`,count(`venta`.`id_venta`) AS `cantidad_ventas` from (`venta` join `pedido_cliente` on((`pedido_cliente`.`id_pedido_cliente` = `venta`.`id_pedido_cliente`))) group by year(`venta`.`fecha`),week(`venta`.`fecha`,1) order by year(`venta`.`fecha`),week(`venta`.`fecha`,1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

-- ----------------------------------------------
-- CREACIÓN DE USUARIOS Y ROLES
-- ----------------------------------------------

CREATE USER 'expendioAdmin'@'localhost' IDENTIFIED BY 'expendioAdmin-12345';
CREATE USER 'expendioEmpleado'@'localhost' IDENTIFIED BY 'expendioEmpleado-12345';

CREATE ROLE admins;
CREATE ROLE empleados;

GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.admin TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.analisis_ventas TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.bebida TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.cliente TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.compra TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.detalle_pedido_cliente TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.detalle_pedido_proveedor TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.empleado TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.pedido_cliente TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.pedido_proveedor TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.productos_mas_vendidos TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.productos_menos_vendidos TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.productos_no_vendidos TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.productos_stock_bajo TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.promocion TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.promocion_bebida TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.promocion_cliente TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.proveedor TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.venta TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.ventas_por_producto TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.vw_ventas_anuales TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.vw_ventas_mensuales TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.vw_ventas_semanales TO admins;
GRANT SELECT, INSERT, UPDATE, DELETE ON expendio_bebidas.vw_stock_bajo TO admins;
GRANT EXECUTE ON expendio_bebidas.* TO admins;

GRANT SELECT, INSERT, UPDATE ON expendio_bebidas.venta TO empleados;
GRANT SELECT, INSERT, UPDATE ON expendio_bebidas.cliente TO empleados;
GRANT SELECT, INSERT, UPDATE ON expendio_bebidas.pedido_cliente TO empleados;
GRANT SELECT, INSERT, UPDATE ON expendio_bebidas.detalle_pedido_cliente TO empleados;
GRANT SELECT ON expendio_bebidas.productos_stock_bajo TO empleados;
GRANT SELECT ON expendio_bebidas.empleado TO empleados;
GRANT SELECT ON expendio_bebidas.bebida TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.sp_consultar_pedidos_pendientes TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.sp_consultar_stock_bajo TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.sp_crear_detalle_pedido_cliente TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.sp_verificar_promocion_cliente TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.sp_verificar_promocion_bebida TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.sp_registrar_venta TO empleados;
GRANT EXECUTE ON PROCEDURE expendio_bebidas.cancelar_pedido TO empleados;

GRANT admins TO 'expendioAdmin'@'localhost';
SET DEFAULT ROLE admins TO 'expendioAdmin'@'localhost';

GRANT empleados TO 'expendioEmpleado'@'localhost';
SET DEFAULT ROLE empleados TO 'expendioEmpleado'@'localhost';

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-11 23:22:14
