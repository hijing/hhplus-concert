package io.hhplus.concert.interfaces.controller.token.dto;

import io.hhplus.concert.domain.entity.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TokenDTO {
    Long id;
    String token;
    String status;
    LocalDateTime expiredAt;
    Long queuePosition;
    Long userId; // 고의적 유저 찾을때? 디버깅 측면에서도 // uuid 외부 노출할 때 코어한 정보 숨기려고

    public TokenDTO(String token, long queuePosition) {
        this.token = token;
        this.queuePosition = queuePosition;
    }
}
