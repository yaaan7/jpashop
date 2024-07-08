package likelionjpa.shopping.domain;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
//해당 클래스를 Bean 객체로 생성해주는 어노테이션
//DB나 파일 같은 외부 I/O 작업을 처리함
public class MemberRepository {
    @PersistenceContext
    //EntityManager을 빈으로 주입할 때 사용하는 어노테이션
    private EntityManager em;
    // EntityManager : 엔티티에 대한 CRUD(Create, Read, Update, Delete) 기능 제공
    //데이터 베이스와의 상호작용을 관리
    //스프링이 자동으로 'em'이라는 이름으로 'EntityManager'을 불러옴!

    //멤버 저장
    public Long save (Member member){
        //메서드 정의!
        em.persist(member);
        //member 객체를 managed 상태로 데이터베이스에 저장
        return member.getId();
    }

    //멤버 조회
    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
