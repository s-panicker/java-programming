import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Add some fruits to the list
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Print all the items in the list
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
