package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelConFondo extends JPanel {
    private Image img;

    public JPanelConFondo(String img) {
        this(new ImageIcon(img).getImage());

    }

    public JPanelConFondo(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)+10);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }


    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }

}