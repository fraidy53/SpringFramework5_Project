package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // 컨테이너 객체 생성을 대신 해줌(컨테이너 생성)
@ContextConfiguration(locations = "classpath:hello-annot.xml")

public class HelloBeanSpringTest {
	// Spring이 관리하는 Bean을 그대로 테스트
	// Injection = Spring이 객체를 대신 만들어서 변수에 넣어주는 것
	@Autowired // getBean이랑 역할 동일
	HelloBean hello; // HelloBean을 인젝션해주기(매핑). Spring이 HelloBean 객체를 찾아서 hello 변수에 넣어라
	
	@Resource(name="stringPrinter")
	IPrinter printer; // 인젝션 만들어주기
	
	@Autowired
	HelloBeanCons helloCons;
	
	@Test
	void helloBeanSetter() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 어노테이션", printer.toString());
	}
	
	@Test
	void helloBeanCons() {
		assertEquals("Hello 생성자어노테이션", helloCons.sayHello());
		helloCons.print(); // consolePrinter는 print해주면 바로 콘솔에 나타남
	}
}
