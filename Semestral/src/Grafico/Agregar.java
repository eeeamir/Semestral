package Grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Logico.Apostador;
import Logico.Caballo;

public class Agregar extends JFrame {
    private ArrayList<Apostador> apostadores;
    private ArrayList<Caballo> caballos;

    private Font loadFont(String path, float size) {
        Font font = null;
        try {
            File fontFile = new File(path);
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            font = new Font("Arial", Font.PLAIN, (int) size);
        }
        return font;
    }

    public Agregar(ArrayList<Apostador> apostadores, ArrayList<Caballo> caballos) {
        this.apostadores = apostadores;
        this.caballos = caballos;

        setTitle("Agregar Apostador");
        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBackground(new Color(172, 129, 100));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("NOMBRE?");
        JTextField nameField = new JTextField();

        JLabel betAmountLabel = new JLabel("MONTO?");
        JTextField betAmountField = new JTextField();

        JLabel horseLabel = new JLabel("CABALLO?");
        JComboBox<String> horseComboBox = new JComboBox<>();
        for (Caballo caballo : caballos) {
            horseComboBox.addItem(caballo.getNombre());
        }

        JButton addButton = createButton("AGREGAR");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();
                double monto = Double.parseDouble(betAmountField.getText());
                String caballo = (String) horseComboBox.getSelectedItem();

                Apostador apostador = new Apostador(nombre, monto, caballo);
                apostadores.add(apostador);
                dispose();
            }
        });

        JButton cancelButton = createButton("CANCELAR");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        nameLabel.setFont(loadFont("Res/Letra.ttf", 25));
        betAmountLabel.setFont(loadFont("Res/Letra.ttf", 25));
        horseLabel.setFont(loadFont("Res/Letra.ttf", 25));
        nameField.setFont(loadFont("Res/Letra.ttf", 25));
        betAmountField.setFont(loadFont("Res/Letra.ttf", 25));
        horseComboBox.setFont(loadFont("Res/Letra.ttf", 25));
        addButton.setFont(loadFont("Res/Letra.ttf", 20));
        cancelButton.setFont(loadFont("Res/Letra.ttf", 20));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(betAmountLabel);
        panel.add(betAmountField);
        panel.add(horseLabel);
        panel.add(horseComboBox);
        panel.add(addButton);
        panel.add(cancelButton);

        add(panel);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(227, 198, 168));
        button.setBorder(BorderFactory.createLineBorder(new Color(97, 153, 105), 5));


        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(97, 153, 105), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        button.setFocusPainted(false);



        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(97, 153, 105), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        button.setFocusPainted(false);


        return button;
    }
}