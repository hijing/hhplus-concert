package io.hhplus.concert.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("좌석 ID")
    private Long id;

    @Column(name="concert_id", nullable = false)
    @Comment("콘서트 ID")
    private String concertId;

    @Column(name="seat_num", nullable = false)
    @Comment("좌석 번호")
    private int seatNum;

    @Column(name="price", nullable = false)
    @Comment("좌석 금액")
    private int price;

    @Builder
    public Seat(Long id, int seatNum) {
        this.id = id;
        this.seatNum = seatNum;
    }
}
