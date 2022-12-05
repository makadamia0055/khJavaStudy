package example.shopping;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImp implements ProductService{

	@Override
	public boolean insertProduct(List<Product> productList, Product product) {
		if(product==null||productList==null) // 매개변수 예외체크
			return false;
		if(productList.contains(product)) { // 이미 등록된 제품인지 확인
			return false;
		}
		productList.add(product); // 제품 등록
		return true;
	}

	@Override
	public boolean updateProduct(List<Product> productList, int index, Product product){
		if(productList==null || productList.size()==0 || index<0|| product==null )
			return false;
		
			
		productList.set(index, product);
		return true;
	}

	@Override
	public boolean deleteProduct(List<Product> productList, Product product) {
		//매개변수 예외 체크
		if(productList==null||productList.size()==0||product==null)
		return false;
		
		return productList.remove(product);
	}

	@Override
	public Product getProduct(List<Product> productList, int index) {
		//매개변수 예외 체크
		if(productList==null||index<0||productList.size()<=index)
			return null;
		return productList.get(index);
	}

	@Override
	public boolean productStock(Product product, int amount) {
				if(amount< 0 && product.getAmount() < -amount) {
					System.out.println("재고량이 부족합니다.");
					return false;
				}
				product.addAmount(amount);
				return true;
	}

	@Override
	public Product inputProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("분류 : ");
		String type = scan.nextLine();
		System.out.println("제품명 : ");
		String title = scan.nextLine();
		System.out.println("구매가 : ");
		int buyPrice = scan.nextInt();
		System.out.println("판매가 : ");
		int sellPrice = scan.nextInt();
		if(buyPrice>sellPrice)
			return null;
		return new Product(type, title, buyPrice, sellPrice);
	}

	@Override
	public Product getProduct(List<Product> productList, Product product) {
		int index = productList.indexOf(product);
		if(index<0)
			return null;
		
		return productList.get(index);
	}

}
