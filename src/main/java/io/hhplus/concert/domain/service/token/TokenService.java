package io.hhplus.concert.domain.service.token;

import io.hhplus.concert.domain.repository.token.TokenRepository;
import io.hhplus.concert.interfaces.controller.token.dto.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//대기열을 관리하는 서비스 (유저의 요청을 저장하고 대기 시간을 관리)
@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

//    private final ConcurrentLinkedQueue<User> queue = new ConcurrentLinkedQueue<>();

    public TokenDTO addUserToQueue(Long userId) {
//        Token existingToken = tokenRepository.findByUserId(userId);
//
//        queue.add(new User(userId, waitTime));
        return null;
    }

//    public User getNextUser() {
//        return queue.poll(); // 대기열의 첫 번째 유저를 가져오고 제거
//    }

    public void getQueue() {
    }

    public TokenDTO getToken(long userId) {
        TokenPosition tokenPosition = tokenRepository.findTokenId(userId);

        long queuePosition = (userId + 1);

        tokenRepository.save(tokenPosition.token());

        return new TokenDTO(tokenPosition.token(), tokenPosition.queuePosition());
    }
}
