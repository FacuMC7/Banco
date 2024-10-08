package ar.edu.unlam.pb2.Entidades;

public abstract class Cuenta {
	
	double dinero;

	public Cuenta(double dinero) {
		super();
		this.dinero = dinero;
	}

	public abstract Boolean extraerDinero(double montoExtraido);

	public abstract void depositarDinero(double depositado);
	
	public double getDinero() {
		return this.dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	
	
}
