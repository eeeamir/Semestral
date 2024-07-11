package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Grafico.Menu;

public class KeyboardInputs implements KeyListener {
    private Menu menu;

    public KeyboardInputs(Menu menu) {
        this.menu = menu;
    }


	@Override
    public void keyTyped(KeyEvent e) {
        // No implementado
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No implementado
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_P:
               
                break;
            case KeyEvent.VK_A:
                menu.addBettors();
                break;
            case KeyEvent.VK_V:
                menu.viewBettors();
                break;
            case KeyEvent.VK_W:
                menu.possibleWinnings();
                break;
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}