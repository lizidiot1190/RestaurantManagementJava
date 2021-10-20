/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author vhh01
 */
public class MenuAdminGUI extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdminGUI
     */
    public MenuAdminGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFood = new javax.swing.JButton();
        btnRevenue = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnExit = new javax.swing.JLabel();
        btnHide = new javax.swing.JLabel();

        jButton4.setBackground(new java.awt.Color(240, 109, 10));
        jButton4.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        jButton4.setForeground(new java.awt.Color(240, 109, 10));
        jButton4.setText("Category");

        jLabel3.setBackground(new java.awt.Color(240, 109, 10));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 109, 10));
        jLabel3.setText("X");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(900, 630));
        setMaximumSize(new java.awt.Dimension(900, 630));
        setMinimumSize(new java.awt.Dimension(900, 630));
        setUndecorated(true);
        setSize(new java.awt.Dimension(900, 630));

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));

        jLabel1.setBackground(new java.awt.Color(240, 109, 10));
        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 109, 10));
        jLabel1.setText("ADMIN");

        btnFood.setBackground(new java.awt.Color(240, 109, 10));
        btnFood.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnFood.setForeground(new java.awt.Color(240, 109, 10));
        btnFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-food-and-wine-48.png"))); // NOI18N
        btnFood.setText("Food");
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });

        btnRevenue.setBackground(new java.awt.Color(240, 109, 10));
        btnRevenue.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnRevenue.setForeground(new java.awt.Color(240, 109, 10));
        btnRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-revenue-64.png"))); // NOI18N
        btnRevenue.setText("Revenue");

        btnTable.setBackground(new java.awt.Color(240, 109, 10));
        btnTable.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnTable.setForeground(new java.awt.Color(240, 109, 10));
        btnTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-table-64.png"))); // NOI18N
        btnTable.setText("Table");
        btnTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableActionPerformed(evt);
            }
        });

        btnAccount.setBackground(new java.awt.Color(240, 109, 10));
        btnAccount.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(240, 109, 10));
        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-account-50.png"))); // NOI18N
        btnAccount.setText("Account");

        btnStaff.setBackground(new java.awt.Color(240, 109, 10));
        btnStaff.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnStaff.setForeground(new java.awt.Color(240, 109, 10));
        btnStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-staff-48.png"))); // NOI18N
        btnStaff.setText("Staff");

        btnCategory.setBackground(new java.awt.Color(240, 109, 10));
        btnCategory.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnCategory.setForeground(new java.awt.Color(240, 109, 10));
        btnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-food-receiver-48.png"))); // NOI18N
        btnCategory.setText("Category");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(240, 109, 10));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(240, 109, 10));
        btnExit.setText("X");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        btnHide.setBackground(new java.awt.Color(240, 109, 10));
        btnHide.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHide.setForeground(new java.awt.Color(240, 109, 10));
        btnHide.setText("_");
        btnHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHide)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHide)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

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

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "GET OUT?", "EXIT", dialogButton);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideMouseClicked
        // TODO add your handling code here:
        this.setState(MenuAdminGUI.ICONIFIED);
    }//GEN-LAST:event_btnHideMouseClicked

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        CategoryGUI categoryGUI = new CategoryGUI();
        categoryGUI.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableActionPerformed
        TableListGUI tableGUI = new TableListGUI();
        tableGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTableActionPerformed

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        FoodGUI foodGUI = new FoodGUI();
        foodGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFoodActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnCategory;
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnFood;
    private javax.swing.JLabel btnHide;
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
