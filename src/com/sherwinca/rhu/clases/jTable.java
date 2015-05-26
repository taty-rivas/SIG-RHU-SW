package com.sherwinca.rhu.clases;

import com.sherwinca.rhu.conn.MiNuevaConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class jTable {

    /* Limpia los registros previos cargados en la tabla*/
    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    /*Muestra las filas a partir del resultado de la consulta sql en la tabla asignada*/
    public void mostrarFilas(String sql, JTable tabla) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        MiNuevaConexion cc = new MiNuevaConexion();
        cc.estableceConexion();
        /*filas tabla de bajas*/
        Object row[] = new Object[50];
        int i;
        try {
            PreparedStatement pstm = cc.conexion.prepareStatement(sql);
           
            try (ResultSet r1 = pstm.executeQuery()) {
                while (r1.next()) {
                    for (i = 0; i < pstm.getMetaData().getColumnCount(); i++) {
                        row[i] = r1.getObject(1 + i);
                    }
                    modelo.addRow(row);
                }
                tabla.setModel(modelo);
            }

        } catch (SQLException ex) {
        }
        cc.cierraConexion();
    }

}
