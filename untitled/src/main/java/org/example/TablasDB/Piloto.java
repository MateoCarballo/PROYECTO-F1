package org.example.TablasDB;

public class Piloto {
    private String idPiloto;
    private String nombre;
    private String apellido;
    private String idEquipo;
    private String numeroMonoplaza;

    public Piloto(String idPiloto,String nombre,String apellido,String idEquipo,String numeroMonoplaza){
        this.idPiloto=idPiloto;
        this.nombre=nombre;
        this.apellido=apellido;
        this.idEquipo=idEquipo;
        this.numeroMonoplaza=numeroMonoplaza;
    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNumeroMonoplaza() {
        return numeroMonoplaza;
    }

    public void setNumeroMonoplaza(String numeroMonoplaza) {
        this.numeroMonoplaza = numeroMonoplaza;
    }
}
