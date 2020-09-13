package hackathon.banco.safra.easyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EasywayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasywayApplication.class, args);
	}

}
