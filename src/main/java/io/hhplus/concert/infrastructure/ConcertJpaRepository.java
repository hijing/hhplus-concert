package io.hhplus.concert.infrastructure;

import io.hhplus.concert.domain.entity.concert.ConcertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertJpaRepository extends JpaRepository<ConcertEntity, Long> {
}
