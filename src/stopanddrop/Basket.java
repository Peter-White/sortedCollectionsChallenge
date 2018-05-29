package stopanddrop;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
	private final String name;
	private final Map<StockItem, Integer> list;
	
	public Basket(String name) {
		super();
		this.name = name;
		this.list = new TreeMap<>();
	}
	
	public int addToBasket(StockItem item, int quantity) {
		if((item != null) && (quantity > 0)) {
			int inBasket = list.getOrDefault(item, 0);
			list.put(item, inBasket + quantity);
			return inBasket;
		}
		return 0;
	}
	
	public String getName() {
		return name;
	}

	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(list);
	}
	
	public boolean removeItem(StockItem stockItem) {
		if(stockItem != null) {
			if(stockItem.removeFromReserve(this)) {
				list.remove(stockItem);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		String items = (list.size() != 1) ? "items" : "item";
		String s = "\nShopping basket of " + name + " contains " + list.size() + " "+ items + "\n";
		
		//Another way of doing it
//		String s = "\nShopping basket of " + name + " contains " + list.size() + " " + ((list.size() == 1) ? "item" : "items") + " " + "\n";
		
		double totalCost = 0.0;
		for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
			
			s = s + item.getKey() + ". " + item.getValue() + " added\n";
			totalCost += item.getKey().getPrice() * item.getValue();
		}
		
		return s + "Total cost " + String.format("%.2f", totalCost);
	}
}
