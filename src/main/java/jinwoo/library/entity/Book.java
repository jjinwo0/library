package jinwoo.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String name;
    private String author;
    private String publisher;
    private String code;

    @OneToMany(mappedBy = "book")
    private List<MemberBook> memberBooks;

    public Book(String name, String author, String publisher, String code) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.code = code;
    }
}
