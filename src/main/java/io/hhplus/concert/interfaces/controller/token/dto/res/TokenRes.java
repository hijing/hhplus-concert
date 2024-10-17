package io.hhplus.concert.interfaces.controller.token.dto.res;

import io.hhplus.concert.interfaces.controller.token.dto.TokenDTO;

import java.time.LocalDateTime;

public record TokenRes(long id, LocalDateTime expireAt) {

    public static TokenRes from(TokenDTO token) {
        return new TokenRes(token.getId(), token.getExpiredAt());
    }
}