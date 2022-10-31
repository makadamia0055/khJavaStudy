package day06;

public class  RandomClass01 {
int _max;
int _min;

	RandomClass01(int max, int min){
		this._max=max;
		this._min=min;
	}

	public int makeRan1() {
		int temp = (int) (Math.random() * (_max - _min + 1) + _min);
		return temp;
	}
	
}
