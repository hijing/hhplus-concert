package io.hhplus.concert.interfaces.controller.concert;

import io.hhplus.concert.interfaces.controller.concert.dto.ConcertDTO;
import io.hhplus.concert.domain.service.concert.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/api/concert")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertService concertService;

    /**
     * 예약 가능 날짜 API
     */
    @GetMapping("/{concertId}/available")
    public ResponseEntity<ConcertDTO> reservationDate(@PathVariable Long concertId,
                                                      @RequestHeader("Token") String name) {

//      ConcertEntity concertEntity = concertService.selectReservationDate(concertId);

        ConcertDTO concertResponse = new ConcertDTO();
        concertResponse.setId(1L);
        concertResponse.setName("콘서트");
        concertResponse.setEvent_dt(LocalDate.parse("2024-10-04"));
        concertResponse.setStart_time(LocalDateTime.parse("16:00"));
        concertResponse.setRequired_time(70);
//        findAllConcert
        return ResponseEntity.ok(concertResponse);
    }

    /**
     * 예약 가능 좌석 API
     */
    @GetMapping("/{concertId}/available-seat")
    public ResponseEntity<ConcertDTO> reservationSeat(@PathVariable Long id) {

        ConcertDTO concertResponse = new ConcertDTO();
        concertResponse.setId(1L);
        concertResponse.setName("콘서트");
        concertResponse.setEvent_dt(LocalDate.parse("2024-10-04"));
        concertResponse.setStart_time(LocalDateTime.parse("16:00"));


        return ResponseEntity.ok(concertResponse);
    }

    /**
     * 좌석 예약 요청 API
     */
    @PostMapping("/{seatId}/reservation")
    public ResponseEntity<ConcertDTO> reservation(@PathVariable Long id) {

        ConcertDTO concertResponse = new ConcertDTO();
        concertResponse.setId(1L);
        concertResponse.setName("콘서트");
        concertResponse.setEvent_dt(LocalDate.parse("2024-10-04"));
        concertResponse.setStart_time(LocalDateTime.parse("16:00"));

        return ResponseEntity.ok(concertResponse);
    }
}
