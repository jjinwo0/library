package jinwoo.library.service;

import jinwoo.library.entity.Member;
import jinwoo.library.form.LoginForm;
import jinwoo.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(@Valid LoginForm form){
        return memberRepository.findByLastPhoneNumber(form.getLastNumber());
    }
}
