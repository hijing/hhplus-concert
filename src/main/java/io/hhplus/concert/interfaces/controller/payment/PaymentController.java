package io.hhplus.concert.interfaces.controller.payment;

import io.hhplus.concert.domain.entity.Payment;
import io.hhplus.concert.domain.service.payment.PaymentService;
import io.hhplus.concert.interfaces.controller.payment.dto.PaymentDTO;
import io.hhplus.concert.interfaces.controller.payment.dto.req.PaymentReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("v1/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName()); //데이터 확인
    private final PaymentService paymentService;

    /**
     * 잔액 충전  API
     */
    @PatchMapping("/{userId}/charge")
    public void pointCharge(@RequestBody
                            PaymentReq req) {
//        paymentService.charge();
    }

    /**
     * 잔액 조회 API
     */
    @GetMapping("/{userId}")
    public Optional<Payment> pointUser(@PathVariable Long userId) {
        return paymentService.getAllPoint(userId);
    }

    /**
     * 결제 API
     */
    @PostMapping("/{userId}/payment")
    public ResponseEntity<PaymentDTO> createPayment(@RequestHeader String requestId,
                                                    @RequestBody PaymentDTO payment) {
//        String requestId = UUID.randomUUID().toString();

        logger.info(requestId + ", amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());  //결제용 아이디로 랜덤값 생성
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }
}
