/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appejemplostreams;


public class ProductoBuilder {

    private Producto.Tipo tipo;
    private String nombre;
    private String descripcion;
    private double precio;
    private double descuento;

    public ProductoBuilder() {
    }

    public ProductoBuilder setTipo(Producto.Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder setDescuento(double descuento) {
        this.descuento = descuento;
        return this;
    }

    public Producto createProducto() {
        return new Producto(tipo, nombre, descripcion, precio, descuento);
    }
    
}
