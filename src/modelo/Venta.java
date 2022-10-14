/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Herrera
 */
public class Venta {
    private int idAutomovil;
    private int idCliente;
    private String fechaVenta;
    private double precioAuto;
    private double costoTotal;
    private int impuesto;

    public Venta() {
    }

    public Venta(int idAutomoviles, int idClientes, String fechaVenta, double precioAuto, double costoTotal, int impuesto) {
        this.idAutomovil = idAutomoviles;
        this.idCliente = idClientes;
        this.fechaVenta = fechaVenta;
        this.precioAuto = precioAuto;
        this.costoTotal = costoTotal;
        this.impuesto = impuesto;
    }

    public int getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(int idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        return "Ventas{" + "idAutomoviles=" + idAutomovil + ", idClientes=" + idCliente + ", fechaVenta=" + fechaVenta + ", precioAuto=" + precioAuto + ", costoTotal=" + costoTotal + ", impuesto=" + impuesto + '}';
    }
}
