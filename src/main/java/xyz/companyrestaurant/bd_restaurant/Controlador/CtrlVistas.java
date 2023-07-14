/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xyz.companyrestaurant.bd_restaurant.Controlador;



import java.sql.*;
import javax.swing.table.DefaultTableModel;
import static xyz.companyrestaurant.bd_restaurant.Controlador.Conectar.getConexion;


public class CtrlVistas {
    //Only nameTable
    public static DefaultTableModel getModeloTabla(String nameTable) {

        String Sql = "Select * from "+nameTable;
        ResultSetMetaData rsmetadatos; 
        DefaultTableModel Modelo = new DefaultTableModel();
        Statement Acceso=null; 
        try{
            Acceso=getConexion().createStatement();
            ResultSet Consulta=null;       
            Consulta=Acceso.executeQuery(Sql);
            rsmetadatos =  Consulta.getMetaData();
            int Cols=rsmetadatos.getColumnCount();
            String[] etiquetas =new String[Cols];
            for(int i=0;i<Cols;i++)
                etiquetas[i]=rsmetadatos.getColumnLabel(i+1);
            Modelo.setColumnIdentifiers(etiquetas);
            Object[] datosFila = new Object[Cols];
            while(Consulta.next()){
                for(int i=0;i<Cols;++i){
                    datosFila[i]=Consulta.getString(i+1);  
                }
                Modelo.addRow(datosFila);
            }
       }
      catch(SQLException e) {System.out.println(""+e);}
      return Modelo;  
    }
    //Sql --> example sql = "Select * from Cargo"
    public static DefaultTableModel getModeloTabla2(String sql) {
        ResultSetMetaData rsMetaData;
        DefaultTableModel modelo = new DefaultTableModel();
        Statement acceso = null;
        try {
            acceso = getConexion().createStatement();
            ResultSet consulta = null;
            consulta = acceso.executeQuery(sql);
            rsMetaData = consulta.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            String[] etiquetas = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                etiquetas[i] = rsMetaData.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(etiquetas);
            Object[] datosFila = new Object[columnCount];
            while (consulta.next()) {
                for (int i = 0; i < columnCount; ++i) {
                    datosFila[i] = consulta.getString(i + 1);
                }
                modelo.addRow(datosFila);
            }
        } catch (SQLException e) {
            System.out.println("" + e);
        }
        return modelo;
    }


}
