package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity  //객체를 entity로 사용하기 위한 어노테이션
//다른 클래스와 매핑하려 할 때 꼭 적어야함.........
@Getter
@Setter
public class Delivery {
    @Id //Delivery_id를 PK로 지정
    @GeneratedValue
    private Long Delivery_id;

    @Embedded  //Adress클래스를 값 타입으로 사용,
    private Address address;

    //@OneToOne
    //@JoinColumn(name = "Order_id")
    //private Order order;

    //Delivery는 Order과 일대일관계
    @OneToOne(mappedBy = "delivery")
    private Order order;

    private DeliveryStatus status;

}
