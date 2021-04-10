package dominio;

import java.sql.Time;
import java.sql.Date;

public class Tarea {
    int idTarea;
    String nombre;
    String descripcion;
    Date fecha;
    Time hora;
    Boolean finalizada;
    
    public Tarea(){}
    
    public Tarea(int idTarea){
        this.idTarea = idTarea;
    }

    public Tarea(String nombre, String descripcion, Date fecha, Time hora, Boolean finalizada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.finalizada = finalizada;
    }

    public Tarea(int idTarea, String nombre, String descripcion, Date fecha, Time hora, Boolean finalizada) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.finalizada = finalizada;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }
    
    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + ", finalizada=" + finalizada + '}';
    }
    
    
}
