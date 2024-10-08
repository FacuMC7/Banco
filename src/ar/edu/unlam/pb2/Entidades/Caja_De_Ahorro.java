package ar.edu.unlam.pb2.Entidades;

public class Caja_De_Ahorro extends Cuenta {

	private int contadorExtracciones = 0;
	
	private final static int CANTIDAD_EXTRACCIONES_SIN_COSTO = 5;
	
	private final static double COSTO_ADICIONAL = 100.00;

	public Caja_De_Ahorro(double dinero) {
		super(dinero);
	}

	@Override
	public Boolean extraerDinero(double montoExtraido) {
		Boolean booleano = false;
		if(this.dinero >= montoExtraido) {
			if(contadorExtracciones < CANTIDAD_EXTRACCIONES_SIN_COSTO) {
				this.dinero -= montoExtraido;
				this.contadorExtracciones++;
				booleano = true;
			}else {
			if(this.dinero >= montoExtraido + COSTO_ADICIONAL) {
				this.dinero -= montoExtraido + COSTO_ADICIONAL;
				contadorExtracciones ++;
				booleano = true;
			}
			}
		}
		return booleano;
	}

	@Override
	public void depositarDinero(double depositado) {
		this.dinero += depositado;
	}
	

	
	
	

}
