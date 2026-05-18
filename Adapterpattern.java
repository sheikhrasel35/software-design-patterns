
// 1. Existing System Interfaces & Classes

interface Product {
    String getName();
    double getPrice();
}

// Example classes implementing Product interface
class CosmeticProduct implements Product {
    private String name;
    private double price;

    public CosmeticProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class FitnessProduct implements Product {
    private String name;
    private double price;

    public FitnessProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

// System Inventory that ONLY accepts 'Product' type
class ShopInventory {
    // Added Generics <Product> for type safety
    private List<Product> products;

    public ShopInventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    // Method to display items in inventory
    public void showInventory() {
        System.out.println("--- Shop Inventory Items ---");
        for (Product product : products) {
            System.out.println("Item: " + product.getName() + " | Price: ৳" + product.getPrice());
        }
    }
}

// 2. Third-Party Code (Adaptee) - Incompatible

class GroceryItem {
    private String itemName;
    private int costPerUnit;

    public GroceryItem(String itemName, int costPerUnit) {
        this.itemName = itemName;
        this.costPerUnit = costPerUnit;
    }

    public String getItemName() { return itemName; }
    public int getCostPerUnit() { return costPerUnit; }
}

// 3. The Adapter Class
class GroceryItemAdapter implements Product {
    private GroceryItem groceryItem;

    public GroceryItemAdapter(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    @Override
    public String getName() {
        // Mapping getName() to getItemName()
        return groceryItem.getItemName();
    }

    @Override
    public double getPrice() {
        // Mapping getPrice() to getCostPerUnit()
        return groceryItem.getCostPerUnit();   
    }
}

// 4. Main Client Code

public class Main {
    public static void main(String[] args) {
        ShopInventory inventory = new ShopInventory();

        // Adding regular store products (directly implements Product)
        inventory.addProduct(new CosmeticProduct("Lavie Handbag", 5000.0));
        inventory.addProduct(new FitnessProduct("Yoga SmartFit", 2000.75));

        // Third-party item which doesn't implement Product interface
        GroceryItem groceryItem = new GroceryItem("Wheat Flour", 100);

        // System compatible bananor jonno adapter use kora holo
        inventory.addProduct(new GroceryItemAdapter(groceryItem));     

        // Print the full inventory to verify
        inventory.showInventory();
    }
}