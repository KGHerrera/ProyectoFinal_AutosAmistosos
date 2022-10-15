/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import conexionBD.ConexionBD;
import modelo.Automovil;

/**
 *
 * @author Herrera
 */
public class AutomovilDAO implements Runnable{
    private int opcion;
    private Automovil automovil;
    private boolean res = false;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }
              
    public boolean isRes(){
        return res;
    }
    
    public boolean altaAutomovil(){
        res = ConexionBD.altaAutomovil(automovil);
        return res;
    }
    
    public boolean bajaAutomovil(){
        res = ConexionBD.bajaAutomovil(automovil);
        return res;
    }
    
    public boolean cambioAutomovil(){
        res = ConexionBD.cambioAutomovil(automovil);
        return res;
    }
    
    public void consultaAutomovil(){
        ConexionBD.consultaAutomovil(automovil);
    }

    @Override
    public void run() {
        if (opcion == 1){
            altaAutomovil();
        }   
        else if (opcion == 2){
            cambioAutomovil();
        }
        else if(opcion == 3){
            bajaAutomovil();
        }
    }
    
    
    
    
}
