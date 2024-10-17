package io.hhplus.concert.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "Concert")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("콘서트 ID")
    private Long id;

    @Column(name="name", nullable = false)
    @Comment("콘서트 제목")
    private String concertName;

//    public Concert(Long id, String concertName) {
//        this.id = id;
//        this.concertName = concertName;
//    }

    @Builder
    public Concert(Long id, String concertName) {
        this.id = id;
        this.concertName = concertName;
    }

}
