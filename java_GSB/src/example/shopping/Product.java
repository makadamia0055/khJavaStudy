package example.shopping;

import lombok.Data;

@Data
public class Product {
	private String type;
	private String title;
	private int amount;
	private int buyPrice;
	private int sellPrice;
	
	public Product(String type, String title, int buyPrice, int sellPrice) {
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public Product(Product pd) {
		this.type = pd.type;
		this.title = pd.title;
		this.amount = pd.amount;
		this.buyPrice = pd.buyPrice;
		this.sellPrice = pd.sellPrice;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}

	@Override
	public String toString() {
		return "[ 분류 : " + type +  " | 제품명: " + title +  " | 수량 : " +  amount +  " | 구매가 : " + buyPrice
				+  " | 판매가 : " +  sellPrice + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	
	
}
