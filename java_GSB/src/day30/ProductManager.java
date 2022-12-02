package day30;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProductManager {
	private ArrayList<Product> productList = new ArrayList<Product>();
	private ArrayList<ProductLedger> pldList = new ArrayList<ProductLedger>();
	private Scanner scan = new Scanner(System.in);
//	 제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
//	 * - 제품 수정
//	 * - 제품 삭제
//	 * - 제품 구매(입고)
//	 * - 제품 판매(출고)
	
	
	public Product scanProduct() {
		System.out.println("제품 분류 : ");
		String sort = scan.nextLine();
		System.out.println("제품 명 : ");
		String name = scan.nextLine();
		System.out.println("구매 가격 : (원)");
		int inprice = scan.nextInt();
		System.out.println("판매 가격 : (원)");
		int outprice = scan.nextInt();
		
		System.out.println("제품 현 재고");
		int amount = scan.nextInt();
		
		Product tmp = new Product(sort, name, amount, inprice, outprice);
		return tmp;
	}
	public Product scanPdct() {
		System.out.println("제품 분류 : ");
		String sort = scan.nextLine();
		System.out.println("제품 명 : ");
		String name = scan.nextLine();
		
		
		Product tmp = new Product(sort, name);
		return tmp;
	}
	
	
	public void addProduct() {
		Product tmp = scanProduct();
		if(productList.contains(tmp)) {
			System.out.println("이미 등록된 제품입니다.");
			return ; // 추후 갱신할건지 물어보기
		}
		productList.add(tmp);
	}
	public void editProduct() {
		Product tmp = scanPdct();
		int index = productList.indexOf(tmp);
		if(index==-1) {
			System.out.println("존재하지 않는 제품입니다.");
			return ; 
		}
		tmp = scanProduct();
		productList.set(index, tmp);
		System.out.println("수정을 완료했습니다.");
	}
	public void deleteProduct() {
		Product tmp = scanPdct();
		int index = productList.indexOf(tmp);
		if(index==-1) {
			System.out.println("존재하지 않는 제품입니다.");
			return ; 
		}
		productList.remove(index);
		System.out.println("삭제가 완료되었습니다.");
	}
	
	public Date scanDate() {
		System.out.println("날짜 입력 : yyyyMMdd");
		String str = scan.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			Date tmpDate = format.parse(str);
			return tmpDate;
		} catch (ParseException e) {
			System.out.println("날짜 입력 형식이 틀렸습니다.");
			return null;
		}
		
	}
	
	
	public void inOutProduct() {
	System.out.println("입고할 물품 검색");
	Product tmp = scanPdct();
	int index = productList.indexOf(tmp);
	if(index==-1) {
		System.out.println("존재하지 않는 제품입니다.");
		return ; 
	}
	
	Date tmpDate = scanDate();
	int ledgerIndex = -1;
	for(ProductLedger tmpLedger : pldList) {
		if(tmpLedger.getDate()==tmpDate) {
			ledgerIndex = pldList.indexOf(tmpLedger);
			break;
		}
	}
	if(ledgerIndex!=-1) {
		//여기서 또 장부 있는지 찾아야함.
	}
		
	
	System.out.println("입고량 : ");
	int inAmount = scan.nextInt();
	System.out.println("출고량 : ");
	int outAmount = scan.nextInt();
	
		
	}
}
