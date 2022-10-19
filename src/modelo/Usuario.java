/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Herrera
 */
public class Usuario {
    private int idUsuarios;
    private String usuario;
    private String password;
    
    public Usuario(){
        
    }

    public Usuario(int idUsuarios, String usuario, String password) {
        this.idUsuarios = idUsuarios;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

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

    @Override
    public String toString() {
        return "Usuario{" + "idUsuarios=" + idUsuarios + ", usuario=" + usuario + ", password=" + password + '}';
    }
           
}
