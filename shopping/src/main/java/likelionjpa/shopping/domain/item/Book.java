package likelionjpa.shopping.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {
    private String author;
    private int isbn; //도서번호!

}

