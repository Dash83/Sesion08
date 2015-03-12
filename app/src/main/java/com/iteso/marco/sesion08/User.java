package com.iteso.marco.sesion08;

/**
 * Created by marco on 3/11/15.
 */
public class User {
    private String usuario;
    private String password;
    private boolean isLogged;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
}
