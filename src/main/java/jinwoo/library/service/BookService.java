package jinwoo.library.service;

import jinwoo.library.entity.Book;
import jinwoo.library.form.BookForm;
import jinwoo.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findBook(String name){
        return bookRepository.findByName(name);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void register(@Valid BookForm form){
        Book book = new Book();

        book.setName(form.getName());
        book.setAuthor(form.getAuthor());
        book.setPublisher(form.getPublisher());
    }

    public void findReadingBook(String bookStr){

    }
}
