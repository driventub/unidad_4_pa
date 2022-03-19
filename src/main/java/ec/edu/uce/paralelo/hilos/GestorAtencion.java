package ec.edu.uce.paralelo.hilos;

import java.util.concurrent.TimeUnit;

public class GestorAtencion {
	
	public void procesar(Cajero cajero, long tiempoInicial) {
		System.out.println("Inicia atender cajero:  " + cajero.getNombre());
		for(Integer tiempo: cajero.getClientes()) {
			
			atenderCliente(tiempo);
			
		}
		System.out.println("Fin atender cajero:  " + cajero.getNombre());
		long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + "seg de atencion por: " + cajero.getNombre());
		
	}
	
	private void atenderCliente(Integer tiempo) {
		System.out.println("Atendiendo a cliente : "+ tiempo);
		System.out.println("Hilo: "+ Thread.currentThread().getName());
		try {
//			Se demora en la atencion
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Atendiendo a cliente : "+ tiempo);
	}
}
