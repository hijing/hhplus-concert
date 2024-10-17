package io.hhplus.concert.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="USERS")
public class User {

    //이 클래스는 H2 DB에 'user' 테이블로 생성되며,
    // yml(properties)에 선언한 테이블 생성 전략(create)에 의해 애플리케이션이 실행되는 시점에 CREATE DDL 쿼리가 실행됩니다.

    //Entity의 PK는 Long 타입의 Auto_increment를 사용하도록 하고,
    // 주민등록번호 같은 비즈니스상의 유니크 키나 복합키 등은 다음과 같은 이유 때문에
    // 유니크 키로 별도로 추가하는 것을 권장한다.
    // Entity 클래스에서는 Setter 메소드 대신 @Builder를 통해 제공되는 빌더 클래스를 사용하도록 한다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "userAmount", nullable = false)
    private Long userAmount;

    @Column(name = "created_dt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Builder
    public User(Long id) {
        this.id = id;
        this.userName = userName;
        this.userAmount = userAmount;
    }

}
