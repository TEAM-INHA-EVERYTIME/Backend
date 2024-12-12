package inhating.crud.domain;

import inhating.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    private String major;
    private String mbti;
    private Boolean smoke;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // 생성자 추가
    public Post(String title, String content, User author, String major, String mbti, Boolean smoke) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.major = major;
        this.mbti = mbti;
        this.smoke = smoke;
    }
}
