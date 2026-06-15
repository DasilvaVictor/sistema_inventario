package com.sistemas.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.app.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {
    Optional<Producto> findByCodigoProducto(String codigoProducto);
}
