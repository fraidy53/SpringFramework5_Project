package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
public class StringPrinterBean implements IPrinter {
	public StringPrinterBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}
	private StringBuffer buffer = new StringBuffer();

	public void print(String message) {
		this.buffer.append(message);
	}
	
	public String toString() {
		return this.buffer.toString();
	}
}
