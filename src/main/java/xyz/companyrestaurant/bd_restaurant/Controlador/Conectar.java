
package xyz.companyrestaurant.bd_restaurant.Controlador;

import java.sql.*;
import static xyz.companyrestaurant.bd_restaurant.Controlador.Conectar.getConexion;

public class Conectar {
    public static synchronized Connection getConexion() {
    Connection conex = null;
    try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String usr = "JSDEV";//
            String psw = "1234";
            conex = DriverManager.getConnection(url, usr, psw);
            System.out.println("Conexion Realizada");
	} catch (ClassNotFoundException ex) {
		System.out.println("Error >> Driver no Instalado!!");
	} catch (SQLException ex) {
		System.out.println(ex+"Error >> de conexion con la BD");
	}
    return conex;
    }
}


