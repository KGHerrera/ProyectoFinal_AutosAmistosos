/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Herrera
 */
public class Automovil {
    private int idAutomovil;
    private int idFabricante;
    private String modelo;
    private String marca;
    private double precio;
    private String paisFabricacion;
    private byte numeroPuertas;
    private String color;
    private byte numeroAcientos;
    private int kilometraje;

    public Automovil() {
    }

    public Automovil(int idAutomoviles, int idFabricantes, String modelo, String marca, double precio, String paisFabricacion, byte numeroPuertos, String color, byte numeroAcientos, int kilometraje) {
        this.idAutomovil = idAutomoviles;
        this.idFabricante = idFabricantes;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.paisFabricacion = paisFabricacion;
        this.numeroPuertas = numeroPuertos;
        this.color = color;
        this.numeroAcientos = numeroAcientos;
        this.kilometraje = kilometraje;
    }

    public int getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(int idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public byte getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(byte numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte getNumeroAcientos() {
        return numeroAcientos;
    }

    public void setNumeroAcientos(byte numeroAcientos) {
        this.numeroAcientos = numeroAcientos;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }    
}
