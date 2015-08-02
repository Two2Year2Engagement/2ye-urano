package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private PersonRepository repository;

	@Override
	public void run(String... args) throws Exception {
		System.err.println(this.repository.findAll());
	}
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
