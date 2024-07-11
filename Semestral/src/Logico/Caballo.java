package Logico;

import java.util.ArrayList;

public class Caballo {
    private String nombre;
    private int edad;
    private String historial;
    private String color;
    private String jockey;

   
    public Caballo(String nombre, int edad, String historial,String color, String jockey) {
        this.nombre = nombre;
        this.edad = edad;
        this.historial = historial;
        this.color = color;
        this.jockey = jockey;
    }

    
    public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }
    
    public static void main(String[] args) {
        ArrayList<Caballo> caballos = new ArrayList<>();
        
        caballos.add(new Caballo("Selfiri", 5, "10-6-1","Negro", "Ikinho"));
        caballos.add(new Caballo("Pegaso", 3, "8-6-0","Blanco", "Zeus"));
        caballos.add(new Caballo("Tiro al blanco", 4, "12-9-2","Chocolate", "Woody"));
        caballos.add(new Caballo("Juan", 3, "12-1-2","Salario Mínimo", "Juan"));

        for (Caballo caballo : caballos) {
            System.out.println("Nombre: " + caballo.getNombre());
            System.out.println("Edad: " + caballo.getEdad());
            System.out.println("Historial: " + caballo.getHistorial());
            System.out.println("Jockey: " + caballo.getJockey());
            System.out.println();
        }
    }
}

