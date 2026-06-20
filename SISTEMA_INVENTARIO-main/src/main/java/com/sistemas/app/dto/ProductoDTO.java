package com.sistemas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private String codigoProducto;
    private String nombre;
    private String descripcion;
    private String unidad;
    private Integer stock;
    private Long categoriaId;
    private String categoriaNombre;

}
