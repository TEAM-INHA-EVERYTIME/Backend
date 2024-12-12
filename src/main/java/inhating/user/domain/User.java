package inhating.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Table(name = "user")
@Setter
@Entity
@NoArgsConstructor
// 유지보수, 안전성 등의 이유로 DTO와 User.java와 엔티티 분리
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String pw;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "birth")
    private LocalDateTime birth;

    @Column(name = "number")
    private int number;

    @Column(name = "image")
    private String image;

    @Column(name = "major")
    private String major;

    @Column(name = "student_number")
    private int studentNumber;

    @Column(name = "mbti")
    private String MBTI;

    @Column(name = "alcohol")
    private int alcohol;

    @Column(name = "smoke")
    private Boolean smoke;

    @Column(name = "introduce", length = 1000)
    private String introduce;

    @Column(name = "taxi_temperature")
    private int taxiTemperature;

    @Column(name = "matching_note")
    private String matchingNote;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
