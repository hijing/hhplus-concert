package io.hhplus.concert.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("결제 ID")
    private Long id;

    @Column(name="user_id", nullable = false)
    @Comment("사용자 ID")
    private Long userId;

    @Column(name="reservation_id", nullable = false)
    @Comment("예약 ID")
    private Long reservationId;

    @Column(name="price", nullable = false)
    @Comment("결제 금액")
    private int price;

    @Builder
    public Payment(Long id) {
        this.id = id;
    }
}
