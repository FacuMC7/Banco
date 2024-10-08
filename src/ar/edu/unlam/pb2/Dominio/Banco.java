package ar.edu.unlam.pb2.Dominio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.pb2.Entidades.Cliente;
import ar.edu.unlam.pb2.Entidades.Cuenta;

public class Banco {
	
	List<Cliente> clientes;
	
	public Banco() {
		this.clientes = new ArrayList<>();
	}

	public Boolean agregarCliente(Cliente clienteNuevo) {
		Boolean booleano = false;
		
		for(Cliente cliente : this.clientes) {
			if(cliente.getDni() == clienteNuevo.getDni()) {
				return booleano;
			}
		}
		booleano = true;
	    clientes.add(clienteNuevo);
		return booleano;
	}
	
	public List<Cliente> obtenerVips(){
		List<Cliente> clientesVip = new ArrayList<>();
		
		for(Cliente cliente : this.clientes) {
			if(cliente.esVip()) {
				clientesVip.add(cliente);
			}
		}
		
		return clientesVip;
	}
	
	
	
}
