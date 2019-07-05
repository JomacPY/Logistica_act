/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Date;
/**
 *
 * @author matias
 */
public class clProveedor {
    private int prov_id;
    private String prov_nombre;
    private String prov_direccion;
    private String prov_telefono;
    
    public int getprov_id() {
        return prov_id;
    }
    public void setprov_id(int prov_id) {
        this.prov_id = prov_id;
    }
    
    public String getprov_nombre() {
        return prov_nombre;
    }
    public void setprov_nombre(String prov_nombre) {
        this.prov_nombre = prov_nombre;
    }
    
    public String getprov_direccion() {
        return prov_direccion;
    }
    public void setprov_direccion(String prov_direccion) {
        this.prov_direccion = prov_direccion;
    }
    
    public String getprov_telefono() {
        return prov_telefono;
    }
    public void setprov_telefono(String prov_telefono) {
        this.prov_telefono = prov_telefono;
    }
        
}
