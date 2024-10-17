package io.hhplus.concert.interfaces.controller.token;

import io.hhplus.concert.domain.service.token.TokenService;
import org.springframework.scheduling.annotation.Scheduled;

public class QueueScheduler {
    private final TokenService tokenService;

    public QueueScheduler(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Scheduled(fixedRate = 60000) // 1분마다 실행
    public void decrementWaitTimes() {
//        tokenService.getQueue().forEach(User::decrementWaitTime);
    }
}
