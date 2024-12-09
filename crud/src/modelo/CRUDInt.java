package modelo;

import java.text.ParseException;
import java.util.List;

public interface CRUDInt {

    void listarPersonas();
    void crearPersona(Persona persona);
    void eliminarPersona(int id);
    void modificarPersona(int id) throws ParseException;

}
