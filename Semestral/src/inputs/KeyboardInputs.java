package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener{

    public void keyTyped(KeyEvent e) {
        // Handle key typed event here
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key pressed event here
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    	switch(e.getKeyCode()) {
    	
    	case KeyEvent.VK_UP:
    		System.out.println("Hola");
    		break;
    	case KeyEvent.VK_DOWN:
    		System.out.println("Ve");
    		break;
    	case KeyEvent.VK_RIGHT:
    		System.out.println("a ");
    		break;
    	case KeyEvent.VK_LEFT:
    		System.out.println("la Tienda ");
    		break;
    		
    }
}}
