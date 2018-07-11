package part04_exam;

import org.aspectj.lang.ProceedingJoinPoint;

public class StopWatchAspect {
	
	public void process(ProceedingJoinPoint point) {
		long start = System.currentTimeMillis();
		//시작시간 받아오기.
		
		try {
			point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		//proceed해서 실행되는 메소드 (핵심로직이 구현되어있는 메소드.)
		String time = point.getSignature().getName()+
				"메서드 실행시간:" + (end - start);
		System.out.println(time);
	}//end process()

}
