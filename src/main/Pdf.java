
package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author SAM
 */
public class Pdf {
    private List<String[]> tableData = new ArrayList<>();
    private File currentPdfFile;
    private int asistentes=0;
    private int noAsistentes=0;
    
    public void connectToDatabase() {
        // Datos de conexión (modifica según tu configuración)
        
        String query = "SELECT cedula, name, seat, state FROM participants";
        
        try {
            Connection con=Conexion.conectar();
            
            
            // 2. Ejecutar consulta
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            // 3. Obtener metadatos para nombres de columnas
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            /*
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = metaData.getColumnName(i);
            }*/
            
            // 4. Almacenar nombres de columnas
            String[] columnNames ={"Cedula","Apellidos y Nombres", "Asiento","Asistió"};
            tableData.add(columnNames);
            
            // 5. Almacenar datos
            
            while (rs.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    if(i==4){
                        if(rs.getString(i).equals("0")){
                            rowData[i-1] = "No";
                            noAsistentes++;
                        }else{
                            rowData[i-1] = "Si";
                            asistentes++;
                        }
                    }else{
                        rowData[i-1] = rs.getString(i);
                    }
                }
                tableData.add(rowData);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void generateAndSavePDF() {
        connectToDatabase();
        if (tableData.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para generar el PDF","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Seleccionar ubicación para guardar
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF (*.pdf)", "pdf"));
        fileChooser.setSelectedFile(new File("reporte_bd.pdf"));
        
        int userSelection = fileChooser.showSaveDialog(null);
        
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        File fileToSave = fileChooser.getSelectedFile();
        // Asegurar extensión .pdf
        if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
            fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
        }
        
        try {
            // Configurar documento PDF
            Document document = new Document(PageSize.A4); 
            PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
            document.open();
            
            // Título
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLUE);
            Paragraph title = new Paragraph("Reporte de Asistencia", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20f);
            document.add(title);
            
            // Crear tabla con 4 columnas
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            // Configurar anchos de columnas (opcional)
            float[] columnWidths = {1.2f, 4f, 1f, 1f};
            table.setWidths(columnWidths);
            
            // Agregar datos a la tabla
            boolean isHeader = true;
            for (String[] row : tableData) {
                for (String cell : row) {
                    // Estilo diferente para encabezados
                    Phrase phrase = new Phrase(cell, 
                        isHeader ? FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12) 
                                 : FontFactory.getFont(FontFactory.HELVETICA, 10));
                    table.addCell(phrase);
                }
                isHeader = false;
            }
            
            document.add(table);
            
            Paragraph total = new Paragraph("Graduados que asistieron: \t"+String.valueOf(asistentes)+"\n\nGraduados que no asistieron: \t"+String.valueOf(noAsistentes), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            total.setSpacingAfter(20);
            document.add(total);
            document.close();
            
            JOptionPane.showMessageDialog(null, "PDF generado y guardado exitosamente en:\n" + 
                                         fileToSave.getAbsolutePath(), 
                                         "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (DocumentException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
