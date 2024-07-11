package Logico;

public class Apostador {
    private String nombre;
    private double apuesta;
    private String caballo;

    public Apostador(String nombre, double apuesta, String caballo) {
        this.nombre = nombre;
        this.apuesta = apuesta;
        this.caballo = caballo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getApuesta() {
        return apuesta;
    }

    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }

    public String getCaballo() {
        return caballo;
    }

    public void setCaballo(String caballo) {
        this.caballo = caballo;
    }

    public double getcalcularGanancia() {
        return apuesta * 2; 
    }
}
