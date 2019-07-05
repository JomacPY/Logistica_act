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
public class clEquipo {
    private int equi_id;
    private String equi_desc;
    private int equi_precio_venta;
    private int equi_precio_compra;
    private int equi_stock;
    private int equi_prov;
    private int equi_tipo;
    
    public int getequi_id() {
        return equi_id;
    }
    public void setequi_id(int equi_id) {
        this.equi_id = equi_id;
    }
    
    public String getequi_desc() {
        return equi_desc;
    }
    public void setequi_desc(String equi_desc) {
        this.equi_desc = equi_desc;
    }
    
    public int getequi_precio_venta() {
        return equi_precio_venta;
    }
    public void setequi_precio_venta(int equi_precio_venta) {
        this.equi_precio_venta = equi_precio_venta;
    }
    
    public int getequi_precio_compra() {
        return equi_precio_compra;
    } 
    public void setequi_precio_compra(int equi_precio_compra) {
        this.equi_precio_compra = equi_precio_compra;
    }
    
    public int getequi_stock() {
        return equi_stock;
    }
    public void setequi_stock(int equi_stock) {
        this.equi_stock = equi_stock;
    }
    
    public int getequi_prov() {
        return equi_prov;
    }
    public void setequi_prov(int equi_prov) {
        this.equi_prov = equi_prov;
    }
    
    public int getequi_tipo() {
        return equi_tipo;
    }
    public void setequi_tipo(int equi_tipo) {
        this.equi_tipo = equi_tipo;
    }
}