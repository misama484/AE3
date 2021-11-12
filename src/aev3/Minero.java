package aev3;

public class Minero implements Runnable{
	static int bolsa;
	int tiempoExtraccion = 1000;
	Mina mina;
	
	Minero(Mina mina){
		Minero.bolsa = 0;
		this.mina = mina;
	}
	
	synchronized public void extraerRecurso(String nombre, int unidadesExtraidas) {
		
		if(unidadesExtraidas <= mina.stock) {
			mina.stock = mina.stock - unidadesExtraidas;
			bolsa = bolsa + unidadesExtraidas;
			System.out.println("El " + nombre + " ha extraido " + unidadesExtraidas + " oros");
			System.err.println("Quedan " + mina.stock + " oros");
			try {
				Thread.sleep(tiempoExtraccion);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(mina.stock == 0) {
			System.err.println("El oro se ha acabado, la mina esta vacia");
			System.err.println("Se han recolectado " + bolsa + " oros");
		}
	}

	@Override
	public void run() {
		int unidadesExtraidas = (int) (Math.random()*10 + 1);
		String nombre = Thread.currentThread().getName();
		extraerRecurso(nombre, unidadesExtraidas);
		
	}

}
