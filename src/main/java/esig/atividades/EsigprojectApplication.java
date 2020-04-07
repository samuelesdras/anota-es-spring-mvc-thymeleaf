package esig.atividades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "esig.atividades.model")
public class EsigprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsigprojectApplication.class, args);
	}

}
