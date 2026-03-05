package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class OrderSpringTest {
	ApplicationContext context = new GenericXmlApplicationContext("classpath:mylab-order-di.xml");
	
	@Test
	void testShoppingCart() {
		ShoppingCart shoppingCart = context.getBean("shoppingCart", ShoppingCart.class);
		
		assertNotNull(shoppingCart);
		assertEquals(2, shoppingCart.getProducts().size());
		assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
		assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
	}
	
	@Test
	void testOrderService() {
		//Spring 컨테이너에서 Bean을 가져오는 것 
		// getBean("Bean이름", 타입)
		OrderService orderService = context.getBean("orderService", OrderService.class);
		
		assertNotNull(orderService);
		double total = orderService.calculateOrderTotal();
		assertEquals(950000, total);
	}
}
