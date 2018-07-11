package part01_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * AOP (Aspect Oriented Programming)
 * 1. AOP는 문제를 바라보는 관점을 기준으로 프로그래맹 하는 기법이다.
 * 2. AOP는 문제를 해결하기 위한 핵심관심사항과 전체에 적용되는 공통관심사항을 기준으로 프로그래밍함으로써 
 *    공통 모듈을 여러 코드에 쉽게 적용할수 있오록 해준다.
 * */




//교재에서 오토와이어 라는 어노테이션 주의! 자동적으로 맵핑이 되어진다 - 익숙하지 않은상태에서 아직쓰지 말자~~
//권장사항 아님.
public class SpringTest {

	public static void main(String[] args) {
		//먼저 aop.xml빈들을 컨테이너에 설정하고~~
		ApplicationContext context = new ClassPathXmlApplicationContext("part01_xml/aop.xml");
		
		Service svc = (Service) context.getBean("svc");
		//svc.prn1();
		
		//svc.prn1(10);
		//x:10 aop환경설정이 안되어있기떄문에 아직 그냥 인자값만 넘어간다.
		//인자값이 하나를 넘길때는 그 메소드 안에 (*) 
		
		//svc.prn1(20, 30);
		/*여기까지가 berfore 적용시키기.*/
		
		
		/*after적용시키기.*/
		//svc.prn2();
		//svc.prn3();
		
		/*try {
		svc.prn4(); } catch(Exception ex) {}*/
		
		svc.prn5();
		
		

		//처음에 라이브러리를 넣지 않았을때는 오류가 난다.
		//라이브러리를 메이븐에서 넣어주면 오류가 나지 않는다.
		
		// aop를 실행하려면 org.aspectj.weaver... 라이브러리가 있어야됨
	    // 1. http://mvnrepository.org/ 접속
	    // 2. 검색창에 'aspectj weaver' 입력
	    // 3. version 1.8.10 클릭(사용자가 많은 거 사용 // 버전을 가져올때도 조심히 가져와야됨)
	    // 4. Maven에 입력된 depen... 복사
	    // 5. pom.xml에  </dependencies> 바로 위에 삽입

	}//end main()//

}//end class
