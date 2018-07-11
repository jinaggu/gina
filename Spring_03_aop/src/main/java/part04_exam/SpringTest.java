package part04_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part04_exam/aop.xml");
		Service svc = (Service)context.getBean("svc");
		svc.prn();

	}//end main()//

}//end class//
