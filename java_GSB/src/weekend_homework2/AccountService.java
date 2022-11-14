package weekend_homework2;

import java.util.ArrayList;
import java.util.Scanner;

public interface AccountService {
	void insertItem(ArrayList<Item> list, Item item); // 내역 리스트, 추가할 아이템
	void printItem(ArrayList<Item> list); // 내역 리스트
	boolean updateItem(ArrayList<Item> list, int index, Item item); // 내역 리스트, 몇번지, 수정할 아이템 // 리턴 수정 실패 혹은 성공 여부
	boolean deleteItem(ArrayList<Item> list, int index); // 내역 리스트, 볓번지 혹은 지울 아이템
	void runMenu(ArrayList<Item> list, int menu, Scanner scan);
	void printMenu();
	
}
