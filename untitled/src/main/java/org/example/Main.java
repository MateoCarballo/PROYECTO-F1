package org.example;

import org.example.ConexionDB.Conexion;
import org.example.TablasDB.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        HashMap<Integer, Circuito> listadoCircuitos = new HashMap<Integer, Circuito>();
        HashMap<Integer, Equipo> listadoEquipos = new HashMap<Integer, Equipo>();
        HashMap<Integer, Piloto> listadoPilotos = new HashMap<Integer, Piloto>();
        HashMap<Integer, Sala> listadoSalas  = new HashMap<Integer, Sala>();
        HashMap<Integer, Usuario> listadoUsuarios  = new HashMap<Integer, Usuario>();
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
        columnasTabla.add("IdEquipo");
        columnasTabla.add("NumeroMonoplaza");

        Conexion con1 = Conexion.singleton(url,user,password);
        con1.abrirConexion(columnasTabla,query);
    }
}