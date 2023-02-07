package jinwoo.library.form;

import jinwoo.library.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MemberForm {

    @NotEmpty(message = "필수 입력 항목입니다.")
    private String username;
    private String school;
    private String phoneNumber;
    private String parentsPhoneNumber;

}
