package Admin;

import java.awt.*;
public class ImagenAdmin extends Canvas {
    @Override
    public void paint(Graphics g) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\InterfazGrafica\\perfil.png");
        g.drawImage(image,30,30,this);
    }
}