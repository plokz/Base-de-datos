package Bean;

import java.util.ArrayList;

public class Factura {
	private int idFactura ;
	private int Cliente;
	private String fecha ;
	private ArrayList<Ticket> lista;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public int getCliente() {
		return Cliente;
	}
	public void setCliente(int cliente) {
		Cliente = cliente;
	}
	public ArrayList<Ticket> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Ticket> lista) {
		this.lista = lista;
	}
	
	
	
}
