package Admin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Admin.NuevoVacante.listaVacantes;

public class ConsultarVacante extends JFrame {
    private JPanel panelContainer, panelDatos, panelButton;
    private JLabel titulo, nombreLabel, numeroLabel, experienciaLabel, fechaLabel, sueldoLabel, descripcionLabel;
    private JTextArea nombreText, numeroText, experienciaText, fechaText, sueldoText, descripcionText;
    private JButton regresar, eliminar;

    public ConsultarVacante() {
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        regresar();
        eliminar();
        mostrarDatos(listaVacantes);
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panelDatos = new JPanel();
        regresar = new JButton();
        panelButton = new JPanel();
        eliminar = new JButton();

        titulo = new JLabel("Datos de la vacante");
        nombreLabel = new JLabel("Nombre de vacante: ");
        numeroLabel = new JLabel("Numero de vacante: ");
        experienciaLabel = new JLabel("¿Tiene Experiencia? ");
        fechaLabel = new JLabel("Fecha de publicacion: ");
        sueldoLabel = new JLabel("Sueldo vacante: ");
        descripcionLabel = new JLabel("Descripcion de la vacante: ");

        nombreText = new JTextArea();
        numeroText = new JTextArea();
        experienciaText = new JTextArea();
        fechaText = new JTextArea();
        sueldoText = new JTextArea();
        descripcionText = new JTextArea();
    }

    private void configFrame() {
        setTitle("Consultar Vacante");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 700);
    }

    private void setControl() {
        regresar.setText("Regresar");
        eliminar.setText("Eliminar Vacante");
    }

    private void configPanel() {
        panelDatos.setLayout(new GridLayout(7, 2));
        panelDatos.setPreferredSize(new Dimension(500, 400));
        panelDatos.add(nombreLabel);
        panelDatos.add(nombreText);
        panelDatos.add(numeroLabel);
        panelDatos.add(numeroText);
        panelDatos.add(experienciaLabel);
        panelDatos.add(experienciaText);
        panelDatos.add(fechaLabel);
        panelDatos.add(fechaText);
        panelDatos.add(sueldoLabel);
        panelDatos.add(sueldoText);
        panelDatos.add(descripcionLabel);
        panelDatos.add(descripcionText);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(titulo);
        panelContainer.add(panelDatos);
        panelContainer.add(panelButton);

        panelButton.setLayout(new FlowLayout());
        panelButton.add(regresar);
        panelButton.add(eliminar);
        add(panelContainer);
    }

    private void mostrarDatos(ArrayList<Vacante> listaVacantes) {
        if (listaVacantes.size() > 0) {
            Vacante vacante = listaVacantes.get(listaVacantes.size() - 1);
            nombreText.setText(vacante.getNombre());
            numeroText.setText(vacante.getNumero());
            experienciaText.setText(vacante.getExperiencia());
            fechaText.setText(vacante.getFecha());
            sueldoText.setText(vacante.getSueldo());
            descripcionText.setText(vacante.getDescripcion());
        }
    }

    private void regresar() {
        regresar.addActionListener(e -> {
            this.setVisible(false);
            new PanelAdmin().setVisible(true);
        });
    }

    private void eliminar() {
        eliminar.addActionListener(e -> {
            if (listaVacantes.size() > 0) {
                listaVacantes.remove(listaVacantes.size() - 1);
                limpiarCampos();
            }
        });
    }

    private void limpiarCampos() {
        nombreText.setText("");
        numeroText.setText("");
        experienciaText.setText("");
        fechaText.setText("");
        sueldoText.setText("");
        descripcionText.setText("");
    }
}

