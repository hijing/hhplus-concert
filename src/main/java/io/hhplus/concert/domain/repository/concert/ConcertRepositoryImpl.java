package io.hhplus.concert.domain.repository.concert;

import io.hhplus.concert.infrastructure.ConcertJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConcertRepositoryImpl implements ConcertRepository{

    private final ConcertJpaRepository concertJpaRepository;
}
