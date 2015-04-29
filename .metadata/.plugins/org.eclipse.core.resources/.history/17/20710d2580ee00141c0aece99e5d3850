package Dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import Bean.ProductosAccesorios;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class DaoProductoAccesorios implements Interfaces {

	@Override
	public void insertarProducto (ObjectContainer conexion){
		ProductosAccesorios producto =  new ProductosAccesorios();
		System.out.print("ID producto : ");	
		producto.setIdproductoAccesorios(numero());
		System.out.print("Nombre Producto : ");
		producto.setNombre(cadena());
		System.out.print("Descripcion producto : ");
		producto.setDescripcion(cadena());
		System.out.print("Costo : ");
		producto.setCostoPublico(decimal());
		producto.setFechaResgistro(obtenerFecha());
		conexion.store(producto);
		System.err.println("Producto Agregado Correctamente");
		System.out.println("\n\n");
	}

	@Override
	public void eliminarProducto (ObjectContainer conexion){
		System.err.println("Eliminar Producto");
		System.out.println("Ingrese el numero del producto a dar de baja: ");
		ObjectSet eliminar = conexion.queryByExample(new ProductosAccesorios(numero()));
		if(eliminar.isEmpty()){
			System.out.println("No existe el alumno verifique sus datos");
		}else{
			ProductosAccesorios producto = (ProductosAccesorios) eliminar.next();
			System.out.println(producto);
			System.out.println("Numero: "+producto.getIdproductoAccesorios());
			System.out.println("Nombre: "+producto.getNombre());
			conexion.delete(producto);
			System.err.println("Producto Eliminado");
		}
		System.out.println("\n\n");
	}

	@Override
	public void modificarProducto(ObjectContainer conexion) {
		// TODO Auto-generated method stub
		System.err.println("Modificar Producto ");
		System.out.println("Ingrese el numero del Producto:");
		ObjectSet modificar = conexion.queryByExample(new ProductosAccesorios(numero()));
		if(modificar.isEmpty()){
			System.out.println("Verifique sus datos");
		}else{
			ProductosAccesorios producto = (ProductosAccesorios) modificar.next();
			System.out.println(producto);
			System.out.println("Numero: "+producto.getNombre());
			System.out.println("Descripcion: "+producto.getDescripcion());
			System.out.println("Costo Publico : "+producto.getCostoPublico());
			System.out.println("Fecha Resgistro: "+producto.getFechaResgistro());
			
			System.out.println("Numero: ");
			producto.setIdproductoAccesorios(numero());
			System.out.println("Nombre: ");
			producto.setNombre(cadena());
			System.out.println("Descripcion: ");
			producto.setDescripcion(cadena());
			System.out.println("Costo : ");
			producto.setCostoPublico(decimal());
			System.out.println("Fecha : ");
			producto.setFechaResgistro(obtenerFecha());
			conexion.store(producto);
		}
		System.out.println("\n\n");
	}

	@Override
	public void consultarProducto(ObjectContainer conexion) {
		// TODO Auto-generated method stub	
		System.err.println("Consultar Productos");
		ObjectSet coleccion = conexion.queryByExample(new ProductosAccesorios());
		if(coleccion.isEmpty()){
			System.out.println("No existen Productos");
		}else{
			while(coleccion.hasNext()){
				ProductosAccesorios producto = (ProductosAccesorios) coleccion.next();

				System.out.println("Id: "+producto.getIdproductoAccesorios());
				System.out.println("Nombre: "+producto.getNombre());
				System.out.println("Descripcion : "+producto.getDescripcion());
				System.out.println("Costo Publico : "+producto.getCostoPublico());
				System.out.println("Fecha Resgistro : "+producto.getFechaResgistro());
			}
			System.out.println("\n\n");
		}
	}
	
	public static ProductosAccesorios consultaEspecifica(ObjectContainer conexion){
		System.err.println("Busqueda de Producto");
		System.out.println("Nombre : ");
		Query consulta = conexion.query();
		consulta.constrain(ProductosAccesorios.class);
		consulta.descend("nombre").constrain(cadena()).equal();
		ObjectSet resultado = consulta.execute();
		ProductosAccesorios producto = new ProductosAccesorios();
		if(resultado.isEmpty()){
			System.out.println("No existen Productos");
		}else{
			while(resultado.hasNext()){
				 producto = (ProductosAccesorios) resultado.next();				
			}			
		}
		return producto;
	}
	
	
	public static int numero(){
		Scanner lector =  new Scanner(System.in );		
		return  lector.nextInt();
	}
	
	public static String cadena(){
		Scanner lector =  new Scanner(System.in );		
		return  lector.nextLine();
	}
	
	public static Double decimal(){
		Scanner lector =  new Scanner(System.in );		
		return  lector.nextDouble();
	}
	public static String obtenerFecha(){
		Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        System.out.println("Fecha Actual: "
                           + dia + "/" + (mes+1) + "/" + año);
        return dia+"/"+(mes+1)+"/"+año;
	}

	

}
