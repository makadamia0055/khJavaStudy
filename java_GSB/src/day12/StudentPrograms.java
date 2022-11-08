package day12;

import java.util.Arrays;
import java.util.Scanner;
import day12.*;
public class StudentPrograms {

	public HighStudent[] HSArray = new HighStudent[0];

	
	public void printMenu() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 성적 출력");
		System.out.println("4. 종료");
		System.out.println("-----------------");
		System.out.println();
		
	}

	
	public int selectMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택해주세요 : ");
		int menu;
		do {
		menu = scan.nextInt();
		if(menu<1||menu>4) {
			System.out.println("잘못된 입력입니다.");
		} else {
			break;
		}
		}while(true);
				
		return menu;
	}

	
	public void run(int menu) {
		
		int grade, classnum, stdnum;
		String subject;
		int semester;
		Scanner scan = new Scanner(System.in);
		HighStudent tmp;

		switch(menu) {
		case 1: // 학생 정보 추가
			System.out.println("학생 정보를 추가합니다.");
			System.out.println("학년, 반, 번호, 이름 순으로 입력해주십시오.");
			String name;
			grade = scan.nextInt();
			classnum = scan.nextInt();
			stdnum = scan.nextInt();
			name = scan.next();
			
			tmp = new HighStudent(grade, classnum, stdnum, name);
			if(findStd(tmp)!=null) {
				System.out.println("이미 해당 학생이 존재합니다.");
				System.out.println("초기메뉴로 돌아갑니다.");
				
				break;
			} else {
			HighStudent[] tmpHSArray = new HighStudent[HSArray.length+1];
			//어레이 복사 해야됨.
			System.arraycopy(HSArray, 0, tmpHSArray, 0, HSArray.length);
			//
			tmpHSArray[tmpHSArray.length-1] = tmp;
			HSArray=tmpHSArray;
			System.out.printf("%d학년 %d반 %d번 %s학생이 정상적으로 저장되었습니다.\n", grade, classnum, stdnum, name);
			break;
			}
		case 2: // 학생 성적 추가
			System.out.println("학생 성적을 추가합니다.");
			System.out.println("성적을 입력할 학생의 학년, 반, 번호를 입력해주세요.");
			grade = scan.nextInt();
			classnum = scan.nextInt();
			stdnum = scan.nextInt();
			if(findStd(grade, classnum, stdnum)!=null) {
				// 성적 추가 메소드
				tmp = findStd(grade, classnum, stdnum);
				System.out.printf("%d학년 %d반 %d번 %s학생의 성적을 입력합니다.\n", grade, classnum, stdnum, tmp.getStdName());
				System.out.println("과목명, 학기를 차례로 입력해주십시오.");
				subject = scan.next();
				semester = scan.nextInt();
				//중복 판별 메소드
				System.out.println(subject+semester);
				if(tmp.findScore(subject, semester)==null) {
					
					Score tmpScore = new Score(subject, semester);
					System.out.println(subject+"과목의 " + semester + "학기 성적을 입력해주십시오.");
					System.out.println("중간, 기말, 수행평가 순으로 입력해주십시오.");
					int midscore = scan.nextInt();
					int fnlscore = scan.nextInt();
					int pfas = scan.nextInt();
					tmpScore.setMidScore(midscore);
					tmpScore.setFinalScore(fnlscore);
					tmpScore.setPfas(pfas);
					
					
					Score [] tmpScoreArray = new Score[tmp.getStdScores().length+1];
					System.arraycopy(tmp.getStdScores(), 0, tmpScoreArray, 0, tmp.getStdScores().length);
					tmpScoreArray[tmpScoreArray.length-1] = tmpScore;
					tmp.setStdScores(tmpScoreArray);
					
					System.out.printf("%s학생의 %d 학기 %s 과목 성적이 정상적으로 입력되었습니다. ", tmp.getStdName(), semester, subject);
					
				} else {
					System.out.println("해당 "+semester+"학기 "+subject+"과목의 성적이 이미 존재합니다.");
					
				}
				//
				
				
				
			} else {
				System.out.println("해당 학생이 존재하지 않습니다.");
				System.out.println("초기메뉴로 돌아갑니다.");
			}
			break;
			
			
		case 3://학생 정보 출력
			
			if(HSArray.length==0) {
				System.out.println("입력된 학생이 없습니다.");
			} else {
				for(HighStudent j: HSArray) {
					j.printInfo();
					
					}
			}
			break;
		case 4: //종료
			break;
			default:
				System.out.println("잘못된 접근 입니다.");
		}
	}
	
	

	/**
	 * 
	 * @param hsArray 학생 Array를 입력받음
	 * @param grade
	 * @param classnum
	 * @param stdnum
	 * @return
	 */
	public HighStudent findStd(int grade, int classnum, int stdnum) {
		HighStudent temp = new HighStudent(grade, classnum, stdnum, "temp");
		HighStudent rst =null;
		for(HighStudent tmp1 : HSArray) {
			if(temp.equals(tmp1)) {
				rst = tmp1;
			}
		}
		return rst;
		}
	public HighStudent findStd(HighStudent temp) {
		HighStudent rst =null;
		for(HighStudent tmp1 : HSArray) {
			if(temp.equals(tmp1)) {
				rst = tmp1;
			}
		}
		return rst;
		}
	
	
	
}
