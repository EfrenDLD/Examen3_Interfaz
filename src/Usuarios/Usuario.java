package Usuarios;

import java.security.PrivateKey;

public class Usuario {
    private String nombre;
    private String edad;
    private String nivel;
    private String correo;
    private String telefono;

    public Usuario(String nombre, String edad, String nivel, String correo, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivel = nivel;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
    @Override
    public String toString() {
        return "Usuarios{" +
                "Nombre completo='" + nombre + '\'' +
                ", Nivel de estudio='" + nivel + '\'' +
                ", Edad '" + edad + '\'' +
                ", Correo='" + correo + '\'' +
                ", Telefono ='" + telefono + '\'' +
                '}';
    }
}
