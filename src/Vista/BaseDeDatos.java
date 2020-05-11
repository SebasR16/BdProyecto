/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author sebas
 */
public class BaseDeDatos {

 /*static public String DRIVER = "org.postgresql.Driver";
    static public String DBNAME = "Empleados";
    static public String HOSTNAME = "localhost";
    static public String PORT = "5432";
    static public String URL = "jdbc:postgresql://" + HOSTNAME + ":" + PORT + "/" + DBNAME;
    static public String USERNAME = "AdminDB";
    static public String PASSWORD = "1234";
*/
    static public String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static public String DBNAME = "employees";
    static public String HOSTNAME = "localhost";
    static public String PORT = "1433";
    
    static public String USERNAME = "Sebastian";/*integratedSecurity=true*/
    static public String PASSWORD = "Sebas1699";
    static public String URL = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";databaseName=" + DBNAME + ";user=" + USERNAME + ";password=" + PASSWORD;
    
//    static public String DRIVER = "com.mysql.jdbc.Driver";
//    static public String DBNAME = "by3zohsmnt9wsbuuywue";
//    static public String HOSTNAME = "by3zohsmnt9wsbuuywue-mysql.services.clever-cloud.com";
//    static public String PORT = "3306";
//    static public String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DBNAME;
//    static public String USERNAME = "uxe6qbbaxvktdfyn";
//    static public String PASSWORD = "w1I6jPbJJgscJH8AFt9y";

//   static public String DBNAME   = "employees";
//   static public String HOSTNAME = "localhost";
//   static  public String PORT="3306";
//   static public String URL="jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DBNAME;
//   static public String USERNAME = "root";
//   static public String PASSWORD = "Sebas1699";
//    
    
   
    //public abstract boolean ConnectDB();
    public static Connection Conexion() {
        Connection cn = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return cn;

    }
}
