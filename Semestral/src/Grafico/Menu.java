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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Logico.Apostador;
import Logico.Caballo;
import Logico.ManejarApostador;

public class Menu extends JFrame {

    private ArrayList<Apostador> apostadores;
    private ArrayList<Caballo> caballos;
    private ManejarApostador manejarApostador;
    private Agregar agregarFrame;

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

    public Menu() {
        setTitle("Carreras ilegales");
        setSize(560, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        apostadores = new ArrayList<>();
        caballos = new ArrayList<>();
        manejarApostador = new ManejarApostador();

        caballos.add(new Caballo("Selfiri", 5, "10-6-1", "Negro", "Ikinho"));
        caballos.add(new Caballo("Pegaso", 3, "8-6-0", "Blanco", "Zeus"));
        caballos.add(new Caballo("Tiro al blanco", 4, "12-9-2", "Chocolate", "Woody"));
        caballos.add(new Caballo("Juan", 3, "12-1-2", "Salario Mínimo", "Juan"));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10));
        mainPanel.setBackground(new Color(172, 129, 100));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("CARRERA DE HILOS", SwingConstants.CENTER);
        titleLabel.setFont(loadFont("Res/Letra.ttf", 40));
        titleLabel.setForeground(Color.WHITE);
        mainPanel.add(titleLabel);

        JButton playButton = createButton("JUGAR");
        JButton addBettorsButton = createButton("ANADIR APOSTADORES");
        JButton viewBettorsButton = createButton("VER APOSTADORES");
        JButton possibleWinningsButton = createButton("POSIBLES GANANCIAS");
        JButton quitButton = createButton("CERRAR");

        playButton.setFont(loadFont("Res/Letra.ttf", 25));
        addBettorsButton.setFont(loadFont("Res/Letra.ttf", 25));
        viewBettorsButton.setFont(loadFont("Res/Letra.ttf", 25));
        possibleWinningsButton.setFont(loadFont("Res/Letra.ttf", 25));
        quitButton.setFont(loadFont("Res/Letra.ttf", 25));

        mainPanel.add(playButton);
        mainPanel.add(addBettorsButton);
        mainPanel.add(viewBettorsButton);
        mainPanel.add(possibleWinningsButton);
        mainPanel.add(quitButton);

        add(mainPanel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addBettorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (agregarFrame == null) {
                    agregarFrame = new Agregar(apostadores, caballos);
                }
                agregarFrame.setVisible(true);
            }
        });
        
            viewBettorsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Redirigir a la clase VerApuestas
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new VerApuestas(apostadores).setVisible(true);
                        }
                    });
                }
            });

        possibleWinningsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder("Posibles Ganancias:\n");
                for (Apostador apostador : apostadores) {
                    sb.append(apostador.getNombre()).append(", Ganancia: ").append(apostador.getcalcularGanancia()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
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

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}