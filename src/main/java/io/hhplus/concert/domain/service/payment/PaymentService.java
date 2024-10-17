package io.hhplus.concert.domain.service.payment;

import io.hhplus.concert.interfaces.controller.payment.dto.PointDTO;
import io.hhplus.concert.domain.entity.Payment;
import io.hhplus.concert.domain.repository.payment.PointRepository;
import io.hhplus.concert.infrastructure.repository.jpa.PointJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PointRepository pointRepository;
    private final PointJpaRepository pointJpaRepository;

    public Optional<Payment> getAllPoint(Long userId) {
//        pointRepository.getAllPoint(userId);


        return pointJpaRepository.findById(userId);
//        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
    }

    public void charge(Long userId, int amount) {
        PointDTO point = pointRepository.findById(userId);

        point.chargePoint(amount);

        pointRepository.save(point);


    }
}
