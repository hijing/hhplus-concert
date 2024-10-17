package io.hhplus.concert.infrastructure.repository;

import io.hhplus.concert.domain.repository.payment.PointRepository;
import io.hhplus.concert.infrastructure.repository.jpa.PointJpaRepository;
import io.hhplus.concert.interfaces.controller.payment.dto.PointDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepository {

    private PointJpaRepository pointJpaRepository;
    private PointRepository pointRepository;

    @Override
    public void findAllPoint(Long userId) {

    }

    @Override
    public PointDTO findById(Long userId) {
        return null;
    }

    @Override
    public void save(PointDTO point) {

    }
}
