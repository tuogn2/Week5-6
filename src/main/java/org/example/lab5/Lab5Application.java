package org.example.lab5;

import org.example.lab5.models.Person;
import org.example.lab5.models.Product;
import org.example.lab5.repositories.PersonRepository;
import org.example.lab5.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab5Application implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ProductRepository productRepository;


	public static void main(String[] args)  {
		SpringApplication.run(Lab5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person();
		person.setName("John Doe");
		person.setAddress("Bucharest");
		person.setGender("M");
		person.setPhone("1234567890");
		person.setEmail("tuong@gmail.com");

		personRepository.save(person);

		Product product = new Product();
		product.setName("iphone 12 pro max");
		product.setPrice(1000);
		product.setDescription("iphone 12 pro max");
		product.setQuantity(10);


		productRepository.save(product);

		System.out.println(personRepository.findAll());




	}
}
	