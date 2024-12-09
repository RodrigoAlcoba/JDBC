package controlador;

import modelo.CRUD;
import modelo.CRUDInt;
import modelo.Persona;
import vista.Vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controlador {

    static CRUDInt crud = new CRUD();




   public static void iniciar() throws ParseException {
       Scanner scanner = new Scanner(System.in);
       Vista.mostrarMenu();
       int opcion = controlarOpcion();

       switch(opcion){
           case 1:
               System.out.println("Escriba el nombre");
               String nombre = scanner.next();
               System.out.println("Escriba el apellido");
               String apellido = scanner.next();
               System.out.println("Escriba los hijos");
               byte cantHijos = scanner.nextByte();
               System.out.println("Escriba la fecha en formato dd/MM/yyyy");
               String fechaNacimientoString = scanner.next();

                   Persona persona = new Persona(nombre, apellido, cantHijos, fechaNacimientoString);
                   crud.crearPersona(persona);
                   preguntarPorOtraFuncionalidad();
               break;

               case 2:
                   System.out.println("Estas son las personas que puede modificar");
                   crud.listarPersonas();
                   System.out.println("Ingrese el id de la persona que desea modificar");
                   int id = scanner.nextInt();
                   crud.modificarPersona(id);
                   preguntarPorOtraFuncionalidad();
                   break;

                   case 3:
                       System.out.println("Estas son las personas que pueden eliminar");
                       crud.listarPersonas();
                       System.out.println("Ingrese el id de la persona que desea modificar");
                       int id2 = scanner.nextInt();
                       crud.eliminarPersona(id2);
                       preguntarPorOtraFuncionalidad();
                       break;

                       case 4:
                           System.out.println("Listado");
                           crud.listarPersonas();
                           preguntarPorOtraFuncionalidad();
                           break;

                           case 5:
                               System.exit(0);
                               break;

           default:
               System.out.println("Opcion no valida");
       }
   }

    public static int controlarOpcion(){
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;
   }

   public static void preguntarPorOtraFuncionalidad() throws ParseException {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Desea volver al menu");
       System.out.println("Ingrese 1 si desea volver al menu, de lo contrario ingrese 2");
       int opcion = scanner.nextInt();
       if (opcion == 1){
           iniciar();
       }else {
           System.exit(0);
       }
    }
}
