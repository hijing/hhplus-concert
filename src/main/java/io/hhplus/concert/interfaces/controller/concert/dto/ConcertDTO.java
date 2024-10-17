package io.hhplus.concert.interfaces.controller.concert.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ConcertDTO {
    private Long id;
    private String name;
    private LocalDate event_dt;
    private LocalDateTime start_time;
    private int required_time;
}
