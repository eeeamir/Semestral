package Logico;

import java.util.ArrayList;

public class ManejarApostador {
    private ArrayList<Apostador> apostadores;

    public ManejarApostador() {
        apostadores = new ArrayList<>();
    }

    public void agregarApostador(Apostador apostador) {
        apostadores.add(apostador);
    }

    public ArrayList<Apostador> getApostadores() {
        return apostadores;
    }
}