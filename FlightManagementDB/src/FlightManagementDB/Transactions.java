/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightManagementDB;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingConstants;
/**
 *
 * @author hp
 */
public class Transactions extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs= null;
    int lastid;
    String Date;
    /**
     * Creates new form Transactions
     */
    public Transactions() {
        initComponents();
        conn = FlightMangementDB.FlightMangementDB();
        DisplayTable();
        DisplayTable2();
        get_ID();
        
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
    private void DisplayTable2(){
        try{
            String sql = "Select * from seat_class ";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Table2.setModel(DbUtils.resultSetToTableModel(rs));

        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void get_ID(){
        
        try{
            String sql = "Select max(Transaction_ID) from transactions";
            PreparedStatement st = conn.prepareStatement(sql);
            
            rs=st.executeQuery(sql);
            if(rs.next()){
                lastid = rs.getInt(1);
                lastid++;
                TID.setText(Integer.toString(lastid));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "no increment");
        }
    }
    
    void Button_off(){
        for (int i = 0; i < 3; i++) {
            Business_Class(i,0);
            Secondary_Class(i,0);
            Economy_Class(i,0);
        }
    }
    
    void Business_Class(int i,int j){
         JButton[] buttons = new JButton[3];
         buttons[0] = B1;
         buttons[1] = B2;
         buttons[2] = B3;
         if(j == 1){
             buttons[i].setEnabled(true);
         }
         else if(j == 2){
             if (i == 0){
                 buttons[0].setEnabled(false);
                 buttons[1].setEnabled(true);
                 buttons[2].setEnabled(true);
                 SN.setText("B"+(i+1));
             }
             else if(i == 1){
                 buttons[1].setEnabled(false);
                 buttons[0].setEnabled(true);
                 buttons[2].setEnabled(true);
                 SN.setText("B"+(i+1));
             }
             else if(i==2){
                 buttons[2].setEnabled(false);
                 buttons[1].setEnabled(true);
                 buttons[0].setEnabled(true);
                 SN.setText("B"+(i+1));
             }
             
         }
         else{
             buttons[i].setEnabled(false);
         }
    }
    void Secondary_Class(int i,int j){
         JButton[] buttons = new JButton[3];
         buttons[0] = S1;
         buttons[1] = S2;
         buttons[2] = S3;
         if(j == 1){
             buttons[i].setEnabled(true);
         }
         else if(j == 2){
             if (i == 0){
                 buttons[0].setEnabled(false);
                 buttons[1].setEnabled(true);
                 buttons[2].setEnabled(true);
                 SN.setText("S"+(i+1));
             }
             else if(i == 1){
                 buttons[1].setEnabled(false);
                 buttons[0].setEnabled(true);
                 buttons[2].setEnabled(true);
                 SN.setText("S"+(i+1));
             }
             else if(i==2){
                 buttons[2].setEnabled(false);
                 buttons[1].setEnabled(true);
                 buttons[0].setEnabled(true);
                 SN.setText("S"+(i+1));
             }
         }
         else{
             buttons[i].setEnabled(false);
         }
    }
    void Economy_Class(int i,int j){
         JButton[] buttons = new JButton[3];
         buttons[0] = E1;
         buttons[1] = E2;
         buttons[2] = E3;
         if(j == 1){
             buttons[i].setEnabled(true);
         }
         else if(j == 2){
             if (i == 0){
                 buttons[0].setEnabled(false);
                 buttons[1].setEnabled(true);
                 buttons[2].setEnabled(true);
                 SN.setText("E"+(i+1));
             }
             else if(i == 1){
                 buttons[1].setEnabled(false);
                 buttons[0].setEnabled(true);
                 buttons[2].setEnabled(true);
                 SN.setText("E"+(i+1));
             }
             else if(i==2){
                 buttons[2].setEnabled(false);
                 buttons[1].setEnabled(true);
                 buttons[0].setEnabled(true);
                 SN.setText("E"+(i+1));
             }
         }
         else{
             buttons[i].setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        TID = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        UserName = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        FN = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        SN = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        Charges = new javax.swing.JTextField();
        Validate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Submit = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        RI = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        B1 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        S1 = new javax.swing.JButton();
        S2 = new javax.swing.JButton();
        S3 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        E2 = new javax.swing.JButton();
        E1 = new javax.swing.JButton();
        E3 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        CI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table1.setBackground(new java.awt.Color(204, 153, 0));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table1);
        if (Table1.getColumnModel().getColumnCount() > 0) {
            Table1.getColumnModel().getColumn(0).setResizable(false);
            Table1.getColumnModel().getColumn(1).setResizable(false);
            Table1.getColumnModel().getColumn(2).setResizable(false);
            Table1.getColumnModel().getColumn(3).setResizable(false);
            Table1.getColumnModel().getColumn(4).setResizable(false);
            Table1.getColumnModel().getColumn(5).setResizable(false);
            Table1.getColumnModel().getColumn(6).setResizable(false);
            Table1.getColumnModel().getColumn(7).setResizable(false);
            Table1.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 31, 708, 80));

        Table2.setBackground(new java.awt.Color(204, 153, 0));
        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table2);
        if (Table2.getColumnModel().getColumnCount() > 0) {
            Table2.getColumnModel().getColumn(0).setResizable(false);
            Table2.getColumnModel().getColumn(1).setResizable(false);
            Table2.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 137, 311, 124));

        TID.setEditable(false);
        TID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIDActionPerformed(evt);
            }
        });
        jPanel1.add(TID, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 137, 191, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 153, 0));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Transaction ID");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 137, 118, -1));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 153, 0));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("User Name");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 215, 118, -1));

        UserName.setEditable(false);
        UserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 215, 191, -1));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 153, 0));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Flight No");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 250, 118, -1));

        FN.setEditable(false);
        FN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(FN, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 250, 191, -1));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 153, 0));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Class ID");
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 118, -1));

        SN.setEditable(false);
        SN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(SN, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 191, -1));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(255, 153, 0));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("Charges");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 118, -1));

        Charges.setEditable(false);
        Charges.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(Charges, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 191, -1));

        Validate.setBackground(new java.awt.Color(255, 153, 0));
        Validate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Validate.setText("Validate");
        Validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidateActionPerformed(evt);
            }
        });
        jPanel1.add(Validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 172, 90, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 90, -1));

        Submit.setBackground(new java.awt.Color(255, 153, 0));
        Submit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 143, -1));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 153, 0));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Reservation ID");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 172, 118, -1));

        RI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(RI, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 172, 191, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 153, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Secondary Class");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 335, 186, -1));

        B1.setBackground(new java.awt.Color(0, 102, 102));
        B1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B1.setForeground(new java.awt.Color(255, 255, 255));
        B1.setText("B1");
        B1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B1.setBorderPainted(false);
        B1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        jPanel1.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 303, 100, -1));

        B3.setBackground(new java.awt.Color(0, 102, 102));
        B3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B3.setForeground(new java.awt.Color(255, 255, 255));
        B3.setText("B3");
        B3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B3.setBorderPainted(false);
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        jPanel1.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 303, 100, -1));

        B2.setBackground(new java.awt.Color(0, 102, 102));
        B2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        B2.setForeground(new java.awt.Color(255, 255, 255));
        B2.setText("B2");
        B2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B2.setBorderPainted(false);
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        jPanel1.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 303, 100, -1));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 153, 0));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Business Class");
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 274, 186, -1));

        S1.setBackground(new java.awt.Color(0, 102, 102));
        S1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        S1.setForeground(new java.awt.Color(255, 255, 255));
        S1.setText("S1");
        S1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        S1.setBorderPainted(false);
        S1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S1ActionPerformed(evt);
            }
        });
        jPanel1.add(S1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 364, 100, -1));

        S2.setBackground(new java.awt.Color(0, 102, 102));
        S2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        S2.setForeground(new java.awt.Color(255, 255, 255));
        S2.setText("S2");
        S2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        S2.setBorderPainted(false);
        S2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S2ActionPerformed(evt);
            }
        });
        jPanel1.add(S2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 364, 100, -1));

        S3.setBackground(new java.awt.Color(0, 102, 102));
        S3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        S3.setForeground(new java.awt.Color(255, 255, 255));
        S3.setText("S3");
        S3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        S3.setBorderPainted(false);
        S3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S3ActionPerformed(evt);
            }
        });
        jPanel1.add(S3, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 364, 100, -1));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(255, 153, 0));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("Economy Class");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 396, 186, -1));

        E2.setBackground(new java.awt.Color(0, 102, 102));
        E2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E2.setForeground(new java.awt.Color(255, 255, 255));
        E2.setText("E2");
        E2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        E2.setBorderPainted(false);
        E2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E2ActionPerformed(evt);
            }
        });
        jPanel1.add(E2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 431, 100, -1));

        E1.setBackground(new java.awt.Color(0, 102, 102));
        E1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E1.setForeground(new java.awt.Color(255, 255, 255));
        E1.setText("E1");
        E1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        E1.setBorderPainted(false);
        E1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E1ActionPerformed(evt);
            }
        });
        jPanel1.add(E1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 431, 100, -1));

        E3.setBackground(new java.awt.Color(0, 102, 102));
        E3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        E3.setForeground(new java.awt.Color(255, 255, 255));
        E3.setText("E3");
        E3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        E3.setBorderPainted(false);
        E3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E3ActionPerformed(evt);
            }
        });
        jPanel1.add(E3, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 431, 100, -1));

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(255, 153, 0));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("Seat No");
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 118, -1));

        CI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(CI, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 191, -1));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hasnain Ali\\Downloads\\pic 3.jpg")); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void TIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIDActionPerformed

    private void ValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidateActionPerformed
        // TODO add your handling code here:
        try{
           String sql = "Select * from passenger_ticket where Reservation_ID = ?";
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1,RI.getText());
           
           ResultSet rs = st.executeQuery();
           if(rs.next()){
               UserName.setText(rs.getString("UserName"));
               FN.setText(rs.getString("FlightNo"));
           }
           else{
               JOptionPane.showMessageDialog(null, "Record Not Found.");
           }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ValidateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
           String sql = "Select * from Seat_Class where Class_ID = ?";
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1, CI.getText());
           
           ResultSet rs = st.executeQuery();
           if(rs.next()){
               Charges.setText(rs.getString("Charges"));
           }
           else{
               JOptionPane.showMessageDialog(null, "Record Not Found.");
           }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        if(Integer.parseInt(CI.getText()) == 1){
            for (int i = 0; i < 3; i++) {
                Business_Class(i, 1);
            }
        }
        else if(Integer.parseInt(CI.getText()) == 2){
            for (int i = 0; i < 3; i++) {
                Secondary_Class(i, 1);
            }
        }
        else if(Integer.parseInt(CI.getText()) == 3){
            for (int i = 0; i < 3; i++) {
                Economy_Class(i, 1);
            }
        }
        
        String sql = "Select PT.FlightNo, PT.Dateoftravel, T.Seat_No from \n" +
                     "passenger_ticket as PT INNER join transactions as T on\n" +
                     "PT.Reservation_ID = T.Reservation_ID"
                     +" WHERE (PT.FlightNo = "+FN.getText()+" AND PT.Dateoftravel='"+Date+"')";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                String date = rs.getString("T.Seat_NO");
                System.out.println(date);
                String ClassID = date.substring(0,1);
                System.out.println(ClassID);
                String SeatNo = date.substring(1);
                System.out.println(SeatNo);
                if (ClassID.contains("B")== true){
                    Business_Class(Integer.parseInt(SeatNo)-1,0);
                    System.out.println("Jiye Bhiutto");
                }
                else if(ClassID.contains("S")== true){
                    Secondary_Class(Integer.parseInt(SeatNo)-1,0);
                    System.out.println("Jiye Bhiutto");
                }
                else if(ClassID.contains("E")== true){
                    Economy_Class(Integer.parseInt(SeatNo)-1,0);
                    System.out.println("Jiye Bhiutto");
                }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        try{
           String sql = "insert into transactions values (?,?,?,?,?,?,?)";
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1, TID.getText());
           st.setString(2, RI.getText());
           st.setString(3, UserName.getText());
           st.setString(4, FN.getText());
           st.setString(5, CI.getText());
           st.setString(6, SN.getText());
           st.setInt(7,Integer.parseInt(Charges.getText()));
           
           int amount = Integer.parseInt(Charges.getText());
           
           st.executeUpdate();
           JOptionPane.showMessageDialog(null, "Booking Complete your amount:"+amount);
           
           new MainMenu().setVisible(true);
           dispose();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SubmitActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
        Business_Class(0,2);
        
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        Business_Class(1,2);
        
    }//GEN-LAST:event_B2ActionPerformed

    private void S1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S1ActionPerformed
        // TODO add your handling code here:
        Secondary_Class(0, 2);
    }//GEN-LAST:event_S1ActionPerformed

    private void S2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S2ActionPerformed
        // TODO add your handling code here:
        Secondary_Class(1, 2);
    }//GEN-LAST:event_S2ActionPerformed

    private void E2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E2ActionPerformed
        // TODO add your handling code here:
        Economy_Class(1, 2);
    }//GEN-LAST:event_E2ActionPerformed

    private void E1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E1ActionPerformed
        // TODO add your handling code here:
        Economy_Class(0,2);
    }//GEN-LAST:event_E1ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
        Business_Class(2,2);
    }//GEN-LAST:event_B3ActionPerformed

    private void S3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S3ActionPerformed
        // TODO add your handling code here:
        Secondary_Class(2,2);
    }//GEN-LAST:event_S3ActionPerformed

    private void E3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E3ActionPerformed
        // TODO add your handling code here:
        Economy_Class(2,2);
    }//GEN-LAST:event_E3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JTextField CI;
    private javax.swing.JTextField Charges;
    private javax.swing.JButton E1;
    private javax.swing.JButton E2;
    private javax.swing.JButton E3;
    private javax.swing.JTextField FN;
    private javax.swing.JTextField RI;
    private javax.swing.JButton S1;
    private javax.swing.JButton S2;
    private javax.swing.JButton S3;
    private javax.swing.JTextField SN;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField TID;
    private javax.swing.JTable Table1;
    private javax.swing.JTable Table2;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton Validate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
