/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import main.Conexion;
import main.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
/**
 *
 * @author Rufufu
 */
public class Login extends javax.swing.JFrame {
    int press=1;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void iniciar(){
        String data,pass;
        data=usuaTxt.getText().trim();
        pass=contraTxt.getText().trim();
        if (!data.isEmpty() && !pass.isEmpty()) {
            boolean op=Conexion.login(data, pass);
            if (op) {
                Menu menu = new Menu();
                menu.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Error, no ha digitado correctamente los datos");
            }
              
        }else{
            JOptionPane.showMessageDialog(null, "Error no ha digitado nada");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPane = new javax.swing.JPanel();
        contraLabel = new javax.swing.JLabel();
        usuaLabel = new javax.swing.JLabel();
        usuaTxt = new javax.swing.JTextField();
        contraTxt = new javax.swing.JPasswordField();
        limpiarBtn = new javax.swing.JButton();
        iniciarBtn = new javax.swing.JButton();
        usuaIcon = new javax.swing.JLabel();
        contraIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mostrBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Control de asistencia");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        LoginPane.setBackground(new java.awt.Color(101, 139, 222));
        LoginPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoginPane.setMaximumSize(new java.awt.Dimension(330, 500));
        LoginPane.setMinimumSize(new java.awt.Dimension(330, 500));
        LoginPane.setName(""); // NOI18N
        LoginPane.setPreferredSize(new java.awt.Dimension(330, 500));
        LoginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contraLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        contraLabel.setText("Contraseña");
        LoginPane.add(contraLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 100, 35));

        usuaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuaLabel.setText("Usuario");
        LoginPane.add(usuaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 80, 35));

        usuaTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usuaTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        usuaTxt.setMaximumSize(new java.awt.Dimension(270, 30));
        usuaTxt.setMinimumSize(new java.awt.Dimension(270, 30));
        usuaTxt.setPreferredSize(new java.awt.Dimension(270, 30));
        usuaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuaTxtKeyPressed(evt);
            }
        });
        LoginPane.add(usuaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        contraTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        contraTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        contraTxt.setMaximumSize(new java.awt.Dimension(240, 30));
        contraTxt.setMinimumSize(new java.awt.Dimension(240, 30));
        contraTxt.setPreferredSize(new java.awt.Dimension(240, 30));
        contraTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraTxtKeyPressed(evt);
            }
        });
        LoginPane.add(contraTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        limpiarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        limpiarBtn.setText("Limpiar");
        limpiarBtn.setMaximumSize(new java.awt.Dimension(120, 30));
        limpiarBtn.setMinimumSize(new java.awt.Dimension(120, 30));
        limpiarBtn.setPreferredSize(new java.awt.Dimension(120, 30));
        limpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtnActionPerformed(evt);
            }
        });
        LoginPane.add(limpiarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        iniciarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iniciarBtn.setText("Iniciar");
        iniciarBtn.setMaximumSize(new java.awt.Dimension(120, 30));
        iniciarBtn.setMinimumSize(new java.awt.Dimension(120, 30));
        iniciarBtn.setPreferredSize(new java.awt.Dimension(120, 30));
        iniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBtnActionPerformed(evt);
            }
        });
        LoginPane.add(iniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        usuaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/usuario-30x30.png"))); // NOI18N
        usuaIcon.setToolTipText("");
        LoginPane.add(usuaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 30, 30));

        contraIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/candado-30x30.png"))); // NOI18N
        LoginPane.add(contraIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/comprobacion-de-asistencia (1).png"))); // NOI18N
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        LoginPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        mostrBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/ojo.png"))); // NOI18N
        mostrBtn.setToolTipText("");
        mostrBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mostrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrBtnMouseClicked(evt);
            }
        });
        LoginPane.add(mostrBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 30, 30));

        getContentPane().add(LoginPane);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtnActionPerformed
        
        usuaTxt.setText("");
        contraTxt.setText("");
        usuaTxt.requestFocusInWindow();
    }//GEN-LAST:event_limpiarBtnActionPerformed

    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        iniciar();
    }//GEN-LAST:event_iniciarBtnActionPerformed

    private void mostrBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrBtnMouseClicked
        if (press == 0) {
            contraTxt.setEchoChar('\u2022');
            mostrBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/ojo.png")));
            press = 1;
        } else {
            contraTxt.setEchoChar((char) 0);
            mostrBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/invisible.png")));
            press = 0;
        }
    }//GEN-LAST:event_mostrBtnMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Main.cerrarXampp();
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void contraTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraTxtKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            iniciar();
        }
    }//GEN-LAST:event_contraTxtKeyPressed

    private void usuaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuaTxtKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            iniciar();
        }
    }//GEN-LAST:event_usuaTxtKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /*    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *//*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>*/

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPane;
    private javax.swing.JLabel contraIcon;
    private javax.swing.JLabel contraLabel;
    private javax.swing.JPasswordField contraTxt;
    private javax.swing.JButton iniciarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limpiarBtn;
    private javax.swing.JLabel mostrBtn;
    private javax.swing.JLabel usuaIcon;
    private javax.swing.JLabel usuaLabel;
    private javax.swing.JTextField usuaTxt;
    // End of variables declaration//GEN-END:variables
}
