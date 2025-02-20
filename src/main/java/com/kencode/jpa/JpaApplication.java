package com.kencode.jpa;

import com.github.javafaker.Faker;
import com.kencode.jpa.model.Author;
import com.kencode.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
		return args -> {
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder().firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().username() + "@kenecodes.com")
						.build();
				repository.save(author);
			}
      var author = Author.builder()
        .id(1)
        .firstName("Kene")
        .lastName("Ogu")
        .age(34)
        .email("contact@keneogu.com")
        .build();
//      repository.save(author);
      repository.updateAuthor(22, 1);
//      update Autor a set a.age = 22 where a.id = 1
		};
	}
}
