/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Herrera
 */
public class Ventas {
    private int idAutomoviles;
    private int idClientes;
    private String fechaVenta;
    private double precioAuto;
    private double costoTotal;
    private int impuesto;

    public Ventas() {
    }

    public Ventas(int idAutomoviles, int idClientes, String fechaVenta, double precioAuto, double costoTotal, int impuesto) {
        this.idAutomoviles = idAutomoviles;
        this.idClientes = idClientes;
        this.fechaVenta = fechaVenta;
        this.precioAuto = precioAuto;
        this.costoTotal = costoTotal;
        this.impuesto = impuesto;
    }

    public int getIdAutomoviles() {
        return idAutomoviles;
    }

    public void setIdAutomoviles(int idAutomoviles) {
        this.idAutomoviles = idAutomoviles;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getPrecioAuto() {
        return precioAuto;
    }

    public void setPrecioAuto(double precioAuto) {
        this.precioAuto = precioAuto;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "Ventas{" + "idAutomoviles=" + idAutomoviles + ", idClientes=" + idClientes + ", fechaVenta=" + fechaVenta + ", precioAuto=" + precioAuto + ", costoTotal=" + costoTotal + ", impuesto=" + impuesto + '}';
    }
}
