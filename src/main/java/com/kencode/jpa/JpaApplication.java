package com.kencode.jpa;

//import com.kencode.jpa.model.Author;
//import com.kencode.jpa.repositories.AuthorRepository;
////import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
//		return args -> {
//			var author = Author.builder()
//					.firstName("kene")
//					.lastName("Ogu")
//					.email("contact@keneogu.com")
//					.age(33)
//					.build();
//			repository.save(author);
//		};
//	}
}
