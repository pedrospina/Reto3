import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import com.devsenior.cdiaz.model.Book;
import com.devsenior.cdiaz.service.BookService;
public class Main {

    private BookService service;
    public static void main(String[] args) {

        
        System.out.println("Hello world!");


 //      BookService libreria = BookService.getInstancia();

      
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

         while (!salir) {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE EMERGENCIAS ===");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Consultar libro");
            System.out.println("3. Registrar un usuario");
            System.out.println("4. Realizar un prestamo");
            System.out.println("5. Consultar Préstamos por Usuario");
            System.out.println("6. Finalizar jornada (cerrar sistema)");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                   var isbn = sc.nextLine();
                    var title = sc.nextLine();
                    var author = sc.nextLine(); 
                  //  books.add(new Book(isbn, title, author));
                    break;
                case 2:
               //     libreria.mostrarEstadoRecursos();
                    break;
                case 3:
                //    atenderEmergenciaMenu(libreria, sc);
                    break;
                case 4:
                //    libreria.mostrarEstadisticas();
                    break;
                case 5:
                //    libreria.mostrarEstadisticas();
                    break;
                case 6:
                    System.out.println("Finalizando jornada...");
               //     libreria.finalizarJornada();
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
    }

   
}


