package inhating.user.service;

import inhating.user.domain.User;
import inhating.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원가입
    public User registerUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    // 로그인
    public Optional<User> loginUser(String userId, String pw) {
        return userRepository.findByUserId(userId)
                .filter(user -> user.getPw().equals(pw));
    }

    // 정보 수정
    public User updateUser(Long id, User updatedInfo) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedInfo.getName());
            user.setNickName(updatedInfo.getNickName());
            user.setMajor(updatedInfo.getMajor());
            user.setIntroduce(updatedInfo.getIntroduce());
            user.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    // 회원 탈퇴
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // 사용자 검색
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
