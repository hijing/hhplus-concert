package io.hhplus.concert.interfaces.controller.concert;

import io.hhplus.concert.domain.service.concert.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concert")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertService concertService;

    /**
     * 예약 가능 날짜 API
     */
    @GetMapping("/{concertId}/date")
    public void reservationDate(@PathVariable Long concertId) {}

    /**
     * 예약 가능 좌석 API
     */
    @GetMapping("/{concertId}/seat")
    public void reservationSeat(@PathVariable Long concertId) {}

    /**
     * 좌석 예약 요청 API
     */
    @PostMapping("{seatId}/reservation")
    public void reservation() {}


}
