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

		StockItem temp = new StockItem("Bread", 0.86, 100);
		stockList.addStock(temp);
		
		temp = new StockItem("Car", 12.50, 20);
		stockList.addStock(temp);
		
		temp = new StockItem("Batarang", 3.10, 500);
		stockList.addStock(temp);
		
		temp = new StockItem("Pipe Weed", 30.25, 90);
		stockList.addStock(temp);
		
		temp = new StockItem("AR-15", 300.00, 43);
		stockList.addStock(temp);
		
		temp = new StockItem("Sweet Roll", 1.00, 359);
		stockList.addStock(temp);
		
		temp = new StockItem("Muscle Milk", 99.99, 35);
		stockList.addStock(temp);
		
		temp = new StockItem("Pizza Rolls", 9.45, 700);
		stockList.addStock(temp);
		
		temp = new StockItem("Tidepods", 39.99, 468);
		stockList.addStock(temp);
		
		temp = new StockItem("Nukacola", 3.99, 635);
		stockList.addStock(temp);
		
		temp = new StockItem("Healing Herb", 25.99, 185);
		stockList.addStock(temp);
	
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
		
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		customerBasket = new Basket(name);
		System.out.println("\nHello " + customerBasket.getName() + "!\n");
		mainMenu();
	}
	
	public static void printMainInstructions() {
		System.out.println("Welcome to 🛍 Stop and Drop Online!");
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view your basket items");
        System.out.println("\t 2 - To open your basket");
        System.out.println("\t 3 - To view stock items");
        System.out.println("\t 4 - To open stock item menu");
        System.out.println("\t 5 - To quit the application");
	}
	
	public static void mainMenu() {
		boolean on = true;
		printMainInstructions();
		while (on) {
			System.out.println("\nEnter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 0:
				printMainInstructions();
				break;
			case 1:
				System.out.println(customerBasket);
				break;
			case 2:
				basketMenu();
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
		System.out.println("\n🛍 Stop and Drop! Item Stock. Employees Only.");
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view all stock items");
        System.out.println("\t 2 - To add to stock");
        System.out.println("\t 3 - To view item");
        System.out.println("\t 4 - To remove item from stock");
        System.out.println("\t 5 - To go back to main");
	}
	
	public static void stockMenu() {
		boolean back = false;
		if(employee) {
			System.out.println("\nWelcome 🛍 Stop and Drop! Employee\n");
			printStockInstructions();
			while (!back) {
				System.out.println("\nEnter your choice:");
				int choice = scanner.nextInt();
				switch (choice) {
				case 0:
					printStockInstructions();
					break;
				case 1:
					System.out.println(stockList);
					break;
				case 2:
					addToStock();
					break;
				case 3:
					boolean valid = false;
					while (!valid) {
						scanner.nextLine();
						System.out.println("Enter item name");
						String name = scanner.nextLine();
						if(stockList.Items().containsKey(
								 name.toUpperCase().replaceAll(" ", "_"))) {
							
						}
					}
					
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

	}
	
	public static void printBasketInstructions() {
		System.out.println("Your 🛍 Stop and Drop! Basket");
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To add to basket");
        System.out.println("\t 2 - To update quantity of item");
        System.out.println("\t 3 - To remove from basket");
        System.out.println("\t 4 - To go back to basket");
	}
	
	public static void basketMenu() {
		boolean back = false;
		printBasketInstructions();
		while (!back) {
			System.out.println("\nEnter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 0:
				printBasketItemInstructions();
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
	}
	
	public static void printStockItemMenu(String name) {
		System.out.println("🛍 Stop and Drop! Stock Item " + name);
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view item");
        System.out.println("\t 2 - To change item price");
        System.out.println("\t 3 - To change item quanity");
        System.out.println("\t 4 - To delete item");
        System.out.println("\t 5 - To go back to stock menu");
	}
	
	public static void stockItemMenu(StockItem item) {
		boolean back = false;
		if(employee) {
			printStockInstructions();
			while (!back) {
				System.out.println("\nEnter your choice:");
				int choice = scanner.nextInt();
				switch (choice) {
				case 0:
					printStockItemMenu(item.getName());
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
			System.out.println("You are not an employee. Access Denied.");
		}
	}
	
	public static boolean login(String password) {
		int lockoutCount = 5;
		scanner.nextLine();
		while (lockoutCount > 0) {
			System.out.println("\nEnter employee password");
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
	
	public static int addToBasket(Basket basket) {
		scanner.nextLine();
		System.out.println("\nEnter item from stock list to add to your basket");
		String item = scanner.nextLine();
		
		int quantity = 0;
		
		StockItem stockItem = stockList.get(item.toUpperCase().replaceAll(" ", "_"));
		
		if(stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if(basket.Items().containsKey(stockItem)) {
			boolean valid = false;
			while (!valid) {
				System.out.println(item + " is already in your basket with a quantity of " + basket.Items().get(stockItem));
				System.out.println("Would you like to add change the quantity? (Y/N)");
				String answer = scanner.nextLine();
				if(answer.toUpperCase().equals("Y")) {
					quantity = basket.Items().get(stockItem);
					valid = true;
				} else if (answer.toUpperCase().equals("N")){
					System.out.println("Back to basket");
					return 0;
				} else {
					System.out.println("Not a valid entry");
				}
			}
		}
		
		boolean valid = false;
		while (!valid) {
			System.out.println("Enter quantity of item. You can use negative numbers to substract from your cart.");
			int newQuantity = scanner.nextInt();
			
			quantity += newQuantity;
			
			if(stockItem.quantityInStock() >= quantity) {
				if(quantity > 0) {
					System.out.println(quantity + " " + ((quantity == 1) ? 
					stockItem.getName() : stockItem.getName() + "s") + 
					" has been added to the basket");
					basket.addToBasket(stockItem, quantity);
					return quantity;
				} else if (quantity == 0) {
					boolean choice = false;
					while (!choice) {
						System.out.println("Your quantity is zero. Do you wish to remove this item from cart? (Y/N)");
						String answer = scanner.nextLine();
						if(answer.toUpperCase().equals("Y")) {
							if(basket.removeItem(stockItem)) {
								System.out.println("\n" + stockItem.getName() + " removed");
							}
							valid = true;
						} else if (answer.toUpperCase().equals("N")){
							System.out.println("Back to basket");
						} else {
							System.out.println("Not a valid entry");
						}
					}
				} else {
					System.out.println("You cannot have less than zero quantity");
				}
			} else {
				System.out.println("There is not enough of that item in stock");
			}
		}
		return 0;
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
		System.out.println("\nEnter the item name to add:");
		String name = scanner.nextLine();
		String nameConverted = name.toUpperCase().replaceAll(" ", "_");
		if(!stockList.Items().containsKey(nameConverted)) {
			// Set Price
			double price = -0.01;
			while(price < 0.00) {
				System.out.println("\nEnter the price of the item");
				price = scanner.nextDouble();
				if(price < 0.00) {
					System.out.println("Cannot have a price less than zero");
				}
			}
			// Set quantity
			int quantity = 0;
			while (quantity < 1) {
				System.out.println("\nEnter the quantity for " + name);
				quantity = scanner.nextInt();
				if(quantity < 1) {
					System.out.println("\nCannot have a quantity less than 1");
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
					stockItemMenu(stockList.get(nameConverted));
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
