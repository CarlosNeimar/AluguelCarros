package aluguelcarro.labdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"aluguelcarro.labdev"})
@EnableJpaRepositories(basePackages = "aluguelcarro.labdev.repositories")

public class LabdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabdevApplication.class, args);
	}

}	
