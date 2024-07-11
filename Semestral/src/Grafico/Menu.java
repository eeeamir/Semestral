package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Menu extends JFrame {
    private ArrayList<String> apostadores;
    private Juego juego;

    public Menu() {
        setTitle("Carreras ilegales");
        setSize(560, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        apostadores = new ArrayList<>();
        juego = new Juego(apostadores);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10));
        mainPanel.setBackground(new Color(172, 129, 100));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("CARRERA DE HILOS", JLabel.CENTER);

        try {
            titleLabel.setFont(loadFont("Res/Letra.ttf", 40));
        } catch (FontLoadException e) {
            titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
            e.printStackTrace();
        }
        titleLabel.setForeground(Color.WHITE);
        mainPanel.add(titleLabel);

        JButton playButton = createButton("JUGAR");
        JButton addBettorsButton = createButton("anadir apostadores");
        JButton viewBettorsButton = createButton("ver apostadores");
        JButton possibleWinningsButton = createButton("posibles ganancias");
        JButton quitButton = createButton("CERRAR");

        try {
            playButton.setFont(loadFont("Res/Letra.ttf", 25));
            addBettorsButton.setFont(loadFont("Res/Letra.ttf", 25));
            viewBettorsButton.setFont(loadFont("Res/Letra.ttf", 25));
            possibleWinningsButton.setFont(loadFont("Res/Letra.ttf", 25));
            quitButton.setFont(loadFont("Res/Letra.ttf", 25));
        } catch (FontLoadException e) {
            Font defaultFont = new Font("Arial", Font.BOLD, 25);
            playButton.setFont(defaultFont);
            addBettorsButton.setFont(defaultFont);
            viewBettorsButton.setFont(defaultFont);
            possibleWinningsButton.setFont(defaultFont);
            quitButton.setFont(defaultFont);
            e.printStackTrace();
        }

        mainPanel.add(playButton);
        mainPanel.add(addBettorsButton);
        mainPanel.add(viewBettorsButton);
        mainPanel.add(possibleWinningsButton);
        mainPanel.add(quitButton);

        add(mainPanel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.playGame();
            }
        });

        addBettorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addBettors();
                } catch (InvalidBettorException ex) {
                    JOptionPane.showMessageDialog(Menu.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

