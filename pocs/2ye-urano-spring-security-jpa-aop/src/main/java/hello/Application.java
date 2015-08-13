package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackages = "hello")
@EntityScan(basePackages = "hello")
public class Application {

	
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	
}
