package com.sistemas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemas.app.dto.ProductoDTO;
import com.sistemas.app.mapper.Mapper;
import com.sistemas.app.model.Categoria;
import com.sistemas.app.model.Producto;
import com.sistemas.app.repository.CategoriaRepository;
import com.sistemas.app.repository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

        private final ProductoRepository productoRepo;
        private final CategoriaRepository categoriaRepo;

        @Override
        public ProductoDTO createProducto(ProductoDTO productoDTO) {

                if (productoRepo.existsById(productoDTO.getCodigoProducto())) {
                        throw new RuntimeException(
                                        "Ya existe un producto con ese código");
                }

                Categoria categoria = categoriaRepo.findById(productoDTO.getCategoriaId())
                                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));

                Producto newProducto = Producto.builder()
                                .codigoProducto(productoDTO.getCodigoProducto())
                                .nombre(productoDTO.getNombre())
                                .descripcion(productoDTO.getDescripcion())
                                .unidad(productoDTO.getUnidad())
                                .stock(0)
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

        @Override
        public ProductoDTO getProductoByCodigo(String codigoProducto) {
                return productoRepo.findByCodigoProducto(codigoProducto)
                                .map(Mapper::toProductoDTO)
                                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        }

        @Override
        public ProductoDTO updateProducto(ProductoDTO productoDTO) {

                Producto producto = productoRepo.findByCodigoProducto(
                                productoDTO.getCodigoProducto())
                                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

                Categoria categoria = categoriaRepo.findById(productoDTO.getCategoriaId())
                                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));

                producto.setNombre(productoDTO.getNombre());
                producto.setDescripcion(productoDTO.getDescripcion());
                producto.setUnidad(productoDTO.getUnidad());
                producto.setStock(0);
                producto.setCategoria(categoria);

                productoRepo.save(producto);

                return Mapper.toProductoDTO(producto);
        }

        @Override
        public void deleteProducto(String codigoProducto) {
                Producto producto = productoRepo.findByCodigoProducto(codigoProducto)
                                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
                productoRepo.delete(producto);
        }

        @Override
        public List<ProductoDTO> buscarProductos(String texto) {

                return productoRepo.findByCodigoProductoContainingIgnoreCaseOrNombreContainingIgnoreCase(texto, texto).stream().map(Mapper::toProductoDTO).toList();
        }

}
