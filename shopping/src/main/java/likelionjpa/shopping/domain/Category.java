package likelionjpa.shopping.domain;
import jakarta.persistence.*;
import likelionjpa.shopping.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;


@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="category_item",
            //다대다를 일대다, 다대일로 풀어주는 과정
            joinColumns = @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<Category>();

    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }
}
