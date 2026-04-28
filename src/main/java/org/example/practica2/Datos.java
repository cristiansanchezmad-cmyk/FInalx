package org.example.practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.practica2.Estudiante;

import java.sql.*;
import java.time.LocalDate;

public class Datos {
    public static void main(String[] args) {

        Connection bd = conexion();
        System.out.println("Realizando consultas...");
        desconectar(bd);

    }

    public static void insertar(Connection conexion, Estudiante estudiante){

        System.out.println("Insertando...");



        String query ="";//        String query = "INSERT INTO `estudiante` (`nia`, `nombre`, `fecha_nacimiento`) VALUES (211, 'Christian', '2024-04-16')";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }


    public static void modificar(Connection conexion, Estudiante estudiante){

        System.out.println("Modificando...");



        String query = "UPDATE estudiante SET  nia = '"+estudiante.getNia()+"' ," +
                "nombre = '"+estudiante.getNombre()+"', fecha_nacimiento='"+
                estudiante.getFecha_nacimiento()+"' WHERE nia = '"+estudiante.getNia()+"'";


        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String psw = "";
        String bd = "insti";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void eliminar(Connection conexion, Estudiante estudiante){

        System.out.println("Eliminando...");



        String query = "DELETE FROM insti WHERE nia = "+estudiante.getNia()+"'";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }


    public static ObservableList<Estudiante> consulta (Connection conexion){

        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

        String query = "SELECT * FROM estudiante";

        //necesitamos dos variables de tipo Statement y ResultSet para realizar la consulta y guardar la respuesta
        Statement stmt;
        ResultSet respuesta;

        try {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){ //recorremos todas las filas existentes en la tabla y las imprimimos
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                LocalDate fecha_nacimiento = respuesta.getDate("fecha_nacimiento").toLocalDate();
                listaEstudiantes.add(new Estudiante(nia,nombre,fecha_nacimiento));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return listaEstudiantes;
    }

    public static void desconectar(Connection conexion){

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}