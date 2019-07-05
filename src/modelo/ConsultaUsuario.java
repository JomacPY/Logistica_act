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
public class ConsultaUsuario extends conexion{
    public boolean registrar (clUsuario usu) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "INSERT INTO usuario (usua_nick, usua_password, usua_tius_id) VALUES (?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContrasenha());
            ps.setInt(3, usu.getTipo());
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
    
        public boolean modificar (clUsuario usu) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "UPDATE usuario SET usua_nick=?, usua_password=?, usua_tius_id=? WHERE usua_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContrasenha());
            ps.setInt(3, usu.getTipo());
            ps.setInt(4, usu.idusuario);
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
        
               public boolean eliminar (clUsuario usu) {
        PreparedStatement ps = null;
        Connection con = conectar();
        
        String sql = "DELETE FROM usuario WHERE usua_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usu.idusuario);
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
               
        public boolean buscar(clUsuario usu) {
            PreparedStatement ps = null;
            Connection con = conectar();
            ResultSet rs = null;
            
            String sql = "SELECT * FROM usuario WHERE usua_nick=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()) {
                usu.setIdusuario(Integer.parseInt(rs.getString("usua_id")));
                usu.setUsuario(rs.getString("usua_nick"));
                usu.setContrasenha(rs.getString("usua_password"));
                usu.setTipo(Integer.parseInt(rs.getString("usua_tius_id")));
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
