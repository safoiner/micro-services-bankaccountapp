package net.adib.customerservice;

import net.adib.customerservice.config.GolbalConifg;
import net.adib.customerservice.entities.Customer;
import net.adib.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GolbalConifg.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstname("Hassan")
							.lastname("elhoumi")
							.email("elhoumi@ent.ma")
							.build(),
					Customer.builder()
							.firstname("yanis")
							.lastname("houmi")
							.email("yanis@ent.ma")
							.build(),
					Customer.builder()
							.firstname("Hassania")
							.lastname("el")
							.email("el@ent.ma")
							.build()
			);
			customerRepository.saveAll(customerList);
		};

	}
}