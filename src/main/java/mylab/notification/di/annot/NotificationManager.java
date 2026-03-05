package mylab.notification.di.annot;

public class NotificationManager {
	private NotificationService emailService;
    private NotificationService smsService;
    
    public NotificationManager(EmailNotificationService emailNotificationService, SmsNotificationService smsNotificationService) {
        this.emailService = emailNotificationService;
        this.smsService = smsNotificationService;
    }
    
    public NotificationService getEmailService() { return emailService; }
    public NotificationService getSmsService() { return smsService; }
    
    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }
    
    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}
