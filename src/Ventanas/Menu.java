/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import main.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import main.DatabaseManager;
import main.Main;
import main.Pdf;


/**
 *
 * @author SAM
 */
public class Menu extends javax.swing.JFrame {
    int reporte=0;
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        reportePane.setVisible(false);
        buscarTxt.addKeyListener(new KeyAdapter() {
            private ActionEvent evt;
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                buscarBtnActionPerformed(evt);
            }
        }
        });
    }
    private void limpiar(){
        buscarTxt.setText("");
        nombreTxt.setText("");
        cedulaTxt.setText("");
        asientoTxt.setText("");
        estadoTxt.setText("");
        buscarTxt.setEditable(true);
        buscarTxt.requestFocusInWindow();
    }

    
    private void buscar(){
        String[] datos=Conexion.consultaGraduado(buscarTxt.getText());
        String estado;
        if(datos==null){
            limpiar();
        }
        else{
            nombreTxt.setText(datos[0]);
            cedulaTxt.setText(datos[3]);
            asientoTxt.setText(datos[1]);
            
            if(datos[2].equals("0")){
                estado = "No ha entrado";
            }
            else{
                estado = "Ha entrado";
            }
            estadoTxt.setText(estado);
            buscarTxt.setEditable(false);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        piePane = new javax.swing.JPanel();
        reportePane = new javax.swing.JPanel();
        menuSeparador3 = new javax.swing.JSeparator();
        pdfBtn = new javax.swing.JLabel();
        productosPane = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JLabel();
        buscarLabel = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JLabel();
        limpiarBtn = new javax.swing.JButton();
        buscarBtn = new javax.swing.JButton();
        areaLabel = new javax.swing.JLabel();
        asientoTxt = new javax.swing.JLabel();
        cedulaTxt = new javax.swing.JLabel();
        asientoLabel = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        estadoTxt = new javax.swing.JLabel();
        registrarBtn = new javax.swing.JButton();
        cedulaLabel = new javax.swing.JLabel();
        areaTxt1 = new javax.swing.JLabel();
        tituloPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuPane = new javax.swing.JPanel();
        reporteBtn = new javax.swing.JLabel();
        menuSeparador = new javax.swing.JSeparator();
        menuSeparador1 = new javax.swing.JSeparator();
        salirBtn = new javax.swing.JLabel();
        menuSeparador2 = new javax.swing.JSeparator();
        AñadirBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de asistencia");
        setMinimumSize(new java.awt.Dimension(950, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setMaximumSize(new java.awt.Dimension(950, 670));
        fondo.setPreferredSize(new java.awt.Dimension(950, 500));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        piePane.setBackground(new java.awt.Color(101, 139, 222));

        javax.swing.GroupLayout piePaneLayout = new javax.swing.GroupLayout(piePane);
        piePane.setLayout(piePaneLayout);
        piePaneLayout.setHorizontalGroup(
            piePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        piePaneLayout.setVerticalGroup(
            piePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        fondo.add(piePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        reportePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuSeparador3.setForeground(new java.awt.Color(0, 0, 0));
        reportePane.add(menuSeparador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 10));

        pdfBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 25)); // NOI18N
        pdfBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pdfBtn.setText("PDF");
        pdfBtn.setToolTipText("");
        pdfBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pdfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pdfBtn.setMaximumSize(new java.awt.Dimension(180, 100));
        pdfBtn.setMinimumSize(new java.awt.Dimension(180, 100));
        pdfBtn.setPreferredSize(new java.awt.Dimension(180, 70));
        pdfBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdfBtnMouseClicked(evt);
            }
        });
        reportePane.add(pdfBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        fondo.add(reportePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 180, 70));

        productosPane.setBackground(new java.awt.Color(204, 204, 255));
        productosPane.setMaximumSize(new java.awt.Dimension(770, 570));
        productosPane.setMinimumSize(new java.awt.Dimension(770, 570));
        productosPane.setPreferredSize(new java.awt.Dimension(770, 400));
        productosPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPanel.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        tituloPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPanel.setText("Graduados");
        tituloPanel.setMaximumSize(new java.awt.Dimension(320, 40));
        tituloPanel.setMinimumSize(new java.awt.Dimension(320, 40));
        tituloPanel.setPreferredSize(new java.awt.Dimension(320, 40));
        productosPane.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 20, -1, -1));

        buscarLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        buscarLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buscarLabel.setText("Cedula o asiento:");
        productosPane.add(buscarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, 30));

        buscarTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        buscarTxt.setMaximumSize(new java.awt.Dimension(140, 30));
        buscarTxt.setMinimumSize(new java.awt.Dimension(140, 30));
        buscarTxt.setPreferredSize(new java.awt.Dimension(140, 30));
        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarTxtKeyTyped(evt);
            }
        });
        productosPane.add(buscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 140, -1));

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nombreLabel.setText("Nombre:");
        productosPane.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nombreTxt.setText(" ");
        productosPane.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 400, -1));

        limpiarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        limpiarBtn.setText("Limpiar");
        limpiarBtn.setMaximumSize(new java.awt.Dimension(190, 30));
        limpiarBtn.setMinimumSize(new java.awt.Dimension(190, 30));
        limpiarBtn.setPreferredSize(new java.awt.Dimension(250, 40));
        limpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtnActionPerformed(evt);
            }
        });
        productosPane.add(limpiarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 250, -1));

        buscarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarBtn.setText("Buscar");
        buscarBtn.setMaximumSize(new java.awt.Dimension(190, 30));
        buscarBtn.setMinimumSize(new java.awt.Dimension(190, 30));
        buscarBtn.setPreferredSize(new java.awt.Dimension(190, 30));
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });
        productosPane.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 90, -1));

        areaLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        areaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productosPane.add(areaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 70, -1));

        asientoTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        asientoTxt.setText(" ");
        productosPane.add(asientoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 270, -1));

        cedulaTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cedulaTxt.setText("  ");
        productosPane.add(cedulaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 270, -1));

        asientoLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        asientoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        asientoLabel.setText("Asiento:");
        productosPane.add(asientoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 70, -1));

        estadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estadoLabel.setText("Estado:");
        productosPane.add(estadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 70, -1));

        estadoTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        estadoTxt.setText("  ");
        productosPane.add(estadoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 270, -1));

        registrarBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registrarBtn.setText("Registrar Asistencia");
        registrarBtn.setMaximumSize(new java.awt.Dimension(190, 30));
        registrarBtn.setMinimumSize(new java.awt.Dimension(190, 30));
        registrarBtn.setPreferredSize(new java.awt.Dimension(250, 40));
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });
        productosPane.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 250, -1));

        cedulaLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cedulaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cedulaLabel.setText("Cedula:");
        productosPane.add(cedulaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 70, -1));

        areaTxt1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        areaTxt1.setText(" ");
        productosPane.add(areaTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 270, -1));

        fondo.add(productosPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        tituloPane.setBackground(new java.awt.Color(101, 139, 222));
        tituloPane.setMaximumSize(new java.awt.Dimension(950, 70));
        tituloPane.setMinimumSize(new java.awt.Dimension(950, 70));
        tituloPane.setPreferredSize(new java.awt.Dimension(950, 70));
        tituloPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(101, 139, 222));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control de Asistencia");
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 40));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 40));
        tituloPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 15, -1, -1));

        fondo.add(tituloPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reporteBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 25)); // NOI18N
        reporteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reporteBtn.setText("Reporte");
        reporteBtn.setMaximumSize(new java.awt.Dimension(180, 100));
        reporteBtn.setMinimumSize(new java.awt.Dimension(180, 100));
        reporteBtn.setPreferredSize(new java.awt.Dimension(180, 100));
        reporteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reporteBtnMouseClicked(evt);
            }
        });
        menuPane.add(reporteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuSeparador.setForeground(new java.awt.Color(0, 0, 0));
        menuPane.add(menuSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 180, 10));

        menuSeparador1.setForeground(new java.awt.Color(0, 0, 0));
        menuPane.add(menuSeparador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 10));

        salirBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 25)); // NOI18N
        salirBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salirBtn.setText("Salir");
        salirBtn.setMaximumSize(new java.awt.Dimension(180, 100));
        salirBtn.setMinimumSize(new java.awt.Dimension(180, 100));
        salirBtn.setPreferredSize(new java.awt.Dimension(180, 100));
        salirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirBtnMouseClicked(evt);
            }
        });
        menuPane.add(salirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        menuSeparador2.setForeground(new java.awt.Color(0, 0, 0));
        menuPane.add(menuSeparador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 100));

        AñadirBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 25)); // NOI18N
        AñadirBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AñadirBtn.setText("Restablecer");
        AñadirBtn.setMaximumSize(new java.awt.Dimension(180, 100));
        AñadirBtn.setMinimumSize(new java.awt.Dimension(180, 100));
        AñadirBtn.setPreferredSize(new java.awt.Dimension(180, 100));
        AñadirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AñadirBtnMouseClicked(evt);
            }
        });
        menuPane.add(AñadirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        fondo.add(menuPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, -1));

        getContentPane().add(fondo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reporteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reporteBtnMouseClicked
       if(reporte==0){
           reportePane.setVisible(true);
           reporte=1;
       }else{
           reportePane.setVisible(false);
           reporte=0;
       }
    }//GEN-LAST:event_reporteBtnMouseClicked

    private void salirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirBtnMouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirBtnMouseClicked

    private void pdfBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdfBtnMouseClicked
        Pdf pdf=new Pdf();
        pdf.generateAndSavePDF();
    }//GEN-LAST:event_pdfBtnMouseClicked

    private void AñadirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AñadirBtnMouseClicked
        DatabaseManager.resetDatabase();
        //Conexion.anadir(cedula);
    }//GEN-LAST:event_AñadirBtnMouseClicked

    private void limpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtnActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        buscar();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed
        if(estadoTxt.getText().equals("Ha entrado")){
            JOptionPane.showMessageDialog(null, "Ya el graduando esta registrado");
        }else{
            Conexion.asistenciaGraduado(asientoTxt.getText());
        }
        
        limpiar();
    }//GEN-LAST:event_registrarBtnActionPerformed

    private void buscarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_buscarTxtKeyTyped

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_buscarTxtKeyReleased

    private void buscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar();
        }
    }//GEN-LAST:event_buscarTxtKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Main.cerrarXampp();
        dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AñadirBtn;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel areaTxt1;
    private javax.swing.JLabel asientoLabel;
    private javax.swing.JLabel asientoTxt;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JLabel buscarLabel;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel cedulaLabel;
    private javax.swing.JLabel cedulaTxt;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JLabel estadoTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limpiarBtn;
    private javax.swing.JPanel menuPane;
    private javax.swing.JSeparator menuSeparador;
    private javax.swing.JSeparator menuSeparador1;
    private javax.swing.JSeparator menuSeparador2;
    private javax.swing.JSeparator menuSeparador3;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nombreTxt;
    private javax.swing.JLabel pdfBtn;
    private javax.swing.JPanel piePane;
    private javax.swing.JPanel productosPane;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JLabel reporteBtn;
    private javax.swing.JPanel reportePane;
    private javax.swing.JLabel salirBtn;
    private javax.swing.JPanel tituloPane;
    private javax.swing.JLabel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
