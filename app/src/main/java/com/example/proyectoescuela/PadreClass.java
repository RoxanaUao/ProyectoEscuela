package com.example.proyectoescuela;

public class PadreClass {
    private String cedula, correo, nombre, telefono, contraseña, carril;

    public PadreClass(String cedula, String correo, String nombre, String telefono, String contraseña, String carril) {
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.carril = carril;
    }

    // Getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCarril() {
        return carril;
    }

    public void setCarril(String carril) {
        this.carril = carril;
    }
}

