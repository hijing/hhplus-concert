package io.hhplus.concert.domain.repository.token;

import io.hhplus.concert.domain.service.token.TokenPosition;

public interface TokenRepository {


    TokenPosition findTokenId(long userId);

    void save(String token);
}
