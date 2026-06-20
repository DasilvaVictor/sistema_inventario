package com.sistemas.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 200)
    private String descripcion;

    @Column(length = 200)
    private String unidad;

    @Column(nullable = true)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
}
