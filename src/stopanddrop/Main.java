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

		StockItem temp = new StockItem("BREAD", 0.86, 100);
		stockList.addStock(temp);
		
		temp = new StockItem("CAR", 12.50, 20);
		stockList.addStock(temp);
		
		temp = new StockItem("BATARANG", 3.10, 500);
		stockList.addStock(temp);
		
		temp = new StockItem("PIPE_WEED", 30.25, 90);
		stockList.addStock(temp);
		
		temp = new StockItem("SWEET_ROLL", 1.00, 359);
		stockList.addStock(temp);
		
		temp = new StockItem("MUSCLE_MILK", 99.99, 35);
		stockList.addStock(temp);
		
		temp = new StockItem("PIZZA_ROLL", 9.45, 700);
		stockList.addStock(temp);
		
		temp = new StockItem("TIDEPODS", 39.99, 468);
		stockList.addStock(temp);
		
		temp = new StockItem("NUKACOLA", 3.99, 635);
		stockList.addStock(temp);
		
		temp = new StockItem("HEALING_HERB", 25.99, 185);
		stockList.addStock(temp);
	
		stockList.get("HEALING_HERB").setPrice(30.00);
		System.out.println(stockList.get("HEALING_HERB"));
//		for(String s: stockList.Items().keySet()) {
//			System.out.println(s);
//		}
		
//		System.out.println();
//		Basket batmansBasket = new Basket("Bruce Wayne");
//		addToBasket(customerBasket, "AR-15", 25);
//		
//		addToBasket(customerBasket, "Batarang", 100);
//		
//		addToBasket(customerBasket, "Pizza Rolls", 700);
//		
//		addToBasket(customerBasket, "Healing Herb", 700);
//		
//		addToBasket(customerBasket, "Muscle Milk", 30);
//		
//		addToBasket(customerBasket, "Batarang", 100);
//		
//		addToBasket(customerBasket, "Rubber Nipple", 2);
//		
//		addToBasket(customerBasket, "Tidepods", 360);
		
//		temp = new StockItem("Polybius", 567.32);
//		stockList.Items().put(temp.getName(), temp);
		
//		stockList.Items().get("Car").adjustStock(2000);
//		stockList.get("Car").adjustStock(-1000);
//		System.out.println(stockList);
//		for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//			System.out.println(price.getKey() + " costs " + price.getValue());
//		}
		
		System.out.println("Enter your name:");
		String name = scanner.nextLine();
		customerBasket = new Basket(name);
		System.out.println("\nHello " + customerBasket.getName() + "!\n");
		mainMenu();
	}
	// Main menu
	public static void printMainInstructions() {
		System.out.println("Welcome to 🛍 Stop and Drop Online!");
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view your basket items");
        System.out.println("\t 2 - To open your basket");
        System.out.println("\t 3 - To view stock items");
        System.out.println("\t 4 - To open stock item menu (Employees Only)");
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
	
	// Basket menu and options
	public static void printBasketInstructions() {
		System.out.println("Your 🛍 Stop and Drop! Basket");
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options");
        System.out.println("\t 1 - To view all items in your basket");
        System.out.println("\t 2 - To view all stock items");
        System.out.println("\t 3 - To add to basket");
        System.out.println("\t 4 - To update quantity of an item");
        System.out.println("\t 5 - To remove an item from basket");
        System.out.println("\t 6 - To checkout");
        System.out.println("\t 7 - To go back to basket");
	}
	
	public static void basketMenu() {
		boolean back = false;
		printBasketInstructions();
		while (!back) {
			System.out.println("\nEnter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 0:
				printBasketInstructions();
				break;
			case 1:
				System.out.println(customerBasket);
				break;
			case 2:
				System.out.println(stockList);
				break;
			case 3:
				addToBasket(customerBasket);
				break;
			case 4:
				System.out.println("Under Construction");
				break;
			case 5:
				removeFromBasket();
				break;
			case 6:
				double sumTotal = checkout(customerBasket);
				System.out.println("Your total is " + sumTotal);
				System.out.println("Please be sure to take your receipt");
				break;
			case 7:
				System.out.println("Back to main");
				back = true;
				break;
			default:
				break;
			}
		}
	}
	
	public static int addToBasket(Basket basket) {
		scanner.nextLine();
		System.out.println("\nEnter item from the stock list to add to your basket:");
		String item = scanner.nextLine();
		
		int quantity = 0;
		
		StockItem stockItem = stockList.get(nameCapitalized(item));
		
		if(stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if(basket.Items().containsKey(stockItem)) {
			boolean valid = false;
			while (!valid) {
				System.out.println(item + " is already in your basket with a quantity of " + basket.Items().get(stockItem));
				System.out.println("Would you like to add to the existing quantity? (Y/N):");
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
			System.out.println("Enter quantity of item. You can use negative numbers to substract from your cart:");
			int newQuantity = scanner.nextInt();
			
			quantity += newQuantity;
			
			if(stockItem.quantityInStock() >= quantity) {
				if(quantity > 0) {
					System.out.println(quantity + " " + ((quantity == 1) ? 
					stockItem.getName() : stockItem.getName() + "s") + 
					" has been added to the basket");
					basket.addToBasket(stockItem, quantity);
					stockItem.addToReserve(customerBasket, quantity);
					
					return quantity;
				} else if (quantity == 0) {
					boolean choice = false;
					while (!choice) {
						System.out.println("Your quantity is zero. Do you wish to remove this item from cart? (Y/N):");
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
	
	public static void removeFromBasket() {
		scanner.nextLine();
		System.out.println("Enter name of the item to remove:");
		String name = scanner.nextLine();
		
		name = nameCapitalized(name);
		StockItem item = stockList.get(name);

		if(customerBasket.Items().containsKey(item)) {
			removeFromBasket(item);
		} else {
			System.out.println("This item is not your basket");
		}
	}
	
	public static void removeFromBasket(StockItem item) {
		boolean valid = false;
		while (!valid) {
			System.out.println("Are you sure you want to remove " + item.getName() + 
					" from your basket? (Y/N):");
			String answer = scanner.nextLine();
			if(answer.toUpperCase().equals("Y")) {
				if(customerBasket.removeItem(item)) {
					System.out.println(item.getName() + " has been removed from stock");
				} else {
					System.out.println("Item not deleted");
				}
				valid = true;
			} else if (answer.toUpperCase().equals("N")){
				valid = true;
			} else {
				System.out.println("Not a valid entry");
			}
		}
		System.out.println("Back to basket");
	}
	
	public static double checkout(Basket basket) {
		double total = 0.00;
		// retrieve the item from stock list
		for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
			double cost = stockList.sellStock(basket, item.getKey().getName());
			total += cost;
			basket.removeItem(item.getKey());
		}
		
		return total;
	}
	
	// Stock menu and options
	public static void printStockInstructions() {
		System.out.println("\n🛍 Stop and Drop! Item Stock.");
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
					// Add stock thing here
					break;
				case 4:
					removeFromStock();
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
	
	public static void removeFromStock() {
		scanner.nextLine();
		System.out.println("Enter the item to be removed:");
		String name = scanner.nextLine();
		
		name = nameCapitalized(name);
		
		if(stockList.get(name) != null) {
			removeFromStock(stockList.get(name));
		} else {
			System.out.println("Item is not in stock");
		}
	}
	
	// Stock menu and options
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
			printStockItemMenu(item.getName());
			while (!back) {
				System.out.println("\nEnter your choice:");
				int choice = scanner.nextInt();
				switch (choice) {
				case 0:
					printStockItemMenu(item.getName());
					break;
				case 1:
					System.out.println(item.getName());
					break;
				case 2:
					System.out.println("Under Construction");
					break;
				case 3:
					System.out.println("Under Construction");
					break;
				case 4:
					removeFromStock(item);
					break;
				case 5:
					System.out.println("Back to stock menu");
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
			System.out.println("\nEnter employee password:");
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
	
	public static void setNewPrice(StockItem item) {
		System.out.println("Enter the new price for " + item.getName() + ":");
		double price = scanner.nextDouble();
		
		stockList.get(item.getName()).setPrice(price);
	}
	
	public static void removeFromStock(StockItem item) {
		scanner.nextLine();
		boolean valid = false;
		while (!valid) {
			System.out.println("Are you sure you want to remove " + item.getName() + 
					" from stock? (Y/N):");
			String answer = scanner.nextLine();
			if(answer.toUpperCase().equals("Y")) {
				if(stockList.deleteItem(item)) {
					System.out.println(item.getName() + " has been removed from stock");
				} else {
					System.out.println("Item not deleted");
				}
				valid = true;
			} else if (answer.toUpperCase().equals("N")){
				valid = true;
			} else {
				System.out.println("Not a valid entry");
			}
		}
		System.out.println("Back to stock");
	}
	
	public static void addToStock() {
		scanner.nextLine();
		System.out.println("\nEnter the item name to add:");
		String name = scanner.nextLine();
		String nameConverted = nameCapitalized(name);
		if(!stockList.Items().containsKey(nameConverted)) {
			// Set Price
			double price = -0.01;
			while(price < 0.00) {
				System.out.println("\nEnter the price of the item:");
				price = scanner.nextDouble();
				if(price < 0.00) {
					System.out.println("Cannot have a price less than zero");
				}
			}
			// Set quantity
			int quantity = 0;
			while (quantity < 1) {
				System.out.println("\nEnter the quantity for " + name + ":");
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
				System.out.println("Do you want to update " + name + "? (Y/N):");
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
	
	// Items in stock are capitalized and contain underscores rather than spaces
	public static String nameCapitalized(String name) {
		return name.toUpperCase().replaceAll(" ", "_");
	}
}
