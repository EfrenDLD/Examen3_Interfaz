package Usuarios;

import Admin.FormularioPrincipal;
import Admin.ImagenAdmin;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistrarUsuario extends JFrame implements ItemListener, ChangeListener {
    private JPanel panelContainer, panel1, panel2, panelDatos, panelButton, paneltitulo1, panelForm;
    private JButton registrarse, regresar;
    private JLabel vacio1, vacio2, titulo1, nombre, numero, edad, nivel, correo, telefono;
    private JTextField nombEntrada, numEntrada, expEntrada, fechaEntrada, sueldoEntrada, descEntrada;
    private ImagenAdmin imagenAdmin;
    private EventClick eventClick = new EventClick();
    public static ArrayList<Usuario> registroUsuario = new ArrayList<>();
    public static ArrayList<Usuario> listaUsuario = new ArrayList<>();

    public RegistrarUsuario() {
        ImagenAdmin imagenAdmin = new ImagenAdmin();
        this.imagenAdmin = imagenAdmin;
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        regresar();
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
        vacio1 = new JLabel(" ");
        vacio2 = new JLabel(" ");
        titulo1 = new JLabel();
        nombre = new JLabel();
        numero = new JLabel();
        nivel = new JLabel();
        edad = new JLabel();
        correo = new JLabel();
        telefono = new JLabel();

        nombEntrada = new JTextField();
        numEntrada = new JTextField();
        expEntrada = new JTextField();
        fechaEntrada = new JTextField();
        sueldoEntrada = new JTextField();
        descEntrada = new JTextField();
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
        titulo1.setText("Registro de usuarios");
        nombre.setText("Nombre completo :");
        nivel.setText("Numero nivel de estudio :");
        edad.setText("Edad :");
        correo.setText("Correo :");
        telefono.setText("Telefono :");

        registrarse.setText("Registrarse");
        regresar.setText("Regresar");
    }

    private void configPanel() {
        paneltitulo1.setLayout(new BoxLayout(paneltitulo1, BoxLayout.Y_AXIS));
        paneltitulo1.add(titulo1);
        paneltitulo1.add(imagenAdmin);

        panel1.setLayout(new GridLayout(7, 0));
        panel1.add(nombre);
        panel1.add(nivel);
        panel1.add(edad);
        panel1.add(correo);
        panel1.add(telefono);


        panel2.setLayout(new GridLayout(7, 0));
        panel2.add(numEntrada);
        panel2.add(nombEntrada);
        panel2.add(expEntrada);
        panel2.add(fechaEntrada);
        panel2.add(sueldoEntrada);


        panelButton.setLayout(new FlowLayout());
        panelButton.add(regresar);

        panelButton.setLayout(new FlowLayout());
        panelButton.add(registrarse);
        registrarse.addActionListener(eventClick);


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

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public class EventClick implements ActionListener {
        public EventClick() {
            listaUsuario = new ArrayList<>();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombEntrada.getText();
            String nivel = numEntrada.getText();
            String edad = expEntrada.getText();
            String telefono = fechaEntrada.getText();
            String correo = sueldoEntrada.getText();

            listaUsuario.add(new Usuario(nombre, nivel, edad, telefono, correo));

            nombEntrada.setText("");
            numEntrada.setText("");
            expEntrada.setText("");
            fechaEntrada.setText("");
            sueldoEntrada.setText("");
            descEntrada.setText("");

            // Imprimir los datos ingresados
            System.out.println("Datos ingresados:");
            for (Usuario usuario : listaUsuario) {
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Nivel: " + usuario.getNivel());
                System.out.println("Edad: " + usuario.getEdad());
                System.out.println("Telefono: " + usuario.getTelefono());
                System.out.println("Correo: " + usuario.getCorreo());
                System.out.println();
            }
        }
    }

    public static ArrayList<Usuario> getElemento() {
        return listaUsuario;
    }
}



