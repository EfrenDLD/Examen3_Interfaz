package Usuarios;

import Admin.FormularioPrincipal;
import Admin.ImagenAdmin;
import Usuarios.RegistrarUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ingresar extends JFrame {
    private JPanel panelContainer, panel1, panel2, panelDatos, panelButton, paneltitulo1, panelForm;
    private JButton registrarse, regresar;
    private JLabel vacio1, vacio2, titulo1, nombre, contraseña;
    private JTextField nombEntrada, numEntrada;
    private JPasswordField contraseñaEntrada;
    private ImagenAdmin imagenAdmin;

    public Ingresar() {
        ImagenAdmin imagenAdmin = new ImagenAdmin();
        this.imagenAdmin = imagenAdmin;
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        regresar();
        usuario();
        add(panelContainer);
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(imagenAdmin, BorderLayout.CENTER);
        setSize(100, 200);
        setVisible(true);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panel1 = new JPanel();
        panelButton = new JPanel();
        paneltitulo1 = new JPanel();
        panel2 = new JPanel();
        panelForm = new JPanel();
        panelDatos = new JPanel();

        registrarse = new JButton();
        regresar = new JButton();

        nombre = new JLabel();
        contraseña = new JLabel();

        contraseñaEntrada = new JPasswordField();
    }

    private void configFrame() {
        setTitle("Menu registro nuevo vacante");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 700);
    }

    private void setControl() {
        titulo1.setText("Ingresar datos ");
        nombre.setText("Usuario");
        contraseña.setText("Contraseña:");

        registrarse.setText("Registrarse");
        regresar.setText("Regresar");
    }

    private void configPanel() {
        paneltitulo1.setLayout(new BoxLayout(paneltitulo1, BoxLayout.Y_AXIS));
        paneltitulo1.add(titulo1);
        paneltitulo1.add(imagenAdmin);

        panel1.setLayout(new GridLayout(7, 0));
        panel1.add(nombre);
        panel1.add(contraseña);

        panel2.setLayout(new GridLayout(7, 0));
        panel2.add(numEntrada);
        panel2.add(contraseñaEntrada);

        panelButton.setLayout(new FlowLayout());
        panelButton.add(regresar);

        panelButton.setLayout(new FlowLayout());
        panelButton.add(registrarse);

        panelDatos.setLayout(new GridLayout(1, 4));
        panelDatos.setPreferredSize(new Dimension(500, 150));
        panelDatos.add(panel1);
        panelDatos.add(panel2);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(paneltitulo1);
        panelContainer.add(panelDatos);
        panelContainer.add(panelButton);

        add(panelContainer);
    }

    private void regresar() {
        regresar.addActionListener(e -> {
            this.setVisible(false);
            new FormularioPrincipal().setVisible(true);
        });
    }

    private void usuario() {
        registrarse.addActionListener(e -> {
            RegistrarUsuario registrarUsuario = new RegistrarUsuario();
            registrarUsuario.setVisible(true);
            this.setVisible(false);
        });
    }
}
