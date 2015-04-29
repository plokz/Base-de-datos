package Dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Bean.Factura;
import Bean.ProductosAccesorios;
import Bean.Ticket;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DaoFacturas {
	

	public void crearFacturas (ObjectContainer conexion){
		Factura factura =  new Factura();
		System.out.print("ID Factura -> ");	
		factura.setIdFactura(numero());
		factura.setFecha(obtenerFecha());
		ArrayList<Ticket> lista =  new ArrayList<Ticket>();
		
		int opc = 0;
		DaoTickets daoaccesorios = new DaoTickets();
		do{
			System.out.println("1.-ID cliente ");
			System.out.println("2.-Salir ");
			System.out.print("Elige una opcion -> ");
			opc = numero();
			switch (opc){
			case 1:				
				Ticket p =  new Ticket();
				lista = daoaccesorios.consultaEspecifica(conexion);				
				break;
			case 2:
				System.out.print("Adios");
				break;
				default:
					System.out.print("Ninguna Opcion seleccionada");
			}			
		}while (opc!=2);	
		int cliente_id=0;
		for (Ticket tike: lista){
			cliente_id = tike.getIdcliente();
		}
		factura.setLista(lista);
		factura.setCliente(cliente_id);
		conexion.store(factura);
		System.err.println("Facturacion Realizada");
	}


	public void consultarFacturacion(ObjectContainer conexion) {
		// TODO Auto-generated method stub	
		System.out.println("Consultar Facturacion");
		ObjectSet coleccion = conexion.queryByExample(new Factura());
		if(coleccion.isEmpty()){
			System.out.println("No existen Facturas");
		}else{
			int num = 0;
			while(coleccion.hasNext()){
				Factura factura = (Factura) coleccion.next();
				System.out.println("Factura numero -> "+(num+1));
				System.out.print("Id Factura : "+factura.getIdFactura());
				System.out.println("Fecha de registro :"+factura.getFecha());
				ArrayList<Ticket> lista = factura.getLista();
				for ( Ticket ticket : lista) {					
                    System.out.println("Ticket : ");
                    System.out.println("Id Ticket: " + ticket.getIdticket());
                    System.out.println("Total : " + ticket.getTotal());
				}
				System.out.println("Id Cliente  ------- > :"+factura.getCliente());
				num++;
			}
		}
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
	
}
