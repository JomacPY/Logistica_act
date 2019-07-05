/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matias
 */
public class Sentencias_sql {
    private conexion con;
    PreparedStatement ps;
    ResultSet rs;

    public Sentencias_sql() {
        con = new conexion();
    }
    
    public boolean insertar(String datos[], String insert) {
        boolean estado = false;
               try {
            ps = con.conectar().prepareStatement(insert);
            for(int i=0; i<=datos.length-1;i++){
                ps.setString(i+1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
         }catch(SQLException e){
         System.out.println(e);
      }
               return estado;
    }
    
         public Object [][] GetTabla(String colName[], String tabla, String sql){
      int registros = 0;
      
      try{
         ps = con.conectar().prepareStatement("select count(*) as total from " + tabla);
         rs = ps.executeQuery();
         rs.next();
         registros = rs.getInt("total");
         rs.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    
      try{
         ps = con.conectar().prepareStatement(sql);
         rs = ps.executeQuery();
         int i = 0;
         while(rs.next()){
            for(int j=0; j<=colName.length-1;j++){
                col[j] = rs.getString(colName[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         rs.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
}
         