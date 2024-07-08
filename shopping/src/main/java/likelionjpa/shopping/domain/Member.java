package likelionjpa.shopping.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity  //객체를 entity로 사용하기 위한 어노테이션
@Getter
@Setter
@Table(name = "member")
public class Member {
    //entity를 사용하기 위해서는 public 또는 protected의 생성자가 필요
    @Id //PK로 사용할 변수 위에 @Id를 붙여 PK로 지정
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    //Id 값을 entity가 생성될 때마다 자동생성되게 해주는 어노테이션
    @SequenceGenerator(name = "member_seq", sequenceName = "member_SEQ", allocationSize = 1)
    @Column(name = "member_id") //매핑할 데이터베이스 컬럼의 이름 지정
    private Long id;
    private String username;

    @Embedded //address를 값 타입으로 사용하기
    private Address addresss;

    //Member와 Order는 일대다 관계
    @OneToMany(mappedBy = "member") //자식 엔티티필드의 이름 지정
    private List<Order> orders = new ArrayList<>();

}