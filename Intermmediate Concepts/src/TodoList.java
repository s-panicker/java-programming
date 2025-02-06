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

    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ". " + tasks.get(i));
            }
        }
    }
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TodoList todoList = new TodoList();

            boolean exit = false;

            while (!exit) {
                System.out.println("\n1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. View Tasks");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline left by nextInt()

                switch (choice) {
                    case 1:
                        System.out.print("Enter task to add: ");
                        String task = scanner.nextLine();
                        todoList.addTask(task);
                        break;
                    case 2:
                        todoList.displayTasks();
                        System.out.print("Enter task number to remove: ");
                        int index = scanner.nextInt() - 1; // Convert to 0-based index
                        todoList.removeTask(index);
                        break;
                    case 3:
                        todoList.displayTasks();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();
        }
    }
}
