package Bean;

import java.util.ArrayList;

import Dao.DaoProductoAccesorios;

public class Ticket {
	private double total;
	private int idcliente;
	private int idticket;
	private String fecha;
	private ArrayList<ProductosAccesorios> lista;
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getIdticket() {
		return idticket;
	}
	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public ArrayList<ProductosAccesorios> getLista() {
		return lista;
	}
	public void setLista(ArrayList<ProductosAccesorios> lista) {
		this.lista = lista;
	}
	
	
}
