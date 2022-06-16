package blackJack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.awt.Toolkit;

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

		//this.name=name;
		//ArrayList<Integer> baraja = new ArrayList<Integer>();
		//ArrayList<Integer> mano = new ArrayList<Integer>();
		//ArrayList<Integer> manoDealer = new ArrayList<Integer>();
		//int totalManoD ;
		//int totalManoJ;
		
	}
	
//Metodos//
	
	void newGame() {
		baraja();
		mezclar();
		deal2Cartas();
		deal2CartasAlDealer();
		mostrarCartas();
		pedirCarta();
		pedirCartaDealer();
		quienGana();
	}
	
	
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
		System.out.println("============================================================================================================================================");
		System.out.println("Baraja ordenada " +baraja);//llamar a la baraja ordenada
		System.out.println("============================================================================================================================================");
		Collections.shuffle(baraja);//mezclar
		Collections.shuffle(baraja);//mezclar
		System.out.println("Baraja Mezclada " + baraja);//llamar a la baraja mezclada
		System.out.println("============================================================================================================================================");
	}
	
//metodo repartir cartas al jugador
	static void deal2Cartas() {
		for(int i=1; i < 3; i++) {
			int remove=baraja.remove(baraja.size()-1);//remover 2 veces el ultimo item de la baraja
			mano.add(remove);//agragar los elementos removidos a la mano del jugador	
		} 
		
		sumarJ();
		System.out.println("--------JUGADOR--------");
	}
	
//metodo repartir cartas al jugador
	static void deal2CartasAlDealer() {//repartir cartas al dealer
		for(int i=1; i < 3; i++) {
			int remove=baraja.remove(baraja.size()-1);//remover 2 veces el ultimo item de la baraja
			manoDealer.add(remove);//agragar los elementos removidos a la mano del jugador
		}
	
		
		sumarD();
		System.out.println("--------DEALER------");

	}
	
//Metodo: pedir carta o mantenerse
// el jugador pida cartas hasta que ya no desee, luego el dealer pide cartas hasta que ya no desee
//o pierda, el que mas cerca llega a 21 con menos cartas gana.	
	void pedirCarta() {
		
		
		String respuesta;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("***JUGADOR DESEAS MAS CARTAS? 1=SI/2=NO");
		respuesta = sc.next();
		respuesta.toUpperCase();
		
	
		switch(Integer.parseInt(respuesta))
		{
		   
		   case 1 :
		     System.out.println("SI");
		     int remove=baraja.remove(baraja.size()-1);
		     mano.add(remove);
		     System.out.println("Baraja " +baraja);
		     sumarJ();
		     pedirCarta();
		      break; 
	
		   case 2 :
			   System.out.println("NO");
			   System.out.println("JUGADOR no pidio cartas");
		      break;   
		}
		
		
	}
	
//sumar cartas de jugador
	static void sumarJ() {
		
		Object[] objects = mano.toArray();
		System.out.println(" ");
		System.out.println("--------JUGADOR------");
		System.out.println("Mano Jugador :" +mano);
		totalManoJ=0;
		for (int i : mano)
			totalManoJ += i;
		System.out.println("Mano Jugador TOTAL:" + totalManoJ);
		
		if (totalManoJ >=  22) {
			quienGana();
			System.exit(0);
		}
		
	}

// funcion con switch para tomar mas cartas
	void pedirCartaDealer() {
			
			String respuesta;
			Scanner sc = new Scanner(System.in);
			System.out.println("***DEALER DESEAS MAS CARTAS? 1=SI/2=NO");
			respuesta = sc.next();
			respuesta.toUpperCase();
			
			switch(Integer.parseInt(respuesta))
			{
			   
			   case 1 :
				   
			     System.out.println("SI");
			     int remove=baraja.remove(baraja.size()-1);
			     manoDealer.add(remove);
			     System.out.println("Baraja " +baraja);
			     sumarD();
			     pedirCartaDealer();
			      break; 
			   
			   case 2 :
				   System.out.println("NO");
				   System.out.println("DEALER no pidio cartas");
			      break; 	   
			}
	}
	
//sumar cartas de dealer
	static void sumarD() {
		System.out.println(" ");
		System.out.println("--------DEALER------");
		Object[] objects = manoDealer.toArray();
		System.out.println("Mano Dealer :" +manoDealer);
		totalManoD=0;
		for (int i : manoDealer)
			totalManoD += i;
		System.out.println("Mano Dealer TOTAL:" + totalManoD);
		
		if (totalManoD >=  22) {
			quienGana();
			System.exit(0);

		}
		
		
	}

	
//metodo para ver la baraja restante, y las manos
	void mostrarCartas() {
		System.out.println(" ");
		System.out.println("--------RESULTADO------");
		System.out.println("Baraja " +baraja);
		System.out.println("JUGADOR: " +totalManoJ);
		System.out.println("DEALER: " +totalManoD);
		System.out.println("--------RESULTADO------");
	}
	
	
//metodo para ver quien gana
static // metodo para comprar valores y ver quien gana
	void quienGana() {
		
		
		if(totalManoJ>=22) {
			
			System.out.println("JUGADOR Perdio: SE PASO DE 21 :(");
			System.out.println("Gana Dealer con: " + totalManoD);
			
		}
		if(totalManoD>=22 ) {
			
			System.out.println("Dealer Perdio: SE PASO DE 21 :(");
			System.out.println("Gana Jugador con: " + totalManoJ);
			
		}
		else if(totalManoJ>totalManoD && totalManoJ<=21 ) {
			
			System.out.println("Gana Jugador con: " + totalManoJ);
			

		}
		else if(totalManoJ<totalManoD && totalManoD<=21) {
			
			System.out.println("Gana Dealer con: " + totalManoD);
			

		}
		
		else if(totalManoJ==totalManoD){
			
			System.out.println("Empate");
			
		}
		Toolkit.getDefaultToolkit().beep();//beep sound windows
	}
}
