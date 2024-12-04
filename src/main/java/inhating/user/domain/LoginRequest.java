package inhating.user.domain; // 실제 패키지에 맞게 수정하세요

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userId; // JSON에서 매핑될 필드
    private String pw;     // JSON에서 매핑될 필드
}
