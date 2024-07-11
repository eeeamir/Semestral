package Grafico;

import Logico.Apostador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerApuestas extends JFrame {

    private ArrayList<Apostador> apostadores;
    private JTextArea apostadoresTextArea;

    public VerApuestas(ArrayList<Apostador> apostadores) {
        this.apostadores = apostadores;

        setTitle("Ver Apostadores");
        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));
        panel.setBackground(new Color(172, 129, 100));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Apostadores Registrados", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        apostadoresTextArea = new JTextArea();
        apostadoresTextArea.setEditable(false);
        apostadoresTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        apostadoresTextArea.setBackground(new Color(227, 198, 168));
        apostadoresTextArea.setBorder(BorderFactory.createLineBorder(new Color(97, 153, 105), 5));

        JScrollPane scrollPane = new JScrollPane(apostadoresTextArea);
        scrollPane.setPreferredSize(new Dimension(380, 300));
        panel.add(scrollPane);

        JButton closeButton = new JButton("CERRAR");
        closeButton.setFont(new Font("Arial", Font.BOLD, 20));
        closeButton.setBackground(new Color(227, 198, 168));
        closeButton.setBorder(BorderFactory.createLineBorder(new Color(97, 153, 105), 5));
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(closeButton);

        add(panel);

        updateApostadoresText();
    }

    public void updateApostadoresText() {
        StringBuilder sb = new StringBuilder();
        for (Apostador apostador : apostadores) {
            sb.append(apostador.getNombre()).append(", Apuesta: ").append(apostador.getApuesta()).append("\n");
        }
        apostadoresTextArea.setText(sb.toString());
    }
}