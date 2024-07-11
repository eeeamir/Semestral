package Grafico;

import javax.swing.*;
import java.util.ArrayList;

public class Juego {
    private ArrayList<String> apostadores;

    public Juego(ArrayList<String> apostadores) {
        this.apostadores = apostadores;
    }

    public void playGame() {
        if (apostadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bettors available. Please add bettors first.");
            return;
        }

        // Lógica para la carrera de hilos
        RaceThread horse1 = new RaceThread("Horse 1");
        RaceThread horse2 = new RaceThread("Horse 2");

        horse1.start();
        horse2.start();

        try {
            horse1.join();
            horse2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String winner = horse1.getPosition() > horse2.getPosition() ? horse1.getName() : horse2.getName();
        JOptionPane.showMessageDialog(null, "The winner is " + winner);
    }

    private class RaceThread extends Thread {
        private int position = 0;

        public RaceThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                position += (int) (Math.random() * 10);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public int getPosition() {
            return position;
        }
    }
}