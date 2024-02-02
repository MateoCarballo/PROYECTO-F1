package org.example.TablasDB;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String clave;
    private String alias;
    private String sala;

    public Usuario(String idUsuario,String nombre,String clave,String alias,String sala){
        this.idUsuario=idUsuario;
        this.nombre=nombre;
        this.clave=clave;
        this.alias=alias;
        this.sala=sala;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
