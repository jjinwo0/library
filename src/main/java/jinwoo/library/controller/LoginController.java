package jinwoo.library.controller;

import jinwoo.library.entity.Member;
import jinwoo.library.form.LoginForm;
import jinwoo.library.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "/member/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult result, HttpServletRequest request){
        if (result.hasErrors()){
            log.info("에러 발생");
            return "/member/loginForm";
        }

        Member loginMember = loginService.login(form);

        HttpSession session = request.getSession();

        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }
}
