/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author matias
 */
public class ConsultaEquipo extends conexion {
    public boolean registrar (clEquipo equi) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "INSERT INTO logistica.equipo (equi_id, equi_desc, equi_precio_venta, equi_precio_compra, equi_prov_id, equi_stock, equi_tima_id) VALUES (?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equi.getequi_id());
            ps.setString(2, equi.getequi_desc());
            ps.setInt(3, equi.getequi_precio_venta());
            ps.setInt(4, equi.getequi_precio_compra());
            ps.setInt(5, equi.getequi_prov());
            ps.setInt(6, equi.getequi_stock());
            ps.setInt(7, equi.getequi_tipo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;       
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
               System.err.println(e);
            }
        }
    }
    
        public boolean modificar(clEquipo equi) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "UPDATE equipo SET equi_desc=?, equi_precio_venta=?, equi_precio_compra=?, equi_prov_id=?, equi_stock=?, equi_tima_id=? WHERE equi_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equi.getequi_desc());
            ps.setInt(2, equi.getequi_precio_venta());
            ps.setInt(3, equi.getequi_precio_compra());
            ps.setInt(4,equi.getequi_prov());
            ps.setInt(5, equi.getequi_stock());
            ps.setInt(6, equi.getequi_tipo());
            ps.setInt(7, equi.getequi_id());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
               System.err.println(e); 
        }
        
    }

        }
        
       public boolean eliminar(clEquipo equi) {
            PreparedStatement ps = null;
            Connection con = conectar();
        
        String sql = "DELETE FROM equipo WHERE equi_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equi.getequi_id());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
               System.err.println(e); 
        }
        
    }

        }
       
        public boolean buscar(clEquipo equi) {
            PreparedStatement ps = null;
            Connection con = conectar();
            ResultSet rs = null;
        
        String sql = "SELECT * FROM equipo WHERE equi_id=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equi.getequi_id());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                equi.setequi_id(Integer.parseInt(rs.getString("equi_id")));
                equi.setequi_desc(rs.getString("equi_desc"));
                equi.setequi_precio_venta(Integer.parseInt(rs.getString("equi_precio_venta")));
                equi.setequi_precio_compra(Integer.parseInt(rs.getString("equi_precio_compra")));
                equi.setequi_prov(Integer.parseInt(rs.getString("equi_prov_id")));
                equi.setequi_stock(Integer.parseInt(rs.getString("equi_stock")));
                equi.setequi_tipo(Integer.parseInt(rs.getString("equi_tima_id")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
               System.err.println(e); 
        }
        
    }

        }
}
    