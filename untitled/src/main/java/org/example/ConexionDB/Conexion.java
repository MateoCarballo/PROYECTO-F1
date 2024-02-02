package org.example.ConexionDB;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {
    String url;
    String user;
    String password;
    Connection conexion;
    Statement statement;
    ResultSet resultSet;

    public Conexion(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password=password;
        this.conexion= null;
        this.statement=null;
        this.resultSet=null;
    }


    public void abrirConexion(ArrayList<String> nombreColumnas,String query){
        try {
            conexion = DriverManager.getConnection(url,user,password);
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);
            ejecutarConsulta(nombreColumnas);
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void ejecutarConsulta(ArrayList<String> consulta){
        /*
        System.out.println(resultSet.getString("")+" | "+resultSet.getString("Nombre")+" | "+resultSet.getString("Apellido")
                            +" | "+resultSet.getString("IdEquipo")+" | "+resultSet.getString("NumeroMonoplaza"));

                    }
         */
            try {
                while(resultSet.next()) {
                    for (String nombreColumna : consulta) {
                        System.out.print( resultSet.getString(nombreColumna)+" |");
                    }
                    System.out.println(" ");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
    private void cerrarConexion() {
        try {
            conexion.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
