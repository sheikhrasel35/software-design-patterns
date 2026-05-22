// 1. Abstract Class Animal
abstract class Animal implements Cloneable {
    protected int numberOfLegs = 0;
    protected String description = "";
    protected String name = "";

    public abstract String helloAnimal();

    // method clone
    public Animal clone() {
        Animal clonedAnimal = null;
        try {
            clonedAnimal = (Animal) super.clone();
            clonedAnimal.setName(name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedAnimal;
    } // // method clone

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} // // class Animal


// 2. Chicken Class
class chicken extends Animal {
    private int numberOfClones = 0;

    // // helloAnimal
    public String helloAnimal() {
        StringBuffer chickenTalk = new StringBuffer();
        chickenTalk.append("cluck cluck world. I am ");
        chickenTalk.append(name);
        return chickenTalk.toString().toLowerCase(); // tostring() match from slide output
    } // // helloAnimal

    // // method clone
    public chicken clone() {
        chicken clonedChicken = (chicken) super.clone();
        String chickenName = clonedChicken.getName();
        numberOfClones++;
        clonedChicken.setName(chickenName + numberOfClones);
        return clonedChicken;
    } // // method clone
}


// 3. Sheep Class
class sheep extends Animal {
    private int numberOfClones = 0;

    // // helloAnimal
    public String helloAnimal() {
        StringBuffer sheepTalk = new StringBuffer();
        sheepTalk.append("Meeeeeee world. I am ");
        sheepTalk.append(name);
        return sheepTalk.toString();
    } // // helloAnimal

    // // method clone
    public sheep clone() {
        sheep clonedSheep = (sheep) super.clone();
        String sheepName = clonedSheep.getName();
        numberOfClones++;
        clonedSheep.setName(sheepName + numberOfClones);
        return clonedSheep;
    } // // method clone
}


// 4. AnimalCreator Class
class AnimalCreator {
    private Animal sheep = new sheep();
    private Animal chicken = new chicken();

    // // no-arg constructor
    public AnimalCreator() {
        sheep.setName("sheep");
        chicken.setName("chicken");
    } // // no-arg constructor

    // // method retrieveAnimal
    public Animal retrieveAnimal(String kindOfAnimal) {
        if ("chicken".equals(kindOfAnimal)) {
            return chicken.clone();
        } else if ("sheep".equals(kindOfAnimal)) {
            return sheep.clone();
        } // // if
        return null;
    } // // method retrieveAnimal
} // // class AnimalCreator


// 5. Main Client Class
public class Animalclient {
    // // main method
    public static void main(String[] args) {
        AnimalCreator animalcreator = new AnimalCreator();
        Animal[] animalFarm = new Animal[8];

        animalFarm[0] = animalcreator.retrieveAnimal("chicken");
        animalFarm[1] = animalcreator.retrieveAnimal("chicken");
        animalFarm[2] = animalcreator.retrieveAnimal("chicken");
        animalFarm[3] = animalcreator.retrieveAnimal("chicken");
        animalFarm[4] = animalcreator.retrieveAnimal("sheep");
        animalFarm[5] = animalcreator.retrieveAnimal("sheep");
        animalFarm[6] = animalcreator.retrieveAnimal("sheep");
        animalFarm[7] = animalcreator.retrieveAnimal("sheep");

        // // for
        for (int i = 0; i <= 7; i++) {
            System.out.println(animalFarm[i].helloAnimal());
        } 
    } 
} 