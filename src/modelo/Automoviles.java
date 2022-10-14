/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Herrera
 */
public class Automoviles {
    private int idAutomoviles;
    private String modelo;
    private String marca;
    private double precio;
    private String paisFabricacion;
    private byte numeroPuertos;
    private String color;
    private byte numeroAcientos;
    private int kilometraje;

    public Automoviles() {
    }
    
    public Automoviles(int idAutomoviles, String modelo, String marca, double precio, String paisFabricacion, byte numeroPuertos, String color, byte numeroAcientos, int kilometraje) {
        this.idAutomoviles = idAutomoviles;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.paisFabricacion = paisFabricacion;
        this.numeroPuertos = numeroPuertos;
        this.color = color;
        this.numeroAcientos = numeroAcientos;
        this.kilometraje = kilometraje;
    }

    public int getIdAutomoviles() {
        return idAutomoviles;
    }

    public void setIdAutomoviles(int idAutomoviles) {
        this.idAutomoviles = idAutomoviles;
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

    public byte getNumeroPuertos() {
        return numeroPuertos;
    }

    public void setNumeroPuertos(byte numeroPuertos) {
        this.numeroPuertos = numeroPuertos;
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

    @Override
    public String toString() {
        return "Automoviles{" + "idAutomoviles=" + idAutomoviles + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", paisFabricacion=" + paisFabricacion + ", numeroPuertos=" + numeroPuertos + ", color=" + color + ", numeroAcientos=" + numeroAcientos + ", kilometraje=" + kilometraje + '}';
    }    
}
