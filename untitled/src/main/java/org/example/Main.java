package org.example;

import org.example.ConexionDB.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        conectarDB();
    }

    private static void conectarDB() {
        String url = "jdbc:mysql://localhost:3306/temporadaF12024?serverTimezone=UTC";
        String user="root";
        String password="1234ñ!";
        String query ="SELECT * FROM Pilotos";
        ArrayList <String> columnasTabla = new ArrayList<>();
        columnasTabla.add("IdPiloto");
        columnasTabla.add("Nombre");
        columnasTabla.add("Apellido");
        columnasTabla.add("IdEquipqo");
        columnasTabla.add("NumeroMonoplaza");

        Conexion con1 = Conexion.singleton(url,user,password);
        con1.abrirConexion(columnasTabla,query);
    }
}