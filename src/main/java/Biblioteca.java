import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;


class Libro {
    private int id;
    private String titulo;
    private String autor;

    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro [ID= " + id + ", Título= " + titulo + ", Autor= " + autor + "]";
    }
}

class Usuario {
    private int id;
    private String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

class Prestamo {
    private Libro libro;
    Usuario usuario;
    Date fechaPrestamo;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
    }

    @Override
    public String toString() {
        return "Préstamo [Libro= " + libro.getTitulo() + ", Usuario= " + usuario.getNombre() + ", Fecha= " + fechaPrestamo + "]";
    }
}

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();

    }

    
    public void agregarLibro(int id, String titulo, String autor) {
        libros.add(new Libro(id, titulo, autor));
        System.out.println("Libro agregado: " + titulo);
    }

    public Libro obtenerLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void crearUsuario(int id, String nombre) {
        usuarios.add(new Usuario(id, nombre));
        System.out.println("Usuario creado: " + nombre);
    }

    public void prestarLibro(int libroId, int usuarioId, Date fechaPrestamo) {
        Libro libro = obtenerLibroPorId(libroId);
        Usuario usuario = obtenerUsuarioPorId(usuarioId);
        if (libro != null && usuario != null) {
            prestamos.add(new Prestamo(libro, usuario));
            System.out.println("Préstamo registrado:  Libeo: " + libro.getTitulo() + " Usuario: " + usuario.getNombre() + " fecha de prestamo: " + fechaPrestamo.toString()); 
        } else {
            System.out.println("Libro o usuario no encontrado.");
            return;
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }


    public List<Prestamo> obtenerPrestamosPorUsuario(int usuarioId) {
        List<Prestamo> prestamosUsuario = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.usuario.getId() == usuarioId) {
                prestamosUsuario.add(prestamo);
            }
        }
        return prestamosUsuario;
    }



    public static void main(String[] args) {


  
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;
    
        do {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Obtener Libro por ID");
            System.out.println("3. Crear Usuario");
            System.out.println("4. Prestar Libro");
            System.out.println("5. Obtener Préstamos de Usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
    
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del libro: ");

            if (scanner.hasNextInt()) {
                    int idLibro = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese autor del libro: ");
                    String autor = scanner.nextLine();
                    biblioteca.agregarLibro(idLibro, titulo, autor);
                    break;
    
            }else{
                    System.out.println("Error: Debes ingresar un número válido.");
                    Biblioteca.main(null);
            }                      
    
                case 2:

                    System.out.print("Ingrese ID del libro: ");
                    if (scanner.hasNextInt()) {
                    int idLibroBuscar = scanner.nextInt();
                    Libro libroEncontrado = biblioteca.obtenerLibroPorId(idLibroBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
    
                    }else{
                    System.out.println("Error: Debes ingresar un número válido.");
                    Biblioteca.main(null);
                    }                      

                    
                case 3:
                    System.out.print("Ingrese ID del usuario: ");
                    
                    if (scanner.hasNextInt()) {
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    biblioteca.crearUsuario(idUsuario, nombreUsuario);
                    break;
    
                    }else{
                    System.out.println("Error: Debes ingresar un número válido.");
                    Biblioteca.main(null);
                    }
                case 4:
                    System.out.print("Ingrese ID del libro a prestar: ");

               
                    int libroId = scanner.nextInt();
                    
                    System.out.print("Ingrese ID del usuario: ");
                    int usuarioId = scanner.nextInt();
                    biblioteca.prestarLibro(libroId, usuarioId, new Date());    
                    break;
    
              

                case 5:
    
                    System.out.print("Ingrese ID del usuario: ");
                    int idUsuarioPrestamos = scanner.nextInt();
                    List<Prestamo> prestamosUsuario = biblioteca.obtenerPrestamosPorUsuario(idUsuarioPrestamos);
                    if (prestamosUsuario.isEmpty()) {
                        System.out.println("No hay préstamos para el usuario con ID " + idUsuarioPrestamos);
                    } else {
                        System.out.println("Préstamos del usuario:");
                        for (Prestamo prestamo : prestamosUsuario) {
                            System.out.println(prestamo);
                        }
                    }
                    break;
    
                

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    
        scanner.close();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }



}

        


