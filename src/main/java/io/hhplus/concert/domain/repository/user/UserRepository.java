package io.hhplus.concert.domain.repository.user;

import io.hhplus.concert.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //JPA에서의 DB Layer 접근자를 의미한다.
    //인터페이스를 생성 후 JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
    //@Repository를 추가할 필요가 없다.
}
