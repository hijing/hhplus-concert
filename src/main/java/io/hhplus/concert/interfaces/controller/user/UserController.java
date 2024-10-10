package io.hhplus.concert.interfaces.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 토큰 발급 API
     */
    @GetMapping("/userToken")
    public void userToken() {}

    /**
     * 잔액 충전  API
     */
    @PostMapping("/point")
    public void pointCharge() {}

    /**
     * 잔액 조회 API
     */
    @GetMapping("/point/{userId}")
    public void pointUser(@PathVariable Long id) {}
}
