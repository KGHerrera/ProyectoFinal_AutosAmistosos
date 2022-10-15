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
public class AutomovilDAO {
    private int opcion;
    private Automovil automovil;
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
    
    public boolean altaAutomovil(Automovil a){
        res = ConexionBD.altaAutomovil(a);
        return res;
    }
    
    public boolean bajaAutomovil(Automovil a){
        res = ConexionBD.bajaAutomovil(a);
        return res;
    }
    
    public boolean cambioAutomovil(Automovil a){
        res = ConexionBD.cambioAutomovil(a);
        return res;
    }
    
    public void consultaAutomovil(Automovil a){
        ConexionBD.consultaAutomovil(a);
    }
    
    
    
    
}
