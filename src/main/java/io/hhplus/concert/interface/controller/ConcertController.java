package io.hhplus.concert.interfacecontroller;

import io.hhplus.concert.domain.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concert")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertService concertService;

    /**
     * 유저 토큰 발급 API
     */
    @GetMapping("/userToken")
    public void userToken() {}

    /**
     * 예약 가능 날짜 / 좌석 API
     */
    @GetMapping("/{concertId}/date")
    public void reservationDate(@PathVariable Long concertId) {}

    @GetMapping("/{concertId}/seat")
    public void reservationSeat(@PathVariable Long concertId) {}

    /**
     * 좌석 예약 요청 API
     */
    @PostMapping("/reservation")
    public void reservation() {}

    /**
     * 잔액 충전 / 조회 API
     */
    @PostMapping("/point/charge")
    public void pointCharge() {}

    @GetMapping("/point/{userId}")
    public void pointUser(@PathVariable Long id) {}

    /**
     * 결제 API
     */
    @PostMapping("/payment")
    public void payment() {}
}
