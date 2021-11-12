package aev3;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mina mina = new Mina(100);
		Thread hilo;
		Minero minero = null;
		int cont = 1;
		
		while(mina.stock > 0) {
			minero = new Minero(mina);
			hilo = new Thread(minero);
			hilo.setName("Minero " + cont);
			hilo.start();
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cont++;
		}
		System.err.println("Oro total recogido " + Minero.bolsa);
	}

}
