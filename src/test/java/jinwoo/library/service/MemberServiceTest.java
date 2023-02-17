package jinwoo.library.service;

import jinwoo.library.entity.Book;
import jinwoo.library.entity.Member;
import jinwoo.library.entity.MemberBook;
import jinwoo.library.form.MemberForm;
import jinwoo.library.repository.MemberRepository;
import jinwoo.library.service.MemberService;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    EntityManager em;

    public void 회원가입(){
        MemberForm form = new MemberForm("memberA", "schoolA", "1234", "5678");
        Long joinMember = memberService.join(form);

        em.flush();

        Member findMember = memberRepository.findById(joinMember);

        assertThat(joinMember).isEqualTo(findMember.getId());
    }

    public void 읽은도서_검색(){
        Member member = new Member("memberA", "schoolA", "1234", "5678");
        Book book = new Book("bookA", "authorA", "pubA", "code");

        memberService.findReadingBook(member.getId());
    }
}
