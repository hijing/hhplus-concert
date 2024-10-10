package io.hhplus.concert.interfaces.controller.payment;

import io.hhplus.concert.domain.service.concert.ConcertService;
import io.hhplus.concert.domain.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * 결제 API
                */
    @PostMapping("/payment")
    public void payment() {}
}
