package inhating.user.service;

import inhating.user.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(UserAddRequest request) {
        User user = new User();
        mapAddRequestToEntity(user, request);
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, UserModifyRequest request) {
        User user = userRepository.findById(id)
        mapModifyRequestToEntity(user, request);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
        userRepository.delete(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
    }

    private void mapAddRequestToEntity(User user, UserAddRequest request) {
        user.setUserId(request.getUserId());
        user.setPw(request.getPw());
        user.setName(request.getName());
        user.setNickName(request.getNickName());
        user.setGender(request.getGender());
        user.setBirth(request.getBirth());
        user.setNumber(request.getNumber());
        user.setImage(request.getImage());
        user.setMajor(request.getMajor());
        user.setStudentNumber(request.getStudentNumber());
        user.setMBTI(request.getMBTI());
        user.setAlcohol(request.getAlcohol());
        user.setSmoke(request.getSmoke());
        user.setIntroduce(request.getIntroduce());
        user.setTier(request.getTier());
    }

    private void mapModifyRequestToEntity(User user, UserModifyRequest request) {
        Optional.ofNullable(request.getPw()).ifPresent(user::setPw);
        Optional.ofNullable(request.getName()).ifPresent(user::setName);
        Optional.ofNullable(request.getNickName()).ifPresent(user::setNickName);
        Optional.ofNullable(request.getBirth()).ifPresent(user::setBirth);
        Optional.ofNullable(request.getNumber()).ifPresent(user::setNumber);
        Optional.ofNullable(request.getImage()).ifPresent(user::setImage);
        Optional.ofNullable(request.getMajor()).ifPresent(user::setMajor);
        Optional.ofNullable(request.getStudentNumber()).ifPresent(user::setStudentNumber);
        Optional.ofNullable(request.getMBTI()).ifPresent(user::setMBTI);
        Optional.ofNullable(request.getAlcohol()).ifPresent(user::setAlcohol);
        Optional.ofNullable(request.getSmoke()).ifPresent(user::setSmoke);
        Optional.ofNullable(request.getIntroduce()).ifPresent(user::setIntroduce);
        Optional.ofNullable(request.getTier()).ifPresent(user::setTier);
    }
}