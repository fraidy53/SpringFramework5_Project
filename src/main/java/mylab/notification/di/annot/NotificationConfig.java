package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 객체 생성 + 의존성 연결을 Spring이 대신 관리하게 만들기 위해서 만듦
// 이 클래스는 Spring 설정 파일
@Configuration
public class NotificationConfig {
	// Spring 컨테이너가 관리하는 객체(Bean)를 생성
	// EmailNotificationService 객체 생성 → Spring 컨테이너에 저장
	@Bean
    public EmailNotificationService emailNotificationService() {
		// 이 값은 생성자에 전달되는 값
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }
    
    // DI : Spring이 대신 객체를 만들고 필요한 곳에 넣어준다
    // Spring이 EmailNotificationService와 SmsNotificationService Bean을 먼저 생성하고 그 Bean들을 NotificationManager 생성자에
    // 주입해서 NotificationManager Bean을 만든다
    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailNotificationService(), smsNotificationService()); // 이 부분에서 DI 일어남
    }

}
