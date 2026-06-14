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

    private String id;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private Integer stockMinimo;
    private Long categoriaId;

}
