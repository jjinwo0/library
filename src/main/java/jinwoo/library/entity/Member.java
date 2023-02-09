package jinwoo.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    private String username;
    private String school;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "parents_number")
    private String parentsPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
