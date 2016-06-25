package abd.p1.view;

import abd.p1.model.Usuario;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class UserPanel extends javax.swing.JPanel {
    
    private boolean editable = true;
    private Date fecha;
    private Usuario user;

    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();  
    }
    
    public void setUser(Usuario user){
        this.user = user;
    }
    
    public Usuario getUser(){
        return this.user;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.user.getNombre();
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        labelNombre.setText(nombre);
    }
    
    public void setNombrePerfil(String nombre){
        Usuario usr = this.getUser();
        usr.setNombre(nombre);
    }
    
    public void setEdad(String edad){
        this.labelEdad.setText(edad + " años");
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
        buttonNombre.setVisible(editable);
        buttonFechaNacimiento.setVisible(editable);
        buttonAvatar.setVisible(editable);
    }

    /**
     * @return the avatarPanel1
     */
    public abd.p1.view.AvatarPanel getAvatarPanel() {
        return avatarPanel1;
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        buttonNombre = new javax.swing.JButton();
        buttonFechaNacimiento = new javax.swing.JButton();
        buttonAvatar = new javax.swing.JButton();
        avatarPanel1 = new abd.p1.view.AvatarPanel();

        labelNombre.setText("Nombre");

        labelEdad.setText("Edad");

        buttonNombre.setText("Cambiar Nombre");
        buttonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNombreActionPerformed(evt);
            }
        });

        buttonFechaNacimiento.setText("Cambiar Fecha de Nacimiento");
        buttonFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFechaNacimientoActionPerformed(evt);
            }
        });

        buttonAvatar.setText("Cambiar Avatar");
        buttonAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAvatarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout avatarPanel1Layout = new javax.swing.GroupLayout(avatarPanel1);
        avatarPanel1.setLayout(avatarPanel1Layout);
        avatarPanel1Layout.setHorizontalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        avatarPanel1Layout.setVerticalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(labelEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(buttonNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEdad)
                            .addComponent(buttonFechaNacimiento)))
                    .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(buttonAvatar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAvatarActionPerformed
        JFileChooser file = new JFileChooser("user.dir");
        Usuario usr = this.getUser();
        
        int result = file.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File image = file.getSelectedFile();
                try {
                    this.avatarPanel1.setIcon(new ImageIcon(ImageIO.read(image)));
                    usr.setFotoFromImageIcon(new ImageIcon(ImageIO.read(image)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
            
    }//GEN-LAST:event_buttonAvatarActionPerformed

    private void buttonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNombreActionPerformed
        String name = JOptionPane.showInputDialog(null, "Introduce tu nuevo nombre");
        this.setNombre(name);
        this.setNombrePerfil(name);
    }//GEN-LAST:event_buttonNombreActionPerformed

    private void buttonFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFechaNacimientoActionPerformed
        Calendario cal = new Calendario(null,true);
        Usuario usr = this.getUser();
      
        cal.setVisible(true);
        if (cal.isAceptar()) {
            this.fecha = cal.getFechaNacimiento();
            usr.setFechaNacimiento(this.fecha);
            Calendar birthDay = Calendar.getInstance();
            birthDay.setTimeInMillis(this.fecha.getTime());
            long currentTime = System.currentTimeMillis();
            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(currentTime);
            int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
            String edad = Integer.toString(years);
            this.setEdad(edad);
        }
        
    }//GEN-LAST:event_buttonFechaNacimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abd.p1.view.AvatarPanel avatarPanel1;
    private javax.swing.JButton buttonAvatar;
    private javax.swing.JButton buttonFechaNacimiento;
    private javax.swing.JButton buttonNombre;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
 
}
