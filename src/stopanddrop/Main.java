package stopanddrop;

import java.util.Map;
import java.util.Scanner;

public class Main {
	private static StockList stockList = new StockList();
	private static Basket customerBasket;
	private static Scanner scanner = new Scanner(System.in);
	private static boolean employee = false;
	private static boolean lockout = false;
	
	public static void main(String[] args) {

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
	
//		for(String s: stockList.Items().keySet()) {
//			System.out.println(s);
//		}
		
//		System.out.println();
//		Basket batmansBasket = new Basket("Bruce Wayne");
//		addToBasket(batmansBasket, "AR-15", 25);
//		
//		addToBasket(batmansBasket, "Batarang", 100);
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
		
//		temp = new StockItem("Polybius", 567.32);
//		stockList.Items().put(temp.getName(), temp);
		
//		stockList.Items().get("Car").adjustStock(2000);
//		stockList.get("Car").adjustStock(-1000);
//		System.out.println(stockList);
//		for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//			System.out.println(price.getKey() + " costs " + price.getValue());
//		}
		
		System.out.println("Welcome to 🛍 Stop and Drop Online!\n");
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		customerBasket = new Basket(name);
		System.out.println("Hello " + customerBasket.getName() + "!");
		mainMenu();
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
				System.out.println(customerBasket);
				break;
			case 2:
				System.out.println("Under Construction");
				break;
			case 3:
				System.out.println(stockList);
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
        System.out.println("\t 1 - To view all stock items");
        System.out.println("\t 2 - To add to stock");
        System.out.println("\t 3 - To update stock item quantity");
        System.out.println("\t 4 - To remove item from stock");
        System.out.println("\t 5 - To go back to main");
        System.out.println();
	}
	
	public static void stockMenu() {
		boolean back = false;
		if(employee) {
			System.out.println("Welcome Stop and Drop Employee");
			printStockInstructions();
			while (!back) {
				System.out.println("Enter your choice:");
				int choice = scanner.nextInt();
				switch (choice) {
				case 0:
					printMainInstructions();
					break;
				case 1:
					System.out.println(stockList);
					break;
				case 2:
					addToStock();
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
			if(!lockout) {
				boolean entrance = login("Succulent");
				if(entrance) {
					employee = true;
					stockMenu();
				} else {
					System.out.println("You have been locked out");
				}				
			} else {
				System.out.println("You cannot access this page. EVER!");
			}
			mainMenu();
		}
	}
	
	public static void printBasketItemInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To add to basket");
        System.out.println("\t 2 - To update quantity of item");
        System.out.println("\t 3 - To remove from basket");
        System.out.println("\t 4 - To go back to basket");
        System.out.println();
	}
	
	public static void basketMenu() {
		boolean back = false;
		printBasketInstructions();
		while (!back) {
			
		}
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
		int lockoutCount = 5;
		scanner.nextLine();
		while (lockoutCount > 0) {
			System.out.println("Enter employee password");
			String entry = scanner.nextLine();
			if(entry.equals(password)) {
				return true;
			} else {
				lockoutCount--;
				System.out.println("Invalid: " + lockoutCount + " loging attempts remaining\n");
			}
		}
		lockout = true;
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
	
	public static void addToStock() {
		scanner.nextLine();
		System.out.println("Enter the item name to add:");
		String name = scanner.nextLine();
		String nameConverted = name.toUpperCase().replaceAll(" ", "_");
		if(!stockList.Items().containsKey(nameConverted)) {
			// Set Price
			double price = -0.01;
			while(price < 0.00) {
				System.out.println("Enter the price of the item");
				price = scanner.nextDouble();
				if(price < 0.00) {
					System.out.println("Cannot have a price less than zero");
				}
			}
			// Set quantity
			int quantity = 0;
			while (quantity < 1) {
				System.out.println("Enter the quantity for " + name);
				quantity = scanner.nextInt();
				if(quantity < 1) {
					System.out.println("Cannot have a quantity less than 1");
				}
			}
			
			StockItem temp = new StockItem(nameConverted, price, quantity);
			stockList.addStock(temp);
		} else {
			System.out.println(name + " is already in stock.");
			System.out.println(stockList.get(nameConverted));
			boolean valid = false;
			while (!valid) {
				System.out.println("Do you want to update " + name + "? (Y/N)");
				String answer = scanner.nextLine();
				if(answer.toUpperCase().equals("Y")) {
					System.out.println("Update Under Construction");
					valid = true;
				} else if (answer.toUpperCase().equals("N")){
					System.out.println("Back to stock menu");
					valid = true;
				} else {
					System.out.println("Not a valid entry");
				}
			}

		}
	}

}
