package inhating.crud.controller;
import inhating.user.util.JwtTokenProvider;
import inhating.crud.domain.Post;
import inhating.crud.domain.PostRequestDto;
import inhating.crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDto requestDto) {
        // SecurityContextHolder에서 토큰을 가져와 사용자 ID 추출
        String token = JwtTokenProvider.getTokenFromSecurityContext();
        Long userId = Long.parseLong(JwtTokenProvider.getUserIdFromToken(token));
        Post post = postService.createPost(userId, requestDto.getTitle(), requestDto.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id,
                                           @RequestBody PostRequestDto requestDto) {
        String token = JwtTokenProvider.getTokenFromSecurityContext();
        Long userId = Long.parseLong(JwtTokenProvider.getUserIdFromToken(token));
        Post post = postService.updatePost(id, userId, requestDto.getTitle(), requestDto.getContent());
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        String token = JwtTokenProvider.getTokenFromSecurityContext();
        Long userId = Long.parseLong(JwtTokenProvider.getUserIdFromToken(token));
        postService.deletePost(id, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
}