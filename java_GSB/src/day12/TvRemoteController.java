package day12;

interface TvRemoteController{
	// 전원 켜기, 끄기/ 채널 변경(숫자), 채널변경(위아래)/볼륨업, 볼륨다운
	//void turnOn(); // tv클래스의 멤버를 이용할 것이라 매개변수 없음
	//void turnOff();
	
	// 혹은
	//void turn(boolean onOff);
	void turn(); // 하나의 메소드로 처리하기
	void channel(int channel);
	void channelUp();
	void channelDown();
	void volumeUp();
	void volumeDown();
	
	
	
	
}