/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdproyecto;

import Vista.Empleados;
import Vista.Menu;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class BDproyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //new Empleados().setVisible(true);
        new Menu().setVisible(true);
    }
    
}
