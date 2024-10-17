package io.hhplus.concert.infrastructure.repository.jpa;

import io.hhplus.concert.domain.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertJpaRepository extends JpaRepository<Concert, Long> {

    // 단일검색
//    List<ConcertEntity> findByName(String name);

//    // 여러 조건 검색(AND)
//    List<ConcertEntity> findByNameAndCode(String name, Integer code);
//
//    // 여러 조건 검색(OR)
//    List<ConcertEntity> findByNameOrCodeOrDate(String name, Integer code, LocalDate date);
//
//    // LIKE 조건 사용
//    List<ConcertEntity> findByNameContaining(String name);
//
//    // BETWEEN 조건 사용
//    List<ConcertEntity> findByDateBetween(LocalDate startDate, LocalDate endDate);
//
//    // 정렬 조건 사용
//    List<ConcertEntity> findByNameOrderByCodeDesc(String name);
}
