package blackJack;

public class game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealer n = new Dealer("Dealer");
		//llamar a todos los metodos
		n.baraja();
		n.mezclar();
		n.deal2Cartas();
		n.deal2CartasAlDealer();
		//n.pedirCarta();
		//n.pedirCartaDealer();
		n.mostrarCartas();
		n.quienGana();
	}

}



