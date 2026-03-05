package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Spring에게 “여기서 객체(Bean)를 만들 거야” 라고 알려주는 클래스
@Configuration // 이걸 먼저 

//<context:component-scan base-package="myspring.di.annot" />
@ComponentScan(basePackages = {"myspring.di.annot"})

//<context:property-placeholder location="classpath:values.properties" />
@PropertySource(value = "classpath:values.properties")
public class HelloBeanConfig {
	
	public HelloBeanConfig() {
		System.out.println(this.getClass().getName() + "Config 클래스 기본 생성자 호출됨!");
	}
}
