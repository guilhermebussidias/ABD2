package abd.p1.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class AvatarPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private static final int SIZE = 64;
    private static final ImageIcon defaultIcon = 
            new ImageIcon(AvatarPanel.class.getResource("Dino3.png"));
    
    private ImageIcon icon;
    private Image rescaledIcon;

    public AvatarPanel(){
        this(defaultIcon);
    }
    /**
     * Creates new form AvatarPanel
     * @param icon
     */
    public AvatarPanel(ImageIcon icon) {
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
        initComponents();
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.drawImage(rescaledIcon, 0, 0, this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
