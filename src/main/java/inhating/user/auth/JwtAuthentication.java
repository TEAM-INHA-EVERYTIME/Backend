package inhating.user.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthentication extends AbstractAuthenticationToken {

    private final String principal; // userId를 저장
    private final Object credentials;

    // 생성자
    public JwtAuthentication(String principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(true); // 인증 상태로 설정
    }

    @Override
    public Object getCredentials() {
        return credentials; // 비밀번호 또는 토큰
    }

    @Override
    public Object getPrincipal() {
        return principal; // userId 반환
    }
}
