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

    @OneToMany(mappedBy = "book")
    private List<Member> members;
}
