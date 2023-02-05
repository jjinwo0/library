package jinwoo.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
