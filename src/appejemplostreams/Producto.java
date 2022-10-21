/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appejemplostreams;

import java.util.Objects;

/**
 *
 * @author franmatias
 */
public class Producto implements Comparable<Producto> {
    public enum Tipo{FRUTAS, VERDURAS, PESCADOS, CARNES, ERROR}
    private static int contProductos;
    static{
        contProductos = 1000;
    }
    private final String sku;
    Tipo tipo;
    private String nombre;
    private String descripcion;
    private double precio;
    private double descuento;

    public Producto(Tipo tipo, String nombre, String descripcion, double precio, double descuento) {
        contProductos++;
        this.sku = "PRO"+contProductos;
        this.tipo = tipo;
        this.nombre = nombre;        
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" + "sku=" + sku + ", tipo=" + tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", descuento=" + descuento + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.sku);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.sku, other.sku);
    }
    
    

    @Override
    public int compareTo(Producto o) {
        return this.getSku().compareToIgnoreCase(o.getSku());
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
