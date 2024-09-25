package aluguelcarro.labdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableJpaRepositories("com.example.aluguelcarro.repository")
public class LabdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabdevApplication.class, args);
	}

}	
