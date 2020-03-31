/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdproyecto;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author sebas
 */
public class BaseDeDatos {

    static public String DRIVER = "com.mysql.jdbc.Driver";
    static public String DBNAME = "by3zohsmnt9wsbuuywue";
    static public String HOSTNAME = "by3zohsmnt9wsbuuywue-mysql.services.clever-cloud.com";
    static public String PORT = "3306";
    static public String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DBNAME;
    static public String USERNAME = "uxe6qbbaxvktdfyn";
    static public String PASSWORD = "w1I6jPbJJgscJH8AFt9y";

    
    /* static public String DBNAME   = "SEM";
   static public String HOSTNAME = "localhost";
   static  public String PORT="5432";
    static public String URL="jdbc:postgresql://"+HOSTNAME+":"+PORT+"/"+DBNAME;
   static public String USERNAME = "AdminDB";
    static public String PASSWORD = "1234";*/
   // public abstract boolean ConnectDB();
    public static Connection Conexion() {
        Connection cn = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return cn;

    }
}
