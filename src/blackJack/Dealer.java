package blackJack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dealer {
	
//atributos
	String name;
//baraja
	static ArrayList<Integer> baraja = new ArrayList<Integer>();
//manoJugador
	static ArrayList<Integer> mano = new ArrayList<Integer>();
//manoDealer
	static ArrayList<Integer> manoDealer = new ArrayList<Integer>();
//sum mano
	static int totalManoD ;
//sum mano dealer
	static int totalManoJ;

	
//constructor
	Dealer(String name) {
		this.name=name;
		ArrayList<Integer> baraja = new ArrayList<Integer>();
		ArrayList<Integer> mano = new ArrayList<Integer>();
		ArrayList<Integer> manoDealer = new ArrayList<Integer>();
		int totalManoD ;
		int totalManoJ;
		
	}
	
//metodos
	void baraja() {
		//crear baraja
	  //1 al 10 cuatro veces
		for(int k=0;k<4;k++) {
			  for (int i=1; i<=10; i++) {
			    	baraja.add(i);
			    }
		}
	    
		//integramos a la baraja los 12 cartas con valor 10 (J,Q,k)
		  for (int d=1; d<=12; d++) {
		    	baraja.add(10);
		    }
		  /*resultado: Baraja ordenada [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
		  								1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
		  								1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
		  								1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
		  								10, 10, 10, 10, 10, 10, 10, 10, 
		  								10, 10, 10, 10] */ 
		  
	}
	
//metodo para mezclar la baraja
	void mezclar() {
		System.out.println("Baraja ordenada " +baraja);//llamar a la baraja ordenada
		Collections.shuffle(baraja);//mezclar
		System.out.println("Baraja Mezclada " + baraja);//llamar a la baraja mezclada
		
	}
	
//metodo repartir cartas al jugador
	static void deal2Cartas() {
		for(int i=1; i < 3; i++) {
			int remove=baraja.remove(baraja.size()-1);//remover 2 veces el ultimo item de la baraja
			mano.add(remove);//agragar los elementos removidos a la mano del jugador	
		} 
		System.out.println("JUGADOR: Tienes: " + mano);//mostrar mano
		totalManoJ= mano.get(0) + mano.get(1);//sumar cartas SE PUEDE HACER CICLO PARA SUMAR DE MEJOR MANERA/////////
		System.out.println("JUGADOR: Un total de: " + totalManoJ);//mostrar mano sumada 
	}
	
//metodo repartir cartas al jugador
	static void deal2CartasAlDealer() {//repartir cartas al dealer
		for(int i=1; i < 3; i++) {
			int remove=baraja.remove(baraja.size()-1);//remover 2 veces el ultimo item de la baraja
			manoDealer.add(remove);//agragar los elementos removidos a la mano del jugador
		}
		System.out.println("DEALER: Tienes: " + manoDealer);//mostrar mano
		totalManoD= manoDealer.get(0) + manoDealer.get(1);//sumar cartas   SE PUEDE HACER CICLO PARA SUMAR DE MEJOR MANERA/////////
		System.out.println("DEALER: Un total de: " + totalManoD);//mostrar mano sumada 
	}
	
//Metodo: pedir carta o mantenerse
// el jugador pida cartas hasta que ya no desee, luego el dealer pide cartas hasta que ya no desee
//o pierda, el que mas cerca llega a 21 con menos cartas gana.
	
	void pedirCarta() {
		
		String respuesta;
		Scanner sc = new Scanner(System.in);
		System.out.println("JUGADOR DESEAS MAS CARTAS? 1=SI/2=NO");
		respuesta = sc.next();
		respuesta.toUpperCase();
		
		switch(Integer.parseInt(respuesta))
		{
		   
		   case 1 :
		     System.out.println("SI");
		     System.out.println(baraja);
		     int remove=baraja.remove(baraja.size()-1);
		     mano.add(remove);
		     System.out.println(mano);
		     //sumar 3era y 4tacarta.. carta// CAMBIAR ARRAYLIST POR ARREGLO
		      break; 
		   
		   case 2 :
			   System.out.println("NO");
			   System.out.println("JUGADOR no pidio cartas");
		      break;   
		}
	}
	
// funcion con switch para tomar mas cartas
	void pedirCartaDealer() {
			
			String respuesta;
			Scanner sc = new Scanner(System.in);
			System.out.println("DEALER DESEAS MAS CARTAS? 1=SI/2=NO");
			respuesta = sc.next();
			respuesta.toUpperCase();
			
			switch(Integer.parseInt(respuesta))
			{
			   
			   case 1 :
				   
			     System.out.println("SI");
			     System.out.println(baraja);
			     int remove=baraja.remove(baraja.size()-1);
			     manoDealer.add(remove);
			     System.out.println(manoDealer);
			   //sumar 3era carta// CAMBIAR ARRAYLIST POR ARREGLO//
			      break; 
			   
			   case 2 :
				   System.out.println("NO");
				   System.out.println("DEALER no pidio cartas");
			      break; 	   
			}
	}
	
//metodo para ver la baraja restante, y las manos
	void mostrarCartas() {
		System.out.println("Baraja: " +baraja);
		System.out.println("JUGADOR: " +totalManoJ);
		System.out.println("DEALER: " +totalManoD);
	}
	
// metodo para comprar valores y ver quien gana
	void quienGana() {
		
		
		if(totalManoJ>=22) {
			System.out.println("JUGADOR Perdio: SE PASO DE 21 :(");
			System.out.println("Gana Dealer");
		}
		if(totalManoD>=22 ) {
			System.out.println("Dealer Perdio: SE PASO DE 21 :(");
			System.out.println("Gana Jugador");
		}
		else if(totalManoJ>totalManoD && totalManoJ<=21 ) {
			System.out.println("Gana Jugador");

		}
		else if(totalManoJ<totalManoD && totalManoD<=21) {
			System.out.println("Gana Dealer");

		}
		
		else if(totalManoJ==totalManoD){
			System.out.println("Empate");
		}

	}
	
}


