package jinwoo.library.service;

import jinwoo.library.entity.Book;
import jinwoo.library.entity.Member;
import jinwoo.library.entity.MemberBook;
import jinwoo.library.form.BookForm;
import jinwoo.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
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

    public Long register(@Valid BookForm form){
        Book book = new Book();

        book.setName(form.getName());
        book.setAuthor(form.getAuthor());
        book.setPublisher(form.getPublisher());

        return book.getId();
    }

    public Book findBookByBookName(String bookStr){
        return bookRepository.findByName(bookStr);
    }

    public Book findBookByBookCode(String code){
        return bookRepository.findByCode(code);
    }

    public List<MemberBook> findListByBook(Long id){
        Book findBook = bookRepository.findById(id);
        return findBook.getMemberBooks();
    }

    //읽은 멤버 조회
    public List<Member> findReadingMember(Long id){
        List<MemberBook> findList = this.findListByBook(id);
        List<Member> memberList = new ArrayList<>();
        for (MemberBook memberBook : findList) {
            if (memberBook.getBook().getId() ==  id){
                memberList.add(memberBook.getMember());
            }
        }
        return memberList;
    }
}
