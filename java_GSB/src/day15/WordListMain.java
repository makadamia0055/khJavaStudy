package day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import interfacePractice01.SampleInplementsClass;
public class WordListMain {

	public static void main(String[] args) {
		/* 영어 단어장 프로그램을 구현하세요.
		 * 메뉴 
		 * 1. 단어 추가
		 * 2. 단어 확인
		 * 3. 단어 수정
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴선택 : 1
		 * 단어 : apple // 한단어 , 공백입력 x
		 * 뜻 : 사과 // 한문장
		 * 2. 단어 확인
		 * 검색할 단어 입력 : apple
		 * 뜻 : 사과
		 */
		int menu =0;
		int min = 1, max = 5;
		SampleInplementsClass SIC = new SampleInplementsClass();
		ArrayList<Word> wordList = new ArrayList<Word>();
		
		do {
			SIC.printMenu("1. 단어 추가\n"
					+ "2. 단어 확인\n"
					+ "3. 단어 수정\n"
					+ "4. 단어 삭제\n"
					+ "5. 종료\n");
			try {	
			menu = SIC.selectMenu(min, max);
			runMenu(menu, wordList);
			}catch(Exception e) {
				
			}
		}while(menu !=5);
	}

	private static void runMenu(int menu, ArrayList<Word> wordList) throws Exception {
		switch(menu) {
		case 1:
			insertWord(wordList);
			break;
			
		case 2:
			showWord(wordList);
			printWord(wordList);
			break;
			
		case 3: 
			showWord(wordList);
			updateWord(wordList);
			break;
			
		case 4 : 
			showWord(wordList);
			deleteWord(wordList);
			
			break;
			
		case 5 : 
			System.out.println("프로그램 종료");
			break;
			
			default: throw new Exception("잘못된 메뉴를 선택했습니다.");
		}
		
	}

	private static void deleteWord(ArrayList<Word> wordList) throws Exception {
		if(wordList==null||wordList.size()==0) {
			throw new Exception("단어장이 비었습니다");

		}
		Scanner scan = new Scanner(System.in);
		Word tmpWordClass;
		System.out.println("확인할 단어의 스펠링을 입력해주세요.");
		System.out.print("단어 입력 : ");
		String tmpWord = scan.next();
		scan.nextLine();
		if(findWordBySpell(wordList, tmpWord)!=null) {
		tmpWordClass = findWordBySpell(wordList, tmpWord);
		tmpWordClass.printMeans();
		}else {
			throw new Exception("입력하신 단어가 존재하지 않습니다.");
			
		}
		
		System.out.println("삭제할 번호를 입력해주세요.");
		int num = scan.nextInt();
		// 예외 발생
		String tmptmpmean = tmpWordClass.getMeans().get((int)(num-1));
		tmpWordClass.getMeans().remove((int)(num-1));
		System.out.println(num + "번 "+ tmptmpmean + "가 성공적으로 삭제되었습니다.");
	}

	private static void updateWord(ArrayList<Word> wordList) throws Exception {
		if(wordList==null||wordList.size()==0) {
			throw new Exception("단어장이 비었습니다");

		}
		Scanner scan = new Scanner(System.in);
		Word tmpWordClass ;
		System.out.println("확인할 단어의 스펠링을 입력해주세요.");
		System.out.print("단어 입력 : ");
		String tmpWord = scan.next();
		scan.nextLine();
		if(findWordBySpell(wordList, tmpWord)!=null) {
		tmpWordClass = findWordBySpell(wordList, tmpWord);
		tmpWordClass.printMeans();
		}else {
			throw new Exception("입력하신 단어가 존재하지 않습니다.");
			
		}
		
		System.out.println("수정할 번호를 입력해주세요.");
		int num = scan.nextInt();
		scan.nextLine();
		// 예외 발생
		String tmptmpmean = tmpWordClass.getMeans().get((int)(num-1));
		
		System.out.println("새로운 뜻을 입력해주세요.");
		String newMean = scan.nextLine();
		tmpWordClass.getMeans().set((int)(num-1), newMean);
		System.out.println(num + "번 "+ tmptmpmean + "가 "+newMean+"으로 수정되었습니다.");
		
	}

	private static void printWord(ArrayList<Word> wordList) throws Exception {
		if(wordList==null||wordList.size()==0) {
			throw new Exception("단어장이 비었습니다");
			
		}
		Scanner scan = new Scanner(System.in);

		System.out.println("확인할 단어의 스펠링을 입력해주세요.");
		System.out.print("단어 입력 : ");
		String tmpWord = scan.next();
		scan.nextLine();
		if(findWordBySpell(wordList, tmpWord)!=null) {
		Word tmpWordClass = findWordBySpell(wordList, tmpWord);
		tmpWordClass.printMeans();
		
		}else {
			throw new Exception("입력하신 단어가 존재하지 않습니다.");
		}
	}

	private static void insertWord(ArrayList<Word> wordList) {
		
		Scanner scan = new Scanner(System.in);
		Word tmpWordClass;
		System.out.println("추가할 단어의 스펠링을 입력해주세요");
		String tmpWord = scan.next();
		scan.nextLine();
		
		if(findWordBySpell(wordList, tmpWord)!=null) {
		 System.out.println(tmpWord + "는 이미 등록된 단어 입니다.\n새로운 뜻을 추가하시겠습니까");
		 System.out.print("Y/N :");
		 char tmpch = scan.next().charAt(0);
		 scan.nextLine();
		 if(tmpch=='N'||tmpch=='n') {
			return;
		 }
		}
			System.out.println("추가할 단어 "+tmpWord+"의 뜻을 입력해 주세요.");
			String tmpMean = scan.nextLine();
			if(findWordBySpell(wordList, tmpWord)==null) {
			tmpWordClass = new Word(tmpWord, tmpMean); 
			wordList.add(tmpWordClass);
			System.out.println("단어 "+ tmpWord +": ("+ tmpMean +")를 성공적으로 입력했습니다.");
			} else {
				tmpWordClass = findWordBySpell(wordList, tmpWord);
				tmpWordClass.getMeans().add(tmpMean);
				System.out.println("단어 "+ tmpWord +": ("+ tmpMean +")를 성공적으로 입력했습니다.");

			}
			scan.close();
		
	}

	public static Word findWordBySpell(ArrayList<Word> wordList, String spell) {
	Iterator<Word> it = wordList.iterator();
	while(it.hasNext()) {
		Word tmp = it.next();
		if(tmp.getWord().equals(spell)) {
			return tmp;
		}
	}

	return null;
}
	
	public static void showWord(ArrayList<Word> wordList) {
		System.out.println("입력된 단어 리스트 : ");
		System.out.println("----------------");
		for(int i =0 ; i < wordList.size(); i++) {
			System.out.print("\'"+wordList.get(i).getWord()+"\'"+ " ");
		}
		System.out.println();
		System.out.println("----------------");
		
		
	}
	
	
	
	
}
