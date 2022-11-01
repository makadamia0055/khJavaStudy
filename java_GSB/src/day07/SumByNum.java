package day07;

public class SumByNum {
private int _start;
private int _end;
private int _n;


SumByNum(int start, int end, int n){
	this._start = start;
	this._end = end;
	this._n = n;
	
}


public int get_start() {
	return _start;
}


public void set_start(int _start) {
	this._start = _start;
}


public int get_end() {
	return _end;
}


public void set_end(int _end) {
	this._end = _end;
}


public int get_n() {
	return _n;
}


public void set_n(int _n) {
	this._n = _n;
}

public int sumByNum() {
	if(_start>_end) {
		int tmp = _start;
		_start = _end;
		_end = tmp;
	}
	int sum = 0;
	for(int i = _start; i<=_end; i+=_n) {
		sum+=i;
	}
	return sum;
}


public int sumByNum(int init, int end, int n) {
	if(init>end) {
		int tmp = init;
		init = end;
		end = tmp;
	}
	int sum = 0;
	for(int i = init; i<=end; i+=n) {
		sum+=i;
	}
	return sum;
}
public int sumByNum(int init, int end) { //메소드 오버로딩
	if(init>end) {
		int tmp = init;
		init = end;
		end = tmp;
	}
	int sum = 0;
	for(int i = init; i<=end; i++) {
		sum+=i;
	}
	return sum;
}

public int sumByCount(int init, int count, int n) {
	int sum = 0;
	for(int i= init; i<=init+(count)*n; i+=n) {
		sum+=i;
		
	}
	return sum;
}
public int sumByCount(int init, int count) {
	int sum = 0;
	for(int i= init; i<=init+(count); i++) {
		sum+=i;
		
	}
	return sum;
}
	
	
	
}
