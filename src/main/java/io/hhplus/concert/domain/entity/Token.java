package io.hhplus.concert.domain.entity;

import io.hhplus.concert.interfaces.controller.token.TokenStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "QUEUE")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User users;

    @Column(name = "token", nullable = false)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TokenStatus status;

    @Column(name = "create_dt", nullable = false)
    private LocalDateTime createDt;

    @Column(name = "expired_dt")
    private LocalDateTime expiredDt;

    public Token(Long userId, String token) {
        this.users = new User(userId);
        this.token = token;
        this.status = TokenStatus.STAND_BY;
        this.createDt = LocalDateTime.now();
        this.expiredDt = null;
    }

    public Token(Long userId, String token, TokenStatus status, LocalDateTime expiredDt) {
        this.users = new User(userId);
        this.token = token;
        this.status = status;
        this.createDt = LocalDateTime.now();
        this.expiredDt = expiredDt;
    }
}