package inhating.user.domain;

import inhating.user.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequst {
    private String userId;
    private String pw;
}