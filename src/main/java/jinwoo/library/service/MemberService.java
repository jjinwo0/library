package jinwoo.library.service;

import jinwoo.library.entity.Member;
import jinwoo.library.form.MemberForm;
import jinwoo.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(@Valid MemberForm form){

        Member member = new Member();
        member.setUsername(form.getUsername());
        member.setSchool(form.getSchool());
        member.setPhoneNumber(form.getPhoneNumber());
        member.setParentsPhoneNumber(form.getParentsPhoneNumber());

        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMember = memberRepository.findByUsername(member.getUsername());

        if (!findMember.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long id){
        return memberRepository.findById(id);
    }

    @Transactional
    public void modify(Long id, @Valid MemberForm form){
        Member findMember = memberRepository.findById(id);
    }

    public void regReadBook(String number, String bookStr){

        Member findMember = memberRepository.findByLastPhoneNumber(number);

    }
}
