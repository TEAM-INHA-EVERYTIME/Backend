package inhating.user.controller;

import inhating.user.domain.User;
import java.util.Optional;
import inhating.user.domain.LoginRequest;
import inhating.user.service.UserService;
import inhating.user.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.loginUser(loginRequest.getUserId(), loginRequest.getPw());
        if (user.isPresent()) {
            String token = jwtTokenProvider.generateToken(loginRequest.getUserId());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials!");
        }
    }



    // 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedInfo) {
        // JWT로 인증된 사용자 ID 확인
        String authenticatedUserId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 수정하려는 사용자 ID와 인증된 사용자 ID가 다르면 거부
        if (!authenticatedUserId.equals(updatedInfo.getUserId())) {
            return ResponseEntity.status(403).body(null);
        }

        return ResponseEntity.ok(userService.updateUser(id, updatedInfo));
    }

    // 회원 탈퇴
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        // JWT로 인증된 사용자 ID 확인
        String authenticatedUserId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // UserService의 findById 호출
        User user = userService.findById(id);

        // 삭제하려는 사용자 ID와 인증된 사용자 ID가 다르면 거부
        if (!authenticatedUserId.equals(user.getUserId())) {
            return ResponseEntity.status(403).body("Unauthorized request");
        }

        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }

}
