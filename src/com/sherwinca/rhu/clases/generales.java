package com.sherwinca.rhu.clases;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Desarrollo
 */
public class generales {
    
    /*Compara dos fechas */
    
    public int compararFechasConDate(String fecha1, String fecha2) {
        int resultado = 0;
        try {
            /**
             * Obtenemos las fechas enviadas en el formato a comparar
             */
            SimpleDateFormat formateador = new SimpleDateFormat("dd/mm/yyyy");
            Date fechaDate1 = (Date) formateador.parse(fecha1);
            Date fechaDate2 = (Date) formateador.parse(fecha2);

            if (fechaDate1.before(fechaDate2)) {
//        "La Fecha 1 es menor "
                resultado = 1;

            } else {
                if (fechaDate2.before(fechaDate1)) {
//         "La Fecha 1 es Mayor "
                    System.out.println("fecha ini es mayor que fecha final");
                    resultado = 2;
                } else {
//         Las Fechas Son iguales 
                    resultado = 3;
                    System.out.println("iguales");
                }
            }
        } catch (ParseException e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }
        return resultado;
    }
    
   
}
