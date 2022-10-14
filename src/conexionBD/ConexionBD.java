/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

/**
 *
 * @author Herrera
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Automovil;

public class ConexionBD {

    private static Connection conexion = null;
    private static PreparedStatement pstm;
    private static ResultSet rs;

    private ConexionBD() {
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/autosamistosos";
            conexion = DriverManager.getConnection(URL, "enrique", "1234");
            System.out.println("se conecto con exito XD");

        } catch (ClassNotFoundException e) {

            System.out.println("Error de DRIVER");

        } catch (SQLException e) {

            System.out.println("Error de conexion en POSTGRESQL");

        }
    }

    public static Connection getConexion() {
        if (conexion == null) {
            new ConexionBD();
        }
        return conexion;
    }

    public void cerrarConexion() {
        try {
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion");
            //e.printStackTrace();
        }
    }

    public static boolean altaAutomovil(Automovil a) {
        int res = 0;
        try {

            String filtro = "INSERT INTO automoviles(idFabricantes, modelo, marca, precio, paisFabricacion, numeroPuertas, color, numeroAcientos, kilometraje) VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = conexion.prepareStatement(filtro);

            pstm.setInt(1, a.getIdFabricante());
            pstm.setString(2, a.getMarca());
            pstm.setString(3, a.getModelo());
            pstm.setDouble(4, a.getPrecio());
            pstm.setString(5, a.getPaisFabricacion());
            pstm.setByte(6, a.getNumeroPuertas());
            pstm.setString(7, a.getColor());
            pstm.setByte(8, a.getNumeroAcientos());
            pstm.setInt(9, a.getKilometraje());

            res = pstm.executeUpdate();

        } catch (SQLException error) {
            res = 0;
            error.printStackTrace();
        }

        if (res != 0) {
            return true;
        } else {
            return false;
        }

    }
    
    /*public static void main(String[] args) {
        ConexionBD.getConexion();
        
        Automovil a1 = new Automovil();
        ConexionBD.altaAutomovil(new Automovil(0, 1,"20903","chevrolet",200.0, "mexico", (byte)2, "rojo", (byte)2, 1000));
    }*/

}
