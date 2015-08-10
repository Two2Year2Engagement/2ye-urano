package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConcurrencyLockApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringConcurrencyLockApplication.class);

	@Autowired
	private Dictionary dictionary;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConcurrencyLockApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {		
		dictionary.set("java", "object oriented");
		/*dictionary.set("linux", "rulez");
		dictionary.set("mac", "beutifull");
		dictionary.set("solaris", "old but gold");
		dictionary.set("red hat", "new and fit");
		dictionary.set("debian", "just old");*/
		Writer writer = new Writer(dictionary, "Mr. Writer");
		Reader reader1 = new Reader(dictionary, "Mrs Reader 1");
		Reader reader2 = new Reader(dictionary, "Mrs Reader 2");
		Reader reader3 = new Reader(dictionary, "Mrs Reader 3");
		Reader reader4 = new Reader(dictionary, "Mrs Reader 4");
		Reader reader5 = new Reader(dictionary, "Mrs Reader 5");
		log.info("Inciando thread de writer");
		writer.setPriority(Thread.MAX_PRIORITY);
		writer.start();
		log.info("Inciando thread de reader Mrs Reader 1");
		reader1.start();
		log.info("Inciando thread de reader Mrs Reader 2");
		reader2.start();
		log.info("Inciando thread de reader Mrs Reader 3");
		reader3.start();
		log.info("Inciando thread de reader Mrs Reader 4");
		reader4.start();
		log.info("Inciando thread de reader Mrs Reader 5");
		reader5.start();

	}
}
