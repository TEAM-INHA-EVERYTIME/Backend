package inhating.user.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserAddRequest {
    private String userId;
    private String pw;
    private String name;
    private String nickName;
    private Boolean gender;
    private LocalDateTime birth;
    private int number;
    private String image;
    private String major;
    private int studentNumber;
    private String MBTI;
    private int alcohol;
    private Boolean smoke;
    private String introduce;
    //private int taxiTemperature; 사용자 요청이 아닌 개별 로직 처리
    //private String matchingNote; 사용자 요청이 아닌 개별 로직 처리
}