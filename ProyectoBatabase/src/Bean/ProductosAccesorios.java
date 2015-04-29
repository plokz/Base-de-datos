package Bean;

import java.util.Date;

public class ProductosAccesorios {
	private int idproductoAccesorios;
	private String nombre ;
	private String descripcion;
	private Double costoPublico;
	private String  fechaResgistro;

	public ProductosAccesorios (){
		
	}
	public ProductosAccesorios (int numero){
		this.idproductoAccesorios = numero;
	}
	
	public int getIdproductoAccesorios() {
		return idproductoAccesorios;
	}
	public void setIdproductoAccesorios(int idproductoAccesorios) {
		this.idproductoAccesorios = idproductoAccesorios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getCostoPublico() {
		return costoPublico;
	}
	public void setCostoPublico(Double costoPublico) {
		this.costoPublico = costoPublico;
	}
	public String getFechaResgistro() {
		return fechaResgistro;
	}
	public void setFechaResgistro(String  fechaResgistro) {
		this.fechaResgistro = fechaResgistro;
	}
	
}
