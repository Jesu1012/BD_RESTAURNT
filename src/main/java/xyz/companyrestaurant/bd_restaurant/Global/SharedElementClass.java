/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xyz.companyrestaurant.bd_restaurant.Global;

import static xyz.companyrestaurant.bd_restaurant.Controlador.Conectar.getConexion;
//import Modelo.Detalle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import static xyz.companyrestaurant.bd_restaurant.Global.SharedElementClass.FondoTitulo;
import static xyz.companyrestaurant.bd_restaurant.Global.SharedElementClass.TextTitulo;

public class SharedElementClass {
    
    public static Color FondoTitulo=new Color(255,127,80);
    public static Color TextTitulo=new Color(255,255,255);
    public static Color FondoFrm=new Color(245,222,179);
    public static String Empresa="My Primer Negocio";
    
    public static String getHoy(){
        LocalDate todaysDate = LocalDate.now();
     return todaysDate.toString();
    }
    public static DefaultComboBoxModel getModeloCbo(String Sql,int col) {
       DefaultComboBoxModel Modelo = new DefaultComboBoxModel();
       Statement Acceso=null; 
       try{
           Acceso=getConexion().createStatement();
           ResultSet Consulta=null;       
           Consulta=Acceso.executeQuery(Sql);
           while(Consulta.next()){
               Modelo.addElement(Consulta.getString(col));
           }
      }
     catch(SQLException e) {System.out.println(""+e);}
     return Modelo;  
   }   
    public static DefaultListModel getModeloLst(String Sql,int col) {
        DefaultListModel Modelo = new DefaultListModel();
        Statement Acceso=null; 
        try{
            Acceso=getConexion().createStatement();
            ResultSet Consulta=null;       
            Consulta=Acceso.executeQuery(Sql);
            while(Consulta.next()){
                Modelo.addElement(Consulta.getString(col));
            }
       }
      catch(SQLException e) {System.out.println(""+e);}
      return Modelo;  
    } 
    public static void LayoutTable(JTable tbl,int[] Ancho){
        JTableHeader jtableHeader = tbl.getTableHeader();
        jtableHeader.setDefaultRenderer(new EncabezadosTabla());
        tbl.setTableHeader(jtableHeader);  
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl.doLayout();    
        tbl.setRowHeight(25);     
        int Cols=tbl.getColumnCount();
        for (int i = 0; i < Cols; i++) 
           tbl.getColumnModel().getColumn(i).setPreferredWidth(Ancho[i]);

        for(int vColIndex = 0;vColIndex<Cols;++vColIndex){
            TableColumn col = tbl.getColumnModel().getColumn(vColIndex);
            col.setCellRenderer(new CellRenderer());
        }
      }
    
    
    }


class CellRenderer extends JTextField 
        implements TableCellRenderer {
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    boolean hasFocus, int rowIndex, int vColIndex) {
    if(value==null)value=" ";
    setText(value.toString());
    setFont(new Font("Tahoma", 1, 13));
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    if (isSelected) {                
            setBackground(new Color(150,204,255) );   
        }
        else
        {
            setBackground(Color.white);
        }
    return this;
  }
}
class EncabezadosTabla 
        implements TableCellRenderer { 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;       
        if( value instanceof String ) {
            jcomponent = new JLabel((String) value);
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 30, jcomponent.getWidth() );   
            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
        }         
        jcomponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
        jcomponent.setOpaque(true);
        jcomponent.setBackground(FondoTitulo);
        jcomponent.setForeground(TextTitulo);  
        jcomponent.setFont(new Font("Tahoma", 1, 19));
        return jcomponent;
    }
}
