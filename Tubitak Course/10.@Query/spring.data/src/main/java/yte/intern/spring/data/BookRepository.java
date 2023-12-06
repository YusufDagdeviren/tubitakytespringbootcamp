package yte.intern.spring.data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    @Query("select b from Book b where b.title = :title")
    Book findByQuery(String title);
    @Query("select b from Book b where b.age>= :age")
    List<Book> findByAgeQuery(Long age, Sort sort);
    @Query("select b from Book b where b.publishDate>= :publishDate")
    List<Book> findByPublishDate(LocalDateTime localDateTime, PageRequest pageRequest);
    @Query("select b from Book b where b.title like %:title%")
    List<Book> findByTitleLike(String title);
    @Query("select b from Book b where b.author = :author and b.age >= :age")
    List<Book> findByAuthorAndAgeQuery(String author, Long age);

    @Query("select count(b) from Book b where b.author = :author")
    long countByAuthorQuery(String author);

}
