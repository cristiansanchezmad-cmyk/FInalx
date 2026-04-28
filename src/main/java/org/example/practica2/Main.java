package org.example.practica2;

import java.sql.*;
import java.util.ArrayList;


public class Main {

    static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Connection bd = conexion();
        consulta_a_lista(bd);
        desconectar(bd);
    }

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String psw = "";
        String bd = "insti";

        try {
            conexion = DriverManager.getConnection(host + bd, user, psw);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Estudiante> consulta_a_lista(Connection conexion) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        String query = "SELECT * FROM estudiante";

        try (Statement stmt = conexion.createStatement();
             ResultSet respuesta = stmt.executeQuery(query)) {

            while (respuesta.next()) {
                lista.add(new Estudiante(
                        respuesta.getInt("nia"),
                        respuesta.getString("nombre"),
                        respuesta.getDate("fecha_nacimiento").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public static void insertar(Connection conexion, int nia, String nombre, String fecha) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO estudiante (nia, nombre, fecha_nacimiento) VALUES (");
        sb.append(nia).append(", '");
        sb.append(nombre).append("', '");
        sb.append(fecha).append("');");

        try (Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void modificar(Connection conexion, int nia, String nuevoNombre, String nuevaFecha) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE estudiante SET nombre = '");
        sb.append(nuevoNombre).append("', fecha_nacimiento = '");
        sb.append(nuevaFecha).append("' WHERE nia = ");
        sb.append(nia).append(";");

        try (Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrar(Connection conexion, Estudiante seleccionado) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM estudiante WHERE nia = ");
        sb.append(seleccionado.getNia()).append(";");

        try (Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}