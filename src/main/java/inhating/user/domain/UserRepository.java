package inhating.user.domain;

import inhating.user.*;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}