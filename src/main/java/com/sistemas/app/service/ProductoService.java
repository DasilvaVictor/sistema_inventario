package com.sistemas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemas.app.dto.ProductoDTO;
import com.sistemas.app.mapper.Mapper;
import com.sistemas.app.model.Categoria;
import com.sistemas.app.model.Producto;
import com.sistemas.app.repository.CategoriaRepository;
import com.sistemas.app.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepo;
    private final CategoriaRepository categoriaRepo;

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Categoria categoria = categoriaRepo.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        
        Producto newProducto = Producto.builder()
                .codigoProducto(productoDTO.getCodigoProducto())
                .nombre(productoDTO.getNombre())
                .descripcion(productoDTO.getDescripcion())
                .unidad(productoDTO.getUnidad())
                .stock(productoDTO.getStock())
                .categoria(categoria)
                .build();

        productoRepo.save(newProducto);
        return Mapper.toProductoDTO(newProducto);
    }

    @Override
    public List<ProductoDTO> getAllProductos() {
        return productoRepo.findAll().stream()
                .map(Mapper::toProductoDTO)
                .toList();
    }

}
