package Logico;

import java.util.ArrayList;

public class ManejarApostador {
	private static final int MAX_APOSTADORES = 100;
    private ArrayList<Apostador> listaDeApostadores;

    public ManejarApostador() {
        listaDeApostadores = new ArrayList<>();
    }

    public void agregarApostador(Apostador apostador) {
        if (listaDeApostadores.size() < MAX_APOSTADORES) {
            try {
                listaDeApostadores.add(apostador);
            } catch (IllegalArgumentException e) {
                System.out.println("Error al agregar nuevo apostador " + e.getMessage());
            }
        } else {
            System.out.println("No se puede agregar más apostadores. Límite alcanzado.");
        }
    }

   public ArrayList<String> obtenerApostadoresGanadores() {
        ArrayList<String> ApostadoresGanadores = new ArrayList<>();

        for (Apostador apostador : listaDeApostadores) {
            if (apostador.getEleccion() == CaballoGanador) { //crear caballo ganador en la otra clase
                ApostadorGanador.add(apostador.getNombre());
                Apostadorganador.add(apostador.getcalcularGanancia());// crear array list con los ganadores
            }
        }

        return obtenerApostadoresGanadores();
    }

}
