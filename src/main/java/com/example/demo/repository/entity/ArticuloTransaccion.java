package com.example.demo.repository.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "articulostransaccion")
public class ArticuloTransaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "precio_venta")
    private double precioVenta;
    @Column(name = "precio_final")
    private double precioFinal;
    // CREO Q FUNCIONA EL MAPEO, PERO AL NO TENER DATOS NO FUNCIONA
    // Relacionamos articulostransaccion con las tablas correspondientes
    @ManyToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;

    @ManyToOne
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;

    


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticuloTransaccion other = (ArticuloTransaccion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
