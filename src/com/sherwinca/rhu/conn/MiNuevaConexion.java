/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sherwinca.rhu.conn;
import java.sql.*;

/**
 *
 * @author Miguel
 */
public class MiNuevaConexion {
    public Connection conexion = null;
    public void estableceConexion()
    {
        if (conexion != null)
            return;
        String url = "jdbc:postgresql://localhost:5432/SIGRHUSW";//ojo aqui con el puerto seguro el tuyo sera 5432
        try
        {
           Class.forName("org.postgresql.Driver");
           conexion = DriverManager.getConnection(url,"postgres","mh09016");
           if (conexion !=null){
               System.out.println("Conexión a base de datos ... Ok");
           }
        } catch (Exception e) {
            System.out.println("Problema al establecer la Conexión a la base de datos 1 ");
        }
    }
         
public void cierraConexion()
    {
        try
        {
            conexion.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

   
    }


    

