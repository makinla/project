package hh.backend.book_store_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.book_store_project.domain.Book;
import hh.backend.book_store_project.domain.BookRepository;

@SpringBootApplication
public class BookStoreProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreProjectApplication.class, args);
	}

	 @Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple books");
			repository.save(new Book("Tähdettömät taivaat", "Lily Darkmoor", 2023, "978-952-5555-888", 25.00));
			repository.save(new Book("Aavikon varjo", "Cassius Storm", 2021, "978-952-4444-777", 19.90));
			repository.save(new Book("Kylmä tuli", "Mira Faldor", 2020, "978-951-3333-555", 22.50));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
				
			}
		};


	} 


	

}
