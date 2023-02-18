package jinwoo.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class MemberBook {

    @Id @GeneratedValue
    @Column(name = "member_book_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private String bookName;

    public static MemberBook regMemberBook(Book book, String bookName){
        MemberBook memberBook = new MemberBook();
        memberBook.setBook(book);
        memberBook.setBookName(bookName);

        return memberBook;
    }
}
