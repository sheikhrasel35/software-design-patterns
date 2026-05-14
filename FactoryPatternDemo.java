/**
 * Step 1: Create an interface.
 * This common interface will be implemented by all concrete classes.
 */
interface Shape {
    void draw();
}

/**
 * Step 2: Create concrete classes implementing the same interface.
 * Here we define Rectangle, Square, and Circle classes.
 */
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

/**
 * Step 3: Create a Factory class to generate objects of concrete classes.
 * This class handles the logic of object creation based on the input.
 */
class ShapeFactory {
    // This method returns the appropriate Shape object based on shapeType
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        
        // Use equalsIgnoreCase to avoid case sensitivity issues
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        
        return null;
    }
}

/**
 * Step 4: Use the Factory to get an object of a concrete class.
 * This is the main demo class that passes information to get the desired object.
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // 1. Get a Circle object and call its draw method
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        if(shape1 != null) shape1.draw();

        // 2. Get a Rectangle object and call its draw method
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        if(shape2 != null) shape2.draw();

        // 3. Get a Square object and call its draw method
        Shape shape3 = shapeFactory.getShape("SQUARE");
        if(shape3 != null) shape3.draw();
    }
}