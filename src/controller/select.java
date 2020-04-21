/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Vista.BaseDeDatos;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class select {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
     Connection con = null;
    public select(Connection con) {
        this.con=con;
    }
    public DefaultTableModel  getEmpleados() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("emp_no");
        modelo.addColumn("birth_date");
        modelo.addColumn("First_name");
        modelo.addColumn("Last_name");
        modelo.addColumn("Gender");
        modelo.addColumn("HireDate");
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id_docente, String nombre, String apellido, String alias
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
  public DefaultTableModel  getDepartamentos() throws SQLException {
      DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM departments limit 100";
        modelo.addColumn("dept_no");
        modelo.addColumn("dept_name");
       
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id_docente, String nombre, String apellido, String alias
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
   public DefaultTableModel getTitulos() throws SQLException {
       DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM titles ORDER by emp_no DESC limit 100;";
        modelo.addColumn("emp_no");
        modelo.addColumn("title");
        modelo.addColumn("From_date");
        modelo.addColumn("To_date");
      
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id_docente, String nombre, String apellido, String alias
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
   return modelo;
    }
    public DefaultTableModel getDept_Emp() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM dept_emp ORDER by emp_no DESC limit 100;";
        modelo.addColumn("emp_no");
        modelo.addColumn("dept_no");
        modelo.addColumn("From_date");
        modelo.addColumn("To_date");
     
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id_docente, String nombre, String apellido, String alias
            
           
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
     
        
        return modelo;
    }
 public ArrayList listDepartamentos() throws SQLException{
     ArrayList datos=new ArrayList();
     String SQL2 = "SELECT dept_no FROM departments ";
          preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            datos.add(resultSet.getString(1));
             //departamento.addItem(resultSet.getString(1));
              //departamento1.addItem(resultSet.getString(1));
        }
        return datos;
    }
    public select() {
    }
    
     public DefaultTableModel getSalarios() throws SQLException {
         DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM salaries ORDER by emp_no DESC limit 100;";
        modelo.addColumn("emp_no");
        modelo.addColumn("salary");
        modelo.addColumn("From_date");
        modelo.addColumn("To_date");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id_docente, String nombre, String apellido, String alias
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
      public  DefaultTableModel getDept_Manager() throws SQLException {
          DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM dept_manager ORDER by emp_no DESC limit 100;";
        modelo.addColumn("emp_no");
        modelo.addColumn("dept_no");
        modelo.addColumn("From_date");
        modelo.addColumn("To_date");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //int id_docente, String nombre, String apellido, String alias
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
}
