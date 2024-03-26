package dev.jewel.learnspringsecurity.controller;

import dev.jewel.learnspringsecurity.dto.ReqRes;
import dev.jewel.learnspringsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signup(@RequestBody ReqRes signupRequest){
        return ResponseEntity.ok(authService.signUp(signupRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signin(@RequestBody ReqRes signinRequest){
        return ResponseEntity.ok(authService.signIn(signinRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refresh(@RequestBody ReqRes refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
