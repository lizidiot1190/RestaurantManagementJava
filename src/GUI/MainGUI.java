/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.TableBLL;
import DTO.TableDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lizid
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    private String displayName;
    private int permission;
    protected TableBLL tableBLL;
    public MainGUI(String displayName_p,int permission_p) {
        displayName=displayName_p;
        permission=permission_p;
        initComponents();
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flpTable = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnManage = new javax.swing.JButton();
        lbDisplayName = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1600, 830));
        setMinimumSize(new java.awt.Dimension(1600, 830));
        setName("Quản lý quán ăn"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1600, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(1600, 830));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        flpTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        flpTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        flpTable.setMaximumSize(new java.awt.Dimension(900, 630));
        flpTable.setMinimumSize(new java.awt.Dimension(900, 630));
        getContentPane().add(flpTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 42, 1282, 711));

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 370, 124, 58));

        btnManage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnManage.setText("Quản lý");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });
        getContentPane().add(btnManage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 370, 124, 58));

        lbDisplayName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbDisplayName.setText("DisplayName");
        getContentPane().add(lbDisplayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 307, -1, -1));

        jCalendar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 446, -1, 307));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        System.exit(0);
        
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageActionPerformed
        MenuAdminGUI mn = new MenuAdminGUI();
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnManageActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        </editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainGUI(String displayName, int permission).setVisible(true);
//            }
//        });
    }
    
    private void loadTable(){
        lbDisplayName.setText(displayName);
        if(permission!=0){
            btnManage.setVisible(false);
        }
        tableBLL =new TableBLL();
        tableBLL.loadTable(flpTable);
    }
            
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    public static javax.swing.JButton btnManage;
    public static javax.swing.JPanel flpTable;
    private com.toedter.calendar.JCalendar jCalendar1;
    public static javax.swing.JLabel lbDisplayName;
    // End of variables declaration//GEN-END:variables

}
