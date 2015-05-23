package com.sherwinca.rhu.reportes;

import com.sherwinca.rhu.conn.MiNuevaConexion;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;


public class reporte {
    private Connection conexion;
   public reporte() throws SQLException{
       
       MiNuevaConexion conn = new MiNuevaConexion();
       conn.estableceConexion();
       conexion = conn.getConexion();
   }
 /*exportar a pdf*/       
  public void exportarPDF() {
        try {
            String master = "reporteSimulacion.jasper";
            File theFile = new File(master);
            System.out.println("master " + master);
            if (master == null) {
                System.out.println("no encuentro el reporte");
                System.exit(3);
            }
            /*reporte en PDF*/
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(theFile);
            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,null, conexion);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("C:\\Users\\Miguel\\Desktop\\reportePDF.pdf"));
            exporter.exportReport();
            JOptionPane.showMessageDialog(null, "Reporte Generado en el Escritorio");
            
            
 
        } catch (Exception j) {
            System.out.println("error " + j.getMessage());
        }
    }        
           
 /*exportar a excel*/      
  public void exportarExcel() {
      try {
            String master = "reporteSimulacion.jasper";
            File theFile = new File(master);
            System.out.println("master " + master);
            if (master == null) {
                System.out.println("no encuentro el reporte");
                System.exit(3);
            }
            
              /*reporte en Excel*/
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(theFile);
           
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,null, conexion);
            
             JRXlsExporter exportador = new JRXlsExporter();     
             exportador.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
             exportador.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"C:\\Users\\Miguel\\Desktop\\reporteXLS.xls");
             exportador.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
             exportador.setParameter(
                  JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
          exportador.setParameter(
                  JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, false);
          exportador
                  .setParameter(
                          JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
                          true);
          exportador
                  .setParameter(
                          JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                          true);
          exportador
                  .setParameter(
                          JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                          true);
          exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
                  true);
          try {
              exportador.exportReport();
               JOptionPane.showMessageDialog(null, "Reporte Generado en el Escritorio");
          } catch (JRException e) {
              e.printStackTrace();
          }   
            
            
            
          } catch (Exception j) {
            System.out.println("error " + j.getMessage());
        }
  }

       
}
