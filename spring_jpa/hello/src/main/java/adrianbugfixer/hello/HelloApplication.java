package adrianbugfixer.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloApplication {

	private static final Logger log = LoggerFactory.getLogger(HelloApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args) -> {
			repository.save(new Customer("Adrian", "Wasik"));
			repository.save(new Customer("Adrian2", "Wasik2"));
			repository.save(new Customer("Adrian3", "Wasik3"));
			repository.save(new Customer("Adrian4", "Wasik4"));
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
		
	}
}
	