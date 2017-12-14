package net.rohisa.contactos2;

import java.util.Date;

/**
 * Created by Fernando Rojas on 5/12/2017.
 */

public class Contacto {

    private String nombre;
    private String email;
    private String descripcion;
    private Date fecha;
    private String telefono;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fechaNacimiento) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desripcion) {
        this.descripcion = desripcion;
    }
}
