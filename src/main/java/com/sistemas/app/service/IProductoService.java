package com.sistemas.app.service;

import java.util.List;

import com.sistemas.app.dto.ProductoDTO;

public interface IProductoService {
    ProductoDTO createProducto(ProductoDTO productoDTO);
    List<ProductoDTO> getAllProductos();
}
