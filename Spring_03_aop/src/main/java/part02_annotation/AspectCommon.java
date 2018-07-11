package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.jdbc.Expectation;



//공통로직만 구현해놓은 클래스 - 공통관점
@Aspect     //공통 로직으로 사용하겠다는소리이다.@Aspect
public class AspectCommon {

	public AspectCommon() {

	}

	//환경설정을 여기서 할것이다. (xml파일에서 잡아준것.)
	@Before("execution(* part02_annotation.ServiceImp.prn1(..))") 
	//벨류 하나기때문에 별도로 필요 없고 익스큐션 쌍따옴표 안에있는걸로 설정하면 된다.
	public void comm1() {
		System.out.println("before");
	}

	// after적용시킬것
	@After("execution(* part02_annotation.ServiceImp.prn2(..))")
	public void comm2() {
		System.out.println("after");
	}

	
	
	// aop 안에있는 이름이 매개변수 이름이랑 똑같아야 한다.
	@AfterReturning(value="execution(* part02_annotation.ServiceImp.prn3(..))", returning="name")
	//이땐 벨류/ 리터닝 속성에도 값이 들어가기 때문에 벨류라는거 써주고 
	//매개변수명이 name이었으니까 
	public void comm3(String name) {
		System.out.println("comm3:" + name);
	}

	
	@AfterThrowing(value="execution(* part02_annotation.ServiceImp.prn4(..))", throwing="ex")
	//익셉션 받기위한 변수 ex로 설정해놨으니까  throwing="ex"
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
	@Around("execution(* part02_annotation.ServiceImp.prn5(..))") //벨류라는 속성만 지정하면 되기때문에 굳이 value이렇게 안써줘도 됌
	public void comm5(ProceedingJoinPoint point) {
		//공통로직이 먼저 처리가 되고
		System.out.println("comm5 start");
		
		//v포인트에 있는 매개변수 호출해서 넘겨ㅈ면됨.
		try {
			
			
			//쓰로즈 선언되어있어서 예외처리 해주고, 여기서는 제어권이 핵심로직이 구현되어있는 곳으로 넘어간 것이다.
			point.proceed(); //핵심기능을 호출하는 기능.
			
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		 
		 System.out.println("comm5 end");
		
	}//end comm5

}// end class
