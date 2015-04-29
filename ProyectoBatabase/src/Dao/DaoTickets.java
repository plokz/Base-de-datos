package Dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Bean.ProductosAccesorios;
import Bean.Ticket;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class DaoTickets {
	
	public void crearTicket (ObjectContainer conexion){
		Ticket ticket =  new Ticket();
		System.out.print("ID ticket -> ");	
		ticket.setIdticket(numero());
		System.out.print("ID cliente -> ");
		ticket.setIdcliente(numero());
		ticket.setFecha(obtenerFecha());
		ArrayList<ProductosAccesorios> lista =  new ArrayList<ProductosAccesorios>();
		
		int opc = 0;
		double sumatotal = 0;
		DaoProductoAccesorios daoaccesorios = new DaoProductoAccesorios();
		do{
			System.out.println("1.-Agregar un Producto ");
			System.out.println("2.-Salir ");
			System.out.print("Elige una opcion -> ");
			opc = numero();
			switch (opc){
			case 1:				
				ProductosAccesorios p =  new ProductosAccesorios();
				lista.add(daoaccesorios.consultaEspecifica(conexion));
				break;
			case 2:
				System.out.print("Adios");
				break;
				default:
					System.out.print("Ninguna Opcion seleccionada");
			}			
		}while (opc!=2);				
		
		for (ProductosAccesorios p : lista){
			sumatotal += p.getCostoPublico();
		}
		ticket.setLista(lista);
		ticket.setTotal(sumatotal);
		conexion.store(ticket);
		System.err.println("Venta Realizada");
	}


	public void consultarTickets(ObjectContainer conexion) {
		// TODO Auto-generated method stub	
		System.out.println("Consultar Productos");
		ObjectSet coleccion = conexion.queryByExample(new Ticket());
		if(coleccion.isEmpty()){
			System.out.println("No existen Productos");
		}else{
			int num = 0;
			while(coleccion.hasNext()){
				Ticket ticket = (Ticket) coleccion.next();
				System.out.println("Ticket numero -> "+(num+1));
				System.out.print("Id Ticket : "+ticket.getIdticket());
				System.out.println("Fecha de registro :"+ticket.getFecha());
				System.out.println("ID Cliente :"+ticket.getIdcliente());
				ArrayList<ProductosAccesorios> lista = ticket.getLista();
				for ( ProductosAccesorios producto : lista) {					
                    System.out.println("Productos : ");
                    System.out.println("Nombre: " + producto.getNombre());
                    System.out.println("Descripcion: " + producto.getDescripcion());
                    System.out.println("Costo: " + producto.getCostoPublico());
				}
				System.out.println("Total ------- > :"+ticket.getTotal());
				num++;
			}
		}
	}

	public static ArrayList<Ticket> consultaEspecifica(ObjectContainer conexion){
		System.err.println("Busqueda de Tickets Clientes");
		System.out.println("ID cliente : ");
		Query consulta = conexion.query();
		consulta.constrain(Ticket.class);
		consulta.descend("idcliente").constrain(numero()).equal();
		ObjectSet resultado = consulta.execute();
		Ticket ticket = new Ticket();
		ArrayList<Ticket> listaTicket = new ArrayList<Ticket>(); 
		if(resultado.isEmpty()){
			System.out.println("No existen Tickest para este cliente");
		}else{
			while(resultado.hasNext()){
				listaTicket.add((Ticket) resultado.next());		
			}			
		}
		return listaTicket;
	}
	
	
	
	public static String obtenerFecha(){
		Calendar fecha = new GregorianCalendar();
        int a�o = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        System.out.println("Fecha Actual: "
                           + dia + "/" + (mes+1) + "/" + a�o);
        return dia+"/"+(mes+1)+"/"+a�o;
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
