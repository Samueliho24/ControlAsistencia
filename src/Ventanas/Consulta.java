/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import javax.swing.JOptionPane;
import main.Conexion;

/**
 *
 * @author SAM
 */
public class Consulta extends javax.swing.JPanel {

    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productosPane = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JLabel();
        cedulaLabel = new javax.swing.JLabel();
        cedulaTxt = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JLabel();
        limpiarBtn = new javax.swing.JButton();
        buscarBtn = new javax.swing.JButton();
        areaLabel = new javax.swing.JLabel();
        areaTxt = new javax.swing.JLabel();
        asientoTxt = new javax.swing.JLabel();
        asientoLabel = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        estadoTxt = new javax.swing.JLabel();
        registrarBtn = new javax.swing.JButton();

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

        cedulaLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cedulaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cedulaLabel.setText("Cedula:");
        productosPane.add(cedulaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, 30));

        cedulaTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cedulaTxt.setMaximumSize(new java.awt.Dimension(140, 30));
        cedulaTxt.setMinimumSize(new java.awt.Dimension(140, 30));
        cedulaTxt.setPreferredSize(new java.awt.Dimension(140, 30));
        productosPane.add(cedulaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nombreLabel.setText("Nombre:");
        productosPane.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nombreTxt.setText("Bs.");
        productosPane.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 270, -1));

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
        productosPane.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 90, -1));

        areaLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        areaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        areaLabel.setText("Area:");
        productosPane.add(areaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 70, -1));

        areaTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        areaTxt.setText("Bs.");
        productosPane.add(areaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 270, -1));

        asientoTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        asientoTxt.setText("Bs.");
        productosPane.add(asientoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 270, -1));

        asientoLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        asientoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        asientoLabel.setText("Asiento:");
        productosPane.add(asientoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, -1));

        estadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estadoLabel.setText("Estado:");
        productosPane.add(estadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 70, -1));

        estadoTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        estadoTxt.setText("Bs.");
        productosPane.add(estadoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 270, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(productosPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(productosPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtnActionPerformed
        cedulaTxt.setText("");
        nombreTxt.setText("");
        areaTxt.setText("");
        asientoTxt.setText("");
        estadoTxt.setText("");
        cedulaTxt.setEditable(true);
    }//GEN-LAST:event_limpiarBtnActionPerformed

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed
        if(estadoTxt.getText().equals("Llego")){
            JOptionPane.showMessageDialog(null, "Ya el graduando esta registrado");
        }else{
            Conexion.asistenciaGraduado(cedulaTxt.getText());
        }
    }//GEN-LAST:event_registrarBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        String[] datos=Conexion.consultaGraduado(cedulaTxt.getText());
        if(datos==null){
            limpiarBtnActionPerformed(evt);
        }
        else{
            nombreTxt.setText(datos[0]);
            areaTxt.setText(datos[1]);
            asientoTxt.setText(datos[2]);
            estadoTxt.setText(datos[3]);
            cedulaTxt.setEditable(false);
        }
    }//GEN-LAST:event_buscarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel areaTxt;
    private javax.swing.JLabel asientoLabel;
    private javax.swing.JLabel asientoTxt;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JLabel cedulaLabel;
    private javax.swing.JTextField cedulaTxt;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JLabel estadoTxt;
    private javax.swing.JButton limpiarBtn;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nombreTxt;
    private javax.swing.JPanel productosPane;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JLabel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
