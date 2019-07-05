/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.ConsultaProveedor;
import modelo.clProveedor;
import vista.formularioProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author matias
 */
    public class contrlProveedor implements ActionListener {
        private clProveedor prov;
        private ConsultaProveedor provC;
        private formularioProveedor formP;
        
        public contrlProveedor (clProveedor prov, ConsultaProveedor provC, formularioProveedor formP) throws SQLException{
            this.prov = prov;
            this.provC = provC;
            this.formP = formP;
            this.formP.btnRegistrar.addActionListener(this);
            this.formP.btnModificar.addActionListener(this);
            this.formP.btnBuscar.addActionListener(this);
            this.formP.btnEliminar.addActionListener(this);
            
            
        }
        
        public void iniciar() {
            formP.setTitle("Proveedor");
            formP.setLocationRelativeTo(null);
            formP.txtId.setVisible(false);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
             if (e.getSource() == formP.btnRegistrar) {
                prov.setprov_nombre(formP.txtNomProv.getText());
                prov.setprov_direccion(formP.txtProvDir.getText());
                prov.setprov_telefono(formP.txtProvTel.getText());
              if (provC.registrar(prov)) {
                  JOptionPane.showMessageDialog(null, "Proveedor Registrado con exito");
                  limpiar();
              } else {
                  JOptionPane.showMessageDialog(null, "Error al registrar proveedor");
                  limpiar();
              }
        }
             
              if (e.getSource() == formP.btnModificar) {
                 prov.setprov_id(Integer.parseInt(formP.txtId.getText()));
                 prov.setprov_nombre(formP.txtNomProv.getText());
                 prov.setprov_direccion(formP.txtProvDir.getText());
                 prov.setprov_telefono(formP.txtProvTel.getText());
              if (provC.modificar(prov)) {
                  JOptionPane.showMessageDialog(null, "Proveedor modificado con exito");
                  limpiar();
              } else {
                  JOptionPane.showMessageDialog(null, "Error al modificar proveedor");
                  limpiar();
              }
        }
              if (e.getSource() == formP.btnEliminar) {
                 prov.setprov_id(Integer.parseInt(formP.txtId.getText()));

              if (provC.eliminar(prov)) {
                  JOptionPane.showMessageDialog(null, "Proveedor eliminado con exito");
                  limpiar();
              } else {
                  JOptionPane.showMessageDialog(null, "Error al eliminar proveedor, debido a que contiene equipos en el almacen");
                  limpiar();
              }
        }
               
              if (e.getSource() == formP.btnBuscar) {
                 prov.setprov_nombre((formP.txtNomProv.getText()));
                 

              if (provC.buscar(prov)) {
                  formP.txtId.setText(String.valueOf(prov.getprov_id()));
                  formP.txtNomProv.setText(prov.getprov_nombre());
                  formP.txtProvDir.setText(prov.getprov_direccion());
                  formP.txtProvTel.setText(prov.getprov_telefono());

              } else {
                  JOptionPane.showMessageDialog(null, "No se encontro proveedor");
                  limpiar();
              }
        }
        

        
        }
                
            public void limpiar() {
                formP.txtId.setText(null);
                formP.txtNomProv.setText(null);
                formP.txtProvDir.setText(null);
                formP.txtProvTel.setText(null);
            }
 }
