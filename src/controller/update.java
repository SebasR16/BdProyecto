/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Vista.Empleados;
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

/**
 *
 * @author PC
 */
public class update {
     PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
     Connection con = null;
        public update(Connection con) {
        this.con=con;
    }
          public void updateEmpleados(String userId, java.sql.Date  sqdet, String Primernombre, String Apellido, String Genero,java.sql.Date  sqdet1 ) throws ParseException, SQLException {
       
        String SQL = "UPDATE employees SET emp_no=?,birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?";
    
        PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setDate(2, sqdet);
            pst.setString(3, Primernombre);
            pst.setString(4, Apellido);
            pst.setString(5,  Genero);
            pst.setDate(6, sqdet1);
            pst.setInt(7, Integer.parseInt(userId));
            pst.executeUpdate();
    }
      public boolean updateDepartamentos(String id, String name) throws ParseException, SQLException {
          
        boolean exists = false;
        String SQL1 = "UPDATE departments SET dept_no=?, dept_name=? WHERE dept_no=?";
        String SQL = "SELECT * FROM departments limit 100;";
        preparedStatement = con.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();

        String[] datos = new String[2];
       
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos[1] = resultSet.getString(2);
            System.out.println(datos[0]);
            if (id.equals(datos[0]) && name.equals(datos[1])) {
                exists = true;
                System.out.println("ya existe");

            }
        }
        if (exists) {
            return exists;
        } else {

            PreparedStatement pst = con.prepareStatement(SQL1);
            pst.setString(1, id);
            pst.setString(2, name);
                pst.setString(3, id);
            pst.executeUpdate();
            System.out.println("Registro exitoso");
            return false;
        }

    }
      public void updateTitulos(String Numemp, String Title,java.sql.Date  sqdet,java.sql.Date  sqdet1 ) throws ParseException {
        String SQL = "UPDATE titles SET emp_no=?,title=?,from_date=?,to_date=? WHERE emp_no=?";
       
        //String[] empleadoR = new String[6];
        try {
            
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(Numemp));
            pst.setString(2, Title);
            pst.setDate(3, sqdet); 
            pst.setDate(4, sqdet1);
                 pst.setInt(5, Integer.parseInt(Numemp));
            pst.executeUpdate();
            System.out.println("Se realizo el registro");
            
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void updateSalarios(String Numempleado, String Salario,java.sql.Date sqdet, java.sql.Date sqdet1) throws ParseException, SQLException {
        String SQL = "UPDATE salaries SET emp_no=?,salary=?,from_date=?,to_date=? WHERE emp_no=?";
         PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(Numempleado));
            pst.setString(2, Salario);
            pst.setDate(3, sqdet); 
            pst.setDate(4, sqdet1);
                pst.setInt(5, Integer.parseInt(Numempleado));
            pst.executeUpdate();
            System.out.println("Se realizo el registro");
    }
      public void updateDept_emp(String Numemp1, String departamento, java.sql.Date  sqdet,java.sql.Date  sqdet1) throws ParseException, SQLException {
        String SQL = "UPDATE dept_emp SET emp_no=?,dept_no=?,from_date=?,to_date=? WHERE emp_no=?";
    PreparedStatement pst = con.prepareStatement(SQL);
            pst.setInt(1, Integer.parseInt(Numemp1));
            pst.setString(2, departamento);
            pst.setDate(3, sqdet); 
            pst.setDate(4, sqdet1);
               pst.setInt(5, Integer.parseInt(Numemp1));
            pst.executeUpdate();
            System.out.println("Se realizo el registro");
    }
      public void updateDept_manager(String Numemp2, String departamento1, java.sql.Date  sqdet,java.sql.Date  sqdet1) throws ParseException {
         try {
             String SQL = "UPDATE dept_manager SET emp_no=?,dept_no=?,from_date=?,to_date=? WHERE emp_no=?";
             PreparedStatement pst = con.prepareStatement(SQL);
             pst.setInt(1, Integer.parseInt(Numemp2));
             pst.setString(2, departamento1);
             pst.setDate(3, sqdet);
             pst.setDate(4, sqdet1);
                      pst.setInt(5, Integer.parseInt(Numemp2));
             pst.executeUpdate();
             System.out.println("Se realizo el registro");
         } catch (SQLException ex) {
             Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
         }
    } 
}
