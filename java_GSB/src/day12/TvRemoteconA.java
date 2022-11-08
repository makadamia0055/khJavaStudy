package day12;

public class TvRemoteconA implements TvRemoteController {
private boolean power;
private int channel;
private int volumn;

private final int MAX=30;
private final int MIN=0;
	
	
	
	@Override
	public void turn() {
		this.power= !power; //지금 상태의 반대 = ! 연산자
	}

	@Override
	public void channel(int channel) {
		if(!power) {
			return;
		}
		this.channel = channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void channelUp() {
		if(!power) {
			return;
		}
	channel++;
	System.out.println("채널 : " + channel);

	}

	@Override
	public void channelDown() {
		if(!power) {
			return;
		}
		channel--;
		channel = channel<1? 999:channel;
		System.out.println("채널 : " + channel);


	}

	@Override
	public void volumeUp() {
		if(!power) {
			return;
		}
		volumn++;
		volumn = volumn>MAX? MAX: volumn;
		System.out.println("볼륨 : " + volumn);

	}

	@Override
	public void volumeDown() {
		if(!power) {
			return;
		}
		volumn--;
		volumn = volumn<MIN? MIN: volumn;
		System.out.println("볼륨 : " + volumn);

	}
	public void print() {
		System.out.println("전원 : " + (power ? "ON" : "OFF"));
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volumn);
	}

}
