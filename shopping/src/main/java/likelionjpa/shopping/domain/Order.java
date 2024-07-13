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

    @ManyToOne  //Order과 Member는 다대일 관계
    //(+일에 있는 PK가 다에 FK로 있어야함)
    @JoinColumn(name = "member_id")
    //member_id 라는 이름의 외래 키 컬럼(->Member의 PK)과 매핑.
    private Member member;

    //DB에 OrderItems 항목 한 개를 저장하게 되면 자동으로 중앙 DB에 order 관련된 세개의 항목의 저장됨
    @OneToMany(mappedBy = "order") //Order과 OrderITem은 일대다 관계
    private List<OrderItem> orderItems = new ArrayList<>();


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //필요할 때까지 로드되지 않음
    //Order과 Delivery는 일대일 관계
    @JoinColumn(name = "delivery_id") //자식 엔티티 설정
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        this.member=member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
