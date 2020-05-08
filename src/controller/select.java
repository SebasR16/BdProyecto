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
        String SQL = "SELECT TOP 100 * FROM employees ORDER by emp_no DESC;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha de Contratación");
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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
        String SQL = "SELECT TOP 100* FROM departments";
        //String SQL = "SELECT * FROM departments limit 100";
        modelo.addColumn("Número de Departamento");
        modelo.addColumn("Nombre de Departamento");
       
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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
        //String SQL = "SELECT * FROM titles ORDER by emp_no DESC limit 100;";
        String SQL = "SELECT TOP 100* FROM titles ORDER by emp_no DESC;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Titulo");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
      
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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
        //String SQL = "SELECT * FROM dept_emp ORDER by emp_no DESC limit 100;";
        String SQL = "SELECT TOP 100* FROM dept_emp ORDER by emp_no DESC;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Número de Departamento");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
     
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {            
           
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
     String SQL2 = "SELECT dept_no FROM departments";
          preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            datos.add(resultSet.getString(1));
        }
        return datos;
    }
    public select() {
    }
    
     public DefaultTableModel getSalarios() throws SQLException {
         DefaultTableModel modelo = new DefaultTableModel();
        //String SQL = "SELECT * FROM salaries ORDER by emp_no DESC limit 100;";
        String SQL = "SELECT TOP 100* FROM salaries ORDER by emp_no DESC;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Salario");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            
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
        //String SQL = "SELECT * FROM dept_manager ORDER by emp_no DESC limit 100;";
        String SQL = "SELECT TOP 100* FROM dept_manager ORDER by emp_no DESC;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Número de Departamento");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
      public DefaultTableModel FindEmpleados(int id) throws SQLException {
          
        DefaultTableModel modelo = new DefaultTableModel();
          
        
        String SQL = "SELECT * FROM employees WHERE emp_no = " + id;
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha de Contratación");
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            
        
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
               
                fila[i] = resultSet.getObject(i+1);
                
            }
         modelo.addRow(fila);
         
        } 
        return modelo;
      
    }
      public DefaultTableModel  FindDepartamentos(String id) throws SQLException {
      DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM departments WHERE dept_no = '" + id +"'";
        modelo.addColumn("Número de Departamento");
        modelo.addColumn("Nombre de Departamento");
       
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
      public DefaultTableModel FindTitulos(int id) throws SQLException {
       DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM titles WHERE emp_no = " + id;
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Titulo");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
      
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
   return modelo;
    }
     public  DefaultTableModel FindDept_Manager(int id) throws SQLException {
          DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM dept_manager WHERE emp_no = " + id;
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Número de Departamento");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
     public DefaultTableModel FindSalarios(int id) throws SQLException {
         DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM salaries WHERE emp_no = " + id;
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Salario");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
    }
      public DefaultTableModel FindDept_Emp(int id) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM dept_emp WHERE emp_no = " + id;
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Número de Departamento");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
     
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {            
           
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
     
        
        return modelo;
    }
      public DefaultTableModel  getBonus() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT TOP 100 * FROM bonus ORDER by emp_no DESC;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Fecha de Bonus");
        modelo.addColumn("Cantidad de Bonus");
        modelo.addColumn("Tipo de Bonus");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
      }
        public DefaultTableModel FindEmpleadosB(int id) throws SQLException {
          
        DefaultTableModel modelo = new DefaultTableModel();
          
        
        String SQL = "SELECT * FROM bonus WHERE emp_no = " + id;
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Fecha de Bonus");
        modelo.addColumn("Cantidad de Bonus");
        modelo.addColumn("Tipo de Bonus");

        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            
        
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
               
                fila[i] = resultSet.getObject(i+1);
                
            }
         modelo.addRow(fila);
         
        } 
        return modelo;
      
    }
        public DefaultTableModel  getDeduccion() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT TOP 100 * FROM deduction ORDER by emp_no DESC;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Fecha de Deducción");
        modelo.addColumn("Cantidad de Deducción");
        modelo.addColumn("Tipo de Deducción");
        
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Object [] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultSet.getObject(i+1);
            }
         modelo.addRow(fila);
        }
        return modelo;
      }
    }

