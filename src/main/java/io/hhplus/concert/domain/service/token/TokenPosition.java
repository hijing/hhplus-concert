package io.hhplus.concert.domain.service.token;

import lombok.Getter;

@Getter
public record TokenPosition(String token, long queuePosition) {

}
