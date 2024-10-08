package ar.edu.unlam.pb2.Entidades;

public class Cuenta_Sueldo extends Cuenta {

	public Cuenta_Sueldo(double dinero) {
		super(dinero);
	}

	@Override
	public Boolean extraerDinero(double montoExtraido) {
		Boolean booleano = false;
		if(this.dinero >= montoExtraido) {
			booleano = true;
			this.dinero = this.dinero - montoExtraido;
		}
		return booleano;
	}

	@Override
	public void depositarDinero(double depositado) {
		this.dinero += depositado;
	}

	

	

}
