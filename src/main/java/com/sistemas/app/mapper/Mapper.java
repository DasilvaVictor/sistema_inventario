package com.sistemas.app.mapper;

import com.sistemas.app.dto.ProductoDTO;
import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;
import com.sistemas.app.model.Producto;
import com.sistemas.app.model.Usuario;

public class Mapper {
    
    public static Usuario toUsuarioEntity(UsuarioRequestDTO obj) {
        return Usuario.builder()
                .nombre(obj.getNombre())
                .email(obj.getEmail())
                .apellido(obj.getApellido())
                .username(obj.getUsername())
                .password(obj.getPassword())
                .rol(obj.getRol())
                .build();
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario obj) {
        return UsuarioResponseDTO.builder()
                .id(obj.getId())
                .nombre(obj.getNombre())
                .username(obj.getUsername())
                .rol(obj.getRol())
                .build();
    }

    public static ProductoDTO toProductoDTO(Producto obj) {
        return ProductoDTO.builder()
                .codigoProducto(obj.getCodigoProducto())
                .nombre(obj.getNombre())
                .descripcion(obj.getDescripcion())
                .unidad(obj.getUnidad())
                .stock(obj.getStock())
                .categoriaId(obj.getCategoria().getId())
                .categoriaNombre(obj.getCategoria().getNombre())
                .build();
    }
}
