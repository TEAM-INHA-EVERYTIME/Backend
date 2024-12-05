package inhating.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//로그인 시 userId 매핑을 위한 클래스
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}