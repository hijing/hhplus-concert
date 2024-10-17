package io.hhplus.concert.domain.repository.payment;


import io.hhplus.concert.interfaces.controller.payment.dto.PointDTO;

public interface PointRepository {

    void findAllPoint(Long userId);

    PointDTO findById(Long userId);

    void save(PointDTO point);
}
