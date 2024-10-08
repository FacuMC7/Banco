package ar.edu.unlam.pb2.Entidades;

public class Cuenta_Corriente extends Cuenta {

	private static final double COMISION = 0.05;
	
	private static final double DESCUBIERTO_MAXIMO = 150;

	private double descubierto_actual;
	
	private boolean tieneDeuda;
	
	private double deuda;
	
	public Cuenta_Corriente(double dinero) {
		super(dinero);
	}

	@Override
	public Boolean extraerDinero(double montoExtraido) {
		Boolean booleano = false;
		
		if(this.dinero >= montoExtraido) {
			this.dinero -= montoExtraido;
			booleano = true;
		} else if(this.dinero + DESCUBIERTO_MAXIMO >= montoExtraido) {
			this.descubierto_actual += montoExtraido - this.dinero;
			this.tieneDeuda = true;
			this.deuda += (montoExtraido - this.dinero) * COMISION; 
			this.dinero = 0; 
			booleano = true;
		}
		
		return booleano;
	}

	@Override
	public void depositarDinero(double depositado) {
		
		double restante = depositado;
		
		if(tieneDeuda) {

			if(restante > descubierto_actual) {
				restante -= descubierto_actual;
				restante = restante - deuda;
				this.descubierto_actual = 0;
				this.deuda = 0;
			}else {
				this.descubierto_actual -= restante - deuda;
				restante = 0;
				this.deuda = 0;
			}
			
		}
		
		this.dinero += restante;
	
	}

	public double getDescubierto_actual() {
		return descubierto_actual;
	}

	public void setDescubierto_actual(double descubierto_actual) {
		this.descubierto_actual = descubierto_actual;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	
	
	
	

}
