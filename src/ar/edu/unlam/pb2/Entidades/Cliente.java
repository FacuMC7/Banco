package ar.edu.unlam.pb2.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	int dni;
	String nombre;
	String apellido;
	List<Cuenta> cuentas;
	
	public Cliente(int dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuentas = new ArrayList<>();
		
	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		Boolean booleano = false;
		if(cuentas.size() < 3) {
			cuentas.add(cuenta);
			booleano = true;
		}
		
		return booleano;
		
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public Boolean esVip() {
		Boolean booleano = false;
		double saldoTotal = 0;
		double montoParaVip = 1000000;
		
		for(Cuenta cuenta : this.cuentas) {
			saldoTotal += cuenta.getDinero();
		}
		if(saldoTotal >= montoParaVip) {
			booleano = true;
		}
		return booleano;
	}
	
	

}
