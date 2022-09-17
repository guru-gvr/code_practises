package src.main.java.com.learning.jpaBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.learning.repo")
@EntityScan(basePackages = "com.learning.*")
public class JpaBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaBasicsApplication.class, args);
	}

}
