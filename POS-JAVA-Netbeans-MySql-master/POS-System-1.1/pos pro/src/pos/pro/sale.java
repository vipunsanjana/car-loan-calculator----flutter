/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.pro;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Go
 */
public class sale extends javax.swing.JPanel {

    public static String barcode_c = "0" ;
    public static String cus_id = "0";
    
    public sale() {
        initComponents();
       data_load();
        
    }

  public void data_load(){
  
  // load customer
  
      try {
          
          Statement s= db.mycon().createStatement();
          
          ResultSet rs = s.executeQuery("SELECT * FROM customer");
          Vector v = new Vector();
          
          while (rs.next()) {              
              v.add(rs.getString("customer_name"));
              
              DefaultComboBoxModel com = new DefaultComboBoxModel(v);
              com_cus.setModel(com);
               
          }
           
      } catch (SQLException e) {
            System.out.println(e);
      }
     
     // load Product
  
      try {
          
          Statement s= db.mycon().createStatement();
          
          ResultSet rs = s.executeQuery("SELECT * FROM product");
          Vector v = new Vector();
          
          while (rs.next()) {              
              v.add(rs.getString("Product_Name"));
              
              DefaultComboBoxModel com = new DefaultComboBoxModel(v);
              com_pro.setModel(com);
               
          }
           
      } catch (SQLException e) {
            System.out.println(e);
      }  
      
      // load last invoice number
      
      try {
          
        Statement s = db.mycon().createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM extra WHERE exid =1");
          
          if (rs.next()) {
              
              inid.setText(rs.getString("val"));
              
          }
          
      } catch (Exception e) {
      }
     
      // pluss new invoice
      int i = Integer.valueOf(inid.getText());
      i++;
      inid.setText(String.valueOf(i));
      
      
      
      
  }
    
 public void pro_tot_cal(){
 
  // product calculation
         
        Double qt = Double.valueOf(p_qty.getText());
        Double price = Double.valueOf(u_price.getText());
        Double tot ;
        
        tot = qt * price;
        
        tot_price.setText(String.valueOf(tot));
 
 }   
 
 public void cart_total(){
 
 int numofrow = jTable1.getRowCount();
 
    double total = 0;
    
     for (int i = 0; i < numofrow; i++) {
         
         double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
         total += value ;
     }
    bill_tot.setText(Double.toString(total));
    
   /// total qty count 
   
   int numofrows = jTable1.getRowCount();
 
    double totals = 0;
    
     for (int i = 0; i < numofrows; i++) {
         
         double values = Double.valueOf(jTable1.getValueAt(i, 3).toString());
         totals += values ;
     }
    tot_qty.setText(Double.toString(totals));
    
 
 
 
 }
 
 public void tot(){
     
 Double paid = Double.valueOf(paid_amt.getText());
       Double tot = Double.valueOf(bill_tot.getText());
       Double due ;
       
       due =  paid -tot ;
       
       balance.setText(String.valueOf(due));
 
 }
 
 
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        u_price = new javax.swing.JLabel();
        com_cus = new javax.swing.JComboBox<>();
        com_pro = new javax.swing.JComboBox<>();
        p_qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tot_price = new javax.swing.JLabel();
        br_code = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        paid_amt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        bill_tot = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inid.setText("01");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("INVOICE NO :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(inid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inid)
                    .addComponent(jLabel2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Product :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Qty :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Unit Price :");

        u_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        u_price.setText("00.00");

        com_cus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_cus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select " }));
        com_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_cusActionPerformed(evt);
            }
        });

        com_pro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select " }));
        com_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_proActionPerformed(evt);
            }
        });

        p_qty.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        p_qty.setText("0");
        p_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_qtyKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total Price :");

        tot_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot_price.setText("00.00");

        br_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        br_code.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(u_price, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tot_price, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(br_code, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tot_price)
                        .addComponent(br_code))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(u_price)
                        .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Name", "Bar code", "Qty", "Unit Price", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 75, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addGap(19, 19, 19)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Paid Amount :");

        paid_amt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paid_amt.setText("0");
        paid_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amtKeyReleased(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bill_tot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bill_tot.setText("00.00");
        bill_tot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Total Amount :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Balance/Due :");

        balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        balance.setText("00.00");
        balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Total Qty :");

        tot_qty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tot_qty.setText("00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tot_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tot_qty))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(paid_amt)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Pay & Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void com_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_proActionPerformed
        // load unit price
       
        String  name =com_pro.getSelectedItem().toString();
        try {
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT Bar_code,Price FROM product  WHERE Product_Name ='"+name+"'  ");
            if (rs.next()) {
                 
               
                u_price.setText(rs.getString("Price"));
                br_code.setText(rs.getString("Bar_code"));
             
                
                
            }
          
        
        
             pro_tot_cal();
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_com_proActionPerformed

    private void p_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyReleased
        
        pro_tot_cal();
         
    }//GEN-LAST:event_p_qtyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //add  cart to product details 
        
       
       DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        
        Vector v = new Vector();
        
        v.add(inid.getText()); // invoice id
        v.add(com_pro.getSelectedItem().toString()); // product name
        v.add(br_code.getText()); // barcode
        v.add(p_qty.getText()); // p qyt
        v.add(u_price.getText()); // unit price
        v.add(tot_price.getText()); // get totle price
        
        dt.addRow(v);
        
        cart_total();
         tot(); 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // selected remove
        try {
            
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            int rw = jTable1.getSelectedRow();
           
            dt.removeRow(rw);
            
            
        } catch (Exception e) {
        }
        
        cart_total(); 
         tot(); 
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // remove all
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        
         cart_total();
         tot(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void paid_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyReleased
        
      tot(); 
        
        
    }//GEN-LAST:event_paid_amtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // data send to databace
        
        try {
            
            // `cartid`, `INID`, `Product_Name`, `Bar_code`, `qty`, `Unit_Price`, `Total_Price`
            
          DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
          int rc = dt.getRowCount();
          
            for (int i = 0; i < rc; i++) {
                
                String inid = dt.getValueAt(i, 0).toString(); // get inid
                String P_name = dt.getValueAt(i, 1).toString(); // get product name
                String bar_code = dt.getValueAt(i, 2).toString(); // get barcode
                String qty = dt.getValueAt(i, 3).toString(); // get product qty
                String un_price = dt.getValueAt(i, 4).toString(); // get product unit price
                String tot_price = dt.getValueAt(i, 5).toString(); // get product total Price
            
                // cart DB
             Statement s = db.mycon().createStatement();
             s.executeUpdate(" INSERT INTO cart (INID, Product_Name, Bar_code, qty, Unit_Price, Total_Price) VALUES ('"+inid+"','"+P_name+"','"+bar_code+"','"+qty+"','"+un_price+"','"+tot_price+"') ");
           
            }
            
                JOptionPane.showMessageDialog(null, "Data Seved");
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
  
        try {
            
            
            // sales DB
             
             //`saleid`, `INID`, `Cid`, `Customer_Name`, `Total_Qty`, `Total_Bill`, `Status`, `Balance`
            String inv_id = inid.getText();
            String cname  = com_cus.getSelectedItem().toString();
            String totqty = tot_qty.getText();
            String tot_bil = bill_tot.getText();           
            String blnc = balance.getText();
            
             // paid check
             
             Double tot = Double.valueOf(bill_tot.getText());
             Double pid = Double.valueOf(paid_amt.getText());
             String Status = null;
             if (pid.equals(0.0)) {
                 
                Status = "UnPaid";
                
            }else if (tot>pid) {
                 Status = "Partial";
                 
            }else if (tot<=pid) {
                Status = "Paid";
            }
             
            
            
             
             Statement ss = db.mycon().createStatement();
             ss.executeUpdate("INSERT INTO sales(INID, Cid, Customer_Name, Total_Qty, Total_Bill, Status, Balance) VALUES('"+inv_id+"','"+cus_id+"','"+cname+"','"+totqty+"','"+tot_bil+"','"+Status+"','"+blnc+"')");
             
            
            
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
  
        // save las inid number
        try {
            
           String id = inid.getText(); 
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE  extra SET val='"+id+"' WHERE exid = 1");
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
       
        // Print or view ireport bill
        
        
        try {
            
           
        HashMap para = new HashMap();
        
        para.put("inv_id", inid.getText());  // inv_id  is ireport parameter name
        
        ReportView r =new ReportView("src\\reports\\print.jasper", para);
        r.setVisible(true);  
            
            
            
        } catch (Exception e) {
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void com_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_cusActionPerformed
        // get cid 
        
        String  name =com_cus.getSelectedItem().toString();
        try {
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT cid,customer_name FROM customer  WHERE customer_name ='"+name+"'  ");
            if (rs.next()) {
                 
               
               cus_id = (rs.getString("cid"));
               
                
                
            }
          
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_com_cusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bill_tot;
    private javax.swing.JLabel br_code;
    private javax.swing.JComboBox<String> com_cus;
    private javax.swing.JComboBox<String> com_pro;
    private javax.swing.JLabel inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField p_qty;
    private javax.swing.JTextField paid_amt;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel tot_qty;
    private javax.swing.JLabel u_price;
    // End of variables declaration//GEN-END:variables
}
