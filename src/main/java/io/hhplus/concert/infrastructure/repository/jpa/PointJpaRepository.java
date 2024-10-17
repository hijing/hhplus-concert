package io.hhplus.concert.infrastructure.repository.jpa;

import io.hhplus.concert.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointJpaRepository extends JpaRepository<Payment, Long> {

    // 단일검색
    Optional<Payment> findById(Long id);
}
