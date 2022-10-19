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
import javax.swing.JTable;
import modelo.Automovil;
import modelo.Fabricante;
import vista.ResultSetTableModel;

public class ConexionBD {

    private static Connection conexion = null;
    private static PreparedStatement pstm;
    private static ResultSet rs;
    private static String url = "jdbc:postgresql://localhost:5432/autosamistosos";
    private static String costrolador = "org.postgresql.Driver";

    private ConexionBD() {
        try {
            Class.forName(costrolador);
            conexion = DriverManager.getConnection(url, "enrique", "1234");
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

    public static boolean altaAutomovil(Automovil a) throws SQLException {
        int res = 0;
        try {
            // TRANSACCION ALTAS
            conexion.setAutoCommit(false);
                
            String consulta = "INSERT INTO automoviles(idFabricantes, modelo, marca, precio, paisFabricacion, numeroPuertas, color, numeroAcientos, kilometraje) VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = conexion.prepareStatement(consulta);

            pstm.setInt(1, a.getIdFabricante());
            pstm.setString(2, a.getModelo());
            pstm.setString(3, a.getMarca());
            pstm.setDouble(4, a.getPrecio());
            pstm.setString(5, a.getPaisFabricacion());
            pstm.setByte(6, a.getNumeroPuertas());
            pstm.setString(7, a.getColor());
            pstm.setByte(8, a.getNumeroAcientos());
            pstm.setInt(9, a.getKilometraje());

            res = pstm.executeUpdate();
            
            // SE EJECUTA SI NO EXISTE ERROR
            conexion.commit();
            
        } catch (SQLException error) {
            res = 0;
            
            // REGRESA AL ESTADO ANTERIOR
            conexion.rollback();
            error.printStackTrace();
        }

        if (res != 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean altaFabricante(Fabricante f) throws SQLException {
        int res = 0;
        try {
            
            // TRANSACCION ALTAS
            conexion.setAutoCommit(false);
            String consulta = "INSERT INTO fabricantes(nombre, direccion, telefono) VALUES (?,?,?)";
            pstm = conexion.prepareStatement(consulta);

            pstm.setString(1, f.getNombre());
            pstm.setString(2, f.getDireccion());
            pstm.setString(3, f.getTelefono());

            res = pstm.executeUpdate();
            
            // SE EJECUTA SI NO EXISTE ERROR
            conexion.commit();

        } catch (SQLException error) {
            res = 0;
            
            // REGRESA AL ESTADO ANTERIOR
            conexion.rollback();
            error.printStackTrace();
        }

        if (res != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean bajaAutomovil(Automovil a) throws SQLException {
        try {
            // TRANSACCION
            conexion.setAutoCommit(false);
            
            String consulta = "DELETE FROM automoviles WHERE idAutomoviles=?";
            pstm = conexion.prepareStatement(consulta);
            pstm.setInt(1, a.getIdAutomovil());
            int res = pstm.executeUpdate();
            
            // SE EJECUTA SI NO EXISTE ERROR
            conexion.commit();
            
            if (res != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException error) {
            
            // REGRESA AL ESTADO ANTERIOR
            conexion.rollback();
            error.printStackTrace();
        }

        return false;
    }

    public static boolean cambioAutomovil(Automovil a) throws SQLException {
        int res = 0;
        try {
            
            // TRANSACCION
            conexion.setAutoCommit(false);
            
            String consulta = "UPDATE automoviles SET "
                    + "idFabricantes=?, modelo=?, marca=?, precio=?, "
                    + "paisFabricacion=?, numeroPuertas=?, color=?, "
                    + "numeroAcientos=?, kilometraje=? WHERE idAutomoviles=?";
            pstm = conexion.prepareStatement(consulta);

            pstm.setInt(1, a.getIdFabricante());
            pstm.setString(2, a.getModelo());
            pstm.setString(3, a.getMarca());
            pstm.setDouble(4, a.getPrecio());
            pstm.setString(5, a.getPaisFabricacion());
            pstm.setByte(6, a.getNumeroPuertas());
            pstm.setString(7, a.getColor());
            pstm.setByte(8, a.getNumeroAcientos());
            pstm.setInt(9, a.getKilometraje());
            pstm.setInt(10, a.getIdAutomovil());

            res = pstm.executeUpdate();
            
            // SE CONFIRMAN LOS CAMBIOS
            conexion.commit();

        } catch (Exception ex) {
            
            // REGRESA AL ESTADO ANTERIOR
            conexion.rollback();
            res = 0;
            //System.out.println(ex.toString());
        }

        if (res != 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void actualizarTabla(JTable tabla,String nombreTabla, String order) {
        String consulta;
        consulta = "SELECT * FROM " + nombreTabla + " ORDER BY " + order + "";

        ResultSetTableModel modeloDatos = null;

        try {
            modeloDatos = new ResultSetTableModel(costrolador, url,
                    consulta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tabla.setModel(modeloDatos);

    }

    public static void actualizarTablaAutomovilesFiltro(JTable tabla, String campo, String filtro) {
        String consulta;
        consulta = "SELECT * FROM AUTOS_FABRICANTES WHERE " + campo + " LIKE '" + filtro + "%' ORDER BY idAutomoviles";
        ResultSetTableModel modeloDatos = null;

        try {
            modeloDatos = new ResultSetTableModel(costrolador, url,
                    consulta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(modeloDatos);
    }

    public static ResultSetTableModel consultaAutomovil(Automovil a) {

        ResultSetTableModel modeloDatos = null;
        String consulta = "SELECT * FROM AUTOS_FABRICANTES WHERE ";
        consulta += generarConsultaAutomovilModel(a);

        try {
            modeloDatos = new ResultSetTableModel(costrolador, url,
                    consulta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modeloDatos;
    }

    public static String generarConsultaAutomovilModel(Automovil a) {

        String consulta = "";
        if (a.getIdAutomovil() != 0) {
            consulta += "idAutomoviles='" + a.getIdAutomovil() + "' and ";
        }

        if (a.getIdFabricante() != 0) {
            consulta += "idFabricantes='" + a.getIdFabricante() + "' and ";
        }

        if (a.getModelo() != null) {
            consulta += "modelo='" + a.getModelo() + "' and ";
        }

        if (a.getMarca() != null) {
            consulta += "marca='" + a.getMarca() + "' and ";
        }

        if (a.getPrecio() != 0.0) {
            consulta += "precio='" + a.getPrecio() + "' and ";
        }

        if (a.getPaisFabricacion() != null) {
            consulta += "paisFabricacion='" + a.getPaisFabricacion() + "' and ";
        }

        if (a.getNumeroPuertas() != (byte) 0) {
            consulta += "numeroPuertas='" + a.getNumeroPuertas() + "' and ";
        }

        if (a.getNumeroAcientos() != (byte) 0) {
            consulta += "numeroAcientos='" + a.getNumeroAcientos() + "' and ";
        }

        if (a.getColor() != null) {
            consulta += "color='" + a.getColor() + "' and ";
        }

        if (a.getKilometraje() != 0) {
            consulta += "kilometraje='" + a.getKilometraje() + "' and ";
        }

        if ((consulta.substring(consulta.length() - 4, consulta.length()).equals("and "))) {
            consulta = consulta.substring(0, consulta.length() - 4);
        }

        return consulta;
    }
}
