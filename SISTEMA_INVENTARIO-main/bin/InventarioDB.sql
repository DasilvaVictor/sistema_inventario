CREATE DATABASE inventario;
USE inventario;

-- Tablas
CREATE TABLE Categoria (
    id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200)
);

CREATE TABLE Usuario (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    rol VARCHAR(20) NOT NULL
);

CREATE TABLE Producto (
    id_producto BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    stock INT NOT NULL DEFAULT 0,
    stock_minimo INT NOT NULL DEFAULT 0,
    id_categoria BIGINT NOT NULL,

    CONSTRAINT fk_producto_categoria
        FOREIGN KEY (id_categoria)
        REFERENCES Categoria(id_categoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE Movimiento (
    id_movimiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_producto BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    tipo_movimiento VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    observacion VARCHAR(200),

    CONSTRAINT fk_movimiento_producto
        FOREIGN KEY (id_producto)
        REFERENCES Producto(id_producto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_movimiento_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES Usuario(id_usuario)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);