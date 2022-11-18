package day10;

import java.util.Scanner;
public class UpDownGameManager {

	public static void main(String[] args) {
			/* UpDown 게임을 구현하세요
			 *  
			 * 	반복문(조건 menu !=3)
			 * 	sysout 안내문 출력
			 * 		쇼메뉴
			 * 
			 * 	콘솔 입력 메뉴 받기
			 * 
			 * 런메뉴
			 * 
			 * 
			 * 1. 플레이
			 * 	업다운 메소드
			 * 		//임의의 수 1개 생성
			 * 		//반복		
			 * 		//입력 받기
			 * 		//입력과 비교(UP down 판별) 및 출력
			 * 		//카운트 ++
			 * 		//반복 종료
			 * 		//카운트 출력
			 *   	// 기존기록보다 좋으면 기록추가
			 *   
			 * 2. 기록확인
			 *  	// 기록된 순위를 출력
			 *  	// 
			 * 
			 * 3. 종료
			 */
		Scanner scan = new Scanner(System.in);

		int menu = 0;
		Record[] record = new Record[5];
		//디폴트 네임 코드
		
		record[0] = new Record(4, "곽정");
		record[1] = new Record(5, "양과");
		record[2] = new Record(6, "소용녀");
		record[3] = new Record(7, "구처기");
		record[4] = new Record(8, "윤지평");
		//
		
		do {
			printMenu("--------------", 
					"1. 플레이",
					"2. 기록확인", 
					"3. 종료",
					"--------------"
					  );
			menu = selectMenu(scan);
			runMenu(menu, record, scan);
			
		} while(menu!=3);
		
		
	}
	
	private static int runMenu(int menu, Record[] record, Scanner scan) {
		int count=0;

		switch(menu) {
		case 1:
			count = runGame();
			
			
			int i;
			String tmpName =null;
			for(i = 0; i <record.length ; i++) {
				if(record[i]==null||record[i].getCount()>count) {
					System.out.println("신기록 수립. 이름 입력");
					tmpName = scan.next();
					getNewRecord(record, count, i, tmpName);
					break;
				} else {
					
				} 
				
			}
			
			
			// 메소드 밖으로 빼줘야 메소드 종료후 기록이 안날라감
			// 이건 Record[] 받아서 입력, 변형해주기때문에 안날라가긴 함
			
			break;
		
		case 2:
			for(int j = 0; j <record.length; j++) {
				if(record[j]!=null) {
				System.out.print((j+1)+"등 : ");
				record[j].print();
				} else {
					System.out.println("저장된 기록이 없습니다.");
					break;
				}
			}
			break;
		
		case 3:
			
			break;
		}
		
		return count;
		
		
	}
	
	/**
	 * 기록정보보다 사용자 기록이 좋으면 기록을 추가하는 메소드
	 * @param record 기록정보
	 * @param tryCount 사용자 기록
	 */
	// 강사님 코드
	private static void writeRecord(Record[] records, int tryCount) {
		int index = 0; // 처음에는 저장 안되는 값으로 초기화
		for(int i = 0; i<records.length; i++) {
			//1등부터 비교하여 내 순위가 좋으면 내 순위가 밀림
			if(records[i] != null&& tryCount >=records[i].getCount()) {
				index++;
			} else if(records[i]==null){
				index = i;
				break;
				
			} else {// 코드 위랑 통합 가능하나 의미상 분리
				index = i;
				break;
			}
		}
	if(index==5) {//순위 바깥이면
	return ;
	
	}
	System.arraycopy(records,  index,  records,  index+1,  records.length -index -1);
	// 어레이 카피 기능으로 한칸씩 밀린 배열을 만듦.
	System.out.println("이름을 입력해주세요.");
	Scanner scan = new Scanner(System.in);
	String name = scan.next();
	records[index]= new Record(tryCount, name);
	
	
	}
	
	

	private static void getNewRecord(Record[] record, int count, int i, String tmpName) {
		if(record[i]!=null&&record[i].getCount() != count) {
			for(int j = 0 ; j <=3-i ; j++) {
				record[4-j]=record[3-j];
			}
			Record tmpRecord = new Record(count, tmpName);
			record[i] = tmpRecord;				
			
		} else if(record[i].getCount() == count) {
			// 동점 처리
			for(int j = 3-(i+1) ; j >=0 ; j--) {
				record[j+1]=record[j];
			}
			Record tmpRecord = new Record(count, tmpName);
			record[i+1] = tmpRecord;
			
		}else {
			Record tmpRecord = new Record(count, tmpName);
			record[i] = tmpRecord;
		}
		
	}

	public static int random(int min, int max) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
	/**
	 * 고정된 메뉴를 출력하는 메소드
	 * @param strs
	 */
	public static void printMenu(String ...strs) {
		for(int i = 0; i<strs.length; i++) {
			System.out.print(strs[i]);
			if(i!=strs.length) {
				System.out.println();
			}
		}
	}
	/**
	 * 콘솔에서 정수를 입력받아 입력받은 정수를 알려주는 메소드
	 * @param scan
	 * @return
	 */
	public static int selectMenu(Scanner scan) {

		int menu = scan.nextInt(); 
		return menu;
	}
	public static int runGame() {
		int comNum, min = 1, max = 9;
		Scanner scan = new Scanner(System.in); 
		comNum = random(min, max);
		System.out.println(comNum);
		 int myNum = 0;
		 int count = 0;
		 do {
			 System.out.println(min+"과"+max+"사이의 정수를 입력해주세요.");
			myNum = scan.nextInt();
			if(myNum<min||myNum>max) {
				System.out.println("올바른 숫자를 입력해주세요.");
			} else {
				count++;
				if(myNum>comNum) {
					System.out.println("Down");
				} else if(myNum<comNum) {
					System.out.println("Up");
				} else {
					System.out.println("정답입니다.");
				}
			}
		 } while(comNum!=myNum);
		 System.out.println(count+"회 만에 맞혔습니다.");
	return count;
	}

}
