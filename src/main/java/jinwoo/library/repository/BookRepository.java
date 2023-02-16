package jinwoo.library.repository;

import jinwoo.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("select b from Book b where b.id = :id")
    Book findById(Long id);

    @Query("select b from Book b")
    List<Book> findAll();

    @Query("select b from Book b where b.name = :name")
    Book findByName(String name);

    @Query("select b from Book b where b.code = :code")
    Book findByCode(String code);
}
