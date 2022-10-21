/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexionBD.ConexionBD;
import modelo.Fabricante;

/**
 *
 * @author Herrera
 */
public class FabricanteDAO implements Runnable{
    private int opcion;
    private Fabricante fabricante;
    private boolean res = false;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

                  
    public boolean isRes(){
        return res;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }    
        
    public boolean altaFabricante(){
        res = ConexionBD.altaFabricante(fabricante);
        return res;
    }
    
    public boolean bajaFabricante(){
        //res = ConexionBD.bajaAutomovil(fabricante);
        return res;
    }
    
    public boolean cambioFabricante(){
        res = ConexionBD.cambioFabricante(fabricante);
        return res;
    }
    
    public void consultaFabricante(){
        //ConexionBD.consultaAutomovil(fabricante);
    }

    @Override
    public void run() {
        if (opcion == 1){
            altaFabricante();
        }   
        else if (opcion == 2){
            cambioFabricante();
        }
        else if(opcion == 3){
            bajaFabricante();
        }
    }
    
}
