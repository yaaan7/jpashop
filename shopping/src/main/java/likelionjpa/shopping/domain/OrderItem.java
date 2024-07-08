package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id // id를 PK로 지정
    @GeneratedValue
    @Column(name="order_item_id") //데이터베이스에 order_item_id로 칼럼 이름 지정
    private Long id;

    //FK들
    private int count;
    private int order_Prices;

    @ManyToOne //OrderItem은 Item과 다대일 관계
    @JoinColumn(name="item_id") //Item의 PK
    private Item item;

    @ManyToOne //Order과 OrderItem은 일대다 관계
    @JoinColumn(name="order_id") //Order의 PK
    private Order order;
}
