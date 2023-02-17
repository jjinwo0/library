package jinwoo.library.service;

import jinwoo.library.form.LoginForm;
import jinwoo.library.form.MemberForm;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class LoginServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    LoginService loginService;
    @Autowired
    MemberService memberService;

    public void 로그인(){
        MemberForm form = new MemberForm("memberA", "schoolA", "1234", "5678");
        Long joinMember = memberService.join(form);

        em.flush();

        String num = form.getPhoneNumber();
        LoginForm loginForm = new LoginForm(num.substring(num.length()-4, num.length()));
        loginService.login(loginForm);
    }
}
