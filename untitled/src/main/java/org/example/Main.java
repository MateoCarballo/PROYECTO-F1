package org.example;

import org.example.ConexionDB.Conexion;
import org.example.TablasDB.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static Conexion con1 = null;
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
        con1 = Conexion.singleton(url,user,password);

    }

    public static void cargarDatosEnClases(){
        String querySelectAll ="SELECT * FROM ";
        String[] tablas = {"Circuitos", "Equipos", "Pilotos", "Salas", "Usuarios"};

        String fullQuery = querySelectAll + tablas[0];

        ArrayList <String> columnasTablaCircuitos = new ArrayList<>();
        columnasTablaCircuitos.add("IdCircuito");
        columnasTablaCircuitos.add("Nombre");
        columnasTablaCircuitos.add("Longitud");
        columnasTablaCircuitos.add("Ubicacion");

        ArrayList <String> columnasTablaPilotos = new ArrayList<>();
        columnasTablaPilotos.add("IdPiloto");
        columnasTablaPilotos.add("Nombre");
        columnasTablaPilotos.add("Apellido");
        columnasTablaPilotos.add("IdEquipo");
        columnasTablaPilotos.add("NumeroMonoplaza");
        con1.abrirConexion(columnasTablaPilotos,querySelectAll);


    }
}