package day10;

public class Player {

private String rcdName;
private int rcdScore;
private int index;

public Player() {
	
}
public Player(String name, int score) {
	this.rcdName = name;
	this.rcdScore = score;
}



public String getRcdName() {
	return rcdName;
}
public void setRcdName(String rcdName) {
	this.rcdName = rcdName;
}
public int getRcdScore() {
	return rcdScore;
}
public void setRcdScore(int rcdScore) {
	this.rcdScore = rcdScore;
}

public void setRcdByUser(Player player) {
	this.rcdName = player.rcdName;
	this.rcdScore = player.rcdScore;
}



}
