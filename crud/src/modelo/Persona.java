package modelo;

import java.util.Date;

public class Persona {

    private int id;
    private static int ultimoId = 1;
    private String nombre;
    private String apellido;
    private byte cantHijos;
    private String fechaNacimiento;


    public Persona(String nombre, String apellido, byte cantHijos, String fechaNacimiento) {
        this.id = ultimoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantHijos = cantHijos;
        this.fechaNacimiento = fechaNacimiento;
        ultimoId++;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public byte getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(byte cantHijos) {
        this.cantHijos = cantHijos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cantHijos=" + cantHijos +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}

