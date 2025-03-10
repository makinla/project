package hh.backend.book_store_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.book_store_project.domain.AppUser;
import hh.backend.book_store_project.domain.AppUserRepository;
import hh.backend.book_store_project.domain.Book;
import hh.backend.book_store_project.domain.BookRepository;
import hh.backend.book_store_project.domain.Category;
import hh.backend.book_store_project.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreProjectApplication.class, args);
	}

	 @Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, AppUserRepository uRepository) {
		return (args) -> {
			log.info("save a couple books");
			Category category1 = new Category("Fantasy");
			crepository.save(category1);
			Category category2 = new Category("Adventure");
			crepository.save(category2);
			Category category3 = new Category("Sci-fi");
			crepository.save(category3);

			brepository.save(new Book("Whispers of the Forest", "Oliver Winters", 2021, "978-945-8392-014", 18.99, category1));
			brepository.save(new Book("The Last Horizon", "Sophia Mitchell", 2022, "978-827-4783-601", 22.50, category2));
			brepository.save(new Book("Echoes of Tomorrow", "Lily Darkmoor", 2023, "978-952-5555-888", 25.00, category3));

			AppUser user1 = new AppUser("user", "$2a$10$HXhBqQ3CkyMi93NQa5b5xOMd8mTSenI5Rp1m75mxlZtYUQRfqdH6G", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$n01kJPgoY9VX9Rb/0/2sMeknpUyjqbbJuYUyVW/vHwsV2Z0rclIES", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);
			
			log.info("fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			

			}
			System.out.println("");

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
				
			}
		};

	


	} 


	

}
