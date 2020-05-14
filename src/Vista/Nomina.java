/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controller.insert;
import controller.select;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validators.validator;
import java.sql.Statement;
import java.rmi.RemoteException;
/**
 *
 * @author sebas
 */
public class Nomina extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Nomina
     */
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
     Connection con = BaseDeDatos.Conexion();
     DateFormat df = null;
     select s= new select(con);
     insert i=new insert(con);
     validator validator= new validator();
     
     String birth_date1 = null;
     Date det1 = null;
     java.sql.Date sqdet1 = null;
     
     String birth_date = null;
     Date det = null;
     java.sql.Date sqdet = null;       
            
    public Nomina() throws SQLException {
        initComponents();

        ArrayList paytype = s.listPago();
        for (int i = 0; i < paytype.size(); i++) {
            TipoPago.addItem(paytype.get(i).toString());
            
        }
      this.Desdemonth.addActionListener(this);
      this.Desdeyear.addActionListener(this);
      RegistrarNomina.setEnabled(false);
    }
    public String PayId() throws RemoteException {
        String n = null;
        int num = 0;
        con = BaseDeDatos.Conexion();
        String SQL = "SELECT MAX(payhistory.pay_no) FROM payhistory";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                String u = rs.getString(1);
                
                if (u==null) {
                    num=1;
                }else{
                    num = Integer.parseInt(u) + 1;
                }
            }
            n = "" + num;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return n;

    }
    public String CheckId() throws RemoteException {
        String n = null;
        int num = 0;
        con = BaseDeDatos.Conexion();
        String SQL = "SELECT MAX(payhistory.check_number) FROM payhistory";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                String u = rs.getString(1);
                if (u==null) {
                    num=1;
                }else{
                    num = Integer.parseInt(u) + 1;
                }
                
            }
            n = "" + num;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return n;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NumeroEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NombreBanco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BancoDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        Rutatxt = new javax.swing.JTextField();
        TipoPago = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TipoCuenta = new javax.swing.JComboBox<>();
        Desdeday = new javax.swing.JComboBox<>();
        Desdemonth = new javax.swing.JComboBox<>();
        Desdeyear = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RegistrarNomina = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        CantidadLabel = new javax.swing.JLabel();
        Comprobar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nomina");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Número de Empleado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre de Banco:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Dirección de Banco:");

        BancoDescripcion.setColumns(20);
        BancoDescripcion.setRows(5);
        jScrollPane1.setViewportView(BancoDescripcion);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Número de Ruta:");

        TipoPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de Pago:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tipo de Cuenta:");

        TipoCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenta Corriente", "Cuenta de Ahorros", "Cuenta de Nomina", "Cuenta Remunerada" }));

        Desdeday.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Desdeday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        Desdemonth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Desdemonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        Desdeyear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Desdeyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Desde:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Cantidad de Pago:");

        RegistrarNomina.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RegistrarNomina.setText("Registrar");
        RegistrarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarNominaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("= $");

        CantidadLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CantidadLabel.setText("00.00");

        Comprobar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Comprobar.setText("Comprobar");
        Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprobarActionPerformed(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CantidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TipoCuenta, 0, 218, Short.MAX_VALUE)
                    .addComponent(TipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NumeroEmpleado)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Desdeday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Desdemonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Desdeyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Rutatxt))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Comprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(RegistrarNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(NombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Rutatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Desdeday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Desdemonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Desdeyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(CantidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarNominaActionPerformed
        
                 
        try {
            try {
                i.setNomina(NumeroEmpleado.getText(), sqdet, sqdet1, Rutatxt.getText(), TipoCuenta.getSelectedItem().toString(), NombreBanco.getText()
                        , BancoDescripcion.getText(), TipoPago.getSelectedItem().toString(), PayId(), CheckId(), Double.parseDouble(CantidadLabel.getText()));
                NumeroEmpleado.setText("");
                NombreBanco.setText("");
                BancoDescripcion.setText("");
                Rutatxt.setText("");
                CantidadLabel.setText("00.00");
                Desdeday.setSelectedIndex(0);
                Desdemonth.setSelectedIndex(0);
                Desdeyear.setSelectedIndex(0);
                TipoCuenta.setSelectedIndex(0);
                TipoPago.setSelectedIndex(0);
                RegistrarNomina.setEnabled(false);
        
            } catch (RemoteException ex) {
                Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_RegistrarNominaActionPerformed

    private void ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprobarActionPerformed
        // TODO add your handling code here:
        
        try {
            String id = NumeroEmpleado.getText();
            String banco = NombreBanco.getText();
            String ruta = Rutatxt.getText();
            String descbBanco = BancoDescripcion.getText();
            var errores = validator.Nomina(id,ruta,banco,descbBanco);
            String txt = " ";
            for (String error : errores) {
                txt = txt + error + "\n";
            }
            if (!txt.equals(" ")) {

                JOptionPane.showMessageDialog(null, txt);
                RegistrarNomina.setEnabled(false);
            }else{
                
            
            if (!s.getExisteemployee(id)==true) {
            JOptionPane.showMessageDialog(null, "Este usuario no existe, por favor ingrese un usuario valido");
            RegistrarNomina.setEnabled(false);
            }
            else{
 
            df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            birth_date = Desdeyear.getSelectedItem().toString() + "-" + (Desdemonth.getSelectedIndex()+1) + "-" + Desdeday.getSelectedItem().toString();
            det = df.parse(birth_date);
            sqdet = new java.sql.Date(det.getTime());
            
            if (s.getEmployee(id, sqdet.toString())== true) {
                 
            }else{
            String SQL = "SELECT * FROM salaries WHERE emp_no = " + id + " ORDER by from_date DESC;";
            String[] datos = new String[2];
            preparedStatement = con.prepareStatement(SQL);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            datos[0] = resultSet.getString(1);
            datos[1] = resultSet.getString(2);
            if (id.equals(datos[0])) {
                //JOptionPane.showMessageDialog(null, "Si hay usuario");
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Este usuaio no tiene salarios registrados");
                RegistrarNomina.setEnabled(false);
            }

        }
            
                 if (TipoPago.getSelectedItem().equals("Mensual")) {
                     double temp = Double.parseDouble(datos[1]);
                     temp = temp/12;
                     CantidadLabel.setText(""+temp);
                     birth_date1 = Desdeyear.getSelectedItem().toString() + "-" + (Desdemonth.getSelectedIndex()+2) + "-" + Desdeday.getSelectedItem().toString();
                     det1 = df.parse(birth_date1);
                     sqdet1 = new java.sql.Date(det1.getTime());
                 }
                 if (TipoPago.getSelectedItem().equals("Quincenal")) {
                     double temp = Double.parseDouble(datos[1]);
                     temp = (temp/12)/2;
                     birth_date1 = Desdeyear.getSelectedItem().toString() + "-" + (Desdemonth.getSelectedIndex()+1) + "-" + (Desdeday.getSelectedIndex()+15);
                     det1 = df.parse(birth_date1);
                     sqdet1 = new java.sql.Date(det1.getTime());
                     CantidadLabel.setText(""+temp);
                 }
                 if (TipoPago.getSelectedItem().equals( "Semanal")) {
                     double temp = Double.parseDouble(datos[1]);
                     temp = ((temp/12)/2)/2;
                     birth_date1 = Desdeyear.getSelectedItem().toString() + "-" + (Desdemonth.getSelectedIndex()+1) + "-" + (Desdeday.getSelectedIndex()+7);
                     det1 = df.parse(birth_date1);
                     sqdet1 = new java.sql.Date(det1.getTime());
                     CantidadLabel.setText(""+temp);
                 }
                 RegistrarNomina.setEnabled(true);
            }
            
            }
            
            }
        } catch (ParseException ex) {
            Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComprobarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        
        NumeroEmpleado.setText("");
        NombreBanco.setText("");
        BancoDescripcion.setText("");
        Rutatxt.setText("");
        CantidadLabel.setText("00.00");
        Desdeday.setSelectedIndex(0);
        Desdemonth.setSelectedIndex(0);
        Desdeyear.setSelectedIndex(0);
        TipoCuenta.setSelectedIndex(0);
        TipoPago.setSelectedIndex(0);
        RegistrarNomina.setEnabled(false);
        
    }//GEN-LAST:event_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Nomina().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Nomina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BancoDescripcion;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel CantidadLabel;
    private javax.swing.JButton Comprobar;
    private javax.swing.JComboBox<String> Desdeday;
    private javax.swing.JComboBox<String> Desdemonth;
    private javax.swing.JComboBox<String> Desdeyear;
    private javax.swing.JTextField NombreBanco;
    private javax.swing.JTextField NumeroEmpleado;
    private javax.swing.JButton RegistrarNomina;
    private javax.swing.JTextField Rutatxt;
    private javax.swing.JComboBox<String> TipoCuenta;
    private javax.swing.JComboBox<String> TipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == Desdemonth) {
        
            int days = 31;
            System.out.println("months");
            if (Desdemonth.getSelectedItem().toString().equals("Enero")) {
               days = 32;
               System.out.println("january");

            }
            if (Desdemonth.getSelectedItem().toString().equals("Febrero")) {
               if (Integer.parseInt(Desdeyear.getSelectedItem().toString()) % 4 == 0) {
                  days = 30;
               } else {
                  days = 29;
               }

            }
            if (Desdemonth.getSelectedItem().toString().equals("Marzo")) {
               days = 32;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Abril")) {
               days = 31;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Mayo")) {
               days = 32;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Junio")) {
               days = 31;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Julio")) {
               days = 32;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Agosto")) {
               days = 32;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Septiembre")) {
               days = 31;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Octubre")) {
               days = 32;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Noviembre")) {
               days = 31;
            }
            if (Desdemonth.getSelectedItem().toString().equals("Diciembre")) {
               days = 32;
            }
            Desdeday.removeAllItems();
            for (int i = 1; i < days; i++) {
               Desdeday.addItem("" + i);
            }
         } else if (e.getSource() == Desdeyear) {
            int days = Desdeday.getItemCount() + 1;
            if (Desdemonth.getSelectedItem().toString().equals("Febrero")) {
               if (Integer.parseInt(Desdeyear.getSelectedItem().toString()) % 4 == 0) {
                  days = 30;
               } else {
                  days = 29;
               }

            }
            Desdeday.removeAllItems();
            for (int i = 1; i < days; i++) {
               Desdeday.addItem("" + i);
            }
         }
    
        
        
    }
}
