package org.example.ConexionDB;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {

    private static Conexion singleton;
    private String url;
    private String user;
    private String password;
    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;

    private Conexion(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password=password;
        this.conexion= null;
        this.statement=null;
        this.resultSet=null;
    }

    public static Conexion singleton (String url, String user, String password){
        if(singleton == null){
            singleton = new Conexion(url, user, password);
        }
        return singleton;
    }

    public void abrirConexion(ArrayList<String> nombreColumnas,String query){
        try {
            conexion = DriverManager.getConnection(url,user,password);
            statement = conexion.createStatement();
            ejecutarConsultaSelect(nombreColumnas,query);
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void ejecutarConsultaSelect(ArrayList<String> consulta,String query){
        try {
            resultSet = statement.executeQuery(query);
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
