package jinwoo.library.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BookForm {

    private String name;
    private String author;
    private String publisher;

    public BookForm(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }
}
