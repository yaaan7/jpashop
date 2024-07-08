package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable //값 타입으로 사용하기 위해
@Getter
@Setter
public class Book {
    private String author;
    private int isbn; //도서번호!

}

