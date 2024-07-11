package Grafico;

import Logico.Apostador;
import Logico.Caballo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Agregar extends JFrame {
    private ArrayList<Apostador> apostadores;
    private ArrayList<Caballo> caballos;

    public Agregar(ArrayList<Apostador> apostadores, ArrayList<Caballo> caballos) {
        this.apostadores = apostadores;
        this.caballos = caballos;

        setTitle("Agregar Apostador");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();

        JLabel betAmountLabel = new JLabel("Monto a Apostar:");
        JTextField betAmountField = new JTextField();

        JLabel horseLabel = new JLabel("Caballo:");
        JComboBox<String> horseComboBox = new JComboBox<>();
        for (Caballo caballo : caballos) {
            horseComboBox.addItem(caballo.getNombre());
        }

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                double betAmount;

                try {
                    betAmount = Double.parseDouble(betAmountField.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un monto válido.");
                    return;
                }

                int selectedHorseIndex = horseComboBox.getSelectedIndex();

                if (name.isEmpty() || betAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.");
                } else {
                    Caballo selectedHorse = caballos.get(selectedHorseIndex);
                    Apostador apostador = new Apostador(name, betAmount, 2.0, selectedHorseIndex);
                    apostadores.add(apostador);
                    JOptionPane.showMessageDialog(null, "Apostador agregado con éxito.");
                    dispose();
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(betAmountLabel);
        panel.add(betAmountField);
        panel.add(horseLabel);
        panel.add(horseComboBox);
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
    }
}