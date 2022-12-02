package day30;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class ProductLedger {
	private ArrayList<ItemInOut> DailyList = new ArrayList<ItemInOut>(); 
	private Date date;
	
	@Data
	class ItemInOut{
		private Product product;
		private int inNum;
		private int outNum;
		
		ItemInOut(Product product, int inNum, int outNum){
			this.product = product;
			this.inNum = inNum;
			this.outNum = outNum;
		}
		ItemInOut(Product product){
			this.product = product;
		}

		private ProductLedger getEnclosingInstance() {
			return ProductLedger.this;
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
			ItemInOut other = (ItemInOut) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
				return false;
			}
			if (product == null) {
				if (other.product != null) {
					return false;
				}
			} else if (!product.equals(other.product)) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((product == null) ? 0 : product.hashCode());
			return result;
		}
	}
	
	ProductLedger(Date date, ArrayList<ItemInOut> list){
		this.date = date;
		this.DailyList = list;
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
		ProductLedger other = (ProductLedger) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	
	
}
