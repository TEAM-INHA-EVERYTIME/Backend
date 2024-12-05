// DTO 역할로써 클라이언트에게 정보 제공하는 클래스
package inhating.user.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {
    private Long id;
    private String userId;
    private String name;
    private String nickName;
    private Boolean gender;
    private LocalDateTime birth;
    private String major;
    private String MBTI;
    private String introduce;
    private int taxiTemperature;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.nickName = user.getNickName();
        this.gender = user.getGender();
        this.birth = user.getBirth();
        this.major = user.getMajor();
        this.MBTI = user.getMBTI();
        this.introduce = user.getIntroduce();
        this.taxiTemperature = user.getTaxiTemperature();
    }
}
