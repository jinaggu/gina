package part04_exam;

public class ServiceImp implements Service{
	
	
	//무인자 생성자 생성해놓는다!!!
	public ServiceImp() {
		
	}

	@Override
	public void prn() {
		int sum = 0;
		for (int i=0; i<100000000; i++) {
			sum+=i;
		}
		
		System.out.println("sum:"+sum);
	}//end prn()

}//end class//
