package jinwoo.library.service;

import jinwoo.library.entity.Book;
import jinwoo.library.form.BookForm;
import jinwoo.library.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    public void 도서등록(){
        BookForm form = new BookForm("bookA", "authorA", "pubA");
        Long bookId = bookService.register(form);

        em.flush();

        Book findBook = bookRepository.findById(bookId);

        Assertions.assertThat(bookId).isEqualTo(findBook.getId());
    }
}
