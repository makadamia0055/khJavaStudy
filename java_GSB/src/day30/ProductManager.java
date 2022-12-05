package day30;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import day30.ProductLedger.ItemInOut;
import lombok.Data;
@Data
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
		scan.nextLine();
		
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
	
	
	public boolean addProduct() {
		Product tmp = scanProduct();
		if(productList.contains(tmp)) {
			System.out.println("이미 등록된 제품입니다.");
			return false; // 추후 갱신할건지 물어보기
		}
		productList.add(tmp);
		return true;
	}
	public boolean editProduct() {
		Product tmp = scanPdct();
		int index = productList.indexOf(tmp);
		if(index==-1) {
			System.out.println("존재하지 않는 제품입니다.");
			return false ; 
		}
		System.out.println();
		System.out.println("수정할 제품 정보를 입력해주십시오.");
		tmp = scanProduct();
		productList.set(index, tmp);
		return true;
	}
	public boolean deleteProduct() {
		Product tmp = scanPdct();
		int index = productList.indexOf(tmp);
		if(index==-1) {
			System.out.println("존재하지 않는 제품입니다.");
			return false; 
		}
		productList.remove(index);
		return true;
	}
	
	public Date scanDate() {
		Scanner scan = new Scanner(System.in);
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

	public String printDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String tmpDateFormat = format.format(date);
		return tmpDateFormat;
		
		
	}
	
	
	public boolean addInOutProduct() {
	System.out.println("입고 대장을 수정할 물품 검색");
	Product tmp = scanPdct();
	int index = productList.indexOf(tmp);
	if(index==-1) {
		System.out.println("존재하지 않는 제품입니다.");
		return false; 
	}else {
		tmp = productList.get(index);
	}
	System.out.println("입력할 일지 날짜를 입력합니다.");

	Date tmpDate = scanDate();

	int ledgerIndex = findLedgerByDate(tmpDate);
	
	if(ledgerIndex!=-1) { // 일자가 있을 때 
		ProductLedger dateLedger=pldList.get(ledgerIndex);
		int productIndex = dateLedger.findProductInLedge(tmp);
		if(productIndex==-1) { // 해당 품목의 출고대장이 없을때.
			System.out.println(tmp.getName()+"의 "+ printDate(dateLedger.getDate()) + " 일자 입출고 현황");
			dateLedger.addProductInLedge(tmp);
			System.out.println(printDate(dateLedger.getDate()) +" 일자의 "+tmp.getName()+" 품목 입출고 현황이 작성되었습니다.");
			return true;
			
		}else {
			System.out.println("해당 품목의 일지 대장이 이미 있습니다. 수정으로 고쳐주십시오.");
			return false;
			}
	}else { // 일자가 없을 때
		
		ProductLedger dateLedger = new ProductLedger(tmpDate);
		
		System.out.println(tmp.getName()+"의 "+ printDate(dateLedger.getDate()) + " 일자 입출고 현황");
		dateLedger.addProductInLedge(tmp);
		System.out.println(printDate(dateLedger.getDate()) +" 일자의 "+tmp.getName()+" 품목 입출고 현황이 작성되었습니다.");
		return true;
	}
	}
	
		
	
	public boolean editInOutProduct() {
		System.out.println("입고할 물품 검색");
		Product tmp = scanPdct();
		int index = productList.indexOf(tmp);
		if(index==-1) {
			System.out.println("존재하지 않는 제품입니다.");
			return false; 
		}else {
			tmp = productList.get(index);
		}
		System.out.println("수정할 일지 날짜를 입력합니다.");
		Date tmpDate = scanDate();

		int ledgerIndex = findLedgerByDate(tmpDate);
		
		if(ledgerIndex!=-1) { // 일자가 있을 때 
			ProductLedger dateLedger=pldList.get(ledgerIndex);
			int productIndex = dateLedger.findProductInLedge(tmp);
			if(productIndex==-1) { // 해당 품목의 출고대장이 없을때.
				System.out.println("해당 일자의 일지가 없습니다. 기입 메뉴로 작성해주십시오.");
				return false;
				
			}else {
				System.out.println(tmp.getName()+"의 "+ printDate(dateLedger.getDate()) + " 일자 입출고 현황");
				dateLedger.editProductInLedge(tmp, productIndex);
				System.out.println(printDate(dateLedger.getDate()) +" 일자의 "+tmp.getName()+" 품목 입출고 현황이 작성되었습니다.");
				return true;
				}
		}else { // 일자가 없을 때
			System.out.println("해당 일자의 일지가 없습니다. 기입 메뉴로 작성해주십시오.");
			return false;
		}
		
	
	
		
	}
	
	
	public void printCalculator(int sw) {
		Date tmp; 
		switch(sw) {
		case 1:
			tmp  = scanDate();
			printLedgerByDay(tmp);
			break;
		case 2:
			tmp  = scanDate();
			printLedgerByMonth(tmp);
			break;
		case 3:
			tmp  = scanDate();
			printLedgerByYear(tmp);
			break;
			
		}
		
	}
	
	public int findLedgerByDate(Date tmpDate) {
		int ledgerIndex = -1;
		for(ProductLedger tmpLedger : pldList) {
			if(tmpLedger.getDate().equals(tmpDate)) {
				ledgerIndex = pldList.indexOf(tmpLedger);
				break;
			}
		}
		return ledgerIndex;
	}
	
	public void printLedgerByDay(Date date) { // 일자 입력하면 당일의 구매, 지출, 총매출액 프린트
		int index = findLedgerByDate(date);
		if(index==-1) {
			System.out.println("해당 일자가 없습니다.");
			return;
		}
		ProductLedger tmpPL= pldList.get(index);
		tmpPL.printCal();
		tmpPL.printCalRst();
	}
	
	public void printLedgerByMonth(Date date) {
		pldList.stream().filter(p->p.getDate().getYear()==date.getYear()&&p.getDate().getMonth()==date.getMonth())
			.forEach(p->{p.printCal();
						p.printCalRst();});	
			
		}
	public void printLedgerByYear(Date date) {
		pldList.stream().filter(p->p.getDate().getYear()==date.getYear())
			.forEach(p->{p.printCal();
						p.printCalRst();});	
			
		}
	
}
