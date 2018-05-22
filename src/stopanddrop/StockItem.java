package stopanddrop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockItem implements Comparable<StockItem> {

	private final String name;
	private double price;
	private int quanityStock = 0; // can be initialized later
	private Map<String, Integer> reserved;
	
	public StockItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quanityStock = 0; // or here (doesn't make sense to do both, best do it in here).
		this.reserved = new HashMap<>();
	}
	
	public StockItem(String name, double price, int quanityStock) {
		super();
		this.name = name;
		this.price = price;
		this.quanityStock = quanityStock;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public Map<String, Integer> getReserved() {
		return Collections.unmodifiableMap(reserved);
	}
	
	public void emptyReserve() {
		reserved.clear();
	}

	public void setPrice(double price) {
		if(price > 0.0) {
			this.price = price;
		} else {
			System.out.println("No free shit allowed");
		}
	}
	
	public void adjustStock(int quanity) {
		int newQuantity = this.quanityStock + quanity;
		if(newQuantity >= 0) {
			this.quanityStock = newQuantity;
		}
	}

	public int quantityInStock() {
		return quanityStock;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 69;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Entering StockItem.equals");
		if(obj == this) {
			return true;
		}
		
		if(obj == null || (obj.getClass() != this.getClass())) {
			return false;
		}
		
		String objName = ((StockItem) obj).getName();
		return this.name.equals(objName);
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " - Price: " + String.format("%.2f", this.price);
	}

	@Override
	public int compareTo(StockItem o) {
		if(this == o) {
			return 0;
		}
		
		if(o != null) {
			return this.name.compareTo(o.getName());
		}
		
		throw new NullPointerException();
	}

}