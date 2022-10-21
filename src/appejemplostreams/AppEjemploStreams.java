/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appejemplostreams;

import appejemplostreams.Producto.Tipo;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import java.util.Random;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import java.util.stream.IntStream;

/**
 *
 * @author franmatias
 */
public class AppEjemploStreams {

    private static final Comparator<Integer> ORDENASCENDENTE = Integer::compare;
    private static final Comparator<Integer> ORDENDESCENDENTE = ORDENASCENDENTE.reversed();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Crear un stream con valores: ");
        System.out.print("Números: ");
        Stream.of(1, 2, 3, 5, 7, 11, 18, 9, 2, 27, 7, -1, 4)
                .forEach((x) -> System.out.print(" " + x));
        separador(1, 80, '-'); //Crear un separador con guiones usan
        System.out.println("Crear un stream con un rango y hacía atrás: ");
        System.out.println("Crear un rango de valores inverso: ");
        int from = 1;
        int to = 30;
        IntStream.range(from, to)
                .map(i -> to - i + from - 1)
                .forEach((x) -> System.out.print(" " + x));

        separador(1, 80, '-');

        Stream<Integer> numeros = Stream.of(1, 2, 3, 5, 7, 11, 18, 9, 2, 27, 7, -1, 4);
        System.out.println("\nSeleccionar los 3 mayores impares no repetidos de una lista saltando uno: ");
        numeros.filter((x) -> x % 2 == 1)
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(1)
                .limit(3)
                .forEach((x) -> System.out.print(" " + x));
        //De otra manera
        Stream.of(1, 2, 3, 5, 7, 11, 18, 9, 2, 27, 7, -1, 4).filter((x) -> x % 2 == 1)
                .sorted(ORDENDESCENDENTE) //Mirar en la clase
                .distinct()
                .skip(1)
                .limit(3)
                .forEach((x) -> System.out.print(" " + x));

        // 5 primeros impares dentro de una lista
        separador(1, 80, '-');
        System.out.println("\nSeleccionar los 5 mayores impares no repetidos de una lista: ");
        numeros = Stream.of(1, 2, 3, 5, 7, 11, 18, 9, 2, 27, 7, -1, 4);
        List<Integer> impares = numeros.filter((x) -> x % 2 == 1)
                .sorted(ORDENASCENDENTE)
                .distinct()
                //.skip(1) //Nos permite poner comentarios y no afecta al stream
                .limit(5)
                .collect(toList());

        //Números aleatorios
        separador(1, 80, '-');
        System.out.println("Generar números aleatorios y ordenar");
        Random random = new Random();
        random.
                ints(5).
                sorted().
                forEach(System.out::println);

        //Invertir el orden    
        separador(1, 80, '-');
        System.out.println("Generar números aleatorios y ordenar inverso");
        random.ints(5)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        separador(1, 80, '-');
        System.out.println("Generar números aleatorios y se pasa a una lista");
        List<Integer> aleatorios = Stream.generate(Math::random)
                .limit(5)
                .map((Double x) -> {
                    return (int) (x * 10);
                })
                .collect(toList());
        System.out.println("Aleatorios: " + aleatorios.toString());

        separador(1, 80, '-');
        System.out.println("Generar una cantidad aleatoria de números aleatorios y se pasa a una lista");
        int cantidad = (int) (Math.random() * 20);
        aleatorios = Stream.generate(Math::random)
                .limit(cantidad)
                .map((Double x) -> {
                    return (int) (x * 20);
                })
                .collect(toList());
        System.out.println("Aleatorios: " + aleatorios.toString());
        System.out.println("Num generados: " + aleatorios.stream().collect(counting()));
        System.out.println("Suma: " + aleatorios.stream().reduce(0, Integer::sum));
        Optional<Integer> minA = aleatorios.stream().collect(minBy(Integer::compareTo));
        System.out.println("Min: " + minA.get());
        Optional<Integer> maxA = aleatorios.stream().collect(maxBy(Integer::compareTo));
        System.out.println("Max: " + maxA.toString());

        //Calculo con Streams
        separador(1, 80, '-');
        System.out.println("Uso de Opcional y calculo de máx, min y media");
        Optional<Integer> max = aleatorios.stream().max(Comparator.naturalOrder());
        Optional<Integer> min = aleatorios.stream().reduce(Integer::min);
        OptionalDouble media = aleatorios.stream().mapToInt(Integer::intValue).average();
        System.out.println("Max: " + max + "Min: " + min + "Media: " + media);

        //Letras al azar
        separador(1, 80, '-');
        System.out.println("Letras al azar");
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        Random azar = new Random();
        IntStream.range(from, to)
                .map(i -> to - i + from - 1)
                .forEach((x) -> {
                    char letra = abc.charAt(azar.nextInt(abc.length()));
                    System.out.print(" " + letra);
                });

        //Usando flatMap
        // Creando lista de cadenas 
        separador(1, 80, '-');
        System.out.println("FlatMap");
        List<String> list = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");

        // Usando Stream flatMap(Function mapper) 
        list.stream().flatMap(num -> Stream.of(num)).
                forEach(System.out::println);

        //Más usos de flatmap
        // Creando lista de cadenas 
        list = Arrays.asList("Casa", "CSS",
                "Programación", "html");

        // Usando Stream flatMap(Function mapper) 
        separador(1, 80, '-');
        System.out.println("FlatMap");
        list.stream().flatMap(str -> Stream.of(str.charAt(2)))
                .forEach(System.out::println);

        //Caso práctico de flatMap
        separador(1, 80, '-');
        System.out.println("Caso práctico de flatmap: ");
        List<String> frases = Arrays.asList(
                "la casa de la playa",
                "vamos a la playa que calienta el sol",
                "en el bosque hay una casa de madera",
                "el sol calienta la arena");
        List<String> palabrasUnicas = frases
                .stream()
                .flatMap(frase -> Stream.of(frase.split("\\s+")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Palabras únicas: " + palabrasUnicas);

        //Usando objetos
        separador(1, 80, '-');
        System.out.println("Streams usando Objetos");
        Catalogo catalogo = new Catalogo();
        catalogo.generarDatos();
        //Ver productos:

        System.out.println("Ver todos los productos");
        catalogo.catalogo.stream()
                .forEach(System.out::println);

        //Ver productos ordenados por nombre
        separador(1, 80, '-');
        System.out.println("Ver catalogo ordenado por nombre");
        catalogo.catalogo.stream()
                .sorted(comparing(Producto::getNombre))
                .forEach(System.out::println);

        separador(1, 80, '-');
        System.out.println("Filtrar productos 2>precio<4");
        catalogo.catalogo.stream()
                .filter(producto -> producto.getPrecio() > 2 && producto.getPrecio() < 4)
                .sorted(comparing(Producto::getPrecio))
                .forEach(System.out::println);

        //Obtener verduras o frutas con precio > 1 
        separador(1, 80, '-');
        System.out.println("Filtrado complejo");
        catalogo.catalogo.stream()
                .filter(producto -> producto.getPrecio() > 1
                && (producto.getTipo() == Tipo.FRUTAS
                || producto.getTipo() == Tipo.VERDURAS))
                .sorted(comparing(Producto::getTipo).thenComparing(Producto::getPrecio))
                .forEach((Producto producto) -> {
                    String result = producto.getTipo() + " "
                            + producto.getNombre() + " "
                            + producto.getPrecio();
                    System.out.println(result);
                }
                );

        separador(1, 80, '-');
        System.out.print("\nProducto más caro: ");
        Optional<String> producto = catalogo.catalogo.stream()
                .max(comparing(Producto::getPrecio))
                .map(Producto::getNombre);
        System.out.print(producto.get() + "\n");
        System.out.print("\nFruta más cara: ");
        producto = catalogo.catalogo.stream()
                .filter((Producto p) -> p.getTipo() == Tipo.FRUTAS)
                .max(comparing(Producto::getPrecio))
                .map(Producto::getNombre);
        System.out.print(producto.get() + "\n\n");

        separador(1, 80, '-');
        System.out.println("3 productos + baratos");
        catalogo.catalogo.stream()
                .sorted(comparing(Producto::getPrecio))
                .limit(3)
                .forEachOrdered(System.out::println);

        separador(1, 80, '-');
        System.out.println("Precio final despues de aplicar descuento: ");
        catalogo.catalogo.stream()
                .forEach((Producto p) -> {
                    String result;
                    result = p.getNombre() + "-> " + (p.getPrecio() * (1 - (p.getDescuento() / 100)));
                    System.out.println(result);
                });

        separador(1, 80, '-');
        System.out.println("\nContar los productos disponibles");
        System.out.println("Núm de productos: " + catalogo.catalogo.stream().count());
        separador(1, 80, '-');
        System.out.println("Agrupar por tipos");
        //Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
        // .collect(groupingBy(BlogPost::getType));
        Map<Producto.Tipo, List<Producto>> productosPorTipo = catalogo.catalogo.stream()
                .collect(groupingBy(Producto::getTipo));
        for (Tipo tipo : Tipo.values()) {
            System.out.println("Tipo: " + tipo);
            productosPorTipo.get(tipo).stream()
                    .filter((Producto p) -> p.getTipo() != Tipo.ERROR)
                    .sorted(comparing(Producto::getPrecio))
                    .forEach(System.out::println);
        }

    }

    public static void separador(int min, int max, char simbolo) {
        System.out.println("");
        IntStream.range(min, max)
                .forEach((n) -> System.out.print(simbolo));
        System.out.println("");

    }

}
