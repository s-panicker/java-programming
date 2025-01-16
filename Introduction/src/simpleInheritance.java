public class simpleInheritance {
    // Superclass
    class Animal {
        public void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    // Subclass
    class Dog extends Animal {
        public void sound() {
            System.out.println("Dog barks");
        }
    }

    public class Main {
        public  void main(String[] args) {
            Dog myDog = new Dog();
            myDog.sound();  // Output: Dog barks
        }
    }

}
