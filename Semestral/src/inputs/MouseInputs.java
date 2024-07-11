package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked!");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // No implementado
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // No implementado
    }
}