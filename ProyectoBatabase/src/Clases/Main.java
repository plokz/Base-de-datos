package Clases;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import Bean.ProductosAccesorios;
import Dao.DaoFacturas;
import Dao.DaoProductoAccesorios;
import Dao.DaoTickets;
import Dao.Interfaces;

public class Main   {
	
	public static void main (String args []){
		ObjectContainer conexion = Db4oEmbedded.openFile("PROYECTO.DB4O");
		Scanner lector = new Scanner(System.in);		
		int opcion = 0;
		try {
			while (opcion != 5){
				System.out.println("1.- Productos ");
				System.out.println("2.- Compra ");
				System.out.println("3.- Facturar");
				System.out.println("5.-Regresar ");
				System.out.print("Elija Una opcion -> ");
				opcion = lector.nextInt();
				switch (opcion){
				case 1:
					int opc=0;
					while (opc!= 5){
						System.out.println("\n\n");
						System.out.println("1.-Agregar Producto");
						System.out.println("2.-Eliminar Producto");
						System.out.println("3.-Modificar Producto");
						System.out.println("4.-Consultar Producto");
						System.out.println("5.-Regresar");
						System.out.print("Elija Una opcion -> ");
						opc = lector.nextInt();
						switch(opc){
						case 1:
							DaoProductoAccesorios producto =  new DaoProductoAccesorios();
							producto.insertarProducto(conexion);
							break;
						case 2:
							producto =  new DaoProductoAccesorios();
							producto.eliminarProducto(conexion);
							break;
						case 3:
							producto =  new DaoProductoAccesorios();
							producto.modificarProducto(conexion);
							break;
						case 4:
							producto =  new DaoProductoAccesorios();
							producto.consultarProducto(conexion);
							break;
						case 5:
							System.out.println("Adios");
							default :
								System.out.println("No ah elegido ninguna opcion");		
								break;
						}
					}			
					break;
				case 2:					
					System.out.println("\n\n");
					System.out.println("1.-Realizar Compra");
					System.out.println("2.-Consulta Tickets");
					System.out.println("Elija una opcion -> ");
					opc = lector.nextInt();
					switch (opc){
					case 1:
						DaoTickets daoticket = new DaoTickets();
						daoticket.crearTicket(conexion);
						break;
					case 2:
					    daoticket = new DaoTickets();
						daoticket.consultarTickets(conexion);
						break;
						default :
							System.out.println("No ah elegido ninguna opcion");
							break;
					}
					break;
					
				case 3:
					System.out.println("\n\n");
					System.out.println("1.- Facturar ");
					System.out.println("2.- Imprimir Facturas");
					opc = lector.nextInt();
					switch (opc){
					case 1:
						DaoFacturas daofactura = new DaoFacturas();
						daofactura.crearFacturas(conexion);
						break;
					case 2:
						daofactura = new DaoFacturas();
						daofactura.consultarFacturacion(conexion);
						break;
						default :
							System.out.println("No ah elegido ninguna opcion");
							break;
					}	
					break;
				case 4:
					default:
						break;
				}
			}		
		}finally {
			conexion.close();
		}
		
	 }	
}
