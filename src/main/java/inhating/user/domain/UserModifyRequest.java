package inhating.user.domain;

import inhating.user.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsContructor
public Class UserModifyRequest {
    private String userId;
    private String pw;
    private String name;
    //private Boolean gender; 변경 불가
    private LocalDate birth;
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