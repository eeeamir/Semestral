package Logico;

public class Apostador {
	private String nombre;
    private double apuesta;
    private double cuota; 
    private int eleccion;

    public Apostador(String nombre, double apuesta, double cuota, int eleccion) {
        if (apuesta < 0.0 ) {
            throw new IllegalArgumentException("El importe minímo de apuesta es 0.01");
        }
        this.nombre = nombre;
        this.apuesta = apuesta;
        this.cuota = cuota;
        this.eleccion = eleccion;
    }

    
    public int getEleccion() {
		return eleccion;
	}


	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}


	public void setCuota(double cuota) {
		this.cuota = cuota;
	}


	public String getNombre() {
        return nombre;
    }

    public double getApuesta() {
        return apuesta;
    }

    public double getCuota() {
        return cuota;
    }

    public double getcalcularGanancia() {
        return apuesta * cuota;
    }
}
