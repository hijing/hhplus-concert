package io.hhplus.concert.domain.entity.concert;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "concert")
public class ConcertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("콘서트 ID")
    private Long id;

    @Column(nullable = false)
    @Comment("콘서트 제목")
    private String concertName;

    public ConcertEntity(Long id, String concertName) {
        this.id = id;
        this.concertName = concertName;
    }
}
