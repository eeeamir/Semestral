package Grafico;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import Grafico.Juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {
    private ArrayList<String> apostadores;
    private Juego juego;
    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;

    public Menu() {
        setTitle("Carreras ilegales");
        setSize(560, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        apostadores = new ArrayList<>();
        juego = new Juego(apostadores);

        
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs();

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBackground(new Color(172, 129, 100));
        
        
        JButton playButton = createButton("Play");
        JButton addBettorsButton = createButton("Add Bettors");
        JButton viewBettorsButton = createButton("View Bettors");
        JButton possibleWinningsButton = createButton("Possible Winnings");
        JButton quitButton = createButton("Quit");

        // Agregar los botones al panel principal
        mainPanel.add(playButton);
        mainPanel.add(addBettorsButton);
        mainPanel.add(viewBettorsButton);
        mainPanel.add(possibleWinningsButton);
        mainPanel.add(quitButton);

        // Agregar el panel principal al frame
        add(mainPanel);

        // Acciones de los botones
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.playGame();
            }
        });

        addBettorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBettors();
            }
        });

        viewBettorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBettors();
            }
        });

        possibleWinningsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                possibleWinnings();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar los listeners de teclado y ratón
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(227, 198, 168));
        button.setBorder(BorderFactory.createLineBorder(new Color(97, 153, 105), 5));
        return button;
    }

    public void addBettors() {
        String name = JOptionPane.showInputDialog(this, "Enter bettor's name:");
        if (name != null && !name.trim().isEmpty()) {
            apostadores.add(name.trim());
            JOptionPane.showMessageDialog(this, "Bettor added.");
        }
    }

    public void viewBettors() {
        StringBuilder bettorList = new StringBuilder("Bettors:\n");
        for (String bettor : apostadores) {
            bettorList.append(bettor).append("\n");
        }
        JOptionPane.showMessageDialog(this, bettorList.toString());
    }

    public void possibleWinnings() {
        // Lógica para calcular posibles ganancias
        JOptionPane.showMessageDialog(this, "Possible winnings feature coming soon.");
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