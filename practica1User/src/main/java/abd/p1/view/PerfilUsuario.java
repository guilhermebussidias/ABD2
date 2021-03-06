package abd.p1.view;

import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import abd.p1.controller.Facade;
import abd.p1.model.Aficion;
import abd.p1.model.Usuario;

public class PerfilUsuario extends javax.swing.JDialog {
    
	private static final long serialVersionUID = 1L;
	private Usuario user;
    private boolean editable, guardar;
    DefaultListModel<Aficion> modelo = new DefaultListModel<>();

    /**
     * Creates new form ModificarPerfil
     */
    public PerfilUsuario(java.awt.Frame parent, boolean modal, Usuario user, Usuario baseUser) {
        super(parent, modal);
        initComponents();
        
        this.user = user;
        String txt = user.getDescripcion() == null ? "" : user.getDescripcion();
        this.descripcion.setText(txt);
        
        if(user.getAficiones().isEmpty() ==  false){
           for (Aficion temp : user.getAficiones()){
            modelo.addElement(temp);
            } 
            this.listaAficiones.setModel(modelo);
            this.listaAficiones.setCellRenderer(new AficionCellRenderer());
        }
        
        this.labelGenero.setText(user.getGenero());
        this.labelOrientacionSexual.setText(user.getOpcionSexual());
        this.userPanel1.setUser(user);
        this.userPanel1.setNombre(user.getNombre());
        this.userPanel1.setEdad(user.getEdad() + "");
        
        ImageIcon img = user.getFotoAsImageIcon();
        if (img == null)
        	img = new ImageIcon(AvatarPanel.class.getResource("Dino3.png"));
    	this.userPanel1.getAvatarPanel().setIcon(img);
        	
        this.jLabel3.setVisible(false);
        this.labelDistancia.setVisible(false);
        
        double distancia = 0.0;
        if (baseUser != null) {
        	distancia = Facade.getInstance().getUsuarioController().distance(user, baseUser);
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        labelDistancia.setText(numberFormat.format(distancia/1000.0) + " Km");
    }

    public PerfilUsuario(JFrame jFrame, boolean b) {}
    

     /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
        this.userPanel1.setEditable(editable);
        this.buttonAnadirAficion.setVisible(editable);
        this.buttonCambiarContrasena.setVisible(editable);
        this.buttonCambiarPreferencia.setVisible(editable);
        this.buttonCambiarSexo.setVisible(editable);
        this.buttonCancelar.setVisible(editable);
        this.buttonEditarAficion.setVisible(editable);
        this.buttonEliminarAficion.setVisible(editable);
        this.buttonGuardar.setVisible(editable);
        this.descripcion.setEditable(editable);
        
        //Sólo visible la distancia en la vista Ver Perfil
        if(!editable){
            this.jLabel3.setVisible(true);
            this.labelDistancia.setVisible(true); 
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPanel1 = new abd.p1.view.UserPanel();
        labelDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        labelAficiones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAficiones = new javax.swing.JList<>();
        buttonAnadirAficion = new javax.swing.JButton();
        buttonEliminarAficion = new javax.swing.JButton();
        buttonEditarAficion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelGenero = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelOrientacionSexual = new javax.swing.JLabel();
        buttonCambiarSexo = new javax.swing.JButton();
        buttonCambiarPreferencia = new javax.swing.JButton();
        buttonCambiarContrasena = new javax.swing.JButton();
        buttonGuardar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelDistancia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelDescripcion.setText("Descripción:");

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        labelAficiones.setText("Aficiones:");

        jScrollPane2.setViewportView(listaAficiones);

        buttonAnadirAficion.setText("Añadir afición");
        buttonAnadirAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirAficionActionPerformed(evt);
            }
        });

        buttonEliminarAficion.setText("Eliminar seleccionada");
        buttonEliminarAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarAficionActionPerformed(evt);
            }
        });

        buttonEditarAficion.setText("Editar seleccionada");
        buttonEditarAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAficionActionPerformed(evt);
            }
        });

        jLabel1.setText("Sexo:");

        labelGenero.setText("Masculino");

        jLabel2.setText("Busca:");

        labelOrientacionSexual.setText("Ambos");

        buttonCambiarSexo.setText("Cambiar sexo");
        buttonCambiarSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarSexoActionPerformed(evt);
            }
        });

        buttonCambiarPreferencia.setText("Cambiar preferencia");
        buttonCambiarPreferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarPreferenciaActionPerformed(evt);
            }
        });

        buttonCambiarContrasena.setText("Cambiar contraseña");
        buttonCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCambiarContrasenaActionPerformed(evt);
            }
        });

        buttonGuardar.setText("Guardar cambios");
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Distancia:");

        labelDistancia.setText("100m");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAnadirAficion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonEliminarAficion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonEditarAficion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescripcion)
                            .addComponent(labelAficiones)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(labelOrientacionSexual))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(labelGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonCambiarSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCambiarPreferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCambiarContrasena)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDistancia)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAficiones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAnadirAficion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEliminarAficion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(buttonEditarAficion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelGenero)
                    .addComponent(buttonCambiarSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelOrientacionSexual)
                    .addComponent(buttonCambiarPreferencia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCambiarContrasena)
                    .addComponent(buttonGuardar)
                    .addComponent(buttonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelDistancia))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed
      this.user.setDescripcion(this.descripcion.getText());
      System.out.println(user);//FIXME
      Facade.getInstance().getUsuarioController().update(user);
      this.setVisible(false);
    }//GEN-LAST:event_buttonGuardarActionPerformed

    private void buttonCambiarSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarSexoActionPerformed
         Object sexo = JOptionPane.showInputDialog(null, "Elige tu sexo", "Elección del sexo",
            JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Mujer",
            "Varón" }, "Mujer");
        this.labelGenero.setText(sexo.toString());
        this.user.setGenero(sexo.toString());
    }//GEN-LAST:event_buttonCambiarSexoActionPerformed

    private void buttonCambiarPreferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarPreferenciaActionPerformed
        Object preferencia = JOptionPane.showInputDialog(null, "Elige tu preferencia", "Elección de la preferencia",
            JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Mujeres",
            "Hombres", "Ambos" }, "Mujeres");
        this.labelOrientacionSexual.setText(preferencia.toString());
        this.user.setOpcionSexual(preferencia.toString());
    }//GEN-LAST:event_buttonCambiarPreferenciaActionPerformed

    private void buttonCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCambiarContrasenaActionPerformed
        String contrasena = JOptionPane.showInputDialog(null, "Introduce tu nueva contraseña");
        this.user.setContrasena(contrasena);
    }//GEN-LAST:event_buttonCambiarContrasenaActionPerformed

    private void buttonAnadirAficionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnadirAficionActionPerformed
        String aficion = JOptionPane.showInputDialog(null, "Introduce tu nueva aficion");
        Aficion afi = new Aficion();
        afi.setTexto(aficion);
        afi.setUsuario(user);
        modelo.addElement(afi);
        this.listaAficiones.setModel(modelo);
        this.listaAficiones.setCellRenderer(new AficionCellRenderer());
        this.user.setAficion(afi);
    }//GEN-LAST:event_buttonAnadirAficionActionPerformed

    private void buttonEliminarAficionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarAficionActionPerformed
        Aficion aficion = this.listaAficiones.getSelectedValue();
        int index = this.listaAficiones.getSelectedIndex();
        this.user.borrarAficion(aficion);
        modelo.remove(index);
        this.listaAficiones.setModel(modelo);
        this.listaAficiones.setCellRenderer(new AficionCellRenderer());
    }//GEN-LAST:event_buttonEliminarAficionActionPerformed

    private void buttonEditarAficionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAficionActionPerformed
        Aficion aficion = this.listaAficiones.getSelectedValue();
        int index = this.listaAficiones.getSelectedIndex();
        String afi = JOptionPane.showInputDialog(null, "Modifica tu afición", aficion.getTexto());
        Aficion afic = new Aficion();
        afic.setTexto(afi);
        afic.setUsuario(user);
        modelo.remove(index);
        this.user.borrarAficion(aficion);
        modelo.add(index,afic);
        this.user.setAficion(afic);
        this.listaAficiones.setModel(modelo);
        this.listaAficiones.setCellRenderer(new AficionCellRenderer());
    }//GEN-LAST:event_buttonEditarAficionActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PerfilUsuario dialog = new PerfilUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnadirAficion;
    private javax.swing.JButton buttonCambiarContrasena;
    private javax.swing.JButton buttonCambiarPreferencia;
    private javax.swing.JButton buttonCambiarSexo;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditarAficion;
    private javax.swing.JButton buttonEliminarAficion;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAficiones;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelDistancia;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelOrientacionSexual;
    private javax.swing.JList<Aficion> listaAficiones;
    private abd.p1.view.UserPanel userPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the userPanel1
     */
    public abd.p1.view.UserPanel getUserPanel1() {
        return userPanel1;
    }

   
}
