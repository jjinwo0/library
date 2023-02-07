package jinwoo.library.controller;

import jinwoo.library.entity.Member;
import jinwoo.library.form.MemberForm;
import jinwoo.library.repository.BookRepository;
import jinwoo.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final BookRepository bookRepository;

    @GetMapping("/members/new")
    public String joinForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String join(@Valid MemberForm form, BindingResult result){
        if (result.hasErrors())
            return "/members/createMemberForm";

        memberService.join(form);
        return "redirect:/";
    }

    @GetMapping("/members/modify")
    public String modifyForm(Model model){
        model.addAttribute("modifyForm", new MemberForm());
        return "/members/modifyMemberForm";
    }

    @PostMapping("/members/modify")
    public String modify(@Valid @ModelAttribute("modifyForm") MemberForm form, @SessionAttribute("loginMember") Member member, BindingResult result){
        if (result.hasErrors()){
            log.info("에러 발생");
            return "/members/modifyMemberForm";
        }

        memberService.modify(member.getId(), form);

        return "redirect:/";
    }
}
