package stopanddrop;

import java.util.Map;
import java.util.Scanner;

public class Main {
	private static StockList stockList = new StockList();
	private static Scanner scanner = new Scanner(System.in);
	private static boolean employee = false;
	
	public static void main(String[] args) {
		System.out.println("Welcome to 🛍 Stop and Drop Online!");
		mainMenu();
//		StockItem temp = new StockItem("Bread", 0.86, 100);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Car", 12.50, 20);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Batarang", 3.10, 500);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Pipe Weed", 30.25, 90);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("AR-15", 300.00, 43);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Sweet Roll", 1.00, 359);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Muscle Milk", 99.99, 35);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Pizza Rolls", 9.45, 700);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Tidepods", 39.99, 468);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Nukacola", 3.99, 635);
//		stockList.addStock(temp);
//		
//		temp = new StockItem("Healing Herb", 25.99, 185);
//		stockList.addStock(temp);
//		
//		System.out.println(stockList);
//	
////		for(String s: stockList.Items().keySet()) {
////			System.out.println(s);
////		}
//		
//		System.out.println();
//		Basket batmansBasket = new Basket("Bruce Wayne");
//		addToBasket(batmansBasket, "AR-15", 25);
//		
//		addToBasket(batmansBasket, "Batarang", 100);
//		
////		addToBasket(batmansBasket, "An Ending That Doesn't Suck", 1);
//		
//		addToBasket(batmansBasket, "Pizza Rolls", 700);
//		
//		addToBasket(batmansBasket, "Healing Herb", 700);
//		
//		addToBasket(batmansBasket, "Muscle Milk", 30);
//		
//		addToBasket(batmansBasket, "Batarang", 100);
//		
//		addToBasket(batmansBasket, "Rubber Nipple", 2);
//		
//		addToBasket(batmansBasket, "Tidepods", 360);
//		
//		System.out.println();
//		
//		System.out.println(batmansBasket);
//		
//		System.out.println();
//		
//		checkout(batmansBasket);
//		
//		System.out.println();
//		
//		System.out.println(stockList);
		
//		temp = new StockItem("Polybius", 567.32);
//		stockList.Items().put(temp.getName(), temp);
		
//		stockList.Items().get("Car").adjustStock(2000);
//		stockList.get("Car").adjustStock(-1000);
//		System.out.println(stockList);
//		for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//			System.out.println(price.getKey() + " costs " + price.getValue());
//		}
	}
	
	public static void printMainInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view your basket items");
        System.out.println("\t 2 - To open your basket");
        System.out.println("\t 3 - To view stock items");
        System.out.println("\t 4 - To open stock item menu");
        System.out.println("\t 5 - To quit the application.");
        System.out.println();
	}
	
	public static void mainMenu() {
		boolean on = true;
		printMainInstructions();
		while (on) {
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 0:
				printMainInstructions();
				break;
			case 1:
				System.out.println("Under Construction");
				break;
			case 2:
				System.out.println("Under Construction");
				break;
			case 3:
				System.out.println("Under Construction");
				break;
			case 4:
				stockMenu();
				break;
			case 5:
				System.out.println("Thank you for reluctantly giving your hard earned money to");
				System.out.println("🛍 Stop and Drop!");
				on = false;
				break;
			default:
				break;
			}
		}
	}
	
	public static void printStockInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view your basket items");
        System.out.println("\t 2 - To open your basket");
        System.out.println("\t 3 - To view stock items");
        System.out.println("\t 4 - To open stock item menu");
        System.out.println("\t 5 - To go back to main");
        System.out.println();
	}
	
	public static void stockMenu() {
		if(employee) {
			System.out.println("Welcome Stop and Drop Employee");
			boolean back = false;
			printStockInstructions();
			while (!back) {
				System.out.println("Enter your choice:");
				int choice = scanner.nextInt();
				switch (choice) {
				case 0:
					printMainInstructions();
					break;
				case 1:
					System.out.println("Under Construction");
					break;
				case 2:
					System.out.println("Under Construction");
					break;
				case 3:
					System.out.println("Under Construction");
					break;
				case 4:
					System.out.println("Under Construction");
					break;
				case 5:
					System.out.println("Back to main");
					back = true;
					break;
				default:
					break;
				}
			}
		} else {
			boolean entrance = login("Succulent");
			if(entrance) {
				employee = true;
				stockMenu();
			} else {
				
			}
		}
	}
	
	public static void printBasketItemInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To update quantity");
        System.out.println("\t 2 - To remove from basket");
        System.out.println("\t 5 - To go back to basket");
        System.out.println();
	}
	
	public static void printStockItemMenu() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view your basket items");
        System.out.println("\t 2 - To open your basket");
        System.out.println("\t 3 - To view stock items");
        System.out.println("\t 4 - To open stock item menu");
        System.out.println("\t 5 - To quit the application.");
        System.out.println();
	}
	
	public static void printBasketInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view your basket items");
        System.out.println("\t 2 - To open your basket");
        System.out.println("\t 3 - To view stock items");
        System.out.println("\t 4 - To open stock item menu");
        System.out.println("\t 5 - To quit the application.");
        System.out.println();
	}
	
	public static boolean login(String password) {
		int lockout = 5;
		while (lockout > 0) {
			System.out.println("Enter employee password");
			scanner.nextLine();
			String entry = scanner.nextLine();
			if(entry.equals(password)) {
				return true;
			} else {
				System.out.println("Invalid");
			}
		}
		return false;
	}
	
	public static int addToBasket(Basket basket, String item, int quantity) {
		StockItem stockItem = stockList.get(item);
		
		if(stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if(basket.Items().containsKey(stockItem)) {
			System.out.println(item + " is already in your basket");
		}
		
		if(stockItem.quantityInStock() >= quantity) {
			if(quantity > 0) {
				System.out.println(quantity + " " + ((quantity == 1) ? 
				stockItem.getName() : stockItem.getName() + "s") + 
				" has been added to the basket");
				basket.addToBasket(stockItem, quantity);
				return quantity;
			} else {
				System.out.println("Cannot add less than 1 item");
				return 0;
			}

		} else {
			System.out.println("There is not enough of that item in stock");
			return 0;
		}
	}
	
	public static double checkout(Basket basket) {
		double total = 0.00;
		// retrieve the item from stock list
		for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
			stockList.sellStock(item.getKey().getName(), item.getValue());
			total += (item.getValue() * item.getKey().getPrice());
		}
		
		return total;
	}
}
