package org.example.TablasDB;

public class Sala {
    private String idSala;
    private String nombre;
    //TODO como crear las salas para jugar, deberia usar algun tipo de lista para almacenar los usuarios?
    private String usuario1;
    private String usuario2;
    private String usuario3;
    private String usuario4;

    public Sala(String idSala,String nombre,String usuario1,String usuario2,String usuario3,String usuario4){

    }
    public Sala(String idSala,String nombre,String usuario1){

    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(String usuario2) {
        this.usuario2 = usuario2;
    }

    public String getUsuario3() {
        return usuario3;
    }

    public void setUsuario3(String usuario3) {
        this.usuario3 = usuario3;
    }

    public String getUsuario4() {
        return usuario4;
    }

    public void setUsuario4(String usuario4) {
        this.usuario4 = usuario4;
    }
}
