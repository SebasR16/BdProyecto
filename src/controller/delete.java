/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Vista.BaseDeDatos;
import Vista.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class delete {

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Connection con = null;

    public delete(Connection con) {
        this.con = con;
    }

    public String[] setDeleteEmpleados(String dato) throws ParseException, SQLException {
        String SQL = "SELECT * FROM employees WHERE emp_no = " + dato + " ;";

        String[] datos = new String[1];

        preparedStatement = con.prepareStatement(SQL);

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
        }
        System.out.println(datos[0]);

        if (dato.equals(datos[0])) {

            String SQL1 = "DELETE FROM employees WHERE emp_no = " + dato + " ;";
            Statement st = con.createStatement();
            st.executeUpdate(SQL1);

        }

        return datos;
    }

    public String[] setDeleteDepartamento(String dato) throws ParseException, SQLException {
        String SQL = "SELECT * FROM departments WHERE dept_no = '" + dato + "' ;";
        String[] datos = new String[1];
        preparedStatement = con.prepareStatement(SQL);

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            datos[0] = resultSet.getString(1);

            System.out.println(datos[0]);

            if (dato.equals(datos[0])) {

                String SQL1 = "DELETE FROM departments WHERE dept_no = '" + dato + "' ;";
                Statement st = con.createStatement();
                st.executeUpdate(SQL1);

            }

        }
        return datos;
    }
       public String[] setDeleteTitulos(String dato, String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM titles WHERE emp_no = " + dato + " and from_date = '" + dato1 + "' ;";
        String[] datos = new String[3];

    
            preparedStatement = con.prepareStatement(SQL);
      
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[2] = resultSet.getDate(3).toString();
            }
            System.out.println(datos[0] + " " + datos[2]);
       
          if (dato.equals(datos[0]) && dato1.equals(datos[2])) {
         
              String SQL1 = "DELETE FROM titles WHERE emp_no = " + dato + " and from_date = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
            
          }
        return datos;
    }
       public String[]setDeleteGerente(String dato, String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM dept_manager WHERE emp_no = " + dato + " and dept_no = '" + dato1 + "' ;";
        String[] datos = new String[2];

      
            preparedStatement = con.prepareStatement(SQL);
   
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getString(2);
            }
            System.out.println(datos[0] + " " + datos[1]);
      
          if (dato.equals(datos[0]) && dato1.equals(datos[1])) {
        
              String SQL1 = "DELETE FROM dept_manager WHERE emp_no = " + dato + " and dept_no = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
            
              }
          
return datos;
    }
      public String[] setDeleteSalaries(String dato, String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM salaries WHERE emp_no = " + dato + " and from_date = '" + dato1 + "' ;";
        String[] datos = new String[3];

      
            preparedStatement = con.prepareStatement(SQL);
       
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[2] = resultSet.getDate(3).toString();
            }
            System.out.println(datos[0] + " " + datos[2]);
       
          if (dato.equals(datos[0]) && dato1.equals(datos[2])) {
         
              String SQL1 = "DELETE FROM salaries WHERE emp_no = " + dato + " and from_date = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
         
          }
return datos;
    }
      public String[] setDeleteDept_emp(String dato, String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM dept_emp WHERE emp_no = " + dato + " and dept_no = '" + dato1 + "' ;";
        String[] datos = new String[2];

       
            preparedStatement = con.prepareStatement(SQL);
      
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getString(2);
            }
            System.out.println(datos[0] + " " + datos[1]);
   
          if (dato.equals(datos[0]) && dato1.equals(datos[1])) {
     
              String SQL1 = "DELETE FROM dept_emp WHERE emp_no = " + dato + " and dept_no = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
              
          }
            return datos;
      }
        public String[] setDeleteBonus(String dato,String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM bonus WHERE emp_no = " + dato + " and bonus_date = '" + dato1 + "' ;";

        String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
       
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getDate(2).toString();
            }
            //System.out.println(datos[0] + " " + datos[1]);
       
          if (dato.equals(datos[0]) && dato1.equals(datos[1])) {
         
              String SQL1 = "DELETE FROM bonus WHERE emp_no = " + dato + " and bonus_date = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
              JOptionPane.showMessageDialog(null, "Se elimino el Bonus");
          }
            return datos;
        }
        public String[] setDeleteDeduction(String dato,String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM deduction WHERE emp_no = " + dato + " and deduct_date = '" + dato1 + "' ;";

            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
       
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getDate(2).toString();
            }
            System.out.println(datos[0] + " " + datos[1]);
       
          if (dato.equals(datos[0]) && dato1.equals(datos[1])) {
         
              String SQL1 = "DELETE FROM deduction WHERE emp_no = " + dato + " and deduct_date = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
              JOptionPane.showMessageDialog(null, "Se elimino la deduccion");
          }
            return datos;
        }
        public String[] setDeleteHoliday(String dato,String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM holiday WHERE emp_no = " + dato + " and start_date = '" + dato1 + "' ;";

            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
       
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getDate(2).toString();
            }
            System.out.println(datos[0] + " " + datos[1]);
       
          if (dato.equals(datos[0]) && dato1.equals(datos[1])) {
         
              String SQL1 = "DELETE FROM holiday WHERE emp_no = " + dato + " and start_date = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
              JOptionPane.showMessageDialog(null, "Se elimino el registro");
          }
            return datos;
        }
        public String[] setDeleteSick(String dato,String dato1) throws ParseException, SQLException {
        String SQL = "SELECT * FROM sickleave WHERE emp_no = " + dato + " and start_date = '" + dato1 + "' ;";

            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
       
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                datos[0] = resultSet.getString(1);
                datos[1] = resultSet.getDate(2).toString();
            }
            //System.out.println(datos[0] + " " + datos[1]);
       
          if (dato.equals(datos[0]) && dato1.equals(datos[1])) {
         
              String SQL1 = "DELETE FROM sickleave WHERE emp_no = " + dato + " and start_date = '" + dato1 + "' ;";
              Statement st = con.createStatement();
              st.executeUpdate(SQL1);
              JOptionPane.showMessageDialog(null, "Se elimino el registro");
          }
            return datos;
        }
    }
