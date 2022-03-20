package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.service.IProcesamientoFacultadService;


@SpringBootApplication
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
		
		Integer valor1 =  this.facu.calcularDeuda("1234567", 4);
		Integer valor2 =  this.facu.calcularDeuda("12367", 4);
		Integer valor3 = this.facu.calcularDeuda("1772567", 4);
		Integer valor4 = this.facu.calcularDeuda("18784567", 4);
		
		LOG.info("TOTAL: " + (valor1 +valor2 + valor3+ valor4));
		
		long tFinal = System.currentTimeMillis();
		long tTransc = (tFinal - inicio)/ 100;
		LOG.info(tTransc + "seg");
	}

}
