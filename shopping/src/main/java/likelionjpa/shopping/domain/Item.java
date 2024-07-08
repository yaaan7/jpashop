package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public abstract class Item {
    @Id //Item_id를 PK로 지정
    @GeneratedValue
    private Long Item_id;
    private String name;
    private int price;
    private int stockQuantity;

    @Embedded  //album 클래스를 값타입으로 사용
    private Album album;
    @Embedded  //book 클래스를 값타입으로 사용
    private Book book;
    @Embedded  //movie 클래스를 값타입으로 사용
    private Movie movie;
}

