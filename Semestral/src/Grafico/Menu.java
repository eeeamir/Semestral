package Grafico;



import Grafico.Juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Menu extends JFrame {
    private ArrayList<String> apostadores;
    private Juego juego;
 
    
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

        
    }
    
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(227, 198, 168));
        button.setBorder(BorderFactory.createLineBorder(new Color(97, 153, 105), 5));
        
        int arcSize = 15; 
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(97, 153, 105), 2), 
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); 
        button.setFocusPainted(false); 
        
        return button;
    }

  public void addBettors() throws InvalidBettorException {
        String name = JOptionPane.showInputDialog(this, "Enter bettor's name:");
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidBettorException("Error el parametro no puede estar en blanco.");
        }
        apostadores.add(name.trim());
        JOptionPane.showMessageDialog(this, "Bettor added.");
    }

    public void viewBettors() {
        StringBuilder bettorList = new StringBuilder("Bettors:\n");
        for (String bettor : apostadores) {
            bettorList.append(bettor).append("\n");
        }
        JOptionPane.showMessageDialog(this, bettorList.toString());
    }

    public void possibleWinnings() {
        
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
