package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CRUD implements CRUDInt {

    public CRUD() {
    }

    List<Persona> personas = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void listarPersonas() {
        for (Persona p : personas){
            System.out.println(p.toString());
        }
    }

    @Override
    public void crearPersona(Persona persona) {
        personas.add(persona);
    }

    @Override
    public void eliminarPersona(int id) {
        for (Persona p : personas) {
            if (p.getId() == id) {
                personas.remove(p);
                return;
            }
        }
        System.out.println("No existe persona con el id " + id);
    }

    @Override
    public void modificarPersona(int id) throws ParseException {
        for (Persona p : personas) {
            if (p.getId() == id) {
                System.out.println("Persona encontrada");
                System.out.println("Ingrese el nuevo nombre");
                Scanner s = new Scanner(System.in);
                String nombre = s.nextLine();
                p.setNombre(nombre);
                System.out.println("Ingrese el nuevo apellido");
                String apellido = s.nextLine();
                p.setApellido(apellido);
                System.out.println("Ingrese la nueva cantidad de hijos");
                byte cantidad = s.nextByte();
                s.nextLine();
                p.setCantHijos(cantidad);
                System.out.println("Ingrese la nueva Fecha de nacimiento");
               String fecha = s.nextLine();
               p.setFechaNacimiento(fecha);
               return;


            }else {
                System.out.println("No existe un persona con ese id");
            }
        }
    }
}