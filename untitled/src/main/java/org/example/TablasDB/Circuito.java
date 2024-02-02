package org.example.TablasDB;

public class Circuito {
    private String idCircuito;
    private String nombre;
    private String longitud;
    private String ubicacion;

    public Circuito(String idCircuito,String nombre, String longitud, String ubicacion){
        this.idCircuito=idCircuito;
        this.nombre=nombre;
        this.longitud=longitud;
        this.ubicacion=ubicacion;
    }

    public String getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(String idCircuito) {
        this.idCircuito = idCircuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
