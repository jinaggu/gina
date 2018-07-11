package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.jdbc.Expectation;



//공통로직만 구현해놓은 클래스 - 공통관점
public class AspectCommon {

	public AspectCommon() {

	}

	// before적용시킬것
	public void comm1() {
		System.out.println("before");
	}

	// after적용시킬것
	public void comm2() {
		System.out.println("after");
	}

	// aop 안에있는 이름이 매개변수 이름이랑 똑같아야 한다.
	public void comm3(String name) {
		System.out.println("comm3:" + name);
	}

	public void comm4(Expectation ex) {
		if (ex != null) {
			System.out.println(ex.toString()); // ex를 스트링 값으로 변화시켜주는 toString메소드.
		}
	}
	
	
	/*핵심로직을 구현해 높은 빈(클래스) : Target
	 * Target에 구현된 메소드 : JoinPoint
	 * JoinPoint에 실행해야될 위치 : Pointcut
	 * */
	//인자값에다가 핵심로직이 구현되어있는 메소드에 대한 정보를 받아와야한다.(ProceedingJoinPoint point)
	public void comm5(ProceedingJoinPoint point) {
		//공통로직이 먼저 처리가 되고
		System.out.println("comm5 start");
		
		//포인트에 있는 매개변수 호출해서 넘겨주면됨.
		try {
			
			
			//쓰로즈 선언되어있어서 예외처리 해주고, 여기서는 제어권이 핵심로직이 구현되어있는 곳으로 넘어간 것이다.
			point.proceed(); //핵심기능을 호출하는 기능.
			
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		 
		 System.out.println("comm5 end");
		
	}//end comm5

}// end class
