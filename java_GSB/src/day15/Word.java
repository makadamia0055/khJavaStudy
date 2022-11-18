package day15;

import java.util.ArrayList;



public class Word {

	private String word;
	private ArrayList<String> means = new ArrayList<String>() ;
	
	public Word(String word, String mean) {
		this.word = word;
		this.means.add(mean);
	}
	
	public void printMeans() {
		for(int i = 0; i<means.size(); i++) {
			System.out.println((i+1)+"번 : "+ means.get(i));
		}
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @return the means
	 */
	public ArrayList<String> getMeans() {
		return means;
	}





}



