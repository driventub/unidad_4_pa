package ec.edu.uce;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import ec.edu.uce.service.IProcesamientoFacultadService;


@SpringBootApplication
@EnableAsync

public class PaWebU4Application implements CommandLineRunner{
	
	private static final Logger LOG = LoggerFactory.getLogger(PaWebU4Application.class);
	
	@Autowired
	private IProcesamientoFacultadService facu;
	
	public static void main(String[] args) {
		SpringApplication.run(PaWebU4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		long inicio = System.currentTimeMillis();
		
//		Procesamiento asincrono, pero sin manejo de respuesta por cada hilo
//		Integer valor1 =  this.facu.calcularDeuda("1234567", 4);
//		Integer valor2 =  this.facu.calcularDeuda("12367", 4);
//		Integer valor3 = this.facu.calcularDeuda("1772567", 4);
//		Integer valor4 = this.facu.calcularDeuda("18784567", 4);
		
//		Procesamiento asincrono, pero sin manejo de respuesta por cada hilo
		
		CompletableFuture<Integer> valor1 =  this.facu.calcularDeudaFuture("1234567", 4);
		CompletableFuture<Integer> valor2 =  this.facu.calcularDeudaFuture("12367", 4);
		CompletableFuture<Integer> valor3 = this.facu.calcularDeudaFuture("1772567", 4);
		CompletableFuture<Integer> valor4 = this.facu.calcularDeudaFuture("18784567", 4);
		
//		Sentencia que espera que terminen todos los hilos
		CompletableFuture.allOf(valor1,valor2,valor3,valor4).join();
		
		LOG.info("TOTAL: " + (valor1.get() +valor2.get() + valor3.get()+ valor4.get()));
		
		long tFinal = System.currentTimeMillis();
		long tTransc = (tFinal - inicio)/ 100;
		
		LOG.info(tTransc + "seg");
	}

}
