package abd.p1.view;

import java.util.Iterator;

import javax.swing.DefaultListModel;

import abd.p1.model.Usuario;

public class ListaUsuarios extends javax.swing.JPanel {
  
	private static final long serialVersionUID = 1L;
	
	public ListaUsuarios() {
        initComponents();
        jlistUsuarios.setCellRenderer(new UsuarioCellRenderer());
        this.grabFocus();
    }
    
    public void setUsuariosRelacionados(Iterable<Usuario> amigos){
        DefaultListModel<Usuario> modelo = new DefaultListModel<>();
        
        for(Iterator<Usuario> it = amigos.iterator(); it.hasNext();){
            Usuario usr = it.next();
             modelo.addElement(usr);
        }
        //jlistUsuarios.setCellRenderer(new UsuarioCellRenderer());
        jlistUsuarios.setModel(modelo);
    }
    
    public Usuario getSelectedUser(){
        return jlistUsuarios.getSelectedValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlistUsuarios = new javax.swing.JList<>();

        jScrollPane1.setViewportView(jlistUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Usuario> jlistUsuarios;
    // End of variables declaration//GEN-END:variables
}
