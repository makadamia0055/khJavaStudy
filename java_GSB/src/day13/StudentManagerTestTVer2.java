package day13;

import java.util.Scanner;

public class StudentManagerTestTVer2 {

	public static void main(String[] args) {
		/* 학생 성적 관리 프로그램을 작성하세요. 
		 * - 작성하기 위해 필요한 작업들을 주석으로 정리해보세요. 
		 * 1. 프로그램에 필요한 기능을 정리
		 * 메뉴
		 * 1. 학생 정보 추가
		 * 2. 학생 성적 추가
		 * 3. 학생 정보 출력
		 * 4. 프로그램 종료
		 * 
		 * 2. 프로그램 실행 과정은 어떻게 할 건지? 
		 * 기능
		 * 1. 학생정보 추가
		 *  - 학년, 반, 번호, 이름을 입력하여 학생 정보 추가
		 *  - 학년, 반, 번호가 같은 학생이 이미 있으면 추가하지 않음
		 * 2. 학생 성적 추가
		 *  - 학년, 반, 번호로 학생을 검색 한 후 있으면 성적을 추가
		 *  - 성적 추가시 과목명, 학기, 중간, 기말, 수행 평가를 입력하여 추가한다
		 *  - 이미 추가된 과목(학기랑 과목명이 같으면)이면 추가하지 않음
		 * 3. 학생 정보 출력
		 * 
		 * 3. 정보를 효율적으로 관리하기 위해 클래스를 만들것인가? 만든다면 어떤 클래스를 만들건지?
		 *  - 학생클래스 HighStudent
		 *  - 성적클래스 Score
		 * 
		 * 4. 프로그램 실행 과정을 주석으로 작성
		 * */
		Scanner scan = new Scanner(System.in);
		Student [] stds = new Student[30];
		int count = 0;
		//반복
		for( ; ; ) {
			//메뉴 출력
			System.out.println("------메뉴-----");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 성적 추가");
			System.out.println("3. 학생 정보 출력");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			//메뉴 선택
			int menu = scan.nextInt();
			
			//선택한 메뉴에 따른 기능 실행
			if(menu == 1) {
				System.out.println("1. 학생 정보 추가 기능 구현 예정");
				//1. 학생 정보 추가
				//학생 정보를 입력(학년, 반, 번호, 이름)
				System.out.println("추가할 학생 정보 입력");
				System.out.println("학년 : ");
				int grade = scan.nextInt();
				System.out.println("반 : ");
				int classNum = scan.nextInt();
				System.out.println("번호 : ");
				int num = scan.nextInt();
				System.out.println("이름 : ");
				String name = scan.next();
				System.out.println(grade+ "학년 " + classNum+ "반 "+ num+ "번 "+ name+ " 학생");
				
				//입력한 학생 정보가 없으면 추가
				//학생 정보들 중에서 하나씩 비교하여 학년, 반, 번호가 같은 학생이 있는지 확인후
				//없으면 마지막 학생 뒤에 추가해주기
				
				int index = -1; //학생정보가 있으면 몇번지에 있는지 알려주는
				Student tmp = new Student(grade, classNum, num);
				for(int i = 0; i<count; i++) {
					if(stds[i].equals(tmp)) {
						index = i;
					}
				}
				if(index==-1) {
					stds[count] = tmp; // tmp는 내가 만들었고 컨트롤 할 수 있는 위치에 있으니 얕은 복사해도 됨. 
					System.out.println(name+ "학생의 정보를 정상적으로 입력했습니다.");					// 조건문 끝나면 초기화도 되니.
				} else {
					System.out.println("이미 입력된 학생 정보입니다.");
				}
				
			}else if(menu == 2) {
				System.out.println("2. 학생 성적 추가 기능 구현 예정");
				//2. 학생 성적 추가
				//학생 정보를 입력(학년, 반, 번호)
				//입력한 학생 정보가 없으면 끝System.out.println("추가할 학생 정보 입력");
				System.out.println("학년 : ");
				int grade = scan.nextInt();
				System.out.println("반 : ");
				int classNum = scan.nextInt();
				System.out.println("번호 : ");
				int num = scan.nextInt();
				
				System.out.println(grade+ "학년 " + classNum+ "반 "+ num+ "번 ");
				int index = -1; //학생정보가 있으면 몇번지에 있는지 알려주는
				Student tmp = new Student(grade, classNum, num);
				for(int i = 0; i<count; i++) {
					if(stds[i].equals(tmp)) {
						index = i;
					}
				}
				if(index==-1) {
					continue;
				}
		
				//성적 정보를 입력(과목, 학기, 중간, 기말, 수행평가)
				System.out.println("성적 정보를 입력하세요.");
				
				System.out.println("과목 : " );
				String title = scan.next();
				System.out.println("학기 : " );
				int term = scan.nextInt();
				//과목 학기를 기반으로 해당 성적이 입력되어 있는지 확인
				System.out.println("중간 : " );
				int midScore = scan.nextInt();
				System.out.println("기말 : " );
				int finalScore = scan.nextInt();
				System.out.println("수행평가 : " );
				int performance = scan.nextInt();
				boolean res = stds[index].addScore(new Score(title, term, midScore, finalScore, performance));
				if(res) {
					System.out.println("성적을 등록했습니다.");
				stds[index].printScore();
				} else {
					System.out.println("성적 등록에 실패했습니다.");
				}
				//입력한 성적 정보가 없으면 추가
			}else if(menu == 3) {
				System.out.println("3. 학생 정보 출력 기능 구현 예정");
				//3. 학생 정보 출력
				//저장된 학생 정보를 출력
			}else if(menu == 4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못된 메뉴!!");
			}
			
			
			
			
		}
		
	}

}