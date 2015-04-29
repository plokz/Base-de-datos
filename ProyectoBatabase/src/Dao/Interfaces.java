package Dao;

import com.db4o.ObjectContainer;

public interface Interfaces {	
	public void insertarProducto (ObjectContainer conexion);
	public void eliminarProducto (ObjectContainer conexion);
	public void modificarProducto (ObjectContainer conexion);
	public void consultarProducto (ObjectContainer conexion);
	
}
