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
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
        DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                         
                            case 1:
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}
		
};
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
       DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                         
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
		
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
              DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                         
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
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
               DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                         
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
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
              DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                         
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
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
              DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                         
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
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
              DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                            case 1:
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
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
               DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                            case 1:
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
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
        public DefaultTableModel  getHoliday() throws SQLException {
           DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                            case 1:
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
        String SQL = "SELECT TOP 100 * FROM holiday ORDER by emp_no DESC;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Empleado");
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
        public DefaultTableModel  getSickleave() throws SQLException {
          DefaultTableModel modelo = new DefaultTableModel(){
@Override
			public boolean isCellEditable(int row, int column) {
                        switch(column){
                            case 0:
                            case 1:
                                return false;
                               
                            default:
                                return true;
                           
                        }
				
			}};
        String SQL = "SELECT TOP 100 * FROM sickleave ORDER by emp_no DESC;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        modelo.addColumn("Razon");
        
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
        public DefaultTableModel  getTipoBonus() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM bonustype;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número tipo de Bonus");
        modelo.addColumn("Descripción de Bonus");

        
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
        public DefaultTableModel  getTipoDeduccion() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM deducttype;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número tipo de Deducción");
        modelo.addColumn("Descripción de Deducción");

        
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
        public DefaultTableModel  getTipoPago() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM paytype;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número tipo de Pago");
        modelo.addColumn("Descripción tipo de Pago");

        
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
        public DefaultTableModel  getDetallesPago() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM paydetails;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Desde");
        modelo.addColumn("Número de Ruta");
        modelo.addColumn("Tipo de Cuenta");
        modelo.addColumn("Nombre de Banco");
        modelo.addColumn("Dirección de banco");
        modelo.addColumn("Número tipo de Pago");
        
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
        public DefaultTableModel  getHistorialPago() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM payhistory;";
        //String SQL = "SELECT * FROM employees ORDER by emp_no DESC limit 100;";
        modelo.addColumn("Número de Pago");
        modelo.addColumn("Número de Empleado");
        modelo.addColumn("Fecha de Pago");
        modelo.addColumn("Número de Cheque");
        modelo.addColumn("Cantidad de Pago");
        
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
        public ArrayList listBonus() throws SQLException {
        ArrayList datos = new ArrayList();
        String SQL2 = "SELECT bonus_description FROM bonustype";
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            datos.add(resultSet.getString(1));
        }
        return datos;
    }
        public ArrayList listDeduccion() throws SQLException {
        ArrayList datos = new ArrayList();
        String SQL2 = "SELECT deduct_description FROM deducttype";
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            datos.add(resultSet.getString(1));
        }
        return datos;
    }
        public ArrayList listPago() throws SQLException {
        ArrayList datos = new ArrayList();
        String SQL2 = "SELECT pay_type_description FROM paytype";
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            datos.add(resultSet.getString(1));
        }
        return datos;
    }
        public boolean getEmployee(String userId,String  sqdet) throws ParseException, SQLException {
        String SQL = "SELECT emp_no, start_date FROM paydetails WHERE emp_no = " + userId + " and start_date = '" + sqdet + "' ;";
            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
            boolean exists = false;
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos[1] = resultSet.getDate(2).toString();

            if (userId.equals(datos[0]) && sqdet.equals(datos[1])) {
                exists = true;
                JOptionPane.showMessageDialog(null, "Este usuaio ya se registro en esta Fecha");
            }

        }
        System.out.println(datos[0] + " " + datos[1]);
        if (exists) {
            return exists;
        } else {
            return false;
        }

    }
        public String[] getSalario(String userId) throws ParseException, SQLException {
        String SQL = "SELECT * FROM salaries WHERE emp_no = " + userId + " ORDER by from_date DESC;";
            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos[1] = resultSet.getString(2);
            if (userId.equals(datos[0])) {
                JOptionPane.showMessageDialog(null, "Si hay usuario");
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Este usuaio No tiene salarios registrados");
                
            }

        }
        System.out.println(datos[0] + " " + datos[1]);
            return datos;
        }
        public boolean getExisteemployee(String userId) throws ParseException, SQLException {
        String SQL = "SELECT emp_no FROM employees WHERE emp_no = " + userId + ";";
            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
            boolean exists = false;
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            
            if (!userId.equals(datos[0])) {
                exists = true;
                JOptionPane.showMessageDialog(null, "Este usuario no ha sido registrado");
            }

        }
        System.out.println(datos[0] + " " + datos[1]);
        if (exists) {
            return exists;
        } else {
            return false;
        }

    }
}

