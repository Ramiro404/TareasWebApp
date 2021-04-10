package datos;

import dominio.Tarea;
//import java.util.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TareaDaoJDBC {
    
    public static final String SQL_SELECT = "SELECT id, nombre, descripcion, fecha, hora, finalizada FROM TAREA";
    public static final String SQL_INSERT = "INSERT INTO tarea(nombre, descripcion, fecha, hora, finalizada) VALUES(?, ?, ?, ?, ?)";
    public static final String SQL_SELECT_BY_ID = "SELECT nombre, descripcion, fecha, hora, finalizada FROM TAREA WHERE id=?";
    public static final String SQL_UPDATE = "UPDATE TAREA SET nombre=?, descripcion=?, fecha=?, hora=? WHERE id=?";
    public static final String SQL_DELETE = "DELETE FROM TAREA WHERE id=?";
    
    public TareaDaoJDBC() {
    }
    
    public List<Tarea> listar() {
        Tarea tarea = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Tarea> tareas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTarea = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                Boolean finalizada = rs.getBoolean("finalizada");
                tarea = new Tarea(idTarea, nombre, descripcion, fecha, hora, finalizada);
                tareas.add(tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tareas;
    }
    
    public int insertar(Tarea tarea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, tarea.getNombre());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setDate(3, (Date) tarea.getFecha());
            stmt.setTime(4, tarea.getHora());
            stmt.setBoolean(5, tarea.getFinalizada());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
    
    public Tarea encontrar(Tarea tarea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, tarea.getIdTarea());
            rs = stmt.executeQuery();
            rs.absolute(1);
            
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            Date fecha = rs.getDate("fecha");
            Time hora = rs.getTime("hora");
            Boolean finalizada = rs.getBoolean("finalizada");
            
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);
            tarea.setFecha(fecha);
            tarea.setHora(hora);
            tarea.setFinalizada(finalizada);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tarea;
    }
    
    public int actualizar(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, tarea.getNombre());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setDate(3, tarea.getFecha());
            stmt.setTime(4, tarea.getHora());
            stmt.setInt(5, tarea.getIdTarea());
            
            rows = stmt.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
    
    public int eliminar(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tarea.getIdTarea());
            rows = stmt.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
}
