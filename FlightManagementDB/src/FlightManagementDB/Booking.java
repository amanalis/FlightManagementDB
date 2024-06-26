/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightManagementDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author hp
 */
public class Booking extends javax.swing.JFrame {

    Connection conn = null;
    int lastid;
    ResultSet rs= null;
    /**
     * Creates new form Booking
     */
    public Booking() {
        initComponents();
        conn = FlightMangementDB.FlightMangementDB();
        DisplayTable();
        get_ID();
        get_dates();
    }
    
    private void DisplayTable(){
        try{
            String sql = "Select * from ticket_info ";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));

        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void get_ID(){
        
        try{
            String sql = "Select max(Reservation_ID) from passenger_ticket";
            PreparedStatement st = conn.prepareStatement(sql);
            
            rs=st.executeQuery(sql);
            if(rs.next()){
                lastid = rs.getInt(1);
                lastid++;
                Reservation_ID.setText(Integer.toString(lastid));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "no increment");
        }
    }
    
    private void get_dates(){
        try{
            String sql = ("select * from \n" +
"(select adddate('1970-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selected_date from\n" +
" (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,\n" +
" (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,\n" +
" (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,\n" +
" (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,\n" +
" (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v\n" +
"where selected_date between CURRENT_DATE and  DATE_ADD(CURRENT_DATE, INTERVAL 5 DAY)");
            PreparedStatement st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Dates.addItem(rs.getString("Selected_Date"));
            }
        }
        catch(Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        UserName = new javax.swing.JTextField();
        Validate = new javax.swing.JButton();
        Submit = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        FlightNo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        Reservation_ID = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        Dates = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(153, 204, 255,80));
        jTextField1.setFont(new java.awt.Font("Sitka Banner", 0, 48)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("BOOKING");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 12, 452, 90));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 153, 0));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("User Name");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 362, 100, 35));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 153, 0));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("FlightNo");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 456, 100, 36));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 153, 0));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Date Of Travel");
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 505, 100, 35));

        Table1.setBackground(new java.awt.Color(255, 153, 0,60));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FlightNo", "Departure Time", "Arrival Time", "Duration", "Destination", "Business Class", "Secondary Class", "Economy Class"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 849, 160));

        UserName.setBackground(java.awt.Color.lightGray);
        getContentPane().add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 362, 178, 35));

        Validate.setBackground(new java.awt.Color(255, 204, 0));
        Validate.setForeground(new java.awt.Color(255, 255, 255));
        Validate.setText("Validate");
        Validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidateActionPerformed(evt);
            }
        });
        getContentPane().add(Validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 362, 90, 35));

        Submit.setBackground(new java.awt.Color(255, 153, 0));
        Submit.setForeground(new java.awt.Color(255, 255, 255));
        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        getContentPane().add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 96, 33));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 153, 0));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Full Name");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 409, 100, 34));

        Name.setEditable(false);
        Name.setBackground(java.awt.Color.lightGray);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 409, 178, 34));

        FlightNo.setBackground(java.awt.Color.lightGray);
        FlightNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11501", "22201", "33805" }));
        FlightNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightNoActionPerformed(evt);
            }
        });
        getContentPane().add(FlightNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 456, 178, 36));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 107, 33));

        Reservation_ID.setEditable(false);
        Reservation_ID.setBackground(java.awt.Color.lightGray);
        getContentPane().add(Reservation_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 314, 178, 35));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 153, 0));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Reservation ID");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 314, 100, 35));

        Dates.setBackground(java.awt.Color.lightGray);
        getContentPane().add(Dates, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 505, 178, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hasnain Ali\\Downloads\\ezgif.com-gif-maker (2).gif")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void ValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidateActionPerformed
        // TODO add your handling code here:
        try{
           String sql = "Select * from passenger_info where UserName = ?";
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1,UserName.getText());
           
           ResultSet rs = st.executeQuery();
           if(rs.next()){
               Name.setText(rs.getString("Full_Name"));
           }
           else{
               JOptionPane.showMessageDialog(null, "Record Not Found.");
           }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ValidateActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        try{
           String sql = "insert into passenger_ticket values (?,?,?,?,?)";
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1, Reservation_ID.getText());
           st.setString(2, UserName.getText());
           st.setString(3, Name.getText());
           String flight;
           flight = FlightNo.getSelectedItem().toString();
           st.setString(4, flight);
           String Date;
           Date = Dates.getSelectedItem().toString();
           st.setString(5, Date);
           
           
           
           
           st.executeUpdate();
           JOptionPane.showMessageDialog(null, "Ticket Booked");
           
           Transactions transaction= new Transactions();
           transaction.setLocationRelativeTo(null);
           transaction.setVisible(true);
           this.dispose();
           transaction.Button_off();
           transaction.Date= (String) Dates.getSelectedItem();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SubmitActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void FlightNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FlightNoActionPerformed

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
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Dates;
    private javax.swing.JComboBox<String> FlightNo;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Reservation_ID;
    private javax.swing.JButton Submit;
    private javax.swing.JTable Table1;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton Validate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
