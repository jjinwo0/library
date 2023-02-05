package jinwoo.library.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

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
