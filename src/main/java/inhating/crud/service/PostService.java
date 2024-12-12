package inhating.crud.service;

import inhating.crud.domain.Post;
import inhating.crud.domain.PostRepository;
import inhating.user.domain.User;
import inhating.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(Long userId, String title, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(user);
        post.setMajor(user.getMajor());
        post.setMbti(user.getMBTI());
        post.setSmoke(user.getSmoke());

        return postRepository.save(post);
    }

    public Post updatePost(Long postId, Long userId, String title, String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (!post.getAuthor().getId().equals(userId)) {
            throw new IllegalStateException("Only the author can update the post");
        }

        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (!post.getAuthor().getId().equals(userId)) {
            throw new IllegalStateException("Only the author can delete the post");
        }

        postRepository.delete(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }
}
