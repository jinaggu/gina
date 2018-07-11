package part01_xml;


//여기가 핵심로직을 가지고 있ㄴ을 거임.(이걸 타겟.이라고한다.)
public class ServiceImp implements Service{
	
	public ServiceImp() {
		
	}

	@Override
	public void prn1() {
		System.out.println("냥냥");
		
	}

	@Override
	public void prn1(int x) {
		System.out.println("x:"+x);
	}

	//인자 값 두개일때.
	@Override
	public void prn1(int a, int b) {
		System.out.printf("a:%d, b:%d\n",a,b);
		
	}

	@Override
	public void prn2() {
		System.out.println("prn2");
	}

	@Override
	public String prn3() { //여기서 리턴타입 변경해줬으면 service인터페이스에도 리턴타입 바꾸어 줘야한다.
		System.out.println("prn3");
		return "홍길동";
	}

	
	
	@Override
	public void prn4() {
		System.out.println("prn4");
		String data = "abcd";
		int num = Integer.parseInt(data);
		
	}

	
	//이형태가 많이 사용이 될것이다.
	//핵심로직이 처리되는 전후로 공통로직을 처리해줄때 어라운드를 써준다.
	@Override
	public void prn5() {
		System.out.println("prn5");
	}
	
	

}//end class
