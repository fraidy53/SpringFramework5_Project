package mylab.user.di.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // 컨테이너 객체 생성을 대신 해줌(컨테이너 생성)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	void testUserService() {
		assertNotNull(userService);
		
		assertNotNull(userService.getUserRepository());
		
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		
		assertNotNull(userService.getSecurityService());
		
		assertTrue(userService.registerUser("test01", "홍길동", "1234"));
	}
}
