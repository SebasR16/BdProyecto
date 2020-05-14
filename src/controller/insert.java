/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Vista.BaseDeDatos;
import Vista.Empleados;
import java.awt.List;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class insert {
     PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
     Connection con = null;
        public insert(Connection con) {
        this.con=con;}
    public void setEmpleados(String userId, java.sql.Date  sqdet, String Primernombre, String Apellido, String Genero,java.sql.Date  sqdet1 ) throws ParseException, SQLException {
       
        String SQL = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date)VALUES(?,?,?,?,?,?)";
    
        PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setDate(2, sqdet);
            pst.setString(3, Primernombre);
            pst.setString(4, Apellido);
            pst.setString(5,  Genero);
            pst.setDate(6, sqdet1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
            
    }
      public boolean setDepartamentos(String id, String name) throws ParseException, SQLException {
          
        boolean exists = false;
        String SQL1 = "INSERT INTO departments(dept_no,dept_name)VALUES(?,?)";
        String SQL = "SELECT TOP 100 * FROM departments;";
        //String SQL = "SELECT * FROM departments limit 100;";
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();

        String[] datos = new String[2];
       
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos[1] = resultSet.getString(2);
            System.out.println(datos[0]);
            if (id.equals(datos[0]) || name.equals(datos[1])) {
                exists = true;
                JOptionPane.showMessageDialog(null,"Ya existe este departamento");

            }
        }
        if (exists) {
            return exists;
        } else {

            PreparedStatement pst = con.prepareStatement(SQL1);
            pst.setString(1, "d"+id);
            pst.setString(2, name);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
            return false;
        }

    }
      public void setTitulos(String Numemp, String Title,java.sql.Date  sqdet,java.sql.Date  sqdet1 ) throws ParseException {
        String SQL = "INSERT INTO titles(emp_no,title,from_date,to_date)VALUES(?,?,?,?)";
       
        
        try {
            
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(Numemp));
            pst.setString(2, Title);
            pst.setDate(3, sqdet); 
            pst.setDate(4, sqdet1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
            
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void setSalarios(String Numempleado, String Salario,java.sql.Date sqdet, java.sql.Date sqdet1) throws ParseException, SQLException {
        String SQL = "INSERT INTO salaries(emp_no,salary,from_date,to_date)VALUES(?,?,?,?)";
         PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(Numempleado));
            pst.setString(2, Salario);
            pst.setDate(3, sqdet); 
            pst.setDate(4, sqdet1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
    }
      public void setDept_emp(String Numemp1, String departamento, java.sql.Date  sqdet,java.sql.Date  sqdet1) throws ParseException, SQLException {
        String SQL = "INSERT INTO dept_emp(emp_no,dept_no,from_date,to_date)VALUES(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(Numemp1));
            pst.setString(2, departamento);
            pst.setDate(3, sqdet); 
            pst.setDate(4, sqdet1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
    }
      public void setDept_manager(String Numemp2, String departamento1, java.sql.Date  sqdet,java.sql.Date  sqdet1) throws ParseException {
         try {
             String SQL = "INSERT INTO dept_manager(emp_no,dept_no,from_date,to_date)VALUES(?,?,?,?)";
             PreparedStatement pst = con.prepareStatement(SQL);
             pst.setInt(1, Integer.parseInt(Numemp2));
             pst.setString(2, departamento1);
             pst.setDate(3, sqdet);
             pst.setDate(4, sqdet1);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Se realizo el registro");
         } catch (SQLException ex) {
             Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
      public boolean setBonus(String userId, java.sql.Date  sqdet, String Cantidad, String Tipo) throws ParseException, SQLException {
       
        String SQL = "INSERT INTO bonus(emp_no,bonus_date,bonus_amount,bonus_type_no)VALUES(?,?,?,?)";
        String SQL1 = "SELECT TOP 100 * FROM bonustype;";
        String SQL2 = "SELECT emp_no, bonus_date FROM bonus WHERE emp_no= " + userId;
        boolean exists = false;
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        String[] datos = new String[2];
        Date[]datos2 = new Date[2];
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos2[0] = resultSet.getDate(2);
            System.out.println(datos[0]);
            System.out.println(datos2[0]);
            if (userId.equals(datos[0]) && sqdet.equals(datos2[0])) {
                exists = true;
                JOptionPane.showMessageDialog(null, "Este usuaio ya se registro en esta Fecha");
                
            }
        }
        if (exists) {
            return exists;
        } else {
            preparedStatement = con.prepareStatement(SQL1);
            resultSet = preparedStatement.executeQuery();

            String[] datos1 = new String[2];

            while (resultSet.next()) {
                datos1[0] = resultSet.getString(1);
                datos1[1] = resultSet.getString(2);

                if (Tipo.equals(datos1[1])) {

                    break;
                }
            }

            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setDate(2, sqdet);
            pst.setString(3, Cantidad);
            pst.setInt(4, Integer.parseInt(datos1[0]));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
            return false;
        }
        
    }
        
        
      public boolean setDeduccion(String userId, java.sql.Date  sqdet, String Cantidad, String Tipo) throws ParseException, SQLException {
       
        String SQL = "INSERT INTO deduction(emp_no,deduct_date,deduct_amount,deduct_type_no)VALUES(?,?,?,?)";
        String SQL1 = "SELECT TOP 100 * FROM deducttype;";
        String SQL2 = "SELECT emp_no, deduct_date FROM deduction WHERE emp_no= " + userId;
        boolean exists = false;
        
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        String[] datos = new String[2];
        Date[]datos2 = new Date[2];
        
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos2[0] = resultSet.getDate(2);
            System.out.println(datos[0]);
            System.out.println(datos2[0]);
            if (userId.equals(datos[0]) && sqdet.equals(datos2[0])) {
                exists = true;
                JOptionPane.showMessageDialog(null, "Este usuaio ya se registro en esta Fecha");
                
            }
        }if (exists) {
            return exists;
        } else {
            
        
        preparedStatement = con.prepareStatement(SQL1);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos[1] = resultSet.getString(2);
            
            if (Tipo.equals(datos[1])) {
                
                break;
            }
        }
        
        PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setDate(2, sqdet);
            pst.setString(3, Cantidad);
            pst.setInt(4, Integer.parseInt(datos[0]));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se realizo el registro");
            return false;
        }   
    }
      public boolean setHoliday(String userId, java.sql.Date  sqdet,java.sql.Date  sqdet1) throws ParseException, SQLException {
       
        String SQL = "INSERT INTO holiday(emp_no,start_date,end_date)VALUES(?,?,?)";
        String SQL2 = "SELECT emp_no, start_date FROM holiday WHERE emp_no= " + userId;
        boolean exists = false;
        
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        String[] datos = new String[2];
        Date[]datos2 = new Date[2];
        
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos2[0] = resultSet.getDate(2);
            System.out.println(datos[0]);
            System.out.println(datos2[0]);
            if (userId.equals(datos[0]) && sqdet.equals(datos2[0])) {
                exists = true;
                JOptionPane.showMessageDialog(null, "Este usuaio ya se registro en esta Fecha");
                
            }
        }if (exists) {
            return exists;
            
        } else {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setDate(2, sqdet);
            pst.setDate(3, sqdet1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se realizo el registro");
            return false;
            
        }
        
            
    }
      public boolean setSickLeave(String userId, java.sql.Date  sqdet,java.sql.Date  sqdet1, String razon) throws ParseException, SQLException {
       
        String SQL = "INSERT INTO sickleave(emp_no,start_date,end_date,reason)VALUES(?,?,?,?)";
        String SQL2 = "SELECT emp_no, start_date FROM sickleave WHERE emp_no= " + userId;
        boolean exists = false;
        
        preparedStatement = con.prepareStatement(SQL2);
        resultSet = preparedStatement.executeQuery();
        String[] datos = new String[2];
        Date[]datos2 = new Date[2];
        
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos2[0] = resultSet.getDate(2);
            System.out.println(datos[0]);
            System.out.println(datos2[0]);
            if (userId.equals(datos[0]) && sqdet.equals(datos2[0])) {
                exists = true;
                JOptionPane.showMessageDialog(null, "Este usuaio ya se registro en esta Fecha");
            }
        }
        if (exists) {
            return exists;
        } else {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setDate(2, sqdet);
            pst.setDate(3, sqdet1);
            pst.setString(4, razon);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se realizo el registro");
            return false;
        }
             
    }
      public void setNomina(String userId, java.sql.Date  sqdet,java.sql.Date  sqdet1, String Ruta, 
              String Cuenta, String Banco, String Banco_Direccion,String Tipo, 
              String payid,String checkid,Double Cantidad) throws ParseException, SQLException {
       
          String SQL = "INSERT INTO paydetails(emp_no,start_date,routing_number,account_type,bank_name,bank_address,pay_type_no)"
                  + "VALUES(?,?,?,?,?,?,?)";
          String SQL1 = "INSERT INTO payhistory(pay_no,emp_no,pay_date, check_number,pay_amount)VALUES(?,?,?,?,?)";
          String SQL2 = "SELECT  * FROM paytype;";
          //String SQL2 = "SELECT emp_no, start_date FROM paydetails WHERE emp_no= " + userId;
          
          preparedStatement = con.prepareStatement(SQL2);
          resultSet = preparedStatement.executeQuery();

            String[] datos1 = new String[2];

            while (resultSet.next()) {
                datos1[0] = resultSet.getString(1);
                datos1[1] = resultSet.getString(2);

                if (Tipo.equals(datos1[1])) {
                    break;
                }
            }
          
          PreparedStatement pst = con.prepareStatement(SQL);
          pst.setInt(1, Integer.parseInt(userId));
          pst.setDate(2, sqdet);
          pst.setString(3, Ruta);
          pst.setString(4, Cuenta);
          pst.setString(5, Banco);
          pst.setString(6, Banco_Direccion);
          pst.setInt(7, Integer.parseInt(datos1[0]));
          pst.executeUpdate();
          
          PreparedStatement pst2 = con.prepareStatement(SQL1);
          pst2.setInt(1, Integer.parseInt(payid));
          pst2.setInt(2, Integer.parseInt(userId));
          pst2.setDate(3, sqdet1);
          pst2.setString(4, checkid);
          pst2.setDouble(5, Cantidad);
          pst2.executeUpdate();
          JOptionPane.showMessageDialog(null, "Se realizo el registro");

        }
             
    
}
