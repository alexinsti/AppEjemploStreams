/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appejemplostreams;

import appejemplostreams.Producto.Tipo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author franmatias
 */
public class Catalogo {

    public List<Producto> catalogo;

    Catalogo() {
        catalogo = new LinkedList<>();
    }

    public void generarDatos() {
        String[][] productos = {
            {"Fresones", "1.85", "Frutas"},
            {"Limones", "0.99", "Frutas"},
            {"Manzana Golden", "1.35", "Frutas"},
            {"Manzana Starking", "1.05", "Frutas"},
            {"Naranja Navel", "0.40", "Frutas"},
            {"Pera Blanquilla", "1.33", "Frutas"},
            {"Pera Passacrasana", "1.50", "Frutas"},
            {"Piña", "1.80", "Frutas"},
            {"Plátanos", "0.97", "Frutas"},
            {"Pomelos", "1.00", "Frutas"},
            {"Alcachofas", "1.58", "Verduras"},
            {"Cebollas ", "0.38", "Verduras"},
            {"Coliflor", "1.74", "Verduras"},
            {"Judias Verdes Perona", "2.53", "Verduras"},
            {"Lechugas", "0.41", "Verduras"},
            {"Patatas calidad", "0.43", "Verduras"},
            {"Patatas Primor", "0.45", "Verduras"},
            {"Tomate maduro", "1.1", "Verduras"},
            {"Tomate verde", "1.14", "Verduras"},
            {"Zanahorias", "0.40", "Verduras"},
            {"Bacaladilla", "2.93", "Pescados"},
            {"Bacalao", "6.50", "Pescados"},
            {"Caballa", "3.48", "Pescados"},
            {"Chirla", "3.50", "Pescados"},
            {"Mejillón", "1.75", "Pescados"},
            {"Merluza", "8.83", "Pescados"},
            {"Palometa", "5.50", "Pescados"},
            {"Pescadilla", "4.50", "Pescados"},
            {"Sardina", "2.96", "Pescados"},
            {"Trucha", "4.20", "Pescados"},
            {"Bacalao", "6.00", "Pescados"},
            {"Calamar", "3.75", "Pescados"},
            {"Gamba", "27.00", "Pescados"},
            {"Langostino", "16.50", "Pescados"},
            {"Merluza", "6.25", "Pescados"},
            {"Ovino - Casquería", "1.62", "Carnes"},
            {"Ovino - Lechal", "7.75", "Carnes"},
            {"Ovino - Recental", "6.38", "Carnes"},
            {"Porcino - Casquería", "1.69", "Carnes"},
            {"Porcino - Cerdo blanco", "2.39", "Carnes"},
            {"Porcino - Cochinillo", "12.38", "Carnes"},
            {"Vacuno - Añojo", "4.16", "Carnes"},
            {"Vacuno - Casquería", "2.23", "Carnes"},
            {"Vacuno - Ternera", "4.40", "Carnes"}};

        for (String[] fila : productos) {
            try {
                String nombre = fila[0];
                double precio = Double.parseDouble(fila[1]);
                Tipo tipo = stringToTipo(fila[2]);
                String number = String.format("%.2f", Math.random()*10).replace(",", ".");                
                double descuento = Double.parseDouble(number);
                Producto producto = new ProductoBuilder().setNombre(nombre)
                        .setDescripcion(nombre)
                        .setPrecio(precio)
                        .setTipo(tipo)
                        .setDescuento(descuento)
                        .createProducto();

                catalogo.add(producto);
            } catch (NumberFormatException e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

    public Tipo stringToTipo(String tipo) {
        tipo = tipo.toUpperCase();

        switch (tipo) {
            case "FRUTAS":
                return Tipo.FRUTAS;
            case "VERDURAS":
                return Tipo.VERDURAS;
            case "PESCADOS":
                return Tipo.PESCADOS;
            case "CARNES":
                return Tipo.CARNES;

            default:
                return Tipo.ERROR;
        }
    }

    public void mostrarCatalogo() {
        catalogo.stream()
                .sorted()
                .forEach((Producto x) -> {
                    System.out.println(x);
        });
    }
}
