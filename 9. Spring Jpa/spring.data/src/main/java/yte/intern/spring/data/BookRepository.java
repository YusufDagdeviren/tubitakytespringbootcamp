package yte.intern.spring.data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);
    List<Book> findByAgeGreaterThan(Long age, Sort sort);

    List<Book> findByPublishDateAfter(LocalDateTime publishDate, PageRequest PageRequest);

    List<Book> findByTitleContains(String title);
    List<Book> findByTitleContainsIgnoreCase(String title);// küçük büyük fark etmez
    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);
    long countByAuthor(String author);
    boolean existsByAuthor(String author);

}
