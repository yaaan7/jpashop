package likelionjpa.shopping.domain.item;

import jakarta.persistence.*;
import likelionjpa.shopping.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter
@Setter
public abstract class Item {
    @Id //Item_id를 PK로 지정
    @GeneratedValue
    @Column(name="item_id")
    private Long id; //PK

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}

