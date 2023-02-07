package jinwoo.library.controller;

import jinwoo.library.form.BookForm;
import jinwoo.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/books/register")
    public String bookRegForm(Model model){
        model.addAttribute("bookForm", new BookForm());
        return "books/registerForm";
    }

    @PostMapping("/books/register")
    public String bookReg(@Valid @ModelAttribute("bookForm") BookForm form, BindingResult result){
        if (result.hasErrors()){
            log.info("에러 발생");
            return "books/registerForm";
        }

        bookService.register(form);

        return "redirect:/";
    }
}
