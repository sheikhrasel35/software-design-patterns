// Step 1: Create a Singleton class
class Logger {
    // Step 2: Create a private static instance of the class
    private static Logger instance; 

    // Step 1: Make the constructor private to prevent instantiation from other classes
    private Logger() { 
        // Initialization code, if needed
    }

    // Step 2: Provide a public static method to get the single instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            // Create a new instance if it doesn't exist
            instance = new Logger(); 
        }
        // Return the existing instance
        return instance; 
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// Step 3: Using the Singleton in the main application
public class SingletonPattern {
    public static void main(String[] args) {
        // Accessing the Singleton instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Using the instance to log messages
        logger1.log("Application started");
        logger2.log("Database connected");

        // Checking if both references point to the same instance
        System.out.println(logger1 == logger2); 
    }
}