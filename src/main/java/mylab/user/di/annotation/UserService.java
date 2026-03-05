package mylab.user.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 이게 붙으면 Spring이 자동으로 객체 생성함.
@Component
public class UserService {
	// UserService가 다른 객체를 사용하기 때문
	//@Autowired : UserService 안에 SecurityService & UserRepository 자동 주입
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
    private SecurityService securityService;
        
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }
    
    public boolean registerUser(String userId, String name, String password) {
        if (securityService.authenticate(userId, password)) {
            return userRepository.saveUser(userId, name);
        }
        return false;
    }
}
