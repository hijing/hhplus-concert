package io.hhplus.concert.interfaces.controller.token;

import io.hhplus.concert.domain.service.token.TokenService;
import io.hhplus.concert.interfaces.controller.token.dto.TokenDTO;
import io.hhplus.concert.interfaces.controller.token.dto.res.TokenRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/token")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    /**
     * 유저 토큰 발급 API (유저의 UUID 와 해당 유저의 대기열을 관리할 수 있는 정보 ( 대기 순서 or 잔여 시간 등 )가 담긴 토큰 발급)
     */
    @PostMapping("/generation")
    public ResponseEntity<TokenRes> generateToken(@RequestBody TokenDTO token) {

        TokenDTO tokenDto = tokenService.addUserToQueue(token.getUserId());

        return ResponseEntity.ok(TokenRes.from(tokenDto));
    }

    /**
     * 대기 번호 조회 API
     */
    @GetMapping("/{userId}/checkStatus")
    public ResponseEntity<TokenRes> checkToken(@PathVariable long userId) {

        TokenDTO tokenDto = tokenService.getToken(userId);


        return ResponseEntity.ok(TokenRes.from(tokenDto));
    }
}
