package Admin;
import Admin.FormularioPrincipal;
import Admin.ImagenAdmin;
import Admin.NuevoVacante;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class PanelAdmin extends JFrame {
    private JPanel panelButton, panelContainer, imagen,paneltitulo1;
    private JButton crearNuevo, consultarDato, regresar1;
    private JLabel  titulo1;
    private ImagenAdmin imagenAdmin;

    public PanelAdmin() {
        ImagenAdmin imagenAdmin = new ImagenAdmin();
        this.imagenAdmin = imagenAdmin;
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        regresar1();
        admin();
        consulta();
        //admins();
        add(panelContainer);
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(imagenAdmin, BorderLayout.CENTER);
        setSize(80, 600);
        setVisible(true);
    }

    private void initControl() {
        panelButton = new JPanel();
        panelContainer = new JPanel();
        imagen = new JPanel();
        regresar1 = new JButton();
        crearNuevo = new JButton();
        consultarDato = new JButton();
        paneltitulo1=new JPanel();
        titulo1 = new JLabel();
    }

    private void configFrame() {
        setTitle("Menu Administrador");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(800, 500);
    }

    private void setControl() {
        titulo1.setText("Ingresar datos ");
        crearNuevo.setText("Crear nueva vacante");
        consultarDato.setText("Consultar vacantes publicadas");
        regresar1.setText("Regresar");
    }

    private void configPanel() {
        paneltitulo1.setLayout(new BoxLayout(paneltitulo1, BoxLayout.Y_AXIS));
        paneltitulo1.add(titulo1);
        paneltitulo1.add(imagenAdmin);


        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(800, 100));
        panelButton.add(crearNuevo);
        panelButton.add(consultarDato);
        panelButton.add(regresar1);

        imagen.setLayout(new FlowLayout());
        imagen.setPreferredSize(new Dimension(250, 250));
        imagen.add(imagenAdmin);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.setPreferredSize(new Dimension(200, 300));
        panelContainer.add(imagen);
        panelContainer.add(panelButton);
        add(panelContainer);
    }

    private void admin() {
        crearNuevo.addActionListener(e -> {
            NuevoVacante nuevoVacante = new NuevoVacante();
            nuevoVacante.setVisible(true);
            this.setVisible(false);
        });
    }

    /*
    private void admins() {
        consultarDato.addActionListener(e -> {
            TablaVacante tablaVacante = new TablaVacante();
            nuevoVacante.setVisible(true);
            this.setVisible(false);
        });
    }
    */

    private void regresar1() {
        regresar1.addActionListener(e -> {
            this.setVisible(false);
            new FormularioPrincipal().setVisible(true);
        });
    }
    private void consulta() {
        consultarDato.addActionListener(e -> {
            ConsultarVacante consultarVacante = new ConsultarVacante();
            consultarVacante.setVisible(true);
            this.setVisible(false);
        });
    }
}
