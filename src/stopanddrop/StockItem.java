package stopanddrop;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockItem implements Comparable<StockItem> {

	private final String name;
	private double price;
	private int quanityStock = 0; // can be initialized later
	private Map<Basket, Integer> reserved;
	
	public StockItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quanityStock = 0; // or here (doesn't make sense to do both, best do it in here).
		this.reserved = new LinkedHashMap<>();
	}
	
	public StockItem(String name, double price, int quanityStock) {
		super();
		this.name = name;
		this.price = price;
		this.quanityStock = quanityStock;
		this.reserved = new LinkedHashMap<>();
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public Map<Basket, Integer> getReserved() {
		return Collections.unmodifiableMap(reserved);
	}
	
	public void emptyReserve() {
		reserved.clear();
	}
	
	public void addToReserve(Basket basket, int quantity) {
		reserved.put(basket, quantity);
	}

	public boolean setPrice(double price) {
		if(price >= 0.0) {
			System.out.print(this.price + " is now ");
			this.price = price;
			System.out.println(this.price);
			return true;
		} else {
			System.out.println("Cannot have a price less than zero");
			return false;
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
		return "Name: " + this.name + " - Price: " + 
				String.format("%.2f", this.price) + " - Quantity: " + 
				this.quanityStock;
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
