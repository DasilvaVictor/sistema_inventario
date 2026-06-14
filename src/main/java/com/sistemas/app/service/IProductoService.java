package com.sistemas.app.service;

import java.util.List;

import com.sistemas.app.model.Producto;

public interface IProductoService {
    Producto createProducto(Producto producto);
    List<Producto> getAllProductos();
}
