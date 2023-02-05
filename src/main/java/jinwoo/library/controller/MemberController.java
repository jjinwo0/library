package jinwoo.library.controller;

import jinwoo.library.form.MemberForm;
import jinwoo.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

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
}
