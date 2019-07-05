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
public class ConsultaProveedor extends conexion {
    public boolean registrar(clProveedor prov) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "INSERT INTO proveedor(prov_nombre, prov_direccion, prov_telefono) VALUES(?,?,?)";
        
        try {
        ps = con.prepareStatement(sql);
        ps.setString(1, prov.getprov_nombre());
        ps.setString(2, prov.getprov_direccion());
        ps.setString(3, prov.getprov_telefono());
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
    
    public boolean modificar(clProveedor prov) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "UPDATE proveedor SET prov_nombre=?, prov_direccion=?, prov_telefono=? WHERE prov_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getprov_nombre());
            ps.setString(2, prov.getprov_direccion());
            ps.setString(3, prov.getprov_telefono());
            ps.setInt(4,prov.getprov_id());
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
    
        public boolean eliminar(clProveedor prov) {
            PreparedStatement ps = null;
            Connection con = conectar();
            
            String sql ="DELETE FROM proveedor WHERE prov_id=?";
            
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, prov.getprov_id());
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
        
        public boolean buscar (clProveedor prov) {
            PreparedStatement ps = null;
            Connection con = conectar();
            ResultSet rs = null;
            
            String sql = "SELECT * FROM proveedor WHERE prov_nombre=? ";
            
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, prov.getprov_nombre());
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    prov.setprov_id(Integer.parseInt(rs.getString("prov_id")));
                    prov.setprov_nombre(rs.getString("prov_nombre"));
                    prov.setprov_direccion(rs.getString("prov_direccion"));
                    prov.setprov_telefono(rs.getString("prov_telefono"));
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
