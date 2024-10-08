package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.pb2.Dominio.Banco;
import ar.edu.unlam.pb2.Entidades.Caja_De_Ahorro;
import ar.edu.unlam.pb2.Entidades.Cliente;
import ar.edu.unlam.pb2.Entidades.Cuenta;
import ar.edu.unlam.pb2.Entidades.Cuenta_Corriente;
import ar.edu.unlam.pb2.Entidades.Cuenta_Sueldo;

public class TestBanco {

	/*
	 * 1- CREAR TEST
	 * 
	 * 2- CREAR CLASES
	 * 
	 * 3- CREAR METODOS
	 * */
	
	@Test
	public void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		
		Banco banco = new Banco();
		double saldo = 2000;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta cuenta = new Cuenta_Sueldo(saldo);
		
		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double montoExtraido = 1000;
		
		Boolean extraerDinero = cuenta.extraerDinero(montoExtraido);
		
		assertTrue(extraerDinero);
		
	}
	
	@Test
	public void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		
		Banco banco = new Banco();
		
		double saldo = 2000;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta cuenta = new Cuenta_Sueldo(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double montoExtraido = 2500;
		
		Boolean extraerDinero = cuenta.extraerDinero(montoExtraido);
		
		assertFalse(extraerDinero);
	}
	
	@Test
	public void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {
		
        Banco banco = new Banco();
		
		double saldo = 5000;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta cuenta = new Caja_De_Ahorro(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double montoExtraido = 1000;
		
		cuenta.extraerDinero(montoExtraido);
	    cuenta.extraerDinero(montoExtraido);
	    cuenta.extraerDinero(montoExtraido);
	    cuenta.extraerDinero(montoExtraido);
	    cuenta.extraerDinero(montoExtraido);
	   
	    
	    Double montoEsperado = 0.0;
	    
	    Double montoFinal = cuenta.getDinero();
	    
	    assertEquals(montoEsperado, montoFinal);
		
	}
	
	
	@Test
	public void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900() {
		
		 Banco banco = new Banco();
			
			double saldo = 10000;
			
			int dni = 45128263;
			String nombre = "Facundo";
			String apellido = "Cisneros";

			Cliente cliente = new Cliente(dni, nombre, apellido);
			Cuenta cuenta = new Caja_De_Ahorro(saldo);

			banco.agregarCliente(cliente);
			cliente.agregarCuenta(cuenta);

			double montoExtraido = 1000;
			
			cuenta.extraerDinero(montoExtraido);
		    cuenta.extraerDinero(montoExtraido);
		    cuenta.extraerDinero(montoExtraido);
		    cuenta.extraerDinero(montoExtraido);
		    cuenta.extraerDinero(montoExtraido);
		    cuenta.extraerDinero(montoExtraido);
		   
		    
		    Double montoEsperado = 3900.0;
		    
		    Double montoFinal = cuenta.getDinero();
		    
		    assertEquals(montoEsperado, montoFinal);
		
	}
	
	@Test
	public void queAlDepositar1000EnUnaCuentaCorrienteConSaldoIgualACeroSuSaldoFinalSea1000() {
		Banco banco = new Banco();
		
		double saldo = 0;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta cuenta = new Cuenta_Corriente(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double depositado = 1000;
		
		cuenta.depositarDinero(depositado);
	    
	    Double montoEsperado = 1000.0;
	    
	    Double montoFinal = cuenta.getDinero();
	    
	    assertEquals(montoEsperado, montoFinal);
	}
	
	@Test
	public void queSeCobre5PorCientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldoEnUnaCuentaCorriente() {
        
		Banco banco = new Banco();
		
		double saldo = 0;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta cuenta = new Cuenta_Corriente(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double extraido = 200;
		double depositado = 100;
		double depositado2 = 200;
		
		cuenta.depositarDinero(depositado);
		cuenta.extraerDinero(extraido);
		cuenta.depositarDinero(depositado2);
	    
	    Double montoEsperado = 95.0;
	    
	    Double montoFinal = cuenta.getDinero();
	    
	    assertEquals(montoEsperado, montoFinal);
	}
	
	@Test
	public void queSeCobreElCincoPorCientoDeComisionPorMasQueElProximoDepositoNoSeaSuficienteParaCubrirElDescubiertoEnUnaCuentaCorriente() {
        
		Banco banco = new Banco();
		
		double saldo = 0;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta_Corriente cuenta = new Cuenta_Corriente(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double depositado = 100;
		double extraido = 200;
		double depositado2 = 100;
		
		cuenta.depositarDinero(depositado);
		cuenta.extraerDinero(extraido);
		cuenta.depositarDinero(depositado2);
	    
	    Double montoEsperado = 5.0;
	    
	    Double montoFinal = cuenta.getDescubierto_actual();
	    
	    assertEquals(montoEsperado, montoFinal);
	}
	
	
	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() {
		
        Banco banco = new Banco();
		
		double saldo = 0;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta_Corriente cuenta = new Cuenta_Corriente(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double depositado = 100;
		double extraido = 200;
		double extraido2 = 50;
		
		cuenta.depositarDinero(depositado);
		
		cuenta.extraerDinero(extraido);
		
		Double deudaUno = cuenta.getDeuda();
		//System.out.println(cuenta.getDeuda());
		
		cuenta.extraerDinero(extraido2);
	    	  
		Double deudaDos = cuenta.getDeuda();
		//System.out.println(cuenta.getDeuda());

		Boolean esMayor = false;
		
		if(deudaDos > deudaUno) {
			esMayor = true;
		}else {
			esMayor = false;
		}
		
		assertTrue(esMayor);
	 		
	}
	
	@Test
	public void queVariasOperacionesDeDepositoYExtraccionGenerenElSaldoYLaDeudaCorrecto() {
		
        Banco banco = new Banco();
		
		double saldo = 0;
		
		int dni = 45128263;
		String nombre = "Facundo";
		String apellido = "Cisneros";

		Cliente cliente = new Cliente(dni, nombre, apellido);
		Cuenta_Corriente cuenta = new Cuenta_Corriente(saldo);

		banco.agregarCliente(cliente);
		cliente.agregarCuenta(cuenta);

		double depositado = 100;
		double extraido = 200;
		double extraido2 = 50;
		double depositado2 = 50;
		double extraido3 = 40;
		double depositado3 = 140;
		
		cuenta.depositarDinero(depositado);
		System.out.println(cuenta.getDescubierto_actual());
		System.out.println(cuenta.getDeuda());
		System.out.println(cuenta.getDinero());
		
		
		System.out.println("---");
		
		cuenta.extraerDinero(extraido);
		System.out.println(cuenta.getDescubierto_actual());
		System.out.println(cuenta.getDeuda());
		System.out.println(cuenta.getDinero());

		System.out.println("---");
		
		cuenta.extraerDinero(extraido2);
		System.out.println(cuenta.getDescubierto_actual());
		System.out.println(cuenta.getDeuda());
		System.out.println(cuenta.getDinero());
		
		System.out.println("---");

		cuenta.depositarDinero(depositado2);
		System.out.println(cuenta.getDescubierto_actual());
		System.out.println(cuenta.getDeuda());
		System.out.println(cuenta.getDinero());
		
		System.out.println("---");
		
		cuenta.extraerDinero(extraido3);
		System.out.println(cuenta.getDescubierto_actual());
		System.out.println(cuenta.getDeuda());
		System.out.println(cuenta.getDinero());
		
		System.out.println("---");
		
		cuenta.depositarDinero(depositado3);
		System.out.println(cuenta.getDescubierto_actual());
		System.out.println(cuenta.getDeuda());
		System.out.println(cuenta.getDinero());
		
		Double saldoEsperado = 0.0;
		Double saldoFinal = cuenta.getDinero();
		Double deudaEsperada = 0.0;
		Double deudaFinal = cuenta.getDeuda();
		Double descubiertoEsperado = 9.5;
		Double descubiertoFinal = cuenta.getDescubierto_actual();
		
		assertEquals(saldoEsperado, saldoFinal);
		assertEquals(deudaEsperada, deudaFinal);
		assertEquals(descubiertoEsperado, descubiertoFinal);
		
	}
	
	
	@Test
	public void queSeObtengaDeManeraCorrectaElListadoDeClientesVip() {
		
		 Banco banco = new Banco();
			
			double saldo = 100000;
			double saldo2 = 900000;
			double saldo3 = 250000;
			
			int dni = 45128263;
			String nombre = "Facundo";
			String apellido = "Cisneros";
			
			int dni2 = 45128262;
			String nombre2 = "Pedro";
			String apellido2 = "Cisneros";
			
			int dni3 = 45128261;
			String nombre3 = "Juan";
			String apellido3 = "Cisneros";

			Cliente cliente = new Cliente(dni, nombre, apellido);
			Cliente cliente2 = new Cliente(dni2, nombre2, apellido2);
			Cliente cliente3 = new Cliente(dni3, nombre3, apellido3);
			
			Cuenta cuenta = new Cuenta_Corriente(saldo);
			Cuenta cuenta2 = new Cuenta_Sueldo(saldo2);
			
			Cuenta cuenta3 = new Cuenta_Corriente(saldo2);
			Cuenta cuenta4 = new Cuenta_Sueldo(saldo2);
			
			Cuenta cuenta5 = new Cuenta_Corriente(saldo3);
			Cuenta cuenta6 = new Cuenta_Sueldo(saldo);  

			banco.agregarCliente(cliente);
			banco.agregarCliente(cliente2);
			banco.agregarCliente(cliente3);
			
			cliente.agregarCuenta(cuenta);
			cliente.agregarCuenta(cuenta2); //En total el cliente 1 debe tener 1.000.000
			
			cliente2.agregarCuenta(cuenta3);
			cliente2.agregarCuenta(cuenta4); //En total el cliente 2 debe tener 1.800.000
			
			cliente3.agregarCuenta(cuenta5);
			cliente3.agregarCuenta(cuenta6); //En total el cliente 3 debe tener 350.000
			
			int numeroDeClientesVipEsperados = 2;
			
			int numeroDeClientesVip = banco.obtenerVips().size();
			
			assertEquals(numeroDeClientesVipEsperados, numeroDeClientesVip);

		
	}
	
	
	
	
}
