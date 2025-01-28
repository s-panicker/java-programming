public class Main {
    public void main(String[] args) {
        System.out.println("Hello, World!");
        Person person1 = new Person();
        person1.setName("Alice");
        person1.setAge(25);

        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
    }

    public class Person {
        private String name;  // Private field
        private int age;      // Private field

        // Getter for name
        public String getName() {
            return name;
        }

        // Setter for name
        public void setName(String name) {
            this.name = name;
        }

        // Getter for age
        public int getAge() {
            return age;
        }

        // Setter for age
        public void setAge(int age) {
            if (age > 0) {
                this.age = age;
            } else {
                System.out.println("Age must be positive!");
            }
        }
    }


}