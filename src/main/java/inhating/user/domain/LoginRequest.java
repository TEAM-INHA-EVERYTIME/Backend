package inhating.user.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    private String userId;
    private String pw;
}