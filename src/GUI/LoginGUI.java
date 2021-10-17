/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ConnectSQLServer;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author vhh01
 */
public class LoginGUI extends javax.swing.JFrame {


    public LoginGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public LoginGUI(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void openfacebook() {
        try {
            Desktop.getDesktop().browse(URI.create("https://www.facebook.com/vhh000000"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void openyoutube() {
        try {
            Desktop.getDesktop().browse(URI.create("https://www.youtube.com/channel/UCGOCILLRlxt_rkZ9Zf4Ns4A"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void opentwitter() {
        try {
            Desktop.getDesktop().browse(URI.create("https://twitter.com/vhh0106"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jblexit = new javax.swing.JLabel();
        jblnutan = new javax.swing.JLabel();
        btnreset = new javax.swing.JButton();
        jblyoutube = new javax.swing.JLabel();
        jblfacebook = new javax.swing.JLabel();
        jbltwitter = new javax.swing.JLabel();
        btnsubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(900, 630));
        setMinimumSize(new java.awt.Dimension(900, 630));
        setUndecorated(true);
        setSize(new java.awt.Dimension(900, 630));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 630));

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));
        jPanel1.setForeground(new java.awt.Color(240, 109, 10));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(240, 109, 10));
        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 1, 52)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 109, 10));
        jLabel4.setText("LOGIN");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 82, -1, -1));

        jLabel5.setBackground(new java.awt.Color(240, 109, 10));
        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USER:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 202, -1, -1));

        jLabel6.setBackground(new java.awt.Color(240, 109, 10));
        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PASSWORD:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(240, 109, 10));
        jSeparator2.setForeground(new java.awt.Color(240, 109, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 267, 10));

        jSeparator3.setBackground(new java.awt.Color(240, 109, 10));
        jSeparator3.setForeground(new java.awt.Color(240, 109, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 270, 10));

        txtusername.setBackground(new java.awt.Color(16, 16, 16));
        txtusername.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(240, 109, 10));
        txtusername.setBorder(null);
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 264, 45));

        txtpassword.setBackground(new java.awt.Color(16, 16, 16));
        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(240, 109, 10));
        txtpassword.setBorder(null);
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 270, 53));

        jblexit.setBackground(new java.awt.Color(240, 109, 10));
        jblexit.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jblexit.setForeground(new java.awt.Color(240, 109, 10));
        jblexit.setText("X");
        jblexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblexitMouseClicked(evt);
            }
        });
        jPanel1.add(jblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 31, 41));

        jblnutan.setBackground(new java.awt.Color(240, 109, 10));
        jblnutan.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jblnutan.setForeground(new java.awt.Color(240, 109, 10));
        jblnutan.setText("_");
        jblnutan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblnutan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblnutanMouseClicked(evt);
            }
        });
        jPanel1.add(jblnutan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 31, 30));

        btnreset.setBackground(new java.awt.Color(240, 109, 10));
        btnreset.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        btnreset.setForeground(new java.awt.Color(240, 109, 10));
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-reset-24.png"))); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 460, 120, 40));

        jblyoutube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/YOUTUBE_ON.png"))); // NOI18N
        jblyoutube.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblyoutube.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jblyoutubeMouseMoved(evt);
            }
        });
        jblyoutube.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblyoutubeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblyoutubeMouseExited(evt);
            }
        });
        jPanel1.add(jblyoutube, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, -1, -1));

        jblfacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/facebook_ON.png"))); // NOI18N
        jblfacebook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblfacebook.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jblfacebookMouseMoved(evt);
            }
        });
        jblfacebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblfacebookMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblfacebookMouseExited(evt);
            }
        });
        jPanel1.add(jblfacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, -1));

        jbltwitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/twitter_ON.png"))); // NOI18N
        jbltwitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbltwitter.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbltwitterMouseMoved(evt);
            }
        });
        jbltwitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbltwitterMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbltwitterMouseExited(evt);
            }
        });
        jPanel1.add(jbltwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, -1));

        btnsubmit.setBackground(new java.awt.Color(240, 109, 10));
        btnsubmit.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        btnsubmit.setForeground(new java.awt.Color(240, 109, 10));
        btnsubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-login-30.png"))); // NOI18N
        btnsubmit.setText("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 460, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 430, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void jblyoutubeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblyoutubeMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jblyoutubeMouseMoved

    private void jblyoutubeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblyoutubeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jblyoutubeMouseExited

    private void jblyoutubeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblyoutubeMouseClicked
        // TODO add your handling code here:
        openyoutube();
    }//GEN-LAST:event_jblyoutubeMouseClicked

    private void jblfacebookMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblfacebookMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_jblfacebookMouseMoved

    private void jblfacebookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblfacebookMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jblfacebookMouseExited

    private void jblfacebookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblfacebookMouseClicked
        // TODO add your handling code here:
        openfacebook();
    }//GEN-LAST:event_jblfacebookMouseClicked

    private void jbltwitterMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbltwitterMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jbltwitterMouseMoved

    private void jbltwitterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbltwitterMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbltwitterMouseExited

    private void jbltwitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbltwitterMouseClicked
        // TODO add your handling code here:
        opentwitter();
    }//GEN-LAST:event_jbltwitterMouseClicked

    private void jblnutanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblnutanMouseClicked
        // TODO add your handling code here:
        this.setState(LoginGUI.ICONIFIED);
    }//GEN-LAST:event_jblnutanMouseClicked

    private void jblexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblexitMouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO GET OUT?", "EXIT", dialogButton);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jblexitMouseClicked

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        txtusername.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
        ConnectSQLServer db = new ConnectSQLServer();
        if (txtusername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter your username!");
        }else if (txtpassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your password!");
            } else {
                db.Login(txtusername.getText(), txtpassword.getText());
            }
        
    }//GEN-LAST:event_btnsubmitActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jblexit;
    private javax.swing.JLabel jblfacebook;
    private javax.swing.JLabel jblnutan;
    private javax.swing.JLabel jbltwitter;
    private javax.swing.JLabel jblyoutube;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
