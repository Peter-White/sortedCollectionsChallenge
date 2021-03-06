package stopanddrop;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
	private final Map<String, StockItem> list;

	public StockList() {
		super();
		this.list = new LinkedHashMap<>();
	}
	
	public int addStock(StockItem item) {
		if(item != null) {
			// check if we already have quantities of this item
			StockItem inStockItem = list.getOrDefault(item.getName(), item);
			// If there are already stocks of this item, adjust the quantity
			if(inStockItem != item) {
				item.adjustStock(inStockItem.quantityInStock());
			}
			
			list.put(item.getName(), item);
			System.out.println(item.getName() + " added to stock");
			return item.quantityInStock();
		}
		return 0;
	}
	
	public boolean deleteItem(StockItem item) {
		list.remove(item.getName());
		return true;
	}
	
	public double sellStock(Basket basket, String item) {
		StockItem inStockItem = list.getOrDefault(item, null);
		
		if(inStockItem != null) {
			int quantity = inStockItem.sellItem(basket);
			double cost = quantity * inStockItem.getPrice();
			return cost;
		}
		return 0;
	}
	
	public StockItem get(String key) {
		return list.get(key);
	}

	public Map<String, Double> PriceList() {
		Map<String, Double> prices = new LinkedHashMap<>();
		for(Map.Entry<String, StockItem> item : list.entrySet()) {
			prices.put(item.getKey(), item.getValue().getPrice());
		}
		return Collections.unmodifiableMap(prices);
	}
	
	public Map<String, StockItem> Items() {
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for(Map.Entry<String, StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();
			
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			
			s = s + stockItem + ". There are " + stockItem.quantityInStock() 
			+ " in stock. Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n";
			totalCost += itemValue;
		}
		
		return s + "Total stock value " + String.format("%.2f", totalCost);
	}
}
