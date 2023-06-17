package Admin;

import Admin.PanelAdmin;
import Usuarios.Ingresar;
import Usuarios.RegistrarUsuario;
import Usuarios.Usuario;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class FormularioPrincipal extends JFrame  {
    private JPanel panelButton, panelContainer, imagen,paneltitulo1;
    private JButton panelAdmin,panelUsuario;
    private JLabel vacio1, vacio2, titulo1;
    private ImagenPrincipal imagenPrincipal;

    public FormularioPrincipal() {
        ImagenPrincipal imagenPrincipal = new ImagenPrincipal();
        this.imagenPrincipal = imagenPrincipal;
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        usuario();
        add(panelContainer);
        administrador();
    }

    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(imagenPrincipal, BorderLayout.CENTER);
        setSize(10,400);
        setVisible(true);

    }

    private void initControl(){
        panelButton = new JPanel();
        panelContainer = new JPanel();
        imagen = new JPanel();
        paneltitulo1= new JPanel();

        titulo1 = new JLabel();
        panelAdmin = new JButton();
        panelUsuario = new JButton();
    }

    private void configFrame(){
        setTitle("Menu de Opciones");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 500);
    }
    private void setControl(){
        titulo1.setText(" ");
        panelAdmin.setText("Administrador");
        panelUsuario.setText("Usuario");
    }

    private void configPanel(){
        paneltitulo1.setLayout(new BoxLayout(paneltitulo1, BoxLayout.Y_AXIS));
        paneltitulo1.add(titulo1);
        paneltitulo1.add(imagenPrincipal);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(100, 100));
        panelButton.add(panelAdmin);
        panelButton.add(panelUsuario);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(paneltitulo1);
        panelContainer.add(panelButton);

        add(panelContainer);
    }
    private void administrador() {
        panelAdmin.addActionListener(e -> {
            PanelAdmin panelAdmin = new PanelAdmin();
            panelAdmin.setVisible(true);
            this.setVisible(false);
        });
    }
    private void usuario() {
        panelUsuario.addActionListener(e -> {
            Ingresar ingresar = new Ingresar();
            ingresar.setVisible(true);
            this.setVisible(false);
        });
    }
}
