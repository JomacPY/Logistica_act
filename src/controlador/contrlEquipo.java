/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.ConsultaEquipo;
import modelo.clEquipo;
import vista.formularioCargar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author matias
 */
public class contrlEquipo implements ActionListener  {
        private clEquipo equi;
        private ConsultaEquipo equiC;
        private formularioCargar form;
        
        public contrlEquipo (clEquipo equi, ConsultaEquipo equiC, formularioCargar form) throws SQLException {
            this.equi = equi;
            this.equiC = equiC;
            this.form= form;
            this.form.btnRegistrar.addActionListener(this);
            this.form.btnModificar.addActionListener(this);
            this.form.btnBuscar.addActionListener(this);
            this.form.btnEliminar.addActionListener(this);
            this.form.btnAtras.addActionListener(this);
        }
        
        public void iniciar() {
            form.setTitle("Equipo");
            form.setLocationRelativeTo(null);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == form.btnRegistrar) {
                
                equi.setequi_id(Integer.parseInt(form.txtIdEquipo.getText()));
                equi.setequi_desc(form.txtDesc.getText());
                equi.setequi_precio_venta(Integer.parseInt(form.txtPrecioV.getText()));
                equi.setequi_precio_compra(Integer.parseInt(form.txtPrecioC.getText()));
                equi.setequi_prov(Integer.parseInt(form.txtProv.getText()));
                equi.setequi_stock(Integer.parseInt(form.txtStock.getText()));
                equi.setequi_tipo(Integer.parseInt(form.txtTipo.getText()));
                if (Integer.parseInt(form.txtStock.getText())>0 && Integer.parseInt(form.txtPrecioV.getText())>0 && Integer.parseInt(form.txtPrecioC.getText())>0 ){
            if (equiC.registrar(equi)) {
                JOptionPane.showMessageDialog(null, "Equipo Registrado con exito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar equipo");
                limpiar();
                
            }
            
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso valores negativos");
                
            }
            }
            
            if (e.getSource() == form.btnModificar) {
                equi.setequi_id(Integer.parseInt(form.txtIdEquipo.getText()));
                equi.setequi_desc(form.txtDesc.getText());
                equi.setequi_precio_venta(Integer.parseInt(form.txtPrecioV.getText()));
                equi.setequi_precio_compra(Integer.parseInt(form.txtPrecioC.getText()));
                equi.setequi_prov(Integer.parseInt(form.txtProv.getText()));
                equi.setequi_stock(Integer.parseInt(form.txtStock.getText()));
                equi.setequi_tipo(Integer.parseInt(form.txtTipo.getText()));
            
            if (equiC.modificar(equi)) {
                JOptionPane.showMessageDialog(null, "Equipo modificado con exito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar equipo");
                limpiar();
                
            }
            }
            
            if (e.getSource() == form.btnEliminar) {
                equi.setequi_id(Integer.parseInt(form.txtIdEquipo.getText()));

            
            if (equiC.eliminar(equi)) {
                JOptionPane.showMessageDialog(null, "Equipo eliminado con exito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar equipo");
                limpiar();
                
            }
            }
            
            if (e.getSource() == form.btnBuscar) {
                equi.setequi_id(Integer.parseInt(form.txtIdEquipo.getText()));

            
            if (equiC.buscar(equi)) {
                form.txtIdEquipo.setText(String.valueOf(equi.getequi_id()));
                form.txtDesc.setText(equi.getequi_desc());
                form.txtPrecioV.setText(String.valueOf(equi.getequi_precio_venta()));
                form.txtPrecioC.setText(String.valueOf(equi.getequi_precio_compra()));
                form.txtStock.setText(String.valueOf(equi.getequi_stock()));
                form.txtProv.setText(String.valueOf(equi.getequi_prov()));
                form.txtTipo.setText(String.valueOf(equi.getequi_tipo()));
            } else {
                JOptionPane.showMessageDialog(null, "Error al encontrar equipo");
                limpiar();
                
            }
            }
        }
        
        
        public void limpiar() {
            form.txtIdEquipo.setText(null);
            form.txtDesc.setText(null);
            form.txtPrecioV.setText(null);
            form.txtPrecioC.setText(null);
            form.txtProv.setText(null);
            form.txtStock.setText(null);
            form.txtTipo.setText(null);
            
        }
}
