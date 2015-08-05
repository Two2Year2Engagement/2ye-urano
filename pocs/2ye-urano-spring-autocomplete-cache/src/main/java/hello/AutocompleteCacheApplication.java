package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class AutocompleteCacheApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository repository;

	
	@Autowired
	private CacheController controller;

	private static final Logger log = LoggerFactory.getLogger(AutocompleteCacheApplication.class);

	@Override
	public void run(String... args) throws Exception {
		System.err.println(this.repository.findAll());
		log.info(".... Fetching books");
		log.info("isbn-1234 -->" + controller.getPerson("ve"));
		log.info("isbn-1234 -->" + controller.getPerson("ve"));
		log.info("isbn-1234 -->" + controller.getPerson("Rafa"));
		log.info("isbn-1234 -->" + controller.getPerson("Rafa"));
		log.info("isbn-1234 -->" + controller.getPerson("ão"));
	}

	public static void main(String[] args) {
		SpringApplication.run(AutocompleteCacheApplication.class, args);
	}
	
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("firstName");
    }
}
