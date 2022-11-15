package weekend_homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AccountServiceImp implements AccountService {

	public void insertItem(ArrayList<Item> list, Scanner scan) {
		System.out.print("1. 수입/2. 지출 여부 입력 :  ");
		int tmpIO=0;
		tmpIO=inputScan(tmpIO, 1, 2, "1과 2 중 하나를 입력해주십시오.");
		
		System.out.println("2. 기록할 "+ ((tmpIO==1)?"수입":"지출") +"을 어떻게 분류하시겠습니까?");
		String tmpSort = scan.next();
		scan.nextLine();
		
		System.out.println("3. 세부 내역을 기입해주십시오.");
		String tmpContents = scan.nextLine();
		
		System.out.println("4. "+ ((tmpIO==1)?"수입":"지출")+ "을 기입해주십시오");
		int tmpAmount = scan.nextInt();
		
		System.out.println("5.날짜를 기입해주십시오.");
		DataCal tmpDataCal = DataCal.getDate();
		
		Item tmpHK =new Item(tmpIO, tmpSort, tmpContents, tmpAmount, tmpDataCal);
		list.add(tmpHK);
		Collections.sort(list);
		
	} // 내역 리스트, 추가할 아이템
	public void printItem(ArrayList<Item> list) {
		
	} // 내역 리스트
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		return false;
		
	} // 내역 리스트, 몇번지, 수정할 아이템 // 리턴 수정 실패 혹은 성공 여부
	public boolean deleteItem(ArrayList<Item> list, int index) {
		return false;
		
	} // 내역 리스트, 볓번지 혹은 지울 아이템
	public void runMenu(ArrayList<Item> list, int menu, Scanner scan) {
		
	}
	public void printMenu() {
		
	}
	@Override
	public int inputScan(int tmp, int i, int j, String string) {
				Scanner scan =new Scanner(System.in);
			do {
				tmp=scan.nextInt();
				if(tmp>=i&&tmp<=j) {
					return tmp;
				}else {
					System.out.println(string);
				}
				
			}while(true);
			
			
			
			
		}		
	
	
	
	
	
	
}
