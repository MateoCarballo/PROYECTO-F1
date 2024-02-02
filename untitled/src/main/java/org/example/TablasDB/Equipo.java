package org.example.TablasDB;

public class Equipo {
    // TODO Deberia meter en alguna lista a los pilotos?
    private String idEquipo;
    private String nombre;
    private String piloto1;
    private String piloto2;
    private String pilotoReserva;

    public Equipo(String idEquipo, String nombre, String piloto1, String piloto2, String pilotoReserva){
        this.idEquipo=idEquipo;
        this.nombre=nombre;
        this.piloto1=piloto1;
        this.piloto2=piloto2;
        this.pilotoReserva=pilotoReserva;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPiloto1() {
        return piloto1;
    }

    public void setPiloto1(String piloto1) {
        this.piloto1 = piloto1;
    }

    public String getPiloto2() {
        return piloto2;
    }

    public void setPiloto2(String piloto2) {
        this.piloto2 = piloto2;
    }

    public String getPilotoReserva() {
        return pilotoReserva;
    }

    public void setPilotoReserva(String pilotoReserva) {
        this.pilotoReserva = pilotoReserva;
    }
}
