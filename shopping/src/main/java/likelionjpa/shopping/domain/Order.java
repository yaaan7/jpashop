package likelionjpa.shopping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    //order_id 라는 이름으로 데이터베이스의 컬럼과 매핑.(PK의 이름..?)
    private Long id;



    @OneToMany(mappedBy = "order") //Order과 OrderITem은 일대다 관계
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    private OrderStatus status;

    @OneToOne //Order과 Delivery는 일대일 관계
    @JoinColumn(name = "delivery_id") //자식 엔티티 설정
    private Delivery delivery;

    @ManyToOne  //Order과 Member는 다대일 관계
    //(+일에 있는 PK가 다에 FK로 있어야함)
    @JoinColumn(name = "member_id")
    //member_id 라는 이름의 외래 키 컬럼(->Member의 PK)과 매핑.
    private Member member;
}
