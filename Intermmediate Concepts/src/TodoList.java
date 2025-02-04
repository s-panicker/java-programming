import java.util.ArrayList;
import java.util.Scanner;
public class TodoList {
    private ArrayList<String> tasks;

    // Constructor to initialize tasks list
    public TodoList() {
        tasks = new ArrayList<>();
}
    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to remove a task by index
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            System.out.println("Task removed: " + tasks.get(index));
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }