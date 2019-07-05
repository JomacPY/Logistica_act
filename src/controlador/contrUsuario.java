package controlador;
import modelo.ConsultaUsuario;
import modelo.clUsuario;
import vista.formularioCargar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Sentencias_sql;
import vista.formularioUsuario;
        
/**
 *
 * @author EVA Tester
 */
public class contrUsuario implements ActionListener {
    private clUsuario usua;
    private ConsultaUsuario usuaC;
    private formularioUsuario formU;
    
    public contrUsuario (clUsuario usua, ConsultaUsuario usuaC, formularioUsuario formU) throws SQLException{
            this.usua = usua;
            this.usuaC = usuaC;
            this.formU = formU;
            this.formU.btnRegistrar.addActionListener(this);
            this.formU.btnModificar.addActionListener(this);
            this.formU.btnBuscar.addActionListener(this);
            this.formU.btnEliminar.addActionListener(this);
    }
    
    public void iniciar() {
        formU.setTitle("Usuario");
        formU.setLocationRelativeTo(null);
        formU.txtCodUsu.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
              if (e.getSource() == formU.btnRegistrar) {
                usua.setUsuario(formU.txtNickUsu.getText());
                usua.setContrasenha(formU.txtConUsu.getText());
                usua.setTipo(Integer.parseInt(formU.txtTipoUsu.getText()));
              if (usuaC.registrar(usua)) {
                  JOptionPane.showMessageDialog(null, "Usuario Registrado con exito");
                  limpiar();
              } else {
                  JOptionPane.showMessageDialog(null, "Error al registrar Usuario");
                  limpiar();
              }
        }
              if (e.getSource() == formU.btnModificar) {
                usua.setIdusuario(Integer.parseInt(formU.txtCodUsu.getText()));
                usua.setUsuario(formU.txtNickUsu.getText());
                usua.setContrasenha(formU.txtConUsu.getText());
                usua.setTipo(Integer.parseInt(formU.txtTipoUsu.getText()));
              if (usuaC.modificar(usua)) {
                  JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
                  limpiar();
              } else {
                  JOptionPane.showMessageDialog(null, "Error al modificar usuario");
                  limpiar();
              }
        }
              
              if (e.getSource() == formU.btnEliminar) {
                usua.setIdusuario(Integer.parseInt(formU.txtCodUsu.getText()));

              if (usuaC.eliminar(usua)) {
                  JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
                  limpiar();
              } else {
                  JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
                  limpiar();
              }
        }
              
              if (e.getSource() == formU.btnBuscar) {
                usua.setUsuario((formU.txtNickUsu.getText()));

              if (usuaC.buscar(usua)) {
                 formU.txtCodUsu.setText(String.valueOf(usua.getIdusuario()));
                 formU.txtNickUsu.setText(usua.getUsuario());
                 formU.txtConUsu.setText(usua.getContrasenha());
                 formU.txtTipoUsu.setText(String.valueOf(usua.getTipo()));
              } else {
                  JOptionPane.showMessageDialog(null, "Error al encontrar usuario");
                  limpiar();
              }
        }
                     
    }
    
                public void limpiar() {
                formU.txtCodUsu.setText(null);
                formU.txtNickUsu.setText(null);
                formU.txtConUsu.setText(null);
                formU.txtTipoUsu.setText(null);
            }
}
