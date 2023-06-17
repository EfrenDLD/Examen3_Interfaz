package Admin;

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

public class NuevoVacante extends JFrame implements ItemListener, ChangeListener {
    private JPanel panelContainer, panel1,panel2,panelDatos, panelButton,paneltitulo1,panelForm;
    private JButton publicar, regresar;
    private JLabel vacio1, vacio2, titulo1, nombre, numero, experiencia, fecha, sueldo, descripcion;
    private JTextField nombEntrada, numEntrada, expEntrada, fechaEntrada, sueldoEntrada, descEntrada;
    private ImagenAdmin imagenAdmin;
    private JRadioButton Si, No;
    private EventClick eventClick = new EventClick();
    public static ArrayList<Vacante> registroVacantes = new ArrayList<>();
    public static ArrayList<Vacante> listaVacantes = new ArrayList<>();

    public NuevoVacante() {
        ImagenAdmin imagenAdmin = new ImagenAdmin();
        this.imagenAdmin = imagenAdmin;
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        regresar();
        Si.addChangeListener(this);
        No.addChangeListener(this);
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
        panel2=new JPanel();
        panelForm=new JPanel();
        panelDatos= new JPanel();

        publicar = new JButton();
        regresar = new JButton();
        vacio1 = new JLabel(" ");
        vacio2 = new JLabel(" ");
        titulo1 = new JLabel();
        nombre = new JLabel();
        numero = new JLabel();
        experiencia = new JLabel();
        fecha = new JLabel();
        sueldo = new JLabel();
        descripcion = new JLabel();

        nombEntrada = new JTextField();
        numEntrada = new JTextField();
        expEntrada = new JTextField();
        fechaEntrada = new JTextField();
        sueldoEntrada = new JTextField();
        descEntrada = new JTextField();

        Si = new JRadioButton();
        No = new JRadioButton();
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
        titulo1.setText("Registro de nuevo adeudo");

        nombre.setText("Nombre de vacante ");
        numero.setText("Numero de vacante");
        experiencia.setText("¿Tiene Experiencia?");
        Si.setText("Si");
        No.setText("No");
        fecha.setText("Fecha de publicacion");
        sueldo.setText("Sueldo vacante");
        descripcion.setText("Descripcion de la vacante");

        publicar.setText("Publicar Vacante");
        regresar.setText("Regresar");
    }

    private void configPanel() {
        paneltitulo1.setLayout(new BoxLayout(paneltitulo1, BoxLayout.Y_AXIS));
        paneltitulo1.add(titulo1);
        paneltitulo1.add(imagenAdmin);

        panel1.setLayout(new GridLayout(7, 0));
        panel1.add(nombre);
        panel1.add(numero);
        panel1.add(experiencia);
        panel1.add(fecha);
        panel1.add(sueldo);
        panel1.add(descripcion);


        panel2.setLayout(new GridLayout(7,0));
        panel2.add(numEntrada);
        panel2.add(nombEntrada);
        panel2.add(expEntrada);
        panel2.add(fechaEntrada);
        panel2.add(sueldoEntrada);
        panel2.add(descEntrada);


        panelButton.setLayout(new FlowLayout());
        panelButton.add(regresar);

        panelButton.setLayout(new FlowLayout());
        panelButton.add(publicar);
        publicar.addActionListener(eventClick);


        panelDatos.setLayout(new GridLayout(1,4));
        panelDatos.setPreferredSize(new Dimension(500,150));
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
            new PanelAdmin().setVisible(true);
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
            listaVacantes = new ArrayList<>();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombEntrada.getText();
            String numero = numEntrada.getText();
            String experiencia = expEntrada.getText();
            String fecha = fechaEntrada.getText();
            String sueldo = sueldoEntrada.getText();
            String descripcion = descEntrada.getText();

            listaVacantes.add(new Vacante(nombre, numero, experiencia, fecha, sueldo, descripcion));

            nombEntrada.setText("");
            numEntrada.setText("");
            expEntrada.setText("");
            fechaEntrada.setText("");
            sueldoEntrada.setText("");
            descEntrada.setText("");
        }
    }

    public static ArrayList<Vacante> getElemento() {
        return listaVacantes;
    }
}



