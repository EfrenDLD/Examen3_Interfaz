package Admin;

public class Vacante {
    public String nombres;
    private String nombre;
    private String numero;
    private String experiencia;
    private String fecha;
    private String sueldo;
    private String descripcion;

    public Vacante(String nombre, String numero, String experiencia, String fecha, String sueldo, String descripcion) {
        this.nombre = nombre;
        this.numero = numero;
        this.experiencia = experiencia;
        this.fecha = fecha;
        this.sueldo = sueldo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSueldo() {
        return sueldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Vacantes{" +
                "Nombre Vacante='" + nombre + '\'' +
                ", Numero de vacante='" + numero + '\'' +
                ", Experiencia'" + experiencia + '\'' +
                ", Fecha Publicacion='" + fecha + '\'' +
                ", Sueldo ='" + sueldo + '\'' +
                ", Descricpion vacante='" + descripcion + '\'' +
                '}';
    }
}
