package com.sistemas.app.service;

import java.util.List;

import com.sistemas.app.dto.ProductoDTO;

public interface IProductoService {
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO getProductoByCodigo(String codigoProducto);
    List<ProductoDTO> getAllProductos();
    ProductoDTO updateProducto(ProductoDTO productoDTO);
    void deleteProducto(String codigoProducto);
    List<ProductoDTO> buscarProductos(String texto);
}
