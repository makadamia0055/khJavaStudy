package day30;

import lombok.Data;

@Data
public class Product {
//제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
	private String Sort;
	private String name;
	private int amount;
	private int inPrice;
	private int outPrice;
	
	Product(String Sort, String name, int amount, int inp, int outp){
		this.Sort = Sort;
		this.name = name;
		this.amount = amount;
		this.inPrice = inp;
		this.outPrice = outp;
		
	}
	Product(String sort, String name){
		this.Sort = sort;
		this.name = name;
		
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Sort == null) {
			if (other.Sort != null)
				return false;
		} else if (!Sort.equals(other.Sort))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Sort == null) ? 0 : Sort.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
	
	
	
}
