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
    public Optional<User> loginUser(Long id, String pw) {
        return userRepository.findById(id)
                .filter(user -> user.getPw().equals(pw));
    }

    // 정보 수정
    public User updateUser(Long id, User updatedInfo) {
        return userRepository.findById(id).map(user -> {
            user.setUserId(updatedInfo.getUserId());
            user.setPw(updatedInfo.getPw());
            user.setName(updatedInfo.getName());
            user.setNickName(updatedInfo.getNickName());
            //user.setGender(updatedInfo.getGender());  성별 수정 불가 (악용 방지)
            user.setBirth(updatedInfo.getBirth());
            user.setNumber(updatedInfo.getNumber());
            user.setImage(updatedInfo.getImage());
            user.setMajor(updatedInfo.getMajor());
            //user.setStudentNumber(updatedInfo.getStudentNumber());    학번 수정 불가 (위조 방지)
            user.setMBTI(updatedInfo.getMBTI());
            user.setAlcohol(updatedInfo.getAlcohol());
            user.setSmoke(updatedInfo.getSmoke());
            user.setIntroduce(updatedInfo.getIntroduce());
            //user.setTaxiTemperature(updatedInfo.getTaxiTemperature());  택시 온도 사용자가 수정 불가
            //user.setMatchingNote(updatedInfo.getMatchingNote());    매칭 기록 사용자가 수정 불가
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
