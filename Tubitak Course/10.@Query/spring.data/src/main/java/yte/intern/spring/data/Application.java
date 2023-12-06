package yte.intern.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		saveBooks(bookRepository);
//		System.out.println(bookRepository.findByTitle("Suç ve Ceza"));
//		System.out.println(bookRepository.findByAgeGreaterThan(10L, Sort.by("age").descending()));
//		System.out.println(bookRepository.findByPublishDateAfter(LocalDateTime.parse("2000-01-01T00:00"), PageRequest.of(1, 5)));
//		System.out.println(bookRepository.findByTitleContains("Su"));
//		System.out.println(bookRepository.findByAuthorAndAgeGreaterThan("Dostoyevski",10L));
//		System.out.println(bookRepository.countByAuthor("Dostoyevski"));
//		System.out.println(bookRepository.existsByAuthor("Ahmet"));

	}
	private static void saveBooks(BookRepository bookRepository){
		List<Book> exampleBooks = new ArrayList<>();
		exampleBooks.add(new Book(null,"Suç ve Ceza","Dostoyevski",12L, LocalDateTime.parse("1912-07-11T00:00")));
		exampleBooks.add(new Book(null,"Hayvan Çiftliği","George Orwell",12L, LocalDateTime.parse("1955-07-11T00:00")));
		bookRepository.saveAll(exampleBooks);
	}

}
