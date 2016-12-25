package ccn.itcast.oa0909.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends BaseSpring {
	@Test
	public void testSessionFacoory() {
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");

	}
}
